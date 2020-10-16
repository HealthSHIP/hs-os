# HealthSHIP

## Running locally

An application-local.properties must be created and populated with the following fields:

```
smtp.hostname=YOUR_SMTP_SERVER
smtp.username=YOUR_SMTP_USERNAME
smtp.password=YOUR_SMTP_PASSWORD

# optional SQL file for loading test / dummy data
#spring.datasource.data=file:./local/test-data.sql

# to allow reCaptcha to work on localhost
google.recaptcha.key.site=6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI
google.recaptcha.key.secret=6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe

# SSO TOKEN: this is signed using a private key
# note this key is for TEST ONLY and gets overwritten on live
mod-pubtkt.key=classpath:./keys/privkey.pem
```

Then you should be able to run `mvn clean package && java -Dspring.profiles.active=local,h2 -jar target/<jarfile>`

### Issues running locally

Some common errors are below plus info on how to fix them.

#### Unable to start

```
Request processing failed; nested exception is 
    org.thymeleaf.exceptions.TemplateProcessingException: Exception evaluating SpringEL expression: "@gitProperties.getCommitId()
```

This is caused by the `@gitProperties` bean not being instantiated. This can only be instantiated
if a full `mvn clean package` has been run, before attempting to run this codebase in the IDE.  

## Building and deploying

NB: You will not be able to deploy onto the production infrastructure without access to the GCP project (email maintainer
for details).


```
mvn clean package appengine:deploy
```
