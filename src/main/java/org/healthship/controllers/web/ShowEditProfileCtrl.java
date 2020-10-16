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

import org.healthship.dtos.UserProfileDTO;
import org.healthship.exceptions.ApplicationException;
import org.healthship.models.User;
import org.healthship.repos.AvatarRepo;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ShowEditProfileCtrl {

    private static final Logger logger = LoggerFactory.getLogger(ShowEditProfileCtrl.class);

    HelpRequestRepo eventRepository;
    UserRepository userRepository;
    AvatarRepo avatarRepo;
    ImageService imageService;

    public ShowEditProfileCtrl(
            HelpRequestRepo eventRepository,
            UserRepository userRepository,
            AvatarRepo avatarRepo,
            ImageService imageService
    ) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.avatarRepo = avatarRepo;
        this.imageService = imageService;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showEditProfile(WebRequest request, Model model, Authentication authentication) {
        final User user = userRepository.findByUsername(authentication.getName());
        UserProfileDTO userProfile = new UserProfileDTO(user);

        model.addAttribute("section", "profile");
        model.addAttribute("userProfileDTO", userProfile);
        model.addAttribute("user", user);

        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public ModelAndView postEditProfile(
            @ModelAttribute @Valid UserProfileDTO userProfile,
            BindingResult result,
            WebRequest request,
            Model model,
            Errors errors, Authentication authentication
    ) throws ApplicationException {
        User currentUser = userRepository.findByUsername(authentication.getName());

        ModelAndView mav = new ModelAndView("profile", "userProfileDTO", userProfile);
        mav.addObject("section", "profile");
        mav.addObject("user", currentUser);

        if (result.hasErrors()) {
            logger.error("Error processing response from user");
            return mav;
        }

        userRepository.saveAndFlush(currentUser.withUpdate(userProfile));
        logger.debug("Saved user update for user " + currentUser.getUsername());

        return new ModelAndView("redirect:/?saved");
    }
}
