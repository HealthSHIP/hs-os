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

package org.healthship.services;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service(value = "spbe5Service")
public class SPBE5Service {

    @Value("${spbe5-password}")
    String spbe5Password;

    StandardPBEStringEncryptor encryptor;

    @PostConstruct
    public void setup() {
        encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(spbe5Password);
        encryptor.setStringOutputType("hexadecimal");
    }

    public String encrypt(String input) {
        return encryptor.encrypt(input);
    }

    public String decrypt(String input) {
        return encryptor.decrypt(input);
    }
}
