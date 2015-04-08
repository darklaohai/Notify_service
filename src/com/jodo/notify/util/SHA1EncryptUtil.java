package com.jodo.notify.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * @author treemanz SHA256加密
 */
public class SHA1EncryptUtil {

    public static final SHA1EncryptUtil instance = new SHA1EncryptUtil();

    private SHA1EncryptUtil() {

    }

    public String encrypt(String text) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA1");
            byte[] hash = digest.digest(text.getBytes("UTF-8"));
            String output = Hex.encodeHexString(hash);
            return output;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
