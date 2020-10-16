# IssueLinkTypesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueIssueLinkTypeResourceCreateIssueLinkTypePost**](IssueLinkTypesApi.md#comAtlassianJiraRestV2IssueIssueLinkTypeResourceCreateIssueLinkTypePost) | **POST** /rest/api/3/issueLinkType | Create issue link type
[**comAtlassianJiraRestV2IssueIssueLinkTypeResourceDeleteIssueLinkTypeDelete**](IssueLinkTypesApi.md#comAtlassianJiraRestV2IssueIssueLinkTypeResourceDeleteIssueLinkTypeDelete) | **DELETE** /rest/api/3/issueLinkType/{issueLinkTypeId} | Delete issue link type
[**comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypeGet**](IssueLinkTypesApi.md#comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypeGet) | **GET** /rest/api/3/issueLinkType/{issueLinkTypeId} | Get issue link type
[**comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypesGet**](IssueLinkTypesApi.md#comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypesGet) | **GET** /rest/api/3/issueLinkType | Get issue link types
[**comAtlassianJiraRestV2IssueIssueLinkTypeResourceUpdateIssueLinkTypePut**](IssueLinkTypesApi.md#comAtlassianJiraRestV2IssueIssueLinkTypeResourceUpdateIssueLinkTypePut) | **PUT** /rest/api/3/issueLinkType/{issueLinkTypeId} | Update issue link type



## comAtlassianJiraRestV2IssueIssueLinkTypeResourceCreateIssueLinkTypePost

> IssueLinkType comAtlassianJiraRestV2IssueIssueLinkTypeResourceCreateIssueLinkTypePost(issueLinkType)

Create issue link type

Creates an issue link type. Use this operation to create descriptions of the reasons why issues are linked. The issue link type consists of a name and descriptions for a link&#39;s inward and outward relationships.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueLinkTypesApi;

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

        IssueLinkTypesApi apiInstance = new IssueLinkTypesApi(defaultClient);
        IssueLinkType issueLinkType = {"inward":"Duplicated by","name":"Duplicate","outward":"Duplicates"}; // IssueLinkType | 
        try {
            IssueLinkType result = apiInstance.comAtlassianJiraRestV2IssueIssueLinkTypeResourceCreateIssueLinkTypePost(issueLinkType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueLinkTypesApi#comAtlassianJiraRestV2IssueIssueLinkTypeResourceCreateIssueLinkTypePost");
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
 **issueLinkType** | [**IssueLinkType**](IssueLinkType.md)|  |

### Return type

[**IssueLinkType**](IssueLinkType.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  issue linking is disabled.  *  the issue link type name is in use.  *  the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueIssueLinkTypeResourceDeleteIssueLinkTypeDelete

> comAtlassianJiraRestV2IssueIssueLinkTypeResourceDeleteIssueLinkTypeDelete(issueLinkTypeId)

Delete issue link type

Deletes an issue link type.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueLinkTypesApi;

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

        IssueLinkTypesApi apiInstance = new IssueLinkTypesApi(defaultClient);
        String issueLinkTypeId = "issueLinkTypeId_example"; // String | The ID of the issue link type.
        try {
            apiInstance.comAtlassianJiraRestV2IssueIssueLinkTypeResourceDeleteIssueLinkTypeDelete(issueLinkTypeId);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueLinkTypesApi#comAtlassianJiraRestV2IssueIssueLinkTypeResourceDeleteIssueLinkTypeDelete");
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
 **issueLinkTypeId** | **String**| The ID of the issue link type. |

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
| **400** | Returned if the issue link type ID is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  issue linking is disabled.  *  the issue link type is not found.  *  the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypeGet

> IssueLinkType comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypeGet(issueLinkTypeId)

Get issue link type

Returns an issue link type.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for a project in the site.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueLinkTypesApi;

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

        IssueLinkTypesApi apiInstance = new IssueLinkTypesApi(defaultClient);
        String issueLinkTypeId = "issueLinkTypeId_example"; // String | The ID of the issue link type.
        try {
            IssueLinkType result = apiInstance.comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypeGet(issueLinkTypeId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueLinkTypesApi#comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypeGet");
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
 **issueLinkTypeId** | **String**| The ID of the issue link type. |

### Return type

[**IssueLinkType**](IssueLinkType.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the issue link type ID is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  issue linking is disabled.  *  the issue link type is not found.  *  the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypesGet

> IssueLinkTypes comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypesGet()

Get issue link types

Returns a list of all issue link types.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for a project in the site.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueLinkTypesApi;

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

        IssueLinkTypesApi apiInstance = new IssueLinkTypesApi(defaultClient);
        try {
            IssueLinkTypes result = apiInstance.comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypesGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueLinkTypesApi#comAtlassianJiraRestV2IssueIssueLinkTypeResourceGetIssueLinkTypesGet");
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

[**IssueLinkTypes**](IssueLinkTypes.md)

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
| **404** | Returned if issue linking is disabled. |  -  |


## comAtlassianJiraRestV2IssueIssueLinkTypeResourceUpdateIssueLinkTypePut

> IssueLinkType comAtlassianJiraRestV2IssueIssueLinkTypeResourceUpdateIssueLinkTypePut(issueLinkTypeId, issueLinkType)

Update issue link type

Updates an issue link type.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueLinkTypesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueLinkTypesApi apiInstance = new IssueLinkTypesApi(defaultClient);
        String issueLinkTypeId = "issueLinkTypeId_example"; // String | The ID of the issue link type.
        IssueLinkType issueLinkType = {"inward":"Duplicated by","name":"Duplicate","outward":"Duplicates"}; // IssueLinkType | 
        try {
            IssueLinkType result = apiInstance.comAtlassianJiraRestV2IssueIssueLinkTypeResourceUpdateIssueLinkTypePut(issueLinkTypeId, issueLinkType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueLinkTypesApi#comAtlassianJiraRestV2IssueIssueLinkTypeResourceUpdateIssueLinkTypePut");
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
 **issueLinkTypeId** | **String**| The ID of the issue link type. |
 **issueLinkType** | [**IssueLinkType**](IssueLinkType.md)|  |

### Return type

[**IssueLinkType**](IssueLinkType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the issue link type ID or the request body are invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  issue linking is disabled.  *  the issue link type is not found.  *  the user does not have the required permissions. |  -  |

