# ProjectKeyAndNameValidationApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectKeyGet**](ProjectKeyAndNameValidationApi.md#comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectKeyGet) | **GET** /rest/api/3/projectvalidate/validProjectKey | Get valid project key
[**comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectNameGet**](ProjectKeyAndNameValidationApi.md#comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectNameGet) | **GET** /rest/api/3/projectvalidate/validProjectName | Get valid project name
[**comAtlassianJiraRestV2IssueProjectValidateResourceValidateProjectKeyGet**](ProjectKeyAndNameValidationApi.md#comAtlassianJiraRestV2IssueProjectValidateResourceValidateProjectKeyGet) | **GET** /rest/api/3/projectvalidate/key | Validate project key



## comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectKeyGet

> String comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectKeyGet(key)

Get valid project key

Validates a project key and, if the key is invalid or in use, generates a valid random string for the project key.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectKeyAndNameValidationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ProjectKeyAndNameValidationApi apiInstance = new ProjectKeyAndNameValidationApi(defaultClient);
        String key = HSP; // String | The project key.
        try {
            String result = apiInstance.comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectKeyGet(key);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectKeyAndNameValidationApi#comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectKeyGet");
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
 **key** | **String**| The project key. | [optional]

### Return type

**String**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |


## comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectNameGet

> String comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectNameGet(name)

Get valid project name

Checks that a project name isn&#39;t in use. If the name isn&#39;t in use, the passed string is returned. If the name is in use, this operation attempts to generate a valid project name based on the one supplied, usually by adding a sequence number. If a valid project name cannot be generated, a 404 response is returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectKeyAndNameValidationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ProjectKeyAndNameValidationApi apiInstance = new ProjectKeyAndNameValidationApi(defaultClient);
        String name = "name_example"; // String | The project name.
        try {
            String result = apiInstance.comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectNameGet(name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectKeyAndNameValidationApi#comAtlassianJiraRestV2IssueProjectValidateResourceGetValidProjectNameGet");
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
 **name** | **String**| The project name. |

### Return type

**String**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |
| **404** | Returned if a valid project name cannot be generated. |  -  |


## comAtlassianJiraRestV2IssueProjectValidateResourceValidateProjectKeyGet

> ErrorCollection comAtlassianJiraRestV2IssueProjectValidateResourceValidateProjectKeyGet(key)

Validate project key

Validates a project key by confirming the key is a valid string and not in use.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectKeyAndNameValidationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ProjectKeyAndNameValidationApi apiInstance = new ProjectKeyAndNameValidationApi(defaultClient);
        String key = HSP; // String | The project key.
        try {
            ErrorCollection result = apiInstance.comAtlassianJiraRestV2IssueProjectValidateResourceValidateProjectKeyGet(key);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectKeyAndNameValidationApi#comAtlassianJiraRestV2IssueProjectValidateResourceValidateProjectKeyGet");
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
 **key** | **String**| The project key. | [optional]

### Return type

[**ErrorCollection**](ErrorCollection.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |

