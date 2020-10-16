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

import org.healthship.dtos.UserSignupDTO;
import org.healthship.exceptions.EmailExistsException;
import org.healthship.exceptions.ReCaptchaException;
import org.healthship.models.FriendlyError;
import org.healthship.models.User;
import org.healthship.services.CaptchaServiceImpl;
import org.healthship.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class ShowUserRegCtrl {
    private static final Logger logger = LoggerFactory.getLogger(ShowUserRegCtrl.class);

    IUserService userService;
    CaptchaServiceImpl captchaService;

    public ShowUserRegCtrl(IUserService userService, CaptchaServiceImpl captchaService) {
        this.userService = userService;
        this.captchaService = captchaService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showUserReg(
            WebRequest request,
            Model model) {
        if (request.getParameterMap().containsKey("thanks")
                || request.getParameterMap().containsKey("confirmed")) {
            return "registrationConf";
        }
        UserSignupDTO userSignupDto = new UserSignupDTO();
        model.addAttribute("user", userSignupDto);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView postUserReg(
            @ModelAttribute("user") @Valid UserSignupDTO accountDto,
            BindingResult result,
            Errors errors,
            HttpServletRequest request
    ) {
        String response = request.getParameter("g-recaptcha-response");

        try {
            captchaService.processResponse(response);
        } catch (ReCaptchaException e) {
            logger.error(String.format(
                    "Registration for user '%s' failed due to captcha", accountDto.getUsername()
            ), e);
            return new ModelAndView("meta/friendlyError", "fe", new FriendlyError(
                    "It looks like you didn't pass the 'I'm not a Robot' test :(",
                    "try again", "/registration"
            ));
        }

        if (!passwordsMatch(accountDto)) {
            errors.rejectValue("password", "password", "Passwords do not match");
        }

        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        }

        try {
            User registered = createUserAccount(accountDto);
            logger.info(String.format("Successfully created new user %s", registered.getUsername()));
        } catch (EmailExistsException e) {
            return new ModelAndView("error", HttpStatus.BAD_REQUEST);
        }

        return new ModelAndView("redirect:/registration?thanks");
    }

    private boolean passwordsMatch(UserSignupDTO accountDto) {
        return accountDto.getPassword().equals(accountDto.getMatchingPassword());
    }

    private User createUserAccount(UserSignupDTO accountDto) throws EmailExistsException {
        return userService.registerUser(accountDto);
    }
}
