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

import org.healthship.models.HelpRequest;
import org.healthship.models.internal.Ping;
import org.healthship.models.internal.PingType;
import org.healthship.models.rest.SlackRequest;
import org.healthship.models.rest.slack.ChannelRecipient;
import org.healthship.repos.PingRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.time.ZonedDateTime;

@Service
public class SlackServiceImpl implements SlackService {
    private static final Logger logger = LoggerFactory.getLogger(SlackServiceImpl.class);

    @Value("${slack.dev-uri}")
    URI slackDevURI;

    @Value("${base-url}")
    String baseURL;

    RestOperations restOperations;
    PingRepo pingRepo;

    public SlackServiceImpl(RestOperations restOperations, PingRepo pingRepo) {
        this.restOperations = restOperations;
        this.pingRepo = pingRepo;
    }

    @Override
    public void slackRequest(SlackRequest slackRequest) {
        logger.info("Posted stats to Slack, got response: {}", restOperations.postForObject(slackDevURI, slackRequest, String.class));
    }

    @Override
    public void noMoreUsers(HelpRequest helpRequest) {
        if (pingRepo.existsByHelpRequestAndPingedDTAfterAndPingType(
                helpRequest, ZonedDateTime.now().minusDays(1), PingType.slack_warn)
        ) {
            // Only message slack every 24hrs
            return;
        }

        SlackRequest request = new SlackRequest(new ChannelRecipient("unanswered-posts"))
                .setText(String.format("<!channel> Automated message: Help request <%s/requests/%s|%s> (%s) " +
                                "has no responses and I've already pinged everyone.",
                        baseURL,
                        helpRequest.getId(), helpRequest.getId(),
                        helpRequest.getOrigin()
                ));

        Ping slackPing = pingRepo.save(new Ping("slack", helpRequest, PingType.slack_warn));
        String response = restOperations.postForObject(slackDevURI, request, String.class);
        logger.info("Posted to Slack, got response: {}", response);
        if (null != response && response.equalsIgnoreCase("ok")) {
            pingRepo.save(slackPing.setDelivered(true));
        }
    }

    @Override
    public void messagingViaSMS(HelpRequest helpRequest) {
        if (pingRepo.existsByHelpRequestAndPingedDTAfterAndPingType(
                helpRequest, ZonedDateTime.now().minusHours(6), PingType.slack_sms)
        ) {
            // Only message slack every 6hrs
            return;
        }

        SlackRequest request = new SlackRequest(new ChannelRecipient("dev"))
                .setText(String.format("<!channel> Notification: Email contacts exhausted; SMSs are being " +
                                "sent for request <%s/requests/%s|%s>.",
                        baseURL,
                        helpRequest.getId(), helpRequest.getId()
                ));

        Ping slackPing = pingRepo.save(new Ping("slack", helpRequest, PingType.slack_sms));
        String response = restOperations.postForObject(slackDevURI, request, String.class);
        logger.info("Posted to Slack, got response: {}", response);
        if (null != response && response.equalsIgnoreCase("ok")) {
            pingRepo.save(slackPing.setDelivered(true));
        }
    }


}
