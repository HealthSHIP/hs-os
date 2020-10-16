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

import org.healthship.exceptions.UnrecoverableException;
import org.healthship.models.HelpRequestDTO;
import org.healthship.models.User;
import org.healthship.models.internal.MappingBehaviour;
import org.healthship.models.internal.Radius;
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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestHelpRequests {
    private static final Logger logger = LoggerFactory.getLogger(RestHelpRequests.class);

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    DistanceCalculator distanceCalculator;

    public RestHelpRequests(HelpRequestRepo helpRequestRepo, UserRepository userRepository, DistanceCalculator distanceCalculator) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.distanceCalculator = distanceCalculator;
    }

    @RequestMapping(value = "/api/requests")
    public List<HelpRequestDTO> getRequests(
            @RequestParam(value = "orderBy", required = false, defaultValue = "distance") final String orderBy,
            @RequestParam(value = "filterDistance", required = false, defaultValue = "_13km") final Radius radius,
            Authentication authentication
    ) {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        if (orderBy.equalsIgnoreCase("distance")) {
            return helpRequestRepo
                    .findByVisibleTrueAndSelectedUserIsNullAndCreatedByIsNotAndDateTimeToIsAfter(
                            currentUser, ZonedDateTime.now()
                    )
                    .stream()
                    .peek(q -> {
                        q.setTrnMetresToOrigin(Utils.getDistanceMetres(
                                currentUser.getLng(), currentUser.getLat(),
                                q.getOriginLng(), q.getOriginLat()
                        ));
                        if (null != q.getDestination() && q.getHelpWith().getBehaviour().equals(MappingBehaviour.A_B)) {
                            q.setTrnMetresToDestination(Utils.getDistanceMetres(
                                    currentUser.getLng(), currentUser.getLat(),
                                    q.getDestinationLng(), q.getDestinationLat()
                            ));
                        }
                    })
                    .filter(r -> r.getTrnMetresToOrigin() < currentUser.getNotifyRadius().getMetres())
                    .map(s -> new HelpRequestDTO(s, currentUser, distanceCalculator))
                    .sorted(Comparator.comparing(HelpRequestDTO::getDistanceToOriginMetres))
                    .collect(Collectors.toList());
        }

        if (orderBy.equalsIgnoreCase("createdDT")) {
            return helpRequestRepo
                    .findByVisibleTrueAndSelectedUserIsNullAndCreatedByIsNotAndDateTimeToIsAfterOrderByCreatedDateTimeDesc(
                            currentUser, ZonedDateTime.now()
                    )
                    .stream()
                    .peek(q -> q.setTrnMetresToOrigin(Utils.getDistanceMetres(
                            q.getOriginLng(), q.getOriginLat(),
                            currentUser.getLng(), currentUser.getLat()
                    )))
                    .filter(r -> r.getTrnMetresToOrigin() < radius.getMetres())
                    .map(s -> new HelpRequestDTO(s, currentUser, distanceCalculator))
                    .collect(Collectors.toList());
        }

        if (orderBy.equalsIgnoreCase("startDT")) {
            return helpRequestRepo
                    .findByVisibleTrueAndSelectedUserIsNullAndCreatedByIsNotAndDateTimeToIsAfterOrderByDateTimeFrom(
                            currentUser, ZonedDateTime.now()
                    )
                    .stream()
                    .peek(q -> q.setTrnMetresToOrigin(Utils.getDistanceMetres(
                            q.getOriginLng(), q.getOriginLat(),
                            currentUser.getLng(), currentUser.getLat()
                    )))
                    .filter(r -> r.getTrnMetresToOrigin() < radius.getMetres())
                    .map(s -> new HelpRequestDTO(s, currentUser, distanceCalculator))
                    .collect(Collectors.toList());
        }

        throw new UnrecoverableException("Unable to find correct type of sort");
    }
}
