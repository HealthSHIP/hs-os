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

public class SurveyDTO {

    private String surveyID;
    private String q1;
    private String q2;
    private String q3;

    public String getSurveyID() {
        return surveyID;
    }

    public SurveyDTO setSurveyID(String surveyID) {
        this.surveyID = surveyID;
        return this;
    }

    public String getQ1() {
        return q1;
    }

    public SurveyDTO setQ1(String q1) {
        this.q1 = q1;
        return this;
    }

    public String getQ2() {
        return q2;
    }

    public SurveyDTO setQ2(String q2) {
        this.q2 = q2;
        return this;
    }

    public String getQ3() {
        return q3;
    }

    public SurveyDTO setQ3(String q3) {
        this.q3 = q3;
        return this;
    }
}
