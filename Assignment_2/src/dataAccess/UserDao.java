package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;


public class UserDao {
	protected static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
	private PreparedStatement pr = null;
	
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
	
	 public void insertUser(String username, String password, String payment_plan ) throws SQLException, ClassNotFoundException {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
	    pr =  (PreparedStatement) cnx.prepareStatement("insert into users(username,password,payment_plan,validated_payment) values (?,?,?,null)");
				
		pr.setString(1,username);
		pr.setString(2,password );
		pr.setString(3,payment_plan );
				   
		pr.executeUpdate();
		System.out.println("user inserted");
		pr.close();
	 }
					   
			 
				   
				   
	
}
