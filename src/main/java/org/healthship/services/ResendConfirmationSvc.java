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

import org.healthship.exceptions.ApplicationException;
import org.healthship.models.OneTimeToken;
import org.healthship.models.User;
import org.healthship.models.internal.HSHTMLEmail;
import org.healthship.models.internal.TokenType;
import org.healthship.repos.OneTimeTokenRepo;
import org.healthship.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ResendConfirmationSvc {
    private static final Logger logger = LoggerFactory.getLogger(ResendConfirmationSvc.class);

    @Value("${base-url}")
    String baseURL;

    UserRepository userRepository;
    OneTimeTokenRepo tokenRepo;
    EmailSenderSvc emailSenderSvc;

    public ResendConfirmationSvc(UserRepository userRepository, OneTimeTokenRepo tokenRepo, EmailSenderSvc emailSenderSvc) {
        this.userRepository = userRepository;
        this.tokenRepo = tokenRepo;
        this.emailSenderSvc = emailSenderSvc;
    }

    public void resendConfirmation(User user) {
        if (!user.getEnabled()) {
            OneTimeToken token = tokenRepo.save(new OneTimeToken(user).setTokenType(TokenType.registration));

            final String confStr = String.format("registration/confirm?email=%s&confirm=%s", token.getOwner().getUsername(), token.getId());
            final String confHref = String.format("%s/%s", baseURL, confStr);

            try {
                emailSenderSvc.sendEmail(user.getUsername(), "Please confirm your account", new HSHTMLEmail(
                        "Hey!",
                        "It looks like the internet pixies got a little cross with us earlier, " +
                                "and stopped us from sending through your confirmation email.",
                        "All our ducks are now back in a row: you should be able to confirm your identity below.",
                        confHref, "confirm account"
                ), null);
            } catch (ApplicationException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

}
