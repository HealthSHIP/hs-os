# IssueSecurityLevelApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueIssueSecurityLevelResourceGetIssueSecurityLevelGet**](IssueSecurityLevelApi.md#comAtlassianJiraRestV2IssueIssueSecurityLevelResourceGetIssueSecurityLevelGet) | **GET** /rest/api/3/securitylevel/{id} | Get issue security level



## comAtlassianJiraRestV2IssueIssueSecurityLevelResourceGetIssueSecurityLevelGet

> SecurityLevel comAtlassianJiraRestV2IssueIssueSecurityLevelResourceGetIssueSecurityLevelGet(id)

Get issue security level

Returns details of an issue security level.  Use [Get issue security scheme](#api-rest-api-3-issuesecurityschemes-id-get) to obtain the IDs of issue security levels associated with the issue security scheme.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.IssueSecurityLevelApi;

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

        IssueSecurityLevelApi apiInstance = new IssueSecurityLevelApi(defaultClient);
        String id = "id_example"; // String | The ID of the issue security level.
        try {
            SecurityLevel result = apiInstance.comAtlassianJiraRestV2IssueIssueSecurityLevelResourceGetIssueSecurityLevelGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueSecurityLevelApi#comAtlassianJiraRestV2IssueIssueSecurityLevelResourceGetIssueSecurityLevelGet");
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
 **id** | **String**| The ID of the issue security level. |

### Return type

[**SecurityLevel**](SecurityLevel.md)

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
| **404** | Returned if the issue security level is not found. |  -  |

