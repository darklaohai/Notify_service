package com.jodo.notify.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * @author treemanz SHA256加密
 */
public class SHA256EncryptUtil {

    public static final SHA256EncryptUtil instance = new SHA256EncryptUtil();

    private SHA256EncryptUtil() {

    }

    public String encrypt(String text) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
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
    
    public static void main(String[] args) {
    	System.out.println(instance.encrypt("abcd123456"));
	}

}
