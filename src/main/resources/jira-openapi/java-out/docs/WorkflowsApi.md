# WorkflowsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2AdminWorkflowWorkflowSearchResourceGetWorkflowsPaginatedGet**](WorkflowsApi.md#comAtlassianJiraRestV2AdminWorkflowWorkflowSearchResourceGetWorkflowsPaginatedGet) | **GET** /rest/api/3/workflow/search | Get workflows paginated
[**comAtlassianJiraRestV2AdminWorkflowsResourceGetAllWorkflowsGet**](WorkflowsApi.md#comAtlassianJiraRestV2AdminWorkflowsResourceGetAllWorkflowsGet) | **GET** /rest/api/3/workflow | Get all workflows



## comAtlassianJiraRestV2AdminWorkflowWorkflowSearchResourceGetWorkflowsPaginatedGet

> PageBeanWorkflow comAtlassianJiraRestV2AdminWorkflowWorkflowSearchResourceGetWorkflowsPaginatedGet(startAt, maxResults, workflowName, expand)

Get workflows paginated

Returns a [paginated](#pagination) list of published classic workflows. When workflow names are specified, details of those workflows are returned. Otherwise, all published classic workflows are returned.  This operation does not return next-gen workflows.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowsApi;

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

        WorkflowsApi apiInstance = new WorkflowsApi(defaultClient);
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        List<String> workflowName = Arrays.asList(); // List<String> | The name of a workflow to return.
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  `transitions` For each workflow, returns information about the transitions inside the workflow.  *  `transitions.rules` For each workflow transition, returns information about its rules. Transitions are included automatically if this expand is requested.  *  `statuses` For each workflow, returns information about the statuses inside the workflow.  *  `statuses.properties` For each workflow status, returns information about its properties. Statuses are included automatically if this expand is requested.
        try {
            PageBeanWorkflow result = apiInstance.comAtlassianJiraRestV2AdminWorkflowWorkflowSearchResourceGetWorkflowsPaginatedGet(startAt, maxResults, workflowName, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowsApi#comAtlassianJiraRestV2AdminWorkflowWorkflowSearchResourceGetWorkflowsPaginatedGet");
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
 **workflowName** | [**List&lt;String&gt;**](String.md)| The name of a workflow to return. | [optional]
 **expand** | **String**| Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;transitions&#x60; For each workflow, returns information about the transitions inside the workflow.  *  &#x60;transitions.rules&#x60; For each workflow transition, returns information about its rules. Transitions are included automatically if this expand is requested.  *  &#x60;statuses&#x60; For each workflow, returns information about the statuses inside the workflow.  *  &#x60;statuses.properties&#x60; For each workflow status, returns information about its properties. Statuses are included automatically if this expand is requested. | [optional]

### Return type

[**PageBeanWorkflow**](PageBeanWorkflow.md)

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


## comAtlassianJiraRestV2AdminWorkflowsResourceGetAllWorkflowsGet

> List&lt;DeprecatedWorkflow&gt; comAtlassianJiraRestV2AdminWorkflowsResourceGetAllWorkflowsGet(workflowName)

Get all workflows

Returns all workflows in Jira or a workflow. Deprecated, use [Get workflows paginated](#api-rest-api-3-workflow-search-get).  If the &#x60;workflowName&#x60; parameter is specified, the workflow is returned as an object (not in an array). Otherwise, an array of workflow objects is returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowsApi;

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

        WorkflowsApi apiInstance = new WorkflowsApi(defaultClient);
        String workflowName = "workflowName_example"; // String | The name of the workflow to be returned. Only one workflow can be specified.
        try {
            List<DeprecatedWorkflow> result = apiInstance.comAtlassianJiraRestV2AdminWorkflowsResourceGetAllWorkflowsGet(workflowName);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowsApi#comAtlassianJiraRestV2AdminWorkflowsResourceGetAllWorkflowsGet");
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
 **workflowName** | **String**| The name of the workflow to be returned. Only one workflow can be specified. | [optional]

### Return type

[**List&lt;DeprecatedWorkflow&gt;**](DeprecatedWorkflow.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the user does not have the necessary permission. |  -  |

