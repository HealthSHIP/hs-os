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

import java.util.Objects;

/**
 * AttachmentArchiveEntry
 */
@JsonPropertyOrder({
  AttachmentArchiveEntry.JSON_PROPERTY_ENTRY_INDEX,
  AttachmentArchiveEntry.JSON_PROPERTY_ABBREVIATED_NAME,
  AttachmentArchiveEntry.JSON_PROPERTY_MEDIA_TYPE,
  AttachmentArchiveEntry.JSON_PROPERTY_NAME,
  AttachmentArchiveEntry.JSON_PROPERTY_SIZE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class AttachmentArchiveEntry {
  public static final String JSON_PROPERTY_ENTRY_INDEX = "entryIndex";
  private Long entryIndex;

  public static final String JSON_PROPERTY_ABBREVIATED_NAME = "abbreviatedName";
  private String abbreviatedName;

  public static final String JSON_PROPERTY_MEDIA_TYPE = "mediaType";
  private String mediaType;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Long size;


  public AttachmentArchiveEntry entryIndex(Long entryIndex) {
    
    this.entryIndex = entryIndex;
    return this;
  }

   /**
   * Get entryIndex
   * @return entryIndex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ENTRY_INDEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getEntryIndex() {
    return entryIndex;
  }


  public void setEntryIndex(Long entryIndex) {
    this.entryIndex = entryIndex;
  }


  public AttachmentArchiveEntry abbreviatedName(String abbreviatedName) {
    
    this.abbreviatedName = abbreviatedName;
    return this;
  }

   /**
   * Get abbreviatedName
   * @return abbreviatedName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ABBREVIATED_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAbbreviatedName() {
    return abbreviatedName;
  }


  public void setAbbreviatedName(String abbreviatedName) {
    this.abbreviatedName = abbreviatedName;
  }


  public AttachmentArchiveEntry mediaType(String mediaType) {
    
    this.mediaType = mediaType;
    return this;
  }

   /**
   * Get mediaType
   * @return mediaType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MEDIA_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMediaType() {
    return mediaType;
  }


  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }


  public AttachmentArchiveEntry name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public AttachmentArchiveEntry size(Long size) {
    
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

  public Long getSize() {
    return size;
  }


  public void setSize(Long size) {
    this.size = size;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachmentArchiveEntry attachmentArchiveEntry = (AttachmentArchiveEntry) o;
    return Objects.equals(this.entryIndex, attachmentArchiveEntry.entryIndex) &&
        Objects.equals(this.abbreviatedName, attachmentArchiveEntry.abbreviatedName) &&
        Objects.equals(this.mediaType, attachmentArchiveEntry.mediaType) &&
        Objects.equals(this.name, attachmentArchiveEntry.name) &&
        Objects.equals(this.size, attachmentArchiveEntry.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entryIndex, abbreviatedName, mediaType, name, size);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentArchiveEntry {\n");
    sb.append("    entryIndex: ").append(toIndentedString(entryIndex)).append("\n");
    sb.append("    abbreviatedName: ").append(toIndentedString(abbreviatedName)).append("\n");
    sb.append("    mediaType: ").append(toIndentedString(mediaType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

