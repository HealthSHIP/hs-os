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

import org.healthship.exceptions.ApplicationException;
import org.healthship.models.HelpRequest;
import org.healthship.models.OneTimeToken;
import org.healthship.models.User;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.OneTimeTokenRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.HelpRequestActionsSvc;
import org.healthship.services.ResendConfirmationSvc;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// this class is loaded only under local profile, to
// perform any admin type actions
@RestController
@Profile({"proxy", "proxy-int"})
public class ProxyRestFunctions {

    UserRepository userRepository;
    ResendConfirmationSvc resendConfirmationSvc;
    OneTimeTokenRepo tokenRepo;
    HelpRequestActionsSvc actionsSvc;
    HelpRequestRepo helpRequestRepo;

    public ProxyRestFunctions(
            UserRepository userRepository,
            ResendConfirmationSvc resendConfirmationSvc,
            OneTimeTokenRepo tokenRepo,
            HelpRequestActionsSvc actionsSvc,
            HelpRequestRepo helpRequestRepo
    ) {
        this.userRepository = userRepository;
        this.resendConfirmationSvc = resendConfirmationSvc;
        this.tokenRepo = tokenRepo;
        this.actionsSvc = actionsSvc;
        this.helpRequestRepo = helpRequestRepo;
    }

    @RequestMapping("/api/localProfile/resendConfirmation")
    public ResponseEntity<String> resendConfirmation(
            @RequestParam("user") String username
    ) throws ApplicationException {
        User user = userRepository.findByUsername(username);
        if (null == user) throw new ApplicationException("User not found");
        resendConfirmationSvc.resendConfirmation(user);
        return ResponseEntity.ok("OK");
    }

    @RequestMapping("/api/proxyProfile/deleteUser")
    public ResponseEntity<String> deleteUser(
            @RequestParam("user") String username
    ) throws ApplicationException {
        User user = userRepository.findByUsername(username);
        if (null == user) throw new ApplicationException("User not found");

        List<OneTimeToken> tokens = tokenRepo.findByOwnerIs(user);
        for (OneTimeToken token : tokens) {
            tokenRepo.delete(token);
        }

        userRepository.delete(user);
        return ResponseEntity.ok("OK");
    }

    @RequestMapping("/api/proxyProfile/deleteRequest")
    public ResponseEntity<String> deleteRequest(
            @RequestParam("id") String requestID
    ) throws ApplicationException {
        HelpRequest request = helpRequestRepo.getOne(requestID);
        actionsSvc.delete(request);
        return ResponseEntity.ok("OK");
    }
}
