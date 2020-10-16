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

import org.healthship.exceptions.ApplicationException;
import org.healthship.exceptions.HSPersistenceException;
import org.healthship.exceptions.HSSecurityException;
import org.healthship.models.HelpRequest;
import org.healthship.models.User;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.HelpRequestActionsSvc;
import org.healthship.services.IEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class DeleteHelpCtrl {

    private static final Logger logger = LoggerFactory.getLogger(DeleteHelpCtrl.class);

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    IEmailService emailService;
    HelpRequestActionsSvc actionsSvc;

    public DeleteHelpCtrl(HelpRequestRepo helpRequestRepo, UserRepository userRepository, IEmailService emailService, HelpRequestActionsSvc actionsSvc) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.actionsSvc = actionsSvc;
    }

    @RequestMapping(value = "/requests/{requestID}/delete", method = RequestMethod.GET)
    public String showDeleteHelp(
            @PathVariable("requestID") final String requestID,
            WebRequest request, Model model, Authentication authentication) throws ApplicationException {
        // protect
        final User currentUser = userRepository.findByUsername(authentication.getName());
        final HelpRequest helpRequest = helpRequestRepo.findById(requestID).orElseThrow(() ->
                new HSPersistenceException(String.format(
                        "Request %s not found by user %s", requestID, currentUser.getUsername()
                ))
        );
        checkUserOwnsResource(currentUser, helpRequest);
        // do not edit above this line

        model.addAttribute("section", "delete");
        model.addAttribute("user", currentUser);
        model.addAttribute("helpRequest", helpRequest);

        return "delete";
    }

    @RequestMapping(value = "/requests/{requestID}/delete", method = RequestMethod.POST)
    public String postDeleteHelp(
            @RequestParam("requestID") final String requestIDForm,
            Authentication authentication
    ) throws HSSecurityException {
        // protect
        HelpRequest helpRequest = helpRequestRepo.findById(requestIDForm).orElseThrow(() ->
                new HSSecurityException(String.format(
                        "User %s attempted to delete request ID %s but this object does not exist",
                        authentication.getName(), requestIDForm))
        );
        final User currentUser = userRepository.findByUsername(authentication.getName());
        checkUserOwnsResource(currentUser, helpRequest);
        // do not edit above this line

        actionsSvc.delete(helpRequest);

        return "redirect:/";
    }

    private void checkUserOwnsResource(User currentUser, HelpRequest helpRequest) throws HSSecurityException {
        if (!currentUser.owns(helpRequest)) {
            throw new HSSecurityException(String.format(
                    "User %s attempted to delete request %s belonging to user %s",
                    currentUser.getUsername(), helpRequest.getId(), helpRequest.getCreatedBy().getUsername()
            ));
        }
    }
}
