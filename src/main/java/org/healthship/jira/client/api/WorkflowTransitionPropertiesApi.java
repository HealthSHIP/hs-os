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
import org.healthship.jira.client.model.WorkflowTransitionProperty;
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
public class WorkflowTransitionPropertiesApi {
    private ApiClient apiClient;

    public WorkflowTransitionPropertiesApi() {
        this(new ApiClient());
    }

    @Autowired
    public WorkflowTransitionPropertiesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create workflow transition property
     * Adds a property to a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     * <p><b>200</b> - 200 response
     * <p><b>400</b> - Returned if a workflow property with the same key is present on the transition.
     * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
     * <p><b>403</b> - Returned if the user does not have the necessary permission.
     * <p><b>404</b> - Returned if the workflow transition is not found.
     * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.
     * @param key The key of the property being added, also known as the name of the property. Set this to the same value as the &#x60;key&#x60; defined in the request body.
     * @param workflowName The name of the workflow that the transition belongs to.
     * @param requestBody The requestBody parameter
     * @param workflowMode The workflow status. Set to *live* for inactive workflows or *draft* for draft workflows. Active workflows cannot be edited.
     * @return WorkflowTransitionProperty
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<WorkflowTransitionProperty> comAtlassianJiraRestV2AdminWorkflowTransitionResourceCreateWorkflowTransitionPropertyPost(Long transitionId, String key, String workflowName, Map<String, Object> requestBody, String workflowMode) throws RestClientException {
        Object postBody = requestBody;
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'transitionId' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceCreateWorkflowTransitionPropertyPost");
        }
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'key' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceCreateWorkflowTransitionPropertyPost");
        }
        // verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'workflowName' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceCreateWorkflowTransitionPropertyPost");
        }
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestBody' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceCreateWorkflowTransitionPropertyPost");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("transitionId", transitionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "key", key));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "workflowName", workflowName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "workflowMode", workflowMode));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<WorkflowTransitionProperty> localVarReturnType = new ParameterizedTypeReference<WorkflowTransitionProperty>() {};
        return apiClient.invokeAPI("/rest/api/3/workflow/transitions/{transitionId}/properties", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
    /**
     * Delete workflow transition property
     * Deletes a property from a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     * <p><b>200</b> - 200 response
     * <p><b>304</b> - Returned if no changes were made by the request. For example, trying to delete a property that cannot be found.
     * <p><b>400</b> - Returned if the request is invalid.
     * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
     * <p><b>403</b> - Returned if the user does not have the necessary permission.
     * <p><b>404</b> - Returned if the workflow transition is not found.
     * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.
     * @param key The name of the transition property to delete, also known as the name of the property.
     * @param workflowName The name of the workflow that the transition belongs to.
     * @param workflowMode The workflow status. Set to &#x60;live&#x60; for inactive workflows or &#x60;draft&#x60; for draft workflows. Active workflows cannot be edited.
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> comAtlassianJiraRestV2AdminWorkflowTransitionResourceDeleteWorkflowTransitionPropertyDelete(Long transitionId, String key, String workflowName, String workflowMode) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'transitionId' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceDeleteWorkflowTransitionPropertyDelete");
        }
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'key' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceDeleteWorkflowTransitionPropertyDelete");
        }
        // verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'workflowName' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceDeleteWorkflowTransitionPropertyDelete");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("transitionId", transitionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "key", key));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "workflowName", workflowName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "workflowMode", workflowMode));

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/rest/api/3/workflow/transitions/{transitionId}/properties", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
    /**
     * Get workflow transition properties
     * Returns the properties on a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     * <p><b>200</b> - 200 response
     * <p><b>400</b> - Returned if the request is invalid.
     * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
     * <p><b>403</b> - Returned if the user does not have admin permission
     * <p><b>404</b> - Returned if the workflow transition or property is not found.
     * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira administration console. The ID is shown next to the transition.
     * @param workflowName The name of the workflow that the transition belongs to.
     * @param includeReservedKeys Some properties with keys that have the *jira.* prefix are reserved, which means they are not editable. To include these properties in the results, set this parameter to *true*.
     * @param key The key of the property being returned, also known as the name of the property. If this parameter is not specified, all properties on the transition are returned.
     * @param workflowMode The workflow status. Set to *live* for active and inactive workflows, or *draft* for draft workflows.
     * @return WorkflowTransitionProperty
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<WorkflowTransitionProperty> comAtlassianJiraRestV2AdminWorkflowTransitionResourceGetWorkflowTransitionPropertiesGet(Long transitionId, String workflowName, Boolean includeReservedKeys, String key, String workflowMode) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'transitionId' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceGetWorkflowTransitionPropertiesGet");
        }
        // verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'workflowName' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceGetWorkflowTransitionPropertiesGet");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("transitionId", transitionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeReservedKeys", includeReservedKeys));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "key", key));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "workflowName", workflowName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "workflowMode", workflowMode));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "basicAuth" };

        ParameterizedTypeReference<WorkflowTransitionProperty> localVarReturnType = new ParameterizedTypeReference<WorkflowTransitionProperty>() {};
        return apiClient.invokeAPI("/rest/api/3/workflow/transitions/{transitionId}/properties", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
    /**
     * Update workflow transition property
     * Updates a workflow transition by changing the property value. Trying to update a property that does not exist results in a new property being added to the transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     * <p><b>200</b> - 200 response
     * <p><b>304</b> - Returned if no changes were made by the request. For example, attempting to update a property with its current value.
     * <p><b>400</b> - Returned if the request is invalid.
     * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
     * <p><b>403</b> - Returned if the user does not have the necessary permission.
     * <p><b>404</b> - Returned if the workflow transition is not found.
     * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.
     * @param key The key of the property being updated, also known as the name of the property. Set this to the same value as the &#x60;key&#x60; defined in the request body.
     * @param workflowName The name of the workflow that the transition belongs to.
     * @param requestBody The requestBody parameter
     * @param workflowMode The workflow status. Set to &#x60;live&#x60; for inactive workflows or &#x60;draft&#x60; for draft workflows. Active workflows cannot be edited.
     * @return WorkflowTransitionProperty
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<WorkflowTransitionProperty> comAtlassianJiraRestV2AdminWorkflowTransitionResourceUpdateWorkflowTransitionPropertyPut(Long transitionId, String key, String workflowName, Map<String, Object> requestBody, String workflowMode) throws RestClientException {
        Object postBody = requestBody;
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'transitionId' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceUpdateWorkflowTransitionPropertyPut");
        }
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'key' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceUpdateWorkflowTransitionPropertyPut");
        }
        // verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'workflowName' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceUpdateWorkflowTransitionPropertyPut");
        }
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestBody' when calling comAtlassianJiraRestV2AdminWorkflowTransitionResourceUpdateWorkflowTransitionPropertyPut");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("transitionId", transitionId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "key", key));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "workflowName", workflowName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "workflowMode", workflowMode));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<WorkflowTransitionProperty> localVarReturnType = new ParameterizedTypeReference<WorkflowTransitionProperty>() {};
        return apiClient.invokeAPI("/rest/api/3/workflow/transitions/{transitionId}/properties", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
