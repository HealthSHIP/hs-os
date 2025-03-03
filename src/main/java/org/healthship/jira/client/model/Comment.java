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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * A comment.
 */
@ApiModel(description = "A comment.")
@JsonPropertyOrder({
  Comment.JSON_PROPERTY_SELF,
  Comment.JSON_PROPERTY_ID,
  Comment.JSON_PROPERTY_AUTHOR,
  Comment.JSON_PROPERTY_BODY,
  Comment.JSON_PROPERTY_RENDERED_BODY,
  Comment.JSON_PROPERTY_UPDATE_AUTHOR,
  Comment.JSON_PROPERTY_CREATED,
  Comment.JSON_PROPERTY_UPDATED,
  Comment.JSON_PROPERTY_VISIBILITY,
  Comment.JSON_PROPERTY_JSD_PUBLIC,
  Comment.JSON_PROPERTY_PROPERTIES
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class Comment extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_SELF = "self";
  private String self;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_AUTHOR = "author";
  private UserDetails author = null;

  public static final String JSON_PROPERTY_BODY = "body";
  private Object body = null;

  public static final String JSON_PROPERTY_RENDERED_BODY = "renderedBody";
  private String renderedBody;

  public static final String JSON_PROPERTY_UPDATE_AUTHOR = "updateAuthor";
  private UserDetails updateAuthor = null;

  public static final String JSON_PROPERTY_CREATED = "created";
  private OffsetDateTime created;

  public static final String JSON_PROPERTY_UPDATED = "updated";
  private OffsetDateTime updated;

  public static final String JSON_PROPERTY_VISIBILITY = "visibility";
  private Visibility visibility = null;

  public static final String JSON_PROPERTY_JSD_PUBLIC = "jsdPublic";
  private Boolean jsdPublic;

  public static final String JSON_PROPERTY_PROPERTIES = "properties";
  private List<EntityProperty> properties = null;


   /**
   * The URL of the comment.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the comment.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSelf() {
    return self;
  }




   /**
   * The ID of the comment.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the comment.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }




   /**
   * The ID of the user who created the comment.
   * @return author
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the user who created the comment.")
  @JsonProperty(JSON_PROPERTY_AUTHOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UserDetails getAuthor() {
    return author;
  }




  public Comment body(Object body) {
    
    this.body = body;
    return this;
  }

   /**
   * The comment text in [Atlassian Document Format](https://developer.atlassian.com/cloud/jira/platform/apis/document/structure/).
   * @return body
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The comment text in [Atlassian Document Format](https://developer.atlassian.com/cloud/jira/platform/apis/document/structure/).")
  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getBody() {
    return body;
  }


  public void setBody(Object body) {
    this.body = body;
  }


   /**
   * The rendered version of the comment.
   * @return renderedBody
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The rendered version of the comment.")
  @JsonProperty(JSON_PROPERTY_RENDERED_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRenderedBody() {
    return renderedBody;
  }




   /**
   * The ID of the user who updated the comment last.
   * @return updateAuthor
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the user who updated the comment last.")
  @JsonProperty(JSON_PROPERTY_UPDATE_AUTHOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UserDetails getUpdateAuthor() {
    return updateAuthor;
  }




   /**
   * The date and time at which the comment was created.
   * @return created
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time at which the comment was created.")
  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreated() {
    return created;
  }




   /**
   * The date and time at which the comment was updated last.
   * @return updated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time at which the comment was updated last.")
  @JsonProperty(JSON_PROPERTY_UPDATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getUpdated() {
    return updated;
  }




  public Comment visibility(Visibility visibility) {
    
    this.visibility = visibility;
    return this;
  }

   /**
   * The group or role to which this comment is visible. Optional on create and update.
   * @return visibility
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The group or role to which this comment is visible. Optional on create and update.")
  @JsonProperty(JSON_PROPERTY_VISIBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Visibility getVisibility() {
    return visibility;
  }


  public void setVisibility(Visibility visibility) {
    this.visibility = visibility;
  }


   /**
   * Whether the comment is visible in Jira Service Desk. Defaults to true when comments are created in the Jira Cloud Platform. This includes when the site doesn&#39;t use Jira Service Desk or the project isn&#39;t a Jira Service Desk project and, therefore, there is no Jira Service Desk for the issue to be visible on. To create a comment with its visibility in Jira Service Desk set to false, use the Jira Service Desk REST API [Create request comment](https://developer.atlassian.com/cloud/jira/service-desk/rest/#api-rest-servicedeskapi-request-issueIdOrKey-comment-post) operation.
   * @return jsdPublic
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the comment is visible in Jira Service Desk. Defaults to true when comments are created in the Jira Cloud Platform. This includes when the site doesn't use Jira Service Desk or the project isn't a Jira Service Desk project and, therefore, there is no Jira Service Desk for the issue to be visible on. To create a comment with its visibility in Jira Service Desk set to false, use the Jira Service Desk REST API [Create request comment](https://developer.atlassian.com/cloud/jira/service-desk/rest/#api-rest-servicedeskapi-request-issueIdOrKey-comment-post) operation.")
  @JsonProperty(JSON_PROPERTY_JSD_PUBLIC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getJsdPublic() {
    return jsdPublic;
  }




  public Comment properties(List<EntityProperty> properties) {
    
    this.properties = properties;
    return this;
  }

  public Comment addPropertiesItem(EntityProperty propertiesItem) {
    if (this.properties == null) {
      this.properties = new ArrayList<>();
    }
    this.properties.add(propertiesItem);
    return this;
  }

   /**
   * A list of comment properties. Optional on create and update.
   * @return properties
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list of comment properties. Optional on create and update.")
  @JsonProperty(JSON_PROPERTY_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<EntityProperty> getProperties() {
    return properties;
  }


  public void setProperties(List<EntityProperty> properties) {
    this.properties = properties;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Comment comment = (Comment) o;
    return Objects.equals(this.self, comment.self) &&
        Objects.equals(this.id, comment.id) &&
        Objects.equals(this.author, comment.author) &&
        Objects.equals(this.body, comment.body) &&
        Objects.equals(this.renderedBody, comment.renderedBody) &&
        Objects.equals(this.updateAuthor, comment.updateAuthor) &&
        Objects.equals(this.created, comment.created) &&
        Objects.equals(this.updated, comment.updated) &&
        Objects.equals(this.visibility, comment.visibility) &&
        Objects.equals(this.jsdPublic, comment.jsdPublic) &&
        Objects.equals(this.properties, comment.properties) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, id, author, body, renderedBody, updateAuthor, created, updated, visibility, jsdPublic, properties, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Comment {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    renderedBody: ").append(toIndentedString(renderedBody)).append("\n");
    sb.append("    updateAuthor: ").append(toIndentedString(updateAuthor)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    visibility: ").append(toIndentedString(visibility)).append("\n");
    sb.append("    jsdPublic: ").append(toIndentedString(jsdPublic)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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

