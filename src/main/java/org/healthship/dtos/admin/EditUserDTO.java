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

package org.healthship.dtos.admin;

import org.healthship.models.User;
import org.healthship.models.UserType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EditUserDTO {

    @NotNull
    @NotEmpty
    @Email
    private String username;

    @NotNull
    private Boolean hasPVG;

    @NotNull
    private UserType userType;

    @NotNull
    private Boolean enabled;

    @Email
    private String alternativeEmail;

    // required by POST response
    public EditUserDTO() {}

    public EditUserDTO(User user) {
        this.username = user.getUsername();
        this.hasPVG = user.getPvgVerified();
        this.userType = user.getUserType();
        this.enabled = user.getEnabled();
        this.alternativeEmail = user.getAlternativeEmail();
    }

    public String getUsername() {
        return username;
    }

    public EditUserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public Boolean getHasPVG() {
        return hasPVG;
    }

    public EditUserDTO setHasPVG(Boolean hasPVG) {
        this.hasPVG = hasPVG;
        return this;
    }

    public UserType getUserType() {
        return userType;
    }

    public EditUserDTO setUserType(UserType userType) {
        this.userType = userType;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public EditUserDTO setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public EditUserDTO setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
        return this;
    }
}
