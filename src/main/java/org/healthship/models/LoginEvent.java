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

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@Entity
@Table(name = "loginEvents")
public class LoginEvent {

    @Id
    String id;

    @OneToOne
    User user;

    ZonedDateTime loginDT;

    String userIP;

    public LoginEvent() {}

    public LoginEvent(User currentUser, HttpServletRequest request) {
        this.loginDT = ZonedDateTime.now();
        this.user = currentUser;
        this.id = request.getSession().getId();
        this.userIP = getRemoteIP(request);
    }

    private String getRemoteIP(HttpServletRequest request) {
        String remoteAddr = null;
        if (request != null) {
            remoteAddr = request.getHeader("X-Forwarded-For");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }


}
