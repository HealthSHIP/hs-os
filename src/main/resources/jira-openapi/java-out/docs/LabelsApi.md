# LabelsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2LabelLabelResourceGetAllLabelsGet**](LabelsApi.md#comAtlassianJiraRestV2LabelLabelResourceGetAllLabelsGet) | **GET** /rest/api/3/label | Get all labels



## comAtlassianJiraRestV2LabelLabelResourceGetAllLabelsGet

> PageBeanString comAtlassianJiraRestV2LabelLabelResourceGetAllLabelsGet(startAt, maxResults)

Get all labels

Returns a [paginated](#pagination) list of labels.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.LabelsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        LabelsApi apiInstance = new LabelsApi(defaultClient);
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 1000; // Integer | The maximum number of items to return per page.
        try {
            PageBeanString result = apiInstance.comAtlassianJiraRestV2LabelLabelResourceGetAllLabelsGet(startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling LabelsApi#comAtlassianJiraRestV2LabelLabelResourceGetAllLabelsGet");
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
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 1000]

### Return type

[**PageBeanString**](PageBeanString.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |

