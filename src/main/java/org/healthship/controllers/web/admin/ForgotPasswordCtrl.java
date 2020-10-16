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

import org.healthship.dtos.ForgotPasswordDTO;
import org.healthship.exceptions.ApplicationException;
import org.healthship.exceptions.ReCaptchaException;
import org.healthship.models.FriendlyError;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.ICaptchaService;
import org.healthship.services.ResetPasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ForgotPasswordCtrl {
    private static final Logger logger = LoggerFactory.getLogger(ForgotPasswordCtrl.class);

    private HelpRequestRepo eventRepository;
    private UserRepository userRepository;
    private ResetPasswordService resetPasswordService;
    private ICaptchaService captchaService;

    public ForgotPasswordCtrl(HelpRequestRepo eventRepository, UserRepository userRepository, ResetPasswordService resetPasswordService, ICaptchaService iCaptchaService) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.resetPasswordService = resetPasswordService;
        this.captchaService = iCaptchaService;
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
    public String showForgotPassword(WebRequest request, Model model) {
        model.addAttribute("section", "forgotPassword");
        model.addAttribute("fpForm", new ForgotPasswordDTO());
        return "forgotPassword";
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public ModelAndView postForgotPassword(
            @Valid @ModelAttribute ForgotPasswordDTO forgotPasswordDTO,
            BindingResult result,
            Model model,
            Errors errors,
            HttpServletRequest request
    ) {
        ModelAndView mav = new ModelAndView("forgotPassword", "fpForm", forgotPasswordDTO);
        mav.addObject("section", "forgotPassword");
        String response = request.getParameter("g-recaptcha-response");

        try {
            captchaService.processResponse(response);
        } catch (ReCaptchaException e) {
            logger.error(String.format(
                    "Reset password for user '%s' - %s", forgotPasswordDTO.getUsername(), e.getMessage()
            ), e);
            return new ModelAndView("meta/friendlyError", "fe", new FriendlyError(
                    "It looks like you didn't pass the 'I'm not a Robot' test :(",
                    "try again", "/forgot-password"
            ));
        }

        if (result.hasErrors()) {
            return mav;
        }

        try {
            resetPasswordService.resetPassword(forgotPasswordDTO.getUsername());
        } catch (ApplicationException e) {
            logger.error(String.format(
                    "Reset password for user '%s' - %s", forgotPasswordDTO.getUsername(), e.getMessage()
            ), e);
            return new ModelAndView("meta/friendlyError", "fe", new FriendlyError(
                    "It looks like we're not able to send your email right now. Try again in a few " +
                            "minutes or reach out to us for help.",
                    "contact us", "/contact"
            ));
        }
        return new ModelAndView("redirect:/forgot-password?done");
    }
}
