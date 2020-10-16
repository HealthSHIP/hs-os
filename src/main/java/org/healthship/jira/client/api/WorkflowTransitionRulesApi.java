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
import org.healthship.jira.client.model.PageBeanWorkflowTransitionRules;
import org.healthship.jira.client.model.WorkflowTransitionRulesUpdate;
import org.healthship.jira.client.model.WorkflowTransitionRulesUpdateErrors;
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
import java.util.Locale;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-29T15:40:13.931673+01:00[Europe/London]")
public class WorkflowTransitionRulesApi {
    private ApiClient apiClient;

    public WorkflowTransitionRulesApi() {
        this(new ApiClient());
    }

    @Autowired
    public WorkflowTransitionRulesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get workflow transition rule configurations
     * Returns a paginated list of workflows with transition rules. The workflows can be filtered to return only those containing workflow transition rules:   *  of one or more transition rule types, such as [workflow post functions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-post-function/).  *  matching one or more transition rule keys.  Only workflows containing transition rules created by the calling Connect app are returned. However, if a workflow is returned all transition rules that match the filters are returned for that workflow.  Due to server-side optimizations, workflows with an empty list of rules may be returned; these workflows can be ignored.  **[Permissions](#permissions) required:** Only Connect apps can use this operation.
     * <p><b>200</b> - Returned if the request is successful.
     * <p><b>400</b> - Returned if the request is invalid.
     * <p><b>403</b> - Returned if the caller is not a Connect app.
     * <p><b>404</b> - Returned if the any transition rule type is not supported.
     * @param types The types of the transition rules to return.
     * @param startAt The index of the first item to return in a page of results (page offset).
     * @param maxResults The maximum number of items to return per page.
     * @param keys The transition rule class keys, as defined in the Connect app descriptor, of the transition rules to return.
     * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts &#x60;transition&#x60;, which, for each rule, returns information about the transition the rule is assigned to.
     * @return PageBeanWorkflowTransitionRules
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<PageBeanWorkflowTransitionRules> comAtlassianJiraRestV2AdminWorkflowWorkflowRuleConfigResourceGetWorkflowTransitionRuleConfigurationsGet(List<String> types, Long startAt, Integer maxResults, List<String> keys, String expand) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'types' is set
        if (types == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'types' when calling comAtlassianJiraRestV2AdminWorkflowWorkflowRuleConfigResourceGetWorkflowTransitionRuleConfigurationsGet");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "startAt", startAt));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "maxResults", maxResults));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "types", types));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "keys", keys));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "expand", expand));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<PageBeanWorkflowTransitionRules> localVarReturnType = new ParameterizedTypeReference<PageBeanWorkflowTransitionRules>() {};
        return apiClient.invokeAPI("/rest/api/3/workflow/rule/config", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
    /**
     * Update workflow transition rule configurations
     * Updates configuration of workflow transition rules. The following rule types are supported:   *  [post functions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-post-function/)  *  [conditions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-condition/)  *  [validators](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-validator/)  Only rules created by the calling Connect app can be updated.  **[Permissions](#permissions) required:** Only Connect apps can use this operation.
     * <p><b>200</b> - Returned if the request is successful.
     * <p><b>400</b> - Returned if the request is invalid.
     * <p><b>403</b> - Returned if the caller is not a Connect app.
     * @param workflowTransitionRulesUpdate The workflowTransitionRulesUpdate parameter
     * @return WorkflowTransitionRulesUpdateErrors
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Mono<WorkflowTransitionRulesUpdateErrors> comAtlassianJiraRestV2AdminWorkflowWorkflowRuleConfigResourceUpdateWorkflowTransitionRuleConfigurationsPut(WorkflowTransitionRulesUpdate workflowTransitionRulesUpdate) throws RestClientException {
        Object postBody = workflowTransitionRulesUpdate;
        // verify the required parameter 'workflowTransitionRulesUpdate' is set
        if (workflowTransitionRulesUpdate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'workflowTransitionRulesUpdate' when calling comAtlassianJiraRestV2AdminWorkflowWorkflowRuleConfigResourceUpdateWorkflowTransitionRuleConfigurationsPut");
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<WorkflowTransitionRulesUpdateErrors> localVarReturnType = new ParameterizedTypeReference<WorkflowTransitionRulesUpdateErrors>() {};
        return apiClient.invokeAPI("/rest/api/3/workflow/rule/config", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
