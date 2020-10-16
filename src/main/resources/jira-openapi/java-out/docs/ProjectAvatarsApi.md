# ProjectAvatarsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueProjectResourceCreateProjectAvatarPost**](ProjectAvatarsApi.md#comAtlassianJiraRestV2IssueProjectResourceCreateProjectAvatarPost) | **POST** /rest/api/3/project/{projectIdOrKey}/avatar2 | Load project avatar
[**comAtlassianJiraRestV2IssueProjectResourceDeleteProjectAvatarDelete**](ProjectAvatarsApi.md#comAtlassianJiraRestV2IssueProjectResourceDeleteProjectAvatarDelete) | **DELETE** /rest/api/3/project/{projectIdOrKey}/avatar/{id} | Delete project avatar
[**comAtlassianJiraRestV2IssueProjectResourceGetAllProjectAvatarsGet**](ProjectAvatarsApi.md#comAtlassianJiraRestV2IssueProjectResourceGetAllProjectAvatarsGet) | **GET** /rest/api/3/project/{projectIdOrKey}/avatars | Get all project avatars
[**comAtlassianJiraRestV2IssueProjectResourceUpdateProjectAvatarPut**](ProjectAvatarsApi.md#comAtlassianJiraRestV2IssueProjectResourceUpdateProjectAvatarPut) | **PUT** /rest/api/3/project/{projectIdOrKey}/avatar | Set project avatar



## comAtlassianJiraRestV2IssueProjectResourceCreateProjectAvatarPost

> Avatar comAtlassianJiraRestV2IssueProjectResourceCreateProjectAvatarPost(projectIdOrKey, body, x, y, size)

Load project avatar

Loads an avatar for a project.  Specify the avatar&#39;s local file location in the body of the request. Also, include the following headers:   *  &#x60;X-Atlassian-Token: no-check&#x60; To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  &#x60;Content-Type: image/image type&#x60; Valid image types are JPEG, GIF, or PNG.  For example:   &#x60;curl --request POST &#x60;  &#x60;--user email@example.com:&lt;api_token&gt; &#x60;  &#x60;--header &#39;X-Atlassian-Token: no-check&#39; &#x60;  &#x60;--header &#39;Content-Type: image/&lt; image_type&gt;&#39; &#x60;  &#x60;--data-binary \&quot;&lt;@/path/to/file/with/your/avatar&gt;\&quot; &#x60;  &#x60;--url &#39;https://your-domain.atlassian.net/rest/api/3/project/{projectIdOrKey}/avatar2&#39;&#x60;  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square&#39;s sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar use [Set project avatar](#api-rest-api-3-project-projectIdOrKey-avatar-put) to set it as the project&#39;s displayed avatar.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectAvatarsApi;

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

        ProjectAvatarsApi apiInstance = new ProjectAvatarsApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The ID or (case-sensitive) key of the project.
        Object body = null; // Object | 
        Integer x = 0; // Integer | The X coordinate of the top-left corner of the crop region.
        Integer y = 0; // Integer | The Y coordinate of the top-left corner of the crop region.
        Integer size = 56; // Integer | The length of each side of the crop region.
        try {
            Avatar result = apiInstance.comAtlassianJiraRestV2IssueProjectResourceCreateProjectAvatarPost(projectIdOrKey, body, x, y, size);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectAvatarsApi#comAtlassianJiraRestV2IssueProjectResourceCreateProjectAvatarPost");
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
 **projectIdOrKey** | **String**| The ID or (case-sensitive) key of the project. |
 **body** | **Object**|  |
 **x** | **Integer**| The X coordinate of the top-left corner of the crop region. | [optional] [default to 0]
 **y** | **Integer**| The Y coordinate of the top-left corner of the crop region. | [optional] [default to 0]
 **size** | **Integer**| The length of each side of the crop region. | [optional]

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
| **400** | Returned if:   *  an image isn&#39;t included in the request.  *  the image type is unsupported.  *  the crop parameters extend the crop area beyond the edge of the image. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to administer the project or an anonymous call is made to the operation. |  -  |
| **404** | Returned if the project is not found or the user does not have permission to view the project. |  -  |


## comAtlassianJiraRestV2IssueProjectResourceDeleteProjectAvatarDelete

> comAtlassianJiraRestV2IssueProjectResourceDeleteProjectAvatarDelete(projectIdOrKey, id)

Delete project avatar

Deletes a custom avatar from a project. Note that system avatars cannot be deleted.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectAvatarsApi;

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

        ProjectAvatarsApi apiInstance = new ProjectAvatarsApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The project ID or (case-sensitive) key.
        Long id = 56L; // Long | The ID of the avatar.
        try {
            apiInstance.comAtlassianJiraRestV2IssueProjectResourceDeleteProjectAvatarDelete(projectIdOrKey, id);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectAvatarsApi#comAtlassianJiraRestV2IssueProjectResourceDeleteProjectAvatarDelete");
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
 **projectIdOrKey** | **String**| The project ID or (case-sensitive) key. |
 **id** | **Long**| The ID of the avatar. |

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
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the avatar is a system avatar or the user does not have permission to administer the project. |  -  |
| **404** | Returned if the project or avatar is not found or the user does not have permission to view the project. |  -  |


## comAtlassianJiraRestV2IssueProjectResourceGetAllProjectAvatarsGet

> ProjectAvatars comAtlassianJiraRestV2IssueProjectResourceGetAllProjectAvatarsGet(projectIdOrKey)

Get all project avatars

Returns all project avatars, grouped by system and custom avatars.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectAvatarsApi;

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

        ProjectAvatarsApi apiInstance = new ProjectAvatarsApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The ID or (case-sensitive) key of the project.
        try {
            ProjectAvatars result = apiInstance.comAtlassianJiraRestV2IssueProjectResourceGetAllProjectAvatarsGet(projectIdOrKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectAvatarsApi#comAtlassianJiraRestV2IssueProjectResourceGetAllProjectAvatarsGet");
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
 **projectIdOrKey** | **String**| The ID or (case-sensitive) key of the project. |

### Return type

[**ProjectAvatars**](ProjectAvatars.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the the project is not found or the user does not have permission to view the project. |  -  |


## comAtlassianJiraRestV2IssueProjectResourceUpdateProjectAvatarPut

> Object comAtlassianJiraRestV2IssueProjectResourceUpdateProjectAvatarPut(projectIdOrKey, avatar)

Set project avatar

Sets the avatar displayed for a project.  Use [Load project avatar](#api-rest-api-3-project-projectIdOrKey-avatar2-post) to store avatars against the project, before using this operation to set the displayed avatar.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectAvatarsApi;

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

        ProjectAvatarsApi apiInstance = new ProjectAvatarsApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The ID or (case-sensitive) key of the project.
        Avatar avatar = {"id":"10010"}; // Avatar | 
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueProjectResourceUpdateProjectAvatarPut(projectIdOrKey, avatar);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectAvatarsApi#comAtlassianJiraRestV2IssueProjectResourceUpdateProjectAvatarPut");
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
 **projectIdOrKey** | **String**| The ID or (case-sensitive) key of the project. |
 **avatar** | [**Avatar**](Avatar.md)|  |

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
| **204** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to administer the project. |  -  |
| **404** | Returned if the project or avatar is not found or the user does not have permission to view the project. |  -  |

