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

package org.healthship.services;

import org.healthship.models.User;
import org.healthship.models.UserType;
import org.healthship.models.internal.LocalUsersStats;
import org.healthship.models.internal.Radius;
import org.healthship.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service(value = "localUsersStats")
public class LocalUsersStatsSvc {
    private static final Logger logger = LoggerFactory.getLogger(LocalUsersStatsSvc.class);

    UserRepository userRepository;

    LocalUsersStatsSvc(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(value = "localUserStats", key = "{#currentUser.lng,#currentUser.lat,#currentUser.userType}")
    public LocalUsersStats getLocalUsers(User currentUser, UserType localUserType) {
        float offsetDegrees = 0.3f; // ~±20km
        long count = userRepository.findByEnabledTrueAndUserTypeIsAndLatBetweenAndLngBetween(
                localUserType,
                currentUser.getLat() - offsetDegrees, currentUser.getLat() + offsetDegrees,
                currentUser.getLng() - offsetDegrees, currentUser.getLng() + offsetDegrees
        ).stream()
                .peek(s -> s.setTransientGeoDistanceMetres(Utils.getDistanceMetres(
                        s.getLng(), s.getLat(), currentUser.getLng(), currentUser.getLat())
                ))
                .filter(s -> s.getTransientGeoDistanceMetres() < Radius._13km.getMetres()).count(); // todo currently hard-coded at 13 KM, no requirement to make var
        LocalUsersStats stats = new LocalUsersStats(currentUser, localUserType, count);
        logger.debug("Cached new stats object " + stats.toString());
        return stats;
    }

    // test whether it's worth reporting stats for the local user, currently hard coded at 3
    // ... ie if only two volunteers locally, this is marked as 'not significant'
    @Cacheable(value = "localUserStatsSignificant", key = "{#currentUser.lng,#currentUser.lat,#currentUser.userType}")
    public Boolean areSignificant(User currentUser, UserType localUserType) {
        return getLocalUsers(currentUser, localUserType).getCount() >= 3;
    }

    @CacheEvict(value = { "localUserStats", "localUserStatsSignificant" }, allEntries = true)
    public void evictAllCaches() {
        logger.debug("Evicted all cached objects");
    }

}
