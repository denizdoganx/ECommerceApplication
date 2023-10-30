package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelperForAdmin {

	private static final String username = "exampleUsernameForAdmin";
	private static final String password = "examplePasswordForAdmin";
	private static final String dbUrl = "jdbc:mysql://localhost:3306/ecommerce";
	private static Connection connection = null;
	
	private DbHelperForAdmin() { 
		
	}
	
	public static Connection getConnection() throws SQLException {
		if(connection == null) {
			connection = DriverManager.getConnection(dbUrl, username, password);
		}
		return connection;
	}
	
	public static void showErrorMessage(SQLException exception) {
		System.out.println("Error Code : " + exception.getMessage());
	}
	

	public static void killTheConnection() throws SQLException {
		if(connection != null) {
			connection.close();
			connection = null;
		}
	}
}
