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

import java.time.LocalDateTime;

public class MapHelpRequestDTO extends MapObjectDTO {

    Boolean requiresPVG;
    LocalDateTime dateTimeFrom;
    String duration;

    public MapHelpRequestDTO() {}

    public MapHelpRequestDTO(HelpRequest helpRequest, User currentUser) {
        this.id = helpRequest.getId();
        this.lat = helpRequest.getOriginLat();
        this.lng = helpRequest.getOriginLng();
        this.requiresPVG = helpRequest.getRequiresPVG();
        this.dateTimeFrom = helpRequest.getLocalDateTimeFrom(currentUser.getTimezone());
        this.duration = helpRequest.getDuration();
    }

    public Boolean getRequiresPVG() {
        return requiresPVG;
    }

    public MapHelpRequestDTO setRequiresPVG(Boolean requiresPVG) {
        this.requiresPVG = requiresPVG;
        return this;
    }

    public LocalDateTime getDateTimeFrom() {
        return dateTimeFrom;
    }

    public MapHelpRequestDTO setDateTimeFrom(LocalDateTime dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public MapHelpRequestDTO setDuration(String duration) {
        this.duration = duration;
        return this;
    }
}
