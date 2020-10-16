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

import org.junit.Assert;
import org.junit.Test;

public class UserUOMTest {

    @Test
    public void uomKM() {
        UserUOM uom = UserUOM.kilometres;
        Assert.assertEquals("0.0", uom.getFormattedDistance(0));
        Assert.assertEquals("0.0", uom.getFormattedDistance(1));
        Assert.assertEquals("0.5", uom.getFormattedDistance(500));
        Assert.assertEquals("1.0", uom.getFormattedDistance(1000));
        Assert.assertEquals("10.0", uom.getFormattedDistance(10000));
        Assert.assertEquals("11.1", uom.getFormattedDistance(11100));
        Assert.assertEquals("11.1", uom.getFormattedDistance(11149));
    }

    @Test
    public void uomMi() {
        UserUOM uom = UserUOM.miles;
        Assert.assertEquals("0.0", uom.getFormattedDistance(0));
        Assert.assertEquals("1.0", uom.getFormattedDistance(1609));
        Assert.assertEquals("10.0", uom.getFormattedDistance(16093));
    }
}