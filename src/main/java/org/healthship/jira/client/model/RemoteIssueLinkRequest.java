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

import java.util.HashMap;
import java.util.Objects;

/**
 * Details of a remote issue link.
 */
@ApiModel(description = "Details of a remote issue link.")
@JsonPropertyOrder({
  RemoteIssueLinkRequest.JSON_PROPERTY_GLOBAL_ID,
  RemoteIssueLinkRequest.JSON_PROPERTY_APPLICATION,
  RemoteIssueLinkRequest.JSON_PROPERTY_RELATIONSHIP,
  RemoteIssueLinkRequest.JSON_PROPERTY_OBJECT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class RemoteIssueLinkRequest extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_GLOBAL_ID = "globalId";
  private String globalId;

  public static final String JSON_PROPERTY_APPLICATION = "application";
  private Application application = null;

  public static final String JSON_PROPERTY_RELATIONSHIP = "relationship";
  private String relationship;

  public static final String JSON_PROPERTY_OBJECT = "object";
  private RemoteObject _object = null;


  public RemoteIssueLinkRequest globalId(String globalId) {
    
    this.globalId = globalId;
    return this;
  }

   /**
   * An identifier for the remote item in the remote system. For example, the global ID for a remote item in Confluence would consist of the app ID and page ID, like this: &#x60;appId&#x3D;456&amp;pageId&#x3D;123&#x60;.  Setting this field enables the remote issue link details to be updated or deleted using remote system and item details as the record identifier, rather than using the record&#39;s Jira ID.  The maximum length is 255 characters.
   * @return globalId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An identifier for the remote item in the remote system. For example, the global ID for a remote item in Confluence would consist of the app ID and page ID, like this: `appId=456&pageId=123`.  Setting this field enables the remote issue link details to be updated or deleted using remote system and item details as the record identifier, rather than using the record's Jira ID.  The maximum length is 255 characters.")
  @JsonProperty(JSON_PROPERTY_GLOBAL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGlobalId() {
    return globalId;
  }


  public void setGlobalId(String globalId) {
    this.globalId = globalId;
  }


  public RemoteIssueLinkRequest application(Application application) {
    
    this.application = application;
    return this;
  }

   /**
   * Details of the remote application the linked item is in. For example, trello.
   * @return application
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of the remote application the linked item is in. For example, trello.")
  @JsonProperty(JSON_PROPERTY_APPLICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Application getApplication() {
    return application;
  }


  public void setApplication(Application application) {
    this.application = application;
  }


  public RemoteIssueLinkRequest relationship(String relationship) {
    
    this.relationship = relationship;
    return this;
  }

   /**
   * Description of the relationship between the issue and the linked item. If not set, the relationship description \&quot;links to\&quot; is used in Jira.
   * @return relationship
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Description of the relationship between the issue and the linked item. If not set, the relationship description \"links to\" is used in Jira.")
  @JsonProperty(JSON_PROPERTY_RELATIONSHIP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRelationship() {
    return relationship;
  }


  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }


  public RemoteIssueLinkRequest _object(RemoteObject _object) {
    
    this._object = _object;
    return this;
  }

   /**
   * Details of the item linked to.
   * @return _object
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of the item linked to.")
  @JsonProperty(JSON_PROPERTY_OBJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RemoteObject getObject() {
    return _object;
  }


  public void setObject(RemoteObject _object) {
    this._object = _object;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RemoteIssueLinkRequest remoteIssueLinkRequest = (RemoteIssueLinkRequest) o;
    return Objects.equals(this.globalId, remoteIssueLinkRequest.globalId) &&
        Objects.equals(this.application, remoteIssueLinkRequest.application) &&
        Objects.equals(this.relationship, remoteIssueLinkRequest.relationship) &&
        Objects.equals(this._object, remoteIssueLinkRequest._object) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(globalId, application, relationship, _object, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RemoteIssueLinkRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    globalId: ").append(toIndentedString(globalId)).append("\n");
    sb.append("    application: ").append(toIndentedString(application)).append("\n");
    sb.append("    relationship: ").append(toIndentedString(relationship)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
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

