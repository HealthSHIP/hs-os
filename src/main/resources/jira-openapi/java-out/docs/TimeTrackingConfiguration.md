

# TimeTrackingConfiguration

Details of the time tracking configuration.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**workingHoursPerDay** | **Double** | The number of hours in a working day. | 
**workingDaysPerWeek** | **Double** | The number of days in a working week. | 
**timeFormat** | [**TimeFormatEnum**](#TimeFormatEnum) | The format that will appear on an issue&#39;s *Time Spent* field. | 
**defaultUnit** | [**DefaultUnitEnum**](#DefaultUnitEnum) | The default unit of time applied to logged time. | 



## Enum: TimeFormatEnum

Name | Value
---- | -----
PRETTY | &quot;pretty&quot;
DAYS | &quot;days&quot;
HOURS | &quot;hours&quot;



## Enum: DefaultUnitEnum

Name | Value
---- | -----
MINUTE | &quot;minute&quot;
HOUR | &quot;hour&quot;
DAY | &quot;day&quot;
WEEK | &quot;week&quot;



