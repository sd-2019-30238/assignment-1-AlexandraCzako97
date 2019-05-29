package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataAccess.BookDao;
import model.Book;

public class MyLibraryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	HttpSession session;
	ArrayList<String> cartlist = new ArrayList<>();

	public MyLibraryServlet() {
		super();
	
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		String action = request.getParameter("action");
		System.out.println("book not added yet");
		try {
			Book book=BookDao.searchBook((String) request.getAttribute("title"));
			if(book.getStatus()=="free") {
				cartlist.add(book.getTitle());
				session.setAttribute("cartlist", cartlist);
				response.sendRedirect("cartlist");
				System.out.println("book added");
				request.getRequestDispatcher("/MyLibrary.jsp").forward(request, response);
			}else {
				response.sendRedirect("TakenBook.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}


}
