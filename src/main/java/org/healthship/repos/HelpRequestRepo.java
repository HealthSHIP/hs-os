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

package org.healthship.repos;

import org.healthship.models.HelpRequest;
import org.healthship.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

public interface HelpRequestRepo extends JpaRepository<HelpRequest, String> {
    @Query(value = "from HelpRequest where dtStart between :startDate and :endDate or dtEnd between :startDate and :endDate")
    public List<HelpRequest> getAllBetweenDates(@Param("startDate") ZonedDateTime startDate, @Param("endDate") ZonedDateTime endDate);

    List<HelpRequest> findByVisibleTrue();

    /**
     * Used to return events belonging to other users that have not yet been replied to / selected and that have not
     * yet ended: this is used by the home page
     *
     * todo do some very dumb filtering by coordinate, eg if current user is at 53.0,-3.0 filter out one minute either side
     * of each parameter
     *
     * @param createdBy Created by user: results should not be returned containing this user
     * @param dateTimeTo Typically the current time - events that have ended will not appear
     * @return A list of help requests that are still in date
     */
    List<HelpRequest> findByVisibleTrueAndSelectedUserIsNullAndCreatedByIsNotAndDateTimeToIsAfter(User createdBy, @NotNull ZonedDateTime dateTimeTo);
    /*
        As above, but sorted
     */
    List<HelpRequest> findByVisibleTrueAndSelectedUserIsNullAndCreatedByIsNotAndDateTimeToIsAfterOrderByCreatedDateTimeDesc(User createdBy, ZonedDateTime dateTimeTo);
    /*
        And again...
     */
    List<HelpRequest> findByVisibleTrueAndSelectedUserIsNullAndCreatedByIsNotAndDateTimeToIsAfterOrderByDateTimeFrom(User createdBy, ZonedDateTime dateTimeTo);


    List<HelpRequest> findByCreatedByEqualsAndVisibleIsTrueOrderByDateTimeFrom(User user);

    /**
     * Used for pinging local users service - return any results where the owner has not selected someone
     *
     * @param dateTimeFrom current date and time
     * @return List of all requests that are completely unreplied to
     */
    Set<HelpRequest> findByVisibleTrueAndSelectedUserIsNullAndDateTimeFromIsAfter(@NotNull ZonedDateTime dateTimeFrom);

    Set<HelpRequest> findByVisibleTrueAndSelectedUserIsNullAndDateTimeFromIsAfterAndDateTimeFromIsBefore(@NotNull ZonedDateTime dateTimeFromAfter, @NotNull ZonedDateTime dateTimeFromBefore);

    Set<HelpRequest> findByVisibleTrueAndSelectedUserIsNullAndDateTimeToIsAfterAndDateTimeToIsBefore(@NotNull ZonedDateTime dateTimeToAfter, @NotNull ZonedDateTime dateTimeToBefore);

    /**
     * Allow us to return the listings for which the currently logged in user is volunteering - including up
     * to the end of the event (in case they've forgotten to attend or are running late...)
     * @param selectedUser The user that was selected to help
     * @param dateTimeTo Should be the current time
     * @return List of requests for which the user has agreed to volunteer
     */
    Set<HelpRequest> findBySelectedUserEqualsAndDateTimeToIsAfterOrderByDateTimeFrom(@NotNull User selectedUser, @NotNull ZonedDateTime dateTimeTo);

    /**
     * For returning requests for map purposes
     */
    List<HelpRequest> findByVisibleTrueAndSelectedUserIsNullAndDateTimeFromIsAfterAndOriginLatBetweenAndOriginLngBetween(
            @NotNull ZonedDateTime dateTimeFrom,
            @NotNull Float latMin, @NotNull Float latMax,
            @NotNull Float longMin, @NotNull Float longMax
    );

    List<HelpRequest> findBySelectedUserIsNotNullAndSelectedUserDateTimeIsAfterAndOriginLatBetweenAndOriginLngBetween(
            @NotNull ZonedDateTime selectedDateTimeFrom,
            @NotNull Float latMin, @NotNull Float latMax,
            @NotNull Float longMin, @NotNull Float longMax
    );

    // so we don't have to change behaviour of lazy-load / degrade performance for every select
    Boolean existsByIdAndRespondedByContains(String id, User respondedBy);

    Boolean existsHelpRequestByIdAndRespondedByIsNull(String id);
}
