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

import java.util.List;
import java.util.Objects;

/**
 * The hierarchy of issue types within a project.
 */
@ApiModel(description = "The hierarchy of issue types within a project.")
@JsonPropertyOrder({
  ProjectIssueTypeHierarchy.JSON_PROPERTY_PROJECT_ID,
  ProjectIssueTypeHierarchy.JSON_PROPERTY_HIERARCHY
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class ProjectIssueTypeHierarchy {
  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";
  private Long projectId;

  public static final String JSON_PROPERTY_HIERARCHY = "hierarchy";
  private List<ProjectIssueTypesHierarchyLevel> hierarchy = null;


   /**
   * The ID of the project.
   * @return projectId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the project.")
  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getProjectId() {
    return projectId;
  }




   /**
   * Details of an issue type hierarchy level.
   * @return hierarchy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of an issue type hierarchy level.")
  @JsonProperty(JSON_PROPERTY_HIERARCHY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ProjectIssueTypesHierarchyLevel> getHierarchy() {
    return hierarchy;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectIssueTypeHierarchy projectIssueTypeHierarchy = (ProjectIssueTypeHierarchy) o;
    return Objects.equals(this.projectId, projectIssueTypeHierarchy.projectId) &&
        Objects.equals(this.hierarchy, projectIssueTypeHierarchy.hierarchy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, hierarchy);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectIssueTypeHierarchy {\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    hierarchy: ").append(toIndentedString(hierarchy)).append("\n");
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

