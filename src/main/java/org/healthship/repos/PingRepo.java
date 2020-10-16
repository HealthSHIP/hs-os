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

package org.healthship.repos;

import org.healthship.models.HelpRequest;
import org.healthship.models.User;
import org.healthship.models.internal.Ping;
import org.healthship.models.internal.PingType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface PingRepo extends JpaRepository<Ping, String> {

    // don't message user twice about the same post etc
    Boolean existsByHelpRequestAndVolunteerAndPingType(HelpRequest helpRequest, User volunteer, PingType pingType);

    // don't message same user twice within x time etc
    Boolean existsByVolunteerAndPingedDTAfterAndPingType(User volunteer, ZonedDateTime pingedDTAfter, PingType pingType);

    // same as above, but just for any message type
    Boolean existsByVolunteerAndPingedDTAfter(User volunteer, ZonedDateTime pingedDT);

    Boolean existsByHelpRequestAndPingedDTAfterAndPingType(HelpRequest helpRequest, ZonedDateTime pingedDT, PingType pingType);

    List<Ping> findByHelpRequestEquals(HelpRequest helpRequest);

    List<Ping> findByPingedDTAfter(ZonedDateTime pingedDT);
}
