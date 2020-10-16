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

package org.healthship.models;

import com.google.common.io.Resources;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Table(name = "avatars")
public class Avatar {

    private static byte[] defaultImage;

    static {
        try {
            defaultImage = Resources.toByteArray(Resources.getResource("images/defaultAvatar.jpg"));
        } catch (IOException e) {
            throw new RuntimeException("Unable to open default avatar file");
        }
    }

    @Id
    String id;

    @Lob
    @Column(length = 10240000) // 10 MB but gets compressed elsewhere
    byte[] image;

    public Avatar() {}

    public Avatar(User user, byte[] image) {
        this.id = user.getUsername();
        this.image = image;
    }

    public Avatar(byte[] defaultImage) {
        this.image = defaultImage;
    }

    public static Avatar getDefault() {
        return new Avatar(defaultImage);
    }

    public byte[] getImage() {
        return image;
    }

    public Avatar setImage(byte[] image) {
        this.image = image;
        return this;
    }
}
