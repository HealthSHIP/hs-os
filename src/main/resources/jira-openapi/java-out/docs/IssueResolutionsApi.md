# IssueResolutionsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueResolutionResourceGetResolutionGet**](IssueResolutionsApi.md#comAtlassianJiraRestV2IssueResolutionResourceGetResolutionGet) | **GET** /rest/api/3/resolution/{id} | Get resolution
[**comAtlassianJiraRestV2IssueResolutionResourceGetResolutionsGet**](IssueResolutionsApi.md#comAtlassianJiraRestV2IssueResolutionResourceGetResolutionsGet) | **GET** /rest/api/3/resolution | Get resolutions



## comAtlassianJiraRestV2IssueResolutionResourceGetResolutionGet

> Resolution comAtlassianJiraRestV2IssueResolutionResourceGetResolutionGet(id)

Get resolution

Returns an issue resolution value.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueResolutionsApi;

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

        IssueResolutionsApi apiInstance = new IssueResolutionsApi(defaultClient);
        String id = "id_example"; // String | The ID of the issue resolution value.
        try {
            Resolution result = apiInstance.comAtlassianJiraRestV2IssueResolutionResourceGetResolutionGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueResolutionsApi#comAtlassianJiraRestV2IssueResolutionResourceGetResolutionGet");
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
 **id** | **String**| The ID of the issue resolution value. |

### Return type

[**Resolution**](Resolution.md)

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
| **404** | Returned if the issue resolution value is not found. |  -  |


## comAtlassianJiraRestV2IssueResolutionResourceGetResolutionsGet

> List&lt;Resolution&gt; comAtlassianJiraRestV2IssueResolutionResourceGetResolutionsGet()

Get resolutions

Returns a list of all issue resolution values.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueResolutionsApi;

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

        IssueResolutionsApi apiInstance = new IssueResolutionsApi(defaultClient);
        try {
            List<Resolution> result = apiInstance.comAtlassianJiraRestV2IssueResolutionResourceGetResolutionsGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueResolutionsApi#comAtlassianJiraRestV2IssueResolutionResourceGetResolutionsGet");
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

[**List&lt;Resolution&gt;**](Resolution.md)

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

