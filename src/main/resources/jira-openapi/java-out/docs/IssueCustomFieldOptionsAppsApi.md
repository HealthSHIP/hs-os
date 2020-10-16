# IssueCustomFieldOptionsAppsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceCreateIssueFieldOptionPost**](IssueCustomFieldOptionsAppsApi.md#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceCreateIssueFieldOptionPost) | **POST** /rest/api/3/field/{fieldKey}/option | Create issue field option
[**comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceDeleteIssueFieldOptionDelete**](IssueCustomFieldOptionsAppsApi.md#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceDeleteIssueFieldOptionDelete) | **DELETE** /rest/api/3/field/{fieldKey}/option/{optionId} | Delete issue field option
[**comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetAllIssueFieldOptionsGet**](IssueCustomFieldOptionsAppsApi.md#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetAllIssueFieldOptionsGet) | **GET** /rest/api/3/field/{fieldKey}/option | Get all issue field options
[**comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetIssueFieldOptionGet**](IssueCustomFieldOptionsAppsApi.md#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetIssueFieldOptionGet) | **GET** /rest/api/3/field/{fieldKey}/option/{optionId} | Get issue field option
[**comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetSelectableIssueFieldOptionsGet**](IssueCustomFieldOptionsAppsApi.md#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetSelectableIssueFieldOptionsGet) | **GET** /rest/api/3/field/{fieldKey}/option/suggestions/edit | Get selectable issue field options
[**comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetVisibleIssueFieldOptionsGet**](IssueCustomFieldOptionsAppsApi.md#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetVisibleIssueFieldOptionsGet) | **GET** /rest/api/3/field/{fieldKey}/option/suggestions/search | Get visible issue field options
[**comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceReplaceIssueFieldOptionDelete**](IssueCustomFieldOptionsAppsApi.md#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceReplaceIssueFieldOptionDelete) | **DELETE** /rest/api/3/field/{fieldKey}/option/{optionId}/issue | Replace issue field option
[**comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceUpdateIssueFieldOptionPut**](IssueCustomFieldOptionsAppsApi.md#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceUpdateIssueFieldOptionPut) | **PUT** /rest/api/3/field/{fieldKey}/option/{optionId} | Update issue field option



## comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceCreateIssueFieldOptionPost

> IssueFieldOption comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceCreateIssueFieldOptionPost(fieldKey, requestBody)

Create issue field option

Creates an option for a select list issue field.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsAppsApi;

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

        IssueCustomFieldOptionsAppsApi apiInstance = new IssueCustomFieldOptionsAppsApi(defaultClient);
        String fieldKey = "fieldKey_example"; // String | The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the `fieldKey` value, do one of the following:   *  open the app's plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the `jiraIssueFields` module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in `key`. For example, `\"key\": \"teams-add-on__team-issue-field\"`
        Map<String, Object> requestBody = {"value":"Team 1","config":{"scope":{"projects2":[{"attributes":["notSelectable"],"id":1002},{"attributes":["notSelectable"],"id":1001}],"projects":[],"global":{}},"attributes":[]},"properties":{"leader":{"name":"Leader Name","email":"lname@example.com"},"members":42,"founded":"2016-06-06T00:00:00.000Z","description":"The team's description"}}; // Map<String, Object> | 
        try {
            IssueFieldOption result = apiInstance.comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceCreateIssueFieldOptionPost(fieldKey, requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsAppsApi#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceCreateIssueFieldOptionPost");
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
 **fieldKey** | **String**| The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60; |
 **requestBody** | [**Map&lt;String, Object&gt;**](Object.md)|  |

### Return type

[**IssueFieldOption**](IssueFieldOption.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the option is invalid. |  -  |
| **403** | Returned if the request is not authenticated as a Jira administrator or the app that provided the field. |  -  |
| **404** | Returned if the field is not found or does not support options. |  -  |


## comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceDeleteIssueFieldOptionDelete

> Object comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceDeleteIssueFieldOptionDelete(fieldKey, optionId)

Delete issue field option

Deletes an option from a select list issue field.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsAppsApi;

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

        IssueCustomFieldOptionsAppsApi apiInstance = new IssueCustomFieldOptionsAppsApi(defaultClient);
        String fieldKey = "fieldKey_example"; // String | The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the `fieldKey` value, do one of the following:   *  open the app's plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the `jiraIssueFields` module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in `key`. For example, `\"key\": \"teams-add-on__team-issue-field\"`
        Long optionId = 56L; // Long | The ID of the option to be deleted.
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceDeleteIssueFieldOptionDelete(fieldKey, optionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsAppsApi#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceDeleteIssueFieldOptionDelete");
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
 **fieldKey** | **String**| The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60; |
 **optionId** | **Long**| The ID of the option to be deleted. |

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
| **204** | Returned if the field option is deleted. |  -  |
| **403** | Returned if the request is not authenticated as a Jira administrator or the app that provided the field. |  -  |
| **404** | Returned if the field or option is not found. |  -  |
| **409** | Returned if the option is selected for the field in any issue. |  -  |


## comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetAllIssueFieldOptionsGet

> PageBeanIssueFieldOption comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetAllIssueFieldOptionsGet(fieldKey, startAt, maxResults)

Get all issue field options

Returns all the options of a select list issue field. A select list issue field is a type of [issue field](https://developer.atlassian.com/cloud/jira/platform/modules/issue-field/) that enables a user to select a value from a list of options.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsAppsApi;

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

        IssueCustomFieldOptionsAppsApi apiInstance = new IssueCustomFieldOptionsAppsApi(defaultClient);
        String fieldKey = "fieldKey_example"; // String | The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the `fieldKey` value, do one of the following:   *  open the app's plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the `jiraIssueFields` module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in `key`. For example, `\"key\": \"teams-add-on__team-issue-field\"`
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        try {
            PageBeanIssueFieldOption result = apiInstance.comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetAllIssueFieldOptionsGet(fieldKey, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsAppsApi#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetAllIssueFieldOptionsGet");
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
 **fieldKey** | **String**| The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60; |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]

### Return type

[**PageBeanIssueFieldOption**](PageBeanIssueFieldOption.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the field is not found or does not support options. |  -  |
| **403** | Returned if the request is not authenticated as a Jira administrator or the app that provided the field. |  -  |


## comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetIssueFieldOptionGet

> IssueFieldOption comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetIssueFieldOptionGet(fieldKey, optionId)

Get issue field option

Returns an option from a select list issue field.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsAppsApi;

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

        IssueCustomFieldOptionsAppsApi apiInstance = new IssueCustomFieldOptionsAppsApi(defaultClient);
        String fieldKey = "fieldKey_example"; // String | The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the `fieldKey` value, do one of the following:   *  open the app's plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the `jiraIssueFields` module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in `key`. For example, `\"key\": \"teams-add-on__team-issue-field\"`
        Long optionId = 56L; // Long | The ID of the option to be returned.
        try {
            IssueFieldOption result = apiInstance.comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetIssueFieldOptionGet(fieldKey, optionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsAppsApi#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetIssueFieldOptionGet");
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
 **fieldKey** | **String**| The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60; |
 **optionId** | **Long**| The ID of the option to be returned. |

### Return type

[**IssueFieldOption**](IssueFieldOption.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested option is returned. |  -  |
| **400** | Returned if the field is not found or does not support options. |  -  |
| **403** | Returned if the request is not authenticated as a Jira administrator or the app that provided the field. |  -  |
| **404** | Returned if the option is not found. |  -  |


## comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetSelectableIssueFieldOptionsGet

> PageBeanIssueFieldOption comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetSelectableIssueFieldOptionsGet(fieldKey, startAt, maxResults, projectId)

Get selectable issue field options

Returns options for a select list issue field that can be viewed and selected by the user.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsAppsApi;

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

        IssueCustomFieldOptionsAppsApi apiInstance = new IssueCustomFieldOptionsAppsApi(defaultClient);
        String fieldKey = "fieldKey_example"; // String | The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the `fieldKey` value, do one of the following:   *  open the app's plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the `jiraIssueFields` module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in `key`. For example, `\"key\": \"teams-add-on__team-issue-field\"`
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        Long projectId = 56L; // Long | Filters the results to options that are only available in the specified project.
        try {
            PageBeanIssueFieldOption result = apiInstance.comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetSelectableIssueFieldOptionsGet(fieldKey, startAt, maxResults, projectId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsAppsApi#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetSelectableIssueFieldOptionsGet");
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
 **fieldKey** | **String**| The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60; |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]
 **projectId** | **Long**| Filters the results to options that are only available in the specified project. | [optional]

### Return type

[**PageBeanIssueFieldOption**](PageBeanIssueFieldOption.md)

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
| **404** | Returned if the field is not found or does not support options. |  -  |


## comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetVisibleIssueFieldOptionsGet

> PageBeanIssueFieldOption comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetVisibleIssueFieldOptionsGet(fieldKey, startAt, maxResults, projectId)

Get visible issue field options

Returns options for a select list issue field that can be viewed by the user.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsAppsApi;

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

        IssueCustomFieldOptionsAppsApi apiInstance = new IssueCustomFieldOptionsAppsApi(defaultClient);
        String fieldKey = "fieldKey_example"; // String | The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the `fieldKey` value, do one of the following:   *  open the app's plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the `jiraIssueFields` module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in `key`. For example, `\"key\": \"teams-add-on__team-issue-field\"`
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 56; // Integer | The maximum number of items to return per page.
        Long projectId = 56L; // Long | Filters the results to options that are only available in the specified project.
        try {
            PageBeanIssueFieldOption result = apiInstance.comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetVisibleIssueFieldOptionsGet(fieldKey, startAt, maxResults, projectId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsAppsApi#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceGetVisibleIssueFieldOptionsGet");
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
 **fieldKey** | **String**| The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60; |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional]
 **projectId** | **Long**| Filters the results to options that are only available in the specified project. | [optional]

### Return type

[**PageBeanIssueFieldOption**](PageBeanIssueFieldOption.md)

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
| **404** | Returned if the field is not found or does not support options. |  -  |


## comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceReplaceIssueFieldOptionDelete

> comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceReplaceIssueFieldOptionDelete(fieldKey, optionId, replaceWith, jql)

Replace issue field option

Deselects an issue-field select-list option from all issues where it is selected. A different option can be selected to replace the deselected option. The update can also be limited to a smaller set of issues by using a JQL query.  This is an [asynchronous operation](#async). The response object contains a link to the long-running task.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsAppsApi;

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

        IssueCustomFieldOptionsAppsApi apiInstance = new IssueCustomFieldOptionsAppsApi(defaultClient);
        String fieldKey = "fieldKey_example"; // String | The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the `fieldKey` value, do one of the following:   *  open the app's plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the `jiraIssueFields` module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in `key`. For example, `\"key\": \"teams-add-on__team-issue-field\"`
        Long optionId = 56L; // Long | The ID of the option to be deselected.
        Long replaceWith = 56L; // Long | The ID of the option that will replace the currently selected option.
        String jql = "jql_example"; // String | A JQL query that specifies the issues to be updated. For example, *project=10000*.
        try {
            apiInstance.comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceReplaceIssueFieldOptionDelete(fieldKey, optionId, replaceWith, jql);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsAppsApi#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceReplaceIssueFieldOptionDelete");
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
 **fieldKey** | **String**| The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60; |
 **optionId** | **Long**| The ID of the option to be deselected. |
 **replaceWith** | **Long**| The ID of the option that will replace the currently selected option. | [optional]
 **jql** | **String**| A JQL query that specifies the issues to be updated. For example, *project&#x3D;10000*. | [optional]

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **303** | Returned if the long-running task to deselect the option is started. |  -  |
| **400** | Returned if the JQL query is invalid. |  -  |
| **404** | Returned if the field is not found or does not support options, or the options to be replaced are not found. |  -  |


## comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceUpdateIssueFieldOptionPut

> IssueFieldOption comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceUpdateIssueFieldOptionPut(fieldKey, optionId, issueFieldOption)

Update issue field option

Updates or creates an option for a select list issue field. This operation requires that the option ID is provided when creating an option, therefore, the option ID needs to be specified as a path and body parameter. The option ID provided in the path and body must be identical.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsAppsApi;

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

        IssueCustomFieldOptionsAppsApi apiInstance = new IssueCustomFieldOptionsAppsApi(defaultClient);
        String fieldKey = "fieldKey_example"; // String | The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the `fieldKey` value, do one of the following:   *  open the app's plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the `jiraIssueFields` module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in `key`. For example, `\"key\": \"teams-add-on__team-issue-field\"`
        Long optionId = 56L; // Long | The ID of the option to be updated.
        IssueFieldOption issueFieldOption = {"id":1,"value":"Team 1","config":{"scope":{"projects2":[{"attributes":["notSelectable"],"id":1002},{"attributes":["notSelectable"],"id":1001}],"projects":[],"global":{}},"attributes":[]},"properties":{"leader":{"name":"Leader Name","email":"lname@example.com"},"members":42,"founded":"2016-06-06T00:00:00.000Z","description":"The team's description"}}; // IssueFieldOption | 
        try {
            IssueFieldOption result = apiInstance.comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceUpdateIssueFieldOptionPut(fieldKey, optionId, issueFieldOption);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsAppsApi#comAtlassianJiraRestV2IssueFieldIssueFieldOptionResourceUpdateIssueFieldOptionPut");
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
 **fieldKey** | **String**| The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60; |
 **optionId** | **Long**| The ID of the option to be updated. |
 **issueFieldOption** | [**IssueFieldOption**](IssueFieldOption.md)|  |

### Return type

[**IssueFieldOption**](IssueFieldOption.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the option is updated or created. |  -  |
| **400** | Returned if the option is invalid, or the *ID* in the request object does not match the *optionId* parameter. |  -  |
| **403** | Returned if the request is not authenticated as a Jira administrator or the app that provided the field. |  -  |
| **404** | Returned if field is not found. |  -  |

