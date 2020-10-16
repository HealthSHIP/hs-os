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

import org.healthship.dtos.SetPasswordDTO;
import org.healthship.exceptions.ApplicationException;
import org.healthship.models.FriendlyError;
import org.healthship.models.User;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.ResetPasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class NewPasswordCtrl {
    private static final Logger logger = LoggerFactory.getLogger(NewPasswordCtrl.class);

    HelpRequestRepo eventRepository;
    UserRepository userRepository;
    ResetPasswordService resetPasswordService;

    public NewPasswordCtrl(HelpRequestRepo eventRepository, UserRepository userRepository, ResetPasswordService resetPasswordService) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.resetPasswordService = resetPasswordService;
    }

    @RequestMapping(value = "/set-password", method = RequestMethod.GET)
    public ModelAndView showNewPassword(
            @RequestParam("user") String user,
            @RequestParam("auth") String auth,
            Model model
    ) {
        if (!resetPasswordService.isValidLink(user, auth)) {
            return new ModelAndView(
                    "meta/friendlyError",
                    "fe",
                    new FriendlyError("It looks like the link you tried to use is no longer valid :(",
                        "request another link", "/forgot-password"
                    )
            );
        }

        ModelAndView np = new ModelAndView("setPassword");
        np.addObject("section", "setPassword");
        np.addObject("spForm", new SetPasswordDTO(user, auth));
        return np;
    }

    @RequestMapping(value = "/set-password", method = RequestMethod.POST)
    public ModelAndView postNewPassword(
            @Valid @ModelAttribute SetPasswordDTO setPasswordDTO,
            BindingResult result,
            Model model,
            Errors errors
    ) throws ApplicationException {
        if (!resetPasswordService.isValidLink(setPasswordDTO.getUsername(), setPasswordDTO.getToken())) {
            throw new ApplicationException("Invalid password reset link");
        }

        ModelAndView mav = new ModelAndView("setPassword", "spForm", setPasswordDTO);
        mav.addObject("section", "setPassword");

        if (!setPasswordDTO.getPassword().equals(setPasswordDTO.getConfirmPassword())) {
            errors.rejectValue("password", "password", "Passwords do not match");
        }

        if (result.hasErrors()) {
            return mav;
        }

        // password is valid
        User user = userRepository.findByUsername(setPasswordDTO.getUsername())
                .withPassword(new BCryptPasswordEncoder().encode(setPasswordDTO.getPassword()));
        userRepository.saveAndFlush(user);
        resetPasswordService.cleanup(setPasswordDTO.getToken());
        logger.info("Reset password for user " + user.getUsername());

        return new ModelAndView("redirect:/login?reset");
    }
}
