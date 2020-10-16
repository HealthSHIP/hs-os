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

import org.healthship.validators.ValidPassword;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.*;

public class UserSignupDTO {

    @Value("${regex}")
    String regex;

    @NotNull
    @NotEmpty
    @Email
    @Pattern(regexp = ".+@.+.ac.uk|.+@nhs.net|.+@nhs.uk|.+@.+.nhs.uk|" +
            ".+@hse.ie|.+@nuigalway.ie|.+@ucdconnect.ie|.+@tcd.ie|.+@ul.ie|" +
            ".+@studentmail.ul.ie|.+@rcsi.ie|.+@umail.ucc.ie|.+@mater.ie|.+@svuh.ie|.+@galwayclinic.com|" +
            ".+@bonsecours.ie|.+@materprivate.ie|.+@beaconhospital.ie|" +
            ".+@blackrock-clinic.com|.+@stjames.ie|.+@hermitageclinic.ie|" +
            ".+@belfasttrust.hscni.net|.+@st-vincents.ie|.+@cuh.ie|.+@amnch.ie|" +
            ".+@beaumont.ie|.+@rcsihospitals.ie|.+@rcpi.ie|.+@muh.ie|" +
            ".+@sjh.ie|.+@nmh.ie|.+@dni.ie|.+@nrh.ie|.+@.+.edu.aus|.+@.+.ac.nz" +
            ".+@edinburgh.gov.uk|.+@cyrenians.scot",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "must be an approved institutional address")
    private String username;


    @NotNull
    @ValidPassword
    private String password;

    @NotNull
    private String userType;

    @NotNull
    @ValidPassword
    private String matchingPassword;

    @AssertTrue(message = "You must accept the Terms and Conditions")
    private Boolean hasReadTerms;

    public Boolean getHasPVG() {
        return hasPVG;
    }

    public UserSignupDTO setHasPVG(Boolean hasPVG) {
        this.hasPVG = hasPVG;
        return this;
    }

    private Boolean hasPVG;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getHasReadTerms() {
        return hasReadTerms;
    }

    public UserSignupDTO setHasReadTerms(Boolean hasReadTerms) {
        this.hasReadTerms = hasReadTerms;
        return this;
    }
}
