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

package org.healthship.models.internal;

import org.healthship.models.HelpRequest;
import org.healthship.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(name = "pings")
public class Ping {
    private static final Logger logger = LoggerFactory.getLogger(Ping.class);

    @Id
    @Column(columnDefinition = "VARCHAR(64)")
    String id;

    @OneToOne
    User volunteer;

    @OneToOne
    HelpRequest helpRequest;

    public Ping(@NotNull String username, HelpRequest helpRequest, PingType pingType) {
        String hashInput = String.format("%s_%s_%s", username, helpRequest.getId(), pingType.toString()).toLowerCase();
        String hash = DigestUtils.md5DigestAsHex(hashInput.getBytes());
        logger.debug("Instantiating ping object with hash {} (input str: {})", hash, hashInput);

        this.id = hash;
        this.pingedDT = ZonedDateTime.now();
        this.helpRequest = helpRequest;
        this.pingType = pingType;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public Ping setDelivered(Boolean delivered) {
        this.delivered = delivered;
        return this;
    }

    @Column(columnDefinition = "BIT default NULL")
    Boolean delivered;

    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(32)")
    PingType pingType = PingType.sms;

    ZonedDateTime pingedDT;

    public Ping(HelpRequest helpRequest, User volunteer, PingType pingType) {
        this(volunteer.getUsername(), helpRequest, pingType);
        this.volunteer = volunteer;
    }

    public Ping() {}

    public PingType getPingType() {
        return pingType;
    }

    public Ping setPingType(PingType pingType) {
        this.pingType = pingType;
        return this;
    }

    @Override
    public String toString() {
        return "Ping{" +
                "id='" + id + '\'' +
                ", volunteer=" + volunteer +
                ", helpRequest=" + helpRequest +
                ", delivered=" + delivered +
                ", pingType=" + pingType +
                ", pingedDT=" + pingedDT +
                '}';
    }
}
