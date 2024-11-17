package com.begawo.passwordManager.controller;

import com.begawo.passwordManager.services.PasswordServices;

public class PasswordController {

	PasswordServices passwordService = new PasswordServices();

	public boolean getPassword() {
		return passwordService.getPassword();
	}

	public boolean getAllPasswords() {
		return passwordService.getAllPasswords();
	}

	public boolean createPassword() {
		return passwordService.createPassword();
	}

	public boolean updatePassword() {
		return passwordService.updatePassword();
	}

	public boolean deletePassword() {
		return passwordService.deletePassword();
	}

}
