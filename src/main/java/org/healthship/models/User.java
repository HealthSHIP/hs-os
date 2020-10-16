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

import org.healthship.dtos.UserProfileDTO;
import org.healthship.dtos.admin.EditUserDTO;
import org.healthship.models.internal.Radius;
import org.healthship.models.internal.UserUOM;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Column(nullable = true, insertable = true, updatable = true)
    @ElementCollection
    @Enumerated(EnumType.STRING)
    Set<HelpWith> helpWith;
    @Column(length = 1024)
    String introduction;
    @Column(nullable = true, insertable = true, updatable = true)
    @ElementCollection
    @Enumerated(EnumType.STRING)
    Set<HelpTimes> helpTimes;
    @Id
    private String username;
    private String password;
    private UserType userType;
    @Column(columnDefinition = "BIT default 0")
    private Boolean enabled = Boolean.FALSE;
    @Column(columnDefinition = "BIT default 0")
    private Boolean acceptedTerms = Boolean.FALSE;
    private ZonedDateTime acceptedTermsDT;
    @Column(columnDefinition = "BIT default 0")
    private Boolean smsUpdates = Boolean.FALSE;
    @Column(columnDefinition = "BIT default 0")
    private Boolean emailUpdates = Boolean.FALSE;
    private String alternativeEmail;

    private ZoneId timezone = ZoneId.of("Europe/London");

    public Boolean isPVGVerified() {
        return pvgVerified;
    }

    public User withPVGVerified(Boolean pvgVerified) {
        this.pvgVerified = pvgVerified;
        return this;
    }

    @Column(columnDefinition = "decimal(8,5)")
    private Float lng;
    @Column(columnDefinition = "decimal(8,5)")
    private Float lat;
    private String location;
    @Transient
    private Long transientGeoDistanceMetres;
    @Column(columnDefinition = "BIT default 0")
    private Boolean pvgVerified;
    @OneToMany
    private Set<User> vouchedBy = new HashSet<>();
    @Column(nullable = true, insertable = true, updatable = true)
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<AdditionalFlags> additional_flags;
    @Transient
    private Radius notifyRadius = Radius._21km;
    private String name;
    private String phone;
    @Enumerated(EnumType.STRING)
    private UserUOM userUOM = UserUOM.miles;

    @Basic
    private int radiusKm = 21;

    @PostLoad
    void fillTransient() {
        if (radiusKm > 0) {
            this.notifyRadius = Radius.of(radiusKm);
        }
    }

    @PrePersist
    @PreUpdate
    void fillPersistent() {
        if (notifyRadius != null) {
            this.radiusKm = notifyRadius.getKm();
        }
    }

    public Long getTransientGeoDistanceMetres() {
        return transientGeoDistanceMetres;
    }

    public User setTransientGeoDistanceMetres(Long transientGeoDistanceMetres) {
        this.transientGeoDistanceMetres = transientGeoDistanceMetres;
        return this;
    }

    public boolean isInitialised() {
        return (null != lng && null != lat && null != location && !location.isEmpty());
    }

    public boolean isEligible(HelpRequest request) {
        return (this.isPVGVerified() || !request.getRequiresPVG());
    }

    public boolean willBePerforming(HelpRequest helpRequest) {
        return (null != helpRequest.getSelectedUser() && helpRequest.getSelectedUser().equals(this));
    }

    public boolean owns(HelpRequest request) {
        return request.getCreatedBy().equals(this);
    }

    // used when an admin updates the user profile
    public User withUpdate(EditUserDTO editUserDTO) {
        this.pvgVerified = editUserDTO.getHasPVG();
        this.enabled = editUserDTO.getEnabled();
        this.userType = editUserDTO.getUserType();
        this.alternativeEmail = editUserDTO.getAlternativeEmail();
        return this;
    }

    // used when the user updates their own profile
    public User withUpdate(UserProfileDTO profileDTO) {
        this.name = profileDTO.getName();
        this.phone = profileDTO.getPhone();
        this.helpWith = profileDTO.getHelpWith();
        this.helpTimes = profileDTO.getHelpTimes();
        this.location = profileDTO.getLocation();
        this.lng = profileDTO.getLocationLng();
        this.lat = profileDTO.getLocationLat();
        this.introduction = profileDTO.getIntroduction();
        this.additional_flags = profileDTO.getAdditionalFlags();
        this.smsUpdates = profileDTO.getSmsUpdates();
        this.emailUpdates = profileDTO.getEmailUpdates();
        this.notifyRadius = profileDTO.getNotifyRadius();
        this.alternativeEmail = profileDTO.getAlternativeEmail();
        this.timezone = profileDTO.getTimezone();
        this.userUOM = profileDTO.getUserUOM();
        return this;
    }

    public String getContactEmail() {
        if (null == alternativeEmail || alternativeEmail.isEmpty()) {
            return username;
        }
        return alternativeEmail;
    }

    public String getUsername() {
        return username;
    }

    public User withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserType getUserType() {
        return userType;
    }

    public User withUserType(UserType userType) {
        this.userType = userType;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public User withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Set<AdditionalFlags> getAdditional_flags() {
        return additional_flags;
    }

    public User withAdditional_flags(Set<AdditionalFlags> additional_flags) {
        this.additional_flags = additional_flags;
        return this;
    }

    public String getName() {
        return name;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Set<HelpWith> getHelpWith() {
        return helpWith;
    }

    public User withHelpWith(Set<HelpWith> helpWith) {
        this.helpWith = helpWith;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public User withIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public Set<HelpTimes> getHelpTimes() {
        return helpTimes;
    }

    public User withHelpTimes(Set<HelpTimes> helpTimes) {
        this.helpTimes = helpTimes;
        return this;
    }

    public Boolean getSmsUpdates() {
        return smsUpdates;
    }

    public User setSmsUpdates(Boolean smsUpdates) {
        this.smsUpdates = smsUpdates;
        return this;
    }

    public Boolean getAcceptedTerms() {
        return acceptedTerms;
    }

    public User withAcceptedTerms(Boolean acceptedTerms) {
        this.acceptedTerms = acceptedTerms;
        return this;
    }

    public ZonedDateTime getAcceptedTermsDT() {
        return acceptedTermsDT;
    }

    public User withAcceptedTermsDT(ZonedDateTime acceptedTermsDT) {
        this.acceptedTermsDT = acceptedTermsDT;
        return this;
    }

    public Float getLat() {
        return lat;
    }

    public User withLat(Float lat) {
        this.lat = lat;
        return this;
    }

    public Float getLng() {
        return lng;
    }

    public User withLng(Float lng) {
        this.lng = lng;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public User withLocation(String location) {
        this.location = location;
        return this;
    }

    public Boolean getEmailUpdates() {
        return emailUpdates;
    }

    public User setEmailUpdates(Boolean emailUpdates) {
        this.emailUpdates = emailUpdates;
        return this;
    }

    public Boolean getPvgVerified() {
        return pvgVerified;
    }

    public Set<User> getVouchedBy() {
        return vouchedBy;
    }

    public User addVouchedBy(User vouchingUser) {
        this.vouchedBy.add(vouchingUser);
        return this;
    }

    public Radius getNotifyRadius() {
        return notifyRadius;
    }

    public User setNotifyRadius(Radius notifyWithinMiles) {
        this.notifyRadius = notifyWithinMiles;
        return this;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public ZoneId getTimezone() {
        return timezone;
    }

    public UserUOM getUserUOM() {
        return userUOM;
    }

    public User setUserUOM(UserUOM userUOM) {
        this.userUOM = userUOM;
        return this;
    }
}
