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

import org.springframework.util.DigestUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;

// holds the state of all requests (including after the fact, so that we
// don't end up sending the same request twice in a row)

@Entity
@Table(name = "vouchRequests")
public class VouchRequest {

    @Id
    String id;

    @OneToOne
    User clinician;

    @OneToOne
    User volunteer;
    ZonedDateTime requestDT;
    VouchState state;

    public VouchRequest(){}

    public VouchRequest(User clinician, User volunteer) {
        this.id = DigestUtils.md5DigestAsHex(String.format(
                "%s_%s", clinician.getUsername(), volunteer.getUsername()
        ).toLowerCase().getBytes());
        this.clinician = clinician;
        this.volunteer = volunteer;
        this.requestDT = ZonedDateTime.now();
        this.state = VouchState.PENDING;
    }

    public User getClinician() {
        return clinician;
    }

    public VouchRequest setClinician(User clinician) {
        this.clinician = clinician;
        return this;
    }

    public User getVolunteer() {
        return volunteer;
    }

    public VouchRequest setVolunteer(User volunteer) {
        this.volunteer = volunteer;
        return this;
    }

    public ZonedDateTime getRequestDT() {
        return requestDT;
    }

    public VouchRequest setRequestDT(ZonedDateTime requestDT) {
        this.requestDT = requestDT;
        return this;
    }

    public VouchState getState() {
        return state;
    }

    public VouchRequest setState(VouchState state) {
        this.state = state;
        return this;
    }

    public String getId() {
        return id;
    }
}
