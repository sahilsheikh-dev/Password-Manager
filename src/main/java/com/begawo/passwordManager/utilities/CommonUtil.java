package com.begawo.passwordManager.utilities;

import java.util.Scanner;

public class CommonUtil {

	private static final Scanner scanner = new Scanner(System.in);

	// Get user input with validation
	public static String getValidatedInput(String message) {
		String input;
		do {
			System.out.println(message);
			input = scanner.nextLine().trim();
			if (input.isEmpty()) {
				System.out.println("Input cannot be empty! Please enter again.");
			}
		} while (input.isEmpty());
		return input;
	}

	// Get integer input with validation
	public static int getValidatedIntInput(String message) {
		int input;
		while (true) {
			try {
				System.out.println(message);
				input = Integer.parseInt(scanner.nextLine().trim());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter a valid number.");
			}
		}
		return input;
	}

	// Validate if a string is empty or null
	public static boolean isEmpty(String s) {
		return s == null || s.trim().isEmpty() || ("".equals(s)) || ("null".equals(s));
	}

	// Close scanner
	public static void closeScanner() {
		scanner.close();
	}
}
