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
 * JiraExpressionEvalRequestBean
 */
@JsonPropertyOrder({
  JiraExpressionEvalRequestBean.JSON_PROPERTY_EXPRESSION,
  JiraExpressionEvalRequestBean.JSON_PROPERTY_CONTEXT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class JiraExpressionEvalRequestBean {
  public static final String JSON_PROPERTY_EXPRESSION = "expression";
  private String expression;

  public static final String JSON_PROPERTY_CONTEXT = "context";
  private JiraExpressionEvalContextBean context = null;


  public JiraExpressionEvalRequestBean expression(String expression) {
    
    this.expression = expression;
    return this;
  }

   /**
   * The Jira expression to evaluate.
   * @return expression
  **/
  @ApiModelProperty(example = "{ key: issue.key, type: issue.issueType.name, links: issue.links.map(link => link.linkedIssue.id) }", required = true, value = "The Jira expression to evaluate.")
  @JsonProperty(JSON_PROPERTY_EXPRESSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getExpression() {
    return expression;
  }


  public void setExpression(String expression) {
    this.expression = expression;
  }


  public JiraExpressionEvalRequestBean context(JiraExpressionEvalContextBean context) {
    
    this.context = context;
    return this;
  }

   /**
   * The context in which the Jira expression is evaluated.
   * @return context
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The context in which the Jira expression is evaluated.")
  @JsonProperty(JSON_PROPERTY_CONTEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JiraExpressionEvalContextBean getContext() {
    return context;
  }


  public void setContext(JiraExpressionEvalContextBean context) {
    this.context = context;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JiraExpressionEvalRequestBean jiraExpressionEvalRequestBean = (JiraExpressionEvalRequestBean) o;
    return Objects.equals(this.expression, jiraExpressionEvalRequestBean.expression) &&
        Objects.equals(this.context, jiraExpressionEvalRequestBean.context);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expression, context);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JiraExpressionEvalRequestBean {\n");
    sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
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

