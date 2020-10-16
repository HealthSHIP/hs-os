# MyselfApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comAtlassianJiraRestV2IssueCurrentUserResourceGetCurrentUserGet**](MyselfApi.md#comAtlassianJiraRestV2IssueCurrentUserResourceGetCurrentUserGet) | **GET** /rest/api/3/myself | Get current user
[**comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceDeleteLocaleDelete**](MyselfApi.md#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceDeleteLocaleDelete) | **DELETE** /rest/api/3/mypreferences/locale | Delete locale
[**comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetLocaleGet**](MyselfApi.md#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetLocaleGet) | **GET** /rest/api/3/mypreferences/locale | Get locale
[**comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetPreferenceGet**](MyselfApi.md#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetPreferenceGet) | **GET** /rest/api/3/mypreferences | Get preference
[**comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceRemovePreferenceDelete**](MyselfApi.md#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceRemovePreferenceDelete) | **DELETE** /rest/api/3/mypreferences | Delete preference
[**comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetLocalePut**](MyselfApi.md#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetLocalePut) | **PUT** /rest/api/3/mypreferences/locale | Set locale
[**comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetPreferencePut**](MyselfApi.md#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetPreferencePut) | **PUT** /rest/api/3/mypreferences | Set preference



## comAtlassianJiraRestV2IssueCurrentUserResourceGetCurrentUserGet

> User comAtlassianJiraRestV2IssueCurrentUserResourceGetCurrentUserGet(expand)

Get current user

Returns details for the current user.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.MyselfApi;

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

        MyselfApi apiInstance = new MyselfApi(defaultClient);
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information about user in the response. This parameter accepts a comma-separated list. Expand options include:   *  `groups` Returns all groups, including nested groups, the user belongs to.  *  `applicationRoles` Returns the application roles the user is assigned to.
        try {
            User result = apiInstance.comAtlassianJiraRestV2IssueCurrentUserResourceGetCurrentUserGet(expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MyselfApi#comAtlassianJiraRestV2IssueCurrentUserResourceGetCurrentUserGet");
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
 **expand** | **String**| Use [expand](#expansion) to include additional information about user in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;groups&#x60; Returns all groups, including nested groups, the user belongs to.  *  &#x60;applicationRoles&#x60; Returns the application roles the user is assigned to. | [optional]

### Return type

[**User**](User.md)

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


## comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceDeleteLocaleDelete

> Object comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceDeleteLocaleDelete()

Delete locale

Deprecated, use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API instead.  Deletes the locale of the user, which restores the default setting.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.MyselfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        MyselfApi apiInstance = new MyselfApi(defaultClient);
        try {
            Object result = apiInstance.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceDeleteLocaleDelete();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MyselfApi#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceDeleteLocaleDelete");
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

**Object**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |


## comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetLocaleGet

> Locale comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetLocaleGet()

Get locale

Returns the locale for the user.  If the user has no language preference set (which is the default setting) or this resource is accessed anonymous, the browser locale detected by Jira is returned. Jira detects the browser locale using the *Accept-Language* header in the request. However, if this doesn&#39;t match a locale available Jira, the site default locale is returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.MyselfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        MyselfApi apiInstance = new MyselfApi(defaultClient);
        try {
            Locale result = apiInstance.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetLocaleGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MyselfApi#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetLocaleGet");
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

[**Locale**](Locale.md)

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


## comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetPreferenceGet

> String comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetPreferenceGet(key)

Get preference

Returns the value of a preference of the current user.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default this is not set and the user takes the locale of the instance.  *  *jira.user.timezone* The time zone of the user. By default this is not set and the user takes the timezone of the instance.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.MyselfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        MyselfApi apiInstance = new MyselfApi(defaultClient);
        String key = "key_example"; // String | The key of the preference.
        try {
            String result = apiInstance.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetPreferenceGet(key);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MyselfApi#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetPreferenceGet");
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
 **key** | **String**| The key of the preference. |

### Return type

**String**

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
| **404** | Returned if the key is not provided or not found. |  -  |


## comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceRemovePreferenceDelete

> comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceRemovePreferenceDelete(key)

Delete preference

Deletes a preference of the user, which restores the default value of system defined settings.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default, not set. The user takes the instance locale.  *  *jira.user.timezone* The time zone of the user. By default, not set. The user takes the instance timezone.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.MyselfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        MyselfApi apiInstance = new MyselfApi(defaultClient);
        String key = "key_example"; // String | The key of the preference.
        try {
            apiInstance.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceRemovePreferenceDelete(key);
        } catch (ApiException e) {
            System.err.println("Exception when calling MyselfApi#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceRemovePreferenceDelete");
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
 **key** | **String**| The key of the preference. |

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
| **404** | Returned if the key is not provided or not found. |  -  |


## comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetLocalePut

> Object comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetLocalePut(locale)

Set locale

Deprecated, use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API instead.  Sets the locale of the user. The locale must be one supported by the instance of Jira.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.MyselfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        MyselfApi apiInstance = new MyselfApi(defaultClient);
        Locale locale = {"locale":"en_US"}; // Locale | The locale defined in a LocaleBean.
        try {
            Object result = apiInstance.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetLocalePut(locale);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MyselfApi#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetLocalePut");
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
 **locale** | [**Locale**](Locale.md)| The locale defined in a LocaleBean. |

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
| **400** | Returned if request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |


## comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetPreferencePut

> Object comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetPreferencePut(key, body)

Set preference

Creates a preference for the user or updates a preference&#39;s value by sending a plain text string. For example, &#x60;false&#x60;. An arbitrary preference can be created with the value containing up to 255 characters. In addition, the following keys define system preferences that can be set or created:   *  *user.notifications.mimetype* The mime type used in notifications sent to the user. Defaults to &#x60;html&#x60;.  *  *user.notify.own.changes* Whether the user gets notified of their own changes. Defaults to &#x60;false&#x60;.  *  *user.default.share.private* Whether new [ filters](https://confluence.atlassian.com/x/eQiiLQ) are set to private. Defaults to &#x60;true&#x60;.  *  *user.keyboard.shortcuts.disabled* Whether keyboard shortcuts are disabled. Defaults to &#x60;false&#x60;.  *  *user.autowatch.disabled* Whether the user automatically watches issues they create or add a comment to. By default, not set: the user takes the instance autowatch setting.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default, not set. The user takes the instance locale.  *  *jira.user.timezone* The time zone of the user. By default, not set. The user takes the instance timezone.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import org.healthship.jira.ApiClient;
import org.healthship.jira.ApiException;
import org.healthship.jira.Configuration;
import org.healthship.jira.auth.*;
import org.healthship.jira.models.*;
import org.healthship.jira.client.api.MyselfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        MyselfApi apiInstance = new MyselfApi(defaultClient);
        String key = "key_example"; // String | The key of the preference. The maximum length is 255 characters.
        String body = "body_example"; // String | The value of the preference as a plain text string. The maximum length is 255 characters.
        try {
            Object result = apiInstance.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetPreferencePut(key, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MyselfApi#comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetPreferencePut");
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
 **key** | **String**| The key of the preference. The maximum length is 255 characters. |
 **body** | **String**| The value of the preference as a plain text string. The maximum length is 255 characters. |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json, text/plain
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the key or value is not provided or invalid. |  -  |

