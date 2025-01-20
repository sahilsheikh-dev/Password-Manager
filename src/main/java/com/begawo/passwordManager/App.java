package com.begawo.passwordManager;

import java.util.Scanner;
import com.begawo.passwordManager.controller.PasswordController;
import com.begawo.passwordManager.controller.UserController;
import com.begawo.passwordManager.mockHttpSession.MockHttpSession;
import com.begawo.passwordManager.services.UserSessionServices;

/**
 * Hello world! - OneDrive/Desktop/projects/PasswordManager
 *
 */
public class App {

	static UserController userController = new UserController();
	static PasswordController passwordController = new PasswordController();
	static UserSessionServices userSessionService = new UserSessionServices();
	static MockHttpSession session = new MockHttpSession();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Password Manager");

		userOperationsCommandList();

		while (userSessionService.getCurrentSession(session) != null) {
			passwordOperationsCommandList();

			if (userSessionService.getCurrentSession(session) == null) {
				System.out.println("User Seems to be Logged Out. Please Login to Continue");
				break;
			}
		}

		System.out.println("Thanks for using Password Manager, Please Login to Continue");
	}

	public static boolean userOperationsCommandList() {
		System.out.println("Select below Operations Commands for the User");
		System.out.println(" 1 - LogIn");
		System.out.println(" 2 - Create Account");

		int input = sc.nextInt();

		switch (input) {
		case 1:
			return userController.login(session);
		case 2:
			return userController.register();
		case 3:
			return userController.logout(session);
		default:
			System.out.println("Invalid Input");
			return userController.logout(session);
		}
	}

	public static boolean passwordOperationsCommandList() {
		System.out.println("Select below Operations Commands for the Password");
		System.out.println(" 1 - Get All Password");
		System.out.println(" 2 - Get Password by App Name");
		System.out.println(" 3 - Create Password");
		System.out.println(" 4 - Update Password");
		System.out.println(" 5 - Delete Password");
		System.out.println(" 6 - LogOut");

		int input = sc.nextInt();

		switch (input) {
		case 1:
			return passwordController.getAllPasswords(session);
		case 2:
			return passwordController.getPassword(session);
		case 3:
			return passwordController.createPassword(session);
		case 4:
			return passwordController.updatePassword(session);
		case 5:
			return passwordController.deletePassword(session);
		case 6:
			return userController.logout(session);
		default:
			System.out.println("Invalid Input");
			return userController.logout(session);
		}
	}

}
