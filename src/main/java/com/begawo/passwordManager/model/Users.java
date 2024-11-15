package com.begawo.passwordManager.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private int userId;
	@Column(name = "user_name", nullable = false)
	private String userName;
	@Column(name = "user_username", nullable = false)
	private String userUsername;
	@Column(name = "user_password", nullable = false)
	private String userPassword;

	@OneToMany(mappedBy = "user")
	private List<Passwords> passwords;

	public Users(int userId, String userName, String userUsername, String userPassword, List<Passwords> passwords) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.passwords = passwords;
	}

	public Users(String userName, String userUsername, String userPassword, List<Passwords> passwords) {
		super();
		this.userName = userName;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.passwords = passwords;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Passwords> getPasswords() {
		return passwords;
	}

	public void setPasswords(List<Passwords> passwords) {
		this.passwords = passwords;
	}

}
