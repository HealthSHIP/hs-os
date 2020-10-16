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

import org.healthship.validators.ValidPassword;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SetPasswordDTO {

    @NotNull
    @NotEmpty
    private String token;

    @NotNull
    private String username;

    @NotNull
    @ValidPassword
    private String password;

    @NotNull
    private String confirmPassword;

    public SetPasswordDTO() {}

    public SetPasswordDTO(String user, String auth) {
        this.username = user;
        this.token = auth;
    }

    public String getUsername() {
        return username;
    }

    public SetPasswordDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SetPasswordDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public SetPasswordDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getToken() {
        return token;
    }

    public SetPasswordDTO setToken(String token) {
        this.token = token;
        return this;
    }
}
