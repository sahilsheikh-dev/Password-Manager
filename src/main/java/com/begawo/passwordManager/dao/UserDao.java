package com.begawo.passwordManager.dao;

import org.hibernate.Session;

import com.begawo.passwordManager.config.HibernateConfig;
import com.begawo.passwordManager.model.Users;

public class UserDao {

	public Users getUserByUsernamePassword(String username, String password) {
		Session session = HibernateConfig.getSession();

		// write HQL query to get the user with username and password

		HibernateConfig.closeSession(session);
		return new Users();
	}

	public Users addUser(Users user) {
		Session session = HibernateConfig.getSession();
		session.save(user);
		HibernateConfig.closeSession(session);
		return user;
	}

}
