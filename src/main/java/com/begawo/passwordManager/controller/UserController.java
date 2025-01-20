package com.begawo.passwordManager.controller;

import com.begawo.passwordManager.mockHttpSession.MockHttpSession;
import com.begawo.passwordManager.services.UserServices;

public class UserController {

	UserServices userService = new UserServices();

	public boolean login(MockHttpSession session) {
		return userService.login(session);
	}

	public boolean register() {
		return userService.register();
	}

	public boolean logout(MockHttpSession session) {
		return userService.logout(session);
	}

}
