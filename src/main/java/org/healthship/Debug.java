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

package org.healthship;

import org.healthship.models.*;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.ShortCodesRepo;
import org.healthship.repos.UserRepository;
import org.healthship.repos.VouchRequestRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;
import java.util.UUID;

@Configuration
@Profile("debug")
public class Debug {

    private static final Logger logger = LoggerFactory.getLogger(Debug.class);

    private static final String DEMO_CLINICIAN_01 = "student@example.net";
    private static final String DEMO_CLINICIAN_02 = "healthcare-worker-02@example.net";
    private static final String DEMO_CLINICIAN_03 = "healthcare-worker-03@example.net";
    private static final String DEMO_VOLUNTEER = "volunteer@example.net";
    private static final String DEMO_PASSWORDS = "demo";

    UserRepository userRepository;
    HelpRequestRepo helpRequestRepo;
    VouchRequestRepo vouchRequestRepo;
    ShortCodesRepo shortCodesRepo;

    public Debug(UserRepository userRepository, HelpRequestRepo helpRequestRepo, VouchRequestRepo vouchRequestRepo, ShortCodesRepo shortCodesRepo) {
        this.userRepository = userRepository;
        this.helpRequestRepo = helpRequestRepo;
        this.vouchRequestRepo = vouchRequestRepo;
        this.shortCodesRepo = shortCodesRepo;
    }

    @PostConstruct
    public void postConstruct() {
        User student = userRepository.findByUsername(DEMO_VOLUNTEER);
        User clinician = userRepository.findByUsername(DEMO_CLINICIAN_01);

        if (null == student) {
            logger.info("Student object is null, creating new student user");
            userRepository.saveAndFlush(new User()
                    .withUsername(DEMO_VOLUNTEER)
                    .withName("Stu A. Dent")
                    .withIntroduction("Hey! I'm a healthcare student currently studying in Dundee. I'm originally from " +
                            "West Yorkshire. I have a younger brother and I wish I had a pet goat (as well); " +
                            "they're the best animals ever.")
                    .withLat(56.12f)
                    .withLng(-3.23f)
                    .withLocation("Kircaldy 02")
                    .setSmsUpdates(true)
                    .withPVGVerified(true)
                    .withEnabled(true)
                    .withUserType(UserType.student)
                    .withPassword(new BCryptPasswordEncoder().encode(DEMO_PASSWORDS))
                    .withPhone("07772351655")
            );
        }

        if (null == clinician) {
            logger.info("Clinician object is null, creating new student user");
            userRepository.saveAndFlush(new User()
                    .withUsername(DEMO_CLINICIAN_01)
                    .withName("Ms Healthcare Demo")
                    .withIntroduction("Here's a short introduction about myself. I quite like dogs and cats (though the latter " +
                            "can be a bit less friendly).")
                    .withEnabled(true)
                    .withLat(56.39f)
                    .withLng(-3.52f)
                    .withLocation("Perth")
                    .withPVGVerified(true)
                    .withUserType(UserType.clinician)
                    .withPassword(new BCryptPasswordEncoder().encode(DEMO_PASSWORDS))
            );
        }

        userRepository.saveAndFlush(new User()
                .withUsername("org@example.org.uk")
                .withName("Example Org")
                .withEnabled(true)
                .withPVGVerified(false)
                .withUserType(UserType.organisation)
                .withPassword(new BCryptPasswordEncoder().encode(DEMO_PASSWORDS))
        );

        // add another user or two
        userRepository.saveAndFlush(new User()
                .withUsername(DEMO_CLINICIAN_02)
                .withName("Mr Demo Two")
                .withIntroduction("I'm actually not a real person, believe it or not.")
                .withEnabled(true)
                .withLat(56.07f)
                .withLng(-3.47f)
                .withLocation("Dunfermline")
                .withPVGVerified(true)
                .withUserType(UserType.clinician)
                .withPassword(new BCryptPasswordEncoder().encode(DEMO_PASSWORDS))
        );

        User user03 = userRepository.saveAndFlush(new User()
                .withUsername(DEMO_CLINICIAN_03)
                .withName("Dr Demo Three")
                .withIntroduction("I'm not a real person either'.")
                .withEnabled(true)
                .withLat(56.11f)
                .withLng(-3.24f)
                .withLocation("Kircaldy")
                .withPVGVerified(true)
                .withUserType(UserType.clinician)
                .withPassword(new BCryptPasswordEncoder().encode(DEMO_PASSWORDS))
        );

        createTask(
                ZonedDateTime.now().plusHours(1),
                userRepository.findByUsername(DEMO_CLINICIAN_02),
                "Help picking up the groceries"
        );

        HelpRequest hr = createTask(
                ZonedDateTime.now().plusDays(1),
                userRepository.findByUsername(DEMO_CLINICIAN_03),
                "My husband and I are both called into work this morning and have nobody " +
                        "to cover us, is someone free to stay with the kids in the morning " +
                        "and then drop them off at school?"
        )
                .setInstructions("Custom instructions (private)")
                .setDestination("destination location")
                .setDestinationLng(54.30f)
                .setDestinationLat(-3.14f);
        helpRequestRepo.save(hr);
        shortCodesRepo.save(new ShortCode("ABC123", user03, hr));

        vouchRequestRepo.save(new VouchRequest(userRepository.findByUsername(DEMO_CLINICIAN_01), userRepository.findByUsername(DEMO_VOLUNTEER)));
    }

    private HelpRequest createTask(ZonedDateTime startDT, User user, String description) {
        return new HelpRequest(user)
                        .setId(UUID.randomUUID().toString())
                        .setCreatedBy(user)
                        .setRequiresPVG(false)
                        .setVisible(true)
                        .setAutoAccept(false)
                        .setCreatedDateTime(ZonedDateTime.now())
                        .setDateTimeFrom(startDT)
                        .setDateTimeTo(startDT.plusHours(1))
                        .setDescription(description)
                        .setOrigin("origin location")
                        .setOriginLat(user.getLat())
                        .setOriginLng(user.getLng());
    }
}
