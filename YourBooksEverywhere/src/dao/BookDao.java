package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import model.Book;

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

}
