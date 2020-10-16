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

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "surveyResponses")
public class SurveyResponse {
    @Id
    private String id;

    @ManyToOne
    private User user;

    private ZonedDateTime completedDT;

    private String surveyID;

    public SurveyResponse() {}

    public SurveyResponse(User user, String surveyID) {
        this.id = UUID.randomUUID().toString();
        this.completedDT = ZonedDateTime.now();
        this.user = user;
        this.surveyID = surveyID;
    }

    public String getId() {
        return id;
    }

    public SurveyResponse setId(String id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public SurveyResponse setUser(User user) {
        this.user = user;
        return this;
    }

    public ZonedDateTime getCompletedDT() {
        return completedDT;
    }

    public SurveyResponse setCompletedDT(ZonedDateTime completedDT) {
        this.completedDT = completedDT;
        return this;
    }

    public String getSurveyID() {
        return surveyID;
    }

    public SurveyResponse setSurveyID(String surveyID) {
        this.surveyID = surveyID;
        return this;
    }
}
