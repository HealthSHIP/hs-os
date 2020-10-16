

# IssueTypeIssueCreateMetadata

Details of the issue creation metadata for an issue type.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**self** | **String** | The URL of these issue type details. |  [optional] [readonly]
**id** | **String** | The ID of the issue type. |  [optional] [readonly]
**description** | **String** | The description of the issue type. |  [optional] [readonly]
**iconUrl** | **String** | The URL of the issue type&#39;s avatar. |  [optional] [readonly]
**name** | **String** | The name of the issue type. |  [optional] [readonly]
**subtask** | **Boolean** | Whether this issue type is used to create subtasks. |  [optional] [readonly]
**avatarId** | **Long** | The ID of the issue type&#39;s avatar. |  [optional] [readonly]
**entityId** | [**UUID**](UUID.md) | Unique ID for next-gen projects. |  [optional] [readonly]
**scope** | [**Scope**](Scope.md) | Details of the next-gen projects the issue type is available in. |  [optional] [readonly]
**expand** | **String** | Expand options that include additional issue type metadata details in the response. |  [optional] [readonly]
**fields** | [**Map&lt;String, FieldMetadata&gt;**](FieldMetadata.md) | List of the fields available when creating an issue for the issue type. |  [optional] [readonly]



