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

import java.util.Objects;

/**
 * Details about the operations available in this version.
 */
@ApiModel(description = "Details about the operations available in this version.")
@JsonPropertyOrder({
  SimpleLink.JSON_PROPERTY_ID,
  SimpleLink.JSON_PROPERTY_STYLE_CLASS,
  SimpleLink.JSON_PROPERTY_ICON_CLASS,
  SimpleLink.JSON_PROPERTY_LABEL,
  SimpleLink.JSON_PROPERTY_TITLE,
  SimpleLink.JSON_PROPERTY_HREF,
  SimpleLink.JSON_PROPERTY_WEIGHT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class SimpleLink {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_STYLE_CLASS = "styleClass";
  private String styleClass;

  public static final String JSON_PROPERTY_ICON_CLASS = "iconClass";
  private String iconClass;

  public static final String JSON_PROPERTY_LABEL = "label";
  private String label;

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;

  public static final String JSON_PROPERTY_HREF = "href";
  private String href;

  public static final String JSON_PROPERTY_WEIGHT = "weight";
  private Integer weight;


  public SimpleLink id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public SimpleLink styleClass(String styleClass) {
    
    this.styleClass = styleClass;
    return this;
  }

   /**
   * Get styleClass
   * @return styleClass
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STYLE_CLASS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getStyleClass() {
    return styleClass;
  }


  public void setStyleClass(String styleClass) {
    this.styleClass = styleClass;
  }


  public SimpleLink iconClass(String iconClass) {
    
    this.iconClass = iconClass;
    return this;
  }

   /**
   * Get iconClass
   * @return iconClass
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ICON_CLASS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getIconClass() {
    return iconClass;
  }


  public void setIconClass(String iconClass) {
    this.iconClass = iconClass;
  }


  public SimpleLink label(String label) {
    
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LABEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLabel() {
    return label;
  }


  public void setLabel(String label) {
    this.label = label;
  }


  public SimpleLink title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public SimpleLink href(String href) {
    
    this.href = href;
    return this;
  }

   /**
   * Get href
   * @return href
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_HREF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getHref() {
    return href;
  }


  public void setHref(String href) {
    this.href = href;
  }


  public SimpleLink weight(Integer weight) {
    
    this.weight = weight;
    return this;
  }

   /**
   * Get weight
   * @return weight
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_WEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getWeight() {
    return weight;
  }


  public void setWeight(Integer weight) {
    this.weight = weight;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimpleLink simpleLink = (SimpleLink) o;
    return Objects.equals(this.id, simpleLink.id) &&
        Objects.equals(this.styleClass, simpleLink.styleClass) &&
        Objects.equals(this.iconClass, simpleLink.iconClass) &&
        Objects.equals(this.label, simpleLink.label) &&
        Objects.equals(this.title, simpleLink.title) &&
        Objects.equals(this.href, simpleLink.href) &&
        Objects.equals(this.weight, simpleLink.weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, styleClass, iconClass, label, title, href, weight);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimpleLink {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    styleClass: ").append(toIndentedString(styleClass)).append("\n");
    sb.append("    iconClass: ").append(toIndentedString(iconClass)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
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

