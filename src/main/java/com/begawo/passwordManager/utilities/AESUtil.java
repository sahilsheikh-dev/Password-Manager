package com.begawo.passwordManager.utilities;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AESUtil {

	// Encrypt password using AES
	public static String encrypt(String password, String key) {
		try {
			SecretKey secretKey = generateKey(key);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes()));

		} catch (Exception e) {
			throw new RuntimeException("Error while encrypting", e);
		}
	}

	// Decrypt password using AES
	public static String decrypt(String encryptedPassword, String key) {
		try {
			SecretKey secretKey = generateKey(key);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedPassword)));

		} catch (Exception e) {
			throw new RuntimeException("Error while decrypting", e);
		}
	}

	// Generate AES key from user login password
	private static SecretKey generateKey(String key) throws Exception {
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(key.toCharArray(), key.getBytes(), 65536, 256);
		return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
	}
}
