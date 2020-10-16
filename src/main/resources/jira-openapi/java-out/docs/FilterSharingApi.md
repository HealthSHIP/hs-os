# FilterSharingApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2SearchFilterResourceAddSharePermissionPost**](FilterSharingApi.md#comAtlassianJiraRestV2SearchFilterResourceAddSharePermissionPost) | **POST** /rest/api/3/filter/{id}/permission | Add share permission
[**comAtlassianJiraRestV2SearchFilterResourceDeleteSharePermissionDelete**](FilterSharingApi.md#comAtlassianJiraRestV2SearchFilterResourceDeleteSharePermissionDelete) | **DELETE** /rest/api/3/filter/{id}/permission/{permissionId} | Delete share permission
[**comAtlassianJiraRestV2SearchFilterResourceGetDefaultShareScopeGet**](FilterSharingApi.md#comAtlassianJiraRestV2SearchFilterResourceGetDefaultShareScopeGet) | **GET** /rest/api/3/filter/defaultShareScope | Get default share scope
[**comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionGet**](FilterSharingApi.md#comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionGet) | **GET** /rest/api/3/filter/{id}/permission/{permissionId} | Get share permission
[**comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionsGet**](FilterSharingApi.md#comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionsGet) | **GET** /rest/api/3/filter/{id}/permission | Get share permissions
[**comAtlassianJiraRestV2SearchFilterResourceSetDefaultShareScopePut**](FilterSharingApi.md#comAtlassianJiraRestV2SearchFilterResourceSetDefaultShareScopePut) | **PUT** /rest/api/3/filter/defaultShareScope | Set default share scope



## comAtlassianJiraRestV2SearchFilterResourceAddSharePermissionPost

> List&lt;SharePermission&gt; comAtlassianJiraRestV2SearchFilterResourceAddSharePermissionPost(id, sharePermissionInputBean)

Add share permission

Add a share permissions to a filter. If you add a global share permission (one for all logged-in users or the public) it will overwrite all share permissions for the filter.  Be aware that this operation uses different objects for updating share permissions compared to [Update filter](#api-rest-api-3-filter-id-put).  **[Permissions](#permissions) required:** *Share dashboards and filters* [global permission](https://confluence.atlassian.com/x/x4dKLg) and the user must own the filter.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.FilterSharingApi;

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

        FilterSharingApi apiInstance = new FilterSharingApi(defaultClient);
        Long id = 56L; // Long | The ID of the filter.
        SharePermissionInputBean sharePermissionInputBean = {"type":"group","groupname":"jira-administrators"}; // SharePermissionInputBean | 
        try {
            List<SharePermission> result = apiInstance.comAtlassianJiraRestV2SearchFilterResourceAddSharePermissionPost(id, sharePermissionInputBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilterSharingApi#comAtlassianJiraRestV2SearchFilterResourceAddSharePermissionPost");
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
 **id** | **Long**| The ID of the filter. |
 **sharePermissionInputBean** | [**SharePermissionInputBean**](SharePermissionInputBean.md)|  |

### Return type

[**List&lt;SharePermission&gt;**](SharePermission.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **400** | Returned if:   *  the request object is invalid. For example, it contains an invalid type, the ID does not match the type, or the project or group is not found.  *  the user does not own the filter.  *  the user does not have the required permissions. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  the filter is not found.  *  the user does not have permission to view the filter. |  -  |


## comAtlassianJiraRestV2SearchFilterResourceDeleteSharePermissionDelete

> comAtlassianJiraRestV2SearchFilterResourceDeleteSharePermissionDelete(id, permissionId)

Delete share permission

Deletes a share permission from a filter.  **[Permissions](#permissions) required:** Permission to access Jira and the user must own the filter.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.FilterSharingApi;

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

        FilterSharingApi apiInstance = new FilterSharingApi(defaultClient);
        Long id = 56L; // Long | The ID of the filter.
        Long permissionId = 56L; // Long | The ID of the share permission.
        try {
            apiInstance.comAtlassianJiraRestV2SearchFilterResourceDeleteSharePermissionDelete(id, permissionId);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilterSharingApi#comAtlassianJiraRestV2SearchFilterResourceDeleteSharePermissionDelete");
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
 **id** | **Long**| The ID of the filter. |
 **permissionId** | **Long**| The ID of the share permission. |

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
| **404** | Returned if:   *  the filter is not found.  *  the user does not own the filter. |  -  |


## comAtlassianJiraRestV2SearchFilterResourceGetDefaultShareScopeGet

> DefaultShareScope comAtlassianJiraRestV2SearchFilterResourceGetDefaultShareScopeGet()

Get default share scope

Returns the default sharing settings for new filters and dashboards for a user.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.FilterSharingApi;

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

        FilterSharingApi apiInstance = new FilterSharingApi(defaultClient);
        try {
            DefaultShareScope result = apiInstance.comAtlassianJiraRestV2SearchFilterResourceGetDefaultShareScopeGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilterSharingApi#comAtlassianJiraRestV2SearchFilterResourceGetDefaultShareScopeGet");
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

[**DefaultShareScope**](DefaultShareScope.md)

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


## comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionGet

> SharePermission comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionGet(id, permissionId)

Get share permission

Returns a share permission for a filter. A filter can be shared with groups, projects, all logged-in users, or the public. Sharing with all logged-in users or the public is known as a global share permission.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, a share permission is only returned for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.FilterSharingApi;

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

        FilterSharingApi apiInstance = new FilterSharingApi(defaultClient);
        Long id = 56L; // Long | The ID of the filter.
        Long permissionId = 56L; // Long | The ID of the share permission.
        try {
            SharePermission result = apiInstance.comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionGet(id, permissionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilterSharingApi#comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionGet");
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
 **id** | **Long**| The ID of the filter. |
 **permissionId** | **Long**| The ID of the share permission. |

### Return type

[**SharePermission**](SharePermission.md)

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
| **404** | Returned if:   *  the filter is not found.  *  the permission is not found.  *  the user does not have permission to view the filter. |  -  |


## comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionsGet

> List&lt;SharePermission&gt; comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionsGet(id)

Get share permissions

Returns the share permissions for a filter. A filter can be shared with groups, projects, all logged-in users, or the public. Sharing with all logged-in users or the public is known as a global share permission.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, share permissions are only returned for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.FilterSharingApi;

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

        FilterSharingApi apiInstance = new FilterSharingApi(defaultClient);
        Long id = 56L; // Long | The ID of the filter.
        try {
            List<SharePermission> result = apiInstance.comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionsGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilterSharingApi#comAtlassianJiraRestV2SearchFilterResourceGetSharePermissionsGet");
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
 **id** | **Long**| The ID of the filter. |

### Return type

[**List&lt;SharePermission&gt;**](SharePermission.md)

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
| **404** | Returned if:   *  the filter is not found.  *  the user does not have permission to view the filter. |  -  |


## comAtlassianJiraRestV2SearchFilterResourceSetDefaultShareScopePut

> DefaultShareScope comAtlassianJiraRestV2SearchFilterResourceSetDefaultShareScopePut(defaultShareScope)

Set default share scope

Sets the default sharing for new filters and dashboards for a user.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.FilterSharingApi;

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

        FilterSharingApi apiInstance = new FilterSharingApi(defaultClient);
        DefaultShareScope defaultShareScope = {"scope":"GLOBAL"}; // DefaultShareScope | 
        try {
            DefaultShareScope result = apiInstance.comAtlassianJiraRestV2SearchFilterResourceSetDefaultShareScopePut(defaultShareScope);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FilterSharingApi#comAtlassianJiraRestV2SearchFilterResourceSetDefaultShareScopePut");
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
 **defaultShareScope** | [**DefaultShareScope**](DefaultShareScope.md)|  |

### Return type

[**DefaultShareScope**](DefaultShareScope.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if an invalid scope is set. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |

