package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.BookDao;
import model.Observer;

public class StatusServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Observer> observerList=new ArrayList<Observer>();
	
	public StatusServlet() {
		super();
		BeforeServlet bs=new BeforeServlet();
		this.addListenerEvent(bs);
		
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String status=request.getParameter("status");
		for (Observer o:observerList){
	        	o.update(title, status);
		}
		response.sendRedirect("borrowed");
	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	public void addListenerEvent(Observer listener) {
		observerList.add(listener);
	}

	public void removeListenerEvent(Observer listener) {
		observerList.remove(listener);	
	}
	

}
