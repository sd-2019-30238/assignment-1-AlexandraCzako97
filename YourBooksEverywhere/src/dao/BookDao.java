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
			System.out.println("Error inserting the row!");
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
			System.out.println("Error deleting the row!");
		}			
	}
	
	public void updateBook(Book book ) throws SQLException, ClassNotFoundException {
		Connection connection= DBconnector.getConnection();
		PreparedStatement stm =null;
		System.out.println("Row updatesd!");
		try {
			
			String query="update book set status="+"'"+book.getStatus()+"'"+" where title='"+book.getTitle()+"'";
			stm=connection.prepareStatement(query);
			stm.executeUpdate();
			System.out.println("Row updated!");
			
		}catch (Exception e) {
			System.out.println("Error updating the row!");
		}			
				
	}
	
	public boolean searchBook(Book book) throws SQLException, ClassNotFoundException {
		
		Connection connection = DBconnector.getConnection();
		Statement stm = null;
		ResultSet result = null;
		
		try {
		String query = "SELECT COUNT(title) AS num FROM book WHERE title="+"'"+book.getTitle()+"'";
		stm=connection.createStatement();
		result=stm.executeQuery(query);
		
		result.next();
		if(result.getInt("num")!=0) {
			System.out.println("Book found!");
			return true;
		}
		
		}
		catch(Exception e){
			System.out.println("No book!");
		}
		
		return false;

	}
	
	
    public ArrayList<String[]> viewAllBooks() throws SQLException, ClassNotFoundException {
		
		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String query="SELECT * FROM book";
				
		ArrayList<String[]> books = new ArrayList<String[]>(); 
		stm =  (PreparedStatement) connection.prepareStatement(query);
	    result = stm.executeQuery(query);
	    
	    while(result.next()) {
			  
			  String[] oneBook = new String[50];
			  String x=result.getString(1);
			  String y=result.getString(2);
			  String z=result.getString(3);
			  String k=result.getString(4);
			  String q=result.getString(5);
			  String w=result.getString(6);
			  oneBook[0]=x;
			  oneBook[1]=y;
			  oneBook[2]=z;
			  oneBook[3]=k;
			  oneBook[4]=q;
			  oneBook[5]=w;
			  
			  books.add(oneBook);
		}
		
		return books;
		
	}
    
    
    public ArrayList<String[]> filterBooksByAuthor(String author) throws ClassNotFoundException, SQLException{

		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String query="SELECT * FROM book WHERE author="+"'"+author+"'";
		
		ArrayList<String[]> books = new ArrayList<String[]>();
		
		stm =  (PreparedStatement) connection.prepareStatement(query);
	    result = stm.executeQuery(query);
	    
	
		while(result.next()) {
			  
			  String[] oneBook = new String[50];
			  String x=result.getString(1);
			  String y=result.getString(2);
			  String z=result.getString(3);
			  String k=result.getString(4);
			  String q=result.getString(5);
			  String w=result.getString(6);
			  oneBook[0]=x;
			  oneBook[1]=y;
			  oneBook[2]=z;
			  oneBook[3]=k;
			  oneBook[4]=q;
			  oneBook[5]=w;
			  
			  books.add(oneBook);
		}
		
		return books;
		
    }
    
    public ArrayList<String[]> filterBooksByStatus(String status) throws ClassNotFoundException, SQLException{

		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String query="SELECT * FROM book WHERE status="+"'"+status+"'";
		
		ArrayList<String[]> books = new ArrayList<String[]>();
		
		stm =  (PreparedStatement) connection.prepareStatement(query);
	    result = stm.executeQuery(query);
	    
	
		while(result.next()) {
			  
			  String[] oneBook = new String[50];
			  String x=result.getString(1);
			  String y=result.getString(2);
			  String z=result.getString(3);
			  String k=result.getString(4);
			  String q=result.getString(5);
			  String w=result.getString(6);
			  oneBook[0]=x;
			  oneBook[1]=y;
			  oneBook[2]=z;
			  oneBook[3]=k;
			  oneBook[4]=q;
			  oneBook[5]=w;
			  
			  books.add(oneBook);
		}
		
		return books;
		
    }


    
    public ArrayList<String[]> filterBooksByGenre(String genre) throws ClassNotFoundException, SQLException{

		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String query="SELECT * FROM book WHERE genre="+"'"+genre+"'";

		ArrayList<String[]> books = new ArrayList<String[]>(); 
		stm =  (PreparedStatement) connection.prepareStatement(query);
	    result = stm.executeQuery(query);
	    
	    while(result.next()) {
			  
			  String[] oneBook = new String[50];
			  String x=result.getString(1);
			  String y=result.getString(2);
			  String z=result.getString(3);
			  String k=result.getString(4);
			  String q=result.getString(5);
			  String w=result.getString(6);
			  oneBook[0]=x;
			  oneBook[1]=y;
			  oneBook[2]=z;
			  oneBook[3]=k;
			  oneBook[4]=q;
			  oneBook[5]=w;
			  
			  books.add(oneBook);
		}
		
		return books;
		
		
    }
    
    public ArrayList<String[]> filterBooksByDate(String date) throws ClassNotFoundException, SQLException{

		Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String query="SELECT * FROM book WHERE release_date="+"'"+date+"'";
		
		ArrayList<String[]> books = new ArrayList<String[]>(); 
		stm =  (PreparedStatement) connection.prepareStatement(query);
	    result = stm.executeQuery(query);
	    
	    while(result.next()) {
			  
			  String[] oneBook = new String[50];
			  String x=result.getString(1);
			  String y=result.getString(2);
			  String z=result.getString(3);
			  String k=result.getString(4);
			  String q=result.getString(5);
			  String w=result.getString(6);
			  oneBook[0]=x;
			  oneBook[1]=y;
			  oneBook[2]=z;
			  oneBook[3]=k;
			  oneBook[4]=q;
			  oneBook[5]=w;
			  
			  books.add(oneBook);
		}
		
		return books;
		
		
    }
    
   
    public String getRecommendRating() throws SQLException, ClassNotFoundException {
    	Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String query="SELECT title FROM book WHERE rating >80 LIMIT 1";
		
		stm =  (PreparedStatement) connection.prepareStatement(query);
	    result = stm.executeQuery(query);
	    
	    while(result.next()) {
			  return result.getString(1);
			  
		}
		
	    return null;
    }
    
    public String getRecommendGender() throws SQLException, ClassNotFoundException {
    	Connection connection= (Connection) DBconnector.getConnection();
		PreparedStatement stm= null;
		ResultSet result= null;
		
		String query="SELECT title FROM book WHERE genre='Romance' LIMIT 1";
		
		stm =  (PreparedStatement) connection.prepareStatement(query);
	    result = stm.executeQuery(query);
	    
	    while(result.next()) {
			  return result.getString(1);
		}
		
	    return null;
    }
}
