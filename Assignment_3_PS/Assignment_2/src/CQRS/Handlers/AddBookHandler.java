package CQRS.Handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import CQRS.WriteModel.AddBookCommand;
import CQRS.WriteModel.ICommand;
import model.Book;

public class AddBookHandler implements IHandler {
	private PreparedStatement pr = null;

	private String commandType;
	
	public AddBookHandler() {
		this.setCommandType("addBook");
	}
	
	@Override
	public String handler(ICommand command) {
		Book book=((AddBookCommand) command).getBookDetails();
		String title=book.getTitle();
		String author=book.getAuthor();
		String genre=book.getGenre();
		String price=book.getPrice();
		String rating=book.getRating();
		String release_date=book.getRelease_date();
		String status=book.getStatus();
		
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
			pr =  (PreparedStatement) cnx.prepareStatement("insert into book(title,author,genre,release_date,price,status,rating) values (?,?,?,?,?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
					
	    try {
			pr.setString(1,title);
			pr.setString(2,author);
			pr.setString(3,genre);
			pr.setString(4,release_date);
			pr.setString(5,price);
			pr.setString(6,status);
			pr.setString(7,rating);
				      
						   
		    pr.executeUpdate();
		    System.out.println("book inserted");
		   	
		    pr.close();
		    return "Successfully added";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    return "Unsuccessfully added";
		
		
	}

	@Override
	public String getCommandType() {
		return commandType;
	}
	
	public void setCommandType(String commandType) {
		this.commandType=commandType;
		
	}
	
	

}
