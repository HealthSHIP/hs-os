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
 * A changelog.
 */
@ApiModel(description = "A changelog.")
@JsonPropertyOrder({
  Changelog.JSON_PROPERTY_ID,
  Changelog.JSON_PROPERTY_AUTHOR,
  Changelog.JSON_PROPERTY_CREATED,
  Changelog.JSON_PROPERTY_ITEMS,
  Changelog.JSON_PROPERTY_HISTORY_METADATA
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class Changelog {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_AUTHOR = "author";
  private UserDetails author = null;

  public static final String JSON_PROPERTY_CREATED = "created";
  private OffsetDateTime created;

  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<ChangeDetails> items = null;

  public static final String JSON_PROPERTY_HISTORY_METADATA = "historyMetadata";
  private HistoryMetadata historyMetadata = null;


   /**
   * The ID of the changelog.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the changelog.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }




   /**
   * The user who made the change.
   * @return author
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The user who made the change.")
  @JsonProperty(JSON_PROPERTY_AUTHOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UserDetails getAuthor() {
    return author;
  }




   /**
   * The date on which the change took place.
   * @return created
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date on which the change took place.")
  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreated() {
    return created;
  }




   /**
   * The list of items changed.
   * @return items
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list of items changed.")
  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ChangeDetails> getItems() {
    return items;
  }




   /**
   * The history metadata associated with the changed.
   * @return historyMetadata
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The history metadata associated with the changed.")
  @JsonProperty(JSON_PROPERTY_HISTORY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public HistoryMetadata getHistoryMetadata() {
    return historyMetadata;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Changelog changelog = (Changelog) o;
    return Objects.equals(this.id, changelog.id) &&
        Objects.equals(this.author, changelog.author) &&
        Objects.equals(this.created, changelog.created) &&
        Objects.equals(this.items, changelog.items) &&
        Objects.equals(this.historyMetadata, changelog.historyMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, author, created, items, historyMetadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Changelog {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    historyMetadata: ").append(toIndentedString(historyMetadata)).append("\n");
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

