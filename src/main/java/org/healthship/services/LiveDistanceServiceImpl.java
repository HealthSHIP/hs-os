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

import org.apache.http.client.utils.URIBuilder;
import org.healthship.configuration.GMapsApiTokens;
import org.healthship.exceptions.ApplicationException;
import org.healthship.models.Distance;
import org.healthship.models.HelpRequest;
import org.healthship.models.rest.DistanceMatrixResponse;
import org.healthship.models.rest.dm.Element;
import org.healthship.models.rest.dm.MapsResponseStatus;
import org.healthship.models.rest.dm.ResponseRow;
import org.healthship.repos.DistanceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service("liveDistanceService")
public class LiveDistanceServiceImpl implements LiveDistanceService {
    private static final Logger logger = LoggerFactory.getLogger(LiveDistanceServiceImpl.class);

    DistanceRepo distanceRepo;
    RestOperations restOperations;
    GMapsApiTokens gMapsApiTokens;

    @Value("${maps.distance-matrix.base-url}")
    URI mapsBaseURI;

    LiveDistanceServiceImpl(DistanceRepo distanceRepo, RestOperations restOperations, GMapsApiTokens gMapsApiTokens) {
        this.distanceRepo = distanceRepo;
        this.restOperations = restOperations;
        this.gMapsApiTokens = gMapsApiTokens;
    }

    private Distance getDistance(Float startLng, Float startLat, Float endLng, Float endLat) throws ApplicationException {
        return Optional.ofNullable(distanceRepo.findByIdEqualsAndUpdatedDTIsAfter(
                Distance.asID(startLng, startLat, endLng, endLat), ZonedDateTime.now().minusDays(7)
        )).orElse(getOrUpdateDistance(startLng, startLat, endLng, endLat));
    }

    private Distance getOrUpdateDistance(Float startLng, Float startLat, Float endLng, Float endLat) throws ApplicationException {
        // Distance d = new Distance(startLng, startLat, endLng, endLat)
        URIBuilder b = new URIBuilder(mapsBaseURI);
        b.addParameter("origins", String.format("%s,%s", startLat, startLng));
        b.addParameter("destinations", String.format("%s,%s", endLat, endLng));
        b.addParameter("key", gMapsApiTokens.getMatrix());
        DistanceMatrixResponse matrixResponse;
        try {
            matrixResponse = restOperations.getForObject(b.build(), DistanceMatrixResponse.class);
            if (null != matrixResponse && matrixResponse.getStatus().equals(MapsResponseStatus.OK)) {
                for (ResponseRow row : matrixResponse.getRows()) {
                    for (Element element : row.getElements()) {
                        if (null != element.getStatus() && element.getStatus().equals(MapsResponseStatus.OK)) {
                            Distance d = new Distance(
                                    startLng, startLat, endLng, endLat,
                                    element.getDistance().getValue(),
                                    element.getDuration().getValue()
                            );
                            return distanceRepo.saveAndFlush(d);
                        }
                    }
                }
            }
        } catch (URISyntaxException e) {
            throw new ApplicationException(e.getMessage(), e);
        }
        throw new ApplicationException(String.format("Distance could not be resolved: %s", null != matrixResponse ? matrixResponse.toString() : "null response"));
    }

    @Override
    public long distanceMetres(Float startLng, Float startLat, Float endLng, Float endLat) throws ApplicationException {
        return getDistance(startLng, startLat, endLng, endLat).getMetres();
    }

    @Override
    public long distanceSeconds(Float startLng, Float startLat, Float endLng, Float endLat) throws ApplicationException {
        return getDistance(startLng, startLat, endLng, endLat).getSeconds();
    }

    @Override
    public boolean isCached(HelpRequest helpRequest) {
        return null != distanceRepo.findByIdEqualsAndUpdatedDTIsAfter(
                Distance.asID(
                        helpRequest.getOriginLng(), helpRequest.getOriginLat(), helpRequest.getDestinationLng(), helpRequest.getDestinationLat()
                ), ZonedDateTime.now().minusDays(7)
        );
    }
}
