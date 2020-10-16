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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.healthship.models.internal.ResourceType;

import javax.persistence.*;

@Entity
@Table(name = "resources")
public class HelpRequestResource {
    @Id
    String id;
    @Enumerated(EnumType.STRING)
    ResourceType type;
    String name;
    String uri;

    public String getId() {
        return id;
    }

    public HelpRequestResource setId(String id) {
        this.id = id;
        return this;
    }

    public ResourceType getType() {
        return type;
    }

    public HelpRequestResource setType(ResourceType type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public HelpRequestResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public HelpRequestResource setUri(String uri) {
        this.uri = uri;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        HelpRequestResource that = (HelpRequestResource) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(type, that.type)
                .append(name, that.name)
                .append(uri, that.uri)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(type)
                .append(name)
                .append(uri)
                .toHashCode();
    }
}
