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
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Details of a worklog.
 */
@ApiModel(description = "Details of a worklog.")
@JsonPropertyOrder({
  Worklog.JSON_PROPERTY_SELF,
  Worklog.JSON_PROPERTY_AUTHOR,
  Worklog.JSON_PROPERTY_UPDATE_AUTHOR,
  Worklog.JSON_PROPERTY_COMMENT,
  Worklog.JSON_PROPERTY_CREATED,
  Worklog.JSON_PROPERTY_UPDATED,
  Worklog.JSON_PROPERTY_VISIBILITY,
  Worklog.JSON_PROPERTY_STARTED,
  Worklog.JSON_PROPERTY_TIME_SPENT,
  Worklog.JSON_PROPERTY_TIME_SPENT_SECONDS,
  Worklog.JSON_PROPERTY_ID,
  Worklog.JSON_PROPERTY_ISSUE_ID,
  Worklog.JSON_PROPERTY_PROPERTIES
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class Worklog extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_SELF = "self";
  private URI self;

  public static final String JSON_PROPERTY_AUTHOR = "author";
  private UserDetails author = null;

  public static final String JSON_PROPERTY_UPDATE_AUTHOR = "updateAuthor";
  private UserDetails updateAuthor = null;

  public static final String JSON_PROPERTY_COMMENT = "comment";
  private Object comment = null;

  public static final String JSON_PROPERTY_CREATED = "created";
  private OffsetDateTime created;

  public static final String JSON_PROPERTY_UPDATED = "updated";
  private OffsetDateTime updated;

  public static final String JSON_PROPERTY_VISIBILITY = "visibility";
  private Visibility visibility = null;

  public static final String JSON_PROPERTY_STARTED = "started";
  private OffsetDateTime started;

  public static final String JSON_PROPERTY_TIME_SPENT = "timeSpent";
  private String timeSpent;

  public static final String JSON_PROPERTY_TIME_SPENT_SECONDS = "timeSpentSeconds";
  private Long timeSpentSeconds;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_ISSUE_ID = "issueId";
  private String issueId;

  public static final String JSON_PROPERTY_PROPERTIES = "properties";
  private List<EntityProperty> properties = null;


   /**
   * The URL of the worklog item.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the worklog item.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public URI getSelf() {
    return self;
  }




   /**
   * Details of the user who created the worklog.
   * @return author
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of the user who created the worklog.")
  @JsonProperty(JSON_PROPERTY_AUTHOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UserDetails getAuthor() {
    return author;
  }




   /**
   * Details of the user who last updated the worklog.
   * @return updateAuthor
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of the user who last updated the worklog.")
  @JsonProperty(JSON_PROPERTY_UPDATE_AUTHOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UserDetails getUpdateAuthor() {
    return updateAuthor;
  }




  public Worklog comment(Object comment) {
    
    this.comment = comment;
    return this;
  }

   /**
   * A comment about the worklog in [Atlassian Document Format](https://developer.atlassian.com/cloud/jira/platform/apis/document/structure/). Optional when creating or updating a worklog.
   * @return comment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A comment about the worklog in [Atlassian Document Format](https://developer.atlassian.com/cloud/jira/platform/apis/document/structure/). Optional when creating or updating a worklog.")
  @JsonProperty(JSON_PROPERTY_COMMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getComment() {
    return comment;
  }


  public void setComment(Object comment) {
    this.comment = comment;
  }


   /**
   * The datetime on which the worklog was created.
   * @return created
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The datetime on which the worklog was created.")
  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreated() {
    return created;
  }




   /**
   * The datetime on which the worklog was last updated.
   * @return updated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The datetime on which the worklog was last updated.")
  @JsonProperty(JSON_PROPERTY_UPDATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getUpdated() {
    return updated;
  }




  public Worklog visibility(Visibility visibility) {
    
    this.visibility = visibility;
    return this;
  }

   /**
   * Details about any restrictions in the visibility of the worklog. Optional when creating or updating a worklog.
   * @return visibility
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details about any restrictions in the visibility of the worklog. Optional when creating or updating a worklog.")
  @JsonProperty(JSON_PROPERTY_VISIBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Visibility getVisibility() {
    return visibility;
  }


  public void setVisibility(Visibility visibility) {
    this.visibility = visibility;
  }


  public Worklog started(OffsetDateTime started) {
    
    this.started = started;
    return this;
  }

   /**
   * The datetime on which the worklog effort was started. Required when creating a worklog. Optional when updating a worklog.
   * @return started
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The datetime on which the worklog effort was started. Required when creating a worklog. Optional when updating a worklog.")
  @JsonProperty(JSON_PROPERTY_STARTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getStarted() {
    return started;
  }


  public void setStarted(OffsetDateTime started) {
    this.started = started;
  }


  public Worklog timeSpent(String timeSpent) {
    
    this.timeSpent = timeSpent;
    return this;
  }

   /**
   * The time spent working on the issue as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). Required when creating a worklog if &#x60;timeSpentSeconds&#x60; isn&#39;t provided. Optional when updating a worklog. Cannot be provided if &#x60;timeSpentSecond&#x60; is provided.
   * @return timeSpent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The time spent working on the issue as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). Required when creating a worklog if `timeSpentSeconds` isn't provided. Optional when updating a worklog. Cannot be provided if `timeSpentSecond` is provided.")
  @JsonProperty(JSON_PROPERTY_TIME_SPENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTimeSpent() {
    return timeSpent;
  }


  public void setTimeSpent(String timeSpent) {
    this.timeSpent = timeSpent;
  }


  public Worklog timeSpentSeconds(Long timeSpentSeconds) {
    
    this.timeSpentSeconds = timeSpentSeconds;
    return this;
  }

   /**
   * The time in seconds spent working on the issue. Required when creating a worklog if &#x60;timeSpent&#x60; isn&#39;t provided. Optional when updating a worklog. Cannot be provided if &#x60;timeSpent&#x60; is provided.
   * @return timeSpentSeconds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The time in seconds spent working on the issue. Required when creating a worklog if `timeSpent` isn't provided. Optional when updating a worklog. Cannot be provided if `timeSpent` is provided.")
  @JsonProperty(JSON_PROPERTY_TIME_SPENT_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTimeSpentSeconds() {
    return timeSpentSeconds;
  }


  public void setTimeSpentSeconds(Long timeSpentSeconds) {
    this.timeSpentSeconds = timeSpentSeconds;
  }


   /**
   * The ID of the worklog record.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the worklog record.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }




   /**
   * The ID of the issue this worklog is for.
   * @return issueId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the issue this worklog is for.")
  @JsonProperty(JSON_PROPERTY_ISSUE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getIssueId() {
    return issueId;
  }




  public Worklog properties(List<EntityProperty> properties) {
    
    this.properties = properties;
    return this;
  }

  public Worklog addPropertiesItem(EntityProperty propertiesItem) {
    if (this.properties == null) {
      this.properties = new ArrayList<>();
    }
    this.properties.add(propertiesItem);
    return this;
  }

   /**
   * Details of properties for the worklog. Optional when creating or updating a worklog.
   * @return properties
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of properties for the worklog. Optional when creating or updating a worklog.")
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
    Worklog worklog = (Worklog) o;
    return Objects.equals(this.self, worklog.self) &&
        Objects.equals(this.author, worklog.author) &&
        Objects.equals(this.updateAuthor, worklog.updateAuthor) &&
        Objects.equals(this.comment, worklog.comment) &&
        Objects.equals(this.created, worklog.created) &&
        Objects.equals(this.updated, worklog.updated) &&
        Objects.equals(this.visibility, worklog.visibility) &&
        Objects.equals(this.started, worklog.started) &&
        Objects.equals(this.timeSpent, worklog.timeSpent) &&
        Objects.equals(this.timeSpentSeconds, worklog.timeSpentSeconds) &&
        Objects.equals(this.id, worklog.id) &&
        Objects.equals(this.issueId, worklog.issueId) &&
        Objects.equals(this.properties, worklog.properties) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, author, updateAuthor, comment, created, updated, visibility, started, timeSpent, timeSpentSeconds, id, issueId, properties, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Worklog {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    updateAuthor: ").append(toIndentedString(updateAuthor)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    visibility: ").append(toIndentedString(visibility)).append("\n");
    sb.append("    started: ").append(toIndentedString(started)).append("\n");
    sb.append("    timeSpent: ").append(toIndentedString(timeSpent)).append("\n");
    sb.append("    timeSpentSeconds: ").append(toIndentedString(timeSpentSeconds)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    issueId: ").append(toIndentedString(issueId)).append("\n");
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

