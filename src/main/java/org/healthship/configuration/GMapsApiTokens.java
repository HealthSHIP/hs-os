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

package org.healthship.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("gMapsApiTokens")
@ConfigurationProperties(prefix = "api-tokens.gmaps")
public class GMapsApiTokens {
    private String javaScript;
    private String matrix;

    public String getJavaScript() {
        return javaScript;
    }

    public GMapsApiTokens setJavaScript(String javaScript) {
        this.javaScript = javaScript;
        return this;
    }

    public String getMatrix() {
        return matrix;
    }

    public GMapsApiTokens setMatrix(String matrix) {
        this.matrix = matrix;
        return this;
    }
}
