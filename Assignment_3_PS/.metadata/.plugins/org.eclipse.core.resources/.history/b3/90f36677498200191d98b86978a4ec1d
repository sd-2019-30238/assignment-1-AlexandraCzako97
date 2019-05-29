package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Book;


public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static String USER_LOGIN = "/Admin.jsp";
	private static String REGISTER_SUCCESS = "/Admin.jsp";
	private static String REGISTER_FAILURE = "/Failure.jsp";
	
	public AdminServlet() {
		super();

		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher(USER_LOGIN);
		reqDisp.forward(request, response);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
        String forward = "";
        boolean insert=false;
		

	}


}
