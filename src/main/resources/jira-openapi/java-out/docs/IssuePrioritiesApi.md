# IssuePrioritiesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssuePriorityResourceGetPrioritiesGet**](IssuePrioritiesApi.md#comAtlassianJiraRestV2IssuePriorityResourceGetPrioritiesGet) | **GET** /rest/api/3/priority | Get priorities
[**comAtlassianJiraRestV2IssuePriorityResourceGetPriorityGet**](IssuePrioritiesApi.md#comAtlassianJiraRestV2IssuePriorityResourceGetPriorityGet) | **GET** /rest/api/3/priority/{id} | Get priority



## comAtlassianJiraRestV2IssuePriorityResourceGetPrioritiesGet

> List&lt;Priority&gt; comAtlassianJiraRestV2IssuePriorityResourceGetPrioritiesGet()

Get priorities

Returns the list of all issue priorities.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssuePrioritiesApi;

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

        IssuePrioritiesApi apiInstance = new IssuePrioritiesApi(defaultClient);
        try {
            List<Priority> result = apiInstance.comAtlassianJiraRestV2IssuePriorityResourceGetPrioritiesGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssuePrioritiesApi#comAtlassianJiraRestV2IssuePriorityResourceGetPrioritiesGet");
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

[**List&lt;Priority&gt;**](Priority.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |


## comAtlassianJiraRestV2IssuePriorityResourceGetPriorityGet

> Priority comAtlassianJiraRestV2IssuePriorityResourceGetPriorityGet(id)

Get priority

Returns an issue priority.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssuePrioritiesApi;

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

        IssuePrioritiesApi apiInstance = new IssuePrioritiesApi(defaultClient);
        String id = "id_example"; // String | The ID of the issue priority.
        try {
            Priority result = apiInstance.comAtlassianJiraRestV2IssuePriorityResourceGetPriorityGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssuePrioritiesApi#comAtlassianJiraRestV2IssuePriorityResourceGetPriorityGet");
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
 **id** | **String**| The ID of the issue priority. |

### Return type

[**Priority**](Priority.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |
| **404** | Returned if the issue priority is not found. |  -  |

