package CQRS.Handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import CQRS.WriteModel.AddUserCommand;
import CQRS.WriteModel.ICommand;

import model.User;

public class AddUserHandler implements IHandler{

	private PreparedStatement pr = null;
	private String commandType;
	
	public AddUserHandler() {
		this.setCommandType("addUser");
	}


	@Override
	public String handler(ICommand command) {
		User user=((AddUserCommand) command).getUserDetails();
		
		String username=user.getUsername();
		String password=user.getPassword();
		String payment_plan=user.getPayment_plan();


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection cnx = null;
		try {
			cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    try {
	    	 pr =  (PreparedStatement) cnx.prepareStatement("insert into users(username,password,payment_plan,validated_payment) values (?,?,?,null)");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
					
	    try {
			pr.setString(1,username);
			pr.setString(2,password);
			pr.setString(3,payment_plan);
						   
		    pr.executeUpdate();
		    System.out.println("user inserted");
		   	
		    pr.close();
		    return "Success";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    return "Error";
	}

	@Override
	public String getCommandType() {
		return commandType;
	}
	
	public void setCommandType(String commandType) {
		this.commandType=commandType;
		
	}
}
