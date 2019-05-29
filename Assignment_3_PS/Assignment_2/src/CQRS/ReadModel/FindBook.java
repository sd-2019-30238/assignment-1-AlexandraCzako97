package CQRS.ReadModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public static ArrayList<Book> showAllBooks() throws ClassNotFoundException, SQLException{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
		 pr =  (PreparedStatement) cnx.prepareStatement("select * from book");
		 ResultSet rs = pr.executeQuery();
		 
		 ArrayList<Book> allBooks = new ArrayList<>();
		 while(rs.next()) {
			 String title= rs.getString(1);
			 String author= rs.getString(2);
			 String genre= rs.getString(3);
			 String release_date= rs.getString(4);
			 String price= rs.getString(5);
			 String status= rs.getString(6);
			 String rating= rs.getString(7);
			 
			 Book book= new Book();
			 book.setTitle(title);
			 book.setAuthor(author);
			 book.setGenre(genre);
			 book.setRelease_date(release_date);
			 book.setPrice(price);
			 book.setStatus(status);
			 book.setRating(rating);
			 
			 allBooks.add(book);
		 }
		 
		 return allBooks;
	 }
    
    public void changeBookStatusToFree(String title) throws SQLException, ClassNotFoundException
	{
    	 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore?autoReconnect=true&useSSL=false","root","ada123");
		 pr =  (PreparedStatement) cnx.prepareStatement("update book set status = 'free' where title = '" + title+"'");
		 pr.executeQuery();
		 System.out.println("Status updated to free!");
		 	
	}
    
    public void changeBookStatusToTaken(String title) throws SQLException, ClassNotFoundException
	{
    	 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore?autoReconnect=true&useSSL=false","root","ada123");
		 pr =  (PreparedStatement) cnx.prepareStatement("update book set status = 'taken' where title = '" + title+"'");
		 pr.executeQuery();
		 System.out.println("Status updated to taken!");
		 	
	}

}
