# IssueCommentPropertiesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueCommentPropertyResourceDeleteCommentPropertyDelete**](IssueCommentPropertiesApi.md#comAtlassianJiraRestV2IssueCommentPropertyResourceDeleteCommentPropertyDelete) | **DELETE** /rest/api/3/comment/{commentId}/properties/{propertyKey} | Delete comment property
[**comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyGet**](IssueCommentPropertiesApi.md#comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyGet) | **GET** /rest/api/3/comment/{commentId}/properties/{propertyKey} | Get comment property
[**comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyKeysGet**](IssueCommentPropertiesApi.md#comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyKeysGet) | **GET** /rest/api/3/comment/{commentId}/properties | Get comment property keys
[**comAtlassianJiraRestV2IssueCommentPropertyResourceSetCommentPropertyPut**](IssueCommentPropertiesApi.md#comAtlassianJiraRestV2IssueCommentPropertyResourceSetCommentPropertyPut) | **PUT** /rest/api/3/comment/{commentId}/properties/{propertyKey} | Set comment property



## comAtlassianJiraRestV2IssueCommentPropertyResourceDeleteCommentPropertyDelete

> comAtlassianJiraRestV2IssueCommentPropertyResourceDeleteCommentPropertyDelete(commentId, propertyKey)

Delete comment property

Deletes a comment property.  **[Permissions](#permissions) required:** either of:   *  *Edit All Comments* [project permission](https://confluence.atlassian.com/x/yodKLg) to delete a property from any comment.  *  *Edit Own Comments* [project permission](https://confluence.atlassian.com/x/yodKLg) to delete a property from a comment created by the user.  Also, when the visibility of a comment is restricted to a role or group the user must be a member of that role or group.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCommentPropertiesApi;

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

        IssueCommentPropertiesApi apiInstance = new IssueCommentPropertiesApi(defaultClient);
        String commentId = "commentId_example"; // String | The ID of the comment.
        String propertyKey = "propertyKey_example"; // String | The key of the property.
        try {
            apiInstance.comAtlassianJiraRestV2IssueCommentPropertyResourceDeleteCommentPropertyDelete(commentId, propertyKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCommentPropertiesApi#comAtlassianJiraRestV2IssueCommentPropertyResourceDeleteCommentPropertyDelete");
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
 **commentId** | **String**| The ID of the comment. |
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
| **204** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the comment or the property is not found or the user has the necessary project permissions but isn&#39;t a member of the role or group visibility of the comment is restricted to. |  -  |


## comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyGet

> EntityProperty comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyGet(commentId, propertyKey)

Get comment property

Returns the value of a comment property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCommentPropertiesApi;

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

        IssueCommentPropertiesApi apiInstance = new IssueCommentPropertiesApi(defaultClient);
        String commentId = "commentId_example"; // String | The ID of the comment.
        String propertyKey = "propertyKey_example"; // String | The key of the property.
        try {
            EntityProperty result = apiInstance.comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyGet(commentId, propertyKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCommentPropertiesApi#comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyGet");
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
 **commentId** | **String**| The ID of the comment. |
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
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the comment or the property is not found. |  -  |


## comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyKeysGet

> PropertyKeys comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyKeysGet(commentId)

Get comment property keys

Returns the keys of all the properties of a comment.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCommentPropertiesApi;

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

        IssueCommentPropertiesApi apiInstance = new IssueCommentPropertiesApi(defaultClient);
        String commentId = "commentId_example"; // String | The ID of the comment.
        try {
            PropertyKeys result = apiInstance.comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyKeysGet(commentId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCommentPropertiesApi#comAtlassianJiraRestV2IssueCommentPropertyResourceGetCommentPropertyKeysGet");
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
 **commentId** | **String**| The ID of the comment. |

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
| **400** | Returned if the comment ID is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the comment is not found. |  -  |


## comAtlassianJiraRestV2IssueCommentPropertyResourceSetCommentPropertyPut

> Object comAtlassianJiraRestV2IssueCommentPropertyResourceSetCommentPropertyPut(commentId, propertyKey, body)

Set comment property

Creates or updates the value of a property for a comment. Use this resource to store custom data against a comment.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  **[Permissions](#permissions) required:** either of:   *  *Edit All Comments* [project permission](https://confluence.atlassian.com/x/yodKLg) to create or update the value of a property on any comment.  *  *Edit Own Comments* [project permission](https://confluence.atlassian.com/x/yodKLg) to create or update the value of a property on a comment created by the user.  Also, when the visibility of a comment is restricted to a role or group the user must be a member of that role or group.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCommentPropertiesApi;

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

        IssueCommentPropertiesApi apiInstance = new IssueCommentPropertiesApi(defaultClient);
        String commentId = "commentId_example"; // String | The ID of the comment.
        String propertyKey = "propertyKey_example"; // String | The key of the property. The maximum length is 255 characters.
        Object body = null; // Object | 
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueCommentPropertyResourceSetCommentPropertyPut(commentId, propertyKey, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCommentPropertiesApi#comAtlassianJiraRestV2IssueCommentPropertyResourceSetCommentPropertyPut");
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
 **commentId** | **String**| The ID of the comment. |
 **propertyKey** | **String**| The key of the property. The maximum length is 255 characters. |
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
| **200** | Returned if the comment property is updated. |  -  |
| **201** | Returned if the comment property is created. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the comment is not found. |  -  |

