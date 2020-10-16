# IssueNavigatorSettingsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2AdminSettingsResourceGetIssueNavigatorDefaultColumnsGet**](IssueNavigatorSettingsApi.md#comAtlassianJiraRestV2AdminSettingsResourceGetIssueNavigatorDefaultColumnsGet) | **GET** /rest/api/3/settings/columns | Get issue navigator default columns
[**comAtlassianJiraRestV2AdminSettingsResourceSetIssueNavigatorDefaultColumnsPut**](IssueNavigatorSettingsApi.md#comAtlassianJiraRestV2AdminSettingsResourceSetIssueNavigatorDefaultColumnsPut) | **PUT** /rest/api/3/settings/columns | Set issue navigator default columns



## comAtlassianJiraRestV2AdminSettingsResourceGetIssueNavigatorDefaultColumnsGet

> List&lt;ColumnItem&gt; comAtlassianJiraRestV2AdminSettingsResourceGetIssueNavigatorDefaultColumnsGet()

Get issue navigator default columns

Returns the default issue navigator columns.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueNavigatorSettingsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueNavigatorSettingsApi apiInstance = new IssueNavigatorSettingsApi(defaultClient);
        try {
            List<ColumnItem> result = apiInstance.comAtlassianJiraRestV2AdminSettingsResourceGetIssueNavigatorDefaultColumnsGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueNavigatorSettingsApi#comAtlassianJiraRestV2AdminSettingsResourceGetIssueNavigatorDefaultColumnsGet");
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

[**List&lt;ColumnItem&gt;**](ColumnItem.md)

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


## comAtlassianJiraRestV2AdminSettingsResourceSetIssueNavigatorDefaultColumnsPut

> Object comAtlassianJiraRestV2AdminSettingsResourceSetIssueNavigatorDefaultColumnsPut(requestBody)

Set issue navigator default columns

Sets the default issue navigator columns.  The &#x60;columns&#x60; parameter accepts a navigable field value and is expressed as HTML form data. To specify multiple columns, pass multiple &#x60;columns&#x60; parameters. For example, in curl:  &#x60;curl -X PUT -d columns&#x3D;summary -d columns&#x3D;description https://your-domain.atlassian.net/rest/api/3/settings/columns&#x60;  If no column details are sent, then all default columns are removed.  A navigable field is one that can be used as a column on the issue navigator. Find details of navigable issue columns using [Get fields](#api-rest-api-3-field-get).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueNavigatorSettingsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueNavigatorSettingsApi apiInstance = new IssueNavigatorSettingsApi(defaultClient);
        List<String> requestBody = Arrays.asList(); // List<String> | A navigable field value.
        try {
            Object result = apiInstance.comAtlassianJiraRestV2AdminSettingsResourceSetIssueNavigatorDefaultColumnsPut(requestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueNavigatorSettingsApi#comAtlassianJiraRestV2AdminSettingsResourceSetIssueNavigatorDefaultColumnsPut");
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
 **requestBody** | [**List&lt;String&gt;**](String.md)| A navigable field value. | [optional]

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data, 
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if invalid parameters are passed. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if a navigable field value is not found. |  -  |

