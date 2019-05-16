package dataAccess;

import java.util.logging.Logger;

import model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		 
		 public void updateStatus(String title, String status) throws SQLException, ClassNotFoundException {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore","root","ada123");
			    pr =  (PreparedStatement) cnx.prepareStatement("update book set status=? where title=?");	
				pr.setString(1,title);
				pr.setString(2,status);

				pr.executeUpdate();
				System.out.println("book updateeed");
				
				pr.close();
			
		 }
					   
		
}



