package com.begawo.passwordManager.dao;

import java.util.ArrayList;
import java.util.List;

import com.begawo.passwordManager.model.Passwords;

public class PasswordDao {

	public Passwords getPasswordByAppName(String appName) {

		return new Passwords();
	}

	public List<Passwords> getAllPasswords() {

		return new ArrayList<Passwords>();
	}

	public Passwords createPassword(Passwords password) {

		return new Passwords();
	}

	public Passwords updatePassword(Passwords password) {

		return new Passwords();
	}

	public boolean deletePassword(String appName) {

		return true;
	}

}
