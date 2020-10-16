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
import org.healthship.models.internal.RequestType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "requests")
public class HelpRequest {

    @ManyToMany
    Set<User> respondedBy = new HashSet<>();
    @Transient
    String duration;
    @OneToMany
    Set<HelpRequestResource> resources = new HashSet<>();
    @Id
    private String id;
    @OneToOne
    private User createdBy;
    @OneToOne
    private User selectedUser;
    private ZonedDateTime selectedUserDateTime;
    @NotNull
    @NotEmpty
    @Column(length = 1024)
    private String description;
    @Column(length = 512)
    private String instructions;
    @NotNull
    private Float originLng;
    @NotNull
    private Float originLat;
    private Float destinationLng;
    private Float destinationLat;
    @NotNull
    @NotEmpty
    private String origin;
    /*
     * used for requests that are a delivery type
     */
    private String destination;
    private Boolean requiresPVG;
    private ZonedDateTime createdDateTime;
    private Boolean autoAccept = Boolean.FALSE;
    private Boolean visible = Boolean.TRUE;
    @Transient
    private String dateTimeFromDummy;
    @Transient
    private String dateTimeToDummy;
    @Enumerated(EnumType.STRING)
    private HelpWith helpWith = HelpWith.caring;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(32)")
    private RequestType requestType = RequestType.ad_hoc;
    @Transient
    private Boolean isOwner;
    @Transient
    private Boolean alreadyResponded;
    // calculated on the fly, used to store distance to beginning of task
    // stored in metres
    @Transient
    private Long trnMetresToOrigin;
    @Transient
    private Long trnMetresToDestination;
    @Transient
    private String timeAgo;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateTimeFrom;
    // dt to may not always be required
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateTimeTo;
    public HelpRequest() {
    }
    /**
     * for setting up default location etc
     *
     * @param user user for default location
     */
    public HelpRequest(User user) {
        this.origin = user.getLocation();
        this.originLng = user.getLng();
        this.originLat = user.getLat();
    }

    public Set<HelpRequestResource> getResources() {
        return resources;
    }

    public HelpRequest setResources(Set<HelpRequestResource> resources) {
        this.resources = resources;
        return this;
    }

    public String getOrigin() {
        return origin;
    }

    public HelpRequest setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public Boolean getRequiresPVG() {
        return requiresPVG;
    }

