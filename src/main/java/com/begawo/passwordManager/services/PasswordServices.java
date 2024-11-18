package com.begawo.passwordManager.services;

import java.util.List;
import java.util.Scanner;

import com.begawo.passwordManager.dao.PasswordDao;
import com.begawo.passwordManager.model.Passwords;
import com.begawo.passwordManager.utilities.Utilities;

public class PasswordServices {

	PasswordDao passwordDao = new PasswordDao();

	public boolean getPassword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter App Number from Below App List (Enter number from 1 to N)");
		List<Passwords> passwords = passwordDao.getAllPasswords();
		for (Passwords password : passwords) {
			if (!Utilities.isEmpty(password.getSiteName())
					&& !Utilities.isEmpty(Integer.toString(password.getPasswordId())))
				System.out.println(password.getPasswordId() + ". " + password.getSiteName());
		}

		System.out.println("Enter App Number from the above list from 1 to N to Get the Password");
		int appId = sc.nextInt();

		sc.close();
		Passwords password = passwordDao.getPasswordByPasswordId(appId);
		if (password != null) {
			System.out.println("Below is the App Password");
			System.out.println(password);
			return true;
		} else {
			System.out.println("App Not Found or Error while getting the app name");
			return false;
		}
	}

	public boolean getAllPasswords() {
		List<Passwords> passwords = passwordDao.getAllPasswords();

		if (passwords.size() != 0) {
			System.out.println("Below are the password details");
			for (Passwords password : passwords) {
				if (password != null) {
					System.out.println("--------------------------------");
					System.out.println(password);
					System.out.println("--------------------------------");
				}
			}
			return true;
		} else {
			System.out.println("No Password found, please login again and add a new Password");
			return false;
		}
	}

	public boolean createPassword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Password Details");
		System.out.println("Enter Site/App Name");
		String siteName = sc.next();
		System.out.println("Enter Site/App Email");
		String siteEmail = sc.next();
		System.out.println("Enter Site/App Username");
		String siteUsername = sc.next();
		System.out.println("Enter Site/App Password");
		String sitePassword = sc.next();

		// get current user details from session

		Passwords password = passwordDao
				.createPassword(new Passwords(siteName, siteUsername, siteEmail, siteUsername, sitePassword));
		sc.close();

		if (password != null) {
			System.out.println("Your Password has been added to the database");
			return true;
		} else {
			System.out.println("Error while adding your password");
			return false;
		}
	}

	public boolean updatePassword() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter App Number from Below App List to Update (Enter number from 1 to N)");
		List<Passwords> passwords = passwordDao.getAllPasswords();
		for (Passwords password : passwords) {
			if (!Utilities.isEmpty(password.getSiteName())
					&& !Utilities.isEmpty(Integer.toString(password.getPasswordId())))
				System.out.println(password.getPasswordId() + ". " + password.getSiteName());
		}

		System.out.println("Enter App Number from the above list from 1 to N to Update the Password");
		int appId = sc.nextInt();

		System.out.println("Enter the Password Details");
		System.out.println("Enter Site/App Name");
		String siteName = sc.next();
		siteName = sc.next();
		System.out.println("Enter Site/App Email");
		String siteEmail = sc.next();
		System.out.println("Enter Site/App Username");
		String siteUsername = sc.next();
		System.out.println("Enter Site/App Password");
		String sitePassword = sc.next();

		// get current user details from session

		Passwords password = passwordDao
				.updatePassword(new Passwords(appId, siteName, siteUsername, siteEmail, siteUsername, sitePassword));
		sc.close();

		if (password != null) {
			System.out.println("Your Password has been updated to the database");
			return true;
		} else {
			System.out.println("Error while adding your password");
			return false;
		}
	}

	public boolean deletePassword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter App Number from Below App List (Enter number from 1 to N)");
		List<Passwords> passwords = passwordDao.getAllPasswords();
		for (Passwords password : passwords) {
			if (!Utilities.isEmpty(password.getSiteName())
					&& !Utilities.isEmpty(Integer.toString(password.getPasswordId())))
				System.out.println(password.getPasswordId() + ". " + password.getSiteName());
		}

		System.out.println("Enter App Number from the above list from 1 to N to Delete the Password");
		int appId = sc.nextInt();
		String masterPassword = sc.next();
		System.out.println("Enter your account password to delete the password");
		masterPassword = sc.next();
		sc.close();

		// write a logic to check masterPassword with the password from user stored in
		// the session and continue if both are same

		Passwords password = passwordDao.getPasswordByPasswordId(appId);
		if (password != null) {
			boolean deletedStatus = passwordDao.deletePassword(password, masterPassword);
			if (deletedStatus) {
				System.out.println("Password Deleted");
				return true;
			} else {
				System.out.println("Error while deleting the password");
				return false;
			}
		} else {
			System.out.println("App Not Found or Error while getting the app name");
			return false;
		}
	}

}
