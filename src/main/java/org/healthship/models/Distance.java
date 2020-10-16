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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "DistanceMatrices")
public class Distance {
    private static final Logger logger = LoggerFactory.getLogger(Distance.class);

    @Id
    String id;
    ZonedDateTime updatedDT;
    Long crowMetres;
    Long metres;
    Long seconds;

    public Distance() {}

    public Distance(Float startLng, Float startLat, Float endLng, Float endLat, long distMetres, long distSec) {
        this.id = asID(startLng, startLat, endLng, endLat);
        this.metres = distMetres;
        this.seconds = distSec;
        this.updatedDT = ZonedDateTime.now();
        this.crowMetres = Utils.getDistanceMetres(startLng, startLat, endLng, endLat);
    }

    public static String asID(Float startLng, Float startLat, Float endLng, Float endLat) {
        return String.format("%.4f,%.4f_%.4f,%.4f", startLng, startLat, endLng, endLat);
    }

    public Long getCrowMetres() {
        return crowMetres;
    }

    public Distance setCrowMetres(Long crowMetres) {
        this.crowMetres = crowMetres;
        return this;
    }

    public String getId() {
        return id;
    }

    public Distance setId(String id) {
        this.id = id;
        return this;
    }

    public ZonedDateTime getUpdatedDT() {
        return updatedDT;
    }

    public Distance setUpdatedDT(ZonedDateTime updatedDT) {
        this.updatedDT = updatedDT;
        return this;
    }

    public Long getMetres() {
        return metres;
    }

    public Distance setMetres(Long metres) {
        this.metres = metres;
        return this;
    }

    public Long getSeconds() {
        return seconds;
    }

    public Distance setSeconds(Long seconds) {
        this.seconds = seconds;
        return this;
    }
}
