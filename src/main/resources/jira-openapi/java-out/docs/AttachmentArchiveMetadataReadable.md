

# AttachmentArchiveMetadataReadable

Metadata for an archive (for example a zip) and its contents.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Long** | The ID of the attachment. |  [optional] [readonly]
**name** | **String** | The name of the archive file. |  [optional] [readonly]
**entries** | [**List&lt;AttachmentArchiveItemReadable&gt;**](AttachmentArchiveItemReadable.md) | The list of the items included in the archive. |  [optional] [readonly]
**totalEntryCount** | **Long** | The number of items included in the archive. |  [optional] [readonly]
**mediaType** | **String** | The MIME type of the attachment. |  [optional] [readonly]



