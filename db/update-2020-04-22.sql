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

USE healthship;
START TRANSACTION;
DROP TABLE postcodes;
DROP TABLE help_request_help_id;
COMMIT;

ALTER TABLE users CHANGE latitude lat DECIMAL(8,5);
ALTER TABLE users CHANGE longitude lng DECIMAL(8,5);
ALTER TABLE users CHANGE notify_radius radius_km int;
DROP TABLE survey_responses;
COMMIT;

CREATE TABLE survey_responses (
  id varchar(255) UNIQUE NOT NULL,
  completeddt datetime,
  surveyid varchar(255),
  primary key (id),
  user_username varchar(255) NOT NULL,
  constraint FKpjwuujrjgqtm3bog0nc5af5xt foreign key (user_username) references users (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

CREATE TABLE distance_matrices (
  id varchar(255) UNIQUE NOT NULL,
  crow_metres bigint,
  metres bigint,
  seconds bigint,
  updateddt datetime
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

ALTER TABLE requests CHANGE location origin varchar(255);
ALTER TABLE requests CHANGE latitude origin_lat float;
ALTER TABLE requests CHANGE longitude origin_lng float;
ALTER TABLE requests ADD help_with varchar(255);
UPDATE requests AS r INNER JOIN help_request_help_with AS h ON r.id=h.help_request_id
SET r.help_with = h.help_with;

ALTER TABLE requests ADD destination varchar(255);
ALTER TABLE requests ADD destination_lat float;
ALTER TABLE requests ADD destination_lng float;
ALTER TABLE requests ADD instructions VARCHAR(512);
ALTER TABLE users ADD useruom VARCHAR(32);
UPDATE users SET useruom='miles';
UPDATE users SET radius_km=34 WHERE radius_km=25;
UPDATE users SET radius_km=3 WHERE radius_km=2 OR radius_km=1;
UPDATE users SET radius_km=21 WHERE radius_km=19;

COMMIT;