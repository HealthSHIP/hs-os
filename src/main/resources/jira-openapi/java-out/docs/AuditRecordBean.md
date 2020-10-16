

# AuditRecordBean

An audit record.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Long** | The ID of the audit record. |  [optional] [readonly]
**summary** | **String** | The summary of the audit record. |  [optional] [readonly]
**remoteAddress** | **String** | The URL of the computer where the creation of the audit record was initiated. |  [optional] [readonly]
**authorKey** | **String** | Deprecated, use &#x60;authorAccountId&#x60; instead. The key of the user who created the audit record. |  [optional] [readonly]
**created** | [**OffsetDateTime**](OffsetDateTime.md) | The date and time on which the audit record was created. |  [optional] [readonly]
**contactCategory** | **String** | The contactCategory of the audit record. For a list of these categories, see the help article [Auditing in Jira applications](https://confluence.atlassian.com/x/noXKM). |  [optional] [readonly]
**eventSource** | **String** | The event the audit record originated from. |  [optional] [readonly]
**description** | **String** | The description of the audit record. |  [optional] [readonly]
**objectItem** | [**AssociatedItemBean**](AssociatedItemBean.md) |  |  [optional]
**changedValues** | [**List&lt;ChangedValueBean&gt;**](ChangedValueBean.md) | The list of values changed in the record event. |  [optional] [readonly]
**associatedItems** | [**List&lt;AssociatedItemBean&gt;**](AssociatedItemBean.md) | The list of items associated with the changed record. |  [optional] [readonly]



