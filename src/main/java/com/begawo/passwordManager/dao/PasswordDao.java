package com.begawo.passwordManager.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.begawo.passwordManager.config.HibernateConfig;
import com.begawo.passwordManager.model.Passwords;

public class PasswordDao {

	public Passwords getPasswordByPasswordId(int appId) {
		Session session = HibernateConfig.getSession();
		Passwords password = session.get(Passwords.class, appId);
		HibernateConfig.closeSession(session);
		return password;
	}

	public List<Passwords> getAllPasswords() {
		Session session = HibernateConfig.getSession();

		// write HQL query to get all passwords from database

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

	public boolean deletePassword(Passwords password, String masterPassword) {
		Session session = HibernateConfig.getSession();

		HibernateConfig.closeSession(session);
		return true;
	}

}
