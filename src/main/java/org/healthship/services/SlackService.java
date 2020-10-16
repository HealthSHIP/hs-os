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
import org.healthship.models.rest.SlackRequest;

public interface SlackService {
    void slackRequest(SlackRequest slackRequest);

    /**
     * Sends a message to slack stating there are no more users for a request: self-limits
     * @param helpRequest The request for which there are no more users
     */
    void noMoreUsers(HelpRequest helpRequest);

    /**
     * Sends message to slack once pings to SMS have started
     * @param helpRequest The request for which SMSs have started
     */
    void messagingViaSMS(HelpRequest helpRequest);
}
