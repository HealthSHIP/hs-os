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
 * A status.
 */
@ApiModel(description = "A status.")
@JsonPropertyOrder({
  StatusDetails.JSON_PROPERTY_SELF,
  StatusDetails.JSON_PROPERTY_DESCRIPTION,
  StatusDetails.JSON_PROPERTY_ICON_URL,
  StatusDetails.JSON_PROPERTY_NAME,
  StatusDetails.JSON_PROPERTY_ID,
  StatusDetails.JSON_PROPERTY_STATUS_CATEGORY
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class StatusDetails extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_SELF = "self";
  private String self;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_ICON_URL = "iconUrl";
  private String iconUrl;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_STATUS_CATEGORY = "statusCategory";
  private StatusCategory statusCategory = null;


   /**
   * The URL of the status.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the status.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSelf() {
    return self;
  }




   /**
   * The description of the status.
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description of the status.")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }




   /**
   * The URL of the icon used to represent the status.
   * @return iconUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the icon used to represent the status.")
  @JsonProperty(JSON_PROPERTY_ICON_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getIconUrl() {
    return iconUrl;
  }




   /**
   * The name of the status.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the status.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }




   /**
   * The ID of the status.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the status.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }




   /**
   * The category assigned to the status.
   * @return statusCategory
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The category assigned to the status.")
  @JsonProperty(JSON_PROPERTY_STATUS_CATEGORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public StatusCategory getStatusCategory() {
    return statusCategory;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusDetails statusDetails = (StatusDetails) o;
    return Objects.equals(this.self, statusDetails.self) &&
        Objects.equals(this.description, statusDetails.description) &&
        Objects.equals(this.iconUrl, statusDetails.iconUrl) &&
        Objects.equals(this.name, statusDetails.name) &&
        Objects.equals(this.id, statusDetails.id) &&
        Objects.equals(this.statusCategory, statusDetails.statusCategory) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, description, iconUrl, name, id, statusCategory, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusDetails {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    iconUrl: ").append(toIndentedString(iconUrl)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    statusCategory: ").append(toIndentedString(statusCategory)).append("\n");
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

