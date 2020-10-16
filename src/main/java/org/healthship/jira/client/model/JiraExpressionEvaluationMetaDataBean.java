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
 * JiraExpressionEvaluationMetaDataBean
 */
@JsonPropertyOrder({
  JiraExpressionEvaluationMetaDataBean.JSON_PROPERTY_COMPLEXITY,
  JiraExpressionEvaluationMetaDataBean.JSON_PROPERTY_ISSUES
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class JiraExpressionEvaluationMetaDataBean {
  public static final String JSON_PROPERTY_COMPLEXITY = "complexity";
  private JiraExpressionsComplexityBean complexity = null;

  public static final String JSON_PROPERTY_ISSUES = "issues";
  private IssuesMetaBean issues = null;


  public JiraExpressionEvaluationMetaDataBean complexity(JiraExpressionsComplexityBean complexity) {
    
    this.complexity = complexity;
    return this;
  }

   /**
   * Contains information about the expression complexity. For example, the number of steps it took to evaluate the expression.
   * @return complexity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Contains information about the expression complexity. For example, the number of steps it took to evaluate the expression.")
  @JsonProperty(JSON_PROPERTY_COMPLEXITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JiraExpressionsComplexityBean getComplexity() {
    return complexity;
  }


  public void setComplexity(JiraExpressionsComplexityBean complexity) {
    this.complexity = complexity;
  }


  public JiraExpressionEvaluationMetaDataBean issues(IssuesMetaBean issues) {
    
    this.issues = issues;
    return this;
  }

   /**
   * Contains information about the &#x60;issues&#x60; variable in the context. For example, is the issues were loaded with JQL, information about the page will be included here.
   * @return issues
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Contains information about the `issues` variable in the context. For example, is the issues were loaded with JQL, information about the page will be included here.")
  @JsonProperty(JSON_PROPERTY_ISSUES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IssuesMetaBean getIssues() {
    return issues;
  }


  public void setIssues(IssuesMetaBean issues) {
    this.issues = issues;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JiraExpressionEvaluationMetaDataBean jiraExpressionEvaluationMetaDataBean = (JiraExpressionEvaluationMetaDataBean) o;
    return Objects.equals(this.complexity, jiraExpressionEvaluationMetaDataBean.complexity) &&
        Objects.equals(this.issues, jiraExpressionEvaluationMetaDataBean.issues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(complexity, issues);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JiraExpressionEvaluationMetaDataBean {\n");
    sb.append("    complexity: ").append(toIndentedString(complexity)).append("\n");
    sb.append("    issues: ").append(toIndentedString(issues)).append("\n");
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

