package com.jodo.notify.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @author ygchiaaa
 * 對稱加密算法
 */
public class AESencryptUtil {

	
	private Cipher _encrypt;
	private Cipher _decrypt;
	
	private static AESencryptUtil defaultInstance;
	private static AESencryptUtil emailKeyEn;
	
	public static AESencryptUtil getDefaultInstance() {
		if( defaultInstance == null) {
			try {
				defaultInstance= new AESencryptUtil("a03cd5k6h8l0n5oo");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return defaultInstance;
	}
	
	public static AESencryptUtil getEmailAeSencryptUtil() {
	    if( emailKeyEn == null) {
                try {
                    emailKeyEn= new AESencryptUtil("ao3cd4k6h8l0n5o1");
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
        return emailKeyEn;
	}
	
	public AESencryptUtil(String privateKey) throws Exception {
		if(privateKey.length() % 8 != 0) {
			System.out.println("ken length = "+ privateKey.length());
		}
		SecretKeySpec key = new SecretKeySpec( privateKey.getBytes("utf-8"), "AES");
		_encrypt = Cipher.getInstance("AES");	
		_encrypt.init(Cipher.ENCRYPT_MODE, key);
		
		_decrypt = Cipher.getInstance("AES");
		_decrypt.init(Cipher.DECRYPT_MODE, key);
	}
	
	public String encrypt(String plainText) throws Exception {
		byte[] en = _encrypt.doFinal(plainText.getBytes("utf-8"));
		return parseBytesToHexString(en);
	}
	
	public String decrypt(String encryptString) throws Exception {
		byte[] bytes = parseHexStringToBytes(encryptString);
		byte[] de = _decrypt.doFinal(bytes);
		return new String(de);
	}
	
	private String parseBytesToHexString(byte[] byteArray) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<byteArray.length; i++) {
			String hex = Integer.toHexString(byteArray[i] & 0xFF);
			if(hex.length() == 1) {
				sb.append("0").append(hex);
			} else {
				sb.append(hex);
			}
		}
		return sb.toString();
	}
	
	private byte[] parseHexStringToBytes(String hexString) {
		byte[] result = new byte[hexString.length() / 2];
		for(int i=0; i<hexString.length() / 2; i++) {
			int high = Integer.parseInt(hexString.substring(i*2, i*2 + 1), 16);
			int low = Integer.parseInt(hexString.substring(i*2 + 1, i*2 + 2), 16);
			result[i] = (byte)(high * 16 + low);
		}
		return result;
	}
	
	public static void main(String[] args) {
		try {
			
			String decrypt = AESencryptUtil.getDefaultInstance().decrypt("fd38bd89bd50d4b7848679b997eb21c5656b97a147a176d1574435c4d0221a9db9378c104d7e7c2cc8a274ef131293c3a1b57b9fa8c0b2f88c1e6cc485a03b063e1fb127c0aaf95cf805b55270fdc79c44bf938e95424be17e2a8bb35bc779ad6d352b2c46880dd4633b11048daa6a7f");
			System.out.println(decrypt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
