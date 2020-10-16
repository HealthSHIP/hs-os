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

/*
 * nicked this from somewhere, can't
 */
public class FriendlyTime {

    public static long SECOND = 1l;
    public static long MINUTE = SECOND * 60l;
    public static long HOUR = MINUTE * 60l;
    public static long DAY = HOUR * 24l;
    public static long MONTH = DAY * 30l;
    public static long YEAR = DAY * 365l;

    public static String fromEpoch(long epoch) {
        long current = System.currentTimeMillis();
        return betweenEpoch((current / 1000l), epoch);
    }

    public static String betweenEpoch(long time1, long time2) {
        long gap = Math.abs(time1 - time2);

        if (gap / YEAR == 1l) {
            return String.valueOf(gap / YEAR) + " year";
        } else if (gap / YEAR > 1l) {
            return String.valueOf(gap / YEAR) + " years";
        }

        if (gap / MONTH == 1l) {
            return String.valueOf(gap / MONTH) + " month";
        } else if (gap / MONTH > 1l) {
            return String.valueOf(gap / MONTH) + " months";
        }

        if (gap / DAY == 1l) {
            return "1 day";
        } else if (gap / DAY > 1l) {
            return String.valueOf(gap / DAY) + " days";
        }

        if (gap / HOUR == 1l) {
            return String.valueOf(gap / HOUR) + " hour";
        } else if (gap / HOUR > 1l) {
            return String.valueOf(gap / HOUR) + " hours";
        }

        if (gap / YEAR == 1l) {
            return String.valueOf(gap / YEAR) + " year";
        } else if (gap / YEAR > 1l) {
            return String.valueOf(gap / YEAR) + " years";
        }

        if (gap / MINUTE == 1l) {
            return String.valueOf(gap / MINUTE) + " minute";
        } else if (gap / MINUTE > 1l) {
            return String.valueOf(gap / MINUTE) + " minutes";
        }

        if (gap / SECOND == 1l) {
            return String.valueOf(gap / SECOND) + " second";
        } else if (gap / SECOND > 1l) {
            return String.valueOf(gap / SECOND) + " seconds";
        }

        return "";
    }

    public static String sinceFromEpoch(long epoch) {
        return (fromEpoch(epoch).isEmpty() ? "just now" : fromEpoch(epoch));
    }
}
