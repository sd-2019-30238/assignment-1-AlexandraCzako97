package CQRS.ReadModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindUser {
	private static PreparedStatement pr = null;
       public boolean searchUser(String username, String password) throws SQLException, ClassNotFoundException {
		
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
		pr =  (PreparedStatement) cnx.prepareStatement("SELECT COUNT(username) AS num FROM users WHERE username="+"'"+username+"'"+"AND"+" password="+"'"+password+"'");
		ResultSet rs = pr.executeQuery();
		
		rs.next();
		int usersNumber=rs.getInt("num");
		System.out.println(username);
		if(usersNumber==1) {
			System.out.println("User found!");
			return true;
		}else if(usersNumber==0) {
			System.out.println("User not found!");
		}
		
		return false;

	}
       
       public boolean searchAdmin(String username, String password) throws SQLException, ClassNotFoundException {
   		
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
		pr =  (PreparedStatement) cnx.prepareStatement("SELECT COUNT(username) AS num FROM admins WHERE username="+"'"+username+"'"+"AND"+" password="+"'"+password+"'");
		ResultSet rs = pr.executeQuery();
		
		rs.next();
		int usersNumber=rs.getInt("num");
		System.out.println(username);
		if(usersNumber==1) {
			System.out.println("Admin found!");
			return true;
		}else if(usersNumber==0) {
			System.out.println("Admin not found!");
		}
		
		return false;

	}
       
       

}
