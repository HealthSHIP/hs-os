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

package org.healthship.controllers.web;

import org.healthship.models.ShortCode;
import org.healthship.repos.ShortCodesRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MobileShortCodeFunctions {

    ShortCodesRepo shortCodesRepo;

    public MobileShortCodeFunctions(ShortCodesRepo shortCodesRepo) {
        this.shortCodesRepo = shortCodesRepo;
    }

    @RequestMapping(value = "/m/{shortCode}", method = RequestMethod.GET)
    public String redirectShortCode(@PathVariable("shortCode") String shortCode) {
        if (shortCodesRepo.existsById(shortCode)) {
            ShortCode sc = shortCodesRepo.getOne(shortCode);
            sc.setCount(sc.getCount() + 1);
            shortCodesRepo.save(sc);
            return String.format("redirect:/requests/%s", sc.getHelpRequest().getId());
        }
        return "redirect:/";
    }

}
