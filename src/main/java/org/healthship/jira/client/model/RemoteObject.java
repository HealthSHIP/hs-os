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

import java.util.HashMap;
import java.util.Objects;

/**
 * The linked item.
 */
@ApiModel(description = "The linked item.")
@JsonPropertyOrder({
  RemoteObject.JSON_PROPERTY_URL,
  RemoteObject.JSON_PROPERTY_TITLE,
  RemoteObject.JSON_PROPERTY_SUMMARY,
  RemoteObject.JSON_PROPERTY_ICON,
  RemoteObject.JSON_PROPERTY_STATUS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class RemoteObject extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;

  public static final String JSON_PROPERTY_SUMMARY = "summary";
  private String summary;

  public static final String JSON_PROPERTY_ICON = "icon";
  private Icon icon = null;

  public static final String JSON_PROPERTY_STATUS = "status";
  private Status status = null;


  public RemoteObject url(String url) {
    
    this.url = url;
    return this;
  }

   /**
   * The URL of the item.
   * @return url
  **/
  @ApiModelProperty(required = true, value = "The URL of the item.")
  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUrl() {
    return url;
  }


  public void setUrl(String url) {
    this.url = url;
  }


  public RemoteObject title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * The title of the item.
   * @return title
  **/
  @ApiModelProperty(required = true, value = "The title of the item.")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public RemoteObject summary(String summary) {
    
    this.summary = summary;
    return this;
  }

   /**
   * The summary details of the item.
   * @return summary
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The summary details of the item.")
  @JsonProperty(JSON_PROPERTY_SUMMARY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSummary() {
    return summary;
  }


  public void setSummary(String summary) {
    this.summary = summary;
  }


  public RemoteObject icon(Icon icon) {
    
    this.icon = icon;
    return this;
  }

   /**
   * Details of the icon for the item. If no icon is defined, the default link icon is used in Jira.
   * @return icon
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of the icon for the item. If no icon is defined, the default link icon is used in Jira.")
  @JsonProperty(JSON_PROPERTY_ICON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Icon getIcon() {
    return icon;
  }


  public void setIcon(Icon icon) {
    this.icon = icon;
  }


  public RemoteObject status(Status status) {
    
    this.status = status;
    return this;
  }

   /**
   * The status of the item.
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of the item.")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Status getStatus() {
    return status;
  }


  public void setStatus(Status status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RemoteObject remoteObject = (RemoteObject) o;
    return Objects.equals(this.url, remoteObject.url) &&
        Objects.equals(this.title, remoteObject.title) &&
        Objects.equals(this.summary, remoteObject.summary) &&
        Objects.equals(this.icon, remoteObject.icon) &&
        Objects.equals(this.status, remoteObject.status) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, title, summary, icon, status, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RemoteObject {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

