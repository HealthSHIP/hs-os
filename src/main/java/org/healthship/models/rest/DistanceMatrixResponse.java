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

package org.healthship.models.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.healthship.models.rest.dm.MapsResponseStatus;
import org.healthship.models.rest.dm.ResponseRow;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DistanceMatrixResponse {
    @JsonProperty("origin_addresses")
    List<String> originAddresses;

    @JsonProperty("destination_addresses")
    List<String> destinationAddresses;

    List<ResponseRow> rows;
    MapsResponseStatus status;

    public List<ResponseRow> getRows() {
        return rows;
    }

    public DistanceMatrixResponse setRows(List<ResponseRow> rows) {
        this.rows = rows;
        return this;
    }

    public MapsResponseStatus getStatus() {
        return status;
    }

    public DistanceMatrixResponse setStatus(MapsResponseStatus status) {
        this.status = status;
        return this;
    }

    public List<String> getOriginAddresses() {
        return originAddresses;
    }

    public DistanceMatrixResponse setOriginAddresses(List<String> originAddresses) {
        this.originAddresses = originAddresses;
        return this;
    }

    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public DistanceMatrixResponse setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
        return this;
    }

    @Override
    public String toString() {
        return "DistanceMatrixResponse{" +
                "originAddresses=" + originAddresses +
                ", destinationAddresses=" + destinationAddresses +
                ", rows=" + rows +
                ", status=" + status +
                '}';
    }
}
