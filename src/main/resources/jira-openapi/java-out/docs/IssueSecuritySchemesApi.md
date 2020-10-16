# IssueSecuritySchemesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemeGet**](IssueSecuritySchemesApi.md#comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemeGet) | **GET** /rest/api/3/issuesecurityschemes/{id} | Get issue security scheme
[**comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemesGet**](IssueSecuritySchemesApi.md#comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemesGet) | **GET** /rest/api/3/issuesecurityschemes | Get issue security schemes



## comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemeGet

> SecurityScheme comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemeGet(id)

Get issue security scheme

Returns an issue security scheme along with its security levels.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for a project that uses the requested issue security scheme.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueSecuritySchemesApi;

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

        IssueSecuritySchemesApi apiInstance = new IssueSecuritySchemesApi(defaultClient);
        Long id = 56L; // Long | The ID of the issue security scheme. Use the [Get issue security schemes](#api-rest-api-3-issuesecurityschemes-get) operation to get a list of issue security scheme IDs.
        try {
            SecurityScheme result = apiInstance.comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemeGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueSecuritySchemesApi#comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemeGet");
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
 **id** | **Long**| The ID of the issue security scheme. Use the [Get issue security schemes](#api-rest-api-3-issuesecurityschemes-get) operation to get a list of issue security scheme IDs. |

### Return type

[**SecurityScheme**](SecurityScheme.md)

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
| **403** | Returned if the user does not have the administrator permission and the scheme is not used in any project where the user has administrative permission. |  -  |


## comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemesGet

> SecuritySchemes comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemesGet()

Get issue security schemes

Returns all [issue security schemes](https://confluence.atlassian.com/x/J4lKLg).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueSecuritySchemesApi;

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

        IssueSecuritySchemesApi apiInstance = new IssueSecuritySchemesApi(defaultClient);
        try {
            SecuritySchemes result = apiInstance.comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemesGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueSecuritySchemesApi#comAtlassianJiraRestV2IssueIssueSecuritySchemeResourceGetIssueSecuritySchemesGet");
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

[**SecuritySchemes**](SecuritySchemes.md)

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
| **403** | Returned if the user does not have permission to administer issue security schemes. |  -  |

