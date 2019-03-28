package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

public class BookDao {
protected static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
	
    public void insertBook(Book book ) throws SQLException, ClassNotFoundException {
    	Connection connection= DBconnector.getConnection();
		PreparedStatement stm =null;
		try {
			
			String query="insert into book (title,author,genre,release_date,price,status) values (?,?,?,?,?,?)";
			stm=connection.prepareStatement(query);
			stm.setString(1, book.getTitle());
			stm.setString(2, book.getAuthor());
			stm.setString(3, book.getGenre());
			stm.setString(4, book.getRelease_date());
			stm.setString(5, book.getPrice());
			stm.setString(6, book.getStatus());
			stm.executeUpdate();
			System.out.println("Row inserted!");
			
		}catch (Exception e) {
			System.out.println("Error inserting the row!"+e);
		}	
		
	}
	public void deleteBook(Book book ) throws SQLException, ClassNotFoundException {
		Connection connection= DBconnector.getConnection();
		PreparedStatement stm =null;
		try {
			
			String query="delete from book where title="+"'"+book.getTitle()+"'";
			stm=connection.prepareStatement(query);
			stm.executeUpdate();
			System.out.println("Row deleted!");
			
		}catch (Exception e) {
			System.out.println("Error deleting the row!"+e);
		}			
	}
	
	public void updateBook(Book book ) throws SQLException, ClassNotFoundException {
		Connection connection= DBconnector.getConnection();
		PreparedStatement stm =null;
		System.out.println("Row updatesd!");
		try {
			
			String query="update book set price="+"'"+book.getPrice()+"'"+" where title='"+book.getTitle()+"'";
			stm=connection.prepareStatement(query);
			stm.executeUpdate();
			System.out.println("Row updated!");
			
		}catch (Exception e) {
			System.out.println("Error updating the row!"+e);
		}			
				
	}
	
	public int searchBook(Book book) throws SQLException, ClassNotFoundException {
		
		Connection connection = DBconnector.getConnection();
		Statement stm = null;
		ResultSet result = null;
		
		try {
		String query = "SELECT COUNT(title) AS num FROM book WHERE title="+"'"+book.getTitle()+"'";
		stm=connection.createStatement();
		result=stm.executeQuery(query);
		
		result.next();
		int booksNumber=result.getInt("num");
		if(booksNumber!=0) {
			System.out.println("Book found!");
		}
		return booksNumber;
		}
		catch(Exception e){
			System.out.println("No book!");
		}
		
		return 0;

	}
	
    public ArrayList<Book> viewAllBooks() throws SQLException, ClassNotFoundException {
		
		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String select="SELECT * FROM book";
				
		ArrayList<Book> books = new ArrayList<Book>(); 
		stm =  (PreparedStatement) connection.prepareStatement(select);
	    result = stm.executeQuery(select);
		while(result.next()) {
			  Book b=new Book(result.getString("title"),result.getString("author"),result.getString("genre"),result.getString("release_date"),
					  result.getString("price"),result.getString("status"));
			  books.add(b);
		}
		
		return books;
	}
    
    public void filterBooksByTitle(String title) throws ClassNotFoundException, SQLException{

		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String select="SELECT * FROM book WHERE title="+"'"+title+"'";
		
		stm =  (PreparedStatement) connection.prepareStatement(select);
	    result = stm.executeQuery(select);
	    
		while(result.next()) {
			  System.out.println(result.getString(3)+" "+result.getString(4)+" "+result.getString(5));
		}
		
    }
    
    public void filterBooksByAuthor(String author) throws ClassNotFoundException, SQLException{

		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String select="SELECT * FROM book WHERE author="+"'"+author+"'";
		
		//ArrayList<String> books = new ArrayList<String>(); 
		
		stm =  (PreparedStatement) connection.prepareStatement(select);
	    result = stm.executeQuery(select);
	    
		while(result.next()) {
			  System.out.println(result.getString(2)+" "+result.getString(4)+" "+result.getString(5));
		}
		
    }
    
    public void filterBooksByGenre(String genre) throws ClassNotFoundException, SQLException{

		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String select="SELECT * FROM book WHERE genre="+"'"+genre+"'";

		stm =  (PreparedStatement) connection.prepareStatement(select);
	    result = stm.executeQuery(select);
	    
		while(result.next()) {
			  System.out.println(result.getString(2)+" "+result.getString(3)+" "+result.getString(5));
		}
		
    }
    
    public void filterBooksByDate(Date date) throws ClassNotFoundException, SQLException{

		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String select="SELECT * FROM book WHERE release_date="+"'"+date+"'";
		
		stm =  (PreparedStatement) connection.prepareStatement(select);
	    result = stm.executeQuery(select);
	    
		while(result.next()) {
			  System.out.println(result.getString(2)+" "+result.getString(3)+" "+result.getString(5)+" "+result.getString(6));
		}
		
    }

}
