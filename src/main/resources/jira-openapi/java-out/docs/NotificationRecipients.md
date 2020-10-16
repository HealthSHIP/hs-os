

# NotificationRecipients

Details of the users and groups to receive the notification.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**reporter** | **Boolean** | Whether the notification should be sent to the issue&#39;s reporter. |  [optional]
**assignee** | **Boolean** | Whether the notification should be sent to the issue&#39;s assignees. |  [optional]
**watchers** | **Boolean** | Whether the notification should be sent to the issue&#39;s watchers. |  [optional]
**voters** | **Boolean** | Whether the notification should be sent to the issue&#39;s voters. |  [optional]
**users** | [**List&lt;UserDetails&gt;**](UserDetails.md) | List of users to receive the notification. |  [optional]
**groups** | [**List&lt;GroupName&gt;**](GroupName.md) | List of groups to receive the notification. |  [optional]



