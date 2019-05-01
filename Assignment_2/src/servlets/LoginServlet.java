package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.UserDao;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao usrDao;
	private static String USER_REGISTER = "content/Register.jsp";
	private static String USER_LOGIN = "content/Login.jsp";
	private static String LOGIN_SUCCESS = "content/Success.jsp";
	private static String LOGIN_FAILURE = "content/Failure.jsp";

	public LoginServlet() {
		super();
		usrDao= new UserDao();
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher("content/Success.jsp");
		reqDisp.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		boolean result=false;
		String forward="";
		System.out.println("username1");
		try {
			result= usrDao.searchUser(request.getParameter("username"),request.getParameter("password"));
			System.out.println("username2");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		if(result==true) {
			forward=LOGIN_SUCCESS;
		}else {
			forward=LOGIN_FAILURE;
		}
		RequestDispatcher reqDisp= request.getRequestDispatcher(forward);
		reqDisp.forward(request, response);
	}


}
