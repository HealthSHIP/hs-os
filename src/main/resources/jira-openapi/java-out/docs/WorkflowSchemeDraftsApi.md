# WorkflowSchemeDraftsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceCreateWorkflowSchemeDraftFromParentPost**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceCreateWorkflowSchemeDraftFromParentPost) | **POST** /rest/api/3/workflowscheme/{id}/createdraft | Create draft workflow scheme
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftDefaultWorkflowDelete**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftDefaultWorkflowDelete) | **DELETE** /rest/api/3/workflowscheme/{id}/draft/default | Delete draft default workflow
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftWorkflowMappingDelete**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftWorkflowMappingDelete) | **DELETE** /rest/api/3/workflowscheme/{id}/draft/workflow | Delete issue types for workflow in draft workflow scheme
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftDelete**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftDelete) | **DELETE** /rest/api/3/workflowscheme/{id}/draft | Delete draft workflow scheme
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftIssueTypeDelete**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftIssueTypeDelete) | **DELETE** /rest/api/3/workflowscheme/{id}/draft/issuetype/{issueType} | Delete workflow for issue type in draft workflow scheme
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftDefaultWorkflowGet**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftDefaultWorkflowGet) | **GET** /rest/api/3/workflowscheme/{id}/draft/default | Get draft default workflow
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftWorkflowGet**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftWorkflowGet) | **GET** /rest/api/3/workflowscheme/{id}/draft/workflow | Get issue types for workflows in draft workflow scheme
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftGet**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftGet) | **GET** /rest/api/3/workflowscheme/{id}/draft | Get draft workflow scheme
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftIssueTypeGet**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftIssueTypeGet) | **GET** /rest/api/3/workflowscheme/{id}/draft/issuetype/{issueType} | Get workflow for issue type in draft workflow scheme
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceSetWorkflowSchemeDraftIssueTypePut**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceSetWorkflowSchemeDraftIssueTypePut) | **PUT** /rest/api/3/workflowscheme/{id}/draft/issuetype/{issueType} | Set workflow for issue type in draft workflow scheme
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftDefaultWorkflowPut**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftDefaultWorkflowPut) | **PUT** /rest/api/3/workflowscheme/{id}/draft/default | Update draft default workflow
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftWorkflowMappingPut**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftWorkflowMappingPut) | **PUT** /rest/api/3/workflowscheme/{id}/draft/workflow | Set issue types for workflow in workflow scheme
[**comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateWorkflowSchemeDraftPut**](WorkflowSchemeDraftsApi.md#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateWorkflowSchemeDraftPut) | **PUT** /rest/api/3/workflowscheme/{id}/draft | Update draft workflow scheme



## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceCreateWorkflowSchemeDraftFromParentPost

> WorkflowScheme comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceCreateWorkflowSchemeDraftFromParentPost(id)

Create draft workflow scheme

Create a draft workflow scheme from an active workflow scheme, by copying the active workflow scheme. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the active workflow scheme that the draft is created from.
        try {
            WorkflowScheme result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceCreateWorkflowSchemeDraftFromParentPost(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceCreateWorkflowSchemeDraftFromParentPost");
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
 **id** | **Long**| The ID of the active workflow scheme that the draft is created from. |

### Return type

[**WorkflowScheme**](WorkflowScheme.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftDefaultWorkflowDelete

> WorkflowScheme comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftDefaultWorkflowDelete(id)

Delete draft default workflow

Resets the default workflow for a workflow scheme&#39;s draft. That is, the default workflow is set to Jira&#39;s system workflow (the *jira* workflow).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the workflow scheme that the draft belongs to.
        try {
            WorkflowScheme result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftDefaultWorkflowDelete(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftDefaultWorkflowDelete");
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
 **id** | **Long**| The ID of the workflow scheme that the draft belongs to. |

### Return type

[**WorkflowScheme**](WorkflowScheme.md)

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
| **404** | Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftWorkflowMappingDelete

> comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftWorkflowMappingDelete(id, workflowName)

Delete issue types for workflow in draft workflow scheme

Deletes the workflow-issue type mapping for a workflow in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the workflow scheme that the draft belongs to.
        String workflowName = "workflowName_example"; // String | The name of the workflow.
        try {
            apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftWorkflowMappingDelete(id, workflowName);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftWorkflowMappingDelete");
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
 **id** | **Long**| The ID of the workflow scheme that the draft belongs to. |
 **workflowName** | **String**| The name of the workflow. |

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
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.  *  The workflow is not found.  *  The workflow is not specified. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftDelete

> comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftDelete(id)

Delete draft workflow scheme

Deletes a draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the active workflow scheme that the draft was created from.
        try {
            apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftDelete(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftDelete");
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
 **id** | **Long**| The ID of the active workflow scheme that the draft was created from. |

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
| **403** | Returned if the user does not have the necessary permission.. |  -  |
| **404** | Returned if:   *  the original active workflow scheme is not found.  *  the original active workflow scheme does not have a draft. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftIssueTypeDelete

> WorkflowScheme comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftIssueTypeDelete(id, issueType)

Delete workflow for issue type in draft workflow scheme

Deletes the issue type-workflow mapping for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the workflow scheme that the draft belongs to.
        String issueType = "issueType_example"; // String | The ID of the issue type.
        try {
            WorkflowScheme result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftIssueTypeDelete(id, issueType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftIssueTypeDelete");
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
 **id** | **Long**| The ID of the workflow scheme that the draft belongs to. |
 **issueType** | **String**| The ID of the issue type. |

### Return type

[**WorkflowScheme**](WorkflowScheme.md)

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
| **404** | Returned if the workflow scheme or issue type is not found. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftDefaultWorkflowGet

> DefaultWorkflow comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftDefaultWorkflowGet(id)

Get draft default workflow

Returns the default workflow for a workflow scheme&#39;s draft. The default workflow is the workflow that is assigned any issue types that have not been mapped to any other workflow. The default workflow has *All Unassigned Issue Types* listed in its issue types for the workflow scheme in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the workflow scheme that the draft belongs to.
        try {
            DefaultWorkflow result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftDefaultWorkflowGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftDefaultWorkflowGet");
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
 **id** | **Long**| The ID of the workflow scheme that the draft belongs to. |

### Return type

[**DefaultWorkflow**](DefaultWorkflow.md)

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
| **403** | Returned if the user does not have the necessary permission.. |  -  |
| **404** | Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftWorkflowGet

> IssueTypesWorkflowMapping comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftWorkflowGet(id, workflowName)

Get issue types for workflows in draft workflow scheme

Returns the workflow-issue type mappings for a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the workflow scheme that the draft belongs to.
        String workflowName = "workflowName_example"; // String | The name of a workflow in the scheme. Limits the results to the workflow-issue type mapping for the specified workflow.
        try {
            IssueTypesWorkflowMapping result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftWorkflowGet(id, workflowName);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftWorkflowGet");
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
 **id** | **Long**| The ID of the workflow scheme that the draft belongs to. |
 **workflowName** | **String**| The name of a workflow in the scheme. Limits the results to the workflow-issue type mapping for the specified workflow. | [optional]

### Return type

[**IssueTypesWorkflowMapping**](IssueTypesWorkflowMapping.md)

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
| **404** | Returned if either the workflow scheme or workflow (if specified) is not found. session. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftGet

> WorkflowScheme comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftGet(id)

Get draft workflow scheme

Returns the draft workflow scheme for an active workflow scheme. Draft workflow schemes allow changes to be made to the active workflow schemes: When an active workflow scheme is updated, a draft copy is created. The draft is modified, then the changes in the draft are copied back to the active workflow scheme. See [Configuring workflow schemes](https://confluence.atlassian.com/x/tohKLg) for more information.   Note that:   *  Only active workflow schemes can have draft workflow schemes.  *  An active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the active workflow scheme that the draft was created from.
        try {
            WorkflowScheme result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftGet");
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
 **id** | **Long**| The ID of the active workflow scheme that the draft was created from. |

### Return type

[**WorkflowScheme**](WorkflowScheme.md)

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
| **404** | Returned if:   *  the original active workflow scheme is not found.  *  the original active workflow scheme does not have a draft. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftIssueTypeGet

> IssueTypeWorkflowMapping comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftIssueTypeGet(id, issueType)

Get workflow for issue type in draft workflow scheme

Returns the issue type-workflow mapping for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the workflow scheme that the draft belongs to.
        String issueType = "issueType_example"; // String | The ID of the issue type.
        try {
            IssueTypeWorkflowMapping result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftIssueTypeGet(id, issueType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftIssueTypeGet");
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
 **id** | **Long**| The ID of the workflow scheme that the draft belongs to. |
 **issueType** | **String**| The ID of the issue type. |

### Return type

[**IssueTypeWorkflowMapping**](IssueTypeWorkflowMapping.md)

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
| **404** | Returned if the workflow scheme or issue type is not found. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceSetWorkflowSchemeDraftIssueTypePut

> WorkflowScheme comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceSetWorkflowSchemeDraftIssueTypePut(id, issueType, issueTypeWorkflowMapping)

Set workflow for issue type in draft workflow scheme

Sets the workflow for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the workflow scheme that the draft belongs to.
        String issueType = "issueType_example"; // String | The ID of the issue type.
        IssueTypeWorkflowMapping issueTypeWorkflowMapping = {"issueType":"10000","workflow":"jira","updateDraftIfNeeded":false}; // IssueTypeWorkflowMapping | The issue type-project mapping.
        try {
            WorkflowScheme result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceSetWorkflowSchemeDraftIssueTypePut(id, issueType, issueTypeWorkflowMapping);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceSetWorkflowSchemeDraftIssueTypePut");
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
 **id** | **Long**| The ID of the workflow scheme that the draft belongs to. |
 **issueType** | **String**| The ID of the issue type. |
 **issueTypeWorkflowMapping** | [**IssueTypeWorkflowMapping**](IssueTypeWorkflowMapping.md)| The issue type-project mapping. |

### Return type

[**WorkflowScheme**](WorkflowScheme.md)

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
| **404** | Returned if the workflow scheme or issue type is not found. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftDefaultWorkflowPut

> WorkflowScheme comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftDefaultWorkflowPut(id, defaultWorkflow)

Update draft default workflow

Sets the default workflow for a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the workflow scheme that the draft belongs to.
        DefaultWorkflow defaultWorkflow = {"workflow":"jira","updateDraftIfNeeded":false}; // DefaultWorkflow | The object for the new default workflow.
        try {
            WorkflowScheme result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftDefaultWorkflowPut(id, defaultWorkflow);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftDefaultWorkflowPut");
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
 **id** | **Long**| The ID of the workflow scheme that the draft belongs to. |
 **defaultWorkflow** | [**DefaultWorkflow**](DefaultWorkflow.md)| The object for the new default workflow. |

### Return type

[**WorkflowScheme**](WorkflowScheme.md)

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
| **404** | Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftWorkflowMappingPut

> WorkflowScheme comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftWorkflowMappingPut(id, workflowName, issueTypesWorkflowMapping)

Set issue types for workflow in workflow scheme

Sets the issue types for a workflow in a workflow scheme&#39;s draft. The workflow can also be set as the default workflow for the draft workflow scheme. Unmapped issues types are mapped to the default workflow.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the workflow scheme that the draft belongs to.
        String workflowName = "workflowName_example"; // String | The name of the workflow.
        IssueTypesWorkflowMapping issueTypesWorkflowMapping = {"workflow":"jira","updateDraftIfNeeded":true,"issueTypes":["10000"]}; // IssueTypesWorkflowMapping | 
        try {
            WorkflowScheme result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftWorkflowMappingPut(id, workflowName, issueTypesWorkflowMapping);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftWorkflowMappingPut");
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
 **id** | **Long**| The ID of the workflow scheme that the draft belongs to. |
 **workflowName** | **String**| The name of the workflow. |
 **issueTypesWorkflowMapping** | [**IssueTypesWorkflowMapping**](IssueTypesWorkflowMapping.md)|  |

### Return type

[**WorkflowScheme**](WorkflowScheme.md)

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
| **404** | Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.  *  The workflow is not found.  *  The workflow is not specified. |  -  |


## comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateWorkflowSchemeDraftPut

> WorkflowScheme comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateWorkflowSchemeDraftPut(id, workflowScheme)

Update draft workflow scheme

Updates a draft workflow scheme. If a draft workflow scheme does not exist for the active workflow scheme, then a draft is created. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WorkflowSchemeDraftsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowSchemeDraftsApi apiInstance = new WorkflowSchemeDraftsApi(defaultClient);
        Long id = 56L; // Long | The ID of the active workflow scheme that the draft was created from.
        WorkflowScheme workflowScheme = {"defaultWorkflow":"jira","updateDraftIfNeeded":false,"name":"Example workflow scheme","description":"The description of the example workflow scheme.","issueTypeMappings":{"10000":"scrum workflow"}}; // WorkflowScheme | 
        try {
            WorkflowScheme result = apiInstance.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateWorkflowSchemeDraftPut(id, workflowScheme);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowSchemeDraftsApi#comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateWorkflowSchemeDraftPut");
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
 **id** | **Long**| The ID of the active workflow scheme that the draft was created from. |
 **workflowScheme** | [**WorkflowScheme**](WorkflowScheme.md)|  |

### Return type

[**WorkflowScheme**](WorkflowScheme.md)

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
| **404** | Returned if:   *  the original active workflow scheme is not found.  *  the original active workflow scheme does not have a draft. |  -  |

