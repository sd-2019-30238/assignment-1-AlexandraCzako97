package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {
	
	public int searchAdmin(Admin admin) throws SQLException, ClassNotFoundException {
		
		Connection connection = DBconnector.getConnection();
		Statement stm = null;
		ResultSet result = null;
		
		try {
		String query = "SELECT COUNT(username) AS num FROM admins WHERE username="+"'"+admin.getUsername()+"'"+"AND"+" password="+"'"+admin.getPassword()+"'";
		stm=connection.createStatement();
		result=stm.executeQuery(query);
		
		result.next();
		int admNumber=result.getInt("num");
		if(admNumber!=0) {
			System.out.println("User found!");
		}
		return admNumber;
		}
		catch(Exception e){
			System.out.println("Wrong username/password for admin");
		}
		
		return 0;

	}

}
