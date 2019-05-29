package CQRS.ReadModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;

public class FindBook {
	private static PreparedStatement pr = null;
    public Book searchBook(String title) throws SQLException, ClassNotFoundException {
		
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
		pr =  (PreparedStatement) cnx.prepareStatement("SELECT COUNT(title) AS num FROM book WHERE title="+"'"+title+"'");
		ResultSet rs = pr.executeQuery();
		
		while(rs.next()) {
			 String titlee= rs.getString(1);
			 
			 Book book= new Book();
			 book.setTitle(titlee);
			 System.out.println("Found the book! ");
			 return book;
			
		}
		
		System.out.println("Didn't find that book!");
		return null;

	}

}
