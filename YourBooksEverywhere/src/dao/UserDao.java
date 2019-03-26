package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import model.User;

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
}
