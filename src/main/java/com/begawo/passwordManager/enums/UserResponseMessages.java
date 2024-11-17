package com.begawo.passwordManager.enums;

public enum UserResponseMessages {

	LOGIN_SUCCESS("Logged In Succesfully, Please Continue"),
	LOGOUT_SUCCESS("Logged Out Succesfully"),
	LOGIN_PASSWORD("Incorrect Password"),
	USER_ALREADY_AVAILABLE("User Already Available"),
	USER_NOT_FOUND("User Not Found"),
	BLOCKED_ACCOUNT("Your account is blocked because of multiple invalid attempts"),
	USER_ADDED("User Added Successfully!"),
	USER_MOVED_TO_RECYCLEBIN("User Moved to Recycle Bin"),
	USER_RESTORED("User Restored"),
	USER_UPDATED("User Updated Successfully!"),
	USER_DELETED("User Deleted Successfully!"),
	OPERATION_FAILED("Operation Failed");

	private String authResponsseMessage;

	private UserResponseMessages(String authResponsseMessage) {
		this.authResponsseMessage = authResponsseMessage;
	}

	public String getAuthResponseMessage() {
		return this.authResponsseMessage;
	}

	public void setAuthResponseMessage(String authResponseMessage) {
		this.authResponsseMessage = authResponseMessage;
	}

}
