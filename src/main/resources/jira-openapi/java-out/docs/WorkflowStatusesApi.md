# WorkflowStatusesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueStatusResourceGetStatusGet**](WorkflowStatusesApi.md#comAtlassianJiraRestV2IssueStatusResourceGetStatusGet) | **GET** /rest/api/3/status/{idOrName} | Get status
[**comAtlassianJiraRestV2IssueStatusResourceGetStatusesGet**](WorkflowStatusesApi.md#comAtlassianJiraRestV2IssueStatusResourceGetStatusesGet) | **GET** /rest/api/3/status | Get all statuses



## comAtlassianJiraRestV2IssueStatusResourceGetStatusGet

> StatusDetails comAtlassianJiraRestV2IssueStatusResourceGetStatusGet(idOrName)

Get status

Returns a status. The status must be associated with a workflow to be returned.  If a name is used on more than one status, only the status found first is returned. Therefore, identifying the status by its ID may be preferable.  This operation can be accessed anonymously.  [Permissions](#permissions) required: None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowStatusesApi;

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

        WorkflowStatusesApi apiInstance = new WorkflowStatusesApi(defaultClient);
        String idOrName = "idOrName_example"; // String | The ID or name of the status.
        try {
            StatusDetails result = apiInstance.comAtlassianJiraRestV2IssueStatusResourceGetStatusGet(idOrName);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowStatusesApi#comAtlassianJiraRestV2IssueStatusResourceGetStatusGet");
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
 **idOrName** | **String**| The ID or name of the status. |

### Return type

[**StatusDetails**](StatusDetails.md)

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
| **404** | Returned if:   *  the status is not found.  *  the status is not associated with a workflow.  *  the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueStatusResourceGetStatusesGet

> List&lt;StatusDetails&gt; comAtlassianJiraRestV2IssueStatusResourceGetStatusesGet()

Get all statuses

Returns a list of all statuses associated with workflows.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowStatusesApi;

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

        WorkflowStatusesApi apiInstance = new WorkflowStatusesApi(defaultClient);
        try {
            List<StatusDetails> result = apiInstance.comAtlassianJiraRestV2IssueStatusResourceGetStatusesGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowStatusesApi#comAtlassianJiraRestV2IssueStatusResourceGetStatusesGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;StatusDetails&gt;**](StatusDetails.md)

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

