package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelperForCustomer {
	
	private static final String username = "exampleUsernameForCustomer";
	private static final String password = "examplePasswordForCustomer";
	private static final String dbUrl = "jdbc:mysql://localhost:3306/ecommerce";
	private static Connection connection = null;
	
	private DbHelperForCustomer() {
		
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
