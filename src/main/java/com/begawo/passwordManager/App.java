package com.begawo.passwordManager;

import java.util.Scanner;

import com.begawo.passwordManager.controller.PasswordController;
import com.begawo.passwordManager.controller.UserController;
import com.begawo.passwordManager.services.UserSessionServices;

/**
 * Hello world! - OneDrive/Desktop/projects/PasswordManager
 *
 */
public class App {

	static UserController userController = new UserController();
	static PasswordController passwordController = new PasswordController();
	static UserSessionServices userSessionService = new UserSessionServices();

	public static void main(String[] args) {
		System.out.println("Welcome to Password Manager");
		userOperationsCommandList();

		while (userSessionService.getCurrentSession() != null) {
			passwordOperationsCommandList();

			if (userSessionService.getCurrentSession() == null) {
				System.out.println("User Logged Out.");
				break;
			}
		}

		System.out.println("Thanks for using Password Manager, Good Bye");
	}

	public static boolean userOperationsCommandList() {
		System.out.println("Select below Operations Commands for the User");
		System.out.println(" 1 - LogIn");
		System.out.println(" 2 - Create Account");

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();

		switch (input) {
		case 1:
			return userController.login();
		case 2:
			return userController.register();
		case 3:
			return userController.logout();
		default:
			System.out.println("Invalid Input");
			return userController.logout();
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

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();

		switch (input) {
		case 1:
			return passwordController.getAllPasswords();
		case 2:
			return passwordController.getPassword();
		case 3:
			return passwordController.createPassword();
		case 4:
			return passwordController.updatePassword();
		case 5:
			return passwordController.deletePassword();
		case 6:
			return userController.logout();
		default:
			System.out.println("Invalid Input");
			return userController.logout();
		}
	}

}
