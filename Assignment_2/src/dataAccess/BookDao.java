package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import model.Book;

public class BookDao {
	
	protected static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
	private static PreparedStatement pr = null;
	
	
	
	public static Book searchBook(String title) throws SQLException, ClassNotFoundException {
		
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
		pr =  (PreparedStatement) cnx.prepareStatement("SELECT COUNT(title) AS num FROM book WHERE title="+"'"+title+"'");
		ResultSet rs = pr.executeQuery();
		
		while(rs.next()) {
			 String titlee= rs.getString(1);
			 String author= rs.getString(2);
			 String genre= rs.getString(3);
			 String release_date= rs.getString(4);
			 String price= rs.getString(5);
			 String status= rs.getString(6);
			 String rating= rs.getString(7);
			 
			 Book book= new Book();
			 book.setTitle(titlee);

			 return book;
			
		}
		return null;

	}
	
	 public void insertUser(String title, String author, String genre, String release_date, String price, String status, String rating ) throws SQLException, ClassNotFoundException {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
	    pr =  (PreparedStatement) cnx.prepareStatement("insert into book(title,author,genre,release_date,price,status,rating) values (?,?,?,?,?,?,?)");
				
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
	 }
	 
	 
	 public void updateStatus(String title, String status) throws SQLException, ClassNotFoundException {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
		    pr =  (PreparedStatement) cnx.prepareStatement("UPDATE book SET status="+"'"+status+"'"+" WHERE title="+"'"+title+"'");
					
			pr.setString(1,title);
			pr.setString(6,status);
			      
					   
			pr.executeUpdate();
			System.out.println("book updateeeed");
			pr.close();
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
	 
	 public static ArrayList<Book> showAllBooksWithTitle(String titlee) throws ClassNotFoundException, SQLException{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
		 pr =  (PreparedStatement) cnx.prepareStatement("select * from book where title=?");
		 pr.setString(1,titlee);
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
	 
	 public static ArrayList<Book> showAllFreeBooks() throws ClassNotFoundException, SQLException{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
		 pr =  (PreparedStatement) cnx.prepareStatement("select * from book where status='free'");
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
			

}
