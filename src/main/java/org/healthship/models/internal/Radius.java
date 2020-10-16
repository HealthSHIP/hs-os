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

import java.util.stream.Stream;

public enum Radius {
    // int is used to access array
    _3km(3), _5km(5), _8km(8),
    _13km(13), _21km(21), _34km(34), _55km(55);

    public int getMetres() {
        return km * 1000;
    }

    private int km;

    Radius(int km) {
        this.km = km;
    }

    public int getKm() {
        return km;
    }

    public static Radius of(int km) {
        return Stream.of(Radius.values())
                .filter(p -> p.getKm() == km)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
