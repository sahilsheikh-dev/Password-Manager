package com.begawo.passwordManager.controller;

import com.begawo.passwordManager.services.UserServices;

public class UserController {

	UserServices userService = new UserServices();

	public boolean login() {
		return userService.login();
	}

	public boolean register() {
		return userService.register();
	}

	public boolean logout() {
		return userService.logout();
	}

}
