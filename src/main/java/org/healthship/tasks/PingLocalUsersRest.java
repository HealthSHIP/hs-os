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

package org.healthship.tasks;

import org.healthship.exceptions.ApplicationException;
import org.healthship.models.HelpRequest;
import org.healthship.models.User;
import org.healthship.models.UserType;
import org.healthship.models.internal.PingType;
import org.healthship.repos.HelpRequestRepo;
import org.healthship.repos.PingRepo;
import org.healthship.repos.UserRepository;
import org.healthship.services.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@RestController
@Profile({"proxy", "proxy-int", "local"})
public class PingLocalUsersRest {

    @Autowired(required = false)
    PingLocalUsersSchdTask pingSvc;
    UserRepository userRepository;
    HelpRequestRepo helpRequestRepo;
    PingRepo pingRepo;

    public PingLocalUsersRest(UserRepository userRepository, HelpRequestRepo helpRequestRepo, PingRepo pingRepo) {
        this.userRepository = userRepository;
        this.helpRequestRepo = helpRequestRepo;
        this.pingRepo = pingRepo;
    }

    @RequestMapping("/debug/tasks/ping")
    public void pingUsers() throws ApplicationException {
        if (null == pingSvc) {
            throw new ApplicationException("PingSvc not running");
        }
        pingSvc.pingLocalUsersNonUrgently();
    }

    // sense check - check how filtering is working
    @RequestMapping("/debug/tasks/ping-check")
    public void pingUsersCheck() {

        Set<HelpRequest> unrepliedRequests = helpRequestRepo.findByVisibleTrueAndSelectedUserIsNullAndDateTimeFromIsAfter(
                // urgent posts are dealt with by a separate task that just pings everyone
                ZonedDateTime.now().plusHours(3)
        );
        for (HelpRequest unrepliedRequest : unrepliedRequests) {
            System.out.println("Checking possible volunteers for task: https://healthship.org/requests/" + unrepliedRequest.getId());

            float offsetDegrees = 0.4f; // ~±44km

            List<User> users = userRepository.findByUserTypeIsAndLngLessThanAndLatLessThanAndLngGreaterThanAndLatGreaterThan(
                    UserType.student,
                    unrepliedRequest.getOriginLng() + offsetDegrees, unrepliedRequest.getOriginLat() + offsetDegrees,
                    unrepliedRequest.getOriginLng() - offsetDegrees, unrepliedRequest.getOriginLat() - offsetDegrees);
            for (User user : users) {
                user.setTransientGeoDistanceMetres(Utils.getDistanceMetres(
                        unrepliedRequest.getOriginLng(), unrepliedRequest.getOriginLat(), user.getLng(), user.getLat())
                );
            }

            System.out.println("*** WARNING THIS IS NOT FILTERING BY WHETHER USER WANTS EMAILS ***");

            users.removeIf(user -> user.getTransientGeoDistanceMetres() > user.getNotifyRadius().getMetres());
            System.out.println("After within notification radius check: " + users.size());

            users.removeIf(user -> unrepliedRequest.getRequiresPVG() && !user.isPVGVerified());
            System.out.println("After PVG now have " + users.size());

            users.removeIf(user -> helpRequestRepo.existsByIdAndRespondedByContains(unrepliedRequest.getId(), user));
            System.out.println("After already pinged for task check: " + users.size());

            users.removeIf(user -> pingRepo.existsByVolunteerAndPingedDTAfterAndPingType(user, ZonedDateTime.now().minusHours(12), PingType.email));
            System.out.println("After check for > 12h: " + users.size());

            users.removeIf(user -> pingRepo.existsByHelpRequestAndVolunteerAndPingType(unrepliedRequest, user, PingType.email));
            System.out.println("After check for already pinged for this: " + users.size());

            System.out.println("> Final list of users for task " + unrepliedRequest.getId());
            for (User user : users) {
                System.out.println("\t" + user.getUsername());
            }
            System.out.println("==========");
        }
    }

}
