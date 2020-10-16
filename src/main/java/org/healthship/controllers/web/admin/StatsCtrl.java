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

package org.healthship.controllers.web.admin;

import org.healthship.exceptions.ApplicationException;
import org.healthship.exceptions.HSSecurityException;
import org.healthship.models.User;
import org.healthship.models.UserType;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.IEmailService;
import org.healthship.services.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Controller
public class StatsCtrl {

    private static final Logger logger = LoggerFactory.getLogger(StatsCtrl.class);

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    IEmailService emailService;

    public StatsCtrl(HelpRequestRepo helpRequestRepo, UserRepository userRepository, IEmailService emailService) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public String showDeleteHelp(
            WebRequest request, Model model, Authentication authentication
    ) throws ApplicationException {
        // protect
        final User currentUser = userRepository.findByUsername(authentication.getName());
        if (!Utils.isAdmin(currentUser)) {
            throw new HSSecurityException(String.format("User %s attempted to access stats", currentUser.getUsername()));
        }

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalUsers", String.valueOf(userRepository.findAll().size()));
        stats.put("last24h", userRepository.findByAcceptedTermsDTAfter(ZonedDateTime.now().minusDays(1)).size());
        stats.put("confirmedStudents", String.valueOf(userRepository.findByEnabledTrueAndUserTypeIs(UserType.student).size()));
        stats.put("confirmedStaff", String.valueOf(userRepository.findByEnabledTrueAndUserTypeIs(UserType.clinician).size()));

        stats.put("domainsConf", userRepository.findAll()
                .stream().map(s -> {
                    return s.getUsername().split("@")[1];
                })
                .collect(toMap(String::toString, v -> 1, Math::addExact)));

        stats.put("domainsUnconf", userRepository.findByEnabledFalse()
                .stream().map(s -> {
                    return s.getUsername().split("@")[1];
                })
                .collect(toMap(String::toString, v -> 1, Math::addExact)));

        model.addAttribute("stats", stats);

        return "static/stats";
    }
}
