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

import org.healthship.configuration.ReCaptchaSettings;
import org.healthship.exceptions.ReCaptchaException;
import org.healthship.models.internal.ReCaptchaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.regex.Pattern;

@Service
public class CaptchaServiceImpl implements ICaptchaService {
    private static final Logger logger = LoggerFactory.getLogger(CaptchaServiceImpl.class);

    private final HttpServletRequest request;
    private ReCaptchaSecuritySvc reCaptchaSecuritySvc;
    private final ReCaptchaSettings captchaSettings;
    private final RestOperations restTemplate;

    private static Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");

    public CaptchaServiceImpl(ReCaptchaSecuritySvc reCaptchaSecuritySvc, HttpServletRequest request, ReCaptchaSettings captchaSettings, RestOperations restTemplate) {
        this.reCaptchaSecuritySvc = reCaptchaSecuritySvc;
        this.request = request;
        this.captchaSettings = captchaSettings;
        this.restTemplate = restTemplate;
    }

    @Override
    public void processResponse(String response) throws ReCaptchaException {
        logger.debug("Attempting to validate response {}", response);

        if(!responseSanityCheck(response)) {
            throw new ReCaptchaException("Response contains invalid characters");
        }
        if(reCaptchaSecuritySvc.isBlocked(getClientIP())) {
            throw new ReCaptchaException("Client exceeded maximum number of failed attempts");
        }

        final URI verifyUri = URI.create(String.format("https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s", getReCaptchaSecret(), response, getClientIP()));
        try {
            final ReCaptchaResponse googleResponse = restTemplate.getForObject(verifyUri, ReCaptchaResponse.class);
            if (null == googleResponse) throw new ReCaptchaException("Google response was null");
            logger.debug("Google's response: {} ", googleResponse.toString());

            if (!googleResponse.isSuccess()) {
                if (googleResponse.hasClientError()) {
                    reCaptchaSecuritySvc.reCaptchaFailed(getClientIP());
                }
                throw new ReCaptchaException("reCaptcha was not successfully validated");
            }
        } catch (RestClientException rce) {
            throw new ReCaptchaException("Registration unavailable at this time.  Please try again later.", rce);
        }
        reCaptchaSecuritySvc.reCaptchaSucceeded(getClientIP());
    }

    private boolean responseSanityCheck(String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }

    @Override
    public String getReCaptchaSite() {
        return captchaSettings.getSite();
    }

    @Override
    public String getReCaptchaSecret() {
        return captchaSettings.getSecret();
    }

    private String getClientIP() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}