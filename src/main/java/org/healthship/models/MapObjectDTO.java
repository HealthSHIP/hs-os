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

public class MapObjectDTO {

    String id;
    Float lat;
    Float lng;

    public MapObjectDTO() {}

    public MapObjectDTO(String id, Float lat, Float lng) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
    }

    public MapObjectDTO(User user) {
        this.id = DigestUtils.md5DigestAsHex(user.getUsername().getBytes());
        this.lat = user.getLat();
        this.lng = user.getLng();
    }

    public String getId() {
        return id;
    }

    public MapObjectDTO setId(String id) {
        this.id = id;
        return this;
    }

    public Float getLat() {
        return lat;
    }

    public MapObjectDTO setLat(Float lat) {
        this.lat = lat;
        return this;
    }

    public Float getLng() {
        return lng;
    }

    public MapObjectDTO setLng(Float lng) {
        this.lng = lng;
        return this;
    }
}
