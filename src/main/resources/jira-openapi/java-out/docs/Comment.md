

# Comment

A comment.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**self** | **String** | The URL of the comment. |  [optional] [readonly]
**id** | **String** | The ID of the comment. |  [optional] [readonly]
**author** | [**UserDetails**](UserDetails.md) | The ID of the user who created the comment. |  [optional] [readonly]
**body** | **Object** | The comment text in [Atlassian Document Format](https://developer.atlassian.com/cloud/jira/platform/apis/document/structure/). |  [optional]
**renderedBody** | **String** | The rendered version of the comment. |  [optional] [readonly]
**updateAuthor** | [**UserDetails**](UserDetails.md) | The ID of the user who updated the comment last. |  [optional] [readonly]
**created** | [**OffsetDateTime**](OffsetDateTime.md) | The date and time at which the comment was created. |  [optional] [readonly]
**updated** | [**OffsetDateTime**](OffsetDateTime.md) | The date and time at which the comment was updated last. |  [optional] [readonly]
**visibility** | [**Visibility**](Visibility.md) | The group or role to which this comment is visible. Optional on create and update. |  [optional]
**jsdPublic** | **Boolean** | Whether the comment is visible in Jira Service Desk. Defaults to true when comments are created in the Jira Cloud Platform. This includes when the site doesn&#39;t use Jira Service Desk or the project isn&#39;t a Jira Service Desk project and, therefore, there is no Jira Service Desk for the issue to be visible on. To create a comment with its visibility in Jira Service Desk set to false, use the Jira Service Desk REST API [Create request comment](https://developer.atlassian.com/cloud/jira/service-desk/rest/#api-rest-servicedeskapi-request-issueIdOrKey-comment-post) operation. |  [optional] [readonly]
**properties** | [**List&lt;EntityProperty&gt;**](EntityProperty.md) | A list of comment properties. Optional on create and update. |  [optional]



