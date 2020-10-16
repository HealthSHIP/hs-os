

# FieldMetadata

The metadata describing an issue field.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**required** | **Boolean** | Whether the field is required. |  [readonly]
**schema** | [**JsonTypeBean**](JsonTypeBean.md) | The data type of the field. |  [optional] [readonly]
**name** | **String** | The name of the field. |  [readonly]
**key** | **String** | The key of the field. |  [readonly]
**autoCompleteUrl** | **String** | The URL that can be used to automatically complete the field. |  [optional] [readonly]
**hasDefaultValue** | **Boolean** | Whether the field has a default value. |  [optional] [readonly]
**operations** | **List&lt;String&gt;** | The list of operations that can be performed on the field. |  [readonly]
**allowedValues** | **List&lt;Object&gt;** | The list of values allowed in the field. |  [optional] [readonly]
**defaultValue** | **Object** | The default value of the field. |  [optional] [readonly]



