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

package org.healthship.services;

import org.healthship.models.HelpRequest;
import org.healthship.models.ShortCode;
import org.healthship.models.User;
import org.healthship.models.internal.Ping;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.PingRepo;
import org.healthship.repos.ShortCodesRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

@Service
public class HelpRequestActionsSvcImpl implements HelpRequestActionsSvc {
    private static final Logger logger = LoggerFactory.getLogger(HelpRequestActionsSvcImpl.class);

    HelpRequestRepo helpRequestRepo;
    PingRepo pingRepo;
    ShortCodesRepo shortCodesRepo;
    EmailServiceImpl emailService;

    public HelpRequestActionsSvcImpl(HelpRequestRepo helpRequestRepo, PingRepo pingRepo, ShortCodesRepo shortCodesRepo, EmailServiceImpl emailService) {
        this.helpRequestRepo = helpRequestRepo;
        this.pingRepo = pingRepo;
        this.shortCodesRepo = shortCodesRepo;
        this.emailService = emailService;
    }

    @Override
    public void selectUser(HelpRequest request, User selectedUser) {
        request.setVisible(false);
        request.setSelectedUser(selectedUser);
        request.setSelectedUserDateTime(ZonedDateTime.now());
        helpRequestRepo.save(request);

        // send acceptance email
        logger.info(String.format("Sending acceptance email for request ID '%s' to '%s'", request.getId(), selectedUser.getUsername()));
        emailService.sendVolunteerManuallyAcceptedMessage(selectedUser, request);
        // send rejection emails
        for (User rejectedUser : request.getRespondedBy().stream().filter(u -> !u.equals(selectedUser)).collect(Collectors.toSet())) {
            logger.info(String.format("Sending rejection email for request ID '%s' to '%s'", request.getId(), rejectedUser.getUsername()));
            emailService.sendVolunteerRejectedMessages(rejectedUser, request);
        }
    }

    @Override
    @Transactional
    public void delete(HelpRequest helpRequest) {
        // send notifications to any users that might have already replied
        for (User user : helpRequest.getRespondedBy()) {
            logger.info(String.format("Sending deleted-request email for request ID '%s' to user '%s'", helpRequest.getId(), user.getUsername()));
            emailService.sendVolunteerDeletedMessages(user, helpRequest);
        }
        logger.info(String.format("Appending delete pings transaction '%s'", helpRequest.getId()));
        for (Ping ping : pingRepo.findByHelpRequestEquals(helpRequest)) {
            logger.info("Deleting {}", ping);
            pingRepo.delete(ping);
        }
        logger.info(String.format("Appending delete request transaction '%s'", helpRequest.getId()));
        helpRequestRepo.delete(helpRequest);
        for (ShortCode shortCode : shortCodesRepo.findByHelpRequestEquals(helpRequest)) {
            logger.info("Deleting {}", shortCode);
            shortCodesRepo.delete(shortCode);
        }
    }
}
