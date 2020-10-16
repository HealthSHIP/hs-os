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

import org.healthship.jira.client.model.BulkCreateCustomFieldOptionRequest;
import org.healthship.jira.client.model.CustomFieldOption;
import org.healthship.jira.client.model.PageBeanCustomFieldOptionDetails;
import org.healthship.jira.client.model.UpdateCustomFieldOption;
import org.junit.Ignore;
import org.junit.Test;

/**
 * API tests for IssueCustomFieldOptionsApi
 */
@Ignore
public class IssueCustomFieldOptionsApiTest {

    private final IssueCustomFieldOptionsApi api = new IssueCustomFieldOptionsApi();

    
    /**
     * Create custom field options
     *
     * Creates options and, where the custom select field is of the type *Select List (cascading)*, cascading options for a custom select field. The options are added to the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceCreateCustomFieldOptionsPostTest()  {
        Long fieldId = null;
        BulkCreateCustomFieldOptionRequest bulkCreateCustomFieldOptionRequest = null;
        Object response = api.comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceCreateCustomFieldOptionsPost(fieldId, bulkCreateCustomFieldOptionRequest).block();

        // TODO: test validations
    }
    
    /**
     * Get options for field
     *
     * Returns the options and, where the custom select field is of the type *Select List (cascading)*, cascading options for custom select fields. Cascading options are included in the item count when determining pagination. Only options from the global context are returned.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceGetOptionsForFieldGetTest()  {
        Long fieldId = null;
        Long startAt = null;
        Integer maxResults = null;
        PageBeanCustomFieldOptionDetails response = api.comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceGetOptionsForFieldGet(fieldId, startAt, maxResults).block();

        // TODO: test validations
    }
    
    /**
     * Update custom field options
     *
     * Updates the options on a custom select field. Where an updated option is in use on an issue, the value on the issue is also updated. Options that are not found are ignored. A maximum of 1000 options, including sub-options of *Select List (cascading)* fields, can be updated per request. The options are updated on the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceUpdateCustomFieldOptionsPutTest()  {
        Long fieldId = null;
        UpdateCustomFieldOption updateCustomFieldOption = null;
        Object response = api.comAtlassianJiraRestV2IssueBulkCustomFieldOptionResourceUpdateCustomFieldOptionsPut(fieldId, updateCustomFieldOption).block();

        // TODO: test validations
    }
    
    /**
     * Get custom field option
     *
     * Returns a custom field option. For example, an option in a select list.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     */
    @Test
    public void comAtlassianJiraRestV2IssueCustomfieldCustomFieldOptionResourceGetCustomFieldOptionGetTest()  {
        String id = null;
        CustomFieldOption response = api.comAtlassianJiraRestV2IssueCustomfieldCustomFieldOptionResourceGetCustomFieldOptionGet(id).block();

        // TODO: test validations
    }
    
}
