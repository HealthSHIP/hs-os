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
 * Details of any errors encountered while updating workflow transition rules.
 */
@ApiModel(description = "Details of any errors encountered while updating workflow transition rules.")
@JsonPropertyOrder({
  WorkflowTransitionRulesUpdateErrors.JSON_PROPERTY_UPDATE_RESULTS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class WorkflowTransitionRulesUpdateErrors {
  public static final String JSON_PROPERTY_UPDATE_RESULTS = "updateResults";
  private List<WorkflowTransitionRulesUpdateErrorDetails> updateResults = new ArrayList<>();


  public WorkflowTransitionRulesUpdateErrors updateResults(List<WorkflowTransitionRulesUpdateErrorDetails> updateResults) {
    
    this.updateResults = updateResults;
    return this;
  }

  public WorkflowTransitionRulesUpdateErrors addUpdateResultsItem(WorkflowTransitionRulesUpdateErrorDetails updateResultsItem) {
    this.updateResults.add(updateResultsItem);
    return this;
  }

   /**
   * A list of workflows.
   * @return updateResults
  **/
  @ApiModelProperty(required = true, value = "A list of workflows.")
  @JsonProperty(JSON_PROPERTY_UPDATE_RESULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<WorkflowTransitionRulesUpdateErrorDetails> getUpdateResults() {
    return updateResults;
  }


  public void setUpdateResults(List<WorkflowTransitionRulesUpdateErrorDetails> updateResults) {
    this.updateResults = updateResults;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowTransitionRulesUpdateErrors workflowTransitionRulesUpdateErrors = (WorkflowTransitionRulesUpdateErrors) o;
    return Objects.equals(this.updateResults, workflowTransitionRulesUpdateErrors.updateResults);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updateResults);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowTransitionRulesUpdateErrors {\n");
    sb.append("    updateResults: ").append(toIndentedString(updateResults)).append("\n");
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

