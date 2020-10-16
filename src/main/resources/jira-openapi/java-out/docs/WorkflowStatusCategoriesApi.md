# WorkflowStatusCategoriesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoriesGet**](WorkflowStatusCategoriesApi.md#comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoriesGet) | **GET** /rest/api/3/statuscategory | Get all status categories
[**comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoryGet**](WorkflowStatusCategoriesApi.md#comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoryGet) | **GET** /rest/api/3/statuscategory/{idOrKey} | Get status contactCategory



## comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoriesGet

> List&lt;StatusCategory&gt; comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoriesGet()

Get all status categories

Returns a list of all status categories.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowStatusCategoriesApi;

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

        WorkflowStatusCategoriesApi apiInstance = new WorkflowStatusCategoriesApi(defaultClient);
        try {
            List<StatusCategory> result = apiInstance.comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoriesGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowStatusCategoriesApi#comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoriesGet");
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

[**List&lt;StatusCategory&gt;**](StatusCategory.md)

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


## comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoryGet

> StatusCategory comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoryGet(idOrKey)

Get status contactCategory

Returns a status contactCategory. Status categories provided a mechanism for categorizing [statuses](#api-rest-api-3-status-idOrName-get).  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowStatusCategoriesApi;

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

        WorkflowStatusCategoriesApi apiInstance = new WorkflowStatusCategoriesApi(defaultClient);
        String idOrKey = "idOrKey_example"; // String | The ID or key of the status contactCategory.
        try {
            StatusCategory result = apiInstance.comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoryGet(idOrKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowStatusCategoriesApi#comAtlassianJiraRestV2IssueStatusCategoryResourceGetStatusCategoryGet");
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
 **idOrKey** | **String**| The ID or key of the status contactCategory. |

### Return type

[**StatusCategory**](StatusCategory.md)

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
| **404** | Returned if the status contactCategory is not found. |  -  |

