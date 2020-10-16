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

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.healthship.configuration.VendorApiTokens;
import org.healthship.exceptions.ApplicationException;
import org.healthship.models.HelpRequest;
import org.healthship.models.ShortCode;
import org.healthship.models.User;
import org.healthship.models.internal.Ping;
import org.healthship.models.internal.PingType;
import org.healthship.models.rest.TXTLocalResponse;
import org.healthship.repos.PingRepo;
import org.healthship.repos.ShortCodesRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Service
public class SMSServiceImpl implements SMSService {
    private static final Logger logger = LoggerFactory.getLogger(SMSServiceImpl.class);

    VendorApiTokens vendorApiTokens;
    RestOperations restOperations;
    ShortCodesRepo shortCodesRepo;
    PingRepo pingRepo;

    private static final String SMS_API_KEY = "apiKey";
    private static final String SMS_MESSAGE = "message";
    private static final String SMS_SENDER = "sender";
    private static final String SMS_NUMBERS = "numbers";

    @Value("${sms.base-uri}")
    URI smsBaseURI;

    @Value("${sms.sender:HealthSHIP}")
    String smsSender;

    @Autowired
    Environment env;

    public SMSServiceImpl(VendorApiTokens vendorApiTokens, RestOperations restOperations, ShortCodesRepo shortCodesRepo, PingRepo pingRepo) {
        this.vendorApiTokens = vendorApiTokens;
        this.restOperations = restOperations;
        this.shortCodesRepo = shortCodesRepo;
        this.pingRepo = pingRepo;
    }

    @Override
    public void pingLocalVolunteer(User volunteer, HelpRequest helpRequest) throws ApplicationException {

        ShortCode sc = generate(volunteer, helpRequest);

        String message = String.format(
                "Hey %s, can you help someone %s from you %s? https://healthship.org/m/%s",
                Utils.getFirstName(volunteer.getName()),
                DistanceCalculator.getCrowDistanceBetweenUserAndOriginAsString(volunteer, helpRequest),
                helpRequest.getLocalDateTimeTo(volunteer.getTimezone()).format(
                    DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.UK)
                ),
                sc.getShortCode()
        );

        URIBuilder b = new URIBuilder(smsBaseURI);
        b.addParameter(SMS_API_KEY, vendorApiTokens.getTxtlocal());
        b.addParameter(SMS_MESSAGE, message);
        b.addParameter(SMS_SENDER, smsSender);
        b.addParameter(SMS_NUMBERS, volunteer.getPhone());
        if (!isProduction()) {
            b.addParameter("test", "true");
        }

        try {
            TXTLocalResponse response = restOperations.postForObject(b.build(), null, TXTLocalResponse.class);
            logger.info("Got response for {}: {}", volunteer.getPhone(), response);

            shortCodesRepo.save(sc);
            logger.debug("Persisted short code: {}", sc);

            Ping p = new Ping(helpRequest, volunteer, PingType.sms);
            pingRepo.save(p);
            logger.debug("Persisted ping: {}", p);
        } catch (URISyntaxException e) {
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    private ShortCode generate(User user, HelpRequest helpRequest) {
        int codeLength = 6;
        String code = RandomStringUtils.randomAlphanumeric(codeLength);
        while (shortCodesRepo.existsById(code)) {
            code = RandomStringUtils.randomAlphanumeric(codeLength);
        }
        return new ShortCode(code, user, helpRequest);
    }

    private boolean isProduction() {
        for (String activeProfile : env.getActiveProfiles()) {
            if (activeProfile.equalsIgnoreCase("gcp")) {
                return true;
            }
        }
        logger.info("environment != production");
        return false;
    }
}
