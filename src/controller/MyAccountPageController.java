package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import context.DbHelperForCustomer;
import model.Address;
import model.Card;
import util.MyOrdersViewOrderElement;

public class MyAccountPageController {

	private static MyAccountPageController instance = null;
	
	private MyAccountPageController() {
		
	}
	
	public static MyAccountPageController getInstance() {
		if(instance == null) {
			instance = new MyAccountPageController();
		}
		return instance;
	}
	
	public boolean changePassword(int id, String newPassword) {
		Connection connection;
		PreparedStatement preparedStatement;
		int result;
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("update users set password_ = ? where id = ?;");
			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
		} 
		catch(SQLException e) {
			DbHelperForCustomer.showErrorMessage(e);
			result = -1;
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
			} catch (SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		return result == 1;
	}
	
	public boolean changeCommunicationInformation(int id, String newEmail, String newPhoneNumber) {
		Connection connection;
		PreparedStatement preparedStatement;
		int result;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("update users set email = ?, phone = ? where id = ?;");
			preparedStatement.setString(1, newEmail);
			preparedStatement.setString(2, newPhoneNumber);
			preparedStatement.setInt(3, id);
			
			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			result = -1;
			DbHelperForCustomer.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
			} catch (SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		return result == 1;
	}
	
	public boolean changeMembershipInformation(int id, String newName, String newSurname, String newGender) {
		Connection connection;
		PreparedStatement preparedStatement;
		int result;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("update users set name_ = ?, surname = ?, gender = ? where id = ?;");
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, newSurname);
			preparedStatement.setString(3, newGender);
			preparedStatement.setInt(4, id);
			
			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			DbHelperForCustomer.showErrorMessage(e);
			result = - 1;
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
			} catch (SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		return result == 1;
	}
	

	public ArrayList<Card> getCards(int userId){
		
		ArrayList<Card> cards = null;
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("select cards.* from users, cards where users.id = ? and cards.userId = ?;");
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, userId);
			resultSet = preparedStatement.executeQuery();
			cards = new ArrayList<>();
			
			while(resultSet.next()) {
				cards.add(
						new Card(
								userId,
								resultSet.getString("cardNumber"),
								resultSet.getString("nameAndSurnameOnTheCard"),
								resultSet.getString("expirationDate"),
								resultSet.getString("securityNumber")
								)
						);
			}
		}
		catch(SQLException e) {
			cards = null;
			DbHelperForCustomer.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
			}
			catch(SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		
		return cards;
	}
	
	public ArrayList<Address> getAddresses(int userId){
		ArrayList<Address> addresses = null;
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("select addresses.* from users, addresses where users.id = ? and addresses.userId = ?;");
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, userId);
			resultSet = preparedStatement.executeQuery();
			addresses = new ArrayList<>();
			
			while(resultSet.next()) {
				addresses.add(new Address
						(
							resultSet.getInt("id"),
							userId,
							resultSet.getString("country"),
							resultSet.getString("city"),
							resultSet.getString("town"),
							resultSet.getString("district"),
							resultSet.getString("addressText"),
							resultSet.getString("postalCode"),
							resultSet.getString("addressTitle")
						));
			}
		}
		catch(SQLException e) {
			addresses = null;
			DbHelperForCustomer.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
			}
			catch(SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		
		return addresses;
	}
	
	public ArrayList<MyOrdersViewOrderElement> getOrders(int userId){
		ArrayList<MyOrdersViewOrderElement> orders = null;
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("select orders.*, addresses.addressTitle, addresses.town, addresses.city from orders "
					+ "inner join users on orders.userId = users.id "
					+ "inner join addresses on orders.addressId = addresses.id where users.id = ?;");
			preparedStatement.setInt(1, userId); 
			
			resultSet = preparedStatement.executeQuery();
			orders = new ArrayList<>();
			
			while(resultSet.next()) {
				orders.add(new MyOrdersViewOrderElement(
						resultSet.getInt("id"),
						userId,
						resultSet.getDate("date_"),
						resultSet.getFloat("totalPrice"),
						resultSet.getInt("status_"),
						resultSet.getInt("addressId"),
						resultSet.getString("orderNumber"),
						resultSet.getString("addressTitle") + " / " + resultSet.getString("town") + " / " + resultSet.getString("city")));
			}
		}
		catch(SQLException e) {
			orders = null;
			DbHelperForCustomer.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
			}
			catch(SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		
		return orders;
	}
}
