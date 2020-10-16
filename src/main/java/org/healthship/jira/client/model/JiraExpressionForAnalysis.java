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
 * Details of Jira expressions for analysis.
 */
@ApiModel(description = "Details of Jira expressions for analysis.")
@JsonPropertyOrder({
  JiraExpressionForAnalysis.JSON_PROPERTY_EXPRESSIONS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class JiraExpressionForAnalysis {
  public static final String JSON_PROPERTY_EXPRESSIONS = "expressions";
  private List<String> expressions = new ArrayList<>();


  public JiraExpressionForAnalysis expressions(List<String> expressions) {
    
    this.expressions = expressions;
    return this;
  }

  public JiraExpressionForAnalysis addExpressionsItem(String expressionsItem) {
    this.expressions.add(expressionsItem);
    return this;
  }

   /**
   * The list of Jira expressions to analyse.
   * @return expressions
  **/
  @ApiModelProperty(example = "a -> 1", required = true, value = "The list of Jira expressions to analyse.")
  @JsonProperty(JSON_PROPERTY_EXPRESSIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getExpressions() {
    return expressions;
  }


  public void setExpressions(List<String> expressions) {
    this.expressions = expressions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JiraExpressionForAnalysis jiraExpressionForAnalysis = (JiraExpressionForAnalysis) o;
    return Objects.equals(this.expressions, jiraExpressionForAnalysis.expressions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expressions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JiraExpressionForAnalysis {\n");
    sb.append("    expressions: ").append(toIndentedString(expressions)).append("\n");
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

