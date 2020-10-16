# WorkflowSchemeProjectAssociationsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2AdminWorkflowschemeProjectWorkflowSchemeProjectResourceGetWorkflowSchemeProjectAssociationsGet**](WorkflowSchemeProjectAssociationsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeProjectWorkflowSchemeProjectResourceGetWorkflowSchemeProjectAssociationsGet) | **GET** /rest/api/3/workflowscheme/project | Get workflow scheme project associations



## comAtlassianJiraRestV2AdminWorkflowschemeProjectWorkflowSchemeProjectResourceGetWorkflowSchemeProjectAssociationsGet

> ContainerOfWorkflowSchemeAssociations comAtlassianJiraRestV2AdminWorkflowschemeProjectWorkflowSchemeProjectResourceGetWorkflowSchemeProjectAssociationsGet(projectId)

Get workflow scheme project associations

Returns a list of the workflow schemes associated with a list of projects. Each returned workflow scheme includes a list of the requested projects associated with it. Any next-gen or non-existent projects in the request are ignored and no errors are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeProjectAssociationsApi;

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

        WorkflowSchemeProjectAssociationsApi apiInstance = new WorkflowSchemeProjectAssociationsApi(defaultClient);
        List<Long> projectId = Arrays.asList(); // List<Long> | The ID of a project to return the workflow schemes for. To include multiple projects, provide an ampersand-Jim: oneseparated list. For example, `projectId=10000&projectId=10001`.
        try {
            ContainerOfWorkflowSchemeAssociations result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeProjectWorkflowSchemeProjectResourceGetWorkflowSchemeProjectAssociationsGet(projectId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeProjectAssociationsApi#comAtlassianJiraRestV2AdminWorkflowschemeProjectWorkflowSchemeProjectResourceGetWorkflowSchemeProjectAssociationsGet");
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
 **projectId** | [**List&lt;Long&gt;**](Long.md)| The ID of a project to return the workflow schemes for. To include multiple projects, provide an ampersand-Jim: oneseparated list. For example, &#x60;projectId&#x3D;10000&amp;projectId&#x3D;10001&#x60;. |

### Return type

[**ContainerOfWorkflowSchemeAssociations**](ContainerOfWorkflowSchemeAssociations.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |

