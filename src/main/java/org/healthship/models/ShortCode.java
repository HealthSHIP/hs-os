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

package org.healthship.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "ShortCodes")
public class ShortCode {
    private static final Logger logger = LoggerFactory.getLogger(ShortCode.class);

    @Id
    String shortCode;

    @ManyToOne(optional = false)
    HelpRequest helpRequest;

    @OneToOne(optional = false)
    User user;
    Integer count = 0;
    ZonedDateTime createdDt;

    public ShortCode() {}

    public ShortCode(String shortCode, User user, HelpRequest helpRequest) {
        this.shortCode = shortCode;
        this.user = user;
        this.helpRequest = helpRequest;
        this.createdDt = ZonedDateTime.now();
    }

    public Integer getCount() {
        return count;
    }

    public ShortCode setCount(Integer clicked) {
        this.count = clicked;
        return this;
    }

    public String getShortCode() {
        return shortCode;
    }

    public ShortCode setShortCode(String shortCode) {
        this.shortCode = shortCode;
        return this;
    }

    public HelpRequest getHelpRequest() {
        return helpRequest;
    }

    public ShortCode setHelpRequest(HelpRequest helpRequest) {
        this.helpRequest = helpRequest;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ShortCode setUser(User user) {
        this.user = user;
        return this;
    }

    public ZonedDateTime getCreatedDt() {
        return createdDt;
    }

    public ShortCode setCreatedDt(ZonedDateTime createdDt) {
        this.createdDt = createdDt;
        return this;
    }

    @Override
    public String toString() {
        return "ShortCode{" +
                "shortCode='" + shortCode + '\'' +
                ", helpRequest=" + helpRequest +
                ", user=" + user +
                ", count=" + count +
                ", createdDt=" + createdDt +
                '}';
    }
}
