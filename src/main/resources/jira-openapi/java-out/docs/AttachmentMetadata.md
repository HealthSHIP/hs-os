

# AttachmentMetadata

Metadata for an issue attachment.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Long** | The ID of the attachment. |  [optional] [readonly]
**self** | [**URI**](URI.md) | The URL of the attachment metadata details. |  [optional] [readonly]
**filename** | **String** | The name of the attachment file. |  [optional] [readonly]
**author** | [**User**](User.md) | Details of the user who attached the file. |  [optional] [readonly]
**created** | [**OffsetDateTime**](OffsetDateTime.md) | The datetime the attachment was created. |  [optional] [readonly]
**size** | **Long** | The size of the attachment. |  [optional] [readonly]
**mimeType** | **String** | The MIME type of the attachment. |  [optional] [readonly]
**properties** | **Map&lt;String, Object&gt;** | Additional properties of the attachment. |  [optional] [readonly]
**content** | **String** | The URL of the attachment. |  [optional] [readonly]
**thumbnail** | **String** | The URL of a thumbnail representing the attachment. |  [optional] [readonly]



