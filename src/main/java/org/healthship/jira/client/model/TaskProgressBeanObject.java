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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.net.URI;
import java.util.Objects;

/**
 * Details about a task.
 */
@ApiModel(description = "Details about a task.")
@JsonPropertyOrder({
  TaskProgressBeanObject.JSON_PROPERTY_SELF,
  TaskProgressBeanObject.JSON_PROPERTY_ID,
  TaskProgressBeanObject.JSON_PROPERTY_DESCRIPTION,
  TaskProgressBeanObject.JSON_PROPERTY_STATUS,
  TaskProgressBeanObject.JSON_PROPERTY_MESSAGE,
  TaskProgressBeanObject.JSON_PROPERTY_RESULT,
  TaskProgressBeanObject.JSON_PROPERTY_SUBMITTED_BY,
  TaskProgressBeanObject.JSON_PROPERTY_PROGRESS,
  TaskProgressBeanObject.JSON_PROPERTY_ELAPSED_RUNTIME,
  TaskProgressBeanObject.JSON_PROPERTY_SUBMITTED,
  TaskProgressBeanObject.JSON_PROPERTY_STARTED,
  TaskProgressBeanObject.JSON_PROPERTY_FINISHED,
  TaskProgressBeanObject.JSON_PROPERTY_LAST_UPDATE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class TaskProgressBeanObject {
  public static final String JSON_PROPERTY_SELF = "self";
  private URI self;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  /**
   * The status of the task.
   */
  public enum StatusEnum {
    ENQUEUED("ENQUEUED"),
    
    RUNNING("RUNNING"),
    
    COMPLETE("COMPLETE"),
    
    FAILED("FAILED"),
    
    CANCEL_REQUESTED("CANCEL_REQUESTED"),
    
    CANCELLED("CANCELLED"),
    
    DEAD("DEAD");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  private StatusEnum status;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  private String message;

  public static final String JSON_PROPERTY_RESULT = "result";
  private Object result = null;

  public static final String JSON_PROPERTY_SUBMITTED_BY = "submittedBy";
  private Long submittedBy;

  public static final String JSON_PROPERTY_PROGRESS = "progress";
  private Long progress;

  public static final String JSON_PROPERTY_ELAPSED_RUNTIME = "elapsedRuntime";
  private Long elapsedRuntime;

  public static final String JSON_PROPERTY_SUBMITTED = "submitted";
  private Long submitted;

  public static final String JSON_PROPERTY_STARTED = "started";
  private Long started;

  public static final String JSON_PROPERTY_FINISHED = "finished";
  private Long finished;

  public static final String JSON_PROPERTY_LAST_UPDATE = "lastUpdate";
  private Long lastUpdate;


  public TaskProgressBeanObject self(URI self) {
    
    this.self = self;
    return this;
  }

   /**
   * The URL of the task.
   * @return self
  **/
  @ApiModelProperty(required = true, value = "The URL of the task.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public URI getSelf() {
    return self;
  }


  public void setSelf(URI self) {
    this.self = self;
  }


  public TaskProgressBeanObject id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * The ID of the task.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the task.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public TaskProgressBeanObject description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * The description of the task.
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description of the task.")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public TaskProgressBeanObject status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * The status of the task.
   * @return status
  **/
  @ApiModelProperty(required = true, value = "The status of the task.")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  public TaskProgressBeanObject message(String message) {
    
    this.message = message;
    return this;
  }

   /**
   * Information about the progress of the task.
   * @return message
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Information about the progress of the task.")
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMessage() {
    return message;
  }


  public void setMessage(String message) {
    this.message = message;
  }


  public TaskProgressBeanObject result(Object result) {
    
    this.result = result;
    return this;
  }

   /**
   * The result of the task execution.
   * @return result
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The result of the task execution.")
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getResult() {
    return result;
  }


  public void setResult(Object result) {
    this.result = result;
  }


  public TaskProgressBeanObject submittedBy(Long submittedBy) {
    
    this.submittedBy = submittedBy;
    return this;
  }

   /**
   * The ID of the user who submitted the task.
   * @return submittedBy
  **/
  @ApiModelProperty(required = true, value = "The ID of the user who submitted the task.")
  @JsonProperty(JSON_PROPERTY_SUBMITTED_BY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getSubmittedBy() {
    return submittedBy;
  }


  public void setSubmittedBy(Long submittedBy) {
    this.submittedBy = submittedBy;
  }


  public TaskProgressBeanObject progress(Long progress) {
    
    this.progress = progress;
    return this;
  }

   /**
   * The progress of the task, as a percentage complete.
   * @return progress
  **/
  @ApiModelProperty(required = true, value = "The progress of the task, as a percentage complete.")
  @JsonProperty(JSON_PROPERTY_PROGRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getProgress() {
    return progress;
  }


  public void setProgress(Long progress) {
    this.progress = progress;
  }


  public TaskProgressBeanObject elapsedRuntime(Long elapsedRuntime) {
    
    this.elapsedRuntime = elapsedRuntime;
    return this;
  }

   /**
   * The execution time of the task, in milliseconds.
   * @return elapsedRuntime
  **/
  @ApiModelProperty(required = true, value = "The execution time of the task, in milliseconds.")
  @JsonProperty(JSON_PROPERTY_ELAPSED_RUNTIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getElapsedRuntime() {
    return elapsedRuntime;
  }


  public void setElapsedRuntime(Long elapsedRuntime) {
    this.elapsedRuntime = elapsedRuntime;
  }


  public TaskProgressBeanObject submitted(Long submitted) {
    
    this.submitted = submitted;
    return this;
  }

   /**
   * A timestamp recording when the task was submitted.
   * @return submitted
  **/
  @ApiModelProperty(required = true, value = "A timestamp recording when the task was submitted.")
  @JsonProperty(JSON_PROPERTY_SUBMITTED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getSubmitted() {
    return submitted;
  }


  public void setSubmitted(Long submitted) {
    this.submitted = submitted;
  }


  public TaskProgressBeanObject started(Long started) {
    
    this.started = started;
    return this;
  }

   /**
   * A timestamp recording when the task was started.
   * @return started
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A timestamp recording when the task was started.")
  @JsonProperty(JSON_PROPERTY_STARTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getStarted() {
    return started;
  }


  public void setStarted(Long started) {
    this.started = started;
  }


  public TaskProgressBeanObject finished(Long finished) {
    
    this.finished = finished;
    return this;
  }

   /**
   * A timestamp recording when the task was finished.
   * @return finished
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A timestamp recording when the task was finished.")
  @JsonProperty(JSON_PROPERTY_FINISHED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getFinished() {
    return finished;
  }


  public void setFinished(Long finished) {
    this.finished = finished;
  }


  public TaskProgressBeanObject lastUpdate(Long lastUpdate) {
    
    this.lastUpdate = lastUpdate;
    return this;
  }

   /**
   * A timestamp recording when the task progress was last updated.
   * @return lastUpdate
  **/
  @ApiModelProperty(required = true, value = "A timestamp recording when the task progress was last updated.")
  @JsonProperty(JSON_PROPERTY_LAST_UPDATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getLastUpdate() {
    return lastUpdate;
  }


  public void setLastUpdate(Long lastUpdate) {
    this.lastUpdate = lastUpdate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskProgressBeanObject taskProgressBeanObject = (TaskProgressBeanObject) o;
    return Objects.equals(this.self, taskProgressBeanObject.self) &&
        Objects.equals(this.id, taskProgressBeanObject.id) &&
        Objects.equals(this.description, taskProgressBeanObject.description) &&
        Objects.equals(this.status, taskProgressBeanObject.status) &&
        Objects.equals(this.message, taskProgressBeanObject.message) &&
        Objects.equals(this.result, taskProgressBeanObject.result) &&
        Objects.equals(this.submittedBy, taskProgressBeanObject.submittedBy) &&
        Objects.equals(this.progress, taskProgressBeanObject.progress) &&
        Objects.equals(this.elapsedRuntime, taskProgressBeanObject.elapsedRuntime) &&
        Objects.equals(this.submitted, taskProgressBeanObject.submitted) &&
        Objects.equals(this.started, taskProgressBeanObject.started) &&
        Objects.equals(this.finished, taskProgressBeanObject.finished) &&
        Objects.equals(this.lastUpdate, taskProgressBeanObject.lastUpdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, id, description, status, message, result, submittedBy, progress, elapsedRuntime, submitted, started, finished, lastUpdate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskProgressBeanObject {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    submittedBy: ").append(toIndentedString(submittedBy)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    elapsedRuntime: ").append(toIndentedString(elapsedRuntime)).append("\n");
    sb.append("    submitted: ").append(toIndentedString(submitted)).append("\n");
    sb.append("    started: ").append(toIndentedString(started)).append("\n");
    sb.append("    finished: ").append(toIndentedString(finished)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
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

