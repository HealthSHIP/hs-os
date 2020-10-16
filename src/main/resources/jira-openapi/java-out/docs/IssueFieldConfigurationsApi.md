# IssueFieldConfigurationsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetAllFieldConfigurationsGet**](IssueFieldConfigurationsApi.md#comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetAllFieldConfigurationsGet) | **GET** /rest/api/3/fieldconfiguration | Get all field configurations
[**comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetFieldConfigurationItemsGet**](IssueFieldConfigurationsApi.md#comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetFieldConfigurationItemsGet) | **GET** /rest/api/3/fieldconfiguration/{id}/fields | Get field configuration items
[**comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeMappingsGet**](IssueFieldConfigurationsApi.md#comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeMappingsGet) | **GET** /rest/api/3/fieldconfigurationscheme/mapping | Get field configuration issue type items
[**comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeProjectMappingGet**](IssueFieldConfigurationsApi.md#comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeProjectMappingGet) | **GET** /rest/api/3/fieldconfigurationscheme/project | Get field configuration schemes for projects



## comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetAllFieldConfigurationsGet

> PageBeanFieldConfiguration comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetAllFieldConfigurationsGet(startAt, maxResults, isDefault)

Get all field configurations

Returns a paginated list of all field configurations.  Only field configurations used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueFieldConfigurationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueFieldConfigurationsApi apiInstance = new IssueFieldConfigurationsApi(defaultClient);
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        Boolean isDefault = false; // Boolean | If *true* returns the default field configuration only.
        try {
            PageBeanFieldConfiguration result = apiInstance.comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetAllFieldConfigurationsGet(startAt, maxResults, isDefault);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueFieldConfigurationsApi#comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetAllFieldConfigurationsGet");
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
 **isDefault** | **Boolean**| If *true* returns the default field configuration only. | [optional] [default to false]

### Return type

[**PageBeanFieldConfiguration**](PageBeanFieldConfiguration.md)

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


## comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetFieldConfigurationItemsGet

> PageBeanFieldConfigurationItem comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetFieldConfigurationItemsGet(id, startAt, maxResults)

Get field configuration items

Returns a paginated list of all fields for a configuration.  Only the fields from configurations used in classic objects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueFieldConfigurationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueFieldConfigurationsApi apiInstance = new IssueFieldConfigurationsApi(defaultClient);
        Long id = 56L; // Long | The ID of the field configuration.
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        try {
            PageBeanFieldConfigurationItem result = apiInstance.comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetFieldConfigurationItemsGet(id, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueFieldConfigurationsApi#comAtlassianJiraRestV2IssueFieldFieldConfigurationResourceGetFieldConfigurationItemsGet");
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
 **id** | **Long**| The ID of the field configuration. |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]

### Return type

[**PageBeanFieldConfigurationItem**](PageBeanFieldConfigurationItem.md)

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
| **404** | Returned if the field configuration is not found. |  -  |


## comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeMappingsGet

> PageBeanFieldConfigurationIssueTypeItem comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeMappingsGet(fieldConfigurationSchemeId, startAt, maxResults)

Get field configuration issue type items

Returns a paginated list of field configuration issue type items.  Only items used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueFieldConfigurationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueFieldConfigurationsApi apiInstance = new IssueFieldConfigurationsApi(defaultClient);
        List<Long> fieldConfigurationSchemeId = Arrays.asList(); // List<Long> | The list of field configuration scheme IDs. To include multiple field configuration schemes separate IDs with ampersand: `fieldConfigurationSchemeId=10000&fieldConfigurationSchemeId=10001`.
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        try {
            PageBeanFieldConfigurationIssueTypeItem result = apiInstance.comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeMappingsGet(fieldConfigurationSchemeId, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueFieldConfigurationsApi#comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeMappingsGet");
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
 **fieldConfigurationSchemeId** | [**List&lt;Long&gt;**](Long.md)| The list of field configuration scheme IDs. To include multiple field configuration schemes separate IDs with ampersand: &#x60;fieldConfigurationSchemeId&#x3D;10000&amp;fieldConfigurationSchemeId&#x3D;10001&#x60;. |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]

### Return type

[**PageBeanFieldConfigurationIssueTypeItem**](PageBeanFieldConfigurationIssueTypeItem.md)

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
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if no field configuration schemes are found. |  -  |


## comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeProjectMappingGet

> PageBeanFieldConfigurationSchemeProjects comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeProjectMappingGet(projectId, startAt, maxResults)

Get field configuration schemes for projects

Returns a paginated list of field configuration schemes and, for each scheme, a list of the projects that use it.  The list is sorted by field configuration scheme ID. The first item contains the list of project IDs not assigned to any scheme.  Only field configuration schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueFieldConfigurationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueFieldConfigurationsApi apiInstance = new IssueFieldConfigurationsApi(defaultClient);
        List<Long> projectId = Arrays.asList(); // List<Long> | The list of project IDs. To include multiple projects, separate IDs with ampersand: `projectId=10000&projectId=10001`.
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        try {
            PageBeanFieldConfigurationSchemeProjects result = apiInstance.comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeProjectMappingGet(projectId, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueFieldConfigurationsApi#comAtlassianJiraRestV2IssueFieldFieldConfigurationSchemeResourceGetFieldConfigurationSchemeProjectMappingGet");
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
 **projectId** | [**List&lt;Long&gt;**](Long.md)| The list of project IDs. To include multiple projects, separate IDs with ampersand: &#x60;projectId&#x3D;10000&amp;projectId&#x3D;10001&#x60;. |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]

### Return type

[**PageBeanFieldConfigurationSchemeProjects**](PageBeanFieldConfigurationSchemeProjects.md)

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
| **403** | Returned if the user does not have the necessary permission. |  -  |

