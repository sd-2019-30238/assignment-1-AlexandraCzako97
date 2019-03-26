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
	
    public static void insertBook(Book book ) throws SQLException, ClassNotFoundException {
		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm = (PreparedStatement) connection.prepareStatement("INSERT INTO  book (idbook,title,author,genre,release_date) "
				+ "VALUES ('"+ book.getBookId()+ "','" + book.getTitle() + "','" + book.getAuthor() + "','"+ book.getGenre()  + "','"+ book.getRelease_date()+ "')");
		stm.executeUpdate();
		
		System.out.println("Row inserted!");	
	}
	
	public static void deleteBook(Book book ) throws SQLException, ClassNotFoundException {
		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm = (PreparedStatement) connection.prepareStatement("DELETE FROM book WHERE idbook= "+"'"+book.getBookId()+"'");
		stm.executeUpdate();
				
		System.out.println("Row deleted!");		
	}
	
	public static void updateBook(Book book ) throws SQLException, ClassNotFoundException {
		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm = (PreparedStatement) connection.prepareStatement("UPDATE book SET title= "+"'"+book.getTitle()+"'"+","
		        +" author="+"'"+book.getAuthor()+"'"+","+" genre= "+"'"+book.getGenre()+"'"+","+" release_dat= "+"'"+book.getRelease_date()+"'"+" WHERE idbook= "+"'"+ book.getBookId()+"'");
		stm.executeUpdate();
	
		System.out.println("Row updated!");
				
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
			System.out.println("Wrong username/password");
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
			  Book b=new Book(result.getInt("idbook"),result.getString("title"),result.getString("author"),result.getString("genre"),result.getDate("release_date"));
			  books.add(b);
		}
		
		return books;
	}
    
    public void filterBooksByTitle(String title) throws ClassNotFoundException, SQLException{

		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String select="SELECT * FROM book WHERE title="+"'"+title+"'";
		
		//ArrayList<String> books = new ArrayList<String>(); 
		
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
		
		//ArrayList<String> books = new ArrayList<String>(); 
		
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
		
		//ArrayList<String> books = new ArrayList<String>(); 
		
		stm =  (PreparedStatement) connection.prepareStatement(select);
	    result = stm.executeQuery(select);
	    
		while(result.next()) {
			  System.out.println(result.getString(2)+" "+result.getString(3)+" "+result.getString(5)+" "+result.getString(6));
		}
		
    }

}
