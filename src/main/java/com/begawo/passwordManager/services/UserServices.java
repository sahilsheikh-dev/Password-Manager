package com.begawo.passwordManager.services;

import java.util.Scanner;

import com.begawo.passwordManager.dao.UserDao;
import com.begawo.passwordManager.model.Users;

public class UserServices {

	UserDao userDao = new UserDao();

	public boolean login() {
		System.out.println("Please login to continue...");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		sc.close();

		if (userDao.getUserByUsernamePassword(username, password) != null) {
			System.out.println("LoggedIn Successfully");
			return true;
		} else {
			System.out.println("LoggedIn Failed");
			return false;
		}
	}

	public boolean register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String userName = sc.next();
		System.out.println("Enter Username");
		String userUsername = sc.next();
		System.out.println("Enter Password");
		String userPassword = sc.next();
		sc.close();

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

	public boolean logout() {
		System.out.println("You have been logged out!");
		return false;
	}

}
