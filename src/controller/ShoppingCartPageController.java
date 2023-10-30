package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import context.DbHelperForCustomer;
import model.Address;
import model.Card;

public class ShoppingCartPageController {

	private static ShoppingCartPageController instance = null;
	
	private ShoppingCartPageController() {
		
	}
	
	public static ShoppingCartPageController getInstance() {
		if(instance == null) {
			instance = new ShoppingCartPageController();
		}
		return instance;
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
}
