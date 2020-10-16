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

import com.fasterxml.jackson.annotation.JsonInclude;
import org.healthship.services.DistanceCalculator;
import org.healthship.services.Utils;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HelpRequestDTO {

    private String id;
    private String createdBy;
    private String ownerType;
    private Boolean alreadyResponded;
    private Boolean isOwner;
    private Boolean requiresPVG;
    private Boolean isEligible;
    private Long distanceToOriginMetres;
    private String distanceToOriginFormatted;
    private Long distanceToDestinationMetres;
    private String distanceToDestinationFormatted;
    private String distanceBetweenOriginAndDestinationFormatted;
    private String durationBetweenOriginAndDestinationFormatted;
    private String mappingBehaviour;
    private String origin;
    private String destination;
    private String description;
    private String instructions;
    private LocalDateTime createdDT;
    private LocalDateTime startDT;
    private LocalDateTime endDT;
    private String duration;
    private String postedAgo;
    private String helpWith;

    public HelpRequestDTO(HelpRequest helpRequest, User user, DistanceCalculator distanceCalculator) {
        this.id = helpRequest.getId();
        this.isOwner = helpRequest.getCreatedBy().equals(user);

        // if it's the owner, still show own name etc
        if (!user.isEligible(helpRequest) && !this.isOwner) {
            this.createdBy = "Anonymous (requires PVG)";
            this.description = "Description hidden";
        }
        else {
            this.createdBy = helpRequest.getCreatedBy().getName();
            this.origin = helpRequest.getOrigin();
            this.destination = helpRequest.getDestination();
            this.description = helpRequest.getDescription();
        }
        if (this.isOwner) {
            this.instructions = helpRequest.getInstructions();
        }
        this.ownerType = helpRequest.getCreatedBy().getUserType().name();
        this.alreadyResponded = helpRequest.getRespondedBy().contains(user);
        this.requiresPVG = helpRequest.getRequiresPVG();
        this.distanceToOriginMetres = Utils.getDistanceMetres(
                user.getLng(), user.getLat(),
                helpRequest.getOriginLng(), helpRequest.getOriginLat()
        );
        this.distanceToOriginFormatted = DistanceCalculator
                .getCrowDistanceBetweenUserAndOriginAsString(user, helpRequest);
        if (null != helpRequest.getDestination()
                && null != helpRequest.getDestinationLng()
                && null != helpRequest.getDestinationLat()) {
            this.distanceToDestinationMetres = Utils.getDistanceMetres(
                    user.getLng(), user.getLat(),
                    helpRequest.getDestinationLng(), helpRequest.getDestinationLat()
            );
            this.distanceToDestinationFormatted = DistanceCalculator
                    .getCrowDistanceBetweenUserAndDestinationAsString(user, helpRequest);
            this.distanceBetweenOriginAndDestinationFormatted = distanceCalculator
                    .getRoadDistanceBetweenOriginAndDestinationAsString(user, helpRequest);
            this.durationBetweenOriginAndDestinationFormatted = distanceCalculator
                    .getRoadTimeBetweenOriginAndDestinationAsString(helpRequest);
        }
        this.helpWith = helpRequest.getHelpWith().asString();
        this.postedAgo = Utils.getTimeAgo(helpRequest);
        this.createdDT = helpRequest.getLocalCreatedDateTime(user.getTimezone());
        this.startDT = helpRequest.getLocalDateTimeFrom(user.getTimezone());
        this.endDT = helpRequest.getLocalDateTimeTo(user.getTimezone());
        this.isEligible = (!helpRequest.getRequiresPVG()) || (helpRequest.getRequiresPVG() && user.isPVGVerified());
        this.duration = Utils.getBetweenEpoch(helpRequest.getDateTimeFrom(), helpRequest.getDateTimeTo());
    }

    public String getDistanceToOriginFormatted() {
        return distanceToOriginFormatted;
    }

    public String getDuration() {
        return duration;
    }

    public String getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Boolean getAlreadyResponded() {
        return alreadyResponded;
    }

    public Boolean getOwner() {
        return isOwner;
    }

    public Boolean getRequiresPVG() {
        return requiresPVG;
    }

    public Long getDistanceToOriginMetres() {
        return distanceToOriginMetres;
    }

    public String getHelpWith() {
        return helpWith;
    }

    public String getPostedAgo() {
        return postedAgo;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedDT() {
        return createdDT;
    }

    public LocalDateTime getStartDT() {
        return startDT;
    }

    public LocalDateTime getEndDT() {
        return endDT;
    }

    public Boolean isEligible() {
        return isEligible;
    }

    public Boolean getEligible() {
        return isEligible;
    }

    public String getOrigin() {
        return origin;
    }

    public String getInstructions() {
        return instructions;
    }

    public Long getDistanceToDestinationMetres() {
        return distanceToDestinationMetres;
    }

    public String getDistanceToDestinationFormatted() {
        return distanceToDestinationFormatted;
    }

    public String getMappingBehaviour() {
        return mappingBehaviour;
    }

    public String getDistanceBetweenOriginAndDestinationFormatted() {
        return distanceBetweenOriginAndDestinationFormatted;
    }

    public String getDurationBetweenOriginAndDestinationFormatted() {
        return durationBetweenOriginAndDestinationFormatted;
    }

    public String getDestination() {
        return destination;
    }

    public String getOwnerType() {
        return ownerType;
    }
}
