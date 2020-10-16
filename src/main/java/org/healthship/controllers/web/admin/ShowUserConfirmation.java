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

package org.healthship.controllers.web.admin;

import org.healthship.exceptions.UnrecoverableException;
import org.healthship.models.FriendlyError;
import org.healthship.models.OneTimeToken;
import org.healthship.models.User;
import org.healthship.repos.OneTimeTokenRepo;
import org.healthship.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.time.ZonedDateTime;

@Controller
public class ShowUserConfirmation {
    private static final Logger logger = LoggerFactory.getLogger(ShowUserConfirmation.class);

    UserRepository userRepository;
    OneTimeTokenRepo tokenRepo;

    public ShowUserConfirmation(UserRepository userRepository, OneTimeTokenRepo tokenRepo) {
        this.userRepository = userRepository;
        this.tokenRepo = tokenRepo;
    }

    @RequestMapping(value = "/registration/confirm", method = RequestMethod.GET)
    public ModelAndView confirmUser(
            @RequestParam("email") String username,
            @RequestParam("confirm") String confirmationID,
            WebRequest request,
            ModelAndView mav
    ) {
        // default to error
        mav.setViewName("error");
        mav.setStatus(HttpStatus.BAD_REQUEST);

        if (!tokenRepo.existsById(confirmationID)) {
            logger.error(String.format("ID %s does not exist in database", confirmationID));
            return new ModelAndView(
                    "meta/friendlyError",
                    "fe",
                    new FriendlyError("It looks like your account might already be confirmed: please try to log in")
            );
        }

        OneTimeToken token = tokenRepo.getOne(confirmationID);
        if (!token.getOwner().getUsername().equalsIgnoreCase(username)) {
            logger.error(String.format("Username '%s' does not match '%s'",
                    token.getOwner().getUsername(), username));
            return mav;
        }
        else if (token.getDateTime().isBefore(ZonedDateTime.now().minusDays(1))) {
            logger.error("Code has expired");
            return new ModelAndView(
                    "meta/friendlyError",
                    "fe",
                    new FriendlyError("It looks like your confirmation code has expired", "resend", "/registration/?resend-confirmation")
            );
        }

        validateUser(token);
        return new ModelAndView("redirect:/registration-confirmed");
    }

    private void validateUser(OneTimeToken token) {
        User u = userRepository.findByUsername(token.getOwner().getUsername());
        if (null == u) {
            throw new UnrecoverableException("Unable to find user");
        }

        u.withEnabled(true);
        logger.debug("Updating user: setting user to 'active'");
        userRepository.save(u);
        logger.debug("Removing ID from OneTimeToken table");
        tokenRepo.delete(token);
    }

}
