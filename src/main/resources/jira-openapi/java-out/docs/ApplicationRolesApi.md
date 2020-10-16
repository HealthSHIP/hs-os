# ApplicationRolesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetAllApplicationRolesGet**](ApplicationRolesApi.md#comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetAllApplicationRolesGet) | **GET** /rest/api/3/applicationrole | Get all application roles
[**comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetApplicationRoleGet**](ApplicationRolesApi.md#comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetApplicationRoleGet) | **GET** /rest/api/3/applicationrole/{key} | Get application role



## comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetAllApplicationRolesGet

> List&lt;ApplicationRole&gt; comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetAllApplicationRolesGet()

Get all application roles

Returns all application roles. In Jira, application roles are managed using the [Application access configuration](https://confluence.atlassian.com/x/3YxjL) page.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ApplicationRolesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ApplicationRolesApi apiInstance = new ApplicationRolesApi(defaultClient);
        try {
            List<ApplicationRole> result = apiInstance.comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetAllApplicationRolesGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationRolesApi#comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetAllApplicationRolesGet");
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

[**List&lt;ApplicationRole&gt;**](ApplicationRole.md)

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
| **403** | Returned if the user is not an administrator. |  -  |


## comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetApplicationRoleGet

> ApplicationRole comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetApplicationRoleGet(key)

Get application role

Returns an application role.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ApplicationRolesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ApplicationRolesApi apiInstance = new ApplicationRolesApi(defaultClient);
        String key = jira-software; // String | The key of the application role. Use the [Get all application roles](#api-rest-api-3-applicationrole-get) operation to get the key for each application role.
        try {
            ApplicationRole result = apiInstance.comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetApplicationRoleGet(key);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationRolesApi#comAtlassianJiraRestV2AdminApplicationroleApplicationRoleResourceGetApplicationRoleGet");
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
 **key** | **String**| The key of the application role. Use the [Get all application roles](#api-rest-api-3-applicationrole-get) operation to get the key for each application role. |

### Return type

[**ApplicationRole**](ApplicationRole.md)

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
| **403** | Returned if the user is not an administrator. |  -  |
| **404** | Returned if the role is not found. |  -  |

