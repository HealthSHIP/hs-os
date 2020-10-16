# ProjectCategoriesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueProjectCategoryResourceCreateProjectCategoryPost**](ProjectCategoriesApi.md#comAtlassianJiraRestV2IssueProjectCategoryResourceCreateProjectCategoryPost) | **POST** /rest/api/3/projectCategory | Create project contactCategory
[**comAtlassianJiraRestV2IssueProjectCategoryResourceGetAllProjectCategoriesGet**](ProjectCategoriesApi.md#comAtlassianJiraRestV2IssueProjectCategoryResourceGetAllProjectCategoriesGet) | **GET** /rest/api/3/projectCategory | Get all project categories
[**comAtlassianJiraRestV2IssueProjectCategoryResourceGetProjectCategoryByIdGet**](ProjectCategoriesApi.md#comAtlassianJiraRestV2IssueProjectCategoryResourceGetProjectCategoryByIdGet) | **GET** /rest/api/3/projectCategory/{id} | Get project contactCategory by id
[**comAtlassianJiraRestV2IssueProjectCategoryResourceRemoveProjectCategoryDelete**](ProjectCategoriesApi.md#comAtlassianJiraRestV2IssueProjectCategoryResourceRemoveProjectCategoryDelete) | **DELETE** /rest/api/3/projectCategory/{id} | Delete project contactCategory
[**comAtlassianJiraRestV2IssueProjectCategoryResourceUpdateProjectCategoryPut**](ProjectCategoriesApi.md#comAtlassianJiraRestV2IssueProjectCategoryResourceUpdateProjectCategoryPut) | **PUT** /rest/api/3/projectCategory/{id} | Update project contactCategory



## comAtlassianJiraRestV2IssueProjectCategoryResourceCreateProjectCategoryPost

> ProjectCategory comAtlassianJiraRestV2IssueProjectCategoryResourceCreateProjectCategoryPost(projectCategory)

Create project contactCategory

Creates a project contactCategory.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectCategoriesApi;

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

        ProjectCategoriesApi apiInstance = new ProjectCategoriesApi(defaultClient);
        ProjectCategory projectCategory = {"name":"CREATED","description":"Created Project Category"}; // ProjectCategory | 
        try {
            ProjectCategory result = apiInstance.comAtlassianJiraRestV2IssueProjectCategoryResourceCreateProjectCategoryPost(projectCategory);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectCategoriesApi#comAtlassianJiraRestV2IssueProjectCategoryResourceCreateProjectCategoryPost");
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
 **projectCategory** | [**ProjectCategory**](ProjectCategory.md)|  |

### Return type

[**ProjectCategory**](ProjectCategory.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **409** | Returned if the project contactCategory name is in use. |  -  |


## comAtlassianJiraRestV2IssueProjectCategoryResourceGetAllProjectCategoriesGet

> List&lt;ProjectCategory&gt; comAtlassianJiraRestV2IssueProjectCategoryResourceGetAllProjectCategoriesGet()

Get all project categories

Returns all project categories.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectCategoriesApi;

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

        ProjectCategoriesApi apiInstance = new ProjectCategoriesApi(defaultClient);
        try {
            List<ProjectCategory> result = apiInstance.comAtlassianJiraRestV2IssueProjectCategoryResourceGetAllProjectCategoriesGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectCategoriesApi#comAtlassianJiraRestV2IssueProjectCategoryResourceGetAllProjectCategoriesGet");
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

[**List&lt;ProjectCategory&gt;**](ProjectCategory.md)

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


## comAtlassianJiraRestV2IssueProjectCategoryResourceGetProjectCategoryByIdGet

> ProjectCategory comAtlassianJiraRestV2IssueProjectCategoryResourceGetProjectCategoryByIdGet(id)

Get project contactCategory by id

Returns a project contactCategory.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectCategoriesApi;

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

        ProjectCategoriesApi apiInstance = new ProjectCategoriesApi(defaultClient);
        Long id = 56L; // Long | The ID of the project contactCategory.
        try {
            ProjectCategory result = apiInstance.comAtlassianJiraRestV2IssueProjectCategoryResourceGetProjectCategoryByIdGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectCategoriesApi#comAtlassianJiraRestV2IssueProjectCategoryResourceGetProjectCategoryByIdGet");
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
 **id** | **Long**| The ID of the project contactCategory. |

### Return type

[**ProjectCategory**](ProjectCategory.md)

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
| **404** | Returned if the project contactCategory is not found. |  -  |


## comAtlassianJiraRestV2IssueProjectCategoryResourceRemoveProjectCategoryDelete

> comAtlassianJiraRestV2IssueProjectCategoryResourceRemoveProjectCategoryDelete(id)

Delete project contactCategory

Deletes a project contactCategory.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectCategoriesApi;

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

        ProjectCategoriesApi apiInstance = new ProjectCategoriesApi(defaultClient);
        Long id = 56L; // Long | ID of the project contactCategory to delete.
        try {
            apiInstance.comAtlassianJiraRestV2IssueProjectCategoryResourceRemoveProjectCategoryDelete(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectCategoriesApi#comAtlassianJiraRestV2IssueProjectCategoryResourceRemoveProjectCategoryDelete");
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
 **id** | **Long**| ID of the project contactCategory to delete. |

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
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the project contactCategory is not found. |  -  |


## comAtlassianJiraRestV2IssueProjectCategoryResourceUpdateProjectCategoryPut

> UpdatedProjectCategory comAtlassianJiraRestV2IssueProjectCategoryResourceUpdateProjectCategoryPut(id, projectCategory)

Update project contactCategory

Updates a project contactCategory.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectCategoriesApi;

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

        ProjectCategoriesApi apiInstance = new ProjectCategoriesApi(defaultClient);
        Long id = 56L; // Long | 
        ProjectCategory projectCategory = {"name":"UPDATED","description":"Updated Project Category"}; // ProjectCategory | 
        try {
            UpdatedProjectCategory result = apiInstance.comAtlassianJiraRestV2IssueProjectCategoryResourceUpdateProjectCategoryPut(id, projectCategory);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectCategoriesApi#comAtlassianJiraRestV2IssueProjectCategoryResourceUpdateProjectCategoryPut");
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
 **id** | **Long**|  |
 **projectCategory** | [**ProjectCategory**](ProjectCategory.md)|  |

### Return type

[**UpdatedProjectCategory**](UpdatedProjectCategory.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the project contactCategory is not found. |  -  |

