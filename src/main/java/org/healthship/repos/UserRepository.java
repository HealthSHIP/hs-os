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

package org.healthship.repos;

import org.healthship.models.User;
import org.healthship.models.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByEnabledTrueAndUserTypeIs(UserType userType);
    List<User> findByAcceptedTermsDTAfter(ZonedDateTime acceptedTermsDT);
    List<User> findByEnabledFalse();
    List<User> findByUserTypeIsAndLngLessThanAndLatLessThanAndLngGreaterThanAndLatGreaterThan(UserType userType, Float lng, Float lat, Float lng2, Float lat2);
    List<User> findByEnabledTrueAndUserTypeIsAndLatBetweenAndLngBetween(UserType userType, Float latMin, Float latMax, Float longMin, Float longMax);
}
