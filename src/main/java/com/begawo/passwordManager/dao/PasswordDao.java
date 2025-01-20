package com.begawo.passwordManager.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.begawo.passwordManager.config.HibernateConfig;
import com.begawo.passwordManager.model.Passwords;
import com.begawo.passwordManager.model.Users;

public class PasswordDao {

	public Passwords getPasswordByPasswordId(int appId) {
		Session session = HibernateConfig.getSession();
		Passwords password = session.get(Passwords.class, appId);
		HibernateConfig.closeSession(session);
		return password;
	}

	public List<Passwords> getAllPasswords(int userId) {
		Session session = HibernateConfig.getSession();
		List<Passwords> passwords = new ArrayList<>();

		try {
			Query<Passwords> query = session.createQuery("FROM Passwords WHERE users.userId = :userId",
					Passwords.class);
			query.setParameter("userId", userId);

			passwords = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateConfig.closeSession(session);
		}

		return passwords;
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
		boolean isDeleted = false;

		Users user = password.getUsers();
		if (user != null && user.getUserPassword().equals(masterPassword)) {
			session.delete(password);
			isDeleted = true;
		} else {
			System.out.println("Incorrect Master Password");
		}

		HibernateConfig.closeSession(session);
		return isDeleted;
	}

}
