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

import java.util.Objects;

/**
 * Details about the time tracking provider.
 */
@ApiModel(description = "Details about the time tracking provider.")
@JsonPropertyOrder({
  TimeTrackingProvider.JSON_PROPERTY_KEY,
  TimeTrackingProvider.JSON_PROPERTY_NAME,
  TimeTrackingProvider.JSON_PROPERTY_URL
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class TimeTrackingProvider {
  public static final String JSON_PROPERTY_KEY = "key";
  private String key;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;


  public TimeTrackingProvider key(String key) {
    
    this.key = key;
    return this;
  }

   /**
   * The key for the time tracking provider. For example, *JIRA*.
   * @return key
  **/
  @ApiModelProperty(required = true, value = "The key for the time tracking provider. For example, *JIRA*.")
  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getKey() {
    return key;
  }


  public void setKey(String key) {
    this.key = key;
  }


  public TimeTrackingProvider name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the time tracking provider. For example, *JIRA provided time tracking*.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the time tracking provider. For example, *JIRA provided time tracking*.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


   /**
   * The URL of the configuration page for the time tracking provider app. For example, *_/example/config/url*. This property is only returned if the &#x60;adminPageKey&#x60; property is set in the module descriptor of the time tracking provider app.
   * @return url
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the configuration page for the time tracking provider app. For example, *_/example/config/url*. This property is only returned if the `adminPageKey` property is set in the module descriptor of the time tracking provider app.")
  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUrl() {
    return url;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeTrackingProvider timeTrackingProvider = (TimeTrackingProvider) o;
    return Objects.equals(this.key, timeTrackingProvider.key) &&
        Objects.equals(this.name, timeTrackingProvider.name) &&
        Objects.equals(this.url, timeTrackingProvider.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, name, url);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeTrackingProvider {\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

