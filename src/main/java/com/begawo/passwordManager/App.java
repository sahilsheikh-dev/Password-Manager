package com.begawo.passwordManager;

import java.util.Scanner;

import org.hibernate.Session;

import com.begawo.passwordManager.config.HibernateConfig;

/**
 * Hello world! - OneDrive/Desktop/projects/PasswordManager
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Welcome to Password Manager");

		Scanner sc = new Scanner(System.in);
		int inputCommands = 0;

		Session session = HibernateConfig.getSession();

		while (true) {

			if (inputCommands == -1)
				break;
		}

		HibernateConfig.closeSession(session);
		System.out.println("Thanks for using Password Manager, Good Bye");
		sc.close();
	}

	public static void userOperationsCommandList() {
		System.out.println("Select below Operations Commands for the User");
		System.out.println(" 1 - LogIn");
		System.out.println(" 2 - Create Account");
		System.out.println(" 3 - LogOut");
	}

	public static void passwordOperationsCommandList() {
		System.out.println("Select below Operations Commands for the Password");
		System.out.println(" 1 - Get All Password");
		System.out.println(" 2 - Create Password");
		System.out.println(" 3 - Update Password");
		System.out.println(" 4 - Delete Password");
	}

}
