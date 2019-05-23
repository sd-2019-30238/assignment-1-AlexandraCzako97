package dataAccess;

import java.util.logging.Logger;

import model.Book;
import dataAccess.DBconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {
	

	protected static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
		private PreparedStatement pr = null;
		public boolean searchUser(String username, String password) throws SQLException, ClassNotFoundException {
			
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
			pr =  (PreparedStatement) cnx.prepareStatement("SELECT COUNT(username) AS num FROM admins WHERE username="+"'"+username+"'"+"AND"+" password="+"'"+password+"'");
			ResultSet rs = pr.executeQuery();
			
			rs.next();
			int usersNumber=rs.getInt("num");
			System.out.println(username);
			if(usersNumber==1) {
				System.out.println("Admin found!");
				return true;
			}else if(usersNumber==0) {
				System.out.println("Admin not found!");
			}
			
			return false;

		}	
	
		
		 public boolean insertBook(String title, String author, String genre, String release_date, String price, String status, String rating ) throws SQLException, ClassNotFoundException {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
			    pr =  (PreparedStatement) cnx.prepareStatement("insert into book(title,author,genre,release_date,price,status,rating) values (?,?,?,?,?,?,?)");
						
				pr.setString(1,title);
				pr.setString(2,author);
				pr.setString(3,genre);
				pr.setString(4,release_date);
				pr.setString(5,price);
				pr.setString(6,status);
				pr.setString(7,rating);
				      
						   
				pr.executeUpdate();
				System.out.println("book inserted");
				
				pr.close();
				return true;
			 }
		 
//		 public void updateStatus(String title, String status) throws SQLException, ClassNotFoundException {
//			 Class.forName("com.mysql.cj.jdbc.Driver");
//			    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
//			    pr =  (PreparedStatement) cnx.prepareStatement("update book set status=? where title=?");	
//				pr.setString(1,title);
//				pr.setString(2,status);
//
//				pr.executeUpdate();
//				System.out.println("book updateeed");
//				
//				pr.close();
//			
//		 }


		public void insertWaitingList(String username, String email) throws ClassNotFoundException, SQLException {
			 Class.forName("com.mysql.jdbc.Driver");
			    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
			    pr =  (PreparedStatement) cnx.prepareStatement("insert into waitingList(username,email) values (?,?)");
						
				pr.setString(1,username);
				pr.setString(2,email );

				pr.executeUpdate();
				System.out.println("user inserted to waiting list");
				pr.close();
		 }
		 public String getEmail(String title) throws SQLException, ClassNotFoundException {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
			  //  pr =  (PreparedStatement) cnx.prepareStatement("Select email from waitingList where username = '" + username + "' limit 1");
			   // Statement st = cnx.createStatement();
			    String query = "Select email from waitingList where title = '" + title + "' limit 1";
				Statement statement = cnx.createStatement();
				ResultSet result = statement.executeQuery(query);
				result.next();
				return result.getString(1);
		 }
		 public void modifyAvailability(String title, String status) throws SQLException, ClassNotFoundException
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
			 try {
					java.sql.CallableStatement myStmt = cnx.prepareCall("{call update(?,?)}");
					myStmt.setString(1, title);
					myStmt.setString(2, status);
					myStmt.executeUpdate();
				} catch (SQLException e) {

					e.printStackTrace();
				}
		 }
		 public void searchWaitingList(String username) throws ClassNotFoundException, SQLException {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
			  //  pr =  (PreparedStatement) cnx.prepareStatement("Select email from waitingList where username = '" + username + "' limit 1");
			   // Statement st = cnx.createStatement();
			    String query = "Select title from waitingList where email = '" + username + "' limit 1";
			    
				Statement statement = cnx.createStatement();
				ResultSet result = statement.executeQuery(query);
				result.next();
				
				String query1 = "Select status from book where title = '" + result.getString(1) + "' limit 1";
				Statement statement1 = cnx.createStatement();
				ResultSet result1 = statement.executeQuery(query1);
				result1.next();
			
				int ok;
				if(result1.getString(1).equals("free"))
					ok=1;
				else ok= 0;
				
				if(ok == 1 ) 
					System.out.println("Un email va fi trimis la adresa dumneavoastra de mail!");
				else System.out.println("Cartea nu este disponibila!");
				
		 }
		 
		 public void deleteWaitingList(String username) throws ClassNotFoundException, SQLException {
			 Class.forName("com.mysql.jdbc.Driver");
			    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
			    pr =  (PreparedStatement) cnx.prepareStatement("delete from waitingList(username,email) where username=?");
						
				pr.setString(1,username);

				pr.executeUpdate();
				System.out.println("user inserted to waiting list");
				pr.close();
		 }
		 
		 public void notifyUser(String username) throws ClassNotFoundException, SQLException {
			 Class.forName("com.mysql.jdbc.Driver");
			    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
			    pr =  (PreparedStatement) cnx.prepareStatement("select email from waitingList where username=?");
						
				pr.setString(1,username);

				pr.executeUpdate();
				System.out.println("user inserted to waiting list");
				pr.close();
		 }
					   
		
}



