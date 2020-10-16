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

package org.healthship.controllers.rest;

import org.healthship.exceptions.ApplicationException;
import org.healthship.exceptions.HSSecurityException;
import org.healthship.models.MapHelpRequestDTO;
import org.healthship.models.MapObjectDTO;
import org.healthship.models.User;
import org.healthship.models.UserType;
import org.healthship.models.internal.MappingBehaviour;
import org.healthship.models.rest.DistanceResponse;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.DistanceCalculator;
import org.healthship.services.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestMapping {
    private static final Logger logger = LoggerFactory.getLogger(RestMapping.class);

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    DistanceCalculator distanceCalculator;

    public RestMapping(HelpRequestRepo helpRequestRepo, UserRepository userRepository, DistanceCalculator distanceCalculator) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.distanceCalculator = distanceCalculator;
    }

    @RequestMapping(value = "/api/map/requests")
    public List<MapHelpRequestDTO> getRequests(
            @RequestParam(value = "swLat") final Float swLat,
            @RequestParam(value = "swLng") final Float swLng,
            @RequestParam(value = "neLat") final Float neLat,
            @RequestParam(value = "neLng") final Float neLng,
            Authentication authentication
    ) {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        final Float margin = 0.3f;
        return helpRequestRepo.findByVisibleTrueAndSelectedUserIsNullAndDateTimeFromIsAfterAndOriginLatBetweenAndOriginLngBetween(
                ZonedDateTime.now(), swLat - margin, neLat + margin, swLng - margin, neLng + margin
        ).stream()
                .peek(s -> s.setDuration(Utils.getBetweenEpoch(s.getDateTimeFrom(), s.getDateTimeTo())))
                .map(s -> new MapHelpRequestDTO(s, currentUser))
                .collect(Collectors.toList());
    }

    /**
     * NB is limited to 25 results
     */
    @RequestMapping(value = "/api/map/volunteers")
    public List<MapObjectDTO> getVolunteers(
            @RequestParam(value = "swLat") final Float swLat,
            @RequestParam(value = "swLng") final Float swLng,
            @RequestParam(value = "neLat") final Float neLat,
            @RequestParam(value = "neLng") final Float neLng
    ) {
        return userRepository.findByEnabledTrueAndUserTypeIsAndLatBetweenAndLngBetween(
                UserType.student, swLat, neLat, swLng, neLng
        ).stream()
                .map(MapObjectDTO::new)
                .limit(25)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/map/acceptances")
    public List<MapHelpRequestDTO> getRequestsAcceptedWithinLastWeek(
            @RequestParam(value = "swLat") final Float swLat,
            @RequestParam(value = "swLng") final Float swLng,
            @RequestParam(value = "neLat") final Float neLat,
            @RequestParam(value = "neLng") final Float neLng,
            Authentication authentication
    ) throws HSSecurityException {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        if (!Utils.isAdmin(currentUser)) {
            throw new HSSecurityException(String.format("User %s attempting to access admin endpoint", authentication.getName()));
        }
        final Float margin = 0.3f;
        return helpRequestRepo.findBySelectedUserIsNotNullAndSelectedUserDateTimeIsAfterAndOriginLatBetweenAndOriginLngBetween(
                ZonedDateTime.now().minusDays(7), swLat - margin, neLat + margin, swLng - margin, neLng + margin
        ).stream()
                .peek(s -> s.setDuration(Utils.getBetweenEpoch(s.getDateTimeFrom(), s.getDateTimeTo())))
                .map(s -> new MapHelpRequestDTO(s, currentUser))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/map/clinicians")
    public List<MapObjectDTO> getClinicians(
            @RequestParam(value = "swLat") final Float swLat,
            @RequestParam(value = "swLng") final Float swLng,
            @RequestParam(value = "neLat") final Float neLat,
            @RequestParam(value = "neLng") final Float neLng,
            Authentication authentication
    ) throws HSSecurityException {
        if (!Utils.isAdmin(userRepository.findByUsername(authentication.getName()))) {
            throw new HSSecurityException(String.format("User %s attempting to access admin endpoint", authentication.getName()));
        }
        final Float margin = 0.3f;

        return userRepository.findByEnabledTrueAndUserTypeIsAndLatBetweenAndLngBetween(
                UserType.clinician,
                swLat - margin, neLat + margin,
                swLng - margin, neLng + margin
        ).stream().map(s -> new MapObjectDTO(s)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/map/students")
    public List<MapObjectDTO> getStudents(
            @RequestParam(value = "swLat") final Float swLat,
            @RequestParam(value = "swLng") final Float swLng,
            @RequestParam(value = "neLat") final Float neLat,
            @RequestParam(value = "neLng") final Float neLng,
            Authentication authentication
    ) throws HSSecurityException {
        if (!Utils.isAdmin(userRepository.findByUsername(authentication.getName()))) {
            throw new HSSecurityException(String.format("User %s attempting to access admin endpoint", authentication.getName()));
        }
        final Float margin = 0.3f;

        return userRepository.findByEnabledTrueAndUserTypeIsAndLatBetweenAndLngBetween(
                UserType.student,
                swLat - margin, neLat + margin,
                swLng - margin, neLng + margin
        ).stream().map(s -> new MapObjectDTO(s)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/map/distance")
    public DistanceResponse getDistance(
            @RequestParam(value = "type") MappingBehaviour type,
            @RequestParam(value = "helpRequest", required = false) String requestID,
            Authentication authentication
    ) throws ApplicationException {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        if (type.equals(MappingBehaviour.A_B)) {
            return new DistanceResponse(
                    distanceCalculator.getRoadDistanceBetweenOriginAndDestinationAsString(currentUser, helpRequestRepo.getOne(requestID)),
                    distanceCalculator.getRoadTimeBetweenOriginAndDestinationAsString(helpRequestRepo.getOne(requestID))
            );
        }
        throw new ApplicationException("Unable to find request");
    }

}
