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

ALTER TABLE pings ADD delivered BOOLEAN;
ALTER TABLE pings ADD ping_type VARCHAR(64) NOT NULL;

UPDATE pings SET ping_type='email';

CREATE TABLE short_codes (
  short_code varchar(16) UNIQUE NOT NULL,
  count int,
  created_dt datetime,
  help_request_id VARCHAR(255),
  user_username VARCHAR(255),
  PRIMARY KEY (`short_code`),
  KEY `FK_SC_000` (`help_request_id`),
  KEY `FK_SC_001` (`user_username`),
  CONSTRAINT `FK_SC_000` FOREIGN KEY (`help_request_id`) REFERENCES `requests` (`id`),
  CONSTRAINT `FK_SC_001` FOREIGN KEY (`user_username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

COMMIT;