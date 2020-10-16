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

import org.healthship.models.internal.ContactCategory;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ContactDTO {

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private ContactCategory category;

    @NotNull
    @NotEmpty
    private String description;

    public ContactDTO() {}

    public String getEmail() {
        return email;
    }

    public ContactDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public ContactDTO setName(String name) {
        this.name = name;
        return this;
    }

    public ContactCategory getCategory() {
        return category;
    }

    public ContactDTO setCategory(ContactCategory category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ContactDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
