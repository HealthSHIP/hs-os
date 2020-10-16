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

import com.google.common.io.Resources;
import com.sun.mail.smtp.SMTPTransport;
import org.healthship.exceptions.ApplicationException;
import org.healthship.models.User;
import org.healthship.models.internal.HSHTMLEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

@Service
public class EmailSenderSvc {
    private static final Logger logger = LoggerFactory.getLogger(EmailSenderSvc.class);

    Properties prop = System.getProperties();

    @Autowired
    private Environment environment;

    @Value("${base-url}")
    String baseURL;

    @Value("${mail-from}")
    private String mailFrom;

    @Value("${mail.subject.prefix:HealthSHIP}")
    private String subjectPrefix;

    @Value("${smtp.hostname}")
    private String hostname;

    @Value("${smtp.username}")
    private String username;

    @Value("${smtp.password}")
    private String password;

    @Value("${force-live-email:false}")
    private Boolean forceLiveMail;

    @Autowired
    Environment env;

    @PostConstruct
    public void postConstruct() throws IOException {
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.starttls.enable", "true");

        // only used for testing our resources are available on startup
        Resources.getResource("templates/static/emails/one_button.html");
        Resources.getResource("templates/static/emails/three_buttons.html");
    }

    void sendEmail(User toUser, String subject, HSHTMLEmail message, Map<String, String> customHeaders) throws ApplicationException {
        sendEmail(toUser.getContactEmail(), subject, message, mailFrom, customHeaders);
    }

    void sendEmail(String toUser, String subject, HSHTMLEmail message, Map<String, String> customHeaders) throws ApplicationException {
        sendEmail(toUser, subject, message, mailFrom, customHeaders);
    }
    
    /**
     *
     * This should ONLY be called directly for functions that require a specific email address to be used
     * ... all other cases should pass the User object, so that the preferred email address can be used
     *
     * @param toUser Email address for user
     * @param subject Subject of email
     * @param message Message to send
     * @throws ApplicationException In case of any errors
     */
    void sendEmail(String toUser, String subject, HSHTMLEmail message, String mailFrom, Map<String, String> customHeaders) throws ApplicationException {
        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);

        try {
            msg.setFrom(new InternetAddress(mailFrom));
            if (!isLive()) {
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailFrom, false));
            }
            else {
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toUser, false));
            }
            msg.setSubject(String.format("%s | %s", subjectPrefix, subject));
            msg.addHeader("List-Unsubscribe", String.format("%s/unsubscribe?token=%s", baseURL, UUID.randomUUID().toString()));

            if (null != customHeaders) {
                for (Map.Entry<String, String> entry : customHeaders.entrySet()) {
                    msg.addHeader(String.format("X-HealthSHIP-%s", entry.getKey()), entry.getValue());
                }
            }

            Multipart multiPart = new MimeMultipart("alternative");
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(getText(message), "utf-8");

            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(message.getHtmlMessage(), "text/html; charset=utf-8");

            multiPart.addBodyPart(textPart); // must be first
            multiPart.addBodyPart(htmlPart);
            msg.setContent(multiPart);

            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
            t.connect(hostname, 587, username, password);
            t.sendMessage(msg, msg.getAllRecipients());
            logger.info(String.format("SMTP response: %s", t.getLastServerResponse()));
        } catch (MessagingException e) {
            throw new ApplicationException(String.format(
                    "Unable to send email to user %s (subject: %s)", toUser, subject), e);
        }
    }

    // return the text only ... for mime multipart
    private String getText(HSHTMLEmail message) {
        StringBuilder sb = new StringBuilder(message.getWelcome());
        sb.append(String.format("%n%nYou are viewing this in text-only"));
        sb.append(String.format("%n%n%s", message.getLine1()));
        sb.append(String.format("%n%n%s", message.getLine2()));
        sb.append(String.format("%n%nFurther information is available below"));
        sb.append(String.format("%n%n%s", message.getButtonLink()));
        sb.append(String.format("%n%n---------------------"));
        sb.append(String.format("%n%nThanks, the HealthSHIP team"));
        return sb.toString();
    }

    static class HTMLDataSource implements DataSource {
        private String html;
        public HTMLDataSource(String htmlString) {
            html = htmlString;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            if (html == null) throw new IOException("HTML message is null!");
            return new ByteArrayInputStream(html.getBytes());
        }

        @Override
        public OutputStream getOutputStream() throws IOException {
            throw new IOException("This DataHandler cannot write HTML");
        }

        @Override
        public String getContentType() {
            return "text/html";
        }

        @Override
        public String getName() {
            return "HTMLDataSource";
        }
    }

    public boolean isLive() {
        for (String activeProfile : env.getActiveProfiles()) {
            if (activeProfile.equalsIgnoreCase("gcp") ||
                    activeProfile.equalsIgnoreCase("aws")) {
                return true;
            }
        }
        if (forceLiveMail) {
            logger.warn("Forcing LIVE OUTBOUND MAIL");
            return true;
        }
        logger.info("environment != live");
        return false;
    }
}
