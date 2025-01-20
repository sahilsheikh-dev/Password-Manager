package com.begawo.passwordManager.controller;

import com.begawo.passwordManager.mockHttpSession.MockHttpSession;
import com.begawo.passwordManager.services.PasswordServices;

public class PasswordController {

	PasswordServices passwordService = new PasswordServices();

	public boolean getPassword(MockHttpSession session) {
		return passwordService.getPassword(session);
	}

	public boolean getAllPasswords(MockHttpSession session) {
		return passwordService.getAllPasswords(session);
	}

	public boolean createPassword(MockHttpSession session) {
		return passwordService.createPassword(session);
	}

	public boolean updatePassword(MockHttpSession session) {
		return passwordService.updatePassword(session);
	}

	public boolean deletePassword(MockHttpSession session) {
		return passwordService.deletePassword(session);
	}

}
