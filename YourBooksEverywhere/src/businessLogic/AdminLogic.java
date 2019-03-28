package businessLogic;

import java.sql.SQLException;

import dao.Admin;
import dao.AdminDao;
import dao.User;
import dao.UserDao;

public class AdminLogic {
	
	public int validateAdmin(String username, String password) throws ClassNotFoundException, SQLException {
		Admin admin= new Admin();
		
		admin.setUsername(username);
		admin.setPassword(password);
		
				
		if(username.length()==0 || password.length()==0) {
			return 0;
		}
		
		AdminDao admDao= new AdminDao();
		int admNumber=admDao.searchAdmin(admin);
		if(admNumber==0) {
			return 0;
		}
		
		
		return 1;
		
	}

}
