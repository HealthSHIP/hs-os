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
import java.util.List;
import java.util.Objects;

/**
 * Various counts of issues within a version.
 */
@ApiModel(description = "Various counts of issues within a version.")
@JsonPropertyOrder({
  VersionIssueCounts.JSON_PROPERTY_SELF,
  VersionIssueCounts.JSON_PROPERTY_ISSUES_FIXED_COUNT,
  VersionIssueCounts.JSON_PROPERTY_ISSUES_AFFECTED_COUNT,
  VersionIssueCounts.JSON_PROPERTY_ISSUE_COUNT_WITH_CUSTOM_FIELDS_SHOWING_VERSION,
  VersionIssueCounts.JSON_PROPERTY_CUSTOM_FIELD_USAGE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class VersionIssueCounts {
  public static final String JSON_PROPERTY_SELF = "self";
  private URI self;

  public static final String JSON_PROPERTY_ISSUES_FIXED_COUNT = "issuesFixedCount";
  private Long issuesFixedCount;

  public static final String JSON_PROPERTY_ISSUES_AFFECTED_COUNT = "issuesAffectedCount";
  private Long issuesAffectedCount;

  public static final String JSON_PROPERTY_ISSUE_COUNT_WITH_CUSTOM_FIELDS_SHOWING_VERSION = "issueCountWithCustomFieldsShowingVersion";
  private Long issueCountWithCustomFieldsShowingVersion;

  public static final String JSON_PROPERTY_CUSTOM_FIELD_USAGE = "customFieldUsage";
  private List<VersionUsageInCustomField> customFieldUsage = null;


   /**
   * The URL of these count details.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of these count details.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public URI getSelf() {
    return self;
  }




   /**
   * Count of issues where the &#x60;fixVersion&#x60; is set to the version.
   * @return issuesFixedCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Count of issues where the `fixVersion` is set to the version.")
  @JsonProperty(JSON_PROPERTY_ISSUES_FIXED_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getIssuesFixedCount() {
    return issuesFixedCount;
  }




   /**
   * Count of issues where the &#x60;affectedVersion&#x60; is set to the version.
   * @return issuesAffectedCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Count of issues where the `affectedVersion` is set to the version.")
  @JsonProperty(JSON_PROPERTY_ISSUES_AFFECTED_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getIssuesAffectedCount() {
    return issuesAffectedCount;
  }




   /**
   * Count of issues where a version custom field is set to the version.
   * @return issueCountWithCustomFieldsShowingVersion
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Count of issues where a version custom field is set to the version.")
  @JsonProperty(JSON_PROPERTY_ISSUE_COUNT_WITH_CUSTOM_FIELDS_SHOWING_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getIssueCountWithCustomFieldsShowingVersion() {
    return issueCountWithCustomFieldsShowingVersion;
  }




   /**
   * List of custom fields using the version.
   * @return customFieldUsage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of custom fields using the version.")
  @JsonProperty(JSON_PROPERTY_CUSTOM_FIELD_USAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<VersionUsageInCustomField> getCustomFieldUsage() {
    return customFieldUsage;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionIssueCounts versionIssueCounts = (VersionIssueCounts) o;
    return Objects.equals(this.self, versionIssueCounts.self) &&
        Objects.equals(this.issuesFixedCount, versionIssueCounts.issuesFixedCount) &&
        Objects.equals(this.issuesAffectedCount, versionIssueCounts.issuesAffectedCount) &&
        Objects.equals(this.issueCountWithCustomFieldsShowingVersion, versionIssueCounts.issueCountWithCustomFieldsShowingVersion) &&
        Objects.equals(this.customFieldUsage, versionIssueCounts.customFieldUsage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, issuesFixedCount, issuesAffectedCount, issueCountWithCustomFieldsShowingVersion, customFieldUsage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionIssueCounts {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    issuesFixedCount: ").append(toIndentedString(issuesFixedCount)).append("\n");
    sb.append("    issuesAffectedCount: ").append(toIndentedString(issuesAffectedCount)).append("\n");
    sb.append("    issueCountWithCustomFieldsShowingVersion: ").append(toIndentedString(issueCountWithCustomFieldsShowingVersion)).append("\n");
    sb.append("    customFieldUsage: ").append(toIndentedString(customFieldUsage)).append("\n");
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

