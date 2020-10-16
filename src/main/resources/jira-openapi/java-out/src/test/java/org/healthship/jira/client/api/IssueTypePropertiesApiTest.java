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

import org.healthship.jira.client.model.EntityProperty;
import org.healthship.jira.client.model.PropertyKeys;
import org.junit.Ignore;
import org.junit.Test;

/**
 * API tests for IssueTypePropertiesApi
 */
@Ignore
public class IssueTypePropertiesApiTest {

    private final IssueTypePropertiesApi api = new IssueTypePropertiesApi();

    
    /**
     * Delete issue type property
     *
     * Deletes the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2IssueIssueTypePropertyResourceDeleteIssueTypePropertyDeleteTest()  {
        String issueTypeId = null;
        String propertyKey = null;
        api.comAtlassianJiraRestV2IssueIssueTypePropertyResourceDeleteIssueTypePropertyDelete(issueTypeId, propertyKey).block();

        // TODO: test validations
    }
    
    /**
     * Get issue type property
     *
     * Returns the key and value of the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to get the details of any issue type.  *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) to get the details of any issue types associated with the projects the user has permission to browse.
     */
    @Test
    public void comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyGetTest()  {
        String issueTypeId = null;
        String propertyKey = null;
        EntityProperty response = api.comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyGet(issueTypeId, propertyKey).block();

        // TODO: test validations
    }
    
    /**
     * Get issue type property keys
     *
     * Returns all the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties) keys of the issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to get the property keys of any issue type.  *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) to get the property keys of any issue types associated with the projects the user has permission to browse.
     */
    @Test
    public void comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyKeysGetTest()  {
        String issueTypeId = null;
        PropertyKeys response = api.comAtlassianJiraRestV2IssueIssueTypePropertyResourceGetIssueTypePropertyKeysGet(issueTypeId).block();

        // TODO: test validations
    }
    
    /**
     * Set issue type property
     *
     * Creates or updates the value of the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties). Use this resource to store and update data against an issue type.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2IssueIssueTypePropertyResourceSetIssueTypePropertyPutTest()  {
        String issueTypeId = null;
        String propertyKey = null;
        Object body = null;
        Object response = api.comAtlassianJiraRestV2IssueIssueTypePropertyResourceSetIssueTypePropertyPut(issueTypeId, propertyKey, body).block();

        // TODO: test validations
    }
    
}
