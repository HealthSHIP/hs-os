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

import org.healthship.models.User;
import org.healthship.models.UserType;

public class LocalUsersStats {
    String key;
    Long count;

    public LocalUsersStats(User user, UserType userType, long count) {
        this.key = String.format("%s,%s_%s", user.getLat(), user.getLng(), userType.toString());
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public Long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "LocalUsersStats{" +
                "key='" + key + '\'' +
                ", localUsers=" + count +
                '}';
    }
}
