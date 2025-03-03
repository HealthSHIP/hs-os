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
 * API tests for PermissionsApi
 */
@Ignore
public class PermissionsApiTest {

    private final PermissionsApi api = new PermissionsApi();

    
    /**
     * Get all permissions
     *
     * Returns all permissions, including:   *  global permissions.  *  project permissions.  *  global permissions added by plugins.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2PermissionPermissionsResourceGetAllPermissionsGetTest()  {
        Permissions response = api.comAtlassianJiraRestV2PermissionPermissionsResourceGetAllPermissionsGet().block();

        // TODO: test validations
    }
    
    /**
     * Get bulk permissions
     *
     * Returns:   *  for a list of global permissions, the global permissions granted to the user.  *  for a list of project permissions and lists of projects and issues, for each project permission a list of the projects and issues the user can access or manipulate.  Note that:   *  Invalid project and issue IDs are ignored.  *  A maximum of 1000 projects and 1000 issues can be checked.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     */
    @Test
    public void comAtlassianJiraRestV2PermissionPermissionsResourceGetBulkPermissionsPostTest()  {
        BulkPermissionsRequestBean bulkPermissionsRequestBean = null;
        BulkPermissionGrants response = api.comAtlassianJiraRestV2PermissionPermissionsResourceGetBulkPermissionsPost(bulkPermissionsRequestBean).block();

        // TODO: test validations
    }
    
    /**
     * Get my permissions
     *
     * Returns a list of permissions indicating which permissions the user has. Details of the user&#39;s permissions can be obtained in a global, project, or issue context.  The user is reported as having a project permission:   *  in the global context, if the user has the project permission in any project.  *  for a project, where the project permission is determined using issue data, if the user meets the permission&#39;s criteria for any issue in the project. Otherwise, if the user has the project permission in the project.  *  for an issue, where a project permission is determined using issue data, if the user has the permission in the issue. Otherwise, if the user has the project permission in the project containing the issue.  This means that users may be shown as having an issue permission (such as EDIT\\_ISSUE) in the global context or a project context but may not have the permission for any or all issues. For example, if Reporters have the EDIT\\_ISSUE permission a user would be shown as having this permission in the global context or the context of a project, because any user can be a reporter. However, if they are not the user who reported the issue queried they would not have EDIT\\_ISSUE permission for that issue.  Global permissions are unaffected by context.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     */
    @Test
    public void comAtlassianJiraRestV2PermissionPermissionsResourceGetMyPermissionsGetTest()  {
        String projectKey = null;
        String projectId = null;
        String issueKey = null;
        String issueId = null;
        String permissions = null;
        String projectUuid = null;
        String projectConfigurationUuid = null;
        Permissions response = api.comAtlassianJiraRestV2PermissionPermissionsResourceGetMyPermissionsGet(projectKey, projectId, issueKey, issueId, permissions, projectUuid, projectConfigurationUuid).block();

        // TODO: test validations
    }
    
    /**
     * Get permitted projects
     *
     * Returns all the projects where the user is granted a list of project permissions.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     */
    @Test
    public void comAtlassianJiraRestV2PermissionPermissionsResourceGetPermittedProjectsPostTest()  {
        PermissionsKeysBean permissionsKeysBean = null;
        PermittedProjects response = api.comAtlassianJiraRestV2PermissionPermissionsResourceGetPermittedProjectsPost(permissionsKeysBean).block();

        // TODO: test validations
    }
    
}
