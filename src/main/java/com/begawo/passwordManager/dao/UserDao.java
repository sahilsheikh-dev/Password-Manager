package com.begawo.passwordManager.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.begawo.passwordManager.config.HibernateConfig;
import com.begawo.passwordManager.model.Users;

public class UserDao {

	public Users getUserByUsernamePassword(String username, String password) {
		Session session = HibernateConfig.getSession();
		Users user = null;

		try {
			Query<Users> query = session.createQuery(
					"FROM Users WHERE user_username = :username AND user_password = :password", Users.class);
			query.setParameter("username", username);
			query.setParameter("password", password);

			user = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateConfig.closeSession(session);
		}

		return user;
	}

	public Users addUser(Users user) {
		Session session = HibernateConfig.getSession();
		session.save(user);
		HibernateConfig.closeSession(session);
		return user;
	}

}
