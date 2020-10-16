# TimeTrackingApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetAvailableTimeTrackingImplementationsGet**](TimeTrackingApi.md#comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetAvailableTimeTrackingImplementationsGet) | **GET** /rest/api/3/configuration/timetracking/list | Get all time tracking providers
[**comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSelectedTimeTrackingImplementationGet**](TimeTrackingApi.md#comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSelectedTimeTrackingImplementationGet) | **GET** /rest/api/3/configuration/timetracking | Get selected time tracking provider
[**comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSharedTimeTrackingConfigurationGet**](TimeTrackingApi.md#comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSharedTimeTrackingConfigurationGet) | **GET** /rest/api/3/configuration/timetracking/options | Get time tracking settings
[**comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSelectTimeTrackingImplementationPut**](TimeTrackingApi.md#comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSelectTimeTrackingImplementationPut) | **PUT** /rest/api/3/configuration/timetracking | Select time tracking provider
[**comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSetSharedTimeTrackingConfigurationPut**](TimeTrackingApi.md#comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSetSharedTimeTrackingConfigurationPut) | **PUT** /rest/api/3/configuration/timetracking/options | Set time tracking settings



## comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetAvailableTimeTrackingImplementationsGet

> List&lt;TimeTrackingProvider&gt; comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetAvailableTimeTrackingImplementationsGet()

Get all time tracking providers

Returns all time tracking providers. By default, Jira only has one time tracking provider: *JIRA provided time tracking*. However, you can install other time tracking providers via apps from the Atlassian Marketplace. For more information on time tracking providers, see the documentation for the [ Time Tracking Provider](https://developer.atlassian.com/cloud/jira/platform/modules/time-tracking-provider/) module.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.TimeTrackingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeTrackingApi apiInstance = new TimeTrackingApi(defaultClient);
        try {
            List<TimeTrackingProvider> result = apiInstance.comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetAvailableTimeTrackingImplementationsGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeTrackingApi#comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetAvailableTimeTrackingImplementationsGet");
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

[**List&lt;TimeTrackingProvider&gt;**](TimeTrackingProvider.md)

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


## comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSelectedTimeTrackingImplementationGet

> TimeTrackingProvider comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSelectedTimeTrackingImplementationGet()

Get selected time tracking provider

Returns the time tracking provider that is currently selected. Note that if time tracking is disabled, then a successful but empty response is returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.TimeTrackingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeTrackingApi apiInstance = new TimeTrackingApi(defaultClient);
        try {
            TimeTrackingProvider result = apiInstance.comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSelectedTimeTrackingImplementationGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeTrackingApi#comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSelectedTimeTrackingImplementationGet");
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

[**TimeTrackingProvider**](TimeTrackingProvider.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful and time tracking is enabled. |  -  |
| **204** | Returned if the request is successful but time tracking is disabled. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSharedTimeTrackingConfigurationGet

> TimeTrackingConfiguration comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSharedTimeTrackingConfigurationGet()

Get time tracking settings

Returns the time tracking settings. This includes settings such as the time format, default time unit, and others. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.TimeTrackingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeTrackingApi apiInstance = new TimeTrackingApi(defaultClient);
        try {
            TimeTrackingConfiguration result = apiInstance.comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSharedTimeTrackingConfigurationGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeTrackingApi#comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceGetSharedTimeTrackingConfigurationGet");
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

[**TimeTrackingConfiguration**](TimeTrackingConfiguration.md)

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


## comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSelectTimeTrackingImplementationPut

> Object comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSelectTimeTrackingImplementationPut(timeTrackingProvider)

Select time tracking provider

Selects a time tracking provider.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.TimeTrackingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeTrackingApi apiInstance = new TimeTrackingApi(defaultClient);
        TimeTrackingProvider timeTrackingProvider = {"key":"Jira"}; // TimeTrackingProvider | 
        try {
            Object result = apiInstance.comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSelectTimeTrackingImplementationPut(timeTrackingProvider);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeTrackingApi#comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSelectTimeTrackingImplementationPut");
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
 **timeTrackingProvider** | [**TimeTrackingProvider**](TimeTrackingProvider.md)|  |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the request is successful. |  -  |
| **400** | Returned if the time tracking provider is not found. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |


## comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSetSharedTimeTrackingConfigurationPut

> TimeTrackingConfiguration comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSetSharedTimeTrackingConfigurationPut(timeTrackingConfiguration)

Set time tracking settings

Sets the time tracking settings.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.TimeTrackingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeTrackingApi apiInstance = new TimeTrackingApi(defaultClient);
        TimeTrackingConfiguration timeTrackingConfiguration = {"defaultUnit":"hour","workingHoursPerDay":7.6,"workingDaysPerWeek":5.5,"timeFormat":"pretty"}; // TimeTrackingConfiguration | 
        try {
            TimeTrackingConfiguration result = apiInstance.comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSetSharedTimeTrackingConfigurationPut(timeTrackingConfiguration);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeTrackingApi#comAtlassianJiraRestV2AdminTimetrackingTimeTrackingResourceSetSharedTimeTrackingConfigurationPut");
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
 **timeTrackingConfiguration** | [**TimeTrackingConfiguration**](TimeTrackingConfiguration.md)|  |

### Return type

[**TimeTrackingConfiguration**](TimeTrackingConfiguration.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request object is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |

