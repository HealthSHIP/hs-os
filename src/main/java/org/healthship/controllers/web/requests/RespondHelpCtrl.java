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
import org.healthship.models.FriendlyError;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.time.ZonedDateTime;

@Controller
public class RespondHelpCtrl {

    private static final Logger logger = LoggerFactory.getLogger(RespondHelpCtrl.class);

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    IEmailService emailService;
    HelpRequestActionsSvc actionsSvc;

    public RespondHelpCtrl(HelpRequestRepo helpRequestRepo, UserRepository userRepository, IEmailService emailService, HelpRequestActionsSvc actionsSvc) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.actionsSvc = actionsSvc;
    }

    @RequestMapping(value = "/requests/{requestID}", method = RequestMethod.GET)
    /*
     * This function is used by:
     *
     *  - owner, to check who's replied
     *  - user, to view request (before confirmation)
     *  - user, to view request (after confirmation)
     */
    public ModelAndView showRespondHelp(
            @PathVariable("requestID") String requestID,
            WebRequest request, ModelAndView mav, Authentication authentication)
            throws ApplicationException {
        // protected
        User currentUser = userRepository.findByUsername(authentication.getName());
        // default redirect to profile page if location is not set
        if (!currentUser.isInitialised()) {
            return new ModelAndView("redirect:/profile?init");
        }
        HelpRequest helpRequest = helpRequestRepo.findById(requestID).orElse(null);
        if (null == helpRequest) {
            return new ModelAndView("meta/friendlyError", "fe", new FriendlyError(
                    "Sorry! It looks like that request for help has been deleted or already replied to.",
                    "see who else needs help", "/"
            ));
        }

        if (!currentUser.owns(helpRequest) && !currentUser.isEligible(helpRequest)) {
            logger.error("Security Exception", new HSSecurityException(String.format(
                    "User %s is not eligible to undertake activity that requires PVG",
                    currentUser.getUsername()
            )));
            return new ModelAndView("meta/friendlyError", "fe", new FriendlyError(
                    "Sorry! You need to have a PVG in order to undertake this activity.",
                    "see other requests for help", "/"
            ));
        }
        // do not edit above this line

        mav.addObject("section", "respond");
        mav.addObject("user", currentUser);
        mav.addObject("helpRequest", helpRequest);

        if (currentUser.owns(helpRequest)) {
            mav.setViewName("requestResourceOwner");
            return mav;
        }

        // sanity check: if the event has already been accepted it should only be
        // accessible to the end-user that was accepted
        // TODO : not ideal, relies on isVisible() being set
        if (!helpRequest.isVisible() && !currentUser.willBePerforming(helpRequest)) {
            logger.error("Event appears to already be accepted?", new HSSecurityException(String.format(
                    "Help request %s has already been accepted by %s, but %s was trying to access it " +
                            "(possible benign conflict: current time %s, event was accepted at %s)",
                    helpRequest.getId(), helpRequest.getSelectedUser().getUsername(), currentUser.getUsername(),
                    ZonedDateTime.now(), helpRequest.getSelectedUserDateTime()
            )));
            return new ModelAndView("meta/friendlyError", "fe", new FriendlyError(
                    "Sorry! It looks like someone else has already responded to this request.",
                    "see other requests", "/"
            ));
        }

        // TODO : like above, call it something more sensible
        if (helpRequest.isVisible()) {
            mav.setViewName("requestResourceVolunteer");
        }
        else {
            // this is the view shown when a user has been selected to undertake
            // a task and they attempt to view the page (after being accepted)
            mav.setViewName("viewAcceptedResourceVolunteer");
        }
        return mav;
    }

    @RequestMapping(value = "/requests/reply", method = RequestMethod.POST)
    public String postRespondHelp(
            @RequestParam("requestID") String requestID,
            Authentication authentication
    ) throws ApplicationException {
        // protected
        final User currentUser = userRepository.findByUsername(authentication.getName());
        HelpRequest helpRequest = helpRequestRepo.findById(requestID).orElseThrow(() ->
                new HSPersistenceException(String.format(
                        "Request %s not found by user %s", requestID, currentUser.getUsername()
                ))
        );
        if (!currentUser.isEligible(helpRequest)) {
            throw new HSSecurityException(String.format(
                    "User %s is not eligible to undertake activity that requires PVG", currentUser.getUsername()
            ));
        }
        // do not edit above this line

        helpRequest.addResponse(currentUser);
        try {
            if (helpRequest.getAutoAccept()) {
                helpRequest.setSelectedUser(currentUser);
                helpRequest.setVisible(false);
                emailService.sendVolunteerAutoAcceptedMessage(currentUser, helpRequest);
                return "redirect:/?autoResponded";
            } else {
                emailService.sendVolunteerOfferedMessages(currentUser, helpRequest);
                return "redirect:/?manual";
            }
        } finally {
            helpRequestRepo.save(helpRequest);
        }
    }

    @RequestMapping(value = "/requests/confirm", method = RequestMethod.POST)
    public String confirmRespondHelp(
            @RequestParam("requestID") String requestID,
            @RequestParam("username") String username,
            Authentication authentication
    ) throws ApplicationException {
        // protect
        final User currentUser = userRepository.findByUsername(authentication.getName());
        HelpRequest request = helpRequestRepo.findById(requestID).orElseThrow(() ->
                new HSPersistenceException(String.format(
                        "Request %s not found by user %s", requestID, currentUser.getUsername()
                ))
        );
        if (!currentUser.owns(request)) {
            throw new HSSecurityException(String.format(
                    "User %s has inexplicably attempted to confirm a request %s on behalf of user %s",
                    currentUser.getUsername(), request.getId(), request.getCreatedBy().getUsername()
            ));
        }
        // do not edit above this line

        final User selectedUser = userRepository.findByUsername(username);
        if (null == selectedUser) {
            throw new ApplicationException(String.format("Unable to find user %s", username));
        }

        actionsSvc.selectUser(request, selectedUser);

        return "redirect:/requests/" + requestID;
    }
}
