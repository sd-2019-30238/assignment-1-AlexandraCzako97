package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import model.User;

public class UserDao {
	protected static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
	
	public boolean searchUser(String username, String password) throws SQLException, ClassNotFoundException {
		
		Connection connection = DBconnector.getConnection();
		Statement stm = null;
		ResultSet result = null;
		
		try {
		String query = "SELECT COUNT(username) AS num FROM users WHERE username="+"'"+username+"'"+"AND"+" password="+"'"+password+"'";
		stm=connection.createStatement();
		result=stm.executeQuery(query);
		
		result.next();
		int usersNumber=result.getInt("num");
		System.out.println(username);
		if(usersNumber==1) {
			System.out.println("User found!");
			return true;
		}
		
		}
		catch(Exception e){
			System.out.println("Wrong username/password");
		}
		
		return false;

	}
	
	
	
}
