package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import context.DbHelperForAdmin;
import context.DbHelperForCustomer;
import model.Admin;
import model.User;
import util.Response;


public class LoginPageController {
	
	private static LoginPageController instance = null;
	
	private LoginPageController() {
		
	}
	
	public static LoginPageController getInstance() {
		if(instance == null) {
			instance = new LoginPageController();
		}
		return instance;
	}

	public Response login(String username, String password) {
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		boolean isOk = false;
		String responseMessage = null;
		int authority = - 1;
		boolean isFound = false;
		if(username.contains("admin")) {
			
			ArrayList<Admin> admins = new ArrayList<>();
			
			try {
				connection = DbHelperForAdmin.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select * from admins;");
				while(resultSet.next()) {
					admins.add(new Admin(resultSet.getString("username_"), resultSet.getString("password_"), resultSet.getInt("authority")));
				}
				
				for(Admin admin : admins) {
					if(admin.getUsername().equals(username)) {
						isFound = true;
						if(admin.getPassword().equals(password)) {
							isOk = true;
							authority = admin.getAuthority();
							responseMessage = "Login successful.";
							
						}
						else {
							isOk = false;
							responseMessage = "Username and Password do not match !";
							authority = - 1;
						}
						break;
					}
				}
				if(!isFound) {
					isOk = false;
					responseMessage = "There is no such record !";
					authority = - 1;
				}
				
			} catch(SQLException e) {
				isOk = false;
				responseMessage = "An error has occurred in the system";
				authority = -1;
				DbHelperForAdmin.showErrorMessage(e);
			} 
			finally {
				try {
					DbHelperForAdmin.killTheConnection();
				} catch (SQLException e) {
					DbHelperForAdmin.showErrorMessage(e);
				}
			}
			return new Response(responseMessage, isOk, authority);
		}
		else {
			Response response = null;
			try {
				connection = DbHelperForCustomer.getConnection();
				User user = this.getUserFromDB(username, password, connection);
				if(user == null) {
					isOk = false;
					authority = - 1;
					if(containsGivenUsername(username, connection)) {
						responseMessage = "Username and Password do not match !";
					}
					else {
						responseMessage = "There is no such record !";
					}
					response = new Response(responseMessage, isOk, authority);
				}
				else {
					isOk = true;
					authority = 1;
					responseMessage = "Login successful.";
					response = new Response(responseMessage, isOk, authority);
					response.setUser(user);
				}
			} 
			catch(SQLException e) {
				isOk = false;
				authority = -1;
				responseMessage = "An error has occurred in the system";
				response = new Response(responseMessage, isOk, authority);
				DbHelperForCustomer.showErrorMessage(e);
			}
			finally {
				try {
					DbHelperForCustomer.killTheConnection();
				} catch (SQLException e) {
					DbHelperForCustomer.showErrorMessage(e);
				}
			}
			return response;
		}
		
	}
	
	private User getUserFromDB(String username, String password, Connection connection) {
		User user = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sqlString = "";
		
		try {
			statement = connection.createStatement();
			sqlString = "select * from users where username_ = '" + username + "' and password_ = '" + password + "';";
			resultSet = statement.executeQuery(sqlString);
			if(resultSet.next()) {
				user = new User(
						username,
						password,
						resultSet.getString("name_"),
						resultSet.getString("surname"),
						resultSet.getString("email"),
						resultSet.getString("gender"),
						resultSet.getString("phone")
						);
				user.setId(resultSet.getInt("id"));
			}
			else {
				user = null;
			}
			
		} catch(SQLException e) {
			user = null;
			DbHelperForCustomer.showErrorMessage(e);
		}
		
		return user;
	}
	
	private boolean containsGivenUsername(String username, Connection connection) {

		Statement statement = null;
		ResultSet resultSet = null;
		String sqlString = "";
		boolean ret = false;
		try {
			statement = connection.createStatement();
			sqlString += "select * from users where username_ = '";
			sqlString += username + "';";
			resultSet = statement.executeQuery(sqlString);

			ret = resultSet.next();
		} catch(SQLException e) {
			ret = false;
			DbHelperForCustomer.showErrorMessage(e);
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		return ret;
	}
}
