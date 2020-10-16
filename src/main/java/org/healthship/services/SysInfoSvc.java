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

package org.healthship.services;

import org.healthship.models.UserType;
import org.healthship.models.internal.PingType;
import org.healthship.models.internal.SysInfo;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.PingRepo;
import org.healthship.repos.UserRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;

/*
    Holds values that should not regularly be queried
 */
@Service
public class SysInfoSvc {

    private UserRepository userRepository;
    private HelpRequestRepo helpRequestRepo;
    private PingRepo pingRepo;

    private SysInfo universities;
    private SysInfo students;
    private SysInfo clinicians;
    private SysInfo organisations;
    private SysInfo tasksTotal;
    private SysInfo tasksOpen;
    private SysInfo newUsers24h;
    private SysInfo emailPings24h;
    private SysInfo smsPings24h;

    public SysInfoSvc(UserRepository userRepository, HelpRequestRepo helpRequestRepo, PingRepo pingRepo) {
        this.userRepository = userRepository;
        this.helpRequestRepo = helpRequestRepo;
        this.pingRepo = pingRepo;
    }

    @PostConstruct
    @Scheduled(cron = "0 0,30 * * * *")
    public void runQueries() {
        universities = new SysInfo(String.format("%d",
                userRepository.findByEnabledTrueAndUserTypeIs(UserType.student)
                        .stream().map(s -> s.getUsername().split("@")[1])
                        .distinct().count())
        );
        students = new SysInfo(String.format("%d",
                userRepository.findByEnabledTrueAndUserTypeIs(UserType.student).size()
        ));
        clinicians = new SysInfo(String.format("%d",
                userRepository.findByEnabledTrueAndUserTypeIs(UserType.clinician).size()
        ));
        organisations = new SysInfo(String.format("%d",
                userRepository.findByEnabledTrueAndUserTypeIs(UserType.organisation).size()
        ));
        newUsers24h = new SysInfo(String.format("%d",
                userRepository.findByAcceptedTermsDTAfter(ZonedDateTime.now().minusDays(1)).size()
        ));
        tasksOpen = new SysInfo(String.format("%d",
                helpRequestRepo.findByVisibleTrueAndSelectedUserIsNullAndDateTimeFromIsAfter(
                        ZonedDateTime.now()
                ).size()
        ));
        tasksTotal = new SysInfo(String.format("%d",
                helpRequestRepo.findAll().size()
        ));
        emailPings24h = new SysInfo(String.format("%d",
                pingRepo.findByPingedDTAfter(ZonedDateTime.now().minusDays(1))
                        .stream().filter(s -> s.getPingType().equals(PingType.email))
                        .distinct().count()
        ));
        smsPings24h = new SysInfo(String.format("%d",
                pingRepo.findByPingedDTAfter(ZonedDateTime.now().minusDays(1))
                        .stream().filter(s -> s.getPingType().equals(PingType.sms))
                        .distinct().count()
        ));
    }

    public SysInfo getUniversities() {
        return universities;
    }

    public SysInfo getNewUsers24h() {
        return newUsers24h;
    }

    public SysInfo getStudents() {
        return students;
    }

    public SysInfo getClinicians() {
        return clinicians;
    }

    public SysInfo getOrganisations() {
        return organisations;
    }

    public SysInfo getTasksTotal() {
        return tasksTotal;
    }

    public SysInfo getTasksOpen() {
        return tasksOpen;
    }

    public SysInfo getEmailPings24h() {
        return emailPings24h;
    }

    public SysInfo getSMSPings24h() {
        return smsPings24h;
    }
}
