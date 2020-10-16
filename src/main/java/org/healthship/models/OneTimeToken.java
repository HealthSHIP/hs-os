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

import org.healthship.models.internal.TokenType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "OneTimeTokens")
public class OneTimeToken {
    private static final Logger logger = LoggerFactory.getLogger(OneTimeToken.class);

    @Id
    String id;

    @ManyToOne
    User owner;

    ZonedDateTime dateTime;

    public TokenType getTokenType() {
        return tokenType;
    }

    public OneTimeToken setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    @Enumerated(value = EnumType.STRING)
    TokenType tokenType;

    public OneTimeToken() {

    }

    public OneTimeToken(User owner) {
        this.id = UUID.randomUUID().toString();
        this.owner = owner;
        this.dateTime = ZonedDateTime.now();
    }

    public String getId() {
        return id;
    }

    public OneTimeToken withId(String id) {
        this.id = id;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public OneTimeToken withUser(User user) {
        this.owner = user;
        return this;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public OneTimeToken withDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
