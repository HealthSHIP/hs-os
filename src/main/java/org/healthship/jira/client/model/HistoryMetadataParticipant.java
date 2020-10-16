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
 * Details of user or system associated with a issue history metadata item.
 */
@ApiModel(description = "Details of user or system associated with a issue history metadata item.")
@JsonPropertyOrder({
  HistoryMetadataParticipant.JSON_PROPERTY_ID,
  HistoryMetadataParticipant.JSON_PROPERTY_DISPLAY_NAME,
  HistoryMetadataParticipant.JSON_PROPERTY_DISPLAY_NAME_KEY,
  HistoryMetadataParticipant.JSON_PROPERTY_TYPE,
  HistoryMetadataParticipant.JSON_PROPERTY_AVATAR_URL,
  HistoryMetadataParticipant.JSON_PROPERTY_URL
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class HistoryMetadataParticipant extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;

  public static final String JSON_PROPERTY_DISPLAY_NAME_KEY = "displayNameKey";
  private String displayNameKey;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_AVATAR_URL = "avatarUrl";
  private String avatarUrl;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;


  public HistoryMetadataParticipant id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * The ID of the user or system associated with a history record.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the user or system associated with a history record.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public HistoryMetadataParticipant displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * The display name of the user or system associated with a history record.
   * @return displayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The display name of the user or system associated with a history record.")
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public HistoryMetadataParticipant displayNameKey(String displayNameKey) {
    
    this.displayNameKey = displayNameKey;
    return this;
  }

   /**
   * The key of the display name of the user or system associated with a history record.
   * @return displayNameKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The key of the display name of the user or system associated with a history record.")
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayNameKey() {
    return displayNameKey;
  }


  public void setDisplayNameKey(String displayNameKey) {
    this.displayNameKey = displayNameKey;
  }


  public HistoryMetadataParticipant type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * The type of the user or system associated with a history record.
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the user or system associated with a history record.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getType() {
    return type;
  }


  public void setType(String type) {
    this.type = type;
  }


  public HistoryMetadataParticipant avatarUrl(String avatarUrl) {
    
    this.avatarUrl = avatarUrl;
    return this;
  }

   /**
   * The URL to an avatar for the user or system associated with a history record.
   * @return avatarUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL to an avatar for the user or system associated with a history record.")
  @JsonProperty(JSON_PROPERTY_AVATAR_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAvatarUrl() {
    return avatarUrl;
  }


  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }


  public HistoryMetadataParticipant url(String url) {
    
    this.url = url;
    return this;
  }

   /**
   * The URL of the user or system associated with a history record.
   * @return url
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the user or system associated with a history record.")
  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

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
    HistoryMetadataParticipant historyMetadataParticipant = (HistoryMetadataParticipant) o;
    return Objects.equals(this.id, historyMetadataParticipant.id) &&
        Objects.equals(this.displayName, historyMetadataParticipant.displayName) &&
        Objects.equals(this.displayNameKey, historyMetadataParticipant.displayNameKey) &&
        Objects.equals(this.type, historyMetadataParticipant.type) &&
        Objects.equals(this.avatarUrl, historyMetadataParticipant.avatarUrl) &&
        Objects.equals(this.url, historyMetadataParticipant.url) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, displayName, displayNameKey, type, avatarUrl, url, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistoryMetadataParticipant {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    displayNameKey: ").append(toIndentedString(displayNameKey)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    avatarUrl: ").append(toIndentedString(avatarUrl)).append("\n");
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

