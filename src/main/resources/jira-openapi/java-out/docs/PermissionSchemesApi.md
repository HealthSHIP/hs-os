# PermissionSchemesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionGrantPost**](PermissionSchemesApi.md#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionGrantPost) | **POST** /rest/api/3/permissionscheme/{schemeId}/permission | Create permission grant
[**comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionSchemePost**](PermissionSchemesApi.md#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionSchemePost) | **POST** /rest/api/3/permissionscheme | Create permission scheme
[**comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeDelete**](PermissionSchemesApi.md#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeDelete) | **DELETE** /rest/api/3/permissionscheme/{schemeId} | Delete permission scheme
[**comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeEntityDelete**](PermissionSchemesApi.md#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeEntityDelete) | **DELETE** /rest/api/3/permissionscheme/{schemeId}/permission/{permissionId} | Delete permission scheme grant
[**comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetAllPermissionSchemesGet**](PermissionSchemesApi.md#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetAllPermissionSchemesGet) | **GET** /rest/api/3/permissionscheme | Get all permission schemes
[**comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGet**](PermissionSchemesApi.md#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGet) | **GET** /rest/api/3/permissionscheme/{schemeId} | Get permission scheme
[**comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantGet**](PermissionSchemesApi.md#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantGet) | **GET** /rest/api/3/permissionscheme/{schemeId}/permission/{permissionId} | Get permission scheme grant
[**comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantsGet**](PermissionSchemesApi.md#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantsGet) | **GET** /rest/api/3/permissionscheme/{schemeId}/permission | Get permission scheme grants
[**comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceUpdatePermissionSchemePut**](PermissionSchemesApi.md#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceUpdatePermissionSchemePut) | **PUT** /rest/api/3/permissionscheme/{schemeId} | Update permission scheme



## comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionGrantPost

> PermissionGrant comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionGrantPost(schemeId, permissionGrant, expand)

Create permission grant

Creates a permission grant in a permission scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionSchemesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        PermissionSchemesApi apiInstance = new PermissionSchemesApi(defaultClient);
        Long schemeId = 56L; // Long | The ID of the permission scheme in which to create a new permission grant.
        PermissionGrant permissionGrant = {"holder":{"parameter":"jira-core-users","type":"group"},"permission":"ADMINISTER_PROJECTS"}; // PermissionGrant | The permission grant to create.
        String expand = "expand_example"; // String | Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  `permissions` Returns all permission grants for each permission scheme.  *  `user` Returns information about the user who is granted the permission.  *  `group` Returns information about the group that is granted the permission.  *  `projectRole` Returns information about the project role granted the permission.  *  `field` Returns information about the custom field granted the permission.  *  `all` Returns all expandable information.
        try {
            PermissionGrant result = apiInstance.comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionGrantPost(schemeId, permissionGrant, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionSchemesApi#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionGrantPost");
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
 **schemeId** | **Long**| The ID of the permission scheme in which to create a new permission grant. |
 **permissionGrant** | [**PermissionGrant**](PermissionGrant.md)| The permission grant to create. |
 **expand** | **String**| Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;all&#x60; Returns all expandable information. | [optional]

### Return type

[**PermissionGrant**](PermissionGrant.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the scheme permission is created. |  -  |
| **400** | Returned if the value for expand is invalid or the same permission grant is present. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionSchemePost

> PermissionScheme comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionSchemePost(requestBody, expand)

Create permission scheme

Creates a new permission scheme. You can create a permission scheme with or without defining a set of permission grants.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionSchemesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        PermissionSchemesApi apiInstance = new PermissionSchemesApi(defaultClient);
        Map<String, Object> requestBody = {"permissions":[{"holder":{"parameter":"jira-core-users","type":"group"},"permission":"ADMINISTER_PROJECTS"}],"name":"Example permission scheme","description":"description"}; // Map<String, Object> | The permission scheme to create.
        String expand = "expand_example"; // String | Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  `all` Returns all expandable information.  *  `field` Returns information about the custom field granted the permission.  *  `group` Returns information about the group that is granted the permission.  *  `permissions` Returns all permission grants for each permission scheme.  *  `projectRole` Returns information about the project role granted the permission.  *  `user` Returns information about the user who is granted the permission.
        try {
            PermissionScheme result = apiInstance.comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionSchemePost(requestBody, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionSchemesApi#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceCreatePermissionSchemePost");
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
 **requestBody** | [**Map&lt;String, Object&gt;**](Object.md)| The permission scheme to create. |
 **expand** | **String**| Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission. | [optional]

### Return type

[**PermissionScheme**](PermissionScheme.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the permission scheme is created. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeDelete

> comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeDelete(schemeId)

Delete permission scheme

Deletes a permission scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionSchemesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        PermissionSchemesApi apiInstance = new PermissionSchemesApi(defaultClient);
        Long schemeId = 56L; // Long | The ID of the permission scheme being deleted.
        try {
            apiInstance.comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeDelete(schemeId);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionSchemesApi#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeDelete");
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
 **schemeId** | **Long**| The ID of the permission scheme being deleted. |

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
| **204** | Returned if the permission scheme is deleted. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the permission scheme is not found. |  -  |


## comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeEntityDelete

> comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeEntityDelete(schemeId, permissionId)

Delete permission scheme grant

Deletes a permission grant from a permission scheme. See [About permission schemes and grants](#about-permission-schemes) for more details.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionSchemesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        PermissionSchemesApi apiInstance = new PermissionSchemesApi(defaultClient);
        Long schemeId = 56L; // Long | The ID of the permission scheme to delete the permission grant from.
        Long permissionId = 56L; // Long | The ID of the permission grant to delete.
        try {
            apiInstance.comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeEntityDelete(schemeId, permissionId);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionSchemesApi#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceDeletePermissionSchemeEntityDelete");
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
 **schemeId** | **Long**| The ID of the permission scheme to delete the permission grant from. |
 **permissionId** | **Long**| The ID of the permission grant to delete. |

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
| **204** | Returned if the permission grant is deleted. |  -  |
| **400** | Returned if permission grant with the provided ID is not found. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetAllPermissionSchemesGet

> PermissionSchemes comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetAllPermissionSchemesGet(expand)

Get all permission schemes

Returns all permission schemes.  ### About permission schemes and grants ###  A permission scheme is a collection of permission grants. A permission grant consists of a &#x60;holder&#x60; and a &#x60;permission&#x60;.  #### Holder object ####  The &#x60;holder&#x60; object contains information about the user or group being granted the permission. For example, the *Administer projects* permission is granted to a group named *Teams in space administrators*. In this case, the type is &#x60;\&quot;type\&quot;: \&quot;group\&quot;&#x60;, and the parameter is the group name, &#x60;\&quot;parameter\&quot;: \&quot;Teams in space administrators\&quot;&#x60;. The &#x60;holder&#x60; object is defined by the following properties:   *  &#x60;type&#x60; Identifies the user or group (see the list of types below).  *  &#x60;parameter&#x60; The value of this property depends on the &#x60;type&#x60;. For example, if the &#x60;type&#x60; is a group, then you need to specify the group name.  The following &#x60;types&#x60; are available. The expected values for the &#x60;parameter&#x60; are given in parenthesis (some &#x60;types&#x60; may not have a &#x60;parameter&#x60;):   *  &#x60;anyone&#x60; Grant for anonymous users.  *  &#x60;applicationRole&#x60; Grant for users with access to the specified application (application name). See [Update product access settings](https://confluence.atlassian.com/x/3YxjL) for more information.  *  &#x60;assignee&#x60; Grant for the user currently assigned to an issue.  *  &#x60;group&#x60; Grant for the specified group (group name).  *  &#x60;groupCustomField&#x60; Grant for a user in the group selected in the specified custom field (custom field ID).  *  &#x60;projectLead&#x60; Grant for a project lead.  *  &#x60;projectRole&#x60; Grant for the specified project role (project role ID).  *  &#x60;reporter&#x60; Grant for the user who reported the issue.  *  &#x60;sd.customer.portal.only&#x60; Jira Service Desk only. Grants customers permission to access the customer portal but not Jira. See [Customizing Jira Service Desk permissions](https://confluence.atlassian.com/x/24dKLg) for more information.  *  &#x60;user&#x60; Grant for the specified user (user ID - historically this was the userkey but that is deprecated and the account ID should be used).  *  &#x60;userCustomField&#x60; Grant for a user selected in the specified custom field (custom field ID).  #### Built-in permissions ####  The [built-in Jira permissions](https://confluence.atlassian.com/x/yodKLg) are listed below. Apps can also define custom permissions. See the [project permission](https://developer.atlassian.com/cloud/jira/platform/modules/project-permission/) and [global permission](https://developer.atlassian.com/cloud/jira/platform/modules/global-permission/) module documentation for more information.  **Project permissions**   *  &#x60;ADMINISTER_PROJECTS&#x60;  *  &#x60;BROWSE_PROJECTS&#x60;  *  &#x60;MANAGE_SPRINTS_PERMISSION&#x60; (Jira Software only)  *  &#x60;SERVICEDESK_AGENT&#x60; (Jira Service Desk only)  *  &#x60;VIEW_DEV_TOOLS&#x60; (Jira Software only)  *  &#x60;VIEW_READONLY_WORKFLOW&#x60;  **Issue permissions**   *  &#x60;ASSIGNABLE_USER&#x60;  *  &#x60;ASSIGN_ISSUES&#x60;  *  &#x60;CLOSE_ISSUES&#x60;  *  &#x60;CREATE_ISSUES&#x60;  *  &#x60;DELETE_ISSUES&#x60;  *  &#x60;EDIT_ISSUES&#x60;  *  &#x60;LINK_ISSUES&#x60;  *  &#x60;MODIFY_REPORTER&#x60;  *  &#x60;MOVE_ISSUES&#x60;  *  &#x60;RESOLVE_ISSUES&#x60;  *  &#x60;SCHEDULE_ISSUES&#x60;  *  &#x60;SET_ISSUE_SECURITY&#x60;  *  &#x60;TRANSITION_ISSUES&#x60;  **Voters and watchers permissions**   *  &#x60;MANAGE_WATCHERS&#x60;  *  &#x60;VIEW_VOTERS_AND_WATCHERS&#x60;  **Comments permissions**   *  &#x60;ADD_COMMENTS&#x60;  *  &#x60;DELETE_ALL_COMMENTS&#x60;  *  &#x60;DELETE_OWN_COMMENTS&#x60;  *  &#x60;EDIT_ALL_COMMENTS&#x60;  *  &#x60;EDIT_OWN_COMMENTS&#x60;  **Attachments permissions**   *  &#x60;CREATE_ATTACHMENTS&#x60;  *  &#x60;DELETE_ALL_ATTACHMENTS&#x60;  *  &#x60;DELETE_OWN_ATTACHMENTS&#x60;  **Time tracking permissions**   *  &#x60;DELETE_ALL_WORKLOGS&#x60;  *  &#x60;DELETE_OWN_WORKLOGS&#x60;  *  &#x60;EDIT_ALL_WORKLOGS&#x60;  *  &#x60;EDIT_OWN_WORKLOGS&#x60;  *  &#x60;WORK_ON_ISSUES&#x60;  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionSchemesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        PermissionSchemesApi apiInstance = new PermissionSchemesApi(defaultClient);
        String expand = "expand_example"; // String | Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are included when you specify any value. Expand options include:   *  `all` Returns all expandable information.  *  `field` Returns information about the custom field granted the permission.  *  `group` Returns information about the group that is granted the permission.  *  `permissions` Returns all permission grants for each permission scheme.  *  `projectRole` Returns information about the project role granted the permission.  *  `user` Returns information about the user who is granted the permission.
        try {
            PermissionSchemes result = apiInstance.comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetAllPermissionSchemesGet(expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionSchemesApi#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetAllPermissionSchemesGet");
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
 **expand** | **String**| Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission. | [optional]

### Return type

[**PermissionSchemes**](PermissionSchemes.md)

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


## comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGet

> PermissionScheme comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGet(schemeId, expand)

Get permission scheme

Returns a permission scheme.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionSchemesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        PermissionSchemesApi apiInstance = new PermissionSchemesApi(defaultClient);
        Long schemeId = 56L; // Long | The ID of the permission scheme to return.
        String expand = "expand_example"; // String | Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are included when you specify any value. Expand options include:   *  `all` Returns all expandable information.  *  `field` Returns information about the custom field granted the permission.  *  `group` Returns information about the group that is granted the permission.  *  `permissions` Returns all permission grants for each permission scheme.  *  `projectRole` Returns information about the project role granted the permission.  *  `user` Returns information about the user who is granted the permission.
        try {
            PermissionScheme result = apiInstance.comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGet(schemeId, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionSchemesApi#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGet");
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
 **schemeId** | **Long**| The ID of the permission scheme to return. |
 **expand** | **String**| Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission. | [optional]

### Return type

[**PermissionScheme**](PermissionScheme.md)

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
| **404** | Returned if the permission scheme is not found or the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantGet

> PermissionGrant comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantGet(schemeId, permissionId, expand)

Get permission scheme grant

Returns a permission grant.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionSchemesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        PermissionSchemesApi apiInstance = new PermissionSchemesApi(defaultClient);
        Long schemeId = 56L; // Long | The ID of the permission scheme.
        Long permissionId = 56L; // Long | The ID of the permission grant.
        String expand = "expand_example"; // String | Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  `all` Returns all expandable information.  *  `field` Returns information about the custom field granted the permission.  *  `group` Returns information about the group that is granted the permission.  *  `permissions` Returns all permission grants for each permission scheme.  *  `projectRole` Returns information about the project role granted the permission.  *  `user` Returns information about the user who is granted the permission.
        try {
            PermissionGrant result = apiInstance.comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantGet(schemeId, permissionId, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionSchemesApi#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantGet");
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
 **schemeId** | **Long**| The ID of the permission scheme. |
 **permissionId** | **Long**| The ID of the permission grant. |
 **expand** | **String**| Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission. | [optional]

### Return type

[**PermissionGrant**](PermissionGrant.md)

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
| **404** | Returned if the permission scheme or permission grant is not found or the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantsGet

> PermissionGrants comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantsGet(schemeId, expand)

Get permission scheme grants

Returns all permission grants for a permission scheme.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionSchemesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        PermissionSchemesApi apiInstance = new PermissionSchemesApi(defaultClient);
        Long schemeId = 56L; // Long | The ID of the permission scheme.
        String expand = "expand_example"; // String | Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  `permissions` Returns all permission grants for each permission scheme.  *  `user` Returns information about the user who is granted the permission.  *  `group` Returns information about the group that is granted the permission.  *  `projectRole` Returns information about the project role granted the permission.  *  `field` Returns information about the custom field granted the permission.  *  `all` Returns all expandable information.
        try {
            PermissionGrants result = apiInstance.comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantsGet(schemeId, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionSchemesApi#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceGetPermissionSchemeGrantsGet");
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
 **schemeId** | **Long**| The ID of the permission scheme. |
 **expand** | **String**| Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;all&#x60; Returns all expandable information. | [optional]

### Return type

[**PermissionGrants**](PermissionGrants.md)

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
| **404** | Returned if the permission schemes is not found or the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceUpdatePermissionSchemePut

> PermissionScheme comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceUpdatePermissionSchemePut(schemeId, requestBody, expand)

Update permission scheme

Updates a permission scheme. Below are some important things to note when using this resource:   *  If a permissions list is present in the request, then it is set in the permission scheme, overwriting *all existing* grants.  *  If you want to update only the name and description, then do not send a permissions list in the request.  *  Sending an empty list will remove all permission grants from the permission scheme.  If you want to add or delete a permission grant instead of updating the whole list, see [Create permission grant](#api-rest-api-3-permissionscheme-schemeId-permission-post) or [Delete permission scheme entity](#api-rest-api-3-permissionscheme-schemeId-permission-permissionId-delete).  See [About permission schemes and grants](#about-permission-schemes) for more details.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.PermissionSchemesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        PermissionSchemesApi apiInstance = new PermissionSchemesApi(defaultClient);
        Long schemeId = 56L; // Long | The ID of the permission scheme to update.
        Map<String, Object> requestBody = {"permissions":[{"holder":{"parameter":"jira-core-users","type":"group"},"permission":"ADMINISTER_PROJECTS"}],"name":"Example permission scheme","description":"description"}; // Map<String, Object> | 
        String expand = "expand_example"; // String | Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  `all` Returns all expandable information.  *  `field` Returns information about the custom field granted the permission.  *  `group` Returns information about the group that is granted the permission.  *  `permissions` Returns all permission grants for each permission scheme.  *  `projectRole` Returns information about the project role granted the permission.  *  `user` Returns information about the user who is granted the permission.
        try {
            PermissionScheme result = apiInstance.comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceUpdatePermissionSchemePut(schemeId, requestBody, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PermissionSchemesApi#comAtlassianJiraRestV2AdminPermissionschemePermissionSchemeResourceUpdatePermissionSchemePut");
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
 **schemeId** | **Long**| The ID of the permission scheme to update. |
 **requestBody** | [**Map&lt;String, Object&gt;**](Object.md)|  |
 **expand** | **String**| Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission. | [optional]

### Return type

[**PermissionScheme**](PermissionScheme.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the scheme is updated. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if:   *  the user does not have the necessary permission to update permission schemes.  *  the Jira instance is Jira Core Free or Jira Software Free. Permission schemes cannot be updated on free plans. |  -  |
| **404** | Returned if the permission scheme is not found. |  -  |

