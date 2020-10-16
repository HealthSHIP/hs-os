# AvatarsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueAvatarResourceGetAllSystemAvatarsGet**](AvatarsApi.md#comAtlassianJiraRestV2IssueAvatarResourceGetAllSystemAvatarsGet) | **GET** /rest/api/3/avatar/{type}/system | Get system avatars by type
[**comAtlassianJiraRestV2IssueUniversalAvatarResourceDeleteAvatarDelete**](AvatarsApi.md#comAtlassianJiraRestV2IssueUniversalAvatarResourceDeleteAvatarDelete) | **DELETE** /rest/api/3/universal_avatar/type/{type}/owner/{owningObjectId}/avatar/{id} | Delete avatar
[**comAtlassianJiraRestV2IssueUniversalAvatarResourceGetAvatarsGet**](AvatarsApi.md#comAtlassianJiraRestV2IssueUniversalAvatarResourceGetAvatarsGet) | **GET** /rest/api/3/universal_avatar/type/{type}/owner/{entityId} | Get avatars
[**comAtlassianJiraRestV2IssueUniversalAvatarResourceStoreAvatarPost**](AvatarsApi.md#comAtlassianJiraRestV2IssueUniversalAvatarResourceStoreAvatarPost) | **POST** /rest/api/3/universal_avatar/type/{type}/owner/{entityId} | Load avatar



## comAtlassianJiraRestV2IssueAvatarResourceGetAllSystemAvatarsGet

> SystemAvatars comAtlassianJiraRestV2IssueAvatarResourceGetAllSystemAvatarsGet(type)

Get system avatars by type

Returns a list of system avatar details by owner type, where the owner types are issue type, project, or user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.AvatarsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        AvatarsApi apiInstance = new AvatarsApi(defaultClient);
        String type = project; // String | The avatar type.
        try {
            SystemAvatars result = apiInstance.comAtlassianJiraRestV2IssueAvatarResourceGetAllSystemAvatarsGet(type);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AvatarsApi#comAtlassianJiraRestV2IssueAvatarResourceGetAllSystemAvatarsGet");
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
 **type** | **String**| The avatar type. | [enum: issuetype, project, user]

### Return type

[**SystemAvatars**](SystemAvatars.md)

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
| **500** | Returned if an error occurs while retrieving the list of avatars. |  -  |


## comAtlassianJiraRestV2IssueUniversalAvatarResourceDeleteAvatarDelete

> comAtlassianJiraRestV2IssueUniversalAvatarResourceDeleteAvatarDelete(type, owningObjectId, id)

Delete avatar

Deletes an avatar from a project or issue type.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.AvatarsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        AvatarsApi apiInstance = new AvatarsApi(defaultClient);
        String type = "type_example"; // String | The avatar type.
        String owningObjectId = "owningObjectId_example"; // String | The ID of the item the avatar is associated with.
        Long id = 56L; // Long | The ID of the avatar.
        try {
            apiInstance.comAtlassianJiraRestV2IssueUniversalAvatarResourceDeleteAvatarDelete(type, owningObjectId, id);
        } catch (ApiException e) {
            System.err.println("Exception when calling AvatarsApi#comAtlassianJiraRestV2IssueUniversalAvatarResourceDeleteAvatarDelete");
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
 **type** | **String**| The avatar type. | [enum: project, issuetype]
 **owningObjectId** | **String**| The ID of the item the avatar is associated with. |
 **id** | **Long**| The ID of the avatar. |

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
| **400** | Returned if the request is invalid. |  -  |
| **403** | Returned if the user does not have permission to delete the avatar, the avatar is not deletedable. |  -  |
| **404** | Returned if the avatar type, associated item ID, or avatar ID is invalid. |  -  |


## comAtlassianJiraRestV2IssueUniversalAvatarResourceGetAvatarsGet

> Avatars comAtlassianJiraRestV2IssueUniversalAvatarResourceGetAvatarsGet(type, entityId)

Get avatars

Returns the system and custom avatars for a project or issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.AvatarsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        AvatarsApi apiInstance = new AvatarsApi(defaultClient);
        String type = "type_example"; // String | The avatar type.
        String entityId = "entityId_example"; // String | The ID of the item the avatar is associated with.
        try {
            Avatars result = apiInstance.comAtlassianJiraRestV2IssueUniversalAvatarResourceGetAvatarsGet(type, entityId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AvatarsApi#comAtlassianJiraRestV2IssueUniversalAvatarResourceGetAvatarsGet");
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
 **type** | **String**| The avatar type. | [enum: project, issuetype]
 **entityId** | **String**| The ID of the item the avatar is associated with. |

### Return type

[**Avatars**](Avatars.md)

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
| **404** | Returned if the avatar type is invalid, the associated item ID is missing, or the item is not found. |  -  |


## comAtlassianJiraRestV2IssueUniversalAvatarResourceStoreAvatarPost

> Avatar comAtlassianJiraRestV2IssueUniversalAvatarResourceStoreAvatarPost(type, entityId, size, body, x, y)

Load avatar

Loads a custom avatar for a project or issue type.  Specify the avatar&#39;s local file location in the body of the request. Also, include the following headers:   *  &#x60;X-Atlassian-Token: no-check&#x60; To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  &#x60;Content-Type: image/image type&#x60; Valid image types are JPEG, GIF, or PNG.  For example:   &#x60;curl --request POST &#x60;  &#x60;--user email@example.com:&lt;api_token&gt; &#x60;  &#x60;--header &#39;X-Atlassian-Token: no-check&#39; &#x60;  &#x60;--header &#39;Content-Type: image/&lt; image_type&gt;&#39; &#x60;  &#x60;--data-binary \&quot;&lt;@/path/to/file/with/your/avatar&gt;\&quot; &#x60;  &#x60;--url &#39;https://your-domain.atlassian.net/rest/api/3/universal_avatar/type/{type}/owner/{entityId}&#39;&#x60;  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square&#39;s sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar use:   *  [Update issue type](#api-rest-api-3-issuetype-id-put) to set it as the issue type&#39;s displayed avatar.  *  [Set project avatar](#api-rest-api-3-project-projectIdOrKey-avatar-put) to set it as the project&#39;s displayed avatar.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.AvatarsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        AvatarsApi apiInstance = new AvatarsApi(defaultClient);
        String type = "type_example"; // String | The avatar type.
        String entityId = "entityId_example"; // String | The ID of the item the avatar is associated with.
        Integer size = 56; // Integer | The length of each side of the crop region.
        Object body = null; // Object | 
        Integer x = 0; // Integer | The X coordinate of the top-left corner of the crop region.
        Integer y = 0; // Integer | The Y coordinate of the top-left corner of the crop region.
        try {
            Avatar result = apiInstance.comAtlassianJiraRestV2IssueUniversalAvatarResourceStoreAvatarPost(type, entityId, size, body, x, y);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AvatarsApi#comAtlassianJiraRestV2IssueUniversalAvatarResourceStoreAvatarPost");
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
 **type** | **String**| The avatar type. | [enum: project, issuetype]
 **entityId** | **String**| The ID of the item the avatar is associated with. |
 **size** | **Integer**| The length of each side of the crop region. |
 **body** | **Object**|  |
 **x** | **Integer**| The X coordinate of the top-left corner of the crop region. | [optional] [default to 0]
 **y** | **Integer**| The Y coordinate of the top-left corner of the crop region. | [optional] [default to 0]

### Return type

[**Avatar**](Avatar.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **400** | Returned if:   *  an image isn&#39;t included in the request.  *  the image type is unsupported.  *  the crop parameters extend the crop area beyond the edge of the image. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permissions. |  -  |
| **404** | Returned if the avatar type is invalid, the associated item ID is missing, or the item is not found. |  -  |

