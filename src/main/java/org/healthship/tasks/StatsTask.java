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

package org.healthship.tasks;

import org.healthship.models.rest.SlackRequest;
import org.healthship.models.rest.slack.ChannelRecipient;
import org.healthship.services.SlackService;
import org.healthship.services.SysInfoSvc;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@Profile("gcp")
public class StatsTask {

    SlackService slackService;
    SysInfoSvc infoSvc;

    public StatsTask(SlackService slackService, SysInfoSvc infoSvc) {
        this.slackService = slackService;
        this.infoSvc = infoSvc;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void runStats() {
        StringBuilder sb = new StringBuilder(String.format("Latest stats at %s: %n", ZonedDateTime.now()));
        sb.append(String.format("Universities: %s%n", infoSvc.getUniversities()));
        sb.append(String.format("Students: %s%n", infoSvc.getStudents()));
        sb.append(String.format("Clinicians: %s%n", infoSvc.getClinicians()));
        sb.append(String.format("Organisations: %s%n", infoSvc.getOrganisations()));
        sb.append(String.format("New users (24h): %s%n", infoSvc.getNewUsers24h()));
        sb.append(String.format("Tasks (open): %s%n", infoSvc.getTasksOpen()));
        sb.append(String.format("Tasks (total): %s%n", infoSvc.getTasksTotal()));
        sb.append(String.format("Emails outbound: %s%n", infoSvc.getEmailPings24h()));
        sb.append(String.format("Texts outbound: %s%n", infoSvc.getSMSPings24h()));
        sb.append("NB: Some stats are cached / delayed by 30 min");

        slackService.slackRequest(
                new SlackRequest(new ChannelRecipient("stats"))
                    .setText(sb.toString())
        );
    }
}
