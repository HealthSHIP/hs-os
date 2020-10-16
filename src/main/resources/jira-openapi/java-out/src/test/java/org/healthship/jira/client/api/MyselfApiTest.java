/*
 * The Jira Cloud platform REST API
 * Jira Cloud platform REST API documentation
 *
 * The version of the OpenAPI document: 1001.0.0-SNAPSHOT
 * Contact: ecosystem@atlassian.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.healthship.jira.client.api;

import org.healthship.jira.client.model.Locale;
import org.healthship.jira.client.model.User;
import org.junit.Ignore;
import org.junit.Test;

/**
 * API tests for MyselfApi
 */
@Ignore
public class MyselfApiTest {

    private final MyselfApi api = new MyselfApi();

    
    /**
     * Get current user
     *
     * Returns details for the current user.  **[Permissions](#permissions) required:** Permission to access Jira.
     */
    @Test
    public void comAtlassianJiraRestV2IssueCurrentUserResourceGetCurrentUserGetTest()  {
        String expand = null;
        User response = api.comAtlassianJiraRestV2IssueCurrentUserResourceGetCurrentUserGet(expand).block();

        // TODO: test validations
    }
    
    /**
     * Delete locale
     *
     * Deprecated, use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API instead.  Deletes the locale of the user, which restores the default setting.  **[Permissions](#permissions) required:** Permission to access Jira.
     */
    @Test
    public void comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceDeleteLocaleDeleteTest()  {
        Object response = api.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceDeleteLocaleDelete().block();

        // TODO: test validations
    }
    
    /**
     * Get locale
     *
     * Returns the locale for the user.  If the user has no language preference set (which is the default setting) or this resource is accessed anonymous, the browser locale detected by Jira is returned. Jira detects the browser locale using the *Accept-Language* header in the request. However, if this doesn&#39;t match a locale available Jira, the site default locale is returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     */
    @Test
    public void comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetLocaleGetTest()  {
        Locale response = api.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetLocaleGet().block();

        // TODO: test validations
    }
    
    /**
     * Get preference
     *
     * Returns the value of a preference of the current user.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default this is not set and the user takes the locale of the instance.  *  *jira.user.timezone* The time zone of the user. By default this is not set and the user takes the timezone of the instance.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.
     */
    @Test
    public void comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetPreferenceGetTest()  {
        String key = null;
        String response = api.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceGetPreferenceGet(key).block();

        // TODO: test validations
    }
    
    /**
     * Delete preference
     *
     * Deletes a preference of the user, which restores the default value of system defined settings.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default, not set. The user takes the instance locale.  *  *jira.user.timezone* The time zone of the user. By default, not set. The user takes the instance timezone.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.
     */
    @Test
    public void comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceRemovePreferenceDeleteTest()  {
        String key = null;
        api.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceRemovePreferenceDelete(key).block();

        // TODO: test validations
    }
    
    /**
     * Set locale
     *
     * Deprecated, use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API instead.  Sets the locale of the user. The locale must be one supported by the instance of Jira.  **[Permissions](#permissions) required:** Permission to access Jira.
     */
    @Test
    public void comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetLocalePutTest()  {
        Locale locale = null;
        Object response = api.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetLocalePut(locale).block();

        // TODO: test validations
    }
    
    /**
     * Set preference
     *
     * Creates a preference for the user or updates a preference&#39;s value by sending a plain text string. For example, &#x60;false&#x60;. An arbitrary preference can be created with the value containing up to 255 characters. In addition, the following keys define system preferences that can be set or created:   *  *user.notifications.mimetype* The mime type used in notifications sent to the user. Defaults to &#x60;html&#x60;.  *  *user.notify.own.changes* Whether the user gets notified of their own changes. Defaults to &#x60;false&#x60;.  *  *user.default.share.private* Whether new [ filters](https://confluence.atlassian.com/x/eQiiLQ) are set to private. Defaults to &#x60;true&#x60;.  *  *user.keyboard.shortcuts.disabled* Whether keyboard shortcuts are disabled. Defaults to &#x60;false&#x60;.  *  *user.autowatch.disabled* Whether the user automatically watches issues they create or add a comment to. By default, not set: the user takes the instance autowatch setting.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default, not set. The user takes the instance locale.  *  *jira.user.timezone* The time zone of the user. By default, not set. The user takes the instance timezone.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.
     */
    @Test
    public void comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetPreferencePutTest()  {
        String key = null;
        String body = null;
        Object response = api.comAtlassianJiraRestV2PreferenceCurrentUserPreferencesResourceSetPreferencePut(key, body).block();

        // TODO: test validations
    }
    
}
