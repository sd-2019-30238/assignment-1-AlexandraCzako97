package main;

import java.sql.SQLException;
import presentation.LoginPage;
import dao.DBconnector;
import dao.User;
import dao.UserDao;

public class Main {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		DBconnector.getConnection();
		
		/*User user= new User("aleCz","aaa123");
		User user2= new User(5,"cristiCr","ccc123","yearly");
		UserDao usr= new UserDao();
		usr.searchUser(user);
		*/
		
	}

}
