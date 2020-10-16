

# JiraExpressionValidationError

Details about a syntax error.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**line** | **Integer** | The text line in which the error occurred. If absent, the error pertains to the entire expression. |  [optional]
**column** | **Integer** | The text column in which the error occurred. If absent, the error pertains to the entire expression. |  [optional]
**message** | **String** | The detailed message about the error. | 
**type** | [**TypeEnum**](#TypeEnum) | The error type. | 



## Enum: TypeEnum

Name | Value
---- | -----
SYNTAX | &quot;syntax&quot;
OTHER | &quot;other&quot;



