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

import org.healthship.exceptions.ApplicationException;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public byte[] compress(byte[] input) throws ApplicationException {
        try {
            BufferedImage original = ImageIO.read(new ByteArrayInputStream(input));
            // if image hasn't been read correctly, it'll be returned as null
            if (null == original) {
                throw new ApplicationException("Input image could not be read, could not resize");
            }
            Dimension newMaxSize = new Dimension(255, 255);
            BufferedImage resizedImg = Scalr.resize(original, Scalr.Mode.AUTOMATIC,
                    newMaxSize.width, newMaxSize.height);
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                ImageIO.write(resizedImg, "PNG", baos);
                return baos.toByteArray();
            }
        } catch (IOException e) {
            throw new ApplicationException("Unable to resize image");
        }
    }
}
