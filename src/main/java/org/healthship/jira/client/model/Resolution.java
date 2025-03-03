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
import java.util.Objects;

/**
 * Details of an issue resolution.
 */
@ApiModel(description = "Details of an issue resolution.")
@JsonPropertyOrder({
  Resolution.JSON_PROPERTY_SELF,
  Resolution.JSON_PROPERTY_ID,
  Resolution.JSON_PROPERTY_DESCRIPTION,
  Resolution.JSON_PROPERTY_NAME
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class Resolution {
  public static final String JSON_PROPERTY_SELF = "self";
  private URI self;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;


  public Resolution self(URI self) {
    
    this.self = self;
    return this;
  }

   /**
   * The URL of the issue resolution.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the issue resolution.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public URI getSelf() {
    return self;
  }


  public void setSelf(URI self) {
    this.self = self;
  }


  public Resolution id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * The ID of the issue resolution.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the issue resolution.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public Resolution description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * The description of the issue resolution.
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description of the issue resolution.")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public Resolution name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the issue resolution.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the issue resolution.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Resolution resolution = (Resolution) o;
    return Objects.equals(this.self, resolution.self) &&
        Objects.equals(this.id, resolution.id) &&
        Objects.equals(this.description, resolution.description) &&
        Objects.equals(this.name, resolution.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, id, description, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resolution {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

