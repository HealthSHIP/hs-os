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

package org.healthship.models.rest.dm;

public enum MapsResponseStatus {
    OK, INVALID_REQUEST, // indicates that the provided request was invalid.
    MAX_ELEMENTS_EXCEEDED, // indicates that the product of origins and destinations exceeds the per-query limit.
    OVER_DAILY_LIMIT, // indicates as on the tin
    OVER_QUERY_LIMIT, // indicates the service has received too many requests from your application within the allowed time period.
    REQUEST_DENIED, //
    UNKNOWN_ERROR,

    NOT_FOUND, // indicates that the origin and/or destination of this pairing could not be geocoded.
    ZERO_RESULTS, // indicates no route could be found between the origin and destination.
    MAX_ROUTE_LENGTH_EXCEEDED, //  indicates the requested route is too long and cannot be processed.
}
