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
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * IncludedFields
 */
@JsonPropertyOrder({
  IncludedFields.JSON_PROPERTY_INCLUDED,
  IncludedFields.JSON_PROPERTY_ACTUALLY_INCLUDED,
  IncludedFields.JSON_PROPERTY_EXCLUDED
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class IncludedFields {
  public static final String JSON_PROPERTY_INCLUDED = "included";
  private List<String> included = null;

  public static final String JSON_PROPERTY_ACTUALLY_INCLUDED = "actuallyIncluded";
  private List<String> actuallyIncluded = null;

  public static final String JSON_PROPERTY_EXCLUDED = "excluded";
  private List<String> excluded = null;


  public IncludedFields included(List<String> included) {
    
    this.included = included;
    return this;
  }

  public IncludedFields addIncludedItem(String includedItem) {
    if (this.included == null) {
      this.included = new ArrayList<>();
    }
    this.included.add(includedItem);
    return this;
  }

   /**
   * Get included
   * @return included
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getIncluded() {
    return included;
  }


  public void setIncluded(List<String> included) {
    this.included = included;
  }


  public IncludedFields actuallyIncluded(List<String> actuallyIncluded) {
    
    this.actuallyIncluded = actuallyIncluded;
    return this;
  }

  public IncludedFields addActuallyIncludedItem(String actuallyIncludedItem) {
    if (this.actuallyIncluded == null) {
      this.actuallyIncluded = new ArrayList<>();
    }
    this.actuallyIncluded.add(actuallyIncludedItem);
    return this;
  }

   /**
   * Get actuallyIncluded
   * @return actuallyIncluded
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ACTUALLY_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getActuallyIncluded() {
    return actuallyIncluded;
  }


  public void setActuallyIncluded(List<String> actuallyIncluded) {
    this.actuallyIncluded = actuallyIncluded;
  }


  public IncludedFields excluded(List<String> excluded) {
    
    this.excluded = excluded;
    return this;
  }

  public IncludedFields addExcludedItem(String excludedItem) {
    if (this.excluded == null) {
      this.excluded = new ArrayList<>();
    }
    this.excluded.add(excludedItem);
    return this;
  }

   /**
   * Get excluded
   * @return excluded
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EXCLUDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getExcluded() {
    return excluded;
  }


  public void setExcluded(List<String> excluded) {
    this.excluded = excluded;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IncludedFields includedFields = (IncludedFields) o;
    return Objects.equals(this.included, includedFields.included) &&
        Objects.equals(this.actuallyIncluded, includedFields.actuallyIncluded) &&
        Objects.equals(this.excluded, includedFields.excluded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(included, actuallyIncluded, excluded);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IncludedFields {\n");
    sb.append("    included: ").append(toIndentedString(included)).append("\n");
    sb.append("    actuallyIncluded: ").append(toIndentedString(actuallyIncluded)).append("\n");
    sb.append("    excluded: ").append(toIndentedString(excluded)).append("\n");
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

