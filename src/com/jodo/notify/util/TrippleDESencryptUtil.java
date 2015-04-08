package com.jodo.notify.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @author ygchiaaa
 * 對稱加密算法
 */
public class TrippleDESencryptUtil {

	
	private Cipher _encrypt;
	private Cipher _decrypt;
	
	private static TrippleDESencryptUtil defaultInstance;
	
	public static TrippleDESencryptUtil getDefaultInstance() {
		if( defaultInstance == null) {
			try {
				defaultInstance= new TrippleDESencryptUtil("517A3024D0F244FFB504F066");
				                                                                                   
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return defaultInstance;
	}
	
	public TrippleDESencryptUtil(String privateKey) throws Exception {
		if(privateKey.length() % 8 != 0) {
			System.out.println("ken length = "+ privateKey.length());
		}
		
		SecretKeySpec key = new SecretKeySpec( privateKey.getBytes("utf-8"), "TripleDES");
		_encrypt = Cipher.getInstance("TripleDES/ECB/PKCS5Padding"  );	//java不支持PKCS7Padding?
		_encrypt.init(Cipher.ENCRYPT_MODE, key);
		
		_decrypt = Cipher.getInstance("TripleDES/ECB/PKCS5Padding");
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
			
			String decrypt = TrippleDESencryptUtil.getDefaultInstance().encrypt("123456");
			System.out.println(decrypt);
			String ee = TrippleDESencryptUtil.getDefaultInstance().decrypt(decrypt.toUpperCase());
			System.out.println(ee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
