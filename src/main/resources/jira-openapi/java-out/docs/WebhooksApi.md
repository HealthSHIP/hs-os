# WebhooksApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2WebhookDynamicWebhookResourceDeleteWebhookByIdDelete**](WebhooksApi.md#comAtlassianJiraRestV2WebhookDynamicWebhookResourceDeleteWebhookByIdDelete) | **DELETE** /rest/api/3/webhook | Delete webhooks by ID
[**comAtlassianJiraRestV2WebhookDynamicWebhookResourceGetDynamicWebhooksForAppGet**](WebhooksApi.md#comAtlassianJiraRestV2WebhookDynamicWebhookResourceGetDynamicWebhooksForAppGet) | **GET** /rest/api/3/webhook | Get dynamic webhooks for app
[**comAtlassianJiraRestV2WebhookDynamicWebhookResourceRefreshWebhooksPut**](WebhooksApi.md#comAtlassianJiraRestV2WebhookDynamicWebhookResourceRefreshWebhooksPut) | **PUT** /rest/api/3/webhook/refresh | Extend webhook life
[**comAtlassianJiraRestV2WebhookDynamicWebhookResourceRegisterDynamicWebhooksPost**](WebhooksApi.md#comAtlassianJiraRestV2WebhookDynamicWebhookResourceRegisterDynamicWebhooksPost) | **POST** /rest/api/3/webhook | Register dynamic webhooks
[**comAtlassianJiraRestV2WebhookFailedWebhookResourceGetFailedWebhooksGet**](WebhooksApi.md#comAtlassianJiraRestV2WebhookFailedWebhookResourceGetFailedWebhooksGet) | **GET** /rest/api/3/webhook/failed | Get failed webhooks



## comAtlassianJiraRestV2WebhookDynamicWebhookResourceDeleteWebhookByIdDelete

> comAtlassianJiraRestV2WebhookDynamicWebhookResourceDeleteWebhookByIdDelete(containerForWebhookIDs)

Delete webhooks by ID

Removes webhooks by ID. Only webhooks registered by the calling Connect app are removed. If webhooks created by other apps are specified, they are ignored.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WebhooksApi;

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

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        ContainerForWebhookIDs containerForWebhookIDs = {"webhookIds":[10000,10001,10042]}; // ContainerForWebhookIDs | 
        try {
            apiInstance.comAtlassianJiraRestV2WebhookDynamicWebhookResourceDeleteWebhookByIdDelete(containerForWebhookIDs);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#comAtlassianJiraRestV2WebhookDynamicWebhookResourceDeleteWebhookByIdDelete");
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
 **containerForWebhookIDs** | [**ContainerForWebhookIDs**](ContainerForWebhookIDs.md)|  |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Returned if the request is successful. |  -  |
| **400** | Returned if the list of webhook IDs is missing. |  -  |
| **403** | Returned if the caller is not a Connect app. |  -  |


## comAtlassianJiraRestV2WebhookDynamicWebhookResourceGetDynamicWebhooksForAppGet

> PageBeanWebhook comAtlassianJiraRestV2WebhookDynamicWebhookResourceGetDynamicWebhooksForAppGet(startAt, maxResults)

Get dynamic webhooks for app

Returns the webhooks registered by the calling app.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WebhooksApi;

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

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        Long startAt = 0lL; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 100; // Integer | The maximum number of items to return per page.
        try {
            PageBeanWebhook result = apiInstance.comAtlassianJiraRestV2WebhookDynamicWebhookResourceGetDynamicWebhooksForAppGet(startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#comAtlassianJiraRestV2WebhookDynamicWebhookResourceGetDynamicWebhooksForAppGet");
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
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 100]

### Return type

[**PageBeanWebhook**](PageBeanWebhook.md)

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
| **403** | Returned if the caller is not a Connect app. |  -  |


## comAtlassianJiraRestV2WebhookDynamicWebhookResourceRefreshWebhooksPut

> WebhooksExpirationDate comAtlassianJiraRestV2WebhookDynamicWebhookResourceRefreshWebhooksPut(containerForWebhookIDs)

Extend webhook life

Webhooks registered through the REST API expire after 30 days. Call this resource periodically to keep them alive.  Unrecognized webhook IDs (nonexistent or belonging to other apps) are ignored.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WebhooksApi;

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

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        ContainerForWebhookIDs containerForWebhookIDs = {"webhookIds":[10000,10001,10042]}; // ContainerForWebhookIDs | 
        try {
            WebhooksExpirationDate result = apiInstance.comAtlassianJiraRestV2WebhookDynamicWebhookResourceRefreshWebhooksPut(containerForWebhookIDs);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#comAtlassianJiraRestV2WebhookDynamicWebhookResourceRefreshWebhooksPut");
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
 **containerForWebhookIDs** | [**ContainerForWebhookIDs**](ContainerForWebhookIDs.md)|  |

### Return type

[**WebhooksExpirationDate**](WebhooksExpirationDate.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **403** | Returned if the caller is not a Connect app. |  -  |


## comAtlassianJiraRestV2WebhookDynamicWebhookResourceRegisterDynamicWebhooksPost

> ContainerForRegisteredWebhooks comAtlassianJiraRestV2WebhookDynamicWebhookResourceRegisterDynamicWebhooksPost(webhookRegistrationDetails)

Register dynamic webhooks

Registers webhooks.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WebhooksApi;

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

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        WebhookRegistrationDetails webhookRegistrationDetails = {"webhooks":[{"jqlFilter":"project = PROJ","events":["jira:issue_created","jira:issue_updated"]},{"jqlFilter":"project IN (PROJ, EXP) AND status = done","events":["jira:issue_deleted"]}],"url":"https://your-app.example.com/webhook-received"}; // WebhookRegistrationDetails | 
        try {
            ContainerForRegisteredWebhooks result = apiInstance.comAtlassianJiraRestV2WebhookDynamicWebhookResourceRegisterDynamicWebhooksPost(webhookRegistrationDetails);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#comAtlassianJiraRestV2WebhookDynamicWebhookResourceRegisterDynamicWebhooksPost");
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
 **webhookRegistrationDetails** | [**WebhookRegistrationDetails**](WebhookRegistrationDetails.md)|  |

### Return type

[**ContainerForRegisteredWebhooks**](ContainerForRegisteredWebhooks.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **403** | Returned if the caller is not a Connect app. |  -  |


## comAtlassianJiraRestV2WebhookFailedWebhookResourceGetFailedWebhooksGet

> FailedWebhooks comAtlassianJiraRestV2WebhookFailedWebhookResourceGetFailedWebhooksGet(maxResults, after)

Get failed webhooks

Returns webhooks that have recently failed to be delivered to the requesting app after the maximum number of retries.  After 72 hours the failure may no longer be returned by this operation.  The oldest failure is returned first.  This method uses a cursor-based pagination. To request the next page use the failure time of the last webhook on the list as the &#x60;failedAfter&#x60; value or use the URL provided in &#x60;next&#x60;.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.WebhooksApi;

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

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        Integer maxResults = 56; // Integer | The maximum number of webhooks to return per page. If obeying the maxResults directive would result in records with the same failure time being split across pages, the directive is ignored and all records with the same failure time included on the page.
        Long after = 56L; // Long | The time after which any webhook failure must have occurred for the record to be returned, expressed as milliseconds since the UNIX epoch.
        try {
            FailedWebhooks result = apiInstance.comAtlassianJiraRestV2WebhookFailedWebhookResourceGetFailedWebhooksGet(maxResults, after);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#comAtlassianJiraRestV2WebhookFailedWebhookResourceGetFailedWebhooksGet");
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
 **maxResults** | **Integer**| The maximum number of webhooks to return per page. If obeying the maxResults directive would result in records with the same failure time being split across pages, the directive is ignored and all records with the same failure time included on the page. | [optional]
 **after** | **Long**| The time after which any webhook failure must have occurred for the record to be returned, expressed as milliseconds since the UNIX epoch. | [optional]

### Return type

[**FailedWebhooks**](FailedWebhooks.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | 400 response |  -  |
| **403** | Returned if the caller is not a Connect app. |  -  |

