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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Status details for an issue type.
 */
@ApiModel(description = "Status details for an issue type.")
@JsonPropertyOrder({
  IssueTypeWithStatus.JSON_PROPERTY_SELF,
  IssueTypeWithStatus.JSON_PROPERTY_ID,
  IssueTypeWithStatus.JSON_PROPERTY_NAME,
  IssueTypeWithStatus.JSON_PROPERTY_SUBTASK,
  IssueTypeWithStatus.JSON_PROPERTY_STATUSES
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class IssueTypeWithStatus {
  public static final String JSON_PROPERTY_SELF = "self";
  private String self;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_SUBTASK = "subtask";
  private Boolean subtask;

  public static final String JSON_PROPERTY_STATUSES = "statuses";
  private List<StatusDetails> statuses = new ArrayList<>();


   /**
   * The URL of the issue type&#39;s status details.
   * @return self
  **/
  @ApiModelProperty(required = true, value = "The URL of the issue type's status details.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSelf() {
    return self;
  }




   /**
   * The ID of the issue type.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the issue type.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }




   /**
   * The name of the issue type.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the issue type.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }




   /**
   * Whether this issue type represents subtasks.
   * @return subtask
  **/
  @ApiModelProperty(required = true, value = "Whether this issue type represents subtasks.")
  @JsonProperty(JSON_PROPERTY_SUBTASK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getSubtask() {
    return subtask;
  }




   /**
   * List of status details for the issue type.
   * @return statuses
  **/
  @ApiModelProperty(required = true, value = "List of status details for the issue type.")
  @JsonProperty(JSON_PROPERTY_STATUSES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<StatusDetails> getStatuses() {
    return statuses;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueTypeWithStatus issueTypeWithStatus = (IssueTypeWithStatus) o;
    return Objects.equals(this.self, issueTypeWithStatus.self) &&
        Objects.equals(this.id, issueTypeWithStatus.id) &&
        Objects.equals(this.name, issueTypeWithStatus.name) &&
        Objects.equals(this.subtask, issueTypeWithStatus.subtask) &&
        Objects.equals(this.statuses, issueTypeWithStatus.statuses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, id, name, subtask, statuses);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueTypeWithStatus {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    subtask: ").append(toIndentedString(subtask)).append("\n");
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
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

