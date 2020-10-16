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

package org.healthship.controllers.rest;

import org.healthship.models.rest.DistanceMatrixResponse;
import org.healthship.tasks.PingLocalUsersSchdTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

@RestController
@Profile("local")
public class LocalRestFunctions {

    RestOperations restOperations;
    PingLocalUsersSchdTask pingSvcs;

    @Value("${api-tokens.gmaps.javaScript}")
    String apiToken;

    LocalRestFunctions(RestOperations restOperations, PingLocalUsersSchdTask pingSvcs) {
        this.restOperations = restOperations;
        this.pingSvcs = pingSvcs;
    }

    @RequestMapping("/api/debug/lookupLocation")
    public ResponseEntity<DistanceMatrixResponse> getDistance() {
        DistanceMatrixResponse r = restOperations.getForObject(
                String.format("https://maps.googleapis.com/maps/api/distancematrix/json?origins=56.34,-2.82&destinations=55.94,13.35" +
                        "&key=%s", apiToken),
                DistanceMatrixResponse.class
        );
        System.out.println("test");
        return ResponseEntity.ok(r);
    }

}
