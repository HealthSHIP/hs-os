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

@JsonIgnoreProperties(ignoreUnknown = true)
public class TXTLocalResponse {

    Long balance;
    @JsonProperty("batch_id")
    Long batchID;
    Integer cost;
    String status;

    public Long getBalance() {
        return balance;
    }

    public TXTLocalResponse setBalance(Long balance) {
        this.balance = balance;
        return this;
    }

    public Long getBatchID() {
        return batchID;
    }

    public TXTLocalResponse setBatchID(Long batchID) {
        this.batchID = batchID;
        return this;
    }

    public Integer getCost() {
        return cost;
    }

    public TXTLocalResponse setCost(Integer cost) {
        this.cost = cost;
        return this;
    }

    @Override
    public String toString() {
        return "TXTLocalResponse{" +
                "balance=" + balance +
                ", batchID=" + batchID +
                ", cost=" + cost +
                ", status=" + status +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public TXTLocalResponse setStatus(String status) {
        this.status = status;
        return this;
    }
}
