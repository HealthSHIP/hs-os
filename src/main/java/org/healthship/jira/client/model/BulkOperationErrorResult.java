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
 * BulkOperationErrorResult
 */
@JsonPropertyOrder({
  BulkOperationErrorResult.JSON_PROPERTY_STATUS,
  BulkOperationErrorResult.JSON_PROPERTY_ELEMENT_ERRORS,
  BulkOperationErrorResult.JSON_PROPERTY_FAILED_ELEMENT_NUMBER
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class BulkOperationErrorResult {
  public static final String JSON_PROPERTY_STATUS = "status";
  private Integer status;

  public static final String JSON_PROPERTY_ELEMENT_ERRORS = "elementErrors";
  private ErrorCollection elementErrors;

  public static final String JSON_PROPERTY_FAILED_ELEMENT_NUMBER = "failedElementNumber";
  private Integer failedElementNumber;


  public BulkOperationErrorResult status(Integer status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getStatus() {
    return status;
  }


  public void setStatus(Integer status) {
    this.status = status;
  }


  public BulkOperationErrorResult elementErrors(ErrorCollection elementErrors) {
    
    this.elementErrors = elementErrors;
    return this;
  }

   /**
   * Get elementErrors
   * @return elementErrors
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ELEMENT_ERRORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ErrorCollection getElementErrors() {
    return elementErrors;
  }


  public void setElementErrors(ErrorCollection elementErrors) {
    this.elementErrors = elementErrors;
  }


  public BulkOperationErrorResult failedElementNumber(Integer failedElementNumber) {
    
    this.failedElementNumber = failedElementNumber;
    return this;
  }

   /**
   * Get failedElementNumber
   * @return failedElementNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FAILED_ELEMENT_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getFailedElementNumber() {
    return failedElementNumber;
  }


  public void setFailedElementNumber(Integer failedElementNumber) {
    this.failedElementNumber = failedElementNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkOperationErrorResult bulkOperationErrorResult = (BulkOperationErrorResult) o;
    return Objects.equals(this.status, bulkOperationErrorResult.status) &&
        Objects.equals(this.elementErrors, bulkOperationErrorResult.elementErrors) &&
        Objects.equals(this.failedElementNumber, bulkOperationErrorResult.failedElementNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, elementErrors, failedElementNumber);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkOperationErrorResult {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    elementErrors: ").append(toIndentedString(elementErrors)).append("\n");
    sb.append("    failedElementNumber: ").append(toIndentedString(failedElementNumber)).append("\n");
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

