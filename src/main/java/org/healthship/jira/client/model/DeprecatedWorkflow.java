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
 * Details about a workflow.
 */
@ApiModel(description = "Details about a workflow.")
@JsonPropertyOrder({
  DeprecatedWorkflow.JSON_PROPERTY_NAME,
  DeprecatedWorkflow.JSON_PROPERTY_DESCRIPTION,
  DeprecatedWorkflow.JSON_PROPERTY_LAST_MODIFIED_DATE,
  DeprecatedWorkflow.JSON_PROPERTY_LAST_MODIFIED_USER,
  DeprecatedWorkflow.JSON_PROPERTY_LAST_MODIFIED_USER_ACCOUNT_ID,
  DeprecatedWorkflow.JSON_PROPERTY_STEPS,
  DeprecatedWorkflow.JSON_PROPERTY_SCOPE,
  DeprecatedWorkflow.JSON_PROPERTY_DEFAULT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class DeprecatedWorkflow {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_LAST_MODIFIED_DATE = "lastModifiedDate";
  private String lastModifiedDate;

  public static final String JSON_PROPERTY_LAST_MODIFIED_USER = "lastModifiedUser";
  private String lastModifiedUser;

  public static final String JSON_PROPERTY_LAST_MODIFIED_USER_ACCOUNT_ID = "lastModifiedUserAccountId";
  private String lastModifiedUserAccountId;

  public static final String JSON_PROPERTY_STEPS = "steps";
  private Integer steps;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  private Scope scope = null;

  public static final String JSON_PROPERTY_DEFAULT = "default";
  private Boolean _default;


   /**
   * The name of the workflow.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the workflow.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }




   /**
   * The description of the workflow.
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description of the workflow.")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }




   /**
   * The datetime the workflow was last modified.
   * @return lastModifiedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The datetime the workflow was last modified.")
  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastModifiedDate() {
    return lastModifiedDate;
  }




   /**
   * This property is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
   * @return lastModifiedUser
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This property is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.")
  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_USER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastModifiedUser() {
    return lastModifiedUser;
  }




   /**
   * The account ID of the user that last modified the workflow.
   * @return lastModifiedUserAccountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The account ID of the user that last modified the workflow.")
  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_USER_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastModifiedUserAccountId() {
    return lastModifiedUserAccountId;
  }




   /**
   * The number of steps included in the workflow.
   * @return steps
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of steps included in the workflow.")
  @JsonProperty(JSON_PROPERTY_STEPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getSteps() {
    return steps;
  }




   /**
   * The scope where this workflow applies
   * @return scope
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The scope where this workflow applies")
  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Scope getScope() {
    return scope;
  }




  public DeprecatedWorkflow _default(Boolean _default) {
    
    this._default = _default;
    return this;
  }

   /**
   * Get _default
   * @return _default
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getDefault() {
    return _default;
  }


  public void setDefault(Boolean _default) {
    this._default = _default;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeprecatedWorkflow deprecatedWorkflow = (DeprecatedWorkflow) o;
    return Objects.equals(this.name, deprecatedWorkflow.name) &&
        Objects.equals(this.description, deprecatedWorkflow.description) &&
        Objects.equals(this.lastModifiedDate, deprecatedWorkflow.lastModifiedDate) &&
        Objects.equals(this.lastModifiedUser, deprecatedWorkflow.lastModifiedUser) &&
        Objects.equals(this.lastModifiedUserAccountId, deprecatedWorkflow.lastModifiedUserAccountId) &&
        Objects.equals(this.steps, deprecatedWorkflow.steps) &&
        Objects.equals(this.scope, deprecatedWorkflow.scope) &&
        Objects.equals(this._default, deprecatedWorkflow._default);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, lastModifiedDate, lastModifiedUser, lastModifiedUserAccountId, steps, scope, _default);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeprecatedWorkflow {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastModifiedDate: ").append(toIndentedString(lastModifiedDate)).append("\n");
    sb.append("    lastModifiedUser: ").append(toIndentedString(lastModifiedUser)).append("\n");
    sb.append("    lastModifiedUserAccountId: ").append(toIndentedString(lastModifiedUserAccountId)).append("\n");
    sb.append("    steps: ").append(toIndentedString(steps)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
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

