package tests;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dataAccess.AdminDao;
import dataAccess.BookDao;
import dataAccess.DBconnector;
import model.Book;
import model.MailingObserver;
import servlets.BooksServlet;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//	System.out.println(DBconnector.getConnection());
		
		List<Book> allBooks = BookDao.showAllBooks();
		for(int i=0;i<allBooks.size();i++) {
			//System.out.println(allBooks.get(i).getTitle());
		}		
		AdminDao admD=new AdminDao();
		MailingObserver mail = new MailingObserver();
		//mail.next("Pride and Prejudice");
		admD.modifyAvailability("Pride and Prejudice", "free");
		//admD.updateStatus("Gone With The Wind", "free");
		//admD.searchWaitingList("czaada@gmail.com");
		//System.out.println(admD.getEmail("Pride and Prejudice"));
		


	}

}
