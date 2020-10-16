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

import java.util.Objects;

/**
 * Details of a share permission for the filter.
 */
@ApiModel(description = "Details of a share permission for the filter.")
@JsonPropertyOrder({
  SharePermission.JSON_PROPERTY_ID,
  SharePermission.JSON_PROPERTY_TYPE,
  SharePermission.JSON_PROPERTY_PROJECT,
  SharePermission.JSON_PROPERTY_ROLE,
  SharePermission.JSON_PROPERTY_GROUP
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class SharePermission {
  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  /**
   * The type of share permission:   *  &#x60;group&#x60; Shared with a group. If set in a request, then specify &#x60;sharePermission.group&#x60; as well.  *  &#x60;project&#x60; Shared with a project. If set in a request, then specify &#x60;sharePermission.project&#x60; as well.  *  &#x60;projectRole&#x60; Share with a project role in a project. This value is not returned in responses. It is used in requests, where it needs to be specify with &#x60;projectId&#x60; and &#x60;projectRoleId&#x60;.  *  &#x60;global&#x60; Shared globally. If set in a request, no other &#x60;sharePermission&#x60; properties need to be specified.  *  &#x60;loggedin&#x60; Shared with all logged-in users. Note: This value is set in a request by specifying &#x60;authenticated&#x60; as the &#x60;type&#x60;.  *  &#x60;project-unknown&#x60; Shared with a project that the user does not have access to. Cannot be set in a request.
   */
  public enum TypeEnum {
    GROUP("group"),
    
    PROJECT("project"),
    
    PROJECTROLE("projectRole"),
    
    GLOBAL("global"),
    
    LOGGEDIN("loggedin"),
    
    AUTHENTICATED("authenticated"),
    
    PROJECT_UNKNOWN("project-unknown");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  public static final String JSON_PROPERTY_PROJECT = "project";
  private Project project = null;

  public static final String JSON_PROPERTY_ROLE = "role";
  private ProjectRole role = null;

  public static final String JSON_PROPERTY_GROUP = "group";
  private GroupName group = null;


   /**
   * The unique identifier of the share permission.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identifier of the share permission.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getId() {
    return id;
  }




  public SharePermission type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * The type of share permission:   *  &#x60;group&#x60; Shared with a group. If set in a request, then specify &#x60;sharePermission.group&#x60; as well.  *  &#x60;project&#x60; Shared with a project. If set in a request, then specify &#x60;sharePermission.project&#x60; as well.  *  &#x60;projectRole&#x60; Share with a project role in a project. This value is not returned in responses. It is used in requests, where it needs to be specify with &#x60;projectId&#x60; and &#x60;projectRoleId&#x60;.  *  &#x60;global&#x60; Shared globally. If set in a request, no other &#x60;sharePermission&#x60; properties need to be specified.  *  &#x60;loggedin&#x60; Shared with all logged-in users. Note: This value is set in a request by specifying &#x60;authenticated&#x60; as the &#x60;type&#x60;.  *  &#x60;project-unknown&#x60; Shared with a project that the user does not have access to. Cannot be set in a request.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The type of share permission:   *  `group` Shared with a group. If set in a request, then specify `sharePermission.group` as well.  *  `project` Shared with a project. If set in a request, then specify `sharePermission.project` as well.  *  `projectRole` Share with a project role in a project. This value is not returned in responses. It is used in requests, where it needs to be specify with `projectId` and `projectRoleId`.  *  `global` Shared globally. If set in a request, no other `sharePermission` properties need to be specified.  *  `loggedin` Shared with all logged-in users. Note: This value is set in a request by specifying `authenticated` as the `type`.  *  `project-unknown` Shared with a project that the user does not have access to. Cannot be set in a request.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    this.type = type;
  }


  public SharePermission project(Project project) {
    
    this.project = project;
    return this;
  }

   /**
   * The project that the filter is shared with. This is similar to the project object returned by [Get project](#api-rest-api-3-project-projectIdOrKey-get) but it contains a subset of the properties, which are: &#x60;self&#x60;, &#x60;id&#x60;, &#x60;key&#x60;, &#x60;assigneeType&#x60;, &#x60;name&#x60;, &#x60;roles&#x60;, &#x60;avatarUrls&#x60;, &#x60;projectType&#x60;, &#x60;simplified&#x60;.   For a request, specify the &#x60;id&#x60; for the project.
   * @return project
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The project that the filter is shared with. This is similar to the project object returned by [Get project](#api-rest-api-3-project-projectIdOrKey-get) but it contains a subset of the properties, which are: `self`, `id`, `key`, `assigneeType`, `name`, `roles`, `avatarUrls`, `projectType`, `simplified`.   For a request, specify the `id` for the project.")
  @JsonProperty(JSON_PROPERTY_PROJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Project getProject() {
    return project;
  }


  public void setProject(Project project) {
    this.project = project;
  }


  public SharePermission role(ProjectRole role) {
    
    this.role = role;
    return this;
  }

   /**
   * The project role that the filter is shared with.   For a request, specify the &#x60;id&#x60; for the role. You must also specify the &#x60;project&#x60; object and &#x60;id&#x60; for the project that the role is in.
   * @return role
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The project role that the filter is shared with.   For a request, specify the `id` for the role. You must also specify the `project` object and `id` for the project that the role is in.")
  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ProjectRole getRole() {
    return role;
  }


  public void setRole(ProjectRole role) {
    this.role = role;
  }


  public SharePermission group(GroupName group) {
    
    this.group = group;
    return this;
  }

   /**
   * The group that the filter is shared with. For a request, specify the &#x60;name&#x60; property for the group.
   * @return group
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The group that the filter is shared with. For a request, specify the `name` property for the group.")
  @JsonProperty(JSON_PROPERTY_GROUP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public GroupName getGroup() {
    return group;
  }


  public void setGroup(GroupName group) {
    this.group = group;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SharePermission sharePermission = (SharePermission) o;
    return Objects.equals(this.id, sharePermission.id) &&
        Objects.equals(this.type, sharePermission.type) &&
        Objects.equals(this.project, sharePermission.project) &&
        Objects.equals(this.role, sharePermission.role) &&
        Objects.equals(this.group, sharePermission.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, project, role, group);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SharePermission {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
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

