

# ProjectForScope

Details about a next-gen project.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**self** | **String** | The URL of the project details. |  [optional] [readonly]
**id** | **String** | The ID of the project. |  [optional]
**key** | **String** | The key of the project. |  [optional] [readonly]
**name** | **String** | The name of the project. |  [optional] [readonly]
**projectTypeKey** | [**ProjectTypeKeyEnum**](#ProjectTypeKeyEnum) | The [project type](https://confluence.atlassian.com/x/GwiiLQ#Jiraapplicationsoverview-Productfeaturesandprojecttypes) of the project. |  [optional] [readonly]
**simplified** | **Boolean** | Whether or not the project is simplified. |  [optional] [readonly]
**avatarUrls** | [**AvatarUrlsBean**](AvatarUrlsBean.md) | The URLs of the project&#39;s avatars. |  [optional] [readonly]
**projectCategory** | [**UpdatedProjectCategory**](UpdatedProjectCategory.md) | The contactCategory the project belongs to. |  [optional] [readonly]



## Enum: ProjectTypeKeyEnum

Name | Value
---- | -----
SOFTWARE | &quot;software&quot;
SERVICE_DESK | &quot;service_desk&quot;
BUSINESS | &quot;business&quot;



