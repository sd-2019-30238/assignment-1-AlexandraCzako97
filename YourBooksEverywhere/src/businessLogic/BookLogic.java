package businessLogic;

import java.sql.Date;
import java.sql.SQLException;

import dao.Book;
import dao.BookDao;


public class BookLogic {
	
	public int validateBook(String title, String author, String genre, String release_date,String price, String status) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setPrice(price);
		book.setRelease_date(release_date);
		book.setStatus(status);
		
		if(title.length()==0||author.length()==0||genre.length()==0||price.length()==0||release_date.length()==0||status.length()==0) {
			return 0;
		}
		return 1;
	}
	
	public int addNewBook(String title, String author, String genre, String release_date,String price, String status) throws ClassNotFoundException, SQLException {
		
		BookDao bDao= new BookDao();
		Book book= new Book();
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setRelease_date(release_date);
		book.setPrice(price);
		book.setStatus(status);
		//System.out.println("book added");
		if(validateBook(title, author, genre, release_date,price,status)==1) {
			bDao.insertBook(book);
			//System.out.println("book addea");
			return 1;
		}
		
		return 0;
	}
	
	public int deleteBook(String title, String author, String genre, String release_date,String price, String status) throws ClassNotFoundException, SQLException {
		
		BookDao bDao= new BookDao();
		Book book= new Book();
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setRelease_date(release_date);
		book.setPrice(price);
		book.setStatus(status);

		if(validateBook(title, author, genre, release_date,price,status)==1) {
			bDao.deleteBook(book);

			return 1;
		}
		
		return 0;
	}
	
	public int updateBook(String title, String author, String genre, String release_date,String price, String status) throws ClassNotFoundException, SQLException {
		
		BookDao bDao= new BookDao();
		Book book= new Book();
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setRelease_date(release_date);
		book.setPrice(price);
		book.setStatus(status);

		bDao.updateBook(book);
		return 1;
		
		

	}
	
	

}
