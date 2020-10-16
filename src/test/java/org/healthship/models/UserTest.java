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

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testEligibility01() {
        Assert.assertTrue(new User().withPVGVerified(true).isEligible(new HelpRequest().setRequiresPVG(true)));
        Assert.assertTrue(new User().withPVGVerified(true).isEligible(new HelpRequest().setRequiresPVG(false)));
        Assert.assertFalse(new User().withPVGVerified(false).isEligible(new HelpRequest().setRequiresPVG(true)));
        Assert.assertTrue(new User().withPVGVerified(false).isEligible(new HelpRequest().setRequiresPVG(false)));
    }
}