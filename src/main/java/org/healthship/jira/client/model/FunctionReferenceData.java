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

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Details of functions that can be used in advanced searches.
 */
@ApiModel(description = "Details of functions that can be used in advanced searches.")
@JsonPropertyOrder({
  FunctionReferenceData.JSON_PROPERTY_VALUE,
  FunctionReferenceData.JSON_PROPERTY_DISPLAY_NAME,
  FunctionReferenceData.JSON_PROPERTY_IS_LIST,
  FunctionReferenceData.JSON_PROPERTY_TYPES
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class FunctionReferenceData {
  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;

  /**
   * Whether the function can take a list of arguments.
   */
  public enum IsListEnum {
    TRUE("true"),
    
    FALSE("false");

    private String value;

    IsListEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IsListEnum fromValue(String value) {
      for (IsListEnum b : IsListEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_IS_LIST = "isList";
  private IsListEnum isList;

  public static final String JSON_PROPERTY_TYPES = "types";
  private List<String> types = null;


  public FunctionReferenceData value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * The function identifier.
   * @return value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The function identifier.")
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getValue() {
    return value;
  }


  public void setValue(String value) {
    this.value = value;
  }


  public FunctionReferenceData displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * The display name of the function.
   * @return displayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The display name of the function.")
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public FunctionReferenceData isList(IsListEnum isList) {
    
    this.isList = isList;
    return this;
  }

   /**
   * Whether the function can take a list of arguments.
   * @return isList
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the function can take a list of arguments.")
  @JsonProperty(JSON_PROPERTY_IS_LIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IsListEnum getIsList() {
    return isList;
  }


  public void setIsList(IsListEnum isList) {
    this.isList = isList;
  }


  public FunctionReferenceData types(List<String> types) {
    
    this.types = types;
    return this;
  }

  public FunctionReferenceData addTypesItem(String typesItem) {
    if (this.types == null) {
      this.types = new ArrayList<>();
    }
    this.types.add(typesItem);
    return this;
  }

   /**
   * The data types returned by the function.
   * @return types
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The data types returned by the function.")
  @JsonProperty(JSON_PROPERTY_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getTypes() {
    return types;
  }


  public void setTypes(List<String> types) {
    this.types = types;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FunctionReferenceData functionReferenceData = (FunctionReferenceData) o;
    return Objects.equals(this.value, functionReferenceData.value) &&
        Objects.equals(this.displayName, functionReferenceData.displayName) &&
        Objects.equals(this.isList, functionReferenceData.isList) &&
        Objects.equals(this.types, functionReferenceData.types);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, displayName, isList, types);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FunctionReferenceData {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    isList: ").append(toIndentedString(isList)).append("\n");
    sb.append("    types: ").append(toIndentedString(types)).append("\n");
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

