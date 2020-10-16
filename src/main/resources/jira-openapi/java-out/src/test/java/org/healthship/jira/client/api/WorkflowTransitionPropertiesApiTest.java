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

import org.healthship.jira.client.model.WorkflowTransitionProperty;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

/**
 * API tests for WorkflowTransitionPropertiesApi
 */
@Ignore
public class WorkflowTransitionPropertiesApiTest {

    private final WorkflowTransitionPropertiesApi api = new WorkflowTransitionPropertiesApi();

    
    /**
     * Create workflow transition property
     *
     * Adds a property to a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowTransitionResourceCreateWorkflowTransitionPropertyPostTest()  {
        Long transitionId = null;
        String key = null;
        String workflowName = null;
        Map<String, Object> requestBody = null;
        String workflowMode = null;
        WorkflowTransitionProperty response = api.comAtlassianJiraRestV2AdminWorkflowTransitionResourceCreateWorkflowTransitionPropertyPost(transitionId, key, workflowName, requestBody, workflowMode).block();

        // TODO: test validations
    }
    
    /**
     * Delete workflow transition property
     *
     * Deletes a property from a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowTransitionResourceDeleteWorkflowTransitionPropertyDeleteTest()  {
        Long transitionId = null;
        String key = null;
        String workflowName = null;
        String workflowMode = null;
        api.comAtlassianJiraRestV2AdminWorkflowTransitionResourceDeleteWorkflowTransitionPropertyDelete(transitionId, key, workflowName, workflowMode).block();

        // TODO: test validations
    }
    
    /**
     * Get workflow transition properties
     *
     * Returns the properties on a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowTransitionResourceGetWorkflowTransitionPropertiesGetTest()  {
        Long transitionId = null;
        String workflowName = null;
        Boolean includeReservedKeys = null;
        String key = null;
        String workflowMode = null;
        WorkflowTransitionProperty response = api.comAtlassianJiraRestV2AdminWorkflowTransitionResourceGetWorkflowTransitionPropertiesGet(transitionId, workflowName, includeReservedKeys, key, workflowMode).block();

        // TODO: test validations
    }
    
    /**
     * Update workflow transition property
     *
     * Updates a workflow transition by changing the property value. Trying to update a property that does not exist results in a new property being added to the transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowTransitionResourceUpdateWorkflowTransitionPropertyPutTest()  {
        Long transitionId = null;
        String key = null;
        String workflowName = null;
        Map<String, Object> requestBody = null;
        String workflowMode = null;
        WorkflowTransitionProperty response = api.comAtlassianJiraRestV2AdminWorkflowTransitionResourceUpdateWorkflowTransitionPropertyPut(transitionId, key, workflowName, requestBody, workflowMode).block();

        // TODO: test validations
    }
    
}
