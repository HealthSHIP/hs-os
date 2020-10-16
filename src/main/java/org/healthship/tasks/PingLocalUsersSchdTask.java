/*
 * Copyright (c) 2020 Ronald MacDonald <ronald@rmacd.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.healthship.tasks;

import org.healthship.exceptions.ApplicationException;
import org.healthship.models.HelpRequest;
import org.healthship.models.User;
import org.healthship.models.UserType;
import org.healthship.models.internal.Ping;
import org.healthship.models.internal.PingType;
import org.healthship.models.internal.RequestType;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.PingRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.*;
import org.hibernate.Hibernate;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile({"gcp", "proxy", "proxy-int", "local"})
public class PingLocalUsersSchdTask {
    private static final Logger logger = LoggerFactory.getLogger(PingLocalUsersSchdTask.class);

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    IEmailService emailService;
    SMSService smsService;
    SlackService slackService;
    PingRepo pingRepo;

    @Autowired
    Environment environment;

    public PingLocalUsersSchdTask(
            HelpRequestRepo helpRequestRepo,
            UserRepository userRepository,
            EmailServiceImpl emailService,
            PingRepo pingRepo,
            SMSService smsService,
            SlackService slackService
    ) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.pingRepo = pingRepo;
        this.smsService = smsService;
        this.slackService = slackService;
    }

    @Scheduled(cron = "0 0,30 * * * *")
    @Transactional
    public void pingLocalUsersNonUrgently() throws ApplicationException {
        Set<HelpRequest> unrepliedRequests = helpRequestRepo.findByVisibleTrueAndSelectedUserIsNullAndDateTimeFromIsAfter(
                // urgent posts are dealt with by a separate task that just pings everyone
                ZonedDateTime.now().plusHours(3)
        );
        for (HelpRequest unrepliedRequest : unrepliedRequests) {
            User nextVolunteerToPing =
                    baseGetNextUser(unrepliedRequest, PingType.email).stream()
                            .filter(User::getEmailUpdates)
                            .filter(s -> !pingRepo  // don't ping same user within 12h
                                    .existsByVolunteerAndPingedDTAfterAndPingType(s, ZonedDateTime.now().minusHours(12), PingType.email)
                            )
                            .min(Comparator.comparing(User::getTransientGeoDistanceMetres)).orElse(null);

            // pass to SMS function if there are no results ...
            if (null == nextVolunteerToPing) {
                pingUsersViaSMS(unrepliedRequest);
                continue;
            }

            // add to db, so we only ping this user once (run before emailing so that we get
            // an exception if there's been a problem saving the ping...)
            if (!Utils.isActive("local", environment)) {
                pingRepo.save(new Ping(unrepliedRequest, nextVolunteerToPing, PingType.email));
            }

            emailService.pingLocalVolunteer(nextVolunteerToPing, unrepliedRequest);
        }
    }

    private Set<User> baseGetNextUser(@NotNull HelpRequest unrepliedRequest, PingType pingType) {
        // rather than hammering the db, just manually select an area by lat/long first
        float offsetDegrees = 0.5f; // ~±55km
        // make sure distance is set
        // remove unsuitable users
        return userRepository.findByUserTypeIsAndLngLessThanAndLatLessThanAndLngGreaterThanAndLatGreaterThan(
                UserType.student,
                unrepliedRequest.getOriginLng() + offsetDegrees, unrepliedRequest.getOriginLat() + offsetDegrees,
                unrepliedRequest.getOriginLng() - offsetDegrees, unrepliedRequest.getOriginLat() - offsetDegrees
        )
                .stream()
                .peek(s -> s.setTransientGeoDistanceMetres(Utils.getDistanceMetres(
                        s.getLng(), s.getLat(),
                        unrepliedRequest.getOriginLng(), unrepliedRequest.getOriginLat()
                )))               // make sure distance is set
                .filter(s -> s.getTransientGeoDistanceMetres() <= s.getNotifyRadius().getMetres())
                .filter(s -> !unrepliedRequest.getRequiresPVG() || s.isPVGVerified())           // remove unsuitable users
                // now start doing more expensive operations ie db lookups
                .filter(s -> !helpRequestRepo                                                   // don't ping the user if they've already responded
                        .existsByIdAndRespondedByContains(unrepliedRequest.getId(), s)
                )
                .filter(s -> !pingRepo // remove if user has already received this ping type
                        .existsByHelpRequestAndVolunteerAndPingType(unrepliedRequest, s, pingType)
                )
                .collect(Collectors.toSet());
    }

    // takes a help request and then texts the next person
    public void pingUsersViaSMS(@NotNull HelpRequest unrepliedRequest) throws ApplicationException {
        // RULES:
        // this will ONLY message people if ALL the following are true:
        // - the request has no responses for help
        // - the volunteer hasn't seen the request before
        // - the volunteer is happy to receive texts

        Hibernate.initialize(unrepliedRequest.getRespondedBy());
        if (!unrepliedRequest.getRespondedBy().isEmpty()) {
            logger.info(String.format(
                    "Responded by is not empty: not sending texts for %s", unrepliedRequest.getId()
            ));
            return;
        }

        if (!unrepliedRequest.getRequestType().equals(RequestType.ad_hoc)) {
            logger.debug("Request {}: not sending SMS (is not an ad-hoc request)", unrepliedRequest.getId());
            return;
        }

        List<User> nextVolunteerList = baseGetNextUser(unrepliedRequest, PingType.sms).stream()
                .filter(User::getSmsUpdates)
                .filter(s -> null != s.getPhone() && !s.getPhone().isEmpty())
                .filter(s -> !pingRepo // don't ping same user within 1hr
                        .existsByVolunteerAndPingedDTAfter(
                                s, ZonedDateTime.now().minusHours(1)
                        )
                )
                .filter(s -> !pingRepo // don't ping if they've been sent txt within 6hrs
                        .existsByVolunteerAndPingedDTAfterAndPingType(
                                s, ZonedDateTime.now().minusHours(6), PingType.sms
                        )

                ).collect(Collectors.toList());

        if (0 == nextVolunteerList.size()) {
            slackService.noMoreUsers(unrepliedRequest);
            return;
        };

        // temporarily filter out users if it's night time for them, return next closest user (if any)
        User nextVolunteerToText = nextVolunteerList.stream()
                .filter(s -> {
                    // only message between 7am and 10pm
                    LocalTime ldt = ZonedDateTime.now().withZoneSameInstant(s.getTimezone()).toLocalTime();
                    return (ldt.isAfter(LocalTime.of(7, 0)) && ldt.isBefore(LocalTime.of(22, 0)));
                })
                .min(Comparator.comparing(User::getTransientGeoDistanceMetres)).orElse(null);

        if (null == nextVolunteerToText) {
            logger.info("Volunteer local time is between 22:00 -- 07:00, will try again later ...");
            return;
        }

        slackService.messagingViaSMS(unrepliedRequest);

        // only SMS this user once
        if (!Utils.isActive("local", environment)) {
            pingRepo.save(new Ping(unrepliedRequest, nextVolunteerToText, PingType.sms));
        }

        smsService.pingLocalVolunteer(nextVolunteerToText, unrepliedRequest);
    }

    @Scheduled(cron = "0 */4 * * * *")
    public void pingLocalUsersUrgently() throws ApplicationException {
        // get all that start within the next 3 hours
        // get all that end within the next 3 hours
        Set<HelpRequest> unrepliedRequests = helpRequestRepo.findByVisibleTrueAndSelectedUserIsNullAndDateTimeFromIsAfterAndDateTimeFromIsBefore(
                ZonedDateTime.now(),
                ZonedDateTime.now().plusHours(3)
        );
        // requests can be a max of 12 hours, therefore any within that window (currently open) should be "urgent"
        unrepliedRequests.addAll(
                helpRequestRepo.findByVisibleTrueAndSelectedUserIsNullAndDateTimeToIsAfterAndDateTimeToIsBefore(
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(12)
                )
        );
        for (HelpRequest unrepliedRequest : unrepliedRequests) {
            // rather than hammering the db, just manually select an area by lat/long first
            float offsetDegrees = 0.4f; // ~±44km
            // make sure distance is set
            // remove unsuitable users
            // remove contacted users
            User nextVolunteerToPing = userRepository.findByUserTypeIsAndLngLessThanAndLatLessThanAndLngGreaterThanAndLatGreaterThan(
                    UserType.student,
                    unrepliedRequest.getOriginLng() + offsetDegrees, unrepliedRequest.getOriginLat() + offsetDegrees,
                    unrepliedRequest.getOriginLng() - offsetDegrees, unrepliedRequest.getOriginLat() - offsetDegrees
            )
                    .stream()
                    .filter(User::getEmailUpdates)
                    .peek(s -> s.setTransientGeoDistanceMetres(Utils.getDistanceMetres(
                            unrepliedRequest.getOriginLng(), unrepliedRequest.getOriginLat(),
                            s.getLng(), s.getLat()
                    )))               // make sure distance is set
                    .filter(s -> s.getTransientGeoDistanceMetres() <= s.getNotifyRadius().getMetres())
                    .filter(s -> !unrepliedRequest.getRequiresPVG() || s.isPVGVerified())           // remove unsuitable users
                    // progressively more expensive operations now
                    .filter(s -> !helpRequestRepo                                                   // don't ping the user if they've already responded
                            .existsByIdAndRespondedByContains(unrepliedRequest.getId(), s)
                    )
                    .filter(s -> !pingRepo                                                          // don't ping same user within 1h
                            .existsByVolunteerAndPingedDTAfterAndPingType(s, ZonedDateTime.now().minusHours(1), PingType.email)
                    )
                    .filter(s -> !pingRepo.existsByHelpRequestAndVolunteerAndPingType(unrepliedRequest, s, PingType.email))    // don't message twice for same request
                    .min(Comparator.comparing(User::getTransientGeoDistanceMetres)).orElse(null);

            // don't ping anyone if there are no results ...
            if (null == nextVolunteerToPing) {
                pingUsersViaSMS(unrepliedRequest);
                continue;
            };

            emailService.urgentlyPingLocalVolunteer(nextVolunteerToPing, unrepliedRequest);

            // now add to db, so we only ping this user once
            if (!Utils.isActive("local", environment)) {
                pingRepo.save(new Ping(unrepliedRequest, nextVolunteerToPing, PingType.email));
            }
        }
    }
}
