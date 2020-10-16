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
 * Details of the issue creation metadata for a project.
 */
@ApiModel(description = "Details of the issue creation metadata for a project.")
@JsonPropertyOrder({
  ProjectIssueCreateMetadata.JSON_PROPERTY_EXPAND,
  ProjectIssueCreateMetadata.JSON_PROPERTY_SELF,
  ProjectIssueCreateMetadata.JSON_PROPERTY_ID,
  ProjectIssueCreateMetadata.JSON_PROPERTY_KEY,
  ProjectIssueCreateMetadata.JSON_PROPERTY_NAME,
  ProjectIssueCreateMetadata.JSON_PROPERTY_AVATAR_URLS,
  ProjectIssueCreateMetadata.JSON_PROPERTY_ISSUETYPES
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class ProjectIssueCreateMetadata {
  public static final String JSON_PROPERTY_EXPAND = "expand";
  private String expand;

  public static final String JSON_PROPERTY_SELF = "self";
  private String self;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_KEY = "key";
  private String key;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_AVATAR_URLS = "avatarUrls";
  private AvatarUrlsBean avatarUrls = null;

  public static final String JSON_PROPERTY_ISSUETYPES = "issuetypes";
  private List<IssueTypeIssueCreateMetadata> issuetypes = null;


   /**
   * Expand options that include additional project issue create metadata details in the response.
   * @return expand
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Expand options that include additional project issue create metadata details in the response.")
  @JsonProperty(JSON_PROPERTY_EXPAND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExpand() {
    return expand;
  }




   /**
   * The URL of the project.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the project.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSelf() {
    return self;
  }




   /**
   * The ID of the project.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the project.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }




   /**
   * The key of the project.
   * @return key
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The key of the project.")
  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getKey() {
    return key;
  }




   /**
   * The name of the project.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the project.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }




   /**
   * List of the project&#39;s avatars, returning the avatar size and associated URL.
   * @return avatarUrls
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of the project's avatars, returning the avatar size and associated URL.")
  @JsonProperty(JSON_PROPERTY_AVATAR_URLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AvatarUrlsBean getAvatarUrls() {
    return avatarUrls;
  }




   /**
   * List of the issue types supported by the project.
   * @return issuetypes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of the issue types supported by the project.")
  @JsonProperty(JSON_PROPERTY_ISSUETYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<IssueTypeIssueCreateMetadata> getIssuetypes() {
    return issuetypes;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectIssueCreateMetadata projectIssueCreateMetadata = (ProjectIssueCreateMetadata) o;
    return Objects.equals(this.expand, projectIssueCreateMetadata.expand) &&
        Objects.equals(this.self, projectIssueCreateMetadata.self) &&
        Objects.equals(this.id, projectIssueCreateMetadata.id) &&
        Objects.equals(this.key, projectIssueCreateMetadata.key) &&
        Objects.equals(this.name, projectIssueCreateMetadata.name) &&
        Objects.equals(this.avatarUrls, projectIssueCreateMetadata.avatarUrls) &&
        Objects.equals(this.issuetypes, projectIssueCreateMetadata.issuetypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expand, self, id, key, name, avatarUrls, issuetypes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectIssueCreateMetadata {\n");
    sb.append("    expand: ").append(toIndentedString(expand)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    avatarUrls: ").append(toIndentedString(avatarUrls)).append("\n");
    sb.append("    issuetypes: ").append(toIndentedString(issuetypes)).append("\n");
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

