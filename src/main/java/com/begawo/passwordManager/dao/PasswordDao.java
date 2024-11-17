package com.begawo.passwordManager.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.begawo.passwordManager.config.HibernateConfig;
import com.begawo.passwordManager.model.Passwords;

public class PasswordDao {

	public Passwords getPasswordByAppName(String appName) {
		Session session = HibernateConfig.getSession();

		HibernateConfig.closeSession(session);
		return new Passwords();
	}

	public List<Passwords> getAllPasswords() {
		Session session = HibernateConfig.getSession();

		HibernateConfig.closeSession(session);
		return new ArrayList<Passwords>();
	}

	public Passwords createPassword(Passwords password) {
		Session session = HibernateConfig.getSession();
		session.save(password);
		HibernateConfig.closeSession(session);
		return new Passwords();
	}

	public Passwords updatePassword(Passwords password) {
		Session session = HibernateConfig.getSession();
		session.update(password);
		HibernateConfig.closeSession(session);
		return new Passwords();
	}

	public boolean deletePassword(String appName, String masterPassword) {
		Session session = HibernateConfig.getSession();

		HibernateConfig.closeSession(session);
		return true;
	}

}
