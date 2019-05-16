package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataAccess.AdminDao;
import dataAccess.BookDao;
import model.Observer;
import model.User;
import model.Util;

public class BeforeServlet extends HttpServlet implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		User user =Util.getLoggedUser(session);
		try {
			try {
				request.setAttribute("borrowed", BookDao.showAllBooksWithTitle(user.getUsername()));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/TakenBook.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void update(String title, String status) {
		AdminDao admDao= new AdminDao();
		try {
			admDao.updateStatus(title, status);
			System.out.println("Status updated now!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}