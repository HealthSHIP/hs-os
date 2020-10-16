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

import org.apache.tika.Tika;
import org.healthship.exceptions.ApplicationException;
import org.healthship.models.*;
import org.healthship.repos.AvatarRepo;
import org.healthship.repos.UserRepository;
import org.healthship.repos.VouchRequestRepo;
import org.healthship.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;

@RestController
public class RestUI {
    private static final Logger logger = LoggerFactory.getLogger(RestUI.class);

    UserRepository userRepository;
    ResendConfirmationSvc resendConfirmationSvc;
    VouchRequestRepo vouchRequestRepo;
    EmailServiceImpl emailServiceImpl;
    ModAuthPubtkt modAuthPubtkt;
    AvatarRepo avatarRepo;
    ImageService imageService;
    SPBE5Service spbe5Service;

    public RestUI(
            UserRepository userRepository,
            ResendConfirmationSvc resendConfirmationSvc,
            VouchRequestRepo vouchRequestRepo,
            EmailServiceImpl emailServiceImpl,
            ModAuthPubtkt modAuthPubtkt,
            AvatarRepo avatarRepo,
            ImageService imageService,
            SPBE5Service spbe5Service
    ) {
        this.userRepository = userRepository;
        this.resendConfirmationSvc = resendConfirmationSvc;
        this.vouchRequestRepo = vouchRequestRepo;
        this.emailServiceImpl = emailServiceImpl;
        this.modAuthPubtkt = modAuthPubtkt;
        this.avatarRepo = avatarRepo;
        this.imageService = imageService;
        this.spbe5Service = spbe5Service;
    }

    @RequestMapping(value = "/api/avatars/{encUserID}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(
            @PathVariable("encUserID") String encUserID,
            Authentication authentication
    ) {
        // Why are we using the encrypted user ID? So that users can't look up each other's profile photos ...
        final User currentUser = userRepository.findByUsername(spbe5Service.decrypt(encUserID));
        Avatar a = avatarRepo.findById(currentUser.getUsername()).orElse(Avatar.getDefault());

        Tika tika = new Tika();
        String mimeType = tika.detect(a.getImage());

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(mimeType))
                .body(a.getImage());
    }

    @RequestMapping(value = "/api/avatars", method = RequestMethod.POST)
    public ResponseEntity<String> postAvatar(
            @RequestParam("avatar") MultipartFile file,
            Authentication authentication
    ) {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        if (null != file && !file.isEmpty()) {
            try {
                avatarRepo.save(new Avatar(currentUser, imageService.compress(file.getBytes())));
                logger.debug("Saved profile photo update for user " + currentUser.getUsername());
            } catch (IOException | ApplicationException e) {
                logger.error(String.format("Unable to save avatar for user %s", currentUser.getUsername()), e);
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/api/private")
    @Transactional
    public ResponseEntity<String> uiPrivate(
            @RequestParam(value = "action") final String action,
            @RequestParam(value = "value", required = false) final String value,
            HttpSession session,
            Authentication authentication
    ) throws ApplicationException {
        final User currentUser = userRepository.findByUsername(authentication.getName());

        if (action.equalsIgnoreCase("dismiss-pvg")) {
            session.setAttribute("dismiss-pvg", true);
        }

        if (action.equalsIgnoreCase("sso")) {
            return ResponseEntity.ok().header("sso-token", modAuthPubtkt.generateTicket(currentUser)).build();
        }

        // 0 = no user by that address
        // 1 = yep user exists
        // 2 = already vouched
        // 4 = isn't a clinician
        // 5 = is the same user
        if (action.equalsIgnoreCase("vouch-request")) {
            // need to be a bit careful here - we don't want users getting
            // pissy at each other ... ONLY send back false if the user can't be found
            final User clinician = userRepository.findByUsername(value);
            if (null == clinician) return ResponseEntity.ok("0");
            if (!clinician.getUserType().equals(UserType.clinician)) return ResponseEntity.ok("4");
            if (clinician.equals(currentUser)) return ResponseEntity.ok("5");
            if (currentUser.getVouchedBy().contains(clinician)) return ResponseEntity.ok("2");

            // now check requests - if one already exists (in any state) just return 1
            if (null == vouchRequestRepo.findByClinicianEqualsAndVolunteerEquals(clinician, currentUser)) {
                vouchRequestRepo.save(new VouchRequest(clinician, currentUser));
                emailServiceImpl.sendManualVouchRequest(clinician, currentUser);
            }
            return ResponseEntity.ok("1");
        }

        if (action.equalsIgnoreCase("vouch-response-accept")) {
            User acceptedVolunteer = userRepository.findByUsername(value);
            // not able to find anyone, just return false to AJAX call
            if (null == acceptedVolunteer) return ResponseEntity.ok("false");

            if (null == vouchRequestRepo.findByClinicianEqualsAndVolunteerEquals(currentUser, acceptedVolunteer)) {
                // request doesn't exist
                return ResponseEntity.ok("false");
            }

            VouchRequest vr = vouchRequestRepo.findByClinicianEqualsAndVolunteerEquals(currentUser, acceptedVolunteer);
            if (!vr.getState().equals(VouchState.PENDING)) {
                return ResponseEntity.ok("already-processed");
            }

            vouchRequestRepo.save(vr.setState(VouchState.ACCEPTED));
            userRepository.save(acceptedVolunteer.addVouchedBy(currentUser));
            return ResponseEntity.ok("true");
        }

        if (action.equalsIgnoreCase("vouch-response-reject")) {
            User rejectedVolunteer = userRepository.findByUsername(value);
            // not able to find anyone, just return false to AJAX call
            if (null == rejectedVolunteer) return ResponseEntity.ok("false");

            if (null == vouchRequestRepo.findByClinicianEqualsAndVolunteerEquals(currentUser, rejectedVolunteer)) {
                // request doesn't exist
                return ResponseEntity.ok("false");
            }

            VouchRequest vr = vouchRequestRepo.findByClinicianEqualsAndVolunteerEquals(currentUser, rejectedVolunteer);
            if (!vr.getState().equals(VouchState.PENDING)) {
                return ResponseEntity.ok("already-processed");
            }

            vouchRequestRepo.save(vr.setState(VouchState.REJECTED));
            return ResponseEntity.ok("true");
        }

        return ResponseEntity.ok("true");
    }

    @RequestMapping(value = "/api/public")
    public ResponseEntity<String> uiPublic(
            @RequestParam(value = "action") final String action,
            @RequestParam(value = "value", required = false) final String value
    ) {
        if (action.equalsIgnoreCase("userExists")) {
            boolean exists = (null != userRepository.findByUsername(value));
            return ResponseEntity.ok(Boolean.toString(exists));
        }

        return ResponseEntity.ok().build();
    }
}
