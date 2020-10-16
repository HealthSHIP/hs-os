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
 * The wrapper for the issue creation metadata for a list of projects.
 */
@ApiModel(description = "The wrapper for the issue creation metadata for a list of projects.")
@JsonPropertyOrder({
  IssueCreateMetadata.JSON_PROPERTY_EXPAND,
  IssueCreateMetadata.JSON_PROPERTY_PROJECTS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class IssueCreateMetadata {
  public static final String JSON_PROPERTY_EXPAND = "expand";
  private String expand;

  public static final String JSON_PROPERTY_PROJECTS = "projects";
  private List<ProjectIssueCreateMetadata> projects = null;


   /**
   * Expand options that include additional project details in the response.
   * @return expand
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Expand options that include additional project details in the response.")
  @JsonProperty(JSON_PROPERTY_EXPAND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExpand() {
    return expand;
  }




   /**
   * List of projects and their issue creation metadata.
   * @return projects
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of projects and their issue creation metadata.")
  @JsonProperty(JSON_PROPERTY_PROJECTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ProjectIssueCreateMetadata> getProjects() {
    return projects;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueCreateMetadata issueCreateMetadata = (IssueCreateMetadata) o;
    return Objects.equals(this.expand, issueCreateMetadata.expand) &&
        Objects.equals(this.projects, issueCreateMetadata.projects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expand, projects);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueCreateMetadata {\n");
    sb.append("    expand: ").append(toIndentedString(expand)).append("\n");
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

