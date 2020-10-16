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

package org.healthship.configuration;

import org.healthship.exceptions.ApplicationException;
import org.healthship.models.LoginEvent;
import org.healthship.models.User;
import org.healthship.repos.LoginEventRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.ModAuthPubtkt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class HSAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(HSAuthenticationSuccessHandler.class);

    ModAuthPubtkt modAuthPubtkt;
    UserRepository userRepository;
    LoginEventRepo loginEventRepo;

    public HSAuthenticationSuccessHandler(ModAuthPubtkt modAuthPubtkt, UserRepository userRepository, LoginEventRepo loginEventRepo) {
        this.modAuthPubtkt = modAuthPubtkt;
        this.userRepository = userRepository;
        this.loginEventRepo = loginEventRepo;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication
    ) throws IOException, ServletException {

        try {
            final User currentUser = userRepository.findByUsername(authentication.getName());
            Cookie sso = new Cookie("healthship_sso", modAuthPubtkt.generateTicket(
                    currentUser
            ));
            sso.setHttpOnly(true);
            sso.setSecure(true);

            loginEventRepo.save(new LoginEvent(currentUser, request));

        } catch (ApplicationException e) {
            logger.error(String.format("Unable to add SSO token for user %s", authentication.getName()), e);
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
