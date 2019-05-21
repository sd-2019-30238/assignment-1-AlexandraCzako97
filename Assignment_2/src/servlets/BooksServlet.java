package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dataAccess.BookDao;
import model.Book;


public class BooksServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static String BOOKLIST = "/BookList.jsp";
	ArrayList<Book> myBooks = new ArrayList<>();
	HttpSession session;
	ArrayList<String> cartlist = new ArrayList<>();

	public BooksServlet() {
		super();
	
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			myBooks = BookDao.showAllBooks();
	
			session = request.getSession();
			session.setAttribute("allBooks",myBooks);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(BOOKLIST).forward(request, response);
		//RequestDispatcher view = request.getRequestDispatcher(BOOKLIST);
		//view.forward(request, response);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher view = request.getRequestDispatcher(BOOKLIST);
		view.forward(request, response);		
		//doGet(request,response);
		
	}


}
