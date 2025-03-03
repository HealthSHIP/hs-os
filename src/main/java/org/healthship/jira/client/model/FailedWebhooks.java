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

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A page of failed webhooks.
 */
@ApiModel(description = "A page of failed webhooks.")
@JsonPropertyOrder({
  FailedWebhooks.JSON_PROPERTY_VALUES,
  FailedWebhooks.JSON_PROPERTY_MAX_RESULTS,
  FailedWebhooks.JSON_PROPERTY_NEXT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class FailedWebhooks {
  public static final String JSON_PROPERTY_VALUES = "values";
  private List<FailedWebhook> values = new ArrayList<>();

  public static final String JSON_PROPERTY_MAX_RESULTS = "maxResults";
  private Integer maxResults;

  public static final String JSON_PROPERTY_NEXT = "next";
  private URI next;


  public FailedWebhooks values(List<FailedWebhook> values) {
    
    this.values = values;
    return this;
  }

  public FailedWebhooks addValuesItem(FailedWebhook valuesItem) {
    this.values.add(valuesItem);
    return this;
  }

   /**
   * The list of webhooks.
   * @return values
  **/
  @ApiModelProperty(required = true, value = "The list of webhooks.")
  @JsonProperty(JSON_PROPERTY_VALUES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<FailedWebhook> getValues() {
    return values;
  }


  public void setValues(List<FailedWebhook> values) {
    this.values = values;
  }


  public FailedWebhooks maxResults(Integer maxResults) {
    
    this.maxResults = maxResults;
    return this;
  }

   /**
   * The maximum number of items on the page. If the list of values is shorter than this number, then there are no more pages.
   * @return maxResults
  **/
  @ApiModelProperty(required = true, value = "The maximum number of items on the page. If the list of values is shorter than this number, then there are no more pages.")
  @JsonProperty(JSON_PROPERTY_MAX_RESULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getMaxResults() {
    return maxResults;
  }


  public void setMaxResults(Integer maxResults) {
    this.maxResults = maxResults;
  }


  public FailedWebhooks next(URI next) {
    
    this.next = next;
    return this;
  }

   /**
   * The URL to the next page of results. Present only if the request returned at least one result.The next page may be empty at the time of receiving the response, but new failed webhooks may appear in time. You can save the URL to the next page and query for new results periodically (for example, every hour).
   * @return next
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL to the next page of results. Present only if the request returned at least one result.The next page may be empty at the time of receiving the response, but new failed webhooks may appear in time. You can save the URL to the next page and query for new results periodically (for example, every hour).")
  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public URI getNext() {
    return next;
  }


  public void setNext(URI next) {
    this.next = next;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailedWebhooks failedWebhooks = (FailedWebhooks) o;
    return Objects.equals(this.values, failedWebhooks.values) &&
        Objects.equals(this.maxResults, failedWebhooks.maxResults) &&
        Objects.equals(this.next, failedWebhooks.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values, maxResults, next);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailedWebhooks {\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
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

