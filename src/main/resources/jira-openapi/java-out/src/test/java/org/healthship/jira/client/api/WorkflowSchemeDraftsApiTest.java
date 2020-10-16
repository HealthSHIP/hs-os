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

import org.healthship.jira.client.model.DefaultWorkflow;
import org.healthship.jira.client.model.IssueTypeWorkflowMapping;
import org.healthship.jira.client.model.IssueTypesWorkflowMapping;
import org.healthship.jira.client.model.WorkflowScheme;
import org.junit.Ignore;
import org.junit.Test;

/**
 * API tests for WorkflowSchemeDraftsApi
 */
@Ignore
public class WorkflowSchemeDraftsApiTest {

    private final WorkflowSchemeDraftsApi api = new WorkflowSchemeDraftsApi();

    
    /**
     * Create draft workflow scheme
     *
     * Create a draft workflow scheme from an active workflow scheme, by copying the active workflow scheme. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceCreateWorkflowSchemeDraftFromParentPostTest()  {
        Long id = null;
        WorkflowScheme response = api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceCreateWorkflowSchemeDraftFromParentPost(id).block();

        // TODO: test validations
    }
    
    /**
     * Delete draft default workflow
     *
     * Resets the default workflow for a workflow scheme&#39;s draft. That is, the default workflow is set to Jira&#39;s system workflow (the *jira* workflow).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftDefaultWorkflowDeleteTest()  {
        Long id = null;
        WorkflowScheme response = api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftDefaultWorkflowDelete(id).block();

        // TODO: test validations
    }
    
    /**
     * Delete issue types for workflow in draft workflow scheme
     *
     * Deletes the workflow-issue type mapping for a workflow in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftWorkflowMappingDeleteTest()  {
        Long id = null;
        String workflowName = null;
        api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteDraftWorkflowMappingDelete(id, workflowName).block();

        // TODO: test validations
    }
    
    /**
     * Delete draft workflow scheme
     *
     * Deletes a draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftDeleteTest()  {
        Long id = null;
        api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftDelete(id).block();

        // TODO: test validations
    }
    
    /**
     * Delete workflow for issue type in draft workflow scheme
     *
     * Deletes the issue type-workflow mapping for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftIssueTypeDeleteTest()  {
        Long id = null;
        String issueType = null;
        WorkflowScheme response = api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceDeleteWorkflowSchemeDraftIssueTypeDelete(id, issueType).block();

        // TODO: test validations
    }
    
    /**
     * Get draft default workflow
     *
     * Returns the default workflow for a workflow scheme&#39;s draft. The default workflow is the workflow that is assigned any issue types that have not been mapped to any other workflow. The default workflow has *All Unassigned Issue Types* listed in its issue types for the workflow scheme in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftDefaultWorkflowGetTest()  {
        Long id = null;
        DefaultWorkflow response = api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftDefaultWorkflowGet(id).block();

        // TODO: test validations
    }
    
    /**
     * Get issue types for workflows in draft workflow scheme
     *
     * Returns the workflow-issue type mappings for a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftWorkflowGetTest()  {
        Long id = null;
        String workflowName = null;
        IssueTypesWorkflowMapping response = api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetDraftWorkflowGet(id, workflowName).block();

        // TODO: test validations
    }
    
    /**
     * Get draft workflow scheme
     *
     * Returns the draft workflow scheme for an active workflow scheme. Draft workflow schemes allow changes to be made to the active workflow schemes: When an active workflow scheme is updated, a draft copy is created. The draft is modified, then the changes in the draft are copied back to the active workflow scheme. See [Configuring workflow schemes](https://confluence.atlassian.com/x/tohKLg) for more information.   Note that:   *  Only active workflow schemes can have draft workflow schemes.  *  An active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftGetTest()  {
        Long id = null;
        WorkflowScheme response = api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftGet(id).block();

        // TODO: test validations
    }
    
    /**
     * Get workflow for issue type in draft workflow scheme
     *
     * Returns the issue type-workflow mapping for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftIssueTypeGetTest()  {
        Long id = null;
        String issueType = null;
        IssueTypeWorkflowMapping response = api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceGetWorkflowSchemeDraftIssueTypeGet(id, issueType).block();

        // TODO: test validations
    }
    
    /**
     * Set workflow for issue type in draft workflow scheme
     *
     * Sets the workflow for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceSetWorkflowSchemeDraftIssueTypePutTest()  {
        Long id = null;
        String issueType = null;
        IssueTypeWorkflowMapping issueTypeWorkflowMapping = null;
        WorkflowScheme response = api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceSetWorkflowSchemeDraftIssueTypePut(id, issueType, issueTypeWorkflowMapping).block();

        // TODO: test validations
    }
    
    /**
     * Update draft default workflow
     *
     * Sets the default workflow for a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftDefaultWorkflowPutTest()  {
        Long id = null;
        DefaultWorkflow defaultWorkflow = null;
        WorkflowScheme response = api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftDefaultWorkflowPut(id, defaultWorkflow).block();

        // TODO: test validations
    }
    
    /**
     * Set issue types for workflow in workflow scheme
     *
     * Sets the issue types for a workflow in a workflow scheme&#39;s draft. The workflow can also be set as the default workflow for the draft workflow scheme. Unmapped issues types are mapped to the default workflow.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftWorkflowMappingPutTest()  {
        Long id = null;
        String workflowName = null;
        IssueTypesWorkflowMapping issueTypesWorkflowMapping = null;
        WorkflowScheme response = api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateDraftWorkflowMappingPut(id, workflowName, issueTypesWorkflowMapping).block();

        // TODO: test validations
    }
    
    /**
     * Update draft workflow scheme
     *
     * Updates a draft workflow scheme. If a draft workflow scheme does not exist for the active workflow scheme, then a draft is created. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateWorkflowSchemeDraftPutTest()  {
        Long id = null;
        WorkflowScheme workflowScheme = null;
        WorkflowScheme response = api.comAtlassianJiraRestV2AdminWorkflowschemeWorkflowSchemeResourceUpdateWorkflowSchemeDraftPut(id, workflowScheme).block();

        // TODO: test validations
    }
    
}
