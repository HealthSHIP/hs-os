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

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SearchRequestBean
 */
@JsonPropertyOrder({
  SearchRequestBean.JSON_PROPERTY_JQL,
  SearchRequestBean.JSON_PROPERTY_START_AT,
  SearchRequestBean.JSON_PROPERTY_MAX_RESULTS,
  SearchRequestBean.JSON_PROPERTY_FIELDS,
  SearchRequestBean.JSON_PROPERTY_VALIDATE_QUERY,
  SearchRequestBean.JSON_PROPERTY_EXPAND,
  SearchRequestBean.JSON_PROPERTY_PROPERTIES,
  SearchRequestBean.JSON_PROPERTY_FIELDS_BY_KEYS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class SearchRequestBean {
  public static final String JSON_PROPERTY_JQL = "jql";
  private String jql;

  public static final String JSON_PROPERTY_START_AT = "startAt";
  private Integer startAt;

  public static final String JSON_PROPERTY_MAX_RESULTS = "maxResults";
  private Integer maxResults = 50;

  public static final String JSON_PROPERTY_FIELDS = "fields";
  private List<String> fields = null;

  /**
   * Determines how to validate the JQL query and treat the validation results. Supported values:   *  &#x60;strict&#x60; Returns a 400 response code if any errors are found, along with a list of all errors (and warnings).  *  &#x60;warn&#x60; Returns all errors as warnings.  *  &#x60;none&#x60; No validation is performed.  *  &#x60;true&#x60; *Deprecated* A legacy synonym for &#x60;strict&#x60;.  *  &#x60;false&#x60; *Deprecated* A legacy synonym for &#x60;warn&#x60;.  The default is &#x60;strict&#x60;.  Note: If the JQL is not correctly formed a 400 response code is returned, regardless of the &#x60;validateQuery&#x60; value.
   */
  public enum ValidateQueryEnum {
    STRICT("strict"),
    
    WARN("warn"),
    
    NONE("none"),
    
    TRUE("true"),
    
    FALSE("false");

    private String value;

    ValidateQueryEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ValidateQueryEnum fromValue(String value) {
      for (ValidateQueryEnum b : ValidateQueryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_VALIDATE_QUERY = "validateQuery";
  private ValidateQueryEnum validateQuery;

  public static final String JSON_PROPERTY_EXPAND = "expand";
  private List<String> expand = null;

  public static final String JSON_PROPERTY_PROPERTIES = "properties";
  private List<String> properties = null;

  public static final String JSON_PROPERTY_FIELDS_BY_KEYS = "fieldsByKeys";
  private Boolean fieldsByKeys;


  public SearchRequestBean jql(String jql) {
    
    this.jql = jql;
    return this;
  }

   /**
   * A [JQL](https://confluence.atlassian.com/x/egORLQ) expression.
   * @return jql
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A [JQL](https://confluence.atlassian.com/x/egORLQ) expression.")
  @JsonProperty(JSON_PROPERTY_JQL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getJql() {
    return jql;
  }


  public void setJql(String jql) {
    this.jql = jql;
  }


  public SearchRequestBean startAt(Integer startAt) {
    
    this.startAt = startAt;
    return this;
  }

   /**
   * The index of the first item to return in the page of results (page offset). The base index is &#x60;0&#x60;.
   * @return startAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The index of the first item to return in the page of results (page offset). The base index is `0`.")
  @JsonProperty(JSON_PROPERTY_START_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getStartAt() {
    return startAt;
  }


  public void setStartAt(Integer startAt) {
    this.startAt = startAt;
  }


  public SearchRequestBean maxResults(Integer maxResults) {
    
    this.maxResults = maxResults;
    return this;
  }

   /**
   * The maximum number of items to return per page.
   * @return maxResults
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The maximum number of items to return per page.")
  @JsonProperty(JSON_PROPERTY_MAX_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMaxResults() {
    return maxResults;
  }


  public void setMaxResults(Integer maxResults) {
    this.maxResults = maxResults;
  }


  public SearchRequestBean fields(List<String> fields) {
    
    this.fields = fields;
    return this;
  }

  public SearchRequestBean addFieldsItem(String fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

   /**
   * A list of fields to return for each issue, use it to retrieve a subset of fields. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;*all&#x60; Returns all fields.  *  &#x60;*navigable&#x60; Returns navigable fields.  *  Any issue field, prefixed with a minus to exclude.  The default is &#x60;*navigable&#x60;.  Examples:   *  &#x60;summary,comment&#x60; Returns the summary and comments fields only.  *  &#x60;-description&#x60; Returns all navigable (default) fields except description.  *  &#x60;*all,-comment&#x60; Returns all fields except comments.  Multiple &#x60;fields&#x60; parameters can be included in a request.  Note: All navigable fields are returned by default. This differs from [GET issue](#api-rest-api-3-issue-issueIdOrKey-get) where the default is all fields.
   * @return fields
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list of fields to return for each issue, use it to retrieve a subset of fields. This parameter accepts a comma-separated list. Expand options include:   *  `*all` Returns all fields.  *  `*navigable` Returns navigable fields.  *  Any issue field, prefixed with a minus to exclude.  The default is `*navigable`.  Examples:   *  `summary,comment` Returns the summary and comments fields only.  *  `-description` Returns all navigable (default) fields except description.  *  `*all,-comment` Returns all fields except comments.  Multiple `fields` parameters can be included in a request.  Note: All navigable fields are returned by default. This differs from [GET issue](#api-rest-api-3-issue-issueIdOrKey-get) where the default is all fields.")
  @JsonProperty(JSON_PROPERTY_FIELDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getFields() {
    return fields;
  }


  public void setFields(List<String> fields) {
    this.fields = fields;
  }


  public SearchRequestBean validateQuery(ValidateQueryEnum validateQuery) {
    
    this.validateQuery = validateQuery;
    return this;
  }

   /**
   * Determines how to validate the JQL query and treat the validation results. Supported values:   *  &#x60;strict&#x60; Returns a 400 response code if any errors are found, along with a list of all errors (and warnings).  *  &#x60;warn&#x60; Returns all errors as warnings.  *  &#x60;none&#x60; No validation is performed.  *  &#x60;true&#x60; *Deprecated* A legacy synonym for &#x60;strict&#x60;.  *  &#x60;false&#x60; *Deprecated* A legacy synonym for &#x60;warn&#x60;.  The default is &#x60;strict&#x60;.  Note: If the JQL is not correctly formed a 400 response code is returned, regardless of the &#x60;validateQuery&#x60; value.
   * @return validateQuery
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines how to validate the JQL query and treat the validation results. Supported values:   *  `strict` Returns a 400 response code if any errors are found, along with a list of all errors (and warnings).  *  `warn` Returns all errors as warnings.  *  `none` No validation is performed.  *  `true` *Deprecated* A legacy synonym for `strict`.  *  `false` *Deprecated* A legacy synonym for `warn`.  The default is `strict`.  Note: If the JQL is not correctly formed a 400 response code is returned, regardless of the `validateQuery` value.")
  @JsonProperty(JSON_PROPERTY_VALIDATE_QUERY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ValidateQueryEnum getValidateQuery() {
    return validateQuery;
  }


  public void setValidateQuery(ValidateQueryEnum validateQuery) {
    this.validateQuery = validateQuery;
  }


  public SearchRequestBean expand(List<String> expand) {
    
    this.expand = expand;
    return this;
  }

  public SearchRequestBean addExpandItem(String expandItem) {
    if (this.expand == null) {
      this.expand = new ArrayList<>();
    }
    this.expand.add(expandItem);
    return this;
  }

   /**
   * Use [expand](em&gt;#expansion) to include additional information about issues in the response. Note that, unlike the majority of instances where &#x60;expand&#x60; is specified, &#x60;expand&#x60; is defined as a list of values. The expand options are:   *  &#x60;renderedFields&#x60; Returns field values rendered in HTML format.  *  &#x60;names&#x60; Returns the display name of each field.  *  &#x60;schema&#x60; Returns the schema describing a field type.  *  &#x60;transitions&#x60; Returns all possible transitions for the issue.  *  &#x60;operations&#x60; Returns all possible operations for the issue.  *  &#x60;editmeta&#x60; Returns information about how each field can be edited.  *  &#x60;changelog&#x60; Returns a list of recent updates to an issue, sorted by date, starting from the most recent.  *  &#x60;versionedRepresentations&#x60; Instead of &#x60;fields&#x60;, returns &#x60;versionedRepresentations&#x60; a JSON array containing each version of a field&#39;s value, with the highest numbered item representing the most recent version.
   * @return expand
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Use [expand](em>#expansion) to include additional information about issues in the response. Note that, unlike the majority of instances where `expand` is specified, `expand` is defined as a list of values. The expand options are:   *  `renderedFields` Returns field values rendered in HTML format.  *  `names` Returns the display name of each field.  *  `schema` Returns the schema describing a field type.  *  `transitions` Returns all possible transitions for the issue.  *  `operations` Returns all possible operations for the issue.  *  `editmeta` Returns information about how each field can be edited.  *  `changelog` Returns a list of recent updates to an issue, sorted by date, starting from the most recent.  *  `versionedRepresentations` Instead of `fields`, returns `versionedRepresentations` a JSON array containing each version of a field's value, with the highest numbered item representing the most recent version.")
  @JsonProperty(JSON_PROPERTY_EXPAND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getExpand() {
    return expand;
  }


  public void setExpand(List<String> expand) {
    this.expand = expand;
  }


  public SearchRequestBean properties(List<String> properties) {
    
    this.properties = properties;
    return this;
  }

  public SearchRequestBean addPropertiesItem(String propertiesItem) {
    if (this.properties == null) {
      this.properties = new ArrayList<>();
    }
    this.properties.add(propertiesItem);
    return this;
  }

   /**
   * A list of up to 5 issue properties to include in the results. This parameter accepts a comma-separated list.
   * @return properties
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list of up to 5 issue properties to include in the results. This parameter accepts a comma-separated list.")
  @JsonProperty(JSON_PROPERTY_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getProperties() {
    return properties;
  }


  public void setProperties(List<String> properties) {
    this.properties = properties;
  }


  public SearchRequestBean fieldsByKeys(Boolean fieldsByKeys) {
    
    this.fieldsByKeys = fieldsByKeys;
    return this;
  }

   /**
   * Reference fields by their key (rather than ID). The default is &#x60;false&#x60;.
   * @return fieldsByKeys
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Reference fields by their key (rather than ID). The default is `false`.")
  @JsonProperty(JSON_PROPERTY_FIELDS_BY_KEYS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getFieldsByKeys() {
    return fieldsByKeys;
  }


  public void setFieldsByKeys(Boolean fieldsByKeys) {
    this.fieldsByKeys = fieldsByKeys;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchRequestBean searchRequestBean = (SearchRequestBean) o;
    return Objects.equals(this.jql, searchRequestBean.jql) &&
        Objects.equals(this.startAt, searchRequestBean.startAt) &&
        Objects.equals(this.maxResults, searchRequestBean.maxResults) &&
        Objects.equals(this.fields, searchRequestBean.fields) &&
        Objects.equals(this.validateQuery, searchRequestBean.validateQuery) &&
        Objects.equals(this.expand, searchRequestBean.expand) &&
        Objects.equals(this.properties, searchRequestBean.properties) &&
        Objects.equals(this.fieldsByKeys, searchRequestBean.fieldsByKeys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jql, startAt, maxResults, fields, validateQuery, expand, properties, fieldsByKeys);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchRequestBean {\n");
    sb.append("    jql: ").append(toIndentedString(jql)).append("\n");
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    validateQuery: ").append(toIndentedString(validateQuery)).append("\n");
    sb.append("    expand: ").append(toIndentedString(expand)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    fieldsByKeys: ").append(toIndentedString(fieldsByKeys)).append("\n");
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

