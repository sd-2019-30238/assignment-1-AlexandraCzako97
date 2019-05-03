package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnector {
	
		private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
		private static final String DBURL = "jdbc:mysql://localhost:3307/bookstore";
		private static final String USER ="root";
		private static final String PASS ="ada123";
		private static Connection connection;

		public DBconnector() throws ClassNotFoundException {
		
			Class.forName(DRIVER);
		}
		
		public static Connection getConnection() throws SQLException, ClassNotFoundException {
			connection= null;
			
			connection =DriverManager.getConnection(DBURL, USER, PASS);
				
			if(connection!=null) {
					System.out.println("Successfully connected!");
			}
		
			return connection;
			
		}
		
		public static void close(Connection connection) throws SQLException {
			if (connection != null) {
					connection.close();
					}
		}

		public static void close(Statement statement) throws SQLException {
			if (statement != null) {
					statement.close();
			}
		}
			
		public static void close(ResultSet resultSet) throws SQLException {
			if (resultSet != null) {

					resultSet.close();
			}
			
		}
		public static void close() throws SQLException {
		
				connection.close();
				System.out.println("Closed");
		
		}

/*private static Connection connection;
	
	static{
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore", "root", "ada123");
			if(connection!=null) {
				System.out.println("Successfully connected!");
			}else {
				System.out.println("NOT connected!");
			}
		}catch(ClassNotFoundException e){ 		
			
		}catch(SQLException e){ 
				
		}	
	}

	public static Connection getConnection() {
		return connection;
	}
*/
		
}
