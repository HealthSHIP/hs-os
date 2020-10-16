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
import java.util.List;
import java.util.Objects;

/**
 * Details about the roles in a project.
 */
@ApiModel(description = "Details about the roles in a project.")
@JsonPropertyOrder({
  ProjectRole.JSON_PROPERTY_SELF,
  ProjectRole.JSON_PROPERTY_NAME,
  ProjectRole.JSON_PROPERTY_ID,
  ProjectRole.JSON_PROPERTY_DESCRIPTION,
  ProjectRole.JSON_PROPERTY_ACTORS,
  ProjectRole.JSON_PROPERTY_SCOPE,
  ProjectRole.JSON_PROPERTY_TRANSLATED_NAME,
  ProjectRole.JSON_PROPERTY_ADMIN,
  ProjectRole.JSON_PROPERTY_ROLE_CONFIGURABLE,
  ProjectRole.JSON_PROPERTY_DEFAULT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class ProjectRole {
  public static final String JSON_PROPERTY_SELF = "self";
  private URI self;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_ACTORS = "actors";
  private List<RoleActor> actors = null;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  private Scope scope = null;

  public static final String JSON_PROPERTY_TRANSLATED_NAME = "translatedName";
  private String translatedName;

  public static final String JSON_PROPERTY_ADMIN = "admin";
  private Boolean admin;

  public static final String JSON_PROPERTY_ROLE_CONFIGURABLE = "roleConfigurable";
  private Boolean roleConfigurable;

  public static final String JSON_PROPERTY_DEFAULT = "default";
  private Boolean _default;


   /**
   * The URL the project role details.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL the project role details.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public URI getSelf() {
    return self;
  }




  public ProjectRole name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the project role.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the project role.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


   /**
   * The ID of the project role.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the project role.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getId() {
    return id;
  }




   /**
   * The description of the project role.
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description of the project role.")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }




   /**
   * The list of users who act in this role.
   * @return actors
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list of users who act in this role.")
  @JsonProperty(JSON_PROPERTY_ACTORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<RoleActor> getActors() {
    return actors;
  }




   /**
   * The scope of the role. Indicated for roles associated with [next-gen projects](https://confluence.atlassian.com/x/loMyO).
   * @return scope
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The scope of the role. Indicated for roles associated with [next-gen projects](https://confluence.atlassian.com/x/loMyO).")
  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Scope getScope() {
    return scope;
  }




  public ProjectRole translatedName(String translatedName) {
    
    this.translatedName = translatedName;
    return this;
  }

   /**
   * The translated name of the project role.
   * @return translatedName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The translated name of the project role.")
  @JsonProperty(JSON_PROPERTY_TRANSLATED_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTranslatedName() {
    return translatedName;
  }


  public void setTranslatedName(String translatedName) {
    this.translatedName = translatedName;
  }


   /**
   * Whether this role is the admin role for the project.
   * @return admin
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether this role is the admin role for the project.")
  @JsonProperty(JSON_PROPERTY_ADMIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAdmin() {
    return admin;
  }




  public ProjectRole roleConfigurable(Boolean roleConfigurable) {
    
    this.roleConfigurable = roleConfigurable;
    return this;
  }

   /**
   * Get roleConfigurable
   * @return roleConfigurable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ROLE_CONFIGURABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getRoleConfigurable() {
    return roleConfigurable;
  }


  public void setRoleConfigurable(Boolean roleConfigurable) {
    this.roleConfigurable = roleConfigurable;
  }


   /**
   * Whether this role is the default role for the project
   * @return _default
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether this role is the default role for the project")
  @JsonProperty(JSON_PROPERTY_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getDefault() {
    return _default;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectRole projectRole = (ProjectRole) o;
    return Objects.equals(this.self, projectRole.self) &&
        Objects.equals(this.name, projectRole.name) &&
        Objects.equals(this.id, projectRole.id) &&
        Objects.equals(this.description, projectRole.description) &&
        Objects.equals(this.actors, projectRole.actors) &&
        Objects.equals(this.scope, projectRole.scope) &&
        Objects.equals(this.translatedName, projectRole.translatedName) &&
        Objects.equals(this.admin, projectRole.admin) &&
        Objects.equals(this.roleConfigurable, projectRole.roleConfigurable) &&
        Objects.equals(this._default, projectRole._default);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, name, id, description, actors, scope, translatedName, admin, roleConfigurable, _default);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectRole {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    actors: ").append(toIndentedString(actors)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    translatedName: ").append(toIndentedString(translatedName)).append("\n");
    sb.append("    admin: ").append(toIndentedString(admin)).append("\n");
    sb.append("    roleConfigurable: ").append(toIndentedString(roleConfigurable)).append("\n");
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

