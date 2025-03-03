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
import java.util.List;
import java.util.Objects;

/**
 * An audit record.
 */
@ApiModel(description = "An audit record.")
@JsonPropertyOrder({
  AuditRecordBean.JSON_PROPERTY_ID,
  AuditRecordBean.JSON_PROPERTY_SUMMARY,
  AuditRecordBean.JSON_PROPERTY_REMOTE_ADDRESS,
  AuditRecordBean.JSON_PROPERTY_AUTHOR_KEY,
  AuditRecordBean.JSON_PROPERTY_CREATED,
  AuditRecordBean.JSON_PROPERTY_CATEGORY,
  AuditRecordBean.JSON_PROPERTY_EVENT_SOURCE,
  AuditRecordBean.JSON_PROPERTY_DESCRIPTION,
  AuditRecordBean.JSON_PROPERTY_OBJECT_ITEM,
  AuditRecordBean.JSON_PROPERTY_CHANGED_VALUES,
  AuditRecordBean.JSON_PROPERTY_ASSOCIATED_ITEMS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class AuditRecordBean {
  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  public static final String JSON_PROPERTY_SUMMARY = "summary";
  private String summary;

  public static final String JSON_PROPERTY_REMOTE_ADDRESS = "remoteAddress";
  private String remoteAddress;

  public static final String JSON_PROPERTY_AUTHOR_KEY = "authorKey";
  private String authorKey;

  public static final String JSON_PROPERTY_CREATED = "created";
  private OffsetDateTime created;

  public static final String JSON_PROPERTY_CATEGORY = "category";
  private String category;

  public static final String JSON_PROPERTY_EVENT_SOURCE = "eventSource";
  private String eventSource;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_OBJECT_ITEM = "objectItem";
  private AssociatedItemBean objectItem;

  public static final String JSON_PROPERTY_CHANGED_VALUES = "changedValues";
  private List<ChangedValueBean> changedValues = null;

  public static final String JSON_PROPERTY_ASSOCIATED_ITEMS = "associatedItems";
  private List<AssociatedItemBean> associatedItems = null;


   /**
   * The ID of the audit record.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the audit record.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getId() {
    return id;
  }




   /**
   * The summary of the audit record.
   * @return summary
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The summary of the audit record.")
  @JsonProperty(JSON_PROPERTY_SUMMARY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSummary() {
    return summary;
  }




   /**
   * The URL of the computer where the creation of the audit record was initiated.
   * @return remoteAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the computer where the creation of the audit record was initiated.")
  @JsonProperty(JSON_PROPERTY_REMOTE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRemoteAddress() {
    return remoteAddress;
  }




   /**
   * Deprecated, use &#x60;authorAccountId&#x60; instead. The key of the user who created the audit record.
   * @return authorKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Deprecated, use `authorAccountId` instead. The key of the user who created the audit record.")
  @JsonProperty(JSON_PROPERTY_AUTHOR_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAuthorKey() {
    return authorKey;
  }




   /**
   * The date and time on which the audit record was created.
   * @return created
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time on which the audit record was created.")
  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreated() {
    return created;
  }




   /**
   * The category of the audit record. For a list of these categories, see the help article [Auditing in Jira applications](https://confluence.atlassian.com/x/noXKM).
   * @return category
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The category of the audit record. For a list of these categories, see the help article [Auditing in Jira applications](https://confluence.atlassian.com/x/noXKM).")
  @JsonProperty(JSON_PROPERTY_CATEGORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCategory() {
    return category;
  }




   /**
   * The event the audit record originated from.
   * @return eventSource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The event the audit record originated from.")
  @JsonProperty(JSON_PROPERTY_EVENT_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEventSource() {
    return eventSource;
  }




   /**
   * The description of the audit record.
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description of the audit record.")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }




  public AuditRecordBean objectItem(AssociatedItemBean objectItem) {
    
    this.objectItem = objectItem;
    return this;
  }

   /**
   * Get objectItem
   * @return objectItem
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_OBJECT_ITEM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AssociatedItemBean getObjectItem() {
    return objectItem;
  }


  public void setObjectItem(AssociatedItemBean objectItem) {
    this.objectItem = objectItem;
  }


   /**
   * The list of values changed in the record event.
   * @return changedValues
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list of values changed in the record event.")
  @JsonProperty(JSON_PROPERTY_CHANGED_VALUES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ChangedValueBean> getChangedValues() {
    return changedValues;
  }




   /**
   * The list of items associated with the changed record.
   * @return associatedItems
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list of items associated with the changed record.")
  @JsonProperty(JSON_PROPERTY_ASSOCIATED_ITEMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<AssociatedItemBean> getAssociatedItems() {
    return associatedItems;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditRecordBean auditRecordBean = (AuditRecordBean) o;
    return Objects.equals(this.id, auditRecordBean.id) &&
        Objects.equals(this.summary, auditRecordBean.summary) &&
        Objects.equals(this.remoteAddress, auditRecordBean.remoteAddress) &&
        Objects.equals(this.authorKey, auditRecordBean.authorKey) &&
        Objects.equals(this.created, auditRecordBean.created) &&
        Objects.equals(this.category, auditRecordBean.category) &&
        Objects.equals(this.eventSource, auditRecordBean.eventSource) &&
        Objects.equals(this.description, auditRecordBean.description) &&
        Objects.equals(this.objectItem, auditRecordBean.objectItem) &&
        Objects.equals(this.changedValues, auditRecordBean.changedValues) &&
        Objects.equals(this.associatedItems, auditRecordBean.associatedItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, summary, remoteAddress, authorKey, created, category, eventSource, description, objectItem, changedValues, associatedItems);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditRecordBean {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    remoteAddress: ").append(toIndentedString(remoteAddress)).append("\n");
    sb.append("    authorKey: ").append(toIndentedString(authorKey)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    eventSource: ").append(toIndentedString(eventSource)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    objectItem: ").append(toIndentedString(objectItem)).append("\n");
    sb.append("    changedValues: ").append(toIndentedString(changedValues)).append("\n");
    sb.append("    associatedItems: ").append(toIndentedString(associatedItems)).append("\n");
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

