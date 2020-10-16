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

import org.healthship.models.CalendarEvent;
import org.healthship.models.User;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class RestCalendarEvents {
    private static final Logger logger = LoggerFactory.getLogger(RestCalendarEvents.class);

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    Utils utils;

    public RestCalendarEvents(HelpRequestRepo helpRequestRepo, UserRepository userRepository, Utils utils) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.utils = utils;
    }

    @RequestMapping(value = "/api/requests/calendar")
    public Set<CalendarEvent> getRequestForCalendar(
            Authentication authentication
    ) {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        return helpRequestRepo
                .findByVisibleTrueAndSelectedUserIsNullAndCreatedByIsNotAndDateTimeToIsAfter(
                        currentUser, ZonedDateTime.now()).stream()
                .map(s -> new CalendarEvent(s, currentUser, utils))
                .collect(Collectors.toSet());
    }
}
