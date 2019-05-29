package model;

import javax.servlet.http.HttpSession;

public class Util {
	public static User getLoggedUser(HttpSession session) {
		User logged = (User) session.getAttribute("loggedUser");
		return logged;
	}
}
