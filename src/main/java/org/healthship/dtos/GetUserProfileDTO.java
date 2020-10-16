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

import org.healthship.models.User;

/**
 * Used for pulling back a user profile BEFORE it's been accepted by either party
 */
public class GetUserProfileDTO {

    String name;
    String location;
    Float userLng;
    Float userLat;
    String introduction;

    // encrypted user profile image name (so that users
    // can't look up profile photos directly)
    String encImageName;

    public GetUserProfileDTO() {}

    public GetUserProfileDTO(User user) {
        this.name = user.getName();
        this.location = user.getLocation();
        this.userLng = user.getLng();
        this.userLat = user.getLat();
        this.introduction = user.getIntroduction();
    }

    public String getName() {
        return name;
    }

    public GetUserProfileDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public GetUserProfileDTO setLocation(String location) {
        this.location = location;
        return this;
    }

    public Float getUserLng() {
        return userLng;
    }

    public GetUserProfileDTO setUserLng(Float userLng) {
        this.userLng = userLng;
        return this;
    }

    public Float getUserLat() {
        return userLat;
    }

    public GetUserProfileDTO setUserLat(Float userLat) {
        this.userLat = userLat;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public GetUserProfileDTO setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public GetUserProfileDTO withEncImageName(String encImageName) {
        this.encImageName = encImageName;
        return this;
    }

    public String getEncImageName() {
        return encImageName;
    }

    public GetUserProfileDTO setEncImageName(String encImageName) {
        this.encImageName = encImageName;
        return this;
    }
}
