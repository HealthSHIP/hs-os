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

// alerts setup
// https://stackoverflow.com/questions/35641306/
(function ($) {
    $.fn.alertify = function (options) {
        // This is the easiest way to have default options.
        var $target = this;
        var settings = $.extend({
            // These are the defaults.
            type: 'danger',
            class: 'alertify',
            content: 'There was an error',
            speed: 500,
            delay: 5000,
            complete: function () { // callback function to be called after a the display time
                $target.prev().slideUp(settings.speed, function () {
                    $target.prev().remove();
                });
            }
        }, options);
        var $alert = $('<div class="alert alert-' + settings.type + ' ' + settings.class + '">' + settings.content + '</div>');
        $alert.hide().insertBefore(this).slideDown(settings.speed, function () {
            setTimeout(function () {
                settings.complete();
            }, settings.delay);
        });
    };
    return this;
}(jQuery));

(function (b) {
    // another stackoverflow script I nicked but I've now lost the link / reference ...
    b.toast = function (a, h, g, l, k) {
        b("#toast-container").length || (b("body").prepend(`
                    <div id="toast-container" aria-live="polite" aria-atomic="true"></div>`),
            b("#toast-container").append('<div id="toast-wrapper"></div>'));
        var c = "", d = "", e = "text-muted", f = "",
            m = "object" === typeof a ? a.title || "" : a || "Notice!";
        h = "object" === typeof a ? a.subtitle || "" : h || "";
        g = "object" === typeof a ? a.content || "" : g || "";
        k = "object" === typeof a ? a.delay || 3E3 : k || 3E3;
        switch ("object" === typeof a ? a.type || "" : l || "info") {
            case "info":
                c = "bg-info";
                f = e = d = "text-white";
                break;
            case "success":
                c = "bg-success";
                f = e = d = "text-white";
                break;
            case "warning":
            case "warn":
                c = "bg-warning";
                f = e = d = "text-white";
                break;
            case "error":
            case "danger":
                c = "bg-danger", f = e = d = "text-white"
        }
        a = `<div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="${k}">
                        <div class="toast-header ${c} ${d}"><strong class="mr-auto">${m}</strong>
                        <small class="${e} ml-3">${h}</small>
                        <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">`;
        a += `<span aria-hidden="true" class="${f}">&times;</span></button></div>`;

        "" !== g && (a += '<div class="toast-body">', a += g, a += "</div>");
        a += "</div>";

        b("#toast-wrapper").append(a);
        b("#toast-wrapper .toast:last").toast("show")
    }
})(jQuery);
const TYPES = ['info', 'warning', 'success', 'error'];