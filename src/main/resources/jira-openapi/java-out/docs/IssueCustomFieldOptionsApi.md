# IssueCustomFieldOptionsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceCreateCustomFieldOptionsPost**](IssueCustomFieldOptionsApi.md#comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceCreateCustomFieldOptionsPost) | **POST** /rest/api/3/customField/{fieldId}/option | Create custom field options
[**comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceGetOptionsForFieldGet**](IssueCustomFieldOptionsApi.md#comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceGetOptionsForFieldGet) | **GET** /rest/api/3/customField/{fieldId}/option | Get options for field
[**comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceUpdateCustomFieldOptionsPut**](IssueCustomFieldOptionsApi.md#comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceUpdateCustomFieldOptionsPut) | **PUT** /rest/api/3/customField/{fieldId}/option | Update custom field options
[**comAtlassianJiraRestV2IssueCustomfieldCustomFieldOptionResourceGetCustomFieldOptionGet**](IssueCustomFieldOptionsApi.md#comAtlassianJiraRestV2IssueCustomfieldCustomFieldOptionResourceGetCustomFieldOptionGet) | **GET** /rest/api/3/customFieldOption/{id} | Get custom field option



## comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceCreateCustomFieldOptionsPost

> Object comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceCreateCustomFieldOptionsPost(fieldId, bulkCreateCustomFieldOptionRequest)

Create custom field options

Creates options and, where the custom select field is of the type *Select List (cascading)*, cascading options for a custom select field. The options are added to the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        Long fieldId = 56L; // Long | The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
        BulkCreateCustomFieldOptionRequest bulkCreateCustomFieldOptionRequest = {"options":[{"cascadingOptions":[],"value":"Option value"},{"cascadingOptions":["Child option"],"value":"Other option value"},{"cascadingOptions":["Sub-option","Sub-option 2"],"value":"Third option value"}]}; // BulkCreateCustomFieldOptionRequest | 
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceCreateCustomFieldOptionsPost(fieldId, bulkCreateCustomFieldOptionRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceCreateCustomFieldOptionsPost");
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
 **fieldId** | **Long**| The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. |
 **bulkCreateCustomFieldOptionRequest** | [**BulkCreateCustomFieldOptionRequest**](BulkCreateCustomFieldOptionRequest.md)|  |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the field is not found. |  -  |


## comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceGetOptionsForFieldGet

> PageBeanCustomFieldOptionDetails comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceGetOptionsForFieldGet(fieldId, startAt, maxResults)

Get options for field

Returns the options and, where the custom select field is of the type *Select List (cascading)*, cascading options for custom select fields. Cascading options are included in the item count when determining pagination. Only options from the global context are returned.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        Long fieldId = 56L; // Long | The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 1000; // Integer | The maximum number of items to return per page.
        try {
            PageBeanCustomFieldOptionDetails result = apiInstance.comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceGetOptionsForFieldGet(fieldId, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceGetOptionsForFieldGet");
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
 **fieldId** | **Long**| The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 1000]

### Return type

[**PageBeanCustomFieldOptionDetails**](PageBeanCustomFieldOptionDetails.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the field is not found. |  -  |


## comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceUpdateCustomFieldOptionsPut

> Object comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceUpdateCustomFieldOptionsPut(fieldId, updateCustomFieldOption)

Update custom field options

Updates the options on a custom select field. Where an updated option is in use on an issue, the value on the issue is also updated. Options that are not found are ignored. A maximum of 1000 options, including sub-options of *Select List (cascading)* fields, can be updated per request. The options are updated on the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        Long fieldId = 56L; // Long | The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
        UpdateCustomFieldOption updateCustomFieldOption = {"options":[{"newValue":"New option","value":"Option"},{"cascadingOptions":[{"newValue":"New first child option","value":"First child option"}],"newValue":"Second option","value":"Second option"},{"cascadingOptions":[{"newValue":"New second child option","value":"Second child option"},{"newValue":"New third child option","value":"Third child option"}],"newValue":"New third option value","value":"Third option value"}]}; // UpdateCustomFieldOption | 
        try {
            Object result = apiInstance.comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceUpdateCustomFieldOptionsPut(fieldId, updateCustomFieldOption);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceUpdateCustomFieldOptionsPut");
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
 **fieldId** | **Long**| The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. |
 **updateCustomFieldOption** | [**UpdateCustomFieldOption**](UpdateCustomFieldOption.md)|  |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the field is not found. |  -  |


## comAtlassianJiraRestV2IssueCustomfieldCustomFieldOptionResourceGetCustomFieldOptionGet

> CustomFieldOption comAtlassianJiraRestV2IssueCustomfieldCustomFieldOptionResourceGetCustomFieldOptionGet(id)

Get custom field option

Returns a custom field option. For example, an option in a select list.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueCustomFieldOptionsApi;

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

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        String id = "id_example"; // String | The ID of the custom field option.
        try {
            CustomFieldOption result = apiInstance.comAtlassianJiraRestV2IssueCustomfieldCustomFieldOptionResourceGetCustomFieldOptionGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#comAtlassianJiraRestV2IssueCustomfieldCustomFieldOptionResourceGetCustomFieldOptionGet");
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
 **id** | **String**| The ID of the custom field option. |

### Return type

[**CustomFieldOption**](CustomFieldOption.md)

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
| **404** | Returned if:   *  the custom field option is not found.  *  the user does not have permission to view the custom field. |  -  |

