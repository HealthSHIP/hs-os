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
CREATE TABLE `resources` (
  `id` varchar(255) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `type` varchar(12) DEFAULT NULL,
  `uri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `requests_resources` (
  `help_request_id` varchar(255) NOT NULL,
  `resources_id` varchar(255) NOT NULL,
  PRIMARY KEY (`help_request_id`,`resources_id`),
  UNIQUE KEY `UK_e4d5ebmsqo9e2ldjttrm5esvv` (`resources_id`),
  CONSTRAINT `FKjasqn4j5wumqi18vdm1qik1bq` FOREIGN KEY (`help_request_id`) REFERENCES `requests` (`id`),
  CONSTRAINT `FKm8qqyr2gis1i5exow61pi8jqf` FOREIGN KEY (`resources_id`) REFERENCES `resources` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;