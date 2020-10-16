# ScreensApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueFieldResourceGetScreensForFieldGet**](ScreensApi.md#comAtlassianJiraRestV2IssueFieldResourceGetScreensForFieldGet) | **GET** /rest/api/3/field/{fieldId}/screens | Get screens for a field
[**comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeMappingsGet**](ScreensApi.md#comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeMappingsGet) | **GET** /rest/api/3/issuetypescreenscheme/mapping | Get issue type screen scheme items
[**comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeProjectAssociationsGet**](ScreensApi.md#comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeProjectAssociationsGet) | **GET** /rest/api/3/issuetypescreenscheme/project | Get issue type screen schemes for projects
[**comAtlassianJiraRestV2IssueScreensResourceAddFieldToDefaultScreenPost**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceAddFieldToDefaultScreenPost) | **POST** /rest/api/3/screens/addToDefault/{fieldId} | Add field to default screen
[**comAtlassianJiraRestV2IssueScreensResourceAddScreenTabFieldPost**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceAddScreenTabFieldPost) | **POST** /rest/api/3/screens/{screenId}/tabs/{tabId}/fields | Add screen tab field
[**comAtlassianJiraRestV2IssueScreensResourceAddScreenTabPost**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceAddScreenTabPost) | **POST** /rest/api/3/screens/{screenId}/tabs | Create screen tab
[**comAtlassianJiraRestV2IssueScreensResourceDeleteScreenTabDelete**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceDeleteScreenTabDelete) | **DELETE** /rest/api/3/screens/{screenId}/tabs/{tabId} | Delete screen tab
[**comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabFieldsGet**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabFieldsGet) | **GET** /rest/api/3/screens/{screenId}/tabs/{tabId}/fields | Get all screen tab fields
[**comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabsGet**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabsGet) | **GET** /rest/api/3/screens/{screenId}/tabs | Get all screen tabs
[**comAtlassianJiraRestV2IssueScreensResourceGetAllScreensGet**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceGetAllScreensGet) | **GET** /rest/api/3/screens | Get all screens
[**comAtlassianJiraRestV2IssueScreensResourceGetAvailableScreenFieldsGet**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceGetAvailableScreenFieldsGet) | **GET** /rest/api/3/screens/{screenId}/availableFields | Get available screen fields
[**comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabFieldPost**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabFieldPost) | **POST** /rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id}/move | Move screen tab field
[**comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabPost**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabPost) | **POST** /rest/api/3/screens/{screenId}/tabs/{tabId}/move/{pos} | Move screen tab
[**comAtlassianJiraRestV2IssueScreensResourceRemoveScreenTabFieldDelete**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceRemoveScreenTabFieldDelete) | **DELETE** /rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id} | Remove screen tab field
[**comAtlassianJiraRestV2IssueScreensResourceRenameScreenTabPut**](ScreensApi.md#comAtlassianJiraRestV2IssueScreensResourceRenameScreenTabPut) | **PUT** /rest/api/3/screens/{screenId}/tabs/{tabId} | Update screen tab
[**comAtlassianJiraRestV2IssueScreenschemeScreenSchemeResourceGetAllScreenSchemesGet**](ScreensApi.md#comAtlassianJiraRestV2IssueScreenschemeScreenSchemeResourceGetAllScreenSchemesGet) | **GET** /rest/api/3/screenscheme | Get all screen schemes



## comAtlassianJiraRestV2IssueFieldResourceGetScreensForFieldGet

> PageBeanScreen comAtlassianJiraRestV2IssueFieldResourceGetScreensForFieldGet(fieldId, startAt, maxResults)

Get screens for a field

Returns a [paginated](#pagination) list of the screens a field is used in.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the field to return screens for.
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 100; // Integer | The maximum number of items to return per page.
        try {
            PageBeanScreen result = apiInstance.comAtlassianJiraRestV2IssueFieldResourceGetScreensForFieldGet(fieldId, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueFieldResourceGetScreensForFieldGet");
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
 **fieldId** | **String**| The ID of the field to return screens for. |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 100]

### Return type

[**PageBeanScreen**](PageBeanScreen.md)

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
| **403** | Returned if the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeMappingsGet

> PageBeanIssueTypeScreenSchemeItem comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeMappingsGet(startAt, maxResults, issueTypeScreenSchemeId)

Get issue type screen scheme items

Returns a list of issue type screen scheme items.  Only issue type screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        List<Long> issueTypeScreenSchemeId = Arrays.asList(); // List<Long> | The list of issue type screen scheme IDs. To include multiple issue type screen schemes, separate IDs with ampersand: `issueTypeScreenSchemeId=10000&issueTypeScreenSchemeId=10001`.
        try {
            PageBeanIssueTypeScreenSchemeItem result = apiInstance.comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeMappingsGet(startAt, maxResults, issueTypeScreenSchemeId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeMappingsGet");
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
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]
 **issueTypeScreenSchemeId** | [**List&lt;Long&gt;**](Long.md)| The list of issue type screen scheme IDs. To include multiple issue type screen schemes, separate IDs with ampersand: &#x60;issueTypeScreenSchemeId&#x3D;10000&amp;issueTypeScreenSchemeId&#x3D;10001&#x60;. | [optional]

### Return type

[**PageBeanIssueTypeScreenSchemeItem**](PageBeanIssueTypeScreenSchemeItem.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeProjectAssociationsGet

> PageBeanIssueTypeScreenSchemesProjects comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeProjectAssociationsGet(startAt, maxResults, projectId)

Get issue type screen schemes for projects

Returns a list of issue type screen schemes and, for each issue type screen scheme, a list of the projects that use it.  Only issue type screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        List<Long> projectId = Arrays.asList(); // List<Long> | The list of project IDs. To include multiple projects, separate IDs with ampersand: `projectId=10000&projectId=10001`.
        try {
            PageBeanIssueTypeScreenSchemesProjects result = apiInstance.comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeProjectAssociationsGet(startAt, maxResults, projectId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueIssuetypescreenschemeIssueTypeScreenSchemeResourceGetIssueTypeScreenSchemeProjectAssociationsGet");
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
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]
 **projectId** | [**List&lt;Long&gt;**](Long.md)| The list of project IDs. To include multiple projects, separate IDs with ampersand: &#x60;projectId&#x3D;10000&amp;projectId&#x3D;10001&#x60;. | [optional]

### Return type

[**PageBeanIssueTypeScreenSchemesProjects**](PageBeanIssueTypeScreenSchemesProjects.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the required permissions. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceAddFieldToDefaultScreenPost

> Object comAtlassianJiraRestV2IssueScreensResourceAddFieldToDefaultScreenPost(fieldId)

Add field to default screen

Adds a field to the default tab of the default screen.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

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

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the field.
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueScreensResourceAddFieldToDefaultScreenPost(fieldId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceAddFieldToDefaultScreenPost");
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
 **fieldId** | **String**| The ID of the field. |

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
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the field it not found or the field is already present. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceAddScreenTabFieldPost

> ScreenableField comAtlassianJiraRestV2IssueScreensResourceAddScreenTabFieldPost(screenId, tabId, addFieldBean)

Add screen tab field

Adds a field to a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

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

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        Long tabId = 56L; // Long | The ID of the screen tab.
        AddFieldBean addFieldBean = {"fieldId":"summary"}; // AddFieldBean | 
        try {
            ScreenableField result = apiInstance.comAtlassianJiraRestV2IssueScreensResourceAddScreenTabFieldPost(screenId, tabId, addFieldBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceAddScreenTabFieldPost");
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
 **screenId** | **Long**| The ID of the screen. |
 **tabId** | **Long**| The ID of the screen tab. |
 **addFieldBean** | [**AddFieldBean**](AddFieldBean.md)|  |

### Return type

[**ScreenableField**](ScreenableField.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen, screen tab, or field is not found. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceAddScreenTabPost

> ScreenableTab comAtlassianJiraRestV2IssueScreensResourceAddScreenTabPost(screenId, screenableTab)

Create screen tab

Creates a tab for a screen.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

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

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        ScreenableTab screenableTab = {"name":"Fields Tab"}; // ScreenableTab | 
        try {
            ScreenableTab result = apiInstance.comAtlassianJiraRestV2IssueScreensResourceAddScreenTabPost(screenId, screenableTab);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceAddScreenTabPost");
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
 **screenId** | **Long**| The ID of the screen. |
 **screenableTab** | [**ScreenableTab**](ScreenableTab.md)|  |

### Return type

[**ScreenableTab**](ScreenableTab.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen is not found. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceDeleteScreenTabDelete

> comAtlassianJiraRestV2IssueScreensResourceDeleteScreenTabDelete(screenId, tabId)

Delete screen tab

Deletes a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        Long tabId = 56L; // Long | The ID of the screen tab.
        try {
            apiInstance.comAtlassianJiraRestV2IssueScreensResourceDeleteScreenTabDelete(screenId, tabId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceDeleteScreenTabDelete");
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
 **screenId** | **Long**| The ID of the screen. |
 **tabId** | **Long**| The ID of the screen tab. |

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
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen or screen tab is not found. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabFieldsGet

> List&lt;ScreenableField&gt; comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabFieldsGet(screenId, tabId, projectKey)

Get all screen tab fields

Returns all fields for a screen tab.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

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

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        Long tabId = 56L; // Long | The ID of the screen tab.
        String projectKey = "projectKey_example"; // String | The key of the project.
        try {
            List<ScreenableField> result = apiInstance.comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabFieldsGet(screenId, tabId, projectKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabFieldsGet");
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
 **screenId** | **Long**| The ID of the screen. |
 **tabId** | **Long**| The ID of the screen tab. |
 **projectKey** | **String**| The key of the project. | [optional]

### Return type

[**List&lt;ScreenableField&gt;**](ScreenableField.md)

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
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen or screen tab is not found. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabsGet

> List&lt;ScreenableTab&gt; comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabsGet(screenId, projectKey)

Get all screen tabs

Returns the list of tabs for a screen.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

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

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        String projectKey = "projectKey_example"; // String | The key of the project.
        try {
            List<ScreenableTab> result = apiInstance.comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabsGet(screenId, projectKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceGetAllScreenTabsGet");
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
 **screenId** | **Long**| The ID of the screen. |
 **projectKey** | **String**| The key of the project. | [optional]

### Return type

[**List&lt;ScreenableTab&gt;**](ScreenableTab.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the screen ID is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen is not found. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceGetAllScreensGet

> PageBeanScreen comAtlassianJiraRestV2IssueScreensResourceGetAllScreensGet(startAt, maxResults)

Get all screens

Returns all screens.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

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

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 100; // Integer | The maximum number of items to return per page.
        try {
            PageBeanScreen result = apiInstance.comAtlassianJiraRestV2IssueScreensResourceGetAllScreensGet(startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceGetAllScreensGet");
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
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 100]

### Return type

[**PageBeanScreen**](PageBeanScreen.md)

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
| **403** | Returned if the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceGetAvailableScreenFieldsGet

> List&lt;ScreenableField&gt; comAtlassianJiraRestV2IssueScreensResourceGetAvailableScreenFieldsGet(screenId)

Get available screen fields

Returns the fields that can be added to a tab on a screen.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

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

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        try {
            List<ScreenableField> result = apiInstance.comAtlassianJiraRestV2IssueScreensResourceGetAvailableScreenFieldsGet(screenId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceGetAvailableScreenFieldsGet");
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
 **screenId** | **Long**| The ID of the screen. |

### Return type

[**List&lt;ScreenableField&gt;**](ScreenableField.md)

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
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen is not found. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabFieldPost

> Object comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabFieldPost(screenId, tabId, id, moveFieldBean)

Move screen tab field

Moves a screen tab field.  If &#x60;after&#x60; and &#x60;position&#x60; are provided in the request, &#x60;position&#x60; is ignored.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

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

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        Long tabId = 56L; // Long | The ID of the screen tab.
        String id = "id_example"; // String | The ID of the field.
        MoveFieldBean moveFieldBean = new MoveFieldBean(); // MoveFieldBean | 
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabFieldPost(screenId, tabId, id, moveFieldBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabFieldPost");
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
 **screenId** | **Long**| The ID of the screen. |
 **tabId** | **Long**| The ID of the screen tab. |
 **id** | **String**| The ID of the field. |
 **moveFieldBean** | [**MoveFieldBean**](MoveFieldBean.md)|  |

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
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen, screen tab, or field is not found or the field can&#39;t be moved to the requested position. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabPost

> Object comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabPost(screenId, tabId, pos)

Move screen tab

Moves a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

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

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        Long tabId = 56L; // Long | The ID of the screen tab.
        Integer pos = 56; // Integer | The position of tab. The base index is 0.
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabPost(screenId, tabId, pos);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceMoveScreenTabPost");
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
 **screenId** | **Long**| The ID of the screen. |
 **tabId** | **Long**| The ID of the screen tab. |
 **pos** | **Integer**| The position of tab. The base index is 0. |

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
| **204** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen or screen tab is not found or the position is invalid. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceRemoveScreenTabFieldDelete

> comAtlassianJiraRestV2IssueScreensResourceRemoveScreenTabFieldDelete(screenId, tabId, id)

Remove screen tab field

Removes a field from a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        Long tabId = 56L; // Long | The ID of the screen tab.
        String id = "id_example"; // String | The ID of the field.
        try {
            apiInstance.comAtlassianJiraRestV2IssueScreensResourceRemoveScreenTabFieldDelete(screenId, tabId, id);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceRemoveScreenTabFieldDelete");
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
 **screenId** | **Long**| The ID of the screen. |
 **tabId** | **Long**| The ID of the screen tab. |
 **id** | **String**| The ID of the field. |

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
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen, screen tab, or field is not found. |  -  |


## comAtlassianJiraRestV2IssueScreensResourceRenameScreenTabPut

> ScreenableTab comAtlassianJiraRestV2IssueScreensResourceRenameScreenTabPut(screenId, tabId, screenableTab)

Update screen tab

Updates the name of a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        Long tabId = 56L; // Long | The ID of the screen tab.
        ScreenableTab screenableTab = new ScreenableTab(); // ScreenableTab | 
        try {
            ScreenableTab result = apiInstance.comAtlassianJiraRestV2IssueScreensResourceRenameScreenTabPut(screenId, tabId, screenableTab);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreensResourceRenameScreenTabPut");
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
 **screenId** | **Long**| The ID of the screen. |
 **tabId** | **Long**| The ID of the screen tab. |
 **screenableTab** | [**ScreenableTab**](ScreenableTab.md)|  |

### Return type

[**ScreenableTab**](ScreenableTab.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen or screen tab is not found. |  -  |


## comAtlassianJiraRestV2IssueScreenschemeScreenSchemeResourceGetAllScreenSchemesGet

> PageBeanScreenScheme comAtlassianJiraRestV2IssueScreenschemeScreenSchemeResourceGetAllScreenSchemesGet(startAt, maxResults)

Get all screen schemes

Returns all screen schemes.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.ScreensApi;

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

        ScreensApi apiInstance = new ScreensApi(defaultClient);
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 25; // Integer | The maximum number of items to return per page.
        try {
            PageBeanScreenScheme result = apiInstance.comAtlassianJiraRestV2IssueScreenschemeScreenSchemeResourceGetAllScreenSchemesGet(startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreensApi#comAtlassianJiraRestV2IssueScreenschemeScreenSchemeResourceGetAllScreenSchemesGet");
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
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 25]

### Return type

[**PageBeanScreenScheme**](PageBeanScreenScheme.md)

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
| **403** | Returned if the user does not have the necessary permission. |  -  |

