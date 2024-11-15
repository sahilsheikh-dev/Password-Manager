package com.begawo.passwordManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Passwords {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "password_", nullable = false)
	private int passwordId;
	@Column(name = "site_name", nullable = false)
	private String siteName;
	@Column(name = "site_username", nullable = false)
	private String siteUsername;
	@Column(name = "site_passworrd", nullable = false)
	private String sitePassword;
	@Column(name = "site_email", nullable = false)
	private String siteEmail;
	@Column(name = "site_url", nullable = false)
	private String siteUrl;

	@ManyToOne
	private Users users;

	public Passwords(int passwordId, String siteName, String siteUsername, String sitePassword, String siteEmail,
			String siteUrl, Users users) {
		super();
		this.passwordId = passwordId;
		this.siteName = siteName;
		this.siteUsername = siteUsername;
		this.sitePassword = sitePassword;
		this.siteEmail = siteEmail;
		this.siteUrl = siteUrl;
		this.users = users;
	}

	public Passwords(String siteName, String siteUsername, String sitePassword, String siteEmail, String siteUrl,
			Users users) {
		super();
		this.siteName = siteName;
		this.siteUsername = siteUsername;
		this.sitePassword = sitePassword;
		this.siteEmail = siteEmail;
		this.siteUrl = siteUrl;
		this.users = users;
	}

	public Passwords() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPasswordId() {
		return passwordId;
	}

	public void setPasswordId(int passwordId) {
		this.passwordId = passwordId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteUsername() {
		return siteUsername;
	}

	public void setSiteUsername(String siteUsername) {
		this.siteUsername = siteUsername;
	}

	public String getSitePassword() {
		return sitePassword;
	}

	public void setSitePassword(String sitePassword) {
		this.sitePassword = sitePassword;
	}

	public String getSiteEmail() {
		return siteEmail;
	}

	public void setSiteEmail(String siteEmail) {
		this.siteEmail = siteEmail;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
