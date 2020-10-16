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

import org.healthship.models.User;
import org.healthship.models.VouchState;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.UserRepository;
import org.healthship.repos.VouchRequestRepo;
import org.healthship.services.Utils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VouchUserCtrl {

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    VouchRequestRepo vouchRequestRepo;
    Utils utils;


    public VouchUserCtrl(HelpRequestRepo helpRequestRepo, UserRepository userRepository, VouchRequestRepo vouchRequestRepo, Utils utils) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.vouchRequestRepo = vouchRequestRepo;
        this.utils = utils;
    }

    @RequestMapping(value = "/vouch", method = RequestMethod.GET)
    public String showHome(Model model, Authentication authentication) {
        model.addAttribute("section", "home");
        final User currentUser = userRepository.findByUsername(authentication.getName());
        model.addAttribute("user", currentUser);
        model.addAttribute("myRequests", vouchRequestRepo.findByClinicianEqualsAndStateEquals(currentUser, VouchState.PENDING));
        return "vouch";
    }
}
