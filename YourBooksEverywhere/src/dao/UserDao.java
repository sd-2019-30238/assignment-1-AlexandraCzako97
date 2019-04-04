package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class UserDao {
	protected static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
	
    public void insertUser(User usr ) throws SQLException, ClassNotFoundException {
    	Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm =null;
		try {
			//System.out.println("Row inserted!");
			String query="insert into users (username,password,payment_plan) values (?,?,?)";
			stm=connection.prepareStatement(query);
			stm.setString(1, usr.getUsername());
			stm.setString(2, usr.getPassword());
			stm.setString(3, usr.getPayment_plan());
			//System.out.println("Row inserted!");
			stm.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("Error inserting the row!");
		}	
	}
	
	public void deleteUser(User usr ) throws SQLException, ClassNotFoundException {
		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm = (PreparedStatement) connection.prepareStatement("DELETE FROM users WHERE username= "+"'"+usr.getUsername()+"'");
		stm.executeUpdate();
				
		System.out.println("Row deleted!");		
	}
	
	public void updateUser(User usr ) throws SQLException, ClassNotFoundException {
		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm = (PreparedStatement) connection.prepareStatement("UPDATE users SET username= "+"'"+usr.getUsername()+"'"+","
		        +" password="+"'"+usr.getPassword()+"'"+","+" payment_plan= "+"'"+usr.getPayment_plan()+"'"+" WHERE username= "+"'"+ usr.getUsername()+"'");
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
	
	 public String validatedPayment(User usr) throws SQLException, ClassNotFoundException {
	    	Connection connection= (Connection) DBconnector.getConnection();
			PreparedStatement stm= null;
			ResultSet result= null;
			
			String query="SELECT * FROM users WHERE username="+"'"+usr.getUsername()+"'"+"AND validated_payment='yes'";
			
			stm =  (PreparedStatement) connection.prepareStatement(query);
		    result = stm.executeQuery(query);
		    
		    while(result.next()) {
				  return result.getString(1);
				  
			}
			
		    return null;
	    }
	
}
