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

import org.healthship.jira.client.model.Priority;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * API tests for IssuePrioritiesApi
 */
@Ignore
public class IssuePrioritiesApiTest {

    private final IssuePrioritiesApi api = new IssuePrioritiesApi();

    
    /**
     * Get priorities
     *
     * Returns the list of all issue priorities.  **[Permissions](#permissions) required:** Permission to access Jira.
     */
    @Test
    public void comAtlassianJiraRestV2IssuePriorityResourceGetPrioritiesGetTest()  {
        List<Priority> response = api.comAtlassianJiraRestV2IssuePriorityResourceGetPrioritiesGet().collectList().block();

        // TODO: test validations
    }
    
    /**
     * Get priority
     *
     * Returns an issue priority.  **[Permissions](#permissions) required:** Permission to access Jira.
     */
    @Test
    public void comAtlassianJiraRestV2IssuePriorityResourceGetPriorityGetTest()  {
        String id = null;
        Priority response = api.comAtlassianJiraRestV2IssuePriorityResourceGetPriorityGet(id).block();

        // TODO: test validations
    }
    
}
