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

import org.bouncycastle.util.encoders.Base64;
import org.healthship.exceptions.ApplicationException;
import org.healthship.models.User;
import org.healthship.models.internal.TKTObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

/*
    with thanks to https://artofcode.wordpress.com/2017/05/26/rsa-signatures-in-java-with-bouncy-castle/
 */

@Service
public class ModAuthPubtktImpl implements ModAuthPubtkt {

    @Value("${mod-pubtkt.key}")
    private Resource privateKeyFile;

    RSAPrivateKey privateKey;

    @PostConstruct
    public void postConstruct() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        String keyContents = StreamUtils.copyToString(privateKeyFile.getInputStream(), Charset.defaultCharset());

        // https://community.oracle.com/thread/1528259
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(Base64.decode(keyContents));
        privateKey = (RSAPrivateKey) keyFactory.generatePrivate(privSpec);
    }

    @Override
    public String generateTicket(User user) throws ApplicationException {
        TKTObject tkt = new TKTObject(user.getUsername());
        try {
            Signature signature = Signature.getInstance("SHA1WithRSA", "BC");
            signature.initSign(privateKey);
            signature.update(tkt.toString().getBytes());
            String token = String.format("%s;sig=%s", tkt.toString(), new String(Base64.encode(signature.sign())));
            return URLEncoder.encode(token, "UTF-8");
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | UnsupportedEncodingException e) {
            throw new ApplicationException("Unable to generate SSO token", e);
        }
    }

}
