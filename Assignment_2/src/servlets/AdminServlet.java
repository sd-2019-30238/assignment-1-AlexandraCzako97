package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.AdminDao;
import dataAccess.BookDao;
import dataAccess.UserDao;
import model.Book;


public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AdminDao admDao;
	private static String USER_LOGIN = "/Admin.jsp";
	private static String REGISTER_SUCCESS = "/Admin.jsp";
	private static String REGISTER_FAILURE = "/Failure.jsp";
	
	public AdminServlet() {
		super();
		admDao= new AdminDao();
		
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
		
	 //   try {
	    	/*insert=admDao.insertBook( req.getParameter("title"),  req.getParameter("author"),
	    			 req.getParameter("genre"),  req.getParameter("release_date"), 
	    			 req.getParameter("price"),  req.getParameter("status"),  req.getParameter("rating"));*/
//	    	admDao.updateStatus(req.getParameter("title"), req.getParameter("status"));
//			
//			forward=REGISTER_SUCCESS;
//		} catch (ClassNotFoundException | SQLException e) {
//			forward=REGISTER_FAILURE;
//			e.printStackTrace();
//		}
//	    if(insert) System.out.println("New book inserted!");
//
//		
//         RequestDispatcher view = req.getRequestDispatcher(forward);
//         view.forward(req, response);
	}


}
