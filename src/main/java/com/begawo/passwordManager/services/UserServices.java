package com.begawo.passwordManager.services;

import java.util.Scanner;

import com.begawo.passwordManager.dao.UserDao;
import com.begawo.passwordManager.mockHttpSession.MockHttpSession;
import com.begawo.passwordManager.model.Users;

public class UserServices {

	UserDao userDao = new UserDao();
	UserSessionServices userSessionService = new UserSessionServices();
	Scanner sc = new Scanner(System.in);

	public boolean login(MockHttpSession session) {
		System.out.println("Please login to continue...");
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();

		Users user = userDao.getUserByUsernamePassword(username, password);
		if (user != null) {
			if (userSessionService.addCurrentSession(session, user) != null) {
				System.out.println("LoggedIn Successfully");
				return true;
			} else {
				System.out.println("Error while saving the session");
				return false;
			}
		} else {
			System.out.println("LoggedIn Failed dur to Incorrect usernamr/password or any other error");
			return false;
		}
	}

	public boolean register() {
		System.out.println("Enter Name");
		String userName = sc.next();
		System.out.println("Enter Username");
		String userUsername = sc.next();
		System.out.println("Enter Password");
		String userPassword = sc.next();

		Users user = userDao.addUser(new Users(userName, userUsername, userPassword));

		if (user != null) {
			System.out.println("User Created with below Details");
			System.out.println(user);
			return true;
		} else {
			System.out.println("Error while Creating your Account");
			return false;
		}
	}

	public boolean logout(MockHttpSession session) {
		if (userSessionService.deleteCurrentSession(session)) {
			System.out.println("You have been logged out!");
			return true;
		} else {
			System.out.println("Error while deleting the session");
			return false;
		}
	}

}
