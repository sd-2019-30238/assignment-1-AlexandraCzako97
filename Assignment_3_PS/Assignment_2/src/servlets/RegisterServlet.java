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

import CQRS.WriteModel.BookWriteModel;
import CQRS.WriteModel.UserWriteModel;
import model.Mediator;
import model.User;


public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserWriteModel userModel;
	
	public RegisterServlet() {
		super();
		Mediator mediator= new Mediator();
		userModel= new UserWriteModel(mediator);

		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp= request.getRequestDispatcher("/Register.jsp");
		reqDisp.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String payment_plan=req.getParameter("payment_plan");
		
		User usr=new User();
		usr.setUsername(username);
		usr.setPassword(password);
		usr.setPayment_plan(payment_plan);
		
		String succeed=userModel.addUser(usr);
	
		if(succeed=="Success"){
			System.out.println("User added!");
		}else {
		System.out.println("User not added!");
		}
		
		
	}



}
