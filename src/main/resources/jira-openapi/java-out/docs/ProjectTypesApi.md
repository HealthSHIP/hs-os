# ProjectTypesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAccessibleProjectTypeByKeyGet**](ProjectTypesApi.md#comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAccessibleProjectTypeByKeyGet) | **GET** /rest/api/3/project/type/{projectTypeKey}/accessible | Get accessible project type by key
[**comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllAccessibleProjectTypesGet**](ProjectTypesApi.md#comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllAccessibleProjectTypesGet) | **GET** /rest/api/3/project/type/accessible | Get licensed project types
[**comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllProjectTypesGet**](ProjectTypesApi.md#comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllProjectTypesGet) | **GET** /rest/api/3/project/type | Get all project types
[**comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetProjectTypeByKeyGet**](ProjectTypesApi.md#comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetProjectTypeByKeyGet) | **GET** /rest/api/3/project/type/{projectTypeKey} | Get project type by key



## comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAccessibleProjectTypeByKeyGet

> ProjectType comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAccessibleProjectTypeByKeyGet(projectTypeKey)

Get accessible project type by key

Returns a [project type](https://confluence.atlassian.com/x/Var1Nw) if it is accessible to the user.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectTypesApi;

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

        ProjectTypesApi apiInstance = new ProjectTypesApi(defaultClient);
        String projectTypeKey = "projectTypeKey_example"; // String | The key of the project type.
        try {
            ProjectType result = apiInstance.comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAccessibleProjectTypeByKeyGet(projectTypeKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectTypesApi#comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAccessibleProjectTypeByKeyGet");
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
 **projectTypeKey** | **String**| The key of the project type. | [enum: software, service_desk, business]

### Return type

[**ProjectType**](ProjectType.md)

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
| **404** | Returned if the project type is not accessible to the user. |  -  |


## comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllAccessibleProjectTypesGet

> List&lt;ProjectType&gt; comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllAccessibleProjectTypesGet()

Get licensed project types

Returns all [project types](https://confluence.atlassian.com/x/Var1Nw) with a valid license.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectTypesApi;

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

        ProjectTypesApi apiInstance = new ProjectTypesApi(defaultClient);
        try {
            List<ProjectType> result = apiInstance.comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllAccessibleProjectTypesGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectTypesApi#comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllAccessibleProjectTypesGet");
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

[**List&lt;ProjectType&gt;**](ProjectType.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |


## comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllProjectTypesGet

> List&lt;ProjectType&gt; comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllProjectTypesGet()

Get all project types

Returns all [project types](https://confluence.atlassian.com/x/Var1Nw), whether or not the instance has a valid license for each type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectTypesApi;

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

        ProjectTypesApi apiInstance = new ProjectTypesApi(defaultClient);
        try {
            List<ProjectType> result = apiInstance.comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllProjectTypesGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectTypesApi#comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetAllProjectTypesGet");
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

[**List&lt;ProjectType&gt;**](ProjectType.md)

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


## comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetProjectTypeByKeyGet

> ProjectType comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetProjectTypeByKeyGet(projectTypeKey)

Get project type by key

Returns a [project type](https://confluence.atlassian.com/x/Var1Nw).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectTypesApi;

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

        ProjectTypesApi apiInstance = new ProjectTypesApi(defaultClient);
        String projectTypeKey = "projectTypeKey_example"; // String | The key of the project type.
        try {
            ProjectType result = apiInstance.comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetProjectTypeByKeyGet(projectTypeKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectTypesApi#comAtlassianJiraRestV2ProjectTypeProjectTypeResourceGetProjectTypeByKeyGet");
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
 **projectTypeKey** | **String**| The key of the project type. | [enum: software, service_desk, business]

### Return type

[**ProjectType**](ProjectType.md)

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
| **404** | Returned if the project type is not found. |  -  |

