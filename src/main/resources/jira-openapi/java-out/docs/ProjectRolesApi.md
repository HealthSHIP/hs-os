# ProjectRolesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueProjectProjectRoleDetailsResourceGetProjectRoleDetailsGet**](ProjectRolesApi.md#comAtlassianJiraRestV2IssueProjectProjectRoleDetailsResourceGetProjectRoleDetailsGet) | **GET** /rest/api/3/project/{projectIdOrKey}/roledetails | Get project role details
[**comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRoleGet**](ProjectRolesApi.md#comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRoleGet) | **GET** /rest/api/3/project/{projectIdOrKey}/role/{id} | Get project role for project
[**comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRolesGet**](ProjectRolesApi.md#comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRolesGet) | **GET** /rest/api/3/project/{projectIdOrKey}/role | Get project roles for project
[**comAtlassianJiraRestV2IssueProjectRoleResourceCreateProjectRolePost**](ProjectRolesApi.md#comAtlassianJiraRestV2IssueProjectRoleResourceCreateProjectRolePost) | **POST** /rest/api/3/role | Create project role
[**comAtlassianJiraRestV2IssueProjectRoleResourceDeleteProjectRoleDelete**](ProjectRolesApi.md#comAtlassianJiraRestV2IssueProjectRoleResourceDeleteProjectRoleDelete) | **DELETE** /rest/api/3/role/{id} | Delete project role
[**comAtlassianJiraRestV2IssueProjectRoleResourceFullyUpdateProjectRolePut**](ProjectRolesApi.md#comAtlassianJiraRestV2IssueProjectRoleResourceFullyUpdateProjectRolePut) | **PUT** /rest/api/3/role/{id} | Fully update project role
[**comAtlassianJiraRestV2IssueProjectRoleResourceGetAllProjectRolesGet**](ProjectRolesApi.md#comAtlassianJiraRestV2IssueProjectRoleResourceGetAllProjectRolesGet) | **GET** /rest/api/3/role | Get all project roles
[**comAtlassianJiraRestV2IssueProjectRoleResourceGetProjectRoleByIdGet**](ProjectRolesApi.md#comAtlassianJiraRestV2IssueProjectRoleResourceGetProjectRoleByIdGet) | **GET** /rest/api/3/role/{id} | Get project role by ID
[**comAtlassianJiraRestV2IssueProjectRoleResourcePartialUpdateProjectRolePost**](ProjectRolesApi.md#comAtlassianJiraRestV2IssueProjectRoleResourcePartialUpdateProjectRolePost) | **POST** /rest/api/3/role/{id} | Partial update project role



## comAtlassianJiraRestV2IssueProjectProjectRoleDetailsResourceGetProjectRoleDetailsGet

> List&lt;ProjectRole&gt; comAtlassianJiraRestV2IssueProjectProjectRoleDetailsResourceGetProjectRoleDetailsGet(projectIdOrKey, currentMember, excludeConnectAddons)

Get project role details

Returns all [project roles](https://confluence.atlassian.com/x/3odKLg) and the details for each role. Note that the list of project roles is common to all projects.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectRolesApi;

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

        ProjectRolesApi apiInstance = new ProjectRolesApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The project ID or project key (case sensitive).
        Boolean currentMember = false; // Boolean | Whether the roles should be filtered to include only those the user is assigned to.
        Boolean excludeConnectAddons = false; // Boolean | 
        try {
            List<ProjectRole> result = apiInstance.comAtlassianJiraRestV2IssueProjectProjectRoleDetailsResourceGetProjectRoleDetailsGet(projectIdOrKey, currentMember, excludeConnectAddons);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRolesApi#comAtlassianJiraRestV2IssueProjectProjectRoleDetailsResourceGetProjectRoleDetailsGet");
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
 **projectIdOrKey** | **String**| The project ID or project key (case sensitive). |
 **currentMember** | **Boolean**| Whether the roles should be filtered to include only those the user is assigned to. | [optional] [default to false]
 **excludeConnectAddons** | **Boolean**|  | [optional] [default to false]

### Return type

[**List&lt;ProjectRole&gt;**](ProjectRole.md)

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
| **404** | Returned if the project is not found or if the user does not have the necessary permissions for the project. |  -  |


## comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRoleGet

> ProjectRole comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRoleGet(projectIdOrKey, id)

Get project role for project

Returns a project role&#39;s details and actors associated with the project. The list of actors is sorted by display name.  To check whether a user belongs to a role based on their group memberships, use [Get user](#api-rest-api-3-user-get) with the &#x60;groups&#x60; expand parameter selected. Then check whether the user keys and groups match with the actors returned for the project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectRolesApi;

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

        ProjectRolesApi apiInstance = new ProjectRolesApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The project ID or project key (case sensitive).
        Long id = 56L; // Long | The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
        try {
            ProjectRole result = apiInstance.comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRoleGet(projectIdOrKey, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRolesApi#comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRoleGet");
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
 **projectIdOrKey** | **String**| The project ID or project key (case sensitive). |
 **id** | **Long**| The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. |

### Return type

[**ProjectRole**](ProjectRole.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  the project or project role is not found.  *  the user does not have administrative permission. |  -  |


## comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRolesGet

> Map&lt;String, URI&gt; comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRolesGet(projectIdOrKey)

Get project roles for project

Returns a list of [project roles](https://confluence.atlassian.com/x/3odKLg) for the project returning the name and self URL for each role.  Note that all project roles are shared with all projects in Jira Cloud. See [Get all project roles](#api-rest-api-3-role-get) for more information.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for any project on the site or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectRolesApi;

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

        ProjectRolesApi apiInstance = new ProjectRolesApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The project ID or project key (case sensitive).
        try {
            Map<String, URI> result = apiInstance.comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRolesGet(projectIdOrKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRolesApi#comAtlassianJiraRestV2IssueProjectProjectRoleResourceGetProjectRolesGet");
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
 **projectIdOrKey** | **String**| The project ID or project key (case sensitive). |

### Return type

[**Map&lt;String, URI&gt;**](URI.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing or if the user lacks administrative permissions for the project. |  -  |
| **404** | Returned if the project is not found or or if the user does not have administrative permissions for the project. |  -  |


## comAtlassianJiraRestV2IssueProjectRoleResourceCreateProjectRolePost

> ProjectRole comAtlassianJiraRestV2IssueProjectRoleResourceCreateProjectRolePost(createUpdateRoleRequestBean)

Create project role

Creates a new project role with no [default actors](#api-rest-api-3-resolution-get). You can use the [Add default actors to project role](#api-rest-api-3-role-id-actors-post) operation to add default actors to the project role after creating it.  *Note that although a new project role is available to all projects upon creation, any default actors that are associated with the project role are not added to projects that existed prior to the role being created.*&lt;  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectRolesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ProjectRolesApi apiInstance = new ProjectRolesApi(defaultClient);
        CreateUpdateRoleRequestBean createUpdateRoleRequestBean = {"name":"Developers","description":"A project role that represents developers in a project"}; // CreateUpdateRoleRequestBean | 
        try {
            ProjectRole result = apiInstance.comAtlassianJiraRestV2IssueProjectRoleResourceCreateProjectRolePost(createUpdateRoleRequestBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRolesApi#comAtlassianJiraRestV2IssueProjectRoleResourceCreateProjectRolePost");
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
 **createUpdateRoleRequestBean** | [**CreateUpdateRoleRequestBean**](CreateUpdateRoleRequestBean.md)|  |

### Return type

[**ProjectRole**](ProjectRole.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is not valid. The &#x60;name&#x60; cannot be empty or start or end with whitespace. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have administrative permissions. |  -  |
| **409** | Returned if a project role with the provided name already exists. |  -  |


## comAtlassianJiraRestV2IssueProjectRoleResourceDeleteProjectRoleDelete

> comAtlassianJiraRestV2IssueProjectRoleResourceDeleteProjectRoleDelete(id, swap)

Delete project role

Deletes a project role. You must specify a replacement project role if you wish to delete a project role that is in use.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectRolesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ProjectRolesApi apiInstance = new ProjectRolesApi(defaultClient);
        Long id = 56L; // Long | The ID of the project role to delete. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
        Long swap = 56L; // Long | The ID of the project role that will replace the one being deleted.
        try {
            apiInstance.comAtlassianJiraRestV2IssueProjectRoleResourceDeleteProjectRoleDelete(id, swap);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRolesApi#comAtlassianJiraRestV2IssueProjectRoleResourceDeleteProjectRoleDelete");
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
 **id** | **Long**| The ID of the project role to delete. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. |
 **swap** | **Long**| The ID of the project role that will replace the one being deleted. | [optional]

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid or if the replacement project role is not found. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have administrative permissions. |  -  |
| **404** | Returned if the project role being deleted is not found. |  -  |
| **409** | Returned if the project role being deleted is in use and a replacement project role is not specified in the request. |  -  |


## comAtlassianJiraRestV2IssueProjectRoleResourceFullyUpdateProjectRolePut

> ProjectRole comAtlassianJiraRestV2IssueProjectRoleResourceFullyUpdateProjectRolePut(id, createUpdateRoleRequestBean)

Fully update project role

Updates the project role&#39;s name and description. You must include both a name and a description in the request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectRolesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ProjectRolesApi apiInstance = new ProjectRolesApi(defaultClient);
        Long id = 56L; // Long | The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
        CreateUpdateRoleRequestBean createUpdateRoleRequestBean = {"name":"Developers","description":"A project role that represents developers in a project"}; // CreateUpdateRoleRequestBean | 
        try {
            ProjectRole result = apiInstance.comAtlassianJiraRestV2IssueProjectRoleResourceFullyUpdateProjectRolePut(id, createUpdateRoleRequestBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRolesApi#comAtlassianJiraRestV2IssueProjectRoleResourceFullyUpdateProjectRolePut");
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
 **id** | **Long**| The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. |
 **createUpdateRoleRequestBean** | [**CreateUpdateRoleRequestBean**](CreateUpdateRoleRequestBean.md)|  |

### Return type

[**ProjectRole**](ProjectRole.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is not valid. The &#x60;name&#x60; cannot be empty or start or end with whitespace. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have administrative permissions. |  -  |
| **404** | Returned if the project role is not found. |  -  |


## comAtlassianJiraRestV2IssueProjectRoleResourceGetAllProjectRolesGet

> List&lt;ProjectRole&gt; comAtlassianJiraRestV2IssueProjectRoleResourceGetAllProjectRolesGet()

Get all project roles

Gets a list of all project roles, complete with project role details and default actors.  ### About project roles ###  [Project roles](https://confluence.atlassian.com/x/3odKLg) are a flexible way to to associate users and groups with projects. In Jira Cloud, the list of project roles is shared globally with all projects, but each project can have a different set of actors associated with it (unlike groups, which have the same membership throughout all Jira applications).  Project roles are used in [permission schemes](#api-rest-api-3-permissionscheme-get), [email notification schemes](#api-rest-api-3-notificationscheme-get), [issue security levels](#api-rest-api-3-issuesecurityschemes-get), [comment visibility](#api-rest-api-3-comment-list-post), and workflow conditions.  #### Members and actors ####  In the Jira REST API, a member of a project role is called an *actor*. An *actor* is a group or user associated with a project role.  Actors may be set as [default members](https://confluence.atlassian.com/x/3odKLg#Managingprojectroles-Specifying&#39;defaultmembers&#39;foraprojectrole) of the project role or set at the project level:   *  Default actors: Users and groups that are assigned to the project role for all newly created projects. The default actors can be removed at the project level later if desired.  *  Actors: Users and groups that are associated with a project role for a project, which may differ from the default actors. This enables you to assign a user to different roles in different projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectRolesApi;

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

        ProjectRolesApi apiInstance = new ProjectRolesApi(defaultClient);
        try {
            List<ProjectRole> result = apiInstance.comAtlassianJiraRestV2IssueProjectRoleResourceGetAllProjectRolesGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRolesApi#comAtlassianJiraRestV2IssueProjectRoleResourceGetAllProjectRolesGet");
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

[**List&lt;ProjectRole&gt;**](ProjectRole.md)

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
| **403** | Returned if the user does not have administrative permissions. |  -  |


## comAtlassianJiraRestV2IssueProjectRoleResourceGetProjectRoleByIdGet

> ProjectRole comAtlassianJiraRestV2IssueProjectRoleResourceGetProjectRoleByIdGet(id)

Get project role by ID

Gets the project role details and the default actors associated with the role. The list of default actors is sorted by display name.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectRolesApi;

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

        ProjectRolesApi apiInstance = new ProjectRolesApi(defaultClient);
        Long id = 56L; // Long | The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
        try {
            ProjectRole result = apiInstance.comAtlassianJiraRestV2IssueProjectRoleResourceGetProjectRoleByIdGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRolesApi#comAtlassianJiraRestV2IssueProjectRoleResourceGetProjectRoleByIdGet");
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
 **id** | **Long**| The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. |

### Return type

[**ProjectRole**](ProjectRole.md)

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
| **403** | Returned if the user does not have administrative permissions. |  -  |
| **404** | Returned if the project role is not found. |  -  |


## comAtlassianJiraRestV2IssueProjectRoleResourcePartialUpdateProjectRolePost

> ProjectRole comAtlassianJiraRestV2IssueProjectRoleResourcePartialUpdateProjectRolePost(id, createUpdateRoleRequestBean)

Partial update project role

Updates either the project role&#39;s name or its description.  You cannot update both the name and description at the same time using this operation. If you send a request with a name and a description only the name is updated.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectRolesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ProjectRolesApi apiInstance = new ProjectRolesApi(defaultClient);
        Long id = 56L; // Long | The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
        CreateUpdateRoleRequestBean createUpdateRoleRequestBean = {"name":"Developers","description":"A project role that represents developers in a project"}; // CreateUpdateRoleRequestBean | 
        try {
            ProjectRole result = apiInstance.comAtlassianJiraRestV2IssueProjectRoleResourcePartialUpdateProjectRolePost(id, createUpdateRoleRequestBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRolesApi#comAtlassianJiraRestV2IssueProjectRoleResourcePartialUpdateProjectRolePost");
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
 **id** | **Long**| The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. |
 **createUpdateRoleRequestBean** | [**CreateUpdateRoleRequestBean**](CreateUpdateRoleRequestBean.md)|  |

### Return type

[**ProjectRole**](ProjectRole.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have administrative permissions. |  -  |
| **404** | Returned if the project role is not found. |  -  |

