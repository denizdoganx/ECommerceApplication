package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import context.DbHelperForCustomer;
import model.User;
import util.Response;

public class SignUpPageController {

	private static SignUpPageController instance = null;
	
	private SignUpPageController() {
		
	}
	
	public static SignUpPageController getInstance() {
		if(instance == null) {
			instance = new SignUpPageController();
		}
		return instance;
	}
	
	public Response signUp(User user) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		boolean isOk = false;
		String responseMessage = null;
		try {
			connection = DbHelperForCustomer.getConnection();
			
			if(!containsGivenUsername(user.getUsername(), connection)) {
				preparedStatement = connection.prepareStatement("insert into users "
						+ "(username_, password_, name_, surname, email, gender, phone) values (?, ?, ?, ?, ?, ?, ?);");
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getName());
				preparedStatement.setString(4, user.getSurname());
				preparedStatement.setString(5, user.getEmail());
				preparedStatement.setString(6, user.getGender());
				preparedStatement.setString(7, user.getPhone());
				preparedStatement.executeUpdate();
				isOk = true;
				responseMessage = "The Account has been successfully created.";
			}
			else {
				isOk = false;
				responseMessage = "This username is already taken !";
			}

		} catch (SQLException e) {
			isOk = false;
			responseMessage = "An error has occurred in the system";
			DbHelperForCustomer.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		return new Response(responseMessage, isOk, -1);
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
