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

package org.healthship.controllers.web;

import org.healthship.dtos.SurveyDTO;
import org.healthship.exceptions.ApplicationException;
import org.healthship.models.User;
import org.healthship.repos.SurveyResponseRepo;
import org.healthship.repos.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SurveyCtrl {

    SurveyResponseRepo surveyResponseRepo;
    UserRepository userRepository;

    public SurveyCtrl(SurveyResponseRepo surveyResponseRepo, UserRepository userRepository) {
        this.surveyResponseRepo = surveyResponseRepo;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/survey", method = RequestMethod.GET)
    public String showSurvey(WebRequest request, Model model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());

        model.addAttribute("section", "survey");
        model.addAttribute("surveyDTO", new SurveyDTO());

        return "survey01";
    }

    @RequestMapping(value = "/survey", method = RequestMethod.POST)
    public ModelAndView postSurvey(
            @ModelAttribute @Valid SurveyDTO surveyDTO,
            BindingResult result,
            WebRequest request,
            Errors errors, Authentication authentication) throws ApplicationException {

        ModelAndView mav = new ModelAndView("request", "surveyDTO", surveyDTO);

        if (!result.hasErrors()) {
            throw new ApplicationException("Error processing request");
        }

        return mav;
    }

}
