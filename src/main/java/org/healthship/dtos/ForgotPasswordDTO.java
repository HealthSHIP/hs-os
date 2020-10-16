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

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ForgotPasswordDTO {

    @NotNull
    @NotEmpty
    @Email
    private String username;

    // right now we are actually extracting the google RC value at the controller under
    // a different field name (because otherwise I have to do dirty
    // stuff with @RequestBody)

    public ForgotPasswordDTO() {
    }

    public String getUsername() {
        return username;
    }

    public ForgotPasswordDTO setUsername(String username) {
        this.username = username;
        return this;
    }
}
