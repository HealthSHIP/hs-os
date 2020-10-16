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

import si.uom.SI;
import systems.uom.common.USCustomary;

import javax.measure.Unit;
import javax.measure.quantity.Length;

import static si.uom.NonSI.ANGSTROM;

public enum UserUOM {
    // each array must be 7 long
    miles(USCustomary.MILE, "%.1f","mi"),
    kilometres(SI.METRE.multiply(1000), "%.1f", "km"),
    angstroms(ANGSTROM, "%1.2e","Å"),
    bus_lengths(SI.METRE.multiply(11.23), "%.1f", "bus lengths");

    private String format;
    private Unit<Length> unit;

    public String getAbbreviation() {
        return abbreviation;
    }

    public UserUOM setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
        return this;
    }

    private String abbreviation;

    UserUOM(Unit<Length> unit, String format, String abbreviation) {
        this.unit = unit;
        this.format = format;
        this.abbreviation = abbreviation;
    }

    public String getFormattedDistance(double distanceMetres) {
        return String.format(this.format, SI.METRE.getConverterTo(this.unit).convert(distanceMetres));
    }

    public Unit<Length> getUnit() {
        return unit;
    }

    public String getFormat() {
        return format;
    }

    public UserUOM setFormat(String format) {
        this.format = format;
        return this;
    }
}
