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

import org.healthship.services.Utils;

import java.time.LocalDateTime;

/**
 * Used in rendering the calendar view
 */
public class CalendarEvent {
    String title;
    String description;
    LocalDateTime start;
    LocalDateTime end;
    String url;
    String color;

    public CalendarEvent(HelpRequest request, User user, Utils utils) {
        this.start = request.getLocalDateTimeFrom(user.getTimezone());
        this.end = request.getLocalDateTimeTo(user.getTimezone());

        if (user.isEligible(request)) {
            this.title = String.format("%s (%.1f miles away)",
                    request.getCreatedBy().getName(), Utils.getDistance(
                            request.getOriginLng(), request.getOriginLat(),
                            user.getLng(), user.getLat(),
                            user.getUserUOM().getUnit()
                    )
            );
            this.description = request.getDescription();
            this.url = String.format("/requests/%s", request.getId());
        }
        else {
            this.title = "(Requires PVG)";
            this.color = "#CCC";
            this.description = "";
            this.url = "#";
        }
    }

    public String getTitle() {
        return title;
    }

    public CalendarEvent setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CalendarEvent setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public CalendarEvent setStart(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public CalendarEvent setEnd(LocalDateTime end) {
        this.end = end;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public CalendarEvent setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getColor() {
        return color;
    }
}
