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

package org.healthship.models.rest.dm;

public class Element {
    ResponseKV distance;
    ResponseKV duration;
    MapsResponseStatus status;

    public ResponseKV getDistance() {
        return distance;
    }

    public Element setDistance(ResponseKV distance) {
        this.distance = distance;
        return this;
    }

    public ResponseKV getDuration() {
        return duration;
    }

    public Element setDuration(ResponseKV duration) {
        this.duration = duration;
        return this;
    }

    public MapsResponseStatus getStatus() {
        return status;
    }

    public Element setStatus(MapsResponseStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "Element{" +
                "distance=" + distance +
                ", duration=" + duration +
                ", status=" + status +
                '}';
    }
}
