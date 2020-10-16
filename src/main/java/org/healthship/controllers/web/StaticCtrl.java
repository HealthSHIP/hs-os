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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/*
    Dumping ground for all static pages
 */
public class StaticCtrl {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String showAbout(Model model) {
        model.addAttribute("section", "about");
        return "static/about";
    }

    @RequestMapping(value = "/about/faqs", method = RequestMethod.GET)
    public String showFAQs(Model model) {
        model.addAttribute("section", "about");
        return "static/faqs";
    }

    @RequestMapping(value = "/privacy", method = RequestMethod.GET)
    public String showPrivacy(Model model) {
        model.addAttribute("section", "privacy");
        return "static/privacy";
    }

    @RequestMapping(value = "/registration-confirmed", method = RequestMethod.GET)
    public String showConfirmedUser(Model model) {
        model.addAttribute("section", "regConfirm");
        return "static/regConfirm";
    }

    @RequestMapping(value = "/terms", method = RequestMethod.GET)
    public String showTerms(Model model) {
        model.addAttribute("section", "terms");
        return "static/terms";
    }

    @RequestMapping(value = "/contact/confirmed", method = RequestMethod.GET)
    public String showContact(Model model) {
        model.addAttribute("section", "contactConfirmed");
        return "static/contactConfirm";
    }

    @RequestMapping(value = "/cookies", method = RequestMethod.GET)
    public String showCookies(Model model) {
        model.addAttribute("section", "cookies");
        return "static/cookies";
    }

    @RequestMapping(value = "/recommendations", method = RequestMethod.GET)
    public String showRecommendations(Model model) {
        model.addAttribute("section", "recommendations");
        return "static/recommendations";
    }

    @RequestMapping(value = "/push-notifications", method = RequestMethod.GET)
    public String showPushNotifications(Model model) {
        model.addAttribute("section", "pushNotifications");
        return "static/firebase.html";
    }

    // stupidly put the wrong QR code on the presentation ...
    @RequestMapping(value = "/links/gc", method = RequestMethod.GET)
    public String getApplicationInfo1(Model model) {
        return "redirect:https://links.healthship.org/gc";
    }

    @RequestMapping(value = "/link/gc", method = RequestMethod.GET)
    public String getApplicationInfo2(Model model) {
        return "redirect:https://links.healthship.org/gc";
    }

    // requests to the unsubscribe link should redirect to the profile login
    @RequestMapping(value = "/unsubscribe", method = RequestMethod.GET)
    public String redirectToUnsubscribe() {
        return "redirect:/profile?unsubscribe";
    }
}
