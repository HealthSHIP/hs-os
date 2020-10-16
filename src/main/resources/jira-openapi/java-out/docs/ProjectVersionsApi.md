# ProjectVersionsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsGet**](ProjectVersionsApi.md#comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsGet) | **GET** /rest/api/3/project/{projectIdOrKey}/versions | Get project versions
[**comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsPaginatedGet**](ProjectVersionsApi.md#comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsPaginatedGet) | **GET** /rest/api/3/project/{projectIdOrKey}/version | Get project versions paginated
[**comAtlassianJiraRestV2IssueVersionResourceCreateVersionPost**](ProjectVersionsApi.md#comAtlassianJiraRestV2IssueVersionResourceCreateVersionPost) | **POST** /rest/api/3/version | Create version
[**comAtlassianJiraRestV2IssueVersionResourceDeleteAndReplaceVersionPost**](ProjectVersionsApi.md#comAtlassianJiraRestV2IssueVersionResourceDeleteAndReplaceVersionPost) | **POST** /rest/api/3/version/{id}/removeAndSwap | Delete and replace version
[**comAtlassianJiraRestV2IssueVersionResourceDeleteVersionDelete**](ProjectVersionsApi.md#comAtlassianJiraRestV2IssueVersionResourceDeleteVersionDelete) | **DELETE** /rest/api/3/version/{id} | Delete version
[**comAtlassianJiraRestV2IssueVersionResourceGetVersionGet**](ProjectVersionsApi.md#comAtlassianJiraRestV2IssueVersionResourceGetVersionGet) | **GET** /rest/api/3/version/{id} | Get version
[**comAtlassianJiraRestV2IssueVersionResourceGetVersionRelatedIssuesGet**](ProjectVersionsApi.md#comAtlassianJiraRestV2IssueVersionResourceGetVersionRelatedIssuesGet) | **GET** /rest/api/3/version/{id}/relatedIssueCounts | Get version&#39;s related issues count
[**comAtlassianJiraRestV2IssueVersionResourceGetVersionUnresolvedIssuesGet**](ProjectVersionsApi.md#comAtlassianJiraRestV2IssueVersionResourceGetVersionUnresolvedIssuesGet) | **GET** /rest/api/3/version/{id}/unresolvedIssueCount | Get version&#39;s unresolved issues count
[**comAtlassianJiraRestV2IssueVersionResourceMergeVersionsPut**](ProjectVersionsApi.md#comAtlassianJiraRestV2IssueVersionResourceMergeVersionsPut) | **PUT** /rest/api/3/version/{id}/mergeto/{moveIssuesTo} | Merge versions
[**comAtlassianJiraRestV2IssueVersionResourceMoveVersionPost**](ProjectVersionsApi.md#comAtlassianJiraRestV2IssueVersionResourceMoveVersionPost) | **POST** /rest/api/3/version/{id}/move | Move version
[**comAtlassianJiraRestV2IssueVersionResourceUpdateVersionPut**](ProjectVersionsApi.md#comAtlassianJiraRestV2IssueVersionResourceUpdateVersionPut) | **PUT** /rest/api/3/version/{id} | Update version



## comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsGet

> List&lt;Version&gt; comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsGet(projectIdOrKey, expand)

Get project versions

Returns all versions in a project. The response is not paginated. Use [Get project versions paginated](#api-rest-api-3-project-projectIdOrKey-version-get) if you want to get the versions in a project with pagination.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectVersionsApi;

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

        ProjectVersionsApi apiInstance = new ProjectVersionsApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The project ID or project key (case sensitive).
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information in the response. This parameter accepts `operations`, which returns actions that can be performed on the version.
        try {
            List<Version> result = apiInstance.comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsGet(projectIdOrKey, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectVersionsApi#comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsGet");
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
 **expand** | **String**| Use [expand](#expansion) to include additional information in the response. This parameter accepts &#x60;operations&#x60;, which returns actions that can be performed on the version. | [optional]

### Return type

[**List&lt;Version&gt;**](Version.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **404** | Returned if the project is not found or the user does not have permission to view it. |  -  |


## comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsPaginatedGet

> PageBeanVersion comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsPaginatedGet(projectIdOrKey, startAt, maxResults, orderBy, query, status, expand)

Get project versions paginated

Returns a [paginated](#pagination) representation of all versions in a project. See the [Get project versions](#api-rest-api-3-project-projectIdOrKey-versions-get) resource if you want to get a full list of versions without pagination.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectVersionsApi;

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

        ProjectVersionsApi apiInstance = new ProjectVersionsApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The project ID or project key (case sensitive).
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        String orderBy = "orderBy_example"; // String | [Order](#ordering) the results by a field:   *  `description` Sorts by version description.  *  `name` Sorts by version name.  *  `releaseDate` Sorts by release date, starting with the oldest date. Versions with no release date are listed last.  *  `sequence` Sorts by the order of appearance in the user interface.  *  `startDate` Sorts by start date, starting with the oldest date. Versions with no start date are listed last.
        String query = "query_example"; // String | Filter the results using a literal string. Versions with matching `name` or `description` are returned (case insensitive).
        String status = "status_example"; // String | A list of status values used to filter the results by version status. This parameter accepts a comma-separated list. The status values are `released`, `unreleased`, and `archived`.
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  `issuesstatus` Returns the number of issues in each status contactCategory for each version.  *  `operations` Returns actions that can be performed on the specified version.
        try {
            PageBeanVersion result = apiInstance.comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsPaginatedGet(projectIdOrKey, startAt, maxResults, orderBy, query, status, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectVersionsApi#comAtlassianJiraRestV2IssueProjectResourceGetProjectVersionsPaginatedGet");
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
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]
 **orderBy** | **String**| [Order](#ordering) the results by a field:   *  &#x60;description&#x60; Sorts by version description.  *  &#x60;name&#x60; Sorts by version name.  *  &#x60;releaseDate&#x60; Sorts by release date, starting with the oldest date. Versions with no release date are listed last.  *  &#x60;sequence&#x60; Sorts by the order of appearance in the user interface.  *  &#x60;startDate&#x60; Sorts by start date, starting with the oldest date. Versions with no start date are listed last. | [optional] [enum: description, -description, +description, name, -name, +name, releaseDate, -releaseDate, +releaseDate, sequence, -sequence, +sequence, startDate, -startDate, +startDate]
 **query** | **String**| Filter the results using a literal string. Versions with matching &#x60;name&#x60; or &#x60;description&#x60; are returned (case insensitive). | [optional]
 **status** | **String**| A list of status values used to filter the results by version status. This parameter accepts a comma-separated list. The status values are &#x60;released&#x60;, &#x60;unreleased&#x60;, and &#x60;archived&#x60;. | [optional]
 **expand** | **String**| Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;issuesstatus&#x60; Returns the number of issues in each status contactCategory for each version.  *  &#x60;operations&#x60; Returns actions that can be performed on the specified version. | [optional]

### Return type

[**PageBeanVersion**](PageBeanVersion.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **404** | Returned if the project is not found or the user does not have permission to view it. |  -  |


## comAtlassianJiraRestV2IssueVersionResourceCreateVersionPost

> Version comAtlassianJiraRestV2IssueVersionResourceCreateVersionPost(version)

Create version

Creates a project version.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project the version is added to.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectVersionsApi;

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

        ProjectVersionsApi apiInstance = new ProjectVersionsApi(defaultClient);
        Version version = {"archived":false,"releaseDate":"2010-07-06T00:00:00.000Z","name":"New Version 1","description":"An excellent version","projectId":10000,"released":true}; // Version | 
        try {
            Version result = apiInstance.comAtlassianJiraRestV2IssueVersionResourceCreateVersionPost(version);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectVersionsApi#comAtlassianJiraRestV2IssueVersionResourceCreateVersionPost");
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
 **version** | [**Version**](Version.md)|  |

### Return type

[**Version**](Version.md)

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
| **404** | Returned if:   *  the project is not found.  *  the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueVersionResourceDeleteAndReplaceVersionPost

> Object comAtlassianJiraRestV2IssueVersionResourceDeleteAndReplaceVersionPost(id, deleteAndReplaceVersionBean)

Delete and replace version

Deletes a project version.  Alternative versions can be provided to update issues that use the deleted version in &#x60;fixVersion&#x60;, &#x60;affectedVersion&#x60;, or any version picker custom fields. If alternatives are not provided, occurrences of &#x60;fixVersion&#x60;, &#x60;affectedVersion&#x60;, and any version picker custom field, that contain the deleted version, are cleared. Any replacement version must be in the same project as the version being deleted and cannot be the version being deleted.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that contains the version.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectVersionsApi;

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

        ProjectVersionsApi apiInstance = new ProjectVersionsApi(defaultClient);
        String id = "id_example"; // String | The ID of the version.
        DeleteAndReplaceVersionBean deleteAndReplaceVersionBean = new DeleteAndReplaceVersionBean(); // DeleteAndReplaceVersionBean | 
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueVersionResourceDeleteAndReplaceVersionPost(id, deleteAndReplaceVersionBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectVersionsApi#comAtlassianJiraRestV2IssueVersionResourceDeleteAndReplaceVersionPost");
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
 **id** | **String**| The ID of the version. |
 **deleteAndReplaceVersionBean** | [**DeleteAndReplaceVersionBean**](DeleteAndReplaceVersionBean.md)|  |

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
| **204** | Returned if the version is deleted. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  the version to delete is not found.  *  the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueVersionResourceDeleteVersionDelete

> comAtlassianJiraRestV2IssueVersionResourceDeleteVersionDelete(id, moveFixIssuesTo, moveAffectedIssuesTo)

Delete version

Deletes a project version.  Deprecated, use [ Delete and replace version](#api-rest-api-3-version-id-removeAndSwap-post) that supports swapping version values in custom fields, in addition to the swapping for &#x60;fixVersion&#x60; and &#x60;affectedVersion&#x60; provided in this resource.  Alternative versions can be provided to update issues that use the deleted version in &#x60;fixVersion&#x60; or &#x60;affectedVersion&#x60;. If alternatives are not provided, occurrences of &#x60;fixVersion&#x60; and &#x60;affectedVersion&#x60; that contain the deleted version are cleared.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that contains the version.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectVersionsApi;

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

        ProjectVersionsApi apiInstance = new ProjectVersionsApi(defaultClient);
        String id = "id_example"; // String | The ID of the version.
        String moveFixIssuesTo = "moveFixIssuesTo_example"; // String | The ID of the version to update `fixVersion` to when the field contains the deleted version. The replacement version must be in the same project as the version being deleted and cannot be the version being deleted.
        String moveAffectedIssuesTo = "moveAffectedIssuesTo_example"; // String | The ID of the version to update `affectedVersion` to when the field contains the deleted version. The replacement version must be in the same project as the version being deleted and cannot be the version being deleted.
        try {
            apiInstance.comAtlassianJiraRestV2IssueVersionResourceDeleteVersionDelete(id, moveFixIssuesTo, moveAffectedIssuesTo);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectVersionsApi#comAtlassianJiraRestV2IssueVersionResourceDeleteVersionDelete");
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
 **id** | **String**| The ID of the version. |
 **moveFixIssuesTo** | **String**| The ID of the version to update &#x60;fixVersion&#x60; to when the field contains the deleted version. The replacement version must be in the same project as the version being deleted and cannot be the version being deleted. | [optional]
 **moveAffectedIssuesTo** | **String**| The ID of the version to update &#x60;affectedVersion&#x60; to when the field contains the deleted version. The replacement version must be in the same project as the version being deleted and cannot be the version being deleted. | [optional]

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
| **204** | Returned if the version is deleted. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if:   *  the authentication credentials are incorrect.  *  the user does not have the required permissions. |  -  |
| **404** | Returned if the version is not found. |  -  |


## comAtlassianJiraRestV2IssueVersionResourceGetVersionGet

> Version comAtlassianJiraRestV2IssueVersionResourceGetVersionGet(id, expand)

Get version

Returns a project version.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the version.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectVersionsApi;

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

        ProjectVersionsApi apiInstance = new ProjectVersionsApi(defaultClient);
        String id = "id_example"; // String | The ID of the version.
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information about version in the response. This parameter accepts a comma-separated list. Expand options include:   *  `operations` Returns the list of operations available for this version.  *  `issuesstatus` Returns the count of issues in this version for each of the status categories *to do*, *in progress*, *done*, and *unmapped*. The *unmapped* property represents the number of issues with a status other than *to do*, *in progress*, and *done*.
        try {
            Version result = apiInstance.comAtlassianJiraRestV2IssueVersionResourceGetVersionGet(id, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectVersionsApi#comAtlassianJiraRestV2IssueVersionResourceGetVersionGet");
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
 **id** | **String**| The ID of the version. |
 **expand** | **String**| Use [expand](#expansion) to include additional information about version in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;operations&#x60; Returns the list of operations available for this version.  *  &#x60;issuesstatus&#x60; Returns the count of issues in this version for each of the status categories *to do*, *in progress*, *done*, and *unmapped*. The *unmapped* property represents the number of issues with a status other than *to do*, *in progress*, and *done*. | [optional]

### Return type

[**Version**](Version.md)

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
| **404** | Returned if the version is not found or the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2IssueVersionResourceGetVersionRelatedIssuesGet

> VersionIssueCounts comAtlassianJiraRestV2IssueVersionResourceGetVersionRelatedIssuesGet(id)

Get version&#39;s related issues count

Returns the following counts for a version:   *  Number of issues where the &#x60;fixVersion&#x60; is set to the version.  *  Number of issues where the &#x60;affectedVersion&#x60; is set to the version.  *  Number of issues where a version custom field is set to the version.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* project permission for the project that contains the version.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectVersionsApi;

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

        ProjectVersionsApi apiInstance = new ProjectVersionsApi(defaultClient);
        String id = "id_example"; // String | The ID of the version.
        try {
            VersionIssueCounts result = apiInstance.comAtlassianJiraRestV2IssueVersionResourceGetVersionRelatedIssuesGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectVersionsApi#comAtlassianJiraRestV2IssueVersionResourceGetVersionRelatedIssuesGet");
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
 **id** | **String**| The ID of the version. |

### Return type

[**VersionIssueCounts**](VersionIssueCounts.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |
| **404** | Returned if:   *  the version is not found.  *  the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueVersionResourceGetVersionUnresolvedIssuesGet

> VersionUnresolvedIssuesCount comAtlassianJiraRestV2IssueVersionResourceGetVersionUnresolvedIssuesGet(id)

Get version&#39;s unresolved issues count

Returns counts of the issues and unresolved issues for the project version.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* project permission for the project that contains the version.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectVersionsApi;

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

        ProjectVersionsApi apiInstance = new ProjectVersionsApi(defaultClient);
        String id = "id_example"; // String | The ID of the version.
        try {
            VersionUnresolvedIssuesCount result = apiInstance.comAtlassianJiraRestV2IssueVersionResourceGetVersionUnresolvedIssuesGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectVersionsApi#comAtlassianJiraRestV2IssueVersionResourceGetVersionUnresolvedIssuesGet");
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
 **id** | **String**| The ID of the version. |

### Return type

[**VersionUnresolvedIssuesCount**](VersionUnresolvedIssuesCount.md)

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
| **404** | Returned if:   *  the version is not found.  *  the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueVersionResourceMergeVersionsPut

> Object comAtlassianJiraRestV2IssueVersionResourceMergeVersionsPut(id, moveIssuesTo)

Merge versions

Merges two project versions. The merge is completed by deleting the version specified in &#x60;id&#x60; and replacing any occurrences of its ID in &#x60;fixVersion&#x60; with the version ID specified in &#x60;moveIssuesTo&#x60;.  Consider using [ Delete and replace version](#api-rest-api-3-version-id-removeAndSwap-post) instead. This resource supports swapping version values in &#x60;fixVersion&#x60;, &#x60;affectedVersion&#x60;, and custom fields.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that contains the version.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectVersionsApi;

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

        ProjectVersionsApi apiInstance = new ProjectVersionsApi(defaultClient);
        String id = "id_example"; // String | The ID of the version to delete.
        String moveIssuesTo = "moveIssuesTo_example"; // String | The ID of the version to merge into.
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueVersionResourceMergeVersionsPut(id, moveIssuesTo);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectVersionsApi#comAtlassianJiraRestV2IssueVersionResourceMergeVersionsPut");
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
 **id** | **String**| The ID of the version to delete. |
 **moveIssuesTo** | **String**| The ID of the version to merge into. |

### Return type

**Object**

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the version is deleted. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if:   *  the authentication credentials are incorrect or missing.  *  the user does not have the required permissions. |  -  |
| **404** | Returned if the version to be deleted or the version to merge to are not found. |  -  |


## comAtlassianJiraRestV2IssueVersionResourceMoveVersionPost

> Version comAtlassianJiraRestV2IssueVersionResourceMoveVersionPost(id, versionMoveBean)

Move version

Modifies the version&#39;s sequence within the project, which affects the display order of the versions in Jira.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* project permission for the project that contains the version.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectVersionsApi;

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

        ProjectVersionsApi apiInstance = new ProjectVersionsApi(defaultClient);
        String id = "id_example"; // String | The ID of the version to be moved.
        VersionMoveBean versionMoveBean = {"after":"https://your-domain.atlassian.net/rest/api/~ver~/version/10000"}; // VersionMoveBean | 
        try {
            Version result = apiInstance.comAtlassianJiraRestV2IssueVersionResourceMoveVersionPost(id, versionMoveBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectVersionsApi#comAtlassianJiraRestV2IssueVersionResourceMoveVersionPost");
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
 **id** | **String**| The ID of the version to be moved. |
 **versionMoveBean** | [**VersionMoveBean**](VersionMoveBean.md)|  |

### Return type

[**Version**](Version.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if:   *  no body parameters are provided.  *  &#x60;after&#x60; and &#x60;position&#x60; are provided.  *  &#x60;position&#x60; is invalid. |  -  |
| **401** | Returned if:   *  the authentication credentials are incorrect or missing  *  the user does not have the required commissions. |  -  |
| **404** | Returned if the version or move after version are not found. |  -  |


## comAtlassianJiraRestV2IssueVersionResourceUpdateVersionPut

> Version comAtlassianJiraRestV2IssueVersionResourceUpdateVersionPut(id, version)

Update version

Updates a project version.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that contains the version.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ProjectVersionsApi;

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

        ProjectVersionsApi apiInstance = new ProjectVersionsApi(defaultClient);
        String id = "id_example"; // String | The ID of the version.
        Version version = {"archived":false,"overdue":true,"releaseDate":"2010-07-06T00:00:00.000Z","name":"New Version 1","self":"https://your-domain.atlassian.net/rest/api/~ver~/version/10000","description":"An excellent version","userReleaseDate":"6/Jul/2010","id":"10000","projectId":10000,"released":true}; // Version | 
        try {
            Version result = apiInstance.comAtlassianJiraRestV2IssueVersionResourceUpdateVersionPut(id, version);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectVersionsApi#comAtlassianJiraRestV2IssueVersionResourceUpdateVersionPut");
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
 **id** | **String**| The ID of the version. |
 **version** | [**Version**](Version.md)|  |

### Return type

[**Version**](Version.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if:   *  the request is invalid.  *  the user does not have the required permissions. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |
| **404** | Returned if the version is not found. |  -  |

