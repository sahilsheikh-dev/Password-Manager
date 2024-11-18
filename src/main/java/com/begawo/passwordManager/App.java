package com.begawo.passwordManager;

import java.util.Scanner;

import com.begawo.passwordManager.controller.PasswordController;
import com.begawo.passwordManager.controller.UserController;

/**
 * Hello world! - OneDrive/Desktop/projects/PasswordManager
 *
 */
public class App {

	static boolean userState = false;
	static UserController userController = new UserController();
	static PasswordController passwordController = new PasswordController();

	public static void main(String[] args) {
		System.out.println("Welcome to Password Manager");
		userState = userOperationsCommandList();

		// write a logic to get session status and continue the while loop to avoid the
		// unnecessary loop break
		while (userState) {
			userState = passwordOperationsCommandList();
			if (!userState) {
				userController.logout();
				System.out.println("Something went wrong, User Logged Out.");
			}
		}

		System.out.println("Thanks for using Password Manager, Good Bye");
	}

	public static boolean userOperationsCommandList() {
		System.out.println("Select below Operations Commands for the User");
		System.out.println(" 1 - LogIn");
		System.out.println(" 2 - Create Account");
		if (userState)
			System.out.println(" 3 - LogOut");

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
		if (userState)
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
