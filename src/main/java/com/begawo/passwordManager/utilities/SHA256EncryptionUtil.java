package com.begawo.passwordManager.utilities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SHA256EncryptionUtil {

	public static String generateSalt() {
		byte[] salt = new byte[16];
		new SecureRandom().nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}

	public static String sha256Encrypt(String password, String salt) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String saltedPassword = salt + password;
			byte[] hash = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));

			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error while encryption using SHA-256", e);
		}
	}

}
