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

package org.healthship.services;

import org.healthship.dtos.UserSignupDTO;
import org.healthship.exceptions.ApplicationException;
import org.healthship.exceptions.EmailExistsException;
import org.healthship.models.OneTimeToken;
import org.healthship.models.User;
import org.healthship.models.UserType;
import org.healthship.models.internal.HSHTMLEmail;
import org.healthship.models.internal.TokenType;
import org.healthship.repos.OneTimeTokenRepo;
import org.healthship.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;

@Service
public class UserServiceImpl implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Value("${base-url}")
    String baseURL;

    UserRepository userRepo;
    OneTimeTokenRepo tokenRepo;
    EmailSenderSvc emailService;

    public UserServiceImpl(UserRepository userRepo, OneTimeTokenRepo tokenRepo, EmailSenderSvc emailService) {
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
        this.emailService = emailService;
    }

    @Transactional
    @Override
    public User registerUser(UserSignupDTO userSignupDTO)
            throws EmailExistsException {

        if (userExists(userSignupDTO.getUsername())) {
            throw new EmailExistsException("There is already an account with that address");
        }

        User user = new User()
                .withUsername(userSignupDTO.getUsername().toLowerCase())
                .withPassword(new BCryptPasswordEncoder().encode(userSignupDTO.getPassword()))
                .withUserType(UserType.valueOf(userSignupDTO.getUserType()))
                .withPVGVerified(userSignupDTO.getHasPVG())
                .withAcceptedTerms(userSignupDTO.getHasReadTerms())
                .withAcceptedTermsDT(ZonedDateTime.now())
                .withEnabled(false);

        User savedUser = userRepo.saveAndFlush(user);
        messageUserConfirmation(tokenRepo.save(new OneTimeToken(savedUser).setTokenType(TokenType.registration)));

        return savedUser;
    }

    private boolean userExists(String username) {
        User user = userRepo.findByUsername(username);
        return user != null;
    }

    public void messageUserConfirmation(OneTimeToken token) {
        final String confStr = String.format("registration/confirm?email=%s&confirm=%s", token.getOwner().getUsername(), token.getId());
        final String confHref = String.format("%s/%s", baseURL, confStr);
        try {
            emailService.sendEmail(token.getOwner().getUsername(), "Confirm your account", new HSHTMLEmail(
                    "Hey there!", "Welcome to HealthSHIP", "Before you can log in, we need to " +
                    "validate your account",
                    confHref, "Validate"
            ), null);
        } catch (ApplicationException e) {
            logger.error(String.format("Unable to send user confirmation email to user %s", token.getOwner().getUsername()), e);
        }
    }
}