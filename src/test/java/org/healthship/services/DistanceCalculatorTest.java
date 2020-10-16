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

import org.healthship.exceptions.ApplicationException;
import org.healthship.models.HelpRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DistanceCalculatorTest {
    @InjectMocks
    DistanceCalculator distanceCalculator;

    @Mock
    LiveDistanceService mockLiveDistanceService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(distanceCalculator);
    }

    private HelpRequest getHR() {
        return new HelpRequest()
                .setOriginLng(0f)
                .setOriginLat(0f)
                .setDestinationLng(0f)
                .setDestinationLat(0f);
    }

    @Test
    public void testTime01_0sec() throws ApplicationException {
        Mockito.doReturn(0L).when(mockLiveDistanceService).distanceSeconds(any(Float.class), any(Float.class), any(Float.class), any(Float.class));
        Assert.assertEquals("0min", distanceCalculator.getRoadTimeBetweenOriginAndDestinationAsString(getHR()));
    }

    @Test
    public void testTime01_60sec() throws ApplicationException {
        when(mockLiveDistanceService.distanceSeconds(any(Float.class), any(Float.class), any(Float.class), any(Float.class))).thenReturn(60L);
        Assert.assertEquals("1min", distanceCalculator.getRoadTimeBetweenOriginAndDestinationAsString(getHR()));
    }

    @Test
    public void testTime01_3599sec() throws ApplicationException {
        Mockito.doReturn(3599L).when(mockLiveDistanceService).distanceSeconds(any(Float.class), any(Float.class), any(Float.class), any(Float.class));
        Assert.assertEquals("59min", distanceCalculator.getRoadTimeBetweenOriginAndDestinationAsString(getHR()));
    }

    @Test
    public void testTime01_3601sec() throws ApplicationException {
        Mockito.doReturn(3601L).when(mockLiveDistanceService).distanceSeconds(any(Float.class), any(Float.class), any(Float.class), any(Float.class));
        Assert.assertEquals("1hr 0min", distanceCalculator.getRoadTimeBetweenOriginAndDestinationAsString(getHR()));
    }

    @Test
    public void testTime01_14460sec() throws ApplicationException {
        Mockito.doReturn(14460L).when(mockLiveDistanceService).distanceSeconds(any(Float.class), any(Float.class), any(Float.class), any(Float.class));
        Assert.assertEquals("4hrs 1min", distanceCalculator.getRoadTimeBetweenOriginAndDestinationAsString(getHR()));
    }
}