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

import org.healthship.dtos.ContactDTO;
import org.healthship.exceptions.ApplicationException;
import org.healthship.services.JiraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ContactCtrl {

    JiraService jiraService;

    public ContactCtrl(JiraService jiraService) {
        this.jiraService = jiraService;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView showContact(
            Model model
    ) {
        ModelAndView np = new ModelAndView("contact");
        np.addObject("section", "contact");
        np.addObject("contactForm", new ContactDTO());
        return np;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ModelAndView postContact(
            @Valid @ModelAttribute ContactDTO contactDTO,
            BindingResult result,
            Model model,
            Errors errors
    ) throws ApplicationException {
        ModelAndView mav = new ModelAndView("contact", "contactForm", contactDTO);
        mav.addObject("section", "contact");

        if (result.hasErrors()) {
            return mav;
        }

        switch (contactDTO.getCategory()) {
            case BUG_REPORT:
                jiraService.createBugReport(
                        String.format("%s (%s)", contactDTO.getEmail(), contactDTO.getName()),
                        "Bug report from contact form", contactDTO.getDescription()
                );
                break;
            case ACCOUNT_ISSUE:
                jiraService.createAccountManagementTask(
                        String.format("%s (%s)", contactDTO.getEmail(), contactDTO.getName()),
                        "Account help required (submitted from contact form)", contactDTO.getDescription()
                );
                break;
            case ADMIN:
                jiraService.createAccountManagementTask(
                        String.format("%s (%s)", contactDTO.getEmail(), contactDTO.getName()),
                        "Admin help required (submitted from contact form)", contactDTO.getDescription()
                );
                break;
            case FEEDBACK: // just whack them all into feedback
            case OTHER:
                jiraService.createFeedback(
                        String.format("%s (%s)", contactDTO.getEmail(), contactDTO.getName()),
                        "Site feedback (submitted from contact form)", contactDTO.getDescription()
                );
                break;
        }

        return new ModelAndView("redirect:/contact/confirmed");
    }
}
