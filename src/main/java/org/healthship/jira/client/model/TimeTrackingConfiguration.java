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

import java.util.Objects;

/**
 * Details of the time tracking configuration.
 */
@ApiModel(description = "Details of the time tracking configuration.")
@JsonPropertyOrder({
  TimeTrackingConfiguration.JSON_PROPERTY_WORKING_HOURS_PER_DAY,
  TimeTrackingConfiguration.JSON_PROPERTY_WORKING_DAYS_PER_WEEK,
  TimeTrackingConfiguration.JSON_PROPERTY_TIME_FORMAT,
  TimeTrackingConfiguration.JSON_PROPERTY_DEFAULT_UNIT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class TimeTrackingConfiguration {
  public static final String JSON_PROPERTY_WORKING_HOURS_PER_DAY = "workingHoursPerDay";
  private Double workingHoursPerDay;

  public static final String JSON_PROPERTY_WORKING_DAYS_PER_WEEK = "workingDaysPerWeek";
  private Double workingDaysPerWeek;

  /**
   * The format that will appear on an issue&#39;s *Time Spent* field.
   */
  public enum TimeFormatEnum {
    PRETTY("pretty"),
    
    DAYS("days"),
    
    HOURS("hours");

    private String value;

    TimeFormatEnum(String value) {
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
    public static TimeFormatEnum fromValue(String value) {
      for (TimeFormatEnum b : TimeFormatEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TIME_FORMAT = "timeFormat";
  private TimeFormatEnum timeFormat;

  /**
   * The default unit of time applied to logged time.
   */
  public enum DefaultUnitEnum {
    MINUTE("minute"),
    
    HOUR("hour"),
    
    DAY("day"),
    
    WEEK("week");

    private String value;

    DefaultUnitEnum(String value) {
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
    public static DefaultUnitEnum fromValue(String value) {
      for (DefaultUnitEnum b : DefaultUnitEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_DEFAULT_UNIT = "defaultUnit";
  private DefaultUnitEnum defaultUnit;


  public TimeTrackingConfiguration workingHoursPerDay(Double workingHoursPerDay) {
    
    this.workingHoursPerDay = workingHoursPerDay;
    return this;
  }

   /**
   * The number of hours in a working day.
   * @return workingHoursPerDay
  **/
  @ApiModelProperty(required = true, value = "The number of hours in a working day.")
  @JsonProperty(JSON_PROPERTY_WORKING_HOURS_PER_DAY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Double getWorkingHoursPerDay() {
    return workingHoursPerDay;
  }


  public void setWorkingHoursPerDay(Double workingHoursPerDay) {
    this.workingHoursPerDay = workingHoursPerDay;
  }


  public TimeTrackingConfiguration workingDaysPerWeek(Double workingDaysPerWeek) {
    
    this.workingDaysPerWeek = workingDaysPerWeek;
    return this;
  }

   /**
   * The number of days in a working week.
   * @return workingDaysPerWeek
  **/
  @ApiModelProperty(required = true, value = "The number of days in a working week.")
  @JsonProperty(JSON_PROPERTY_WORKING_DAYS_PER_WEEK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Double getWorkingDaysPerWeek() {
    return workingDaysPerWeek;
  }


  public void setWorkingDaysPerWeek(Double workingDaysPerWeek) {
    this.workingDaysPerWeek = workingDaysPerWeek;
  }


  public TimeTrackingConfiguration timeFormat(TimeFormatEnum timeFormat) {
    
    this.timeFormat = timeFormat;
    return this;
  }

   /**
   * The format that will appear on an issue&#39;s *Time Spent* field.
   * @return timeFormat
  **/
  @ApiModelProperty(required = true, value = "The format that will appear on an issue's *Time Spent* field.")
  @JsonProperty(JSON_PROPERTY_TIME_FORMAT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TimeFormatEnum getTimeFormat() {
    return timeFormat;
  }


  public void setTimeFormat(TimeFormatEnum timeFormat) {
    this.timeFormat = timeFormat;
  }


  public TimeTrackingConfiguration defaultUnit(DefaultUnitEnum defaultUnit) {
    
    this.defaultUnit = defaultUnit;
    return this;
  }

   /**
   * The default unit of time applied to logged time.
   * @return defaultUnit
  **/
  @ApiModelProperty(required = true, value = "The default unit of time applied to logged time.")
  @JsonProperty(JSON_PROPERTY_DEFAULT_UNIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DefaultUnitEnum getDefaultUnit() {
    return defaultUnit;
  }


  public void setDefaultUnit(DefaultUnitEnum defaultUnit) {
    this.defaultUnit = defaultUnit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeTrackingConfiguration timeTrackingConfiguration = (TimeTrackingConfiguration) o;
    return Objects.equals(this.workingHoursPerDay, timeTrackingConfiguration.workingHoursPerDay) &&
        Objects.equals(this.workingDaysPerWeek, timeTrackingConfiguration.workingDaysPerWeek) &&
        Objects.equals(this.timeFormat, timeTrackingConfiguration.timeFormat) &&
        Objects.equals(this.defaultUnit, timeTrackingConfiguration.defaultUnit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workingHoursPerDay, workingDaysPerWeek, timeFormat, defaultUnit);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeTrackingConfiguration {\n");
    sb.append("    workingHoursPerDay: ").append(toIndentedString(workingHoursPerDay)).append("\n");
    sb.append("    workingDaysPerWeek: ").append(toIndentedString(workingDaysPerWeek)).append("\n");
    sb.append("    timeFormat: ").append(toIndentedString(timeFormat)).append("\n");
    sb.append("    defaultUnit: ").append(toIndentedString(defaultUnit)).append("\n");
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

