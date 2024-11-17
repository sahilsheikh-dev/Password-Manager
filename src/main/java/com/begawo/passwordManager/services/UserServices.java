package com.begawo.passwordManager.services;

import com.begawo.passwordManager.model.Users;

public class UserServices {

	public Users login(String username, String password) {

		return new Users();
	}

	public Users register(Users user) {

		return new Users();
	}

	public boolean logout() {

		return true;
	}

}
