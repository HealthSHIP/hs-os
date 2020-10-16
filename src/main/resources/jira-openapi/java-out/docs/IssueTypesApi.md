# IssueTypesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypeAvatarPost**](IssueTypesApi.md#comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypeAvatarPost) | **POST** /rest/api/3/issuetype/{id}/avatar2 | Load issue type avatar
[**comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypePost**](IssueTypesApi.md#comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypePost) | **POST** /rest/api/3/issuetype | Create issue type
[**comAtlassianJiraRestV2IssueIssueTypeResourceDeleteIssueTypeDelete**](IssueTypesApi.md#comAtlassianJiraRestV2IssueIssueTypeResourceDeleteIssueTypeDelete) | **DELETE** /rest/api/3/issuetype/{id} | Delete issue type
[**comAtlassianJiraRestV2IssueIssueTypeResourceGetAlternativeIssueTypesGet**](IssueTypesApi.md#comAtlassianJiraRestV2IssueIssueTypeResourceGetAlternativeIssueTypesGet) | **GET** /rest/api/3/issuetype/{id}/alternatives | Get alternative issue types
[**comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueAllTypesGet**](IssueTypesApi.md#comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueAllTypesGet) | **GET** /rest/api/3/issuetype | Get all issue types for user
[**comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueTypeGet**](IssueTypesApi.md#comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueTypeGet) | **GET** /rest/api/3/issuetype/{id} | Get issue type
[**comAtlassianJiraRestV2IssueIssueTypeResourceUpdateIssueTypePut**](IssueTypesApi.md#comAtlassianJiraRestV2IssueIssueTypeResourceUpdateIssueTypePut) | **PUT** /rest/api/3/issuetype/{id} | Update issue type



## comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypeAvatarPost

> Avatar comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypeAvatarPost(id, size, body, x, y)

Load issue type avatar

Loads an avatar for the issue type.  Specify the avatar&#39;s local file location in the body of the request. Also, include the following headers:   *  &#x60;X-Atlassian-Token: no-check&#x60; To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  &#x60;Content-Type: image/image type&#x60; Valid image types are JPEG, GIF, or PNG.  For example:   &#x60;curl --request POST \\ --user email@example.com:&lt;api_token&gt; \\ --header &#39;X-Atlassian-Token: no-check&#39; \\ --header &#39;Content-Type: image/&lt; image_type&gt;&#39; \\ --data-binary \&quot;&lt;@/path/to/file/with/your/avatar&gt;\&quot; \\ --url &#39;https://your-domain.atlassian.net/rest/api/3/issuetype/{issueTypeId}&#39;This&#x60;  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square&#39;s sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar, use [ Update issue type](#api-rest-api-3-issuetype-id-put) to set it as the issue type&#39;s displayed avatar.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypesApi;

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

        IssueTypesApi apiInstance = new IssueTypesApi(defaultClient);
        String id = "id_example"; // String | The ID of the issue type.
        Integer size = 56; // Integer | The length of each side of the crop region.
        Object body = null; // Object | 
        Integer x = 0; // Integer | The X coordinate of the top-left corner of the crop region.
        Integer y = 0; // Integer | The Y coordinate of the top-left corner of the crop region.
        try {
            Avatar result = apiInstance.comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypeAvatarPost(id, size, body, x, y);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypesApi#comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypeAvatarPost");
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
 **id** | **String**| The ID of the issue type. |
 **size** | **Integer**| The length of each side of the crop region. |
 **body** | **Object**|  |
 **x** | **Integer**| The X coordinate of the top-left corner of the crop region. | [optional] [default to 0]
 **y** | **Integer**| The Y coordinate of the top-left corner of the crop region. | [optional] [default to 0]

### Return type

[**Avatar**](Avatar.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **400** | Returned if:   *  an image isn&#39;t included in the request.  *  the image type is unsupported.  *  the crop parameters extend the crop area beyond the edge of the image.  *  &#x60;cropSize&#x60; is missing.  *  the issue type ID is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the issue type is not found. |  -  |


## comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypePost

> IssueTypeDetails comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypePost(issueTypeCreateBean)

Create issue type

Creates an issue type and adds it to the default issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypesApi;

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

        IssueTypesApi apiInstance = new IssueTypesApi(defaultClient);
        IssueTypeCreateBean issueTypeCreateBean = {"name":"name","description":"description","type":"standard"}; // IssueTypeCreateBean | 
        try {
            IssueTypeDetails result = apiInstance.comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypePost(issueTypeCreateBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypesApi#comAtlassianJiraRestV2IssueIssueTypeResourceCreateIssueTypePost");
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
 **issueTypeCreateBean** | [**IssueTypeCreateBean**](IssueTypeCreateBean.md)|  |

### Return type

[**IssueTypeDetails**](IssueTypeDetails.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid because:   *  no content is sent.  *  the issue type name exceeds 60 characters.  *  a subtask issue type is requested on an instance where subtasks are disabled. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **409** | Returned if the issue type name is in use. |  -  |


## comAtlassianJiraRestV2IssueIssueTypeResourceDeleteIssueTypeDelete

> comAtlassianJiraRestV2IssueIssueTypeResourceDeleteIssueTypeDelete(id, alternativeIssueTypeId)

Delete issue type

Deletes the issue type. If the issue type is in use, all uses are updated with the alternative issue type (&#x60;alternativeIssueTypeId&#x60;). A list of alternative issue types are obtained from the [Get alternative issue types](#api-rest-api-3-issuetype-id-alternatives-get) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypesApi;

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

        IssueTypesApi apiInstance = new IssueTypesApi(defaultClient);
        String id = "id_example"; // String | The ID of the issue type.
        String alternativeIssueTypeId = "alternativeIssueTypeId_example"; // String | The ID of the replacement issue type.
        try {
            apiInstance.comAtlassianJiraRestV2IssueIssueTypeResourceDeleteIssueTypeDelete(id, alternativeIssueTypeId);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypesApi#comAtlassianJiraRestV2IssueIssueTypeResourceDeleteIssueTypeDelete");
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
 **id** | **String**| The ID of the issue type. |
 **alternativeIssueTypeId** | **String**| The ID of the replacement issue type. | [optional]

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
| **400** | Returned if any issues cannot be updated with the alternative issue type. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if:   *  the issue type is in use and an alternative issue type is not specified.  *  the issue type or alternative issue type is not found. |  -  |
| **409** | Returned if the issue type is in use and:   *  also specified as the alternative issue type.  *  is a *standard* issue type and the alternative issue type is a *subtask*. |  -  |


## comAtlassianJiraRestV2IssueIssueTypeResourceGetAlternativeIssueTypesGet

> List&lt;IssueTypeDetails&gt; comAtlassianJiraRestV2IssueIssueTypeResourceGetAlternativeIssueTypesGet(id)

Get alternative issue types

Returns a list of issue types that can be used to replace the issue type. The alternative issue types are those assigned to the same workflow scheme, field configuration scheme, and screen scheme.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypesApi;

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

        IssueTypesApi apiInstance = new IssueTypesApi(defaultClient);
        String id = "id_example"; // String | The ID of the issue type.
        try {
            List<IssueTypeDetails> result = apiInstance.comAtlassianJiraRestV2IssueIssueTypeResourceGetAlternativeIssueTypesGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypesApi#comAtlassianJiraRestV2IssueIssueTypeResourceGetAlternativeIssueTypesGet");
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
 **id** | **String**| The ID of the issue type. |

### Return type

[**List&lt;IssueTypeDetails&gt;**](IssueTypeDetails.md)

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
| **404** | Returned if:   *  the issue type is not found.  *  the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueAllTypesGet

> List&lt;IssueTypeDetails&gt; comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueAllTypesGet()

Get all issue types for user

Returns all issue types.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issue types are only returned as follows:   *  if the user has the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg), all issue types are returned.  *  if the user has the *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for one or more projects, the issue types associated with the projects the user has permission to browse are returned.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypesApi;

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

        IssueTypesApi apiInstance = new IssueTypesApi(defaultClient);
        try {
            List<IssueTypeDetails> result = apiInstance.comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueAllTypesGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypesApi#comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueAllTypesGet");
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

[**List&lt;IssueTypeDetails&gt;**](IssueTypeDetails.md)

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


## comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueTypeGet

> IssueTypeDetails comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueTypeGet(id)

Get issue type

Returns an issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) in a project the issue type is associated with or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypesApi;

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

        IssueTypesApi apiInstance = new IssueTypesApi(defaultClient);
        String id = "id_example"; // String | The ID of the issue type.
        try {
            IssueTypeDetails result = apiInstance.comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueTypeGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypesApi#comAtlassianJiraRestV2IssueIssueTypeResourceGetIssueTypeGet");
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
 **id** | **String**| The ID of the issue type. |

### Return type

[**IssueTypeDetails**](IssueTypeDetails.md)

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
| **404** | Returned if:   *  the issue type is not found.  *  the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueIssueTypeResourceUpdateIssueTypePut

> IssueTypeDetails comAtlassianJiraRestV2IssueIssueTypeResourceUpdateIssueTypePut(id, issueTypeUpdateBean)

Update issue type

Updates the issue type.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypesApi;

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

        IssueTypesApi apiInstance = new IssueTypesApi(defaultClient);
        String id = "id_example"; // String | The ID of the issue type.
        IssueTypeUpdateBean issueTypeUpdateBean = {"avatarId":1,"name":"name","description":"description"}; // IssueTypeUpdateBean | 
        try {
            IssueTypeDetails result = apiInstance.comAtlassianJiraRestV2IssueIssueTypeResourceUpdateIssueTypePut(id, issueTypeUpdateBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypesApi#comAtlassianJiraRestV2IssueIssueTypeResourceUpdateIssueTypePut");
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
 **id** | **String**| The ID of the issue type. |
 **issueTypeUpdateBean** | [**IssueTypeUpdateBean**](IssueTypeUpdateBean.md)|  |

### Return type

[**IssueTypeDetails**](IssueTypeDetails.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid because:   *  no content is sent.  *  the issue type name exceeds 60 characters.  *  the avatar is not associated with this issue type. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the issue type is not found. |  -  |
| **409** | Returned if the issue type name is in use. |  -  |

