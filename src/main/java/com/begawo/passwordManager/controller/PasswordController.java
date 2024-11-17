package com.begawo.passwordManager.controller;

import java.util.List;

import com.begawo.passwordManager.model.Passwords;
import com.begawo.passwordManager.services.PasswordServices;

public class PasswordController {

	PasswordServices passwordService = new PasswordServices();

	public Passwords getPassword(String appName) {
		return passwordService.getPassword(appName);
	}

	public List<Passwords> getAllPasswords() {
		return passwordService.getAllPasswords();
	}

	public Passwords createPassword(Passwords password) {
		return passwordService.createPassword(password);
	}

	public Passwords updatePassword(Passwords password) {
		return passwordService.updatePassword(password);
	}

	public boolean deletePassword(String appName) {
		return passwordService.deletePassword(appName);
	}

}
