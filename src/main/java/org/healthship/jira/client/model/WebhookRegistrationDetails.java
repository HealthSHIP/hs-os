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

/*
 * The Jira Cloud platform REST API
 * Jira Cloud platform REST API documentation
 *
 * The version of the OpenAPI document: 1001.0.0-SNAPSHOT
 * Contact: ecosystem@atlassian.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.healthship.jira.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Details of webhooks to register.
 */
@ApiModel(description = "Details of webhooks to register.")
@JsonPropertyOrder({
  WebhookRegistrationDetails.JSON_PROPERTY_WEBHOOKS,
  WebhookRegistrationDetails.JSON_PROPERTY_URL
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class WebhookRegistrationDetails {
  public static final String JSON_PROPERTY_WEBHOOKS = "webhooks";
  private List<WebhookDetails> webhooks = new ArrayList<>();

  public static final String JSON_PROPERTY_URL = "url";
  private String url;


  public WebhookRegistrationDetails webhooks(List<WebhookDetails> webhooks) {
    
    this.webhooks = webhooks;
    return this;
  }

  public WebhookRegistrationDetails addWebhooksItem(WebhookDetails webhooksItem) {
    this.webhooks.add(webhooksItem);
    return this;
  }

   /**
   * A list of webhooks.
   * @return webhooks
  **/
  @ApiModelProperty(required = true, value = "A list of webhooks.")
  @JsonProperty(JSON_PROPERTY_WEBHOOKS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<WebhookDetails> getWebhooks() {
    return webhooks;
  }


  public void setWebhooks(List<WebhookDetails> webhooks) {
    this.webhooks = webhooks;
  }


  public WebhookRegistrationDetails url(String url) {
    
    this.url = url;
    return this;
  }

   /**
   * The URL that specifies where to send the webhooks.
   * @return url
  **/
  @ApiModelProperty(required = true, value = "The URL that specifies where to send the webhooks.")
  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUrl() {
    return url;
  }


  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookRegistrationDetails webhookRegistrationDetails = (WebhookRegistrationDetails) o;
    return Objects.equals(this.webhooks, webhookRegistrationDetails.webhooks) &&
        Objects.equals(this.url, webhookRegistrationDetails.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(webhooks, url);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookRegistrationDetails {\n");
    sb.append("    webhooks: ").append(toIndentedString(webhooks)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

