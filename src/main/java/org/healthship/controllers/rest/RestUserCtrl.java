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

package org.healthship.controllers.rest;

import org.healthship.models.User;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestUserCtrl {
    private static final Logger logger = LoggerFactory.getLogger(RestUserCtrl.class);

    HelpRequestRepo eventRepository;
    UserRepository userRepository;

    public RestUserCtrl(
            HelpRequestRepo eventRepository,
            UserRepository userRepository
    ) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping("/api/private/users")
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
