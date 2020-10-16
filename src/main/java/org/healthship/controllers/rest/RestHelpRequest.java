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

import org.healthship.dtos.GetUserProfileDTO;
import org.healthship.exceptions.ApplicationException;
import org.healthship.exceptions.HSPersistenceException;
import org.healthship.exceptions.HSSecurityException;
import org.healthship.models.HelpRequest;
import org.healthship.models.User;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.SPBE5Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
 * Used on the 'show results' home page to pull back a user profile
 */
public class RestHelpRequest {
    private static final Logger logger = LoggerFactory.getLogger(RestHelpRequest.class);

    HelpRequestRepo helpRequestRepo;
    UserRepository userRepository;
    SPBE5Service spbe5Service;

    public RestHelpRequest(HelpRequestRepo helpRequestRepo, UserRepository userRepository, SPBE5Service spbe5Service) {
        this.helpRequestRepo = helpRequestRepo;
        this.userRepository = userRepository;
        this.spbe5Service = spbe5Service;
    }

    @RequestMapping(value = "/api/requests/{requestID}/ownerProfile")
    public GetUserProfileDTO getRequestOwner(
            @PathVariable("requestID") String requestID,
            Authentication authentication
    ) throws ApplicationException {
        // protected
        final User currentUser = userRepository.findByUsername(authentication.getName());
        final HelpRequest helpRequest = helpRequestRepo.findById(requestID).orElseThrow(() ->
                new HSPersistenceException(String.format(
                        "Request %s not found by user %s", requestID, currentUser.getUsername()
                ))
        );
        if (!currentUser.isEligible(helpRequest)) {
            throw new HSSecurityException(String.format(
                    "SECURITY: User %s attempted to access request %s, which they are not eligible to do",
                    currentUser.getUsername(), helpRequest.getId()
            ));
        }
        // do not edit above this line
        return new GetUserProfileDTO(helpRequest.getCreatedBy())
                .withEncImageName(spbe5Service.encrypt(helpRequest.getCreatedBy().getUsername()));
    }
}
