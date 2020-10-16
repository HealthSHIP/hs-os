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

import org.healthship.dtos.admin.EditUserDTO;
import org.healthship.dtos.admin.ManuallyCreateUserDTO;
import org.healthship.exceptions.ApplicationException;
import org.healthship.exceptions.HSSecurityException;
import org.healthship.models.FriendlyError;
import org.healthship.models.User;
import org.healthship.repos.UserRepository;
import org.healthship.services.ResetPasswordService;
import org.healthship.services.Utils;
import org.healthship.tasks.StatsTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.ZonedDateTime;

@Controller
public class AdminFunctions {
    private static final Logger logger = LoggerFactory.getLogger(AdminFunctions.class);

    private UserRepository userRepository;
    private ResetPasswordService resetPasswordService;

    @Autowired(required = false)
    private StatsTask statsTask;

    public AdminFunctions(
            UserRepository userRepository,
            ResetPasswordService resetPasswordService
    ) {
        this.userRepository = userRepository;
        this.resetPasswordService = resetPasswordService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showAdmin(WebRequest request, Model model, Authentication authentication) throws HSSecurityException {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        if (!Utils.isAdmin(currentUser)) {
            throw new HSSecurityException(String.format("User %s attempted to access admin functions", currentUser.getUsername()));
        }

        model.addAttribute("section", "adminFunctions");
        return "admin/index";
    }

    @RequestMapping(value = "/admin/editUser", method = RequestMethod.GET)
    public ModelAndView showEditUser(
            WebRequest request,
            ModelAndView model,
            Authentication authentication,
            @RequestParam("username") String username
    ) throws HSSecurityException {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        if (!Utils.isAdmin(currentUser)) {
            throw new HSSecurityException(String.format("User %s attempted to access edit user functions", currentUser.getUsername()));
        }

        User userToEdit = userRepository.findByUsername(username);
        if (null == userToEdit) {
            return new ModelAndView("meta/friendlyError", "fe", new FriendlyError(
                    "User was not found", "go back", "/admin"
            ));
        }

        model.addObject("section", "editUser");
        model.addObject("user", new EditUserDTO(userToEdit));
        model.setViewName("admin/editUser");
        return model;
    }

    @RequestMapping(value = "/admin/editUser", method = RequestMethod.POST)
    @Transactional
    public ModelAndView postEditUser(
            @Valid @ModelAttribute EditUserDTO editUserDTO,
            BindingResult result,
            Model model,
            Errors errors,
            HttpServletRequest request,
            Authentication authentication
    ) throws ApplicationException {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        if (!Utils.isAdmin(currentUser)) {
            throw new HSSecurityException(String.format("User %s attempted to edit a user", currentUser.getUsername()));
        }

        ModelAndView mav = new ModelAndView("admin/editUser", "user", editUserDTO);
        mav.addObject("section", "editUser");

        User userToEdit = userRepository.findByUsername(editUserDTO.getUsername());
        if (null == userToEdit) {
            errors.rejectValue("username", "username", "That user does not exist");
        }

        if (result.hasErrors()) {
            return mav;
        }

        if (null == userToEdit) throw new ApplicationException("Shouldn't have reached here");

        // everything looks good, let's update the user ...
        userRepository.save(userToEdit.withUpdate(editUserDTO));

        return new ModelAndView("redirect:/admin?editedUser");
    }

    @RequestMapping(value = "/admin/createUser", method = RequestMethod.GET)
    public String showManualCreateUser(WebRequest request, Model model, Authentication authentication) throws HSSecurityException {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        if (!Utils.isAdmin(currentUser)) {
            throw new HSSecurityException(String.format("User %s attempted to access admin functions", currentUser.getUsername()));
        }

        model.addAttribute("section", "manuallyCreateUser");
        model.addAttribute("createUserForm", new ManuallyCreateUserDTO());
        return "admin/createUser";
    }

    @RequestMapping(value = "/admin/createUser", method = RequestMethod.POST)
    @Transactional
    public ModelAndView postManualCreateUser(
            @Valid @ModelAttribute ManuallyCreateUserDTO manualCreateUser,
            BindingResult result,
            Model model,
            Errors errors,
            HttpServletRequest request,
            Authentication authentication
    ) throws HSSecurityException {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        if (!Utils.isAdmin(currentUser)) {
            throw new HSSecurityException(String.format("User %s attempted to create a user", currentUser.getUsername()));
        }

        ModelAndView mav = new ModelAndView("admin/createUser", "createUserForm", manualCreateUser);
        mav.addObject("section", "manuallyCreateUser");

        // check user doesn't exist already
        if (null != userRepository.findByUsername(manualCreateUser.getUsername())) {
            errors.rejectValue("username", "username", "That user already exists");
        }

        if (result.hasErrors()) {
            return mav;
        }

        User user = new User()
                .withUsername(manualCreateUser.getUsername().toLowerCase())
                .withPVGVerified(manualCreateUser.getHasPVG())
                .withEnabled(true)
                .withAcceptedTerms(true)
                .withUserType(manualCreateUser.getUserType())
                .withAcceptedTermsDT(ZonedDateTime.now());

        logger.info(String.format("Manually creating user '%s'", user.getUsername()));
        userRepository.saveAndFlush(user);

        try {
            resetPasswordService.resetPassword(user, true);
        } catch (ApplicationException e) {
            return new ModelAndView("meta/friendlyError", "fe", new FriendlyError(
                    String.format("Error: %s", e.getMessage())
            ));
        }

        return new ModelAndView("redirect:/admin?createdUser");
    }

    @RequestMapping(value = "/admin/runStats", method = RequestMethod.GET)
    public String runStats(WebRequest request, Model model, Authentication authentication) throws HSSecurityException {
        final User currentUser = userRepository.findByUsername(authentication.getName());
        if (!Utils.isAdmin(currentUser)) {
            throw new HSSecurityException(String.format("User %s attempted to access admin functions", currentUser.getUsername()));
        }
        if (null != statsTask) {
            statsTask.runStats();
        }
        else {
            logger.warn("Stats task object null, not running stats");
        }
        return "redirect:/";
    }
}
