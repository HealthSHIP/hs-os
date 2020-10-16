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
 * A status category.
 */
@ApiModel(description = "A status category.")
@JsonPropertyOrder({
  StatusCategory.JSON_PROPERTY_SELF,
  StatusCategory.JSON_PROPERTY_ID,
  StatusCategory.JSON_PROPERTY_KEY,
  StatusCategory.JSON_PROPERTY_COLOR_NAME,
  StatusCategory.JSON_PROPERTY_NAME
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class StatusCategory extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_SELF = "self";
  private String self;

  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  public static final String JSON_PROPERTY_KEY = "key";
  private String key;

  public static final String JSON_PROPERTY_COLOR_NAME = "colorName";
  private String colorName;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;


   /**
   * The URL of the status category.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the status category.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSelf() {
    return self;
  }




   /**
   * The ID of the status category.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the status category.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getId() {
    return id;
  }




   /**
   * The key of the status category.
   * @return key
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The key of the status category.")
  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getKey() {
    return key;
  }




   /**
   * The name of the color used to represent the status category.
   * @return colorName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the color used to represent the status category.")
  @JsonProperty(JSON_PROPERTY_COLOR_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getColorName() {
    return colorName;
  }




   /**
   * The name of the status category.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the status category.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusCategory statusCategory = (StatusCategory) o;
    return Objects.equals(this.self, statusCategory.self) &&
        Objects.equals(this.id, statusCategory.id) &&
        Objects.equals(this.key, statusCategory.key) &&
        Objects.equals(this.colorName, statusCategory.colorName) &&
        Objects.equals(this.name, statusCategory.name) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, id, key, colorName, name, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusCategory {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    colorName: ").append(toIndentedString(colorName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

