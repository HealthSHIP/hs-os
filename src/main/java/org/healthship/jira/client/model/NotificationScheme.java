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
 * Details about a notification scheme.
 */
@ApiModel(description = "Details about a notification scheme.")
@JsonPropertyOrder({
  NotificationScheme.JSON_PROPERTY_EXPAND,
  NotificationScheme.JSON_PROPERTY_ID,
  NotificationScheme.JSON_PROPERTY_SELF,
  NotificationScheme.JSON_PROPERTY_NAME,
  NotificationScheme.JSON_PROPERTY_DESCRIPTION,
  NotificationScheme.JSON_PROPERTY_NOTIFICATION_SCHEME_EVENTS,
  NotificationScheme.JSON_PROPERTY_SCOPE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class NotificationScheme {
  public static final String JSON_PROPERTY_EXPAND = "expand";
  private String expand;

  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  public static final String JSON_PROPERTY_SELF = "self";
  private String self;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_NOTIFICATION_SCHEME_EVENTS = "notificationSchemeEvents";
  private List<NotificationSchemeEvent> notificationSchemeEvents = null;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  private Scope scope = null;


  public NotificationScheme expand(String expand) {
    
    this.expand = expand;
    return this;
  }

   /**
   * Expand options that include additional notification scheme details in the response.
   * @return expand
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Expand options that include additional notification scheme details in the response.")
  @JsonProperty(JSON_PROPERTY_EXPAND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExpand() {
    return expand;
  }


  public void setExpand(String expand) {
    this.expand = expand;
  }


  public NotificationScheme id(Long id) {
    
    this.id = id;
    return this;
  }

   /**
   * The ID of the notification scheme.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the notification scheme.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public NotificationScheme self(String self) {
    
    this.self = self;
    return this;
  }

   /**
   * Get self
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSelf() {
    return self;
  }


  public void setSelf(String self) {
    this.self = self;
  }


  public NotificationScheme name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the notification scheme.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the notification scheme.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public NotificationScheme description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * The description of the notification scheme.
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description of the notification scheme.")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public NotificationScheme notificationSchemeEvents(List<NotificationSchemeEvent> notificationSchemeEvents) {
    
    this.notificationSchemeEvents = notificationSchemeEvents;
    return this;
  }

  public NotificationScheme addNotificationSchemeEventsItem(NotificationSchemeEvent notificationSchemeEventsItem) {
    if (this.notificationSchemeEvents == null) {
      this.notificationSchemeEvents = new ArrayList<>();
    }
    this.notificationSchemeEvents.add(notificationSchemeEventsItem);
    return this;
  }

   /**
   * The notification events and associated recipients.
   * @return notificationSchemeEvents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The notification events and associated recipients.")
  @JsonProperty(JSON_PROPERTY_NOTIFICATION_SCHEME_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<NotificationSchemeEvent> getNotificationSchemeEvents() {
    return notificationSchemeEvents;
  }


  public void setNotificationSchemeEvents(List<NotificationSchemeEvent> notificationSchemeEvents) {
    this.notificationSchemeEvents = notificationSchemeEvents;
  }


  public NotificationScheme scope(Scope scope) {
    
    this.scope = scope;
    return this;
  }

   /**
   * The scope of the notification scheme.
   * @return scope
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The scope of the notification scheme.")
  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Scope getScope() {
    return scope;
  }


  public void setScope(Scope scope) {
    this.scope = scope;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationScheme notificationScheme = (NotificationScheme) o;
    return Objects.equals(this.expand, notificationScheme.expand) &&
        Objects.equals(this.id, notificationScheme.id) &&
        Objects.equals(this.self, notificationScheme.self) &&
        Objects.equals(this.name, notificationScheme.name) &&
        Objects.equals(this.description, notificationScheme.description) &&
        Objects.equals(this.notificationSchemeEvents, notificationScheme.notificationSchemeEvents) &&
        Objects.equals(this.scope, notificationScheme.scope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expand, id, self, name, description, notificationSchemeEvents, scope);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationScheme {\n");
    sb.append("    expand: ").append(toIndentedString(expand)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    notificationSchemeEvents: ").append(toIndentedString(notificationSchemeEvents)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
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

