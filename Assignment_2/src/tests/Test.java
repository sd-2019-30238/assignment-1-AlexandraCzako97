package tests;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dataAccess.BookDao;
import dataAccess.DBconnector;
import model.Book;
import servlets.BooksServlet;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(DBconnector.getConnection());
		
		List<Book> allBooks = BookDao.showAllBooks();
		for(int i=0;i<allBooks.size();i++) {
			System.out.println(allBooks.get(i).getTitle());
		}


	}

}
