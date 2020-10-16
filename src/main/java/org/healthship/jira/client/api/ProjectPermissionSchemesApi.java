/*
 * Copyright (c) 2020 Ronald MacDonald <ronald@rmacd.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.healthship.jira.client.api;

import org.healthship.jira.ApiClient;
import org.healthship.jira.client.model.IdBean;
import org.healthship.jira.client.model.PermissionScheme;
import org.healthship.jira.client.model.ProjectIssueSecurityLevels;
import org.healthship.jira.client.model.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class ProjectPermissionSchemesApi {
    private ApiClient apiClient;

    public ProjectPermissionSchemesApi() {
        this(new ApiClient());
    }

    @Autowired
    public ProjectPermissionSchemesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get project issue security scheme
     * Returns the [issue security scheme](https://confluence.atlassian.com/x/J4lKLg) associated with the project.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or the *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
     * <p><b>200</b> - Returned if the request is successful.
     * <p><b>400</b> - Returned if the request is invalid.
     * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
     * <p><b>403</b> - Returned if the project is visible to the user but the user doesn&#39;t have administrative permissions.
     * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
     * @param projectKeyOrId The project ID or project key (case sensitive).
     * @return SecurityScheme
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<SecurityScheme> comAtlassianJiraRestV2IssueProjectIssueSecurityLevelSchemeResourceGetIssueSecuritySchemeGet(String projectKeyOrId) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectKeyOrId' when calling comAtlassianJiraRestV2IssueProjectIssueSecurityLevelSchemeResourceGetIssueSecuritySchemeGet");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("projectKeyOrId", projectKeyOrId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "basicAuth" };

        ParameterizedTypeReference<SecurityScheme> localVarReturnType = new ParameterizedTypeReference<SecurityScheme>() {};
        return apiClient.invokeAPI("/rest/api/3/project/{projectKeyOrId}/issuesecuritylevelscheme", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
    /**
     * Assign permission scheme
     * Assigns a permission scheme with a project. See [Managing project permissions](https://confluence.atlassian.com/x/yodKLg) for more information about permission schemes.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg)
     * <p><b>200</b> - Returned if the request is successful.
     * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
     * <p><b>403</b> - Returned if:   *  the user does not have the necessary permission to edit the project&#39;s configuration.  *  the Jira instance is Jira Core Free or Jira Software Free. Permission schemes cannot be assigned to projects on free plans.
     * <p><b>404</b> - Returned if the project or permission scheme is not found.
     * @param projectKeyOrId The project ID or project key (case sensitive).
     * @param idBean The idBean parameter
     * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.
     * @return PermissionScheme
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<PermissionScheme> comAtlassianJiraRestV2PermissionProjectPermissionSchemeResourceAssignPermissionSchemePut(String projectKeyOrId, IdBean idBean, String expand) throws RestClientException {
        Object postBody = idBean;
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectKeyOrId' when calling comAtlassianJiraRestV2PermissionProjectPermissionSchemeResourceAssignPermissionSchemePut");
        }
        // verify the required parameter 'idBean' is set
        if (idBean == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idBean' when calling comAtlassianJiraRestV2PermissionProjectPermissionSchemeResourceAssignPermissionSchemePut");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("projectKeyOrId", projectKeyOrId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "expand", expand));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "basicAuth" };

        ParameterizedTypeReference<PermissionScheme> localVarReturnType = new ParameterizedTypeReference<PermissionScheme>() {};
        return apiClient.invokeAPI("/rest/api/3/project/{projectKeyOrId}/permissionscheme", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
    /**
     * Get assigned permission scheme
     * Gets the [permission scheme](https://confluence.atlassian.com/x/yodKLg) associated with the project.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
     * <p><b>200</b> - Returned if the request is successful.
     * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
     * <p><b>403</b> - Returned if the user does not have permission to view the project&#39;s configuration.
     * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view the project.
     * @param projectKeyOrId The project ID or project key (case sensitive).
     * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.
     * @return PermissionScheme
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<PermissionScheme> comAtlassianJiraRestV2PermissionProjectPermissionSchemeResourceGetAssignedPermissionSchemeGet(String projectKeyOrId, String expand) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectKeyOrId' when calling comAtlassianJiraRestV2PermissionProjectPermissionSchemeResourceGetAssignedPermissionSchemeGet");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("projectKeyOrId", projectKeyOrId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "expand", expand));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "basicAuth" };

        ParameterizedTypeReference<PermissionScheme> localVarReturnType = new ParameterizedTypeReference<PermissionScheme>() {};
        return apiClient.invokeAPI("/rest/api/3/project/{projectKeyOrId}/permissionscheme", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
    /**
     * Get project issue security levels
     * Returns all [issue security](https://confluence.atlassian.com/x/J4lKLg) levels for the project that the user has access to.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [global permission](https://confluence.atlassian.com/x/x4dKLg) for the project, however, issue security levels are only returned for authenticated user with *Set Issue Security* [global permission](https://confluence.atlassian.com/x/x4dKLg) for the project.
     * <p><b>200</b> - Returned if the request is successful.
     * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
     * @param projectKeyOrId The project ID or project key (case sensitive).
     * @return ProjectIssueSecurityLevels
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<ProjectIssueSecurityLevels> comAtlassianJiraRestV2SecuritylevelProjectSecurityLevelResourceGetSecurityLevelsForProjectGet(String projectKeyOrId) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectKeyOrId' when calling comAtlassianJiraRestV2SecuritylevelProjectSecurityLevelResourceGetSecurityLevelsForProjectGet");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("projectKeyOrId", projectKeyOrId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "basicAuth" };

        ParameterizedTypeReference<ProjectIssueSecurityLevels> localVarReturnType = new ParameterizedTypeReference<ProjectIssueSecurityLevels>() {};
        return apiClient.invokeAPI("/rest/api/3/project/{projectKeyOrId}/securitylevel", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
