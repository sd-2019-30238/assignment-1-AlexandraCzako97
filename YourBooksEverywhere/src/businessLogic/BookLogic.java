package businessLogic;


import java.sql.SQLException;
import java.util.ArrayList;


import dao.Book;
import dao.BookDao;


public class BookLogic {
	
	public boolean validateBook(String title, String author, String genre, String release_date,String price, String status) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setPrice(price);
		book.setRelease_date(release_date);
		book.setStatus(status);
		
		if(title.length()<1||author.length()<1||genre.length()<1||price.length()<1||release_date.length()<1||status.length()<1) {
			return false;
		}
		return true;
	}
	
	public boolean addNewBook(String title, String author, String genre, String release_date,String price, String status) throws ClassNotFoundException, SQLException {
		
		BookDao bDao= new BookDao();
		Book book= new Book();
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setRelease_date(release_date);
		book.setPrice(price);
		book.setStatus(status);
		
		if(validateBook(title, author, genre, release_date,price,status)==true) {
			bDao.insertBook(book);
			
			return true;
		}
		
		return false;
	}
	
	public boolean deleteBook(String title, String author, String genre, String release_date,String price, String status) throws ClassNotFoundException, SQLException {
		
		BookDao bDao= new BookDao();
		Book book= new Book();
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setRelease_date(release_date);
		book.setPrice(price);
		book.setStatus(status);

		bDao.deleteBook(book);

		return true;

	}
	
	public boolean updateBook(String title, String author, String genre, String release_date,String price, String status) throws ClassNotFoundException, SQLException {
		
		BookDao bDao= new BookDao();
		Book book= new Book();
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setRelease_date(release_date);
		book.setPrice(price);
		book.setStatus(status);

		bDao.updateBook(book);
		
		return true;
		
		

	}
	
	public boolean searchBook(String title) throws ClassNotFoundException, SQLException {
		
		BookDao bDao= new BookDao();
		Book book= new Book();
		
		book.setTitle(title);

		if(bDao.searchBook(book)!=false) {
		   return true;
		}
		return false;
		
		
	}
	
	public  ArrayList<String[]> viewAll() throws SQLException, ClassNotFoundException {
		
		BookDao bDao= new BookDao();
		ArrayList<String[]> s=bDao.viewAllBooks();
		return s;
	}
	
	
	public ArrayList<String[]> filterBooks(String filter, String filter2) throws ClassNotFoundException, SQLException{
		BookDao bdao= new BookDao();
		if(filter=="author") {
			//System.out.println(author);
			ArrayList<String[]> s=bdao.filterBooksByAuthor(filter2);
			return s;
		}else if(filter=="genre") {
			//System.out.println(author);
			ArrayList<String[]> s=bdao.filterBooksByGenre(filter2);
			return s;
		
		
	}
		return null;
	}
	
	

}
