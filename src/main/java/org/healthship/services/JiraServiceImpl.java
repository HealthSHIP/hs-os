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

package org.healthship.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.healthship.exceptions.ApplicationException;
import org.healthship.jira.ApiClient;
import org.healthship.jira.client.api.IssuesApi;
import org.healthship.jira.client.api.MyselfApi;
import org.healthship.jira.client.api.ProjectsApi;
import org.healthship.jira.client.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class JiraServiceImpl implements JiraService {

    // documentation: https://community.atlassian.com/t5/Jira-articles/Generating-a-REST-client-for-Jira-Cloud/ba-p/1307133
    // more documentation: https://developer.atlassian.com/cloud/jira/platform/rest/v3/#api-rest-api-3-issue-post

    ApiClient jiraAPIClient;

    @Value("${jira-api-key}")
    String apiKey;

    @PostConstruct
    public void setup() {
        ObjectMapper om = new ObjectMapper();
        jiraAPIClient = new ApiClient(WebClient.create("https://healthship.atlassian.net"), om, DateFormat.getDateInstance());
        jiraAPIClient.setUsername("ronald@rmacd.com");
        jiraAPIClient.setPassword(apiKey);
        jiraAPIClient.setBasePath("https://healthship.atlassian.net");
    }

    @Override
    public void createBugReport(String reportedByEmail, String summary, String description) throws ApplicationException {
        User user = getUser();
        Project project = getProject("HealthSHIP");
        String issueTypeID = getIssueType("bug", project);

        // Now create an issue
        IssuesApi issuesApi = new IssuesApi(jiraAPIClient);
        Map<String, Object> issueCreateParams = new HashMap<>();

        Map<String, Object> fields = new HashMap<>();
        fields.put("summary", summary);

        // needs to be document type (see REST documentation)
        Map<String, Object> descriptionObject = new HashMap<>();
        descriptionObject.put("type", "doc");
        descriptionObject.put("version", 1);

        Map<String, Object> docContent = new HashMap<>();
        docContent.put("type", "paragraph");

        ArrayList<Map<String, Object>> docParagraphArray = new ArrayList<>();
        docParagraphArray.add(textParagraph(String.format("reported by: %s ", reportedByEmail)));
        docParagraphArray.add(textParagraph(description));
        docContent.put("content", docParagraphArray);

        ArrayList<Map<String, Object>> docContentArray = new ArrayList<>();
        docContentArray.add(docContent);
        descriptionObject.put("content", docContentArray);

        fields.put("description", descriptionObject);
        Map<String, Object> issueTypeField = new HashMap<>();
        issueTypeField.put("id", issueTypeID);

        fields.put("issuetype", issueTypeField);
        Map<String, Object> projectField = new HashMap<>();
        projectField.put("id", project.getId());
        fields.put("project", projectField);

        // Assign bugs to Ron
        Map<String, Object> assigneeField = new HashMap<>();
        assigneeField.put("accountId", user.getAccountId());
        fields.put("assignee", assigneeField);

        issueCreateParams.put("fields", fields);

        CreatedIssue createdIssue = issuesApi.comAtlassianJiraRestV2IssueIssueResourceCreateIssuePost(issueCreateParams, true).block();
    }

    @Override
    public void createAccountManagementTask(String reportedByEmail, String summary, String description) throws ApplicationException {
        User user = getUser();
        Project project = getProject("TASK");
        String issueTypeID = getIssueType("task", project);

        // Now create an issue
        IssuesApi issuesApi = new IssuesApi(jiraAPIClient);
        Map<String, Object> issueCreateParams = new HashMap<>();

        Map<String, Object> fields = new HashMap<>();
        fields.put("summary", summary);

        // needs to be document type (see REST documentation)
        Map<String, Object> descriptionObject = new HashMap<>();
        descriptionObject.put("type", "doc");
        descriptionObject.put("version", 1);

        Map<String, Object> docContent = new HashMap<>();
        docContent.put("type", "paragraph");

        ArrayList<Map<String, Object>> docParagraphArray = new ArrayList<>();
        docParagraphArray.add(textParagraph(String.format("reported by: %s ", reportedByEmail)));
        docParagraphArray.add(textParagraph(description));
        docContent.put("content", docParagraphArray);

        ArrayList<Map<String, Object>> docContentArray = new ArrayList<>();
        docContentArray.add(docContent);
        descriptionObject.put("content", docContentArray);

        fields.put("description", descriptionObject);
        Map<String, Object> issueTypeField = new HashMap<>();
        issueTypeField.put("id", issueTypeID);

        fields.put("issuetype", issueTypeField);
        Map<String, Object> projectField = new HashMap<>();
        projectField.put("id", project.getId());
        fields.put("project", projectField);

        issueCreateParams.put("fields", fields);

        CreatedIssue createdIssue = issuesApi.comAtlassianJiraRestV2IssueIssueResourceCreateIssuePost(issueCreateParams, true).block();
    }

    @Override
    public void createFeedback(String reportedByEmail, String summary, String description) throws ApplicationException {
        User user = getUser();
        Project project = getProject("HealthSHIP");
        String issueTypeID = getIssueType("feedback", project);

        // Now create an issue
        IssuesApi issuesApi = new IssuesApi(jiraAPIClient);
        Map<String, Object> issueCreateParams = new HashMap<>();

        Map<String, Object> fields = new HashMap<>();
        fields.put("summary", summary);

        // needs to be document type (see REST documentation)
        Map<String, Object> descriptionObject = new HashMap<>();
        descriptionObject.put("type", "doc");
        descriptionObject.put("version", 1);

        Map<String, Object> docContent = new HashMap<>();
        docContent.put("type", "paragraph");

        ArrayList<Map<String, Object>> docParagraphArray = new ArrayList<>();
        docParagraphArray.add(textParagraph(String.format("reported by: %s ", reportedByEmail)));
        docParagraphArray.add(textParagraph(description));
        docContent.put("content", docParagraphArray);

        ArrayList<Map<String, Object>> docContentArray = new ArrayList<>();
        docContentArray.add(docContent);
        descriptionObject.put("content", docContentArray);

        fields.put("description", descriptionObject);
        Map<String, Object> issueTypeField = new HashMap<>();
        issueTypeField.put("id", issueTypeID);

        fields.put("issuetype", issueTypeField);
        Map<String, Object> projectField = new HashMap<>();
        projectField.put("id", project.getId());
        fields.put("project", projectField);

        issueCreateParams.put("fields", fields);

        CreatedIssue createdIssue = issuesApi.comAtlassianJiraRestV2IssueIssueResourceCreateIssuePost(issueCreateParams, true).block();
    }

    private String getIssueType(String issueType, Project project) {
        String issueTypeId = "0";
        // Find the bug issue type
        for (IssueTypeDetails issueTypeDetails : project.getIssueTypes()) {
            if (issueTypeDetails.getName().equalsIgnoreCase(issueType)) {
                issueTypeId = issueTypeDetails.getId();
            }
        }
        return issueTypeId;
    }

    private Project getProject(String projectName) throws ApplicationException {
        ProjectsApi projectsApi = new ProjectsApi(jiraAPIClient);
        PageBeanProject projects = projectsApi.comAtlassianJiraRestV2IssueProjectResourceSearchProjectsGet(
                null, // startAt
                null, // maxResults
                null, // orderBy
                projectName, // query
                null,  // typeKey
                null,  // categoryId
                null,  // searchBy
                null, // action
                "issueTypes", // expand issue types
                null  // status
        ).block();

        if (null == projects || null == projects.getTotal() || projects.getTotal() != 1) {
            throw new ApplicationException("Unable to find correct project");
        }

        return projects.getValues().get(0);
    }

    private User getUser() throws ApplicationException {
        MyselfApi myselfApi = new MyselfApi(jiraAPIClient);
        User user = myselfApi.comAtlassianJiraRestV2IssueCurrentUserResourceGetCurrentUserGet(null).block();
        if (null == user || null == user.getAccountId()) {
            throw new ApplicationException("User (myselfApi) is null");
        }
        return user;
    }

    private Map<String, Object> textParagraph(String message) {
        Map<String, Object> docParagraph = new HashMap<>();
        docParagraph.put("type", "text");
        docParagraph.put("text", message);
        return docParagraph;
    }
}
