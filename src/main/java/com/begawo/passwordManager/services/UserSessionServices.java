package com.begawo.passwordManager.services;

import com.begawo.passwordManager.model.Users;

public class UserSessionServices {

	public Users getCurrentSession() {
		return new Users();
	}

	public Users addCurrentSession(Users user) {
		return new Users();
	}

	public boolean deleteCurrentSession() {
		return true;
	}

}
