package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.UserDao;


public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserDao usrDao;
	private static String USER_LOGIN = "/Login.jsp";
	private static String REGISTER_SUCCESS = "/Login.jsp";
	private static String REGISTER_FAILURE = "/Failure.jsp";
	
	public RegisterServlet() {
		super();
		usrDao= new UserDao();
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher(USER_LOGIN);
		reqDisp.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
        String forward = "";
		
	    try {
			usrDao.insertUser(
				         req.getParameter("username"),
				         req.getParameter("password"),
				         req.getParameter("payment_plan"));
			forward=REGISTER_SUCCESS;
		} catch (ClassNotFoundException | SQLException e) {
			forward=REGISTER_FAILURE;
			e.printStackTrace();
		}
		
         RequestDispatcher view = req.getRequestDispatcher(forward);
         view.forward(req, response);
	}



}
