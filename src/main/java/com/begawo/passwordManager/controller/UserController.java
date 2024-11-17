package com.begawo.passwordManager.controller;

import com.begawo.passwordManager.model.Users;
import com.begawo.passwordManager.services.UserServices;

public class UserController {

	UserServices userService = new UserServices();

	public Users login(String username, String password) {
		return userService.login(username, password);
	}

	public Users register(Users user) {
		return userService.register(user);
	}

	public boolean logout() {
		return userService.logout();
	}

}
