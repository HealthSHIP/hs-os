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

import org.healthship.models.AdditionalFlags;
import org.healthship.models.HelpTimes;
import org.healthship.models.HelpWith;
import org.healthship.models.User;
import org.healthship.models.internal.Radius;
import org.healthship.models.internal.UserUOM;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.util.Set;

public class UserProfileDTO {

    @NotNull(message = "You must provide a name")
    @NotEmpty(message = "Your name must not be empty")
    String name;
    String phone;
    Boolean smsUpdates;
    Boolean emailUpdates;
    Set<HelpWith> helpWith;
    UserUOM userUOM;
    @Email(message = "Not a valid email address")
    String alternativeEmail;
    @NotNull(message = "Location must be specified")
    @NotEmpty(message = "Location must not be empty")
    String location;
    Float locationLng;
    Float locationLat;
    String introduction;
    Set<HelpTimes> helpTimes;
    Set<AdditionalFlags> additionalFlags;
    Radius notifyRadius;
    ZoneId timezone;
    public UserProfileDTO() {}
    /**
     * Number of times I've forgotten to update this method: 4 (and counting)
     *
     * Used for returning users via eg JSON
     * @param user the proper user object
     */
    public UserProfileDTO(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
        this.helpWith = user.getHelpWith();
        this.helpTimes = user.getHelpTimes();
        this.location = user.getLocation();
        this.locationLng = user.getLng();
        this.locationLat = user.getLat();
        this.introduction = user.getIntroduction();
        this.additionalFlags = user.getAdditional_flags();
        this.smsUpdates = user.getSmsUpdates();
        this.emailUpdates = user.getEmailUpdates();
        this.notifyRadius = user.getNotifyRadius();
        this.timezone = user.getTimezone();
        this.userUOM = user.getUserUOM();
    }

    public Radius getNotifyRadius() {
        return notifyRadius;
    }

    public UserProfileDTO setNotifyRadius(Radius notifyRadius) {
        this.notifyRadius = notifyRadius;
        return this;
    }

    /*
     * HERE BE DEVILS
     *
     * Don't do what I did and be a wise-crack using your own builder method ie `withValue(blah)` ... Spring then
     * fails to bind your setters and then you spend the best part of two hours trying to figure out what's going on.
     *
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Set<HelpWith> getHelpWith() {
        return helpWith;
    }

    public void setHelpWith(Set<HelpWith> helpWith) {
        this.helpWith = helpWith;
    }

    public Set<HelpTimes> getHelpTimes() {
        return helpTimes;
    }

    public void setHelpTimes(Set<HelpTimes> helpTimes) {
        this.helpTimes = helpTimes;
    }

    public Set<AdditionalFlags> getAdditionalFlags() {
        return additionalFlags;
    }

    public void setAdditionalFlags(Set<AdditionalFlags> additionalFlags) {
        this.additionalFlags = additionalFlags;
    }

    public Boolean getSmsUpdates() {
        return smsUpdates;
    }

    public UserProfileDTO setSmsUpdates(Boolean smsUpdates) {
        this.smsUpdates = smsUpdates;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public UserProfileDTO setLocation(String location) {
        this.location = location;
        return this;
    }

    public Float getLocationLng() {
        return locationLng;
    }

    public UserProfileDTO setLocationLng(Float locationLng) {
        this.locationLng = locationLng;
        return this;
    }

    public Float getLocationLat() {
        return locationLat;
    }

    public UserProfileDTO setLocationLat(Float locationLat) {
        this.locationLat = locationLat;
        return this;
    }

    public Boolean getEmailUpdates() {
        return emailUpdates;
    }

    public UserProfileDTO setEmailUpdates(Boolean emailUpdates) {
        this.emailUpdates = emailUpdates;
        return this;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public UserProfileDTO setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
        return this;
    }

    public ZoneId getTimezone() {
        return timezone;
    }

    public UserProfileDTO setTimezone(ZoneId timezone) {
        this.timezone = timezone;
        return this;
    }

    public UserUOM getUserUOM() {
        return userUOM;
    }

    public UserProfileDTO setUserUOM(UserUOM userUOM) {
        this.userUOM = userUOM;
        return this;
    }
}
