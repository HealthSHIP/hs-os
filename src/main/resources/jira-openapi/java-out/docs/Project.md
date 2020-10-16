

# Project

Details about a project.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expand** | **String** | Expand options that include additional project details in the response. |  [optional] [readonly]
**self** | [**URI**](URI.md) | The URL of the project details. |  [optional] [readonly]
**id** | **String** | The ID of the project. |  [optional]
**key** | **String** | The key of the project. |  [optional] [readonly]
**description** | **String** | A brief description of the project. |  [optional] [readonly]
**lead** | [**User**](User.md) | The username of the project lead. |  [optional] [readonly]
**components** | [**List&lt;Component&gt;**](Component.md) | List of the components contained in the project. |  [optional] [readonly]
**issueTypes** | [**List&lt;IssueTypeDetails&gt;**](IssueTypeDetails.md) | List of the issue types available in the project. |  [optional] [readonly]
**url** | **String** | A link to information about this project, such as project documentation. |  [optional] [readonly]
**email** | **String** | An email address associated with the project. |  [optional]
**assigneeType** | [**AssigneeTypeEnum**](#AssigneeTypeEnum) | The default assignee when creating issues for this project. |  [optional] [readonly]
**versions** | [**List&lt;Version&gt;**](Version.md) | The versions defined in the project. For more information, see [Create version](#api-rest-api-3-version-post). |  [optional] [readonly]
**name** | **String** | The name of the project. |  [optional] [readonly]
**roles** | [**Map&lt;String, URI&gt;**](URI.md) | The name and self URL for each role defined in the project. For more information, see [Create project role](#api-rest-api-3-role-post). |  [optional] [readonly]
**avatarUrls** | [**AvatarUrlsBean**](AvatarUrlsBean.md) | The URLs of the project&#39;s avatars. |  [optional] [readonly]
**projectCategory** | [**ProjectCategory**](ProjectCategory.md) | The contactCategory the project belongs to. |  [optional] [readonly]
**projectTypeKey** | [**ProjectTypeKeyEnum**](#ProjectTypeKeyEnum) | The [project type](https://confluence.atlassian.com/x/GwiiLQ#Jiraapplicationsoverview-Productfeaturesandprojecttypes) of the project. |  [optional] [readonly]
**simplified** | **Boolean** | Whether the project is simplified. |  [optional] [readonly]
**style** | [**StyleEnum**](#StyleEnum) | The type of the project. |  [optional] [readonly]
**favourite** | **Boolean** | Whether the project is selected as a favorite. |  [optional]
**isPrivate** | **Boolean** | Whether the project is private. |  [optional] [readonly]
**issueTypeHierarchy** | [**Hierarchy**](Hierarchy.md) | The issue type hierarchy for the project |  [optional] [readonly]
**permissions** | [**ProjectPermissions**](ProjectPermissions.md) | User permissions on the project |  [optional] [readonly]
**properties** | **Map&lt;String, Object&gt;** | Map of project properties |  [optional] [readonly]
**uuid** | [**UUID**](UUID.md) | Unique ID for next-gen projects. |  [optional] [readonly]
**insight** | [**ProjectInsight**](ProjectInsight.md) | Insights about the project. |  [optional] [readonly]
**deleted** | **Boolean** | Whether the project is marked as deleted. |  [optional] [readonly]
**retentionTillDate** | [**OffsetDateTime**](OffsetDateTime.md) | The date when the project is deleted permanently. |  [optional] [readonly]
**deletedDate** | [**OffsetDateTime**](OffsetDateTime.md) | The date when the project was marked as deleted. |  [optional] [readonly]
**deletedBy** | [**User**](User.md) | The user who marked the project as deleted. |  [optional] [readonly]
**archived** | **Boolean** | Whether the project is archived. |  [optional] [readonly]
**archivedDate** | [**OffsetDateTime**](OffsetDateTime.md) | The date when the project was archived. |  [optional] [readonly]
**archivedBy** | [**User**](User.md) | The user who archived the project. |  [optional] [readonly]



## Enum: AssigneeTypeEnum

Name | Value
---- | -----
PROJECT_LEAD | &quot;PROJECT_LEAD&quot;
UNASSIGNED | &quot;UNASSIGNED&quot;



## Enum: ProjectTypeKeyEnum

Name | Value
---- | -----
SOFTWARE | &quot;software&quot;
SERVICE_DESK | &quot;service_desk&quot;
BUSINESS | &quot;business&quot;



## Enum: StyleEnum

Name | Value
---- | -----
CLASSIC | &quot;CLASSIC&quot;
NEXTGEN | &quot;NEXTGEN&quot;
CLASSIC | &quot;classic&quot;
NEXT_GEN | &quot;next-gen&quot;



