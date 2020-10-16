

# ParsedJqlQuery

Details of a parsed JQL query.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**query** | **String** | The JQL query that was parsed and validated. | 
**structure** | [**JqlQuery**](JqlQuery.md) | The syntax tree of the query. Empty if the query was invalid. |  [optional]
**errors** | **List&lt;String&gt;** | The list of syntax or validation errors. |  [optional]



