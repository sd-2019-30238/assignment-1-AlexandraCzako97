package businessLogic;

import java.sql.SQLException;

import dao.User;
import dao.UserDao;

public class UserLogic {
	
	public int validateUser(String username, String password) throws ClassNotFoundException, SQLException {
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

}
