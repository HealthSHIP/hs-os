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

import org.healthship.jira.client.model.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 * API tests for JqlApi
 */
@Ignore
public class JqlApiTest {

    private final JqlApi api = new JqlApi();

    
    /**
     * Parse JQL query
     *
     * Parses and validates JQL queries.  Validation is performed in context of the current user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     */
    @Test
    public void comAtlassianJiraRestV2JqlJqlParserResourceParseJqlQueriesPostTest()  {
        JqlQueriesToParse jqlQueriesToParse = null;
        ParsedJqlQueries response = api.comAtlassianJiraRestV2JqlJqlParserResourceParseJqlQueriesPost(jqlQueriesToParse).block();

        // TODO: test validations
    }
    
    /**
     * Convert user identifiers to account IDs in JQL queries
     *
     * Converts one or more JQL queries with user identifiers (username or user key) to equivalent JQL queries with account IDs.  You may wish to use this operation if your system stores JQL queries and you want to make them GDPR-compliant. For more information about GDPR-related changes, see the [migration guide](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/).  **[Permissions](#permissions) required:** Permission to access Jira.
     */
    @Test
    public void comAtlassianJiraRestV2SearchJQLPersonalDataMigrationResourceMigrateQueriesPostTest()  {
        JQLPersonalDataMigrationRequest jqLPersonalDataMigrationRequest = null;
        ConvertedJQLQueries response = api.comAtlassianJiraRestV2SearchJQLPersonalDataMigrationResourceMigrateQueriesPost(jqLPersonalDataMigrationRequest).block();

        // TODO: test validations
    }
    
    /**
     * Get field reference data
     *
     * Returns reference data for JQL searches. This is a downloadable version of the documentation provided in [Advanced searching - fields reference](https://confluence.atlassian.com/x/gwORLQ) and [Advanced searching - functions reference](https://confluence.atlassian.com/x/hgORLQ), along with a list of JQL-reserved words. Use this information to assist with the programmatic creation of JQL queries or the validation of queries built in a custom query builder.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     */
    @Test
    public void comAtlassianJiraRestV2SearchSearchAutoCompleteResourceGetAutoCompleteGetTest()  {
        JQLReferenceData response = api.comAtlassianJiraRestV2SearchSearchAutoCompleteResourceGetAutoCompleteGet().block();

        // TODO: test validations
    }
    
    /**
     * Get field auto complete suggestions
     *
     * Returns the JQL search auto complete suggestions for a field.  Suggestions can be obtained by providing:   *  &#x60;fieldName&#x60; to get a list of all values for the field.  *  &#x60;fieldName&#x60; and &#x60;fieldValue&#x60; to get a list of values containing the text in &#x60;fieldValue&#x60;.  *  &#x60;fieldName&#x60; and &#x60;predicateName&#x60; to get a list of all predicate values for the field.  *  &#x60;fieldName&#x60;, &#x60;predicateName&#x60;, and &#x60;predicateValue&#x60; to get a list of predicate values containing the text in &#x60;predicateValue&#x60;.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     */
    @Test
    public void comAtlassianJiraRestV2SearchSearchAutoCompleteResourceGetFieldAutoCompleteForQueryStringGetTest()  {
        String fieldName = null;
        String fieldValue = null;
        String predicateName = null;
        String predicateValue = null;
        AutoCompleteSuggestions response = api.comAtlassianJiraRestV2SearchSearchAutoCompleteResourceGetFieldAutoCompleteForQueryStringGet(fieldName, fieldValue, predicateName, predicateValue).block();

        // TODO: test validations
    }
    
}
