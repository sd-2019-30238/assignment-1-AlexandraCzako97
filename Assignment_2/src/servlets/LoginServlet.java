package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataAccess.UserDao;
import model.User;


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao usrDao;
	private static String USER_LOGIN = "/Login.jsp";
	private static String LOGIN_SUCCESS = "/Success.jsp";
	private static String LOGIN_FAILURE = "/Failure.jsp";

	public LoginServlet() {
		super();
		usrDao= new UserDao();
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher(USER_LOGIN);
		reqDisp.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String forward = "";
		
		boolean result=false;
		try {
			result = usrDao.searchUser(
			         request.getParameter("username"),
			         request.getParameter("password"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
         if (result == true) {
             forward = LOGIN_SUCCESS;
         } else {
             forward = LOGIN_FAILURE;
         }
     
         RequestDispatcher view = request.getRequestDispatcher(forward);
         view.forward(request, response);
	}


}
