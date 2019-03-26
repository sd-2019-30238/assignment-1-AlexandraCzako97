package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class UserDao {
	protected static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
	
    public static void insertUser(User usr ) throws SQLException, ClassNotFoundException {
		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm = (PreparedStatement) connection.prepareStatement("INSERT INTO  users (idusers,username,password,payment_plan) "
				+ "VALUES ('"+ usr.getUserId()+ "','" + usr.getUsername() + "','" + usr.getPassword() + "','"+ usr.getPayment_plan() +  "')");
		stm.executeUpdate();
		
		System.out.println("Row inserted!");	
	}
	
	public static void deleteUser(User usr ) throws SQLException, ClassNotFoundException {
		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm = (PreparedStatement) connection.prepareStatement("DELETE FROM users WHERE idusers= "+"'"+usr.getUserId()+"'");
		stm.executeUpdate();
				
		System.out.println("Row deleted!");		
	}
	
	public static void updateUser(User usr ) throws SQLException, ClassNotFoundException {
		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm = (PreparedStatement) connection.prepareStatement("UPDATE users SET username= "+"'"+usr.getUsername()+"'"+","
		        +" password="+"'"+usr.getPassword()+"'"+","+" payment_plan= "+"'"+usr.getPayment_plan()+"'"+" WHERE idusers= "+"'"+ usr.getUserId()+"'");
		stm.executeUpdate();
	
		System.out.println("Row updated!");
				
	}
	public int searchUser(User usr) throws SQLException, ClassNotFoundException {
		
		Connection connection = DBconnector.getConnection();
		Statement stm = null;
		ResultSet result = null;
		
		try {
		String query = "SELECT COUNT(username) AS num FROM users WHERE username="+"'"+usr.getUsername()+"'"+"AND"+" password="+"'"+usr.getPassword()+"'";
		stm=connection.createStatement();
		result=stm.executeQuery(query);
		
		result.next();
		int usersNumber=result.getInt("num");
		if(usersNumber!=0) {
			System.out.println("User found!");
		}
		return usersNumber;
		}
		catch(Exception e){
			System.out.println("Wrong username/password");
		}
		
		return 0;

	}
	
	
}
