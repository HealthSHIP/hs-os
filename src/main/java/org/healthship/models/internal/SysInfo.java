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

package org.healthship.models.internal;

import java.time.ZonedDateTime;

public class SysInfo {

    private String value;
    private ZonedDateTime lastUpdated = ZonedDateTime.now();

    public SysInfo(String value) {
        this.value = value;
        this.lastUpdated = ZonedDateTime.now();
    }

    public String getValue() {
        return value;
    }

    public ZonedDateTime getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return value;
    }
}
