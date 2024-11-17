package com.begawo.passwordManager.enums;

public enum PasswordResponseMessages {

	PASSWORD_SAVED("Your Password Saved"), PASSWORD_DELETED("Your Password Deleted"),
	PASSWORD_UPDATED("Your Password Updated");

	private String passwordResponseMessages;

	private PasswordResponseMessages(String passwordResponseMessages) {
		this.passwordResponseMessages = passwordResponseMessages;
	}

	public String getPasswordResponseMessage() {
		return this.passwordResponseMessages;
	}

	public void setPasswordResponseMessage(String passwordResponseMessages) {
		this.passwordResponseMessages = passwordResponseMessages;
	}

}
