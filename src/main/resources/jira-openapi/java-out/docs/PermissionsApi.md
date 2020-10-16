# PermissionsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2PermissionPermissionsResourceGetAllPermissionsGet**](PermissionsApi.md#comAtlassianJiraRestV2PermissionPermissionsResourceGetAllPermissionsGet) | **GET** /rest/api/3/permissions | Get all permissions
[**comAtlassianJiraRestV2PermissionPermissionsResourceGetBulkPermissionsPost**](PermissionsApi.md#comAtlassianJiraRestV2PermissionPermissionsResourceGetBulkPermissionsPost) | **POST** /rest/api/3/permissions/check | Get bulk permissions
[**comAtlassianJiraRestV2PermissionPermissionsResourceGetMyPermissionsGet**](PermissionsApi.md#comAtlassianJiraRestV2PermissionPermissionsResourceGetMyPermissionsGet) | **GET** /rest/api/3/mypermissions | Get my permissions
[**comAtlassianJiraRestV2PermissionPermissionsResourceGetPermittedProjectsPost**](PermissionsApi.md#comAtlassianJiraRestV2PermissionPermissionsResourceGetPermittedProjectsPost) | **POST** /rest/api/3/permissions/project | Get permitted projects



## comAtlassianJiraRestV2PermissionPermissionsResourceGetAllPermissionsGet

> Permissions comAtlassianJiraRestV2PermissionPermissionsResourceGetAllPermissionsGet()

Get all permissions

Returns all permissions, including:   *  global permissions.  *  project permissions.  *  global permissions added by plugins.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        PermissionsApi apiInstance = new PermissionsApi(defaultClient);
        try {
            Permissions result = apiInstance.comAtlassianJiraRestV2PermissionPermissionsResourceGetAllPermissionsGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionsApi#comAtlassianJiraRestV2PermissionPermissionsResourceGetAllPermissionsGet");
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

[**Permissions**](Permissions.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2PermissionPermissionsResourceGetBulkPermissionsPost

> BulkPermissionGrants comAtlassianJiraRestV2PermissionPermissionsResourceGetBulkPermissionsPost(bulkPermissionsRequestBean)

Get bulk permissions

Returns:   *  for a list of global permissions, the global permissions granted to the user.  *  for a list of project permissions and lists of projects and issues, for each project permission a list of the projects and issues the user can access or manipulate.  Note that:   *  Invalid project and issue IDs are ignored.  *  A maximum of 1000 projects and 1000 issues can be checked.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionsApi;

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

        PermissionsApi apiInstance = new PermissionsApi(defaultClient);
        BulkPermissionsRequestBean bulkPermissionsRequestBean = {"globalPermissions":["SYSTEM_ADMIN"],"projectPermissions":[{"projects":[10001],"permissions":["EDIT_ISSUE"],"issues":[10010,10011,10012,10013,10014]}]}; // BulkPermissionsRequestBean | Details of the permissions to check.
        try {
            BulkPermissionGrants result = apiInstance.comAtlassianJiraRestV2PermissionPermissionsResourceGetBulkPermissionsPost(bulkPermissionsRequestBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionsApi#comAtlassianJiraRestV2PermissionPermissionsResourceGetBulkPermissionsPost");
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
 **bulkPermissionsRequestBean** | [**BulkPermissionsRequestBean**](BulkPermissionsRequestBean.md)| Details of the permissions to check. |

### Return type

[**BulkPermissionGrants**](BulkPermissionGrants.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if:   *  issue or project IDs are provided without at least one project permission being provided.  *  an invalid global permission is provided in the global permissions list.  *  an invalid project permission is provided in the project permissions list.  *  more than 1000 valid project IDs or more than 1000 valid issue IDs are provided. |  -  |


## comAtlassianJiraRestV2PermissionPermissionsResourceGetMyPermissionsGet

> Permissions comAtlassianJiraRestV2PermissionPermissionsResourceGetMyPermissionsGet(projectKey, projectId, issueKey, issueId, permissions, projectUuid, projectConfigurationUuid)

Get my permissions

Returns a list of permissions indicating which permissions the user has. Details of the user&#39;s permissions can be obtained in a global, project, or issue context.  The user is reported as having a project permission:   *  in the global context, if the user has the project permission in any project.  *  for a project, where the project permission is determined using issue data, if the user meets the permission&#39;s criteria for any issue in the project. Otherwise, if the user has the project permission in the project.  *  for an issue, where a project permission is determined using issue data, if the user has the permission in the issue. Otherwise, if the user has the project permission in the project containing the issue.  This means that users may be shown as having an issue permission (such as EDIT\\_ISSUE) in the global context or a project context but may not have the permission for any or all issues. For example, if Reporters have the EDIT\\_ISSUE permission a user would be shown as having this permission in the global context or the context of a project, because any user can be a reporter. However, if they are not the user who reported the issue queried they would not have EDIT\\_ISSUE permission for that issue.  Global permissions are unaffected by context.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionsApi;

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

        PermissionsApi apiInstance = new PermissionsApi(defaultClient);
        String projectKey = "projectKey_example"; // String | The key of project. Ignored if `projectId` is provided.
        String projectId = "projectId_example"; // String | The ID of project.
        String issueKey = "issueKey_example"; // String | The key of the issue. Ignored if `issueId` is provided.
        String issueId = "issueId_example"; // String | The ID of the issue.
        String permissions = BROWSE_PROJECTS,EDIT_ISSUES; // String | A list of permission keys. This parameter accepts a comma-separated list. [ Omitting this parameter is **deprecated**.](https://developer.atlassian.com/cloud/jira/platform/change-notice-get-my-permissions-requires-permissions-query-parameter/) To get the list of available permissions, use [Get all permissions](#api-rest-api-3-permissions-get). Note that deprecated keys cannot be used. Deprecated keys are not returned by [Get all permissions](#api-rest-api-3-permissions-get) but are returned by this operation if `permissions` is omitted.
        String projectUuid = "projectUuid_example"; // String | 
        String projectConfigurationUuid = "projectConfigurationUuid_example"; // String | 
        try {
            Permissions result = apiInstance.comAtlassianJiraRestV2PermissionPermissionsResourceGetMyPermissionsGet(projectKey, projectId, issueKey, issueId, permissions, projectUuid, projectConfigurationUuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionsApi#comAtlassianJiraRestV2PermissionPermissionsResourceGetMyPermissionsGet");
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
 **projectKey** | **String**| The key of project. Ignored if &#x60;projectId&#x60; is provided. | [optional]
 **projectId** | **String**| The ID of project. | [optional]
 **issueKey** | **String**| The key of the issue. Ignored if &#x60;issueId&#x60; is provided. | [optional]
 **issueId** | **String**| The ID of the issue. | [optional]
 **permissions** | **String**| A list of permission keys. This parameter accepts a comma-separated list. [ Omitting this parameter is **deprecated**.](https://developer.atlassian.com/cloud/jira/platform/change-notice-get-my-permissions-requires-permissions-query-parameter/) To get the list of available permissions, use [Get all permissions](#api-rest-api-3-permissions-get). Note that deprecated keys cannot be used. Deprecated keys are not returned by [Get all permissions](#api-rest-api-3-permissions-get) but are returned by this operation if &#x60;permissions&#x60; is omitted. | [optional]
 **projectUuid** | **String**|  | [optional]
 **projectConfigurationUuid** | **String**|  | [optional]

### Return type

[**Permissions**](Permissions.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if &#x60;permissions&#x60; is empty or the permission key it contains is not found or deprecated. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the project or issue is not found or the user does not have permission to view the project or issue. |  -  |


## comAtlassianJiraRestV2PermissionPermissionsResourceGetPermittedProjectsPost

> PermittedProjects comAtlassianJiraRestV2PermissionPermissionsResourceGetPermittedProjectsPost(permissionsKeysBean)

Get permitted projects

Returns all the projects where the user is granted a list of project permissions.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionsApi;

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

        PermissionsApi apiInstance = new PermissionsApi(defaultClient);
        PermissionsKeysBean permissionsKeysBean = new PermissionsKeysBean(); // PermissionsKeysBean | 
        try {
            PermittedProjects result = apiInstance.comAtlassianJiraRestV2PermissionPermissionsResourceGetPermittedProjectsPost(permissionsKeysBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionsApi#comAtlassianJiraRestV2PermissionPermissionsResourceGetPermittedProjectsPost");
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
 **permissionsKeysBean** | [**PermissionsKeysBean**](PermissionsKeysBean.md)|  |

### Return type

[**PermittedProjects**](PermittedProjects.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if a project permission is not found. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |

