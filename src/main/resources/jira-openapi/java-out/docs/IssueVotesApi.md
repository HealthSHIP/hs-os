# IssueVotesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueIssueResourceAddVotePost**](IssueVotesApi.md#comAtlassianJiraRestV2IssueIssueResourceAddVotePost) | **POST** /rest/api/3/issue/{issueIdOrKey}/votes | Add vote
[**comAtlassianJiraRestV2IssueIssueResourceGetVotesGet**](IssueVotesApi.md#comAtlassianJiraRestV2IssueIssueResourceGetVotesGet) | **GET** /rest/api/3/issue/{issueIdOrKey}/votes | Get votes
[**comAtlassianJiraRestV2IssueIssueResourceRemoveVoteDelete**](IssueVotesApi.md#comAtlassianJiraRestV2IssueIssueResourceRemoveVoteDelete) | **DELETE** /rest/api/3/issue/{issueIdOrKey}/votes | Delete vote



## comAtlassianJiraRestV2IssueIssueResourceAddVotePost

> Object comAtlassianJiraRestV2IssueIssueResourceAddVotePost(issueIdOrKey)

Add vote

Adds the user&#39;s vote to an issue. This is the equivalent of the user clicking *Vote* on an issue in Jira.  This operation requires the **Allow users to vote on issues** option to be *ON*. This option is set in General configuration for Jira. See [Configuring Jira application options](https://confluence.atlassian.com/x/uYXKM) for details.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueVotesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueVotesApi apiInstance = new IssueVotesApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueIssueResourceAddVotePost(issueIdOrKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueVotesApi#comAtlassianJiraRestV2IssueIssueResourceAddVotePost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **issueIdOrKey** | **String**| The ID or key of the issue. |

### Return type

**Object**

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  voting is disabled.  *  the user is the issue reporter.  *  the issue is not found. |  -  |


## comAtlassianJiraRestV2IssueIssueResourceGetVotesGet

> Votes comAtlassianJiraRestV2IssueIssueResourceGetVotesGet(issueIdOrKey)

Get votes

Returns details about the votes on an issue.  This operation requires the **Allow users to vote on issues** option to be *ON*. This option is set in General configuration for Jira. See [Configuring Jira application options](https://confluence.atlassian.com/x/uYXKM) for details.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is ini  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  Note that users with the necessary permissions for this operation but without the *View voters and watchers* project permissions are not returned details in the &#x60;voters&#x60; field.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueVotesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueVotesApi apiInstance = new IssueVotesApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        try {
            Votes result = apiInstance.comAtlassianJiraRestV2IssueIssueResourceGetVotesGet(issueIdOrKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueVotesApi#comAtlassianJiraRestV2IssueIssueResourceGetVotesGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **issueIdOrKey** | **String**| The ID or key of the issue. |

### Return type

[**Votes**](Votes.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  voting is disabled.  *  the user does not have permission to view the issue.  *  the issue is not found. |  -  |


## comAtlassianJiraRestV2IssueIssueResourceRemoveVoteDelete

> comAtlassianJiraRestV2IssueIssueResourceRemoveVoteDelete(issueIdOrKey)

Delete vote

Deletes a user&#39;s vote from an issue. This is the equivalent of the user clicking *Unvote* on an issue in Jira.  This operation requires the **Allow users to vote on issues** option to be *ON*. This option is set in General configuration for Jira. See [Configuring Jira application options](https://confluence.atlassian.com/x/uYXKM) for details.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueVotesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueVotesApi apiInstance = new IssueVotesApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        try {
            apiInstance.comAtlassianJiraRestV2IssueIssueResourceRemoveVoteDelete(issueIdOrKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueVotesApi#comAtlassianJiraRestV2IssueIssueResourceRemoveVoteDelete");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **issueIdOrKey** | **String**| The ID or key of the issue. |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  voting is disabled.  *  the user has not voted on the issue.  *  the user is the issue reporter.  *  the issue is not found. |  -  |

