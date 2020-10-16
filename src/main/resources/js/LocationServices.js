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

// used on any page where location modal is saving lat/long back to form
function saveLocation(field) {
    if (circles[field] == null) {
        $.toast({
            title: "System message",
            subtitle: "Now",
            content: "You must enter a location",
            type: "danger",
            delay: 3000,
        });
    }
    else {
        console.log(circles[field]);
        $(`#${field}`).val($(`#${field}ModalField`).val());
        $(`#${field}Lng`).val(circles[field].center.lng());
        $(`#${field}Lat`).val(circles[field].center.lat());
        $(`#${field}Modal`).modal('hide');
    }
}

// requires array of mapInstances to already be instantiated
function initMaps() {
    for (const map of mapInstances) {
        map();
    }
}

// Calls distance service asynchronously to save us killing load time
$(document).ready(function () {
    $('.distanceMatrixElement').each(function(i, obj) {
        jObj = $(obj);
        $.ajax({
            url: '/api/map/distance',
            headers: {
                _csrf: _csrf
            },
            data: {
                type: jObj.data('type'),
                helpRequest: jObj.data('request-id')
            },
            success: function (data) {
                jObj.html(`<p class="alert alert-warning">
                    Note: drop off required at <span class="font-weight-bold">${jObj.data('destination')}</span>
                    (${data.distanceFormatted} / ${data.durationFormatted} away from ${jObj.data('origin')} by road)
                </p>`);
            }
        })
    });
});