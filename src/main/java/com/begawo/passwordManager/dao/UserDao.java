package com.begawo.passwordManager.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.begawo.passwordManager.config.HibernateConfig;
import com.begawo.passwordManager.model.Users;
import com.begawo.passwordManager.utilities.SHA256EncryptionUtil;

public class UserDao {

	public Users getUserByUsernamePassword(String username, String password) {
		Session session = HibernateConfig.getSession();
		try {
			Query<Users> query = session.createQuery("FROM Users WHERE user_username = :username", Users.class);
			query.setParameter("username", username);
			Users user = query.uniqueResult();

			if (user != null) {
				String hashedInputPassword = SHA256EncryptionUtil.sha256Encrypt(password, user.getUserSalt());
				if (hashedInputPassword.equals(user.getUserPassword()))
					return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateConfig.closeSession(session);
		}
		return null;
	}

	public boolean isUsernameExists(String username) {
		Session session = HibernateConfig.getSession();
		try {
			Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Users WHERE userUsername = :username",
					Long.class);
			query.setParameter("username", username);
			Long count = query.uniqueResult();
			return count != null && count > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateConfig.closeSession(session);
		}
		return false;
	}

	public Users addUser(Users user) {
		Session session = HibernateConfig.getSession();
		session.save(user);
		HibernateConfig.closeSession(session);
		return user;
	}

}
