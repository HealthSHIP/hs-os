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
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SimpleListWrapperGroupName
 */
@JsonPropertyOrder({
  SimpleListWrapperGroupName.JSON_PROPERTY_SIZE,
  SimpleListWrapperGroupName.JSON_PROPERTY_ITEMS,
  SimpleListWrapperGroupName.JSON_PROPERTY_PAGING_CALLBACK,
  SimpleListWrapperGroupName.JSON_PROPERTY_CALLBACK,
  SimpleListWrapperGroupName.JSON_PROPERTY_MAX_RESULTS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class SimpleListWrapperGroupName {
  public static final String JSON_PROPERTY_SIZE = "size";
  private Integer size;

  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<GroupName> items = null;

  public static final String JSON_PROPERTY_PAGING_CALLBACK = "pagingCallback";
  private Object pagingCallback;

  public static final String JSON_PROPERTY_CALLBACK = "callback";
  private Object callback;

  public static final String JSON_PROPERTY_MAX_RESULTS = "max-results";
  private Integer maxResults;


  public SimpleListWrapperGroupName size(Integer size) {
    
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getSize() {
    return size;
  }


  public void setSize(Integer size) {
    this.size = size;
  }


  public SimpleListWrapperGroupName items(List<GroupName> items) {
    
    this.items = items;
    return this;
  }

  public SimpleListWrapperGroupName addItemsItem(GroupName itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Get items
   * @return items
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<GroupName> getItems() {
    return items;
  }


  public void setItems(List<GroupName> items) {
    this.items = items;
  }


  public SimpleListWrapperGroupName pagingCallback(Object pagingCallback) {
    
    this.pagingCallback = pagingCallback;
    return this;
  }

   /**
   * Get pagingCallback
   * @return pagingCallback
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PAGING_CALLBACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getPagingCallback() {
    return pagingCallback;
  }


  public void setPagingCallback(Object pagingCallback) {
    this.pagingCallback = pagingCallback;
  }


  public SimpleListWrapperGroupName callback(Object callback) {
    
    this.callback = callback;
    return this;
  }

   /**
   * Get callback
   * @return callback
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CALLBACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getCallback() {
    return callback;
  }


  public void setCallback(Object callback) {
    this.callback = callback;
  }


  public SimpleListWrapperGroupName maxResults(Integer maxResults) {
    
    this.maxResults = maxResults;
    return this;
  }

   /**
   * Get maxResults
   * @return maxResults
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MAX_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMaxResults() {
    return maxResults;
  }


  public void setMaxResults(Integer maxResults) {
    this.maxResults = maxResults;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimpleListWrapperGroupName simpleListWrapperGroupName = (SimpleListWrapperGroupName) o;
    return Objects.equals(this.size, simpleListWrapperGroupName.size) &&
        Objects.equals(this.items, simpleListWrapperGroupName.items) &&
        Objects.equals(this.pagingCallback, simpleListWrapperGroupName.pagingCallback) &&
        Objects.equals(this.callback, simpleListWrapperGroupName.callback) &&
        Objects.equals(this.maxResults, simpleListWrapperGroupName.maxResults);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size, items, pagingCallback, callback, maxResults);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimpleListWrapperGroupName {\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    pagingCallback: ").append(toIndentedString(pagingCallback)).append("\n");
    sb.append("    callback: ").append(toIndentedString(callback)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
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

