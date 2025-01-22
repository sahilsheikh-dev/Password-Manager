package com.begawo.passwordManager.services;

import java.util.List;
import java.util.Scanner;

import com.begawo.passwordManager.dao.PasswordDao;
import com.begawo.passwordManager.mockHttpSession.MockHttpSession;
import com.begawo.passwordManager.model.Passwords;
import com.begawo.passwordManager.model.Users;
import com.begawo.passwordManager.utilities.AESUtil;
import com.begawo.passwordManager.utilities.SHA256EncryptionUtil;
import com.begawo.passwordManager.utilities.Utilities;

public class PasswordServices {

	PasswordDao passwordDao = new PasswordDao();
	UserSessionServices userSessionService = new UserSessionServices();
	Scanner sc = new Scanner(System.in);

	public boolean getPassword(MockHttpSession session) {
		Users currentUser = userSessionService.getCurrentSession(session);
		if (currentUser != null) {
			System.out.println("Enter App Number from Below App List (Enter number from 1 to N)");
			List<Passwords> passwords = passwordDao.getAllPasswords(currentUser.getUserId());

			if (passwords.size() <= 0) {
				System.out.println("No Password found, please add a new Password");
				return true;
			} else {
				for (Passwords password : passwords) {
					if (!Utilities.isEmpty(password.getSiteName())
							&& !Utilities.isEmpty(Integer.toString(password.getPasswordId())))
						System.out.println(password.getPasswordId() + ". " + password.getSiteName());
				}

				System.out.println("Enter App Number from the above list from 1 to N to Get the Password");
				int appId = sc.nextInt();

				Passwords password = passwordDao.getPasswordByPasswordId(appId);
				if (password != null) {
					// Decrypt password using user's login password as the key
					String decryptedPassword = AESUtil.decrypt(password.getSitePassword(),
							currentUser.getUserPassword());

					System.out.println("Below is the Current App Password Details");
					System.out.println(password);
					System.out.println("Password: " + decryptedPassword + "\n--------------------------------");
					return true;
				} else {
					System.out.println("App Not Found or Error while getting the app name");
					return false;
				}
			}
		} else {
			System.out.println("Please login to continue");
			return false;
		}
	}

	public boolean getAllPasswords(MockHttpSession session) {
		Users currentUser = userSessionService.getCurrentSession(session);
		if (currentUser != null) {
			List<Passwords> passwords = passwordDao.getAllPasswords(currentUser.getUserId());

			if (passwords.size() != 0) {
				System.out.println("Below are the password details");
				for (Passwords password : passwords) {
					if (password != null) {
						// Decrypt password using user's login password as the key
						String decryptedPassword = AESUtil.decrypt(password.getSitePassword(),
								currentUser.getUserPassword());
						System.out.println(password);
						System.out.println("Password: " + decryptedPassword + "\n--------------------------------");
					}
				}
				return true;
			} else {
				System.out.println("No Password found, please add a new Password");
				return true;
			}
		} else {
			System.out.println("Please login to continue");
			return false;
		}
	}

	public boolean createPassword(MockHttpSession session) {
		Users currentUser = userSessionService.getCurrentSession(session);
		if (currentUser != null) {
			System.out.println("Enter the Password Details");
			System.out.println("Enter Site/App Name");
			String siteName = sc.next();
			System.out.println("Enter Site/App Email");
			String siteEmail = sc.next();
			System.out.println("Enter Site/App Username");
			String siteUsername = sc.next();
			System.out.println("Enter Site/App Password");
			String sitePassword = sc.next();

			// Encrypt password using the user's login password as the key
			String encryptedPassword = AESUtil.encrypt(sitePassword, currentUser.getUserPassword());

			Passwords password = passwordDao.createPassword(
					new Passwords(siteName, siteUsername, siteEmail, siteUsername, encryptedPassword, currentUser));

			if (password != null) {
				System.out.println("Your Password has been added to the database");
				return true;
			} else {
				System.out.println("Error while adding your password");
				return false;
			}
		} else {
			System.out.println("Please login to continue");
			return false;
		}
	}

	public boolean updatePassword(MockHttpSession session) {
		Users currentUser = userSessionService.getCurrentSession(session);
		if (currentUser != null) {

			System.out.println("Enter App Number from Below App List to Update (Enter number from 1 to N)");
			List<Passwords> passwords = passwordDao.getAllPasswords(currentUser.getUserId());
			for (Passwords password : passwords) {
				if (!Utilities.isEmpty(password.getSiteName())
						&& !Utilities.isEmpty(Integer.toString(password.getPasswordId())))
					System.out.println(password.getPasswordId() + ". " + password.getSiteName());
			}

			System.out.println("Enter App Number from the above list from 1 to N to Update the Password");
			int appId = sc.nextInt();

			Passwords password = passwordDao.getPasswordByPasswordId(appId);
			// Decrypt password using user's login password as the key
			String decryptedPassword = AESUtil.decrypt(password.getSitePassword(), currentUser.getUserPassword());
			System.out.println("Current Password Details");
			System.out.println(password);
			System.out.println("Password: " + decryptedPassword + "\n--------------------------------");

			System.out.println("Enter the Password Details");
			System.out.println("Enter Site/App Name");
			String siteName = sc.next();
			System.out.println("Enter Site/App Email");
			String siteEmail = sc.next();
			System.out.println("Enter Site/App Username");
			String siteUsername = sc.next();
			System.out.println("Enter Site/App Password");
			String sitePassword = sc.next();

			// Encrypt password using the user's login password as the key
			String encryptedPassword = AESUtil.encrypt(sitePassword, currentUser.getUserPassword());

			Passwords updatePassword = passwordDao.updatePassword(new Passwords(appId, siteName, siteUsername,
					siteEmail, siteUsername, encryptedPassword, currentUser));

			if (updatePassword != null) {
				System.out.println("Your Password has been updated to the database");
				return true;
			} else {
				System.out.println("Error while updating your password");
				return false;
			}
		} else {
			System.out.println("Please login to continue");
			return false;
		}
	}

	public boolean deletePassword(MockHttpSession session) {
		Users currentUser = userSessionService.getCurrentSession(session);
		if (currentUser != null) {
			System.out.println("Enter App Number from Below App List (Enter number from 1 to N)");
			List<Passwords> passwords = passwordDao.getAllPasswords(currentUser.getUserId());
			for (Passwords password : passwords) {
				if (!Utilities.isEmpty(password.getSiteName())
						&& !Utilities.isEmpty(Integer.toString(password.getPasswordId())))
					System.out.println(password.getPasswordId() + ". " + password.getSiteName());
			}

			System.out.println("Enter App Number from the above list from 1 to N to Delete the Password");
			int appId = sc.nextInt();
			System.out.println("Enter your account password to delete the password");
			String masterPassword = sc.next();

			if (currentUser != null && currentUser.getUserPassword()
					.equals(SHA256EncryptionUtil.sha256Encrypt(masterPassword, currentUser.getUserSalt()))) {
				Passwords password = passwordDao.getPasswordByPasswordId(appId);
				if (password != null) {
					boolean deletedStatus = passwordDao.deletePassword(password);
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
			} else {
				System.out.println("Invalid Master Password");
				return false;
			}

		} else {
			System.out.println("Please login to continue");
			return false;
		}
	}

}
