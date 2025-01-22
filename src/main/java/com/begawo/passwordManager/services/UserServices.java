package com.begawo.passwordManager.services;

import com.begawo.passwordManager.dao.UserDao;
import com.begawo.passwordManager.mockHttpSession.MockHttpSession;
import com.begawo.passwordManager.model.Users;
import com.begawo.passwordManager.utilities.CommonUtil;
import com.begawo.passwordManager.utilities.SHA256EncryptionUtil;

public class UserServices {

	UserDao userDao = new UserDao();
	UserSessionServices userSessionService = new UserSessionServices();

	public boolean login(MockHttpSession session) {
		try {
			System.out.println("Please login to continue...");
			String username = CommonUtil.getValidatedInput("Enter Username:");
			String password = CommonUtil.getValidatedInput("Enter Password:");

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
		} catch (Exception e) {
			System.out.println("Error occurred due to invalid input. Please try again.");
			return false;
		}
	}

	public boolean register() {
		try {
			String userName = CommonUtil.getValidatedInput("Enter Name:");

			String userUsername;
			while (true) {
				userUsername = CommonUtil.getValidatedInput("Enter Username:");

				if (userDao.isUsernameExists(userUsername))
					System.out.println("Username already exists! Please choose a different username.");
				else
					break;
			}

			String userPassword = CommonUtil.getValidatedInput("Enter Password:");

			String salt = SHA256EncryptionUtil.generateSalt();
			String hashedPassword = SHA256EncryptionUtil.sha256Encrypt(userPassword, salt);

			Users user = userDao.addUser(new Users(userName, userUsername, hashedPassword, salt));

			if (user != null) {
				System.out.println("User Created with below Details");
				System.out.println(user);
				return true;
			} else {
				System.out.println("Error while Creating your Account");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error occurred due to invalid input. Please try again.");
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
