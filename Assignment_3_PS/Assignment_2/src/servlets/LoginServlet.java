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


import model.User;


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static String URL_PREFIX =  "/Assignment_2";
	private static String USER_LOGIN = "/Login.jsp";
	private static String LOGIN_SUCCESS = "/BookList.jsp";
	private static String LOGIN_ADMIN = "/Admin.jsp";
	private static String LOGIN_FAILURE = "/Failure.jsp";

	public LoginServlet() {
		super();

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher(USER_LOGIN);
		reqDisp.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String forward = "";
		

		
     response.sendRedirect(forward.replace(".jsp", ""));
	}


}
