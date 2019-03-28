package businessLogic;

import java.sql.SQLException;

import dao.User;
import dao.UserDao;

public class UserLogic {
	

	public int validateUserLogin(String username, String password) throws ClassNotFoundException, SQLException {
		User usr= new User();
		
		usr.setUsername(username);
		usr.setPassword(password);
		
				
		if(username.length()==0 || password.length()==0) {
			return 0;
		}
		
		UserDao usrDao= new UserDao();
		int usersNumber=usrDao.searchUser(usr);
		
		if(usersNumber==0) {
			return 0;
		}
		return 1;
	}
	
	public int validateUserRegister(String username, String password) throws ClassNotFoundException, SQLException {
		User usr= new User();
		
		usr.setUsername(username);
		
		if(username.length()==0) {
			return 0;
		}
		
		UserDao usrDao= new UserDao();
		int usersNumber=usrDao.searchUser(usr);
		
		if(usersNumber>0) {
			return 0;
		}
		return 1;
	}
	
	
	public int addNewUser(String username, String password, String payment_plan) throws ClassNotFoundException, SQLException {
		
		UserDao usrDao= new UserDao();
		User usr= new User();
		
		usr.setUsername(username);
		usr.setPassword(password);
		usr.setPayment_plan(payment_plan);
		if(validateUserRegister(username,password)==1) {
			usrDao.insertUser(usr);
			System.out.println("user added");
			return 1;
		}
		
		return 0;
	}
	
	
}
	


