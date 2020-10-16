# IssueRemoteLinksApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueIssueResourceCreateOrUpdateRemoteIssueLinkPost**](IssueRemoteLinksApi.md#comAtlassianJiraRestV2IssueIssueResourceCreateOrUpdateRemoteIssueLinkPost) | **POST** /rest/api/3/issue/{issueIdOrKey}/remotelink | Create or update remote issue link
[**comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByGlobalIdDelete**](IssueRemoteLinksApi.md#comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByGlobalIdDelete) | **DELETE** /rest/api/3/issue/{issueIdOrKey}/remotelink | Delete remote issue link by global ID
[**comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByIdDelete**](IssueRemoteLinksApi.md#comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByIdDelete) | **DELETE** /rest/api/3/issue/{issueIdOrKey}/remotelink/{linkId} | Delete remote issue link by ID
[**comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinkByIdGet**](IssueRemoteLinksApi.md#comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinkByIdGet) | **GET** /rest/api/3/issue/{issueIdOrKey}/remotelink/{linkId} | Get remote issue link by ID
[**comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinksGet**](IssueRemoteLinksApi.md#comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinksGet) | **GET** /rest/api/3/issue/{issueIdOrKey}/remotelink | Get remote issue links
[**comAtlassianJiraRestV2IssueIssueResourceUpdateRemoteIssueLinkPut**](IssueRemoteLinksApi.md#comAtlassianJiraRestV2IssueIssueResourceUpdateRemoteIssueLinkPut) | **PUT** /rest/api/3/issue/{issueIdOrKey}/remotelink/{linkId} | Update remote issue link by ID



## comAtlassianJiraRestV2IssueIssueResourceCreateOrUpdateRemoteIssueLinkPost

> RemoteIssueLinkIdentifies comAtlassianJiraRestV2IssueIssueResourceCreateOrUpdateRemoteIssueLinkPost(issueIdOrKey, requestBody)

Create or update remote issue link

Creates or updates a remote issue link for an issue.  If a &#x60;globalId&#x60; is provided and a remote issue link with that global ID is found it is updated. Any fields without values in the request are set to null. Otherwise, the remote issue link is created.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueRemoteLinksApi;

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

        IssueRemoteLinksApi apiInstance = new IssueRemoteLinksApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        Map<String, Object> requestBody = {"application":{"name":"My Acme Tracker","type":"com.acme.tracker"},"globalId":"system=http://www.mycompany.com/support&id=1","relationship":"causes","object":{"summary":"Customer support issue","icon":{"url16x16":"http://www.mycompany.com/support/ticket.png","title":"Support Ticket"},"title":"TSTSUP-111","url":"http://www.mycompany.com/support?id=1","status":{"icon":{"url16x16":"http://www.mycompany.com/support/resolved.png","link":"http://www.mycompany.com/support?id=1&details=closed","title":"Case Closed"},"resolved":true}}}; // Map<String, Object> | 
        try {
            RemoteIssueLinkIdentifies result = apiInstance.comAtlassianJiraRestV2IssueIssueResourceCreateOrUpdateRemoteIssueLinkPost(issueIdOrKey, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueRemoteLinksApi#comAtlassianJiraRestV2IssueIssueResourceCreateOrUpdateRemoteIssueLinkPost");
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
 **requestBody** | [**Map&lt;String, Object&gt;**](Object.md)|  |

### Return type

[**RemoteIssueLinkIdentifies**](RemoteIssueLinkIdentifies.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the remote issue link is updated. |  -  |
| **201** | Returned if the remote issue link is created. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to link issues. |  -  |
| **404** | Returned if the issue is not found or the user does not have permission to view the issue. |  -  |


## comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByGlobalIdDelete

> comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByGlobalIdDelete(issueIdOrKey, globalId)

Delete remote issue link by global ID

Deletes the remote issue link from the issue using the link&#39;s global ID. Where the global ID includes reserved URL characters these must be escaped in the request. For example, pass &#x60;system&#x3D;http://www.mycompany.com/support&amp;id&#x3D;1&#x60; as &#x60;system%3Dhttp%3A%2F%2Fwww.mycompany.com%2Fsupport%26id%3D1&#x60;.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is implemented, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueRemoteLinksApi;

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

        IssueRemoteLinksApi apiInstance = new IssueRemoteLinksApi(defaultClient);
        String issueIdOrKey = 10000; // String | The ID or key of the issue.
        String globalId = system=http://www.mycompany.com/support&id=1; // String | The global ID of a remote issue link.
        try {
            apiInstance.comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByGlobalIdDelete(issueIdOrKey, globalId);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueRemoteLinksApi#comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByGlobalIdDelete");
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
 **globalId** | **String**| The global ID of a remote issue link. |

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
| **400** | Returned if a global ID isn&#39;t provided. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to link issues. |  -  |
| **404** | Returned if the issue or remote issue link is not found or the user does not have permission to view the issue. |  -  |


## comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByIdDelete

> comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByIdDelete(issueIdOrKey, linkId)

Delete remote issue link by ID

Deletes a remote issue link from an issue.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects*, *Edit issues*, and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueRemoteLinksApi;

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

        IssueRemoteLinksApi apiInstance = new IssueRemoteLinksApi(defaultClient);
        String issueIdOrKey = 10000; // String | The ID or key of the issue.
        String linkId = 10000; // String | The ID of a remote issue link.
        try {
            apiInstance.comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByIdDelete(issueIdOrKey, linkId);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueRemoteLinksApi#comAtlassianJiraRestV2IssueIssueResourceDeleteRemoteIssueLinkByIdDelete");
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
 **linkId** | **String**| The ID of a remote issue link. |

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
| **400** | Returned if the link ID is invalid or the remote issue link does not belong to the issue. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to link issues. |  -  |
| **404** | Returned if the issue or remote issue link is not found or the user does not have permission to view the issue. |  -  |


## comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinkByIdGet

> RemoteIssueLink comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinkByIdGet(issueIdOrKey, linkId)

Get remote issue link by ID

Returns a remote issue link for an issue.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueRemoteLinksApi;

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

        IssueRemoteLinksApi apiInstance = new IssueRemoteLinksApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        String linkId = "linkId_example"; // String | The ID of the remote issue link.
        try {
            RemoteIssueLink result = apiInstance.comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinkByIdGet(issueIdOrKey, linkId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueRemoteLinksApi#comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinkByIdGet");
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
 **linkId** | **String**| The ID of the remote issue link. |

### Return type

[**RemoteIssueLink**](RemoteIssueLink.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the link ID is invalid or the remote issue link does not belong to the issue. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if issue linking is disabled. |  -  |
| **404** | Returned if the issue or remote issue link is not found or the user does not have permission to view the issue. |  -  |


## comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinksGet

> RemoteIssueLink comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinksGet(issueIdOrKey, globalId)

Get remote issue links

Returns the remote issue links for an issue. When a remote issue link global ID is provided the record with that global ID is returned, otherwise all remote issue links are returned. Where a global ID includes reserved URL characters these must be escaped in the request. For example, pass &#x60;system&#x3D;http://www.mycompany.com/support&amp;id&#x3D;1&#x60; as &#x60;system%3Dhttp%3A%2F%2Fwww.mycompany.com%2Fsupport%26id%3D1&#x60;.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueRemoteLinksApi;

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

        IssueRemoteLinksApi apiInstance = new IssueRemoteLinksApi(defaultClient);
        String issueIdOrKey = 10000; // String | The ID or key of the issue.
        String globalId = "globalId_example"; // String | The global ID of the remote issue link.
        try {
            RemoteIssueLink result = apiInstance.comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinksGet(issueIdOrKey, globalId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueRemoteLinksApi#comAtlassianJiraRestV2IssueIssueResourceGetRemoteIssueLinksGet");
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
 **globalId** | **String**| The global ID of the remote issue link. | [optional]

### Return type

[**RemoteIssueLink**](RemoteIssueLink.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if issue linking is disabled. |  -  |
| **404** | Returned if the the issue or remote issue link is not found or the user does not have permission to view the issue. |  -  |


## comAtlassianJiraRestV2IssueIssueResourceUpdateRemoteIssueLinkPut

> Object comAtlassianJiraRestV2IssueIssueResourceUpdateRemoteIssueLinkPut(issueIdOrKey, linkId, requestBody)

Update remote issue link by ID

Updates a remote issue link for an issue.  Note: Fields without values in the request are set to null.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueRemoteLinksApi;

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

        IssueRemoteLinksApi apiInstance = new IssueRemoteLinksApi(defaultClient);
        String issueIdOrKey = 10000; // String | The ID or key of the issue.
        String linkId = 10000; // String | The ID of the remote issue link.
        Map<String, Object> requestBody = {"application":{"name":"My Acme Tracker","type":"com.acme.tracker"},"globalId":"system=http://www.mycompany.com/support&id=1","relationship":"causes","object":{"summary":"Customer support issue","icon":{"url16x16":"http://www.mycompany.com/support/ticket.png","title":"Support Ticket"},"title":"TSTSUP-111","url":"http://www.mycompany.com/support?id=1","status":{"icon":{"url16x16":"http://www.mycompany.com/support/resolved.png","link":"http://www.mycompany.com/support?id=1&details=closed","title":"Case Closed"},"resolved":true}}}; // Map<String, Object> | 
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueIssueResourceUpdateRemoteIssueLinkPut(issueIdOrKey, linkId, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueRemoteLinksApi#comAtlassianJiraRestV2IssueIssueResourceUpdateRemoteIssueLinkPut");
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
 **linkId** | **String**| The ID of the remote issue link. |
 **requestBody** | [**Map&lt;String, Object&gt;**](Object.md)|  |

### Return type

**Object**

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the request is successful. |  -  |
| **400** | Returned if:   *  the link ID is invalid.  *  the remote issue link does not belong to the issue.  *  the request body is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to link issues. |  -  |
| **404** | Returned if the issue or remote issue link is not found or the user does not have permission to view the issue. |  -  |

