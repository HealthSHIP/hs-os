# IssueTypePropertiesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueIssueTypePropertyResourceDeleteIssueTypePropertyDelete**](IssueTypePropertiesApi.md#comAtlassianJiraRestV2IssueIssueTypePropertyResourceDeleteIssueTypePropertyDelete) | **DELETE** /rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey} | Delete issue type property
[**comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyGet**](IssueTypePropertiesApi.md#comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyGet) | **GET** /rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey} | Get issue type property
[**comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyKeysGet**](IssueTypePropertiesApi.md#comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyKeysGet) | **GET** /rest/api/3/issuetype/{issueTypeId}/properties | Get issue type property keys
[**comAtlassianJiraRestV2IssueIssueTypePropertyResourceSetIssueTypePropertyPut**](IssueTypePropertiesApi.md#comAtlassianJiraRestV2IssueIssueTypePropertyResourceSetIssueTypePropertyPut) | **PUT** /rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey} | Set issue type property



## comAtlassianJiraRestV2IssueIssueTypePropertyResourceDeleteIssueTypePropertyDelete

> comAtlassianJiraRestV2IssueIssueTypePropertyResourceDeleteIssueTypePropertyDelete(issueTypeId, propertyKey)

Delete issue type property

Deletes the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypePropertiesApi;

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

        IssueTypePropertiesApi apiInstance = new IssueTypePropertiesApi(defaultClient);
        String issueTypeId = "issueTypeId_example"; // String | The ID of the issue type.
        String propertyKey = "propertyKey_example"; // String | The key of the property. Use [Get issue type property keys](#api-rest-api-3-issuetype-issueTypeId-properties-get) to get a list of all issue type property keys.
        try {
            apiInstance.comAtlassianJiraRestV2IssueIssueTypePropertyResourceDeleteIssueTypePropertyDelete(issueTypeId, propertyKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypePropertiesApi#comAtlassianJiraRestV2IssueIssueTypePropertyResourceDeleteIssueTypePropertyDelete");
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
 **issueTypeId** | **String**| The ID of the issue type. |
 **propertyKey** | **String**| The key of the property. Use [Get issue type property keys](#api-rest-api-3-issuetype-issueTypeId-properties-get) to get a list of all issue type property keys. |

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
| **204** | Returned if the issue type property is deleted. |  -  |
| **400** | Returned if the issue type ID is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the issue type or property is not found. |  -  |


## comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyGet

> EntityProperty comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyGet(issueTypeId, propertyKey)

Get issue type property

Returns the key and value of the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to get the details of any issue type.  *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) to get the details of any issue types associated with the projects the user has permission to browse.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypePropertiesApi;

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

        IssueTypePropertiesApi apiInstance = new IssueTypePropertiesApi(defaultClient);
        String issueTypeId = "issueTypeId_example"; // String | The ID of the issue type.
        String propertyKey = "propertyKey_example"; // String | The key of the property. Use [Get issue type property keys](#api-rest-api-3-issuetype-issueTypeId-properties-get) to get a list of all issue type property keys.
        try {
            EntityProperty result = apiInstance.comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyGet(issueTypeId, propertyKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypePropertiesApi#comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyGet");
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
 **issueTypeId** | **String**| The ID of the issue type. |
 **propertyKey** | **String**| The key of the property. Use [Get issue type property keys](#api-rest-api-3-issuetype-issueTypeId-properties-get) to get a list of all issue type property keys. |

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
| **400** | Returned if the issue type ID is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the issue type or property is not found or the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyKeysGet

> PropertyKeys comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyKeysGet(issueTypeId)

Get issue type property keys

Returns all the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties) keys of the issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to get the property keys of any issue type.  *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) to get the property keys of any issue types associated with the projects the user has permission to browse.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypePropertiesApi;

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

        IssueTypePropertiesApi apiInstance = new IssueTypePropertiesApi(defaultClient);
        String issueTypeId = "issueTypeId_example"; // String | The ID of the issue type.
        try {
            PropertyKeys result = apiInstance.comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyKeysGet(issueTypeId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypePropertiesApi#comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyKeysGet");
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
 **issueTypeId** | **String**| The ID of the issue type. |

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
| **400** | Returned if the issue type ID is invalid. |  -  |
| **404** | Returned if:   *  the issue type is not found.  *  the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueIssueTypePropertyResourceSetIssueTypePropertyPut

> Object comAtlassianJiraRestV2IssueIssueTypePropertyResourceSetIssueTypePropertyPut(issueTypeId, propertyKey, body)

Set issue type property

Creates or updates the value of the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties). Use this resource to store and update data against an issue type.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypePropertiesApi;

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

        IssueTypePropertiesApi apiInstance = new IssueTypePropertiesApi(defaultClient);
        String issueTypeId = "issueTypeId_example"; // String | The ID of the issue type.
        String propertyKey = "propertyKey_example"; // String | The key of the issue type property. The maximum length is 255 characters.
        Object body = {"number":5,"string":"string-value"}; // Object | 
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueIssueTypePropertyResourceSetIssueTypePropertyPut(issueTypeId, propertyKey, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypePropertiesApi#comAtlassianJiraRestV2IssueIssueTypePropertyResourceSetIssueTypePropertyPut");
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
 **issueTypeId** | **String**| The ID of the issue type. |
 **propertyKey** | **String**| The key of the issue type property. The maximum length is 255 characters. |
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
| **200** | Returned if the issue type property is updated. |  -  |
| **201** | Returned if the issue type property is created. |  -  |
| **400** | Returned if:   *  the issue type ID is invalid.  *  a property value is not provided.  *  the property value JSON content is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to modify the issue type. |  -  |
| **404** | Returned if:   *  the issue type is not found.  *  the user does not have the permission view the issue type. |  -  |

