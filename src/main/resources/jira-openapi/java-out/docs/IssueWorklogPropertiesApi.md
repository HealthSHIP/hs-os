# IssueWorklogPropertiesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueWorklogPropertyResourceDeleteWorklogPropertyDelete**](IssueWorklogPropertiesApi.md#comAtlassianJiraRestV2IssueWorklogPropertyResourceDeleteWorklogPropertyDelete) | **DELETE** /rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey} | Delete worklog property
[**comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyGet**](IssueWorklogPropertiesApi.md#comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyGet) | **GET** /rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey} | Get worklog property
[**comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyKeysGet**](IssueWorklogPropertiesApi.md#comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyKeysGet) | **GET** /rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties | Get worklog property keys
[**comAtlassianJiraRestV2IssueWorklogPropertyResourceSetWorklogPropertyPut**](IssueWorklogPropertiesApi.md#comAtlassianJiraRestV2IssueWorklogPropertyResourceSetWorklogPropertyPut) | **PUT** /rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey} | Set worklog property



## comAtlassianJiraRestV2IssueWorklogPropertyResourceDeleteWorklogPropertyDelete

> comAtlassianJiraRestV2IssueWorklogPropertyResourceDeleteWorklogPropertyDelete(issueIdOrKey, worklogId, propertyKey)

Delete worklog property

Deletes a worklog property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueWorklogPropertiesApi;

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

        IssueWorklogPropertiesApi apiInstance = new IssueWorklogPropertiesApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        String worklogId = "worklogId_example"; // String | The ID of the worklog.
        String propertyKey = "propertyKey_example"; // String | The key of the property.
        try {
            apiInstance.comAtlassianJiraRestV2IssueWorklogPropertyResourceDeleteWorklogPropertyDelete(issueIdOrKey, worklogId, propertyKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogPropertiesApi#comAtlassianJiraRestV2IssueWorklogPropertyResourceDeleteWorklogPropertyDelete");
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
 **issueIdOrKey** | **String**| The ID or key of the issue. |
 **worklogId** | **String**| The ID of the worklog. |
 **propertyKey** | **String**| The key of the property. |

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
| **204** | Returned if the worklog property is removed. |  -  |
| **400** | Returned if the worklog key or id is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to edit the worklog. |  -  |
| **404** | Returned if:   *  the issue, worklog, or property is not found.  *  the user does not have permission to view the issue or worklog. |  -  |


## comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyGet

> EntityProperty comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyGet(issueIdOrKey, worklogId, propertyKey)

Get worklog property

Returns the value of a worklog property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueWorklogPropertiesApi;

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

        IssueWorklogPropertiesApi apiInstance = new IssueWorklogPropertiesApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        String worklogId = "worklogId_example"; // String | The ID of the worklog.
        String propertyKey = "propertyKey_example"; // String | The key of the property.
        try {
            EntityProperty result = apiInstance.comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyGet(issueIdOrKey, worklogId, propertyKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogPropertiesApi#comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyGet");
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
 **issueIdOrKey** | **String**| The ID or key of the issue. |
 **worklogId** | **String**| The ID of the worklog. |
 **propertyKey** | **String**| The key of the property. |

### Return type

[**EntityProperty**](EntityProperty.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the worklog ID is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  the issue, worklog, or property is not found.  *  the user does not have permission to view the issue or worklog. |  -  |


## comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyKeysGet

> PropertyKeys comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyKeysGet(issueIdOrKey, worklogId)

Get worklog property keys

Returns the keys of all properties for a worklog.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueWorklogPropertiesApi;

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

        IssueWorklogPropertiesApi apiInstance = new IssueWorklogPropertiesApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        String worklogId = "worklogId_example"; // String | The ID of the worklog.
        try {
            PropertyKeys result = apiInstance.comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyKeysGet(issueIdOrKey, worklogId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogPropertiesApi#comAtlassianJiraRestV2IssueWorklogPropertyResourceGetWorklogPropertyKeysGet");
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
 **issueIdOrKey** | **String**| The ID or key of the issue. |
 **worklogId** | **String**| The ID of the worklog. |

### Return type

[**PropertyKeys**](PropertyKeys.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the worklog ID is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  the issue or worklog is not found.  *  the user does not have permission to view the issue or worklog. |  -  |


## comAtlassianJiraRestV2IssueWorklogPropertyResourceSetWorklogPropertyPut

> Object comAtlassianJiraRestV2IssueWorklogPropertyResourceSetWorklogPropertyPut(issueIdOrKey, worklogId, propertyKey, body)

Set worklog property

Sets the value of a worklog property. Use this operation to store custom data against the worklog.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Edit all worklogs*[ project permission](https://confluence.atlassian.com/x/yodKLg) to update any worklog or *Edit own worklogs* to update worklogs created by the user.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueWorklogPropertiesApi;

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

        IssueWorklogPropertiesApi apiInstance = new IssueWorklogPropertiesApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        String worklogId = "worklogId_example"; // String | The ID of the worklog.
        String propertyKey = "propertyKey_example"; // String | The key of the issue property. The maximum length is 255 characters.
        Object body = null; // Object | 
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueWorklogPropertyResourceSetWorklogPropertyPut(issueIdOrKey, worklogId, propertyKey, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogPropertiesApi#comAtlassianJiraRestV2IssueWorklogPropertyResourceSetWorklogPropertyPut");
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
 **issueIdOrKey** | **String**| The ID or key of the issue. |
 **worklogId** | **String**| The ID of the worklog. |
 **propertyKey** | **String**| The key of the issue property. The maximum length is 255 characters. |
 **body** | **Object**|  |

### Return type

**Object**

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the worklog property is updated. |  -  |
| **201** | Returned if the worklog property is created. |  -  |
| **400** | Returned if the worklog ID is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to edit the worklog. |  -  |
| **404** | Returned if:   *  the issue or worklog is not found.  *  the user does not have permission to view the issue or worklog. |  -  |

