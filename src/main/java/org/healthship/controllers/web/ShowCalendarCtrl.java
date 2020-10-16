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
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ShowCalendarCtrl {

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;

    public ShowCalendarCtrl(HelpRequestRepo helpRequestRepo, UserRepository userRepository) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/calendar", method = RequestMethod.GET)
    public String showHome(WebRequest request, Model model, Authentication authentication) {
        model.addAttribute("section", "calendar");
        User currentUser = userRepository.findByUsername(authentication.getName());

        if (!currentUser.isInitialised()) {
            return "redirect:/profile?init";
        }

        model.addAttribute("user", currentUser);

        List<HelpRequest> requests = helpRequestRepo.findAll()
                .stream()
                .filter(HelpRequest::isVisible)
                .peek(helpRequest -> {
                    helpRequest.setTimeAgo(Utils.getTimeAgo(helpRequest));
                    helpRequest.setTrnMetresToOrigin(Utils.getDistanceMetres(
                            helpRequest.getOriginLng(), helpRequest.getOriginLat(), currentUser.getLng(), currentUser.getLat()
                    ));
                    helpRequest.isOwner(helpRequest.getCreatedBy().equals(currentUser));
                    helpRequest.alreadyResponded(helpRequest.getRespondedBy().contains(currentUser));
                })
                .sorted(Comparator.comparingDouble(HelpRequest::getTrnMetresToOrigin))
                .collect(Collectors.toList());

        model.addAttribute("requests", requests);
        return "calendar";
    }
}
