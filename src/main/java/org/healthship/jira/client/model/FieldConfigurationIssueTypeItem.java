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
 * The field configuration for an issue type.
 */
@ApiModel(description = "The field configuration for an issue type.")
@JsonPropertyOrder({
  FieldConfigurationIssueTypeItem.JSON_PROPERTY_FIELD_CONFIGURATION_SCHEME_ID,
  FieldConfigurationIssueTypeItem.JSON_PROPERTY_ISSUE_TYPE_ID,
  FieldConfigurationIssueTypeItem.JSON_PROPERTY_FIELD_CONFIGURATION_ID
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class FieldConfigurationIssueTypeItem {
  public static final String JSON_PROPERTY_FIELD_CONFIGURATION_SCHEME_ID = "fieldConfigurationSchemeId";
  private String fieldConfigurationSchemeId;

  public static final String JSON_PROPERTY_ISSUE_TYPE_ID = "issueTypeId";
  private String issueTypeId;

  public static final String JSON_PROPERTY_FIELD_CONFIGURATION_ID = "fieldConfigurationId";
  private String fieldConfigurationId;


  public FieldConfigurationIssueTypeItem fieldConfigurationSchemeId(String fieldConfigurationSchemeId) {
    
    this.fieldConfigurationSchemeId = fieldConfigurationSchemeId;
    return this;
  }

   /**
   * The ID of the field configuration scheme.
   * @return fieldConfigurationSchemeId
  **/
  @ApiModelProperty(required = true, value = "The ID of the field configuration scheme.")
  @JsonProperty(JSON_PROPERTY_FIELD_CONFIGURATION_SCHEME_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getFieldConfigurationSchemeId() {
    return fieldConfigurationSchemeId;
  }


  public void setFieldConfigurationSchemeId(String fieldConfigurationSchemeId) {
    this.fieldConfigurationSchemeId = fieldConfigurationSchemeId;
  }


  public FieldConfigurationIssueTypeItem issueTypeId(String issueTypeId) {
    
    this.issueTypeId = issueTypeId;
    return this;
  }

   /**
   * The ID of the issue type or *default*. When set to *default* this field configuration issue type item applies to all issue types without a field configuration.
   * @return issueTypeId
  **/
  @ApiModelProperty(required = true, value = "The ID of the issue type or *default*. When set to *default* this field configuration issue type item applies to all issue types without a field configuration.")
  @JsonProperty(JSON_PROPERTY_ISSUE_TYPE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getIssueTypeId() {
    return issueTypeId;
  }


  public void setIssueTypeId(String issueTypeId) {
    this.issueTypeId = issueTypeId;
  }


  public FieldConfigurationIssueTypeItem fieldConfigurationId(String fieldConfigurationId) {
    
    this.fieldConfigurationId = fieldConfigurationId;
    return this;
  }

   /**
   * The ID of the field configuration.
   * @return fieldConfigurationId
  **/
  @ApiModelProperty(required = true, value = "The ID of the field configuration.")
  @JsonProperty(JSON_PROPERTY_FIELD_CONFIGURATION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getFieldConfigurationId() {
    return fieldConfigurationId;
  }


  public void setFieldConfigurationId(String fieldConfigurationId) {
    this.fieldConfigurationId = fieldConfigurationId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldConfigurationIssueTypeItem fieldConfigurationIssueTypeItem = (FieldConfigurationIssueTypeItem) o;
    return Objects.equals(this.fieldConfigurationSchemeId, fieldConfigurationIssueTypeItem.fieldConfigurationSchemeId) &&
        Objects.equals(this.issueTypeId, fieldConfigurationIssueTypeItem.issueTypeId) &&
        Objects.equals(this.fieldConfigurationId, fieldConfigurationIssueTypeItem.fieldConfigurationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldConfigurationSchemeId, issueTypeId, fieldConfigurationId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldConfigurationIssueTypeItem {\n");
    sb.append("    fieldConfigurationSchemeId: ").append(toIndentedString(fieldConfigurationSchemeId)).append("\n");
    sb.append("    issueTypeId: ").append(toIndentedString(issueTypeId)).append("\n");
    sb.append("    fieldConfigurationId: ").append(toIndentedString(fieldConfigurationId)).append("\n");
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

