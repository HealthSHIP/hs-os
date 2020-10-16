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
import org.healthship.models.HelpWith;
import org.healthship.models.OneTimeToken;
import org.healthship.models.User;
import org.healthship.models.internal.HSHTMLEmail;
import org.healthship.models.internal.TokenType;
import org.healthship.repos.OneTimeTokenRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.GitProperties;
import org.springframework.stereotype.Component;
import si.uom.SI;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmailServiceImpl implements IEmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    EmailSenderSvc mailSender;
    Utils utils;
    OneTimeTokenRepo tokenRepo;

    @Autowired(required = false)
    GitProperties gitProperties;

    @Value("${base-url}")
    String baseURL;

    private static final String SUBJ_THANKS_FOR_VOLUNTEERING = "Thanks for volunteering to help";
    private static final String SUBJ_VOLUNTEERING_CONFIRMATION = "Volunteering confirmation";
    private static final String SUBJ_THANKS_FOR_OFFERING = "Thanks for offering to volunteer";
    private static final String SUBJ_REQUEST_ALREADY_FULFILLED = "Request for help already fulfilled";
    private static final String SUBJ_REQUEST_REMOVED = "Request for help removed by user";
    private static final String SUBJ_VOLUNTEER_HAS_ACCEPTED = "A volunteer has accepted your request for help";
    private static final String SUBJ_VOLUNTEER_HAS_RESPONDED = "A volunteer has responded to your request for help";
    private static final String SUBJ_VOUCH_FOR_USER = "Would you be able to vouch for %s?";
    private static final String SUBJ_CAN_YOU_HELP_USER_ANONYMOUS = "Are you able to help someone nearby?";
    private static final String SUBJ_CAN_YOU_HELP_USER_URGENT = "Someone near you needs help within the next 3 hours";

    private static final String VIEW_DETAILS = "view details";
    private static final String VIEW_CONFIRMATION = "view confirmation";
    private static final String VIEW_RESPONSES = "view all responses";
    private static final String PLEASE_ARRANGE_FURTHER_DETAILS = "Please arrange any further details between yourselves, " +
            "and remember to visit our recommendations (linked at the bottom of this message). ";
    private static final String PLEASE_ARRANGE_PLUS_ID = String.format(
            "%s Additionally, remember to take a copy of any criminal record check certificates with you, " +
                    "as well as some form of ID (passport / driving license, or similar).", PLEASE_ARRANGE_FURTHER_DETAILS);
    private static final String PLEASE_DO_PICKUP = "Please make your way to %s between %s and %s. If you require any further information " +
            "or have any difficulties undertaking this task, get in touch with the task organiser. Remember to inform the organiser " +
            "when this task is complete. ";
    private static final String PICKUP_INFO_SENT = "They have been instructed to attend %s before %s and will " +
            "contact you if any further information is required. ";

    enum MessageHeaders {
        REQ_ID("Request-ID"), APP_COMMIT("App-Version"), MESSAGE_TYPE("Msg-Type");
        private String key;

        MessageHeaders(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key;
        }
    }

    enum MessageType {
        TO_REQUESTEE, TO_VOLUNTEER, PING_VOLUNTEER
    }

    Map<String, String> constructHeaders(HelpRequest helpRequest, MessageType messageType) {
        Map<String, String> vals = new HashMap<>();
        vals.put(MessageHeaders.MESSAGE_TYPE.toString(), messageType.toString());
        if (null != gitProperties) {
            vals.put(MessageHeaders.APP_COMMIT.toString(), gitProperties.getCommitId());
        }
        if (null != helpRequest) {
            vals.put(MessageHeaders.REQ_ID.toString(), helpRequest.getId());
        }
        return vals;
    }

    public EmailServiceImpl(EmailSenderSvc mailSender, Utils utils, OneTimeTokenRepo tokenRepo) {
        this.mailSender = mailSender;
        this.utils = utils;
        this.tokenRepo = tokenRepo;
    }

    @Override
    public void sendVolunteerAutoAcceptedMessage(final User volunteer, final HelpRequest helpRequest) {
        final User clinician = helpRequest.getCreatedBy();

        StringBuilder _volunteer_line1 = new StringBuilder(
                thankYouForVolunteeringToHelpName(clinician, helpRequest, volunteer)
        );
        appendPhone(_volunteer_line1, clinician);
        appendInstructions(_volunteer_line1, helpRequest.getInstructions());

        String volLine2 = (helpRequest.getHelpWith().equals(HelpWith.meds) ?
                String.format(PLEASE_DO_PICKUP,
                        helpRequest.getOrigin(),
                        getFriendlyDTFrom(helpRequest, volunteer),
                        getFriendlyDTTo(helpRequest, volunteer)
                ) :
                PLEASE_ARRANGE_PLUS_ID
        );

        try {
            mailSender.sendEmail(volunteer, SUBJ_THANKS_FOR_VOLUNTEERING, new HSHTMLEmail(
                            dear(volunteer),
                            _volunteer_line1.toString(),
                            volLine2,
                            getRequestLink(helpRequest), VIEW_CONFIRMATION),
                    constructHeaders(helpRequest, MessageType.TO_VOLUNTEER)
            );
        } catch (ApplicationException e) {
            logger.error(getNotificationErrorForUser(volunteer, helpRequest), e);
        }

        StringBuilder _clinician_line1 = new StringBuilder(
                aUserHasVolunteeredToHelp(volunteer, helpRequest, clinician)
        );
        appendPhone(_clinician_line1, volunteer);

        String clinLine2;
        if (helpRequest.getHelpWith().equals(HelpWith.meds)) {
            clinLine2 = String.format(PICKUP_INFO_SENT, helpRequest.getOrigin(), getFriendlyDTTo(
                    helpRequest, clinician
            ));
        } else {
            clinLine2 = PLEASE_ARRANGE_FURTHER_DETAILS;
        }

        try {
            mailSender.sendEmail(clinician, SUBJ_VOLUNTEER_HAS_ACCEPTED, new HSHTMLEmail(
                            dear(clinician),
                            _clinician_line1.toString(),
                            clinLine2,
                            getRequestLink(helpRequest), VIEW_DETAILS),
                    constructHeaders(helpRequest, MessageType.TO_REQUESTEE)
            );
        } catch (ApplicationException e) {
            logger.error(getNotificationErrorForUser(clinician, helpRequest), e);
        }
    }

    @Override
    public void sendVolunteerManuallyAcceptedMessage(final User volunteer, final HelpRequest helpRequest) {
        final User clinician = helpRequest.getCreatedBy();

        StringBuilder _volunteer_line1 = new StringBuilder(
                thankYouForVolunteeringToHelpName(clinician, helpRequest, volunteer)
        );
        appendPhone(_volunteer_line1, clinician);
        appendInstructions(_volunteer_line1, helpRequest.getInstructions());

        String volLine2 = (helpRequest.getHelpWith().equals(HelpWith.meds) ?
                String.format(PLEASE_DO_PICKUP,
                        helpRequest.getOrigin(),
                        getFriendlyDTFrom(helpRequest, volunteer),
                        getFriendlyDTTo(helpRequest, volunteer)
                ) :
                PLEASE_ARRANGE_PLUS_ID
        );

        try {
            mailSender.sendEmail(volunteer, SUBJ_VOLUNTEERING_CONFIRMATION, new HSHTMLEmail(
                            dear(volunteer),
                            _volunteer_line1.toString(),
                            volLine2,
                            getRequestLink(helpRequest), VIEW_CONFIRMATION),
                    constructHeaders(helpRequest, MessageType.TO_VOLUNTEER)
            );
        } catch (ApplicationException e) {
            logger.error(getNotificationErrorForUser(volunteer, helpRequest), e);
        }

        StringBuilder _clinician_line1 = new StringBuilder(
                youHaveConfirmedAVolunteerToHelp(volunteer, helpRequest, clinician)
        );
        appendPhone(_clinician_line1, volunteer);

        String clinLine2;
        if (helpRequest.getHelpWith().equals(HelpWith.meds)) {
            clinLine2 = String.format(PICKUP_INFO_SENT, helpRequest.getOrigin(), getFriendlyDTTo(
                    helpRequest, clinician
            ));
        } else {
            clinLine2 = PLEASE_ARRANGE_FURTHER_DETAILS;
        }
        try {
            mailSender.sendEmail(clinician, SUBJ_VOLUNTEERING_CONFIRMATION, new HSHTMLEmail(
                            dear(clinician),
                            _clinician_line1.toString(),
                            clinLine2,
                            getRequestLink(helpRequest), VIEW_DETAILS),
                    constructHeaders(helpRequest, MessageType.TO_REQUESTEE)
            );
        } catch (ApplicationException e) {
            logger.error(getNotificationErrorForUser(clinician, helpRequest), e);
        }
    }

    private void appendInstructions(StringBuilder volunteer_line1, String instructions) {
        if (null != instructions && !instructions.isEmpty()) {
            volunteer_line1.append(String.format(
                    "Additionally, the organiser has appended the following instructions: '%s'. ",
                    instructions
            ));
        }
    }

    @Override
    public void sendVolunteerOfferedMessages(User volunteer, HelpRequest helpRequest) {
        final User clinician = helpRequest.getCreatedBy();
        try {
            StringBuilder _line_2 = new StringBuilder("Please get in touch with them to confirm this arrangement " +
                    "works for you both, before officially confirming via the button below. ");
            appendPhone(_line_2, volunteer);
            mailSender.sendEmail(clinician, SUBJ_VOLUNTEER_HAS_RESPONDED, new HSHTMLEmail(
                            dear(clinician),
                            String.format("%s has volunteered to help you on %s. ", nameAndEmail(volunteer), getFriendlyDTFrom(helpRequest, clinician)),
                            _line_2.toString(),
                            getRequestLink(helpRequest), VIEW_RESPONSES),
                    constructHeaders(helpRequest, MessageType.TO_REQUESTEE)
            );
        } catch (ApplicationException e) {
            logger.error(getNotificationErrorForUser(clinician, helpRequest), e);
        }
    }

    private String getRemoveListingLink(HelpRequest helpRequest) {
        OneTimeToken token = new OneTimeToken(helpRequest.getCreatedBy()).setTokenType(TokenType.unlist_request);
        tokenRepo.save(token);
        return String.format("%s/click/requests/%s/delete?token=%s", baseURL, helpRequest.getId(), token.getId());
    }

    private String getConfirmVolunteerLink(HelpRequest helpRequest, User volunteer) {
        OneTimeToken token = new OneTimeToken(helpRequest.getCreatedBy()).setTokenType(TokenType.confirm_volunteer);
        tokenRepo.save(token);
        return String.format("%s/click/requests/%s/confirm?user=%s&token=%s",
                baseURL, helpRequest.getId(), volunteer.getUsername(), token.getId()
        );
    }

    @Override
    public void sendVolunteerDeletedMessages(User volunteer, HelpRequest helpRequest) {
        final User clinician = helpRequest.getCreatedBy();

        try {
            mailSender.sendEmail(volunteer, SUBJ_REQUEST_REMOVED, new HSHTMLEmail(
                            dear(volunteer),
                            String.format("Thank you for volunteering to help on %s. ", getFriendlyDTFrom(helpRequest, volunteer)),
                            String.format("This is a courtesy notice to let you know that, due to a change of circumstances, %s has deleted " +
                                            "their request for help. Please keep an eye out though for any future posts. ",
                                    clinician.getName()
                            ),
                            baseURL, "see other posts"
                    ), constructHeaders(helpRequest, MessageType.TO_VOLUNTEER)
            );
        } catch (ApplicationException e) {
            logger.error(getNotificationErrorForUser(volunteer, helpRequest), e);
        }
    }

    @Override
    public void sendVolunteerRejectedMessages(User volunteer, HelpRequest helpRequest) {
        final User clinician = helpRequest.getCreatedBy();
        try {
            mailSender.sendEmail(volunteer, SUBJ_REQUEST_ALREADY_FULFILLED, new HSHTMLEmail(
                            dear(volunteer),
                            String.format("Thank you for volunteering to help on %s. ", getFriendlyDTFrom(helpRequest, volunteer)),
                            String.format("This is a courtesy notice to let you know that %s received a number of responses for their " +
                                    "request for help. They have selected another person to help with this particular task, " +
                                    "but please keep an eye out for any future posts.", clinician.getName()),
                            baseURL, "see other posts"
                    ), constructHeaders(helpRequest, MessageType.TO_VOLUNTEER)
            );
        } catch (ApplicationException e) {
            logger.error(getNotificationErrorForUser(volunteer, helpRequest), e);
        }
    }

    @Override
    public void sendManualVouchRequest(User clinician, User volunteer) {
        try {
            mailSender.sendEmail(clinician, String.format(SUBJ_VOUCH_FOR_USER, volunteer.getName()), new HSHTMLEmail(
                    dear(clinician),
                    String.format("%s has asked you to vouch for them on HealthSHIP. ", nameAndEmail(volunteer)),
                    "If you're willing to do this, please visit the page below for more information. ",
                    String.format("%s/vouch", baseURL), "pending requests"
            ), null);
        } catch (ApplicationException e) {
            logger.error("Unable to send email to ask clinician to vouch for user", e);
        }
    }

    @Override
    public void pingLocalVolunteer(User volunteer, HelpRequest helpRequest) {
        try {
            mailSender.sendEmail(volunteer, SUBJ_CAN_YOU_HELP_USER_ANONYMOUS, new HSHTMLEmail(
                            dear(volunteer),
                            String.format("Someone %.1f %s from you has requested help at the following time: %s.",
                                    SI.METRE.getConverterTo(volunteer.getUserUOM().getUnit()).convert((long)
                                            Utils.getDistanceMetres(
                                                    helpRequest.getOriginLng(), helpRequest.getOriginLat(),
                                                    volunteer.getLng(), volunteer.getLat()
                                            )
                                    ),
                                    volunteer.getUserUOM().getAbbreviation(),
                                    getFriendlyDTFrom(helpRequest, volunteer)
                            ),
                            "We've pinged you before sending this message to anyone further afield. If you're " +
                                    "available at this time, please have a look at their request for help below.",
                            getRequestLink(helpRequest), "view request"
                    ), constructHeaders(helpRequest, MessageType.PING_VOLUNTEER)
            );
        } catch (ApplicationException e) {
            logger.error("Unable to send email to ping a local volunteer", e);
        }
    }

    @Override
    public void urgentlyPingLocalVolunteer(User volunteer, HelpRequest helpRequest) {
        try {
            mailSender.sendEmail(volunteer, SUBJ_CAN_YOU_HELP_USER_URGENT, new HSHTMLEmail(
                    dear(volunteer),
                    String.format("Someone %.1f %s from you has requested help within the next three hours.",
                            SI.METRE.getConverterTo(volunteer.getUserUOM().getUnit()).convert((long)
                                    Utils.getDistanceMetres(
                                            helpRequest.getOriginLng(), helpRequest.getOriginLat(),
                                            volunteer.getLng(), volunteer.getLat()
                                    )
                            ),
                            volunteer.getUserUOM().getAbbreviation()
                    ),
                    "We've pinged you before sending this message to anyone further afield. If you're " +
                            "available at this time, please have a look at their request for help below.",
                    getRequestLink(helpRequest), "view request"
            ), constructHeaders(helpRequest, MessageType.TO_VOLUNTEER));
        } catch (ApplicationException e) {
            logger.error("Unable to send email to ping a local volunteer", e);
        }
    }

    private void appendPhone(StringBuilder stringBuilder, User appendNumberOfUser) {
        if (null != appendNumberOfUser.getPhone() && !appendNumberOfUser.getPhone().isEmpty()) {
            stringBuilder.append(String.format(
                    "They have also provided the telephone number %s for you to contact them by. ",
                    appendNumberOfUser.getPhone())
            );
        }
    }

    private String getRequestLink(HelpRequest helpRequest) {
        return String.format("%s/requests/%s", baseURL, helpRequest.getId());
    }

    private String nameAndEmail(User user) {
        return String.format("%s (%s)", user.getName(), user.getUsername());
    }

    private String dear(User user) {
        return String.format("Dear %s,", (null == user.getName() ? user.getUsername() : user.getName()));
    }

    private String getFriendlyDTFrom(HelpRequest helpRequest, User user) {
        return helpRequest.getLocalDateTimeFrom(user.getTimezone()).format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        );
    }

    private String getFriendlyDTTo(HelpRequest helpRequest, User user) {
        return helpRequest.getLocalDateTimeTo(user.getTimezone()).format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        );
    }

    private String thankYouForVolunteeringToHelpName(User clinician, HelpRequest helpRequest, User volunteer) {
        return String.format(
                "Thank you for volunteering to help %s on %s. ",
                nameAndEmail(clinician), getFriendlyDTFrom(helpRequest, volunteer)
        );
    }

    private String aUserHasVolunteeredToHelp(User volunteer, HelpRequest helpRequest, User clinician) {
        return String.format(
                "%s has volunteered to help you on %s. ",
                nameAndEmail(volunteer), getFriendlyDTFrom(helpRequest, clinician)
        );
    }

    private String youHaveConfirmedAVolunteerToHelp(User volunteer, HelpRequest helpRequest, User clinician) {
        return String.format(
                "You've confirmed that you wish %s to help you at the following date and time: %s. ",
                nameAndEmail(volunteer), getFriendlyDTFrom(helpRequest, clinician)
        );
    }

    private String getNotificationErrorForUser(User user, HelpRequest helpRequest) {
        return String.format("Unable to send notification to %s for request ID %s", user.getUsername(), helpRequest.getId());
    }
}
