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

package org.healthship.controllers.web.requests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.healthship.exceptions.ApplicationException;
import org.healthship.models.HelpRequest;
import org.healthship.models.HelpRequestResource;
import org.healthship.models.User;
import org.healthship.models.internal.MappingBehaviour;
import org.healthship.models.internal.ResourceType;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.ResourceRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.Utils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.UUID;

@Controller
public class RequestHelpCtrl {

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    ResourceRepo resourceRepo;

    public RequestHelpCtrl(HelpRequestRepo helpRequestRepo, UserRepository userRepository, ResourceRepo resourceRepo) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.resourceRepo = resourceRepo;
    }

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public String showRequestHelp(WebRequest request, Model model, Authentication authentication) throws ApplicationException {
        User currentUser = userRepository.findByUsername(authentication.getName());
        // default redirect to profile page if location is not set
        if (!currentUser.isInitialised()) {
            return "redirect:/profile?init";
        }
        if (!currentUser.getUserType().canCreateRequests()) {
            throw new ApplicationException(String.format(
                    "User %s attempted to create a help request but is not permitted to do so", currentUser.getUsername()
            ));
        }

        model.addAttribute("isAdmin", Utils.isAdmin(currentUser));
        model.addAttribute("section", "request");
        model.addAttribute("helpRequest", new HelpRequest(currentUser));

        return "request";
    }

    @RequestMapping(value = "/requests", method = RequestMethod.POST)
    public ModelAndView postRequestHelp(
            @ModelAttribute @Valid HelpRequest helpRequest,
            @RequestParam(name = "resourcesJSON", required = false) String resourcesJSON,
            BindingResult result,
            WebRequest request,
            Errors errors, Authentication authentication) {
        User currentUser = userRepository.findByUsername(authentication.getName());
        ModelAndView mav = new ModelAndView("request", "helpRequest", helpRequest);
        mav.addObject("isAdmin", Utils.isAdmin(currentUser));

        // some date checks ... null checks are already done elsewhere but AFTER us
        if (null != helpRequest.getDateTimeFrom() && null != helpRequest.getDateTimeTo()) {
            if (helpRequest.getDateTimeFrom().isBefore(ZonedDateTime.now())) {
                errors.rejectValue("dateTimeFrom", "", "Date cannot be in the past");
            }
            if (helpRequest.getDateTimeTo().isBefore(helpRequest.getDateTimeFrom())) {
                errors.rejectValue("dateTimeTo", "", "End time cannot be before the start time");
            }
            if (helpRequest.getDateTimeFrom().plusHours(13).isBefore(helpRequest.getDateTimeTo())) {
                errors.rejectValue("dateTimeTo", "", "A single task cannot be longer than 12 hours");
            }
        }

        if (!result.hasErrors()) {
            if (null != resourcesJSON && Utils.isAdmin(currentUser)) {
                Type t = TypeToken.getParameterized(HashSet.class, HelpRequestResource.class).getType();
                HashSet<HelpRequestResource> resources = new Gson().fromJson(resourcesJSON, t);
                for (HelpRequestResource resource : resources) {
                    // only dealing with external URLs right now
                    if (null == resource.getType()) resource.setType(ResourceType.ext_url);
                    if (null == resource.getId()) resource.setId(UUID.randomUUID().toString());
                    resourceRepo.save(resource);
                }
                helpRequest.setResources(resources);
            }

            helpRequest.setId(UUID.randomUUID().toString());
            helpRequest.setCreatedBy(userRepository.findByUsername(authentication.getName()));
            helpRequest.setCreatedDateTime(ZonedDateTime.now());
            helpRequest.setRequiresPVG(helpRequest.getHelpWith().requiresPVG());

            if (!helpRequest.getHelpWith().getBehaviour().equals(MappingBehaviour.A_B) ||
                    null == helpRequest.getDestination() || helpRequest.getDestination().isEmpty()
            ) {
                helpRequest.setDestination(null);
                helpRequest.setDestinationLat(null);
                helpRequest.setDestinationLng(null);
            }

            helpRequestRepo.save(helpRequest);
            mav.clear();
            mav.setViewName("redirect:/?added");
            return mav;
        }

        return mav;
    }
}
