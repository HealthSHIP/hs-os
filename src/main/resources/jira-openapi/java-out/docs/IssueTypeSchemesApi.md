# IssueTypeSchemesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemeForProjectsGet**](IssueTypeSchemesApi.md#comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemeForProjectsGet) | **GET** /rest/api/3/issuetypescheme/project | Get issue type schemes for projects
[**comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemesMappingGet**](IssueTypeSchemesApi.md#comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemesMappingGet) | **GET** /rest/api/3/issuetypescheme/mapping | Get issue type scheme items



## comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemeForProjectsGet

> PageBeanIssueTypeSchemeProjects comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemeForProjectsGet(projectId, startAt, maxResults)

Get issue type schemes for projects

Returns a list of issue type schemes and, for each issue type scheme, a list of the projects that use it.  Only issue type schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypeSchemesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueTypeSchemesApi apiInstance = new IssueTypeSchemesApi(defaultClient);
        List<Long> projectId = Arrays.asList(); // List<Long> | The list of project IDs. To include multiple projects, separate IDs with ampersand: `projectId=10000&projectId=10001`.
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        try {
            PageBeanIssueTypeSchemeProjects result = apiInstance.comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemeForProjectsGet(projectId, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypeSchemesApi#comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemeForProjectsGet");
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

[**PageBeanIssueTypeSchemeProjects**](PageBeanIssueTypeSchemeProjects.md)

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


## comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemesMappingGet

> PageBeanIssueTypeSchemeMapping comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemesMappingGet(startAt, maxResults, issueTypeSchemeId)

Get issue type scheme items

Returns a paginated list of issue type scheme items.  Only issue type scheme items used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueTypeSchemesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueTypeSchemesApi apiInstance = new IssueTypeSchemesApi(defaultClient);
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        List<Long> issueTypeSchemeId = Arrays.asList(); // List<Long> | The list of issue type scheme IDs. To include multiple, separate IDs with ampersand: `issueTypeSchemeId=10000&issueTypeSchemeId=10001`.
        try {
            PageBeanIssueTypeSchemeMapping result = apiInstance.comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemesMappingGet(startAt, maxResults, issueTypeSchemeId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueTypeSchemesApi#comAtlassianJiraRestV2IssueIssuetypeschemeIssueTypeSchemeResourceGetIssueTypeSchemesMappingGet");
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
 **issueTypeSchemeId** | [**List&lt;Long&gt;**](Long.md)| The list of issue type scheme IDs. To include multiple, separate IDs with ampersand: &#x60;issueTypeSchemeId&#x3D;10000&amp;issueTypeSchemeId&#x3D;10001&#x60;. | [optional]

### Return type

[**PageBeanIssueTypeSchemeMapping**](PageBeanIssueTypeSchemeMapping.md)

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

