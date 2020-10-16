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

import org.geotools.referencing.GeodeticCalculator;
import org.healthship.models.HelpRequest;
import org.healthship.models.User;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import si.uom.SI;
import tec.uom.se.quantity.Quantities;

import javax.measure.Unit;
import javax.measure.quantity.Length;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class Utils {

    public static Float getDistance(
            Float startLng, Float startLat,
            Float endLng, Float endLat,
            Unit<Length> unit
    ) {
        GeodeticCalculator gc = new GeodeticCalculator();

        gc.setStartingGeographicPoint(startLng, startLat);
        gc.setDestinationGeographicPoint(endLng, endLat);

        Double distance = gc.getOrthodromicDistance();
        return Quantities.getQuantity(distance, unit).getValue().floatValue();
    }

    public static String getTimeAgo(HelpRequest r) {
        return (FriendlyTime.sinceFromEpoch(r.getCreatedDateTime().toEpochSecond()).equals("just now") ?
                FriendlyTime.sinceFromEpoch(r.getCreatedDateTime().toEpochSecond()) :
                String.format("%s ago", FriendlyTime.sinceFromEpoch(r.getCreatedDateTime().toEpochSecond())));
    }

    public static String getFriendlyTime(ZonedDateTime z) {
        return FriendlyTime.fromEpoch(z.toEpochSecond());
    }

    public static String getBetweenEpoch(ZonedDateTime x, ZonedDateTime y) {
        return (FriendlyTime.betweenEpoch(x.toEpochSecond(), y.toEpochSecond()).isEmpty() ? "just a moment" : FriendlyTime.betweenEpoch(x.toEpochSecond(), y.toEpochSecond()));
    }

    public static boolean isAdmin(User user) {
        // open source version: please implement your own checks here
        return false;
    }

    public static Long getDistanceMetres(Float startLng, Float startLat, Float endLng, Float endLat) {
        return getDistance(startLng, startLat, endLng, endLat, SI.METRE).longValue();
    }

    public static boolean isActive(String local, Environment environment) {
        for (String activeProfile : environment.getActiveProfiles()) {
            if (activeProfile.equalsIgnoreCase(local)) {
                return true;
            }
        }
        return false;
    }

    // I should have added a drop-down for titles but here we are ...
    @Deprecated
    public static String getFirstName(String input) {
        Set<String> prefixes = new HashSet<>(Arrays.asList("MR", "MRS", "MX", "MISS", "DR"));
        for (String val : input.trim().split(" ")) {
            if (!val.isEmpty() && !prefixes.contains(val.toUpperCase())) {
                return val;
            }
        }
        return "";
    }
}
