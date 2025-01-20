package com.begawo.passwordManager.services;

import com.begawo.passwordManager.mockHttpSession.MockHttpSession;
import com.begawo.passwordManager.model.Users;

public class UserSessionServices {

	public Users getCurrentSession(MockHttpSession session) {
		return (Users) session.getAttribute("currentUser");
	}

	public Users addCurrentSession(MockHttpSession session, Users user) {
		session.setAttribute("currentUser", user);
		return user;
	}

	public boolean deleteCurrentSession(MockHttpSession session) {
		if (session.getAttribute("currentUser") != null) {
			session.removeAttribute("currentUser");
			return true;
		} else {
			System.out.println("No user is currently logged in.");
			return false;
		}
	}

}
