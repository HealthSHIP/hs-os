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
 * List of project permissions and the projects and issues those permissions grant access to.
 */
@ApiModel(description = "List of project permissions and the projects and issues those permissions grant access to.")
@JsonPropertyOrder({
  BulkProjectPermissionGrants.JSON_PROPERTY_PERMISSION,
  BulkProjectPermissionGrants.JSON_PROPERTY_ISSUES,
  BulkProjectPermissionGrants.JSON_PROPERTY_PROJECTS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class BulkProjectPermissionGrants {
  public static final String JSON_PROPERTY_PERMISSION = "permission";
  private String permission;

  public static final String JSON_PROPERTY_ISSUES = "issues";
  private List<Long> issues = new ArrayList<>();

  public static final String JSON_PROPERTY_PROJECTS = "projects";
  private List<Long> projects = new ArrayList<>();


  public BulkProjectPermissionGrants permission(String permission) {
    
    this.permission = permission;
    return this;
  }

   /**
   * A project permission,
   * @return permission
  **/
  @ApiModelProperty(required = true, value = "A project permission,")
  @JsonProperty(JSON_PROPERTY_PERMISSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPermission() {
    return permission;
  }


  public void setPermission(String permission) {
    this.permission = permission;
  }


  public BulkProjectPermissionGrants issues(List<Long> issues) {
    
    this.issues = issues;
    return this;
  }

  public BulkProjectPermissionGrants addIssuesItem(Long issuesItem) {
    this.issues.add(issuesItem);
    return this;
  }

   /**
   * IDs of the issues the user has the permission for.
   * @return issues
  **/
  @ApiModelProperty(required = true, value = "IDs of the issues the user has the permission for.")
  @JsonProperty(JSON_PROPERTY_ISSUES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Long> getIssues() {
    return issues;
  }


  public void setIssues(List<Long> issues) {
    this.issues = issues;
  }


  public BulkProjectPermissionGrants projects(List<Long> projects) {
    
    this.projects = projects;
    return this;
  }

  public BulkProjectPermissionGrants addProjectsItem(Long projectsItem) {
    this.projects.add(projectsItem);
    return this;
  }

   /**
   * IDs of the projects the user has the permission for.
   * @return projects
  **/
  @ApiModelProperty(required = true, value = "IDs of the projects the user has the permission for.")
  @JsonProperty(JSON_PROPERTY_PROJECTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Long> getProjects() {
    return projects;
  }


  public void setProjects(List<Long> projects) {
    this.projects = projects;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkProjectPermissionGrants bulkProjectPermissionGrants = (BulkProjectPermissionGrants) o;
    return Objects.equals(this.permission, bulkProjectPermissionGrants.permission) &&
        Objects.equals(this.issues, bulkProjectPermissionGrants.issues) &&
        Objects.equals(this.projects, bulkProjectPermissionGrants.projects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(permission, issues, projects);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkProjectPermissionGrants {\n");
    sb.append("    permission: ").append(toIndentedString(permission)).append("\n");
    sb.append("    issues: ").append(toIndentedString(issues)).append("\n");
    sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
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

