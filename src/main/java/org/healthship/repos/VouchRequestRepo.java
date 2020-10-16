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

import org.healthship.models.User;
import org.healthship.models.VouchRequest;
import org.healthship.models.VouchState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VouchRequestRepo extends JpaRepository<VouchRequest, String> {
    VouchRequest findByClinicianEqualsAndVolunteerEquals(User clinician, User volunteer);
    List<VouchRequest> findByClinicianEqualsAndStateEquals(User clinician, VouchState state);
}
