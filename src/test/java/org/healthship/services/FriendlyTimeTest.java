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

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.ZonedDateTime;

public class FriendlyTimeTest {

    @Test
    public void testCase01() {
        Assert.assertEquals("1 second", FriendlyTime.fromEpoch(ZonedDateTime.now().minusSeconds(1l).toEpochSecond()));
        Assert.assertEquals("2 seconds", FriendlyTime.fromEpoch(ZonedDateTime.now().minusSeconds(2l).toEpochSecond()));
    }

    @Test
    public void testCase02() {
        Assert.assertEquals("1 second", FriendlyTime.betweenEpoch(
                ZonedDateTime.now().minusSeconds(1l).toEpochSecond(),
                ZonedDateTime.now().toEpochSecond()
        ));
        Assert.assertEquals("12 seconds", FriendlyTime.betweenEpoch(
                ZonedDateTime.now().plusSeconds(12l).toEpochSecond(),
                ZonedDateTime.now().toEpochSecond()
        ));
    }

    @Test
    public void getHoursSince() {
        ZonedDateTime ex = ZonedDateTime.now().minusMinutes(43).minusHours(1);
        Assert.assertEquals(1, Duration.between(ex, ZonedDateTime.now()).toHours());
        Assert.assertEquals("4", String.format("%.0f", 3.69f));

        Assert.assertEquals("abcdef.ac.com", "test'''eohace@abcdef.ac.com".split("@")[1]);
    }
}