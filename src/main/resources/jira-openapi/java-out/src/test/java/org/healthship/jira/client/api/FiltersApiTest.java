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

import org.healthship.jira.client.model.ColumnItem;
import org.healthship.jira.client.model.Filter;
import org.healthship.jira.client.model.PageBeanFoundFilter;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * API tests for FiltersApi
 */
@Ignore
public class FiltersApiTest {

    private final FiltersApi api = new FiltersApi();

    
    /**
     * Create filter
     *
     * Creates a filter. The filter is shared according to the [default share scope](#api-rest-api-3-filter-post). The filter is not selected as a favorite.  **[Permissions](#permissions) required:** Permission to access Jira.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceCreateFilterPostTest()  {
        Filter filter = null;
        String expand = null;
        Filter response = api.comAtlassianJiraRestV2SearchFilterResourceCreateFilterPost(filter, expand).block();

        // TODO: test validations
    }
    
    /**
     * Remove filter as favorite
     *
     * Removes a filter as a favorite for the user. Note that this operation only removes filters visible to the user from the user&#39;s favorites list. For example, if the user favorites a public filter that is subsequently made private (and is therefore no longer visible on their favorites list) they cannot remove it from their favorites list.  **[Permissions](#permissions) required:** Permission to access Jira.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceDeleteFavouriteForFilterDeleteTest()  {
        Long id = null;
        String expand = null;
        Filter response = api.comAtlassianJiraRestV2SearchFilterResourceDeleteFavouriteForFilterDelete(id, expand).block();

        // TODO: test validations
    }
    
    /**
     * Delete filter
     *
     * Delete a filter.  **[Permissions](#permissions) required:** Permission to access Jira, however filters can only be deleted by the creator of the filter or a user with *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceDeleteFilterDeleteTest()  {
        Long id = null;
        api.comAtlassianJiraRestV2SearchFilterResourceDeleteFilterDelete(id).block();

        // TODO: test validations
    }
    
    /**
     * Get columns
     *
     * Returns the columns configured for a filter. The column configuration is used when the filter&#39;s results are viewed in *List View* with the *Columns* set to *Filter*.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, column details are only returned for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceGetColumnsGetTest()  {
        Long id = null;
        List<ColumnItem> response = api.comAtlassianJiraRestV2SearchFilterResourceGetColumnsGet(id).collectList().block();

        // TODO: test validations
    }
    
    /**
     * Get favorite filters
     *
     * Returns the visible favorite filters of the user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** A favorite filter is only visible to the user where the filter is:   *  owned by the user.  *  shared with a group that the user is a member of.  *  shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  shared with a public project.  *  shared with the public.  For example, if the user favorites a public filter that is subsequently made private that filter is not returned by this operation.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceGetFavouriteFiltersGetTest()  {
        String expand = null;
        List<Filter> response = api.comAtlassianJiraRestV2SearchFilterResourceGetFavouriteFiltersGet(expand).collectList().block();

        // TODO: test validations
    }
    
    /**
     * Get filter
     *
     * Returns a filter.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, the filter is only returned where it is:   *  owned by the user.  *  shared with a group that the user is a member of.  *  shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  shared with a public project.  *  shared with the public.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceGetFilterGetTest()  {
        Long id = null;
        String expand = null;
        Filter response = api.comAtlassianJiraRestV2SearchFilterResourceGetFilterGet(id, expand).block();

        // TODO: test validations
    }
    
    /**
     * Get filters
     *
     * Returns all filters. Deprecated, use [ Search for filters](#api-rest-api-3-filter-search-get) that supports search and pagination.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, only the following filters are returned:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceGetFiltersGetTest()  {
        String expand = null;
        List<Filter> response = api.comAtlassianJiraRestV2SearchFilterResourceGetFiltersGet(expand).collectList().block();

        // TODO: test validations
    }
    
    /**
     * Search for filters
     *
     * Searches for filters. This operation is similar to [Get filters](#api-rest-api-3-filter-get) except that the results can be refined to include filters that have specific attributes. For example, filters with a particular name. When multiple attributes are specified only filters matching all attributes are returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, only the following filters that match the query parameters are returned:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceGetFiltersPaginatedGetTest()  {
        String filterName = null;
        String accountId = null;
        String owner = null;
        String groupname = null;
        Long projectId = null;
        String orderBy = null;
        Long startAt = null;
        Integer maxResults = null;
        String expand = null;
        PageBeanFoundFilter response = api.comAtlassianJiraRestV2SearchFilterResourceGetFiltersPaginatedGet(filterName, accountId, owner, groupname, projectId, orderBy, startAt, maxResults, expand).block();

        // TODO: test validations
    }
    
    /**
     * Get my filters
     *
     * Returns the filters owned by the user. If &#x60;includeFavourites&#x60; is &#x60;true&#x60;, the user&#39;s visible favorite filters are also returned.  **[Permissions](#permissions) required:** Permission to access Jira, however, a favorite filters is only visible to the user where the filter is:   *  owned by the user.  *  shared with a group that the user is a member of.  *  shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  shared with a public project.  *  shared with the public.  For example, if the user favorites a public filter that is subsequently made private that filter is not returned by this operation.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceGetMyFiltersGetTest()  {
        String expand = null;
        Boolean includeFavourites = null;
        List<Filter> response = api.comAtlassianJiraRestV2SearchFilterResourceGetMyFiltersGet(expand, includeFavourites).collectList().block();

        // TODO: test validations
    }
    
    /**
     * Reset columns
     *
     * Reset the user&#39;s column configuration for the filter to the default.  **[Permissions](#permissions) required:** Permission to access Jira, however, columns are only reset for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceResetColumnsDeleteTest()  {
        Long id = null;
        api.comAtlassianJiraRestV2SearchFilterResourceResetColumnsDelete(id).block();

        // TODO: test validations
    }
    
    /**
     * Set columns
     *
     * Sets the columns for a filter. Only navigable fields can be set as columns. Use [Get fields](#api-rest-api-3-field-get) to get the list fields in Jira. A navigable field has &#x60;navigable&#x60; set to &#x60;true&#x60;.  The parameters for this resource are expressed as HTML form data. For example, in curl:  &#x60;curl -X PUT -d columns&#x3D;summary -d columns&#x3D;description https://your-domain.atlassian.net/rest/api/3/filter/10000/columns&#x60;  **[Permissions](#permissions) required:** Permission to access Jira, however, columns are only set for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceSetColumnsPutTest()  {
        Long id = null;
        List<String> requestBody = null;
        Object response = api.comAtlassianJiraRestV2SearchFilterResourceSetColumnsPut(id, requestBody).block();

        // TODO: test validations
    }
    
    /**
     * Add filter as favorite
     *
     * Add a filter as a favorite for the user.  **[Permissions](#permissions) required:** Permission to access Jira, however, the user can only favorite:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceSetFavouriteForFilterPutTest()  {
        Long id = null;
        String expand = null;
        Filter response = api.comAtlassianJiraRestV2SearchFilterResourceSetFavouriteForFilterPut(id, expand).block();

        // TODO: test validations
    }
    
    /**
     * Update filter
     *
     * Updates a filter. Use this operation to update a filter&#39;s name, description, JQL, or sharing.  **[Permissions](#permissions) required:** Permission to access Jira, however the user must own the filter.
     */
    @Test
    public void comAtlassianJiraRestV2SearchFilterResourceUpdateFilterPutTest()  {
        Long id = null;
        Filter filter = null;
        String expand = null;
        Filter response = api.comAtlassianJiraRestV2SearchFilterResourceUpdateFilterPut(id, filter, expand).block();

        // TODO: test validations
    }
    
}
