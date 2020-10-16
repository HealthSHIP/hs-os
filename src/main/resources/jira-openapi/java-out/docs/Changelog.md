

# Changelog

A changelog.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The ID of the changelog. |  [optional] [readonly]
**author** | [**UserDetails**](UserDetails.md) | The user who made the change. |  [optional] [readonly]
**created** | [**OffsetDateTime**](OffsetDateTime.md) | The date on which the change took place. |  [optional] [readonly]
**items** | [**List&lt;ChangeDetails&gt;**](ChangeDetails.md) | The list of items changed. |  [optional] [readonly]
**historyMetadata** | [**HistoryMetadata**](HistoryMetadata.md) | The history metadata associated with the changed. |  [optional] [readonly]



