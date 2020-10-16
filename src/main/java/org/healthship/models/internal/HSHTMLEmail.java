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

import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;

public class HSHTMLEmail {
    private static final Logger logger = LoggerFactory.getLogger(HSHTMLEmail.class);

    // not ideal .. need to think about this structure
    String htmlMessage;
    String welcome;
    String line1;
    String line2;
    String buttonLink;
    String buttonText;

    /**
     * None of the arguments must be null
     * @param welcome eg 'Hi!'
     * @param line1 First line of email
     * @param line2 Second line of email, may be an empty str but NOT null
     * @param buttonLink link href
     * @param buttonText link text
     */
    public HSHTMLEmail(String welcome, String line1, String line2, String buttonLink, String buttonText) {
        this.welcome = welcome;
        this.line1 = line1;
        this.line2 = line2;
        this.buttonLink = buttonLink;
        this.buttonText = buttonText;
        try {
            htmlMessage = Resources.toString(Resources.getResource(
                    "templates/static/emails/one_button.html"
            ), Charset.defaultCharset())
                    .replace("__WELCOME__", welcome)
                    .replace("__LINE_1__", line1)
                    .replace("__LINE_2__", line2)
                    .replace("__BUTTON_LINK__", buttonLink)
                    .replace("__BUTTON_TEXT__", buttonText);
        } catch (IOException e) {
            // shouldn't happen, because the template was already loaded at @PostConstruct
            logger.error(e.getMessage(), e);
        }
    }

    public HSHTMLEmail(String welcome, String line1, String line2,
                       String buttonGreenLink, String buttonGreenText,
                       String buttonBlueLink, String buttonBlueText,
                       String buttonRedLink, String buttonRedText
    ) {
        this.welcome = welcome;
        this.line1 = line1;
        this.line2 = line2;

        // just use primary link in the non-HTML messages
        this.buttonLink = buttonGreenLink;
        this.buttonText = buttonGreenText;

        try {
            htmlMessage = Resources.toString(Resources.getResource(
                    "templates/static/emails/three_buttons.html"
            ), Charset.defaultCharset())
                    .replace("__WELCOME__", welcome)
                    .replace("__LINE_1__", line1)
                    .replace("__LINE_2__", line2)
                    .replace("__BUTTON_GREEN_LINK__", buttonGreenLink)
                    .replace("__BUTTON_GREEN_TEXT__", buttonGreenText)
                    .replace("__BUTTON_BLUE_LINK__", buttonBlueLink)
                    .replace("__BUTTON_BLUE_TEXT__", buttonBlueText)
                    .replace("__BUTTON_RED_LINK__", buttonRedLink)
                    .replace("__BUTTON_RED_TEXT__", buttonRedText);
        } catch (IOException e) {
            // shouldn't happen, because the template was already loaded at @PostConstruct
            logger.error(e.getMessage(), e);
        }
    }

    public String getHtmlMessage() {
        return htmlMessage;
    }

    public String getWelcome() {
        return welcome;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getButtonLink() {
        return buttonLink;
    }

}
