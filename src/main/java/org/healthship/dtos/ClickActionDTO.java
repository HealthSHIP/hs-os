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

package org.healthship.dtos;

import org.healthship.models.OneTimeToken;
import org.healthship.models.User;

public class ClickActionDTO {

    String requestID;
    String userID;
    Action action;
    private String token;

    public ClickActionDTO() {
    }

    // used to confirm a volunteer
    public ClickActionDTO(Action action, String requestID, User volunteer, OneTimeToken token) {
        this.action = action;
        this.requestID = requestID;
        this.token = token.getId();
        this.userID = volunteer.getUsername();
    }

    // used to remove a listing
    public ClickActionDTO(Action action, String requestID, OneTimeToken token) {
        this.action = action;
        this.requestID = requestID;
        this.token = token.getId();
    }

    public String getToken() {
        return token;
    }

    public ClickActionDTO setToken(String token) {
        this.token = token;
        return this;
    }

    public String getRequestID() {
        return requestID;
    }

    public ClickActionDTO setRequestID(String requestID) {
        this.requestID = requestID;
        return this;
    }

    public String getUserID() {
        return userID;
    }

    public ClickActionDTO setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public Action getAction() {
        return action;
    }

    public ClickActionDTO setAction(Action action) {
        this.action = action;
        return this;
    }

    public enum Action {
        confirm, delete
    }
}
