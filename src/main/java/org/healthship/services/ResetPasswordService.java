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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class ResetPasswordService {

    @Value("${base-url}")
    String baseURL;

    EmailSenderSvc emailService;
    UserRepository userRepository;
    ResendConfirmationSvc resendConfirmationSvc;
    OneTimeTokenRepo tokenRepo;

    public ResetPasswordService(EmailSenderSvc emailService, UserRepository userRepository, OneTimeTokenRepo tokenRepo, ResendConfirmationSvc resendConfirmationSvc) {
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.tokenRepo = tokenRepo;
        this.resendConfirmationSvc = resendConfirmationSvc;
    }

    /**
     * NB user may not exist
     * @param user The username to reset password for
     */
    public void resetPassword(User user, boolean isManuallyCreated) throws ApplicationException {
        resetPassword(user.getUsername(), isManuallyCreated);
    }

    public void resetPassword(String username) throws ApplicationException {
        resetPassword(username, false);
    }

    public void resetPassword(String username, boolean isManuallyCreated) throws ApplicationException {
        final User user = userRepository.findByUsername(username);

        if (null != user) {
            if (!user.getEnabled()) {
                resendConfirmationSvc.resendConfirmation(user);
                return;
            }

            // generate conf
            OneTimeToken token = new OneTimeToken(user).setTokenType(TokenType.reset_password);
            tokenRepo.save(token);

            if (isManuallyCreated) {
                emailService.sendEmail(user, "Welcome to HealthSHIP", new HSHTMLEmail(
                        "Hey there!",
                        "We've manually created an account for you.",
                        "However, you need to now set a password.",
                        String.format("%s/set-password/?user=%s&auth=%s", baseURL, token.getOwner().getUsername(), token.getId()),
                        "set a new password"
                ), null);
            }
            else {
                emailService.sendEmail(user, "It looks like you're having trouble logging in", new HSHTMLEmail(
                        "Hey there!",
                        "It seems like you can't get onto our site right now.",
                        "If this wasn't you, don't worry - just ignore this message.",
                        String.format("%s/set-password/?user=%s&auth=%s", baseURL, token.getOwner().getUsername(), token.getId()),
                        "set a new password"
                ), null);
            }

        }
    }

    public boolean isValidLink(String user, String auth) {
        if (tokenRepo.existsById(auth)
                && null != userRepository.findByUsername(user)
                && tokenRepo.getOne(auth).getDateTime().isAfter(ZonedDateTime.now().minusMinutes(10L))
        ) {
            return true;
        }
        return false;
    }

    public void cleanup(String token) {
        tokenRepo.deleteById(token);
    }
}
