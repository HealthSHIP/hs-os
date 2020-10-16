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

package org.healthship.controllers.web;

import org.healthship.models.HelpRequest;
import org.healthship.models.User;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.UserRepository;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShowHomeCtrl {
    private static final Logger logger = LoggerFactory.getLogger(ShowHomeCtrl.class);

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    Utils utils;

    public ShowHomeCtrl(HelpRequestRepo helpRequestRepo, UserRepository userRepository, Utils utils) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.utils = utils;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(WebRequest request, Model model, Authentication authentication) {
        model.addAttribute("section", "home");
        User currentUser = userRepository.findByUsername(authentication.getName());

        // default redirect to profile page if location is not set
        if (!currentUser.isInitialised()) {
            return "redirect:/profile?init";
        }

        List<HelpRequest> myRequests = new ArrayList<>(
                helpRequestRepo.findByCreatedByEqualsAndVisibleIsTrueOrderByDateTimeFrom(currentUser)
        );
        List<HelpRequest> myOffers = new ArrayList<>(
                helpRequestRepo.findBySelectedUserEqualsAndDateTimeToIsAfterOrderByDateTimeFrom(currentUser, ZonedDateTime.now())
        );
        model.addAttribute("myRequests", myRequests);
        model.addAttribute("myOffers", myOffers);

        if (null == currentUser.getLng() || null == currentUser.getLat()) {
            logger.info("Unable to find lat/long fields on current user, setting them to " +
                    "a default value to stop map from blowing up");
            currentUser.withLat(56.34f);
            currentUser.withLng(-2.81f);
        }
        model.addAttribute("user", currentUser);
        return "home";
    }
}