    public HelpRequest setRequiresPVG(Boolean requiresPVG) {
        this.requiresPVG = requiresPVG;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public HelpRequest setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public ZonedDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public HelpRequest setCreatedDateTime(ZonedDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    public Boolean isOwner() {
        return isOwner;
    }

    public HelpRequest isOwner(Boolean owner) {
        isOwner = owner;
        return this;
    }

    public HelpWith getHelpWith() {
        return helpWith;
    }

    public HelpRequest setHelpWith(HelpWith helpWith) {
        this.helpWith = helpWith;
        return this;
    }

    public Boolean alreadyResponded() {
        return alreadyResponded;
    }

    public HelpRequest alreadyResponded(Boolean alreadyResponded) {
        this.alreadyResponded = alreadyResponded;
        return this;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public HelpRequest setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
        return this;
    }

    public Long getTrnMetresToOrigin() {
        return trnMetresToOrigin;
    }

    public HelpRequest setTrnMetresToOrigin(Long trnMetresToOrigin) {
        this.trnMetresToOrigin = trnMetresToOrigin;
        return this;
    }

    public Set<User> getRespondedBy() {
        return respondedBy;
    }

    public HelpRequest setRespondedBy(Set<User> respondedBy) {
        this.respondedBy = respondedBy;
        return this;
    }

    public HelpRequest addResponse(User respondedByUser) {
        this.respondedBy.add(respondedByUser);
        return this;
    }

    public void removeResponse(User user) {
        this.respondedBy.remove(user);
    }

    public String getId() {
        return id;
    }

    public HelpRequest setId(String id) {
        this.id = id;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public HelpRequest setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public HelpRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public ZonedDateTime getDateTimeFrom() {
        return dateTimeFrom;
    }

    public HelpRequest setDateTimeFrom(ZonedDateTime dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
        return this;
    }

    public LocalDateTime getLocalDateTimeFrom(ZoneId timezone) {
        return dateTimeFrom.withZoneSameInstant(timezone).toLocalDateTime();
    }

    public ZonedDateTime getZonedDateTimeFrom(ZoneId timezone) {
        return dateTimeFrom.withZoneSameInstant(timezone);
    }

    public ZonedDateTime getDateTimeTo() {
        return dateTimeTo;
    }

    public HelpRequest setDateTimeTo(ZonedDateTime dateTimeTo) {
        this.dateTimeTo = dateTimeTo;
        return this;
    }

    public String getDateTimeFromDummy() {
        return dateTimeFromDummy;
    }

    public HelpRequest setDateTimeFromDummy(String dateTimeFromDummy) {
        this.dateTimeFromDummy = dateTimeFromDummy;
        return this;
    }

    public String getDateTimeToDummy() {
        return dateTimeToDummy;
    }

    public HelpRequest setDateTimeToDummy(String dateTimeToDummy) {
        this.dateTimeToDummy = dateTimeToDummy;
        return this;
    }

    public Boolean getAutoAccept() {
        return autoAccept;
    }

    public boolean isAutoAccept() {
        return autoAccept;
    }

    public HelpRequest setAutoAccept(Boolean autoAccept) {
        this.autoAccept = autoAccept;
        return this;
    }

    public HelpRequest setAutoAccept(boolean autoAccept) {
        this.autoAccept = autoAccept;
        return this;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        HelpRequest request = (HelpRequest) o;

        return new EqualsBuilder()
                .append(autoAccept, request.autoAccept)
                .append(visible, request.visible)
                .append(respondedBy, request.respondedBy)
                .append(id, request.id)
                .append(createdBy, request.createdBy)
                .append(description, request.description)
                .append(originLng, request.originLng)
                .append(originLat, request.originLat)
                .append(createdDateTime, request.createdDateTime)
                .append(dateTimeFrom, request.dateTimeFrom)
                .append(dateTimeTo, request.dateTimeTo)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(createdBy)
                .append(description)
                .append(origin)
                .append(originLng)
                .append(originLat)
                .append(destination)
                .append(destinationLng)
                .append(destinationLat)
                .append(createdDateTime)
                .append(autoAccept)
                .append(visible)
                .append(dateTimeFrom)
                .append(dateTimeTo)
                .toHashCode();
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public HelpRequest setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
        return this;
    }

    public ZonedDateTime getSelectedUserDateTime() {
        return selectedUserDateTime;
    }

    public HelpRequest setSelectedUserDateTime(ZonedDateTime selectedUserDateTime) {
        this.selectedUserDateTime = selectedUserDateTime;
        return this;
    }

    public Float getOriginLng() {
        return originLng;
    }

    public HelpRequest setOriginLng(Float lng) {
        this.originLng = lng;
        return this;
    }

    public Float getOriginLat() {
        return originLat;
    }

    public HelpRequest setOriginLat(Float lat) {
        this.originLat = lat;
        return this;
    }

    public Boolean getVisible() {
        return visible;
    }

    public HelpRequest setVisible(Boolean visible) {
        this.visible = visible;
        return this;
    }

    public Boolean getOwner() {
        return isOwner;
    }

    public HelpRequest setOwner(Boolean owner) {
        isOwner = owner;
        return this;
    }

    public Boolean getAlreadyResponded() {
        return alreadyResponded;
    }

    public HelpRequest setAlreadyResponded(Boolean alreadyResponded) {
        this.alreadyResponded = alreadyResponded;
        return this;
    }

    public LocalDateTime getLocalDateTimeTo(ZoneId timezone) {
        return dateTimeTo.withZoneSameInstant(timezone).toLocalDateTime();
    }

    public LocalDateTime getLocalCreatedDateTime(ZoneId timezone) {
        return createdDateTime.withZoneSameInstant(timezone).toLocalDateTime();
    }

    public String getDestination() {
        return destination;
    }

    public HelpRequest setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public Float getDestinationLng() {
        return destinationLng;
    }

    public HelpRequest setDestinationLng(Float destinationLng) {
        this.destinationLng = destinationLng;
        return this;
    }

    public Float getDestinationLat() {
        return destinationLat;
    }

    public HelpRequest setDestinationLat(Float destinationLat) {
        this.destinationLat = destinationLat;
        return this;
    }

    public Number getTrnMetresToDestination() {
        return trnMetresToDestination;
    }

    public HelpRequest setTrnMetresToDestination(Long trnMetresToDestination) {
        this.trnMetresToDestination = trnMetresToDestination;
        return this;
    }

    public String getInstructions() {
        return instructions;
    }

    public HelpRequest setInstructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public HelpRequest setRequestType(RequestType requestType) {
        this.requestType = requestType;
        return this;
    }
}
