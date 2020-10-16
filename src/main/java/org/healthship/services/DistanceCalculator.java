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
import org.healthship.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import si.uom.SI;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@Service("distanceCalculator")
public class DistanceCalculator {
    private static final Logger logger = LoggerFactory.getLogger(DistanceCalculator.class);

    LiveDistanceService liveDistanceService;

    public DistanceCalculator(LiveDistanceService liveDistanceService) {
        this.liveDistanceService = liveDistanceService;
    }

    // from current user to helpRequest origin as a float using preferred unit
    public static Float getCrowDistanceBetweenUserAndOriginAsFloat(User user, HelpRequest helpRequest) {
        return rounded(SI.METRE.getConverterTo(user.getUserUOM().getUnit()).convert(
                Utils.getDistanceMetres(
                        user.getLng(), user.getLat(), helpRequest.getOriginLng(), helpRequest.getOriginLat()
                )
        ).floatValue(), 1);
    }

    // as formatted string
    public static String getCrowDistanceBetweenUserAndOriginAsString(User user, HelpRequest helpRequest) {
        return String.format("%.1f %s", getCrowDistanceBetweenUserAndOriginAsFloat(user, helpRequest), user.getUserUOM().getAbbreviation());
    }

    public static Float getCrowDistanceBetweenOriginAndDestinationAsFloat(User currentUser, HelpRequest helpRequest) {
        if (null == helpRequest.getDestination() || helpRequest.getDestination().isEmpty()) {
            return null;
        }
        return rounded(SI.METRE.getConverterTo(currentUser.getUserUOM().getUnit()).convert(
                Utils.getDistanceMetres(
                        helpRequest.getOriginLng(), helpRequest.getOriginLat(),
                        helpRequest.getDestinationLng(), helpRequest.getDestinationLat()
                )
        ).floatValue(), 1);
    }

    public static String getCrowDistanceBetweenOriginAndDestinationAsString(User currentUser, HelpRequest helpRequest) {
        return String.format("%.1f %s",
                getCrowDistanceBetweenOriginAndDestinationAsFloat(currentUser, helpRequest),
                currentUser.getUserUOM().getAbbreviation()
        );
    }

    public static String getCrowDistanceBetweenUserAndDestinationAsString(User user, HelpRequest helpRequest) {
        return String.format("%.1f %s", getCrowDistanceBetweenUserAndDestinationAsFloat(user, helpRequest), user.getUserUOM().getAbbreviation());
    }

    private static Float getCrowDistanceBetweenUserAndDestinationAsFloat(User user, HelpRequest helpRequest) {
        return rounded(SI.METRE.getConverterTo(user.getUserUOM().getUnit()).convert(
                Utils.getDistanceMetres(
                        user.getLng(), user.getLat(), helpRequest.getDestinationLng(), helpRequest.getDestinationLat()
                )
        ).floatValue(), 1);
    }

    private static Float rounded(Float input, int dp) {
        NumberFormat formatter = new DecimalFormat();
        formatter.setGroupingUsed(false);
        formatter.setMaximumFractionDigits(dp);
        formatter.setMinimumFractionDigits(dp);
        formatter.setRoundingMode(RoundingMode.HALF_UP);
        return Float.parseFloat(formatter.format(input));
    }

    public Float getRoadDistanceBetweenOriginAndDestinationAsFloat(User currentUser, HelpRequest helpRequest) {
        if (null == helpRequest.getDestination() || helpRequest.getDestination().isEmpty()) {
            return null;
        }
        try {
            return rounded((float) SI.METRE.getConverterTo(currentUser.getUserUOM().getUnit()).convert(
                    liveDistanceService.distanceMetres(
                        helpRequest.getOriginLng(), helpRequest.getOriginLat(), helpRequest.getDestinationLng(), helpRequest.getDestinationLat()
                    )
            ),1);
        } catch (ApplicationException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public String getRoadDistanceBetweenOriginAndDestinationAsString(User currentUser, HelpRequest helpRequest) {
        return String.format("%.1f %s",
                getRoadDistanceBetweenOriginAndDestinationAsFloat(currentUser, helpRequest),
                currentUser.getUserUOM().getAbbreviation()
        );
    }

    public String getRoadTimeBetweenOriginAndDestinationAsString(HelpRequest helpRequest) {
        try {
            long seconds = liveDistanceService.distanceSeconds(
                    helpRequest.getOriginLng(), helpRequest.getOriginLat(), helpRequest.getDestinationLng(), helpRequest.getDestinationLat()
            );
            StringBuilder sb = new StringBuilder();
            if ((seconds / 3600) > 1) {
                sb.append(String.format("%dhrs ", seconds / 3600));
            }
            if ((seconds / 3600) == 1) {
                sb.append("1hr ");
            }
            sb.append(String.format("%dmin", (seconds % 3600) / 60));
            return sb.toString();
        } catch (ApplicationException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
