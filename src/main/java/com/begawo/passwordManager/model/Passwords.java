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
	@Column(name = "site_url", nullable = true)
	private String siteUrl;
	@Column(name = "site_email", nullable = true)
	private String siteEmail;
	@Column(name = "site_username", nullable = true)
	private String siteUsername;
	@Column(name = "site_passworrd", nullable = false)
	private String sitePassword;

	@ManyToOne
	private Users users;

	public Passwords(int passwordId, String siteName, String siteUrl, String siteEmail, String siteUsername,
			String sitePassword, Users users) {
		super();
		this.passwordId = passwordId;
		this.siteName = siteName;
		this.siteUrl = siteUrl;
		this.siteEmail = siteEmail;
		this.siteUsername = siteUsername;
		this.sitePassword = sitePassword;
		this.users = users;
	}

	public Passwords(int passwordId, String siteName, String siteUrl, String siteEmail, String siteUsername,
			String sitePassword) {
		super();
		this.passwordId = passwordId;
		this.siteName = siteName;
		this.siteUrl = siteUrl;
		this.siteEmail = siteEmail;
		this.siteUsername = siteUsername;
		this.sitePassword = sitePassword;
	}

	public Passwords(String siteName, String siteUrl, String siteEmail, String siteUsername, String sitePassword,
			Users users) {
		super();
		this.siteName = siteName;
		this.siteUrl = siteUrl;
		this.siteEmail = siteEmail;
		this.siteUsername = siteUsername;
		this.sitePassword = sitePassword;
		this.users = users;
	}

	public Passwords(String siteName, String siteUrl, String siteEmail, String siteUsername, String sitePassword) {
		super();
		this.siteName = siteName;
		this.siteUrl = siteUrl;
		this.siteEmail = siteEmail;
		this.siteUsername = siteUsername;
		this.sitePassword = sitePassword;
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

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getSiteEmail() {
		return siteEmail;
	}

	public void setSiteEmail(String siteEmail) {
		this.siteEmail = siteEmail;
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String toString() {
		return "Site Name - " + siteName + "\nSite Email - " + siteEmail + "\nSite Username - " + siteUsername
				+ "\nSite Password - " + sitePassword;
	}

}
