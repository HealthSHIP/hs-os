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

import org.healthship.dtos.ClickActionDTO;
import org.healthship.exceptions.HSSecurityException;
import org.healthship.models.FriendlyError;
import org.healthship.models.HelpRequest;
import org.healthship.models.OneTimeToken;
import org.healthship.models.User;
import org.healthship.models.internal.TokenType;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.OneTimeTokenRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.HelpRequestActionsSvc;
import org.healthship.services.IEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.ZonedDateTime;

/*
    All of these endpoints are only protected by tokens, so for each request, we invalidate the old token and create a new
    one. We also narrow the window for click confirmation by a large amount.
 */
@Controller
public class EmailResponsesCtrl {

    private static final Logger logger = LoggerFactory.getLogger(EmailResponsesCtrl.class);

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    IEmailService emailService;
    OneTimeTokenRepo tokenRepo;
    HelpRequestActionsSvc actionsSvc;

    int confirmWindowMins = 3; // invalidate the confirmation token after this amount of time

    public EmailResponsesCtrl(HelpRequestRepo helpRequestRepo, UserRepository userRepository, IEmailService emailService, OneTimeTokenRepo tokenRepo, HelpRequestActionsSvc actionsSvc) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.tokenRepo = tokenRepo;
        this.actionsSvc = actionsSvc;
    }

    @RequestMapping(value = "/click", method = RequestMethod.GET)
    public String getClickHome() {
        return "static/click";
    }

    @RequestMapping(value = "/click/requests/{requestID}/delete", method = RequestMethod.GET)
    public ModelAndView showUnauthUnlistRequest(
            @PathVariable("requestID") final String requestID,
            @RequestParam("token") final String token
    ) {
        OneTimeToken ott = tokenRepo.findById(token).orElse(null);
        if (null == ott) {
            return new ModelAndView("meta/friendlyError", "fe",
                    new FriendlyError("Invalid token, cannot process request")
            );
        }
        tokenRepo.delete(ott);

        HelpRequest helpRequest = helpRequestRepo.findById(requestID).orElse(null);
        if (null == helpRequest) {
            return new ModelAndView("meta/friendlyError", "fe",
                    new FriendlyError("Request does not exist")
            );
        }

        ModelAndView mav = new ModelAndView("static/confirm_click", "actionDTO",
                new ClickActionDTO(ClickActionDTO.Action.delete, helpRequest.getId(),
                        tokenRepo.save(new OneTimeToken(helpRequest.getCreatedBy()).setTokenType(TokenType.unlist_request))
                )
        );
        mav.addObject("section", "dl");
        return mav;
    }

    @RequestMapping(value = "/click/requests/delete", method = RequestMethod.POST)
    public ModelAndView postUnauthUnlistRequest(
            @ModelAttribute @Valid ClickActionDTO actionDTO
    ) throws HSSecurityException {
        if (!tokenRepo.existsById(actionDTO.getToken()) ||
                !tokenRepo.getOne(actionDTO.getToken()).getTokenType().equals(TokenType.unlist_request)
        ) {
            return new ModelAndView("meta/friendlyError", "fe",
                    new FriendlyError("Link has expired, please log in to delete your request for help")
            );
        }
        if (tokenRepo.getOne(actionDTO.getToken()).getDateTime().isBefore(ZonedDateTime.now().minusMinutes(confirmWindowMins))) {
            tokenRepo.deleteById(actionDTO.getToken());
            return new ModelAndView("meta/friendlyError", "fe",
                    new FriendlyError("Link has expired, please log in to delete your request for help")
            );
        }
        tokenRepo.deleteById(actionDTO.getToken());

        HelpRequest helpRequest = helpRequestRepo.getOne(actionDTO.getRequestID());
        actionsSvc.delete(helpRequest);
        return new ModelAndView("redirect:/click?deleted");
    }

    @RequestMapping(value = "/click/requests/{requestID}/confirm", method = RequestMethod.GET)
    public ModelAndView showConfirmVolunteer(
            @PathVariable("requestID") final String requestID,
            @RequestParam("user") final String userID,
            @RequestParam("token") final String token
    ) {
        OneTimeToken ott = tokenRepo.findById(token).orElse(null);
        if (null == ott) {
            return new ModelAndView("meta/friendlyError", "fe",
                    new FriendlyError("Invalid token, cannot process request")
            );
        }
        tokenRepo.delete(ott);

        User volunteer = userRepository.findByUsername(userID);
        if (null == volunteer) {
            return new ModelAndView("meta/friendlyError", "fe",
                    new FriendlyError("User does not exist")
            );
        }

        HelpRequest helpRequest = helpRequestRepo.findById(requestID).orElse(null);
        if (null == helpRequest) {
            return new ModelAndView("meta/friendlyError", "fe",
                    new FriendlyError("Request does not exist")
            );
        }
        if (!helpRequest.getRespondedBy().contains(volunteer)) {
            return new ModelAndView("meta/friendlyError", "fe",
                    new FriendlyError("User may have rescinded offer of help")
            );
        }

        ModelAndView mav = new ModelAndView("static/confirm_click", "actionDTO",
                new ClickActionDTO(ClickActionDTO.Action.confirm, helpRequest.getId(), volunteer,
                        tokenRepo.save(new OneTimeToken(helpRequest.getCreatedBy()).setTokenType(TokenType.confirm_volunteer))
                )
        );
        mav.addObject("section", "cv");
        return mav;
    }

    @RequestMapping(value = "/click/requests/confirm", method = RequestMethod.POST)
    public ModelAndView postConfirmVolunteer(
            @ModelAttribute @Valid ClickActionDTO actionDTO
    ) throws HSSecurityException {
        if (!tokenRepo.existsById(actionDTO.getToken()) ||
                !tokenRepo.getOne(actionDTO.getToken()).getTokenType().equals(TokenType.confirm_volunteer)
        ) {
            return new ModelAndView("meta/friendlyError", "fe",
                    new FriendlyError("Link has expired, please log in to confirm your volunteer")
            );
        }
        if (tokenRepo.getOne(actionDTO.getToken()).getDateTime().isBefore(ZonedDateTime.now().minusMinutes(confirmWindowMins))) {
            tokenRepo.deleteById(actionDTO.getToken());
            return new ModelAndView("meta/friendlyError", "fe",
                    new FriendlyError("Link has expired, please log in to confirm your volunteer")
            );
        }
        tokenRepo.deleteById(actionDTO.getToken());

        HelpRequest helpRequest = helpRequestRepo.getOne(actionDTO.getRequestID());
        actionsSvc.selectUser(helpRequest, userRepository.findByUsername(actionDTO.getUserID()));
        return new ModelAndView("redirect:/click?confirmed");
    }

}
