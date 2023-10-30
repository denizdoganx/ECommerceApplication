package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import context.DbHelperForAdmin;
import model.Invoice;
import model.Item;
import model.Order;
import model.Payment;
import model.User;
import util.ImageObject;

public class AdminPageController {

	private static AdminPageController instance = null;
	
	private AdminPageController() {
		
	}
	
	public static AdminPageController getInstance() {
		if(instance == null) {
			instance = new AdminPageController();
		}
		return instance;
	}
	
	public int addItem(Item item) {
		PreparedStatement statement = null;
		int lastInsertedId =  - 1;
		Connection connection = null;
		try {
			connection = DbHelperForAdmin.getConnection();
			statement = connection.prepareStatement("insert into items "
					+ "(itemCode, itemName, unitPrice, brand, category1, category2, category3, category4, stockNumber) values (?, ?, ?, ?, ?, ?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, item.getItemCode());
			statement.setString(2, item.getItemName());
			statement.setFloat(3, item.getUnitPrice());
			statement.setString(4, item.getBrand());
			statement.setString(5, item.getCategory1());
			statement.setString(6, item.getCategory2());
			statement.setString(7, item.getCategory3());
			statement.setString(8, item.getCategory4());
			statement.setInt(9, item.getStockNumber());
			statement.executeUpdate();
			
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				lastInsertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			DbHelperForAdmin.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForAdmin.killTheConnection();
			} catch (SQLException e) {
				DbHelperForAdmin.showErrorMessage(e);
			}
		}
		return lastInsertedId;
	}
	
	public boolean addImages(ArrayList<ImageObject> images) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		FileInputStream fis;
		boolean ret = false;
		try {
			connection = DbHelperForAdmin.getConnection();
			
			for(ImageObject imageObject : images) {
				
				fis = null;
				preparedStatement = null;
				
				fis = new FileInputStream(imageObject.getImageFile());
				
				String sql = "INSERT INTO images (name_, data_, itemId) VALUES (?, ?, ?)";
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, imageObject.getImageFile().getName());
				preparedStatement.setBinaryStream(2, fis, (int)imageObject.getImageFile().length());
				preparedStatement.setInt(3, imageObject.getItemID());
				
				int affectedRowNumber = preparedStatement.executeUpdate();
				
				if(affectedRowNumber == 1) {
					System.out.println(imageObject.getImageFile().getName() + "'nın yüklemesi başarılı.");
					ret = true;
				}
				else {
					System.out.println("Yükleme başarısızzzzzzzz.");
				}
			}
			
		} 
		catch(SQLException e) {
			DbHelperForAdmin.showErrorMessage(e);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				DbHelperForAdmin.killTheConnection();
			} catch (SQLException e) {
				DbHelperForAdmin.showErrorMessage(e);
			}
		}
		return ret;
	}
	
	public boolean addUser(User user) {
		PreparedStatement statement = null;
		int result = 0;
		Connection connection = null;
		try {
			connection = DbHelperForAdmin.getConnection();
			statement = connection.prepareStatement("insert into users "
					+ "(username_, password_, name_, surname, email, gender, phone) values (?, ?, ?, ?, ?, ?, ?);");
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getName());
			statement.setString(4, user.getSurname());
			statement.setString(5, user.getEmail());
			statement.setString(6, user.getGender());
			statement.setString(7, user.getPhone());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			DbHelperForAdmin.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForAdmin.killTheConnection();
			} catch (SQLException e) {
				DbHelperForAdmin.showErrorMessage(e);
			}
		}
		return result == 1;
	}
	
	public ArrayList<Order> getOrders(){
		ArrayList<Order> orders;
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		try {
			orders = new ArrayList<>();
			connection = DbHelperForAdmin.getConnection();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from orders;");
			
			while(resultSet.next()) {
				
				orders.add(
						new Order
								(
								resultSet.getInt("userId"),
								resultSet.getInt("addressId"),
								resultSet.getDate("date_"),
								resultSet.getFloat("totalPrice"),
								resultSet.getInt("status_"),
								resultSet.getString("orderNumber")
								)
						);
			}
		}
		catch(SQLException e) {
			orders = null;
			DbHelperForAdmin.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForAdmin.killTheConnection();
			}
			catch(SQLException e) {
				DbHelperForAdmin.showErrorMessage(e);
			}
		}
		return orders;
	}
	
	public ArrayList<Invoice> getInvoices(){
		ArrayList<Invoice> invoices;
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		try {
			invoices = new ArrayList<>();
			connection = DbHelperForAdmin.getConnection();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from invoices;");
					
			while(resultSet.next()) {
				invoices.add(
						new Invoice(
								resultSet.getInt("orderId"),
								resultSet.getInt("addressId"),
								resultSet.getDate("date_"),
								resultSet.getInt("cargoFicheNum"),
								resultSet.getFloat("totalPrice")
								)
						);
			}
		}
		catch(SQLException e) {
			invoices = null;
			DbHelperForAdmin.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForAdmin.killTheConnection();
			}
			catch(SQLException e) {
				DbHelperForAdmin.showErrorMessage(e);
			}
		}
		return invoices;
	}
	
	public ArrayList<Payment> getPayments(){
		ArrayList<Payment> payments;
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		
		try {
			payments = new ArrayList<>();
			connection = DbHelperForAdmin.getConnection();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from payments;");
					
			while(resultSet.next()) {
				payments.add(
						new Payment(
								resultSet.getInt("orderId"),
								resultSet.getDate("date_"),
								resultSet.getInt("paymentType"),
								resultSet.getBoolean("isOk"),
								resultSet.getString("approveCode"),
								resultSet.getFloat("paymentTotal")
								)
						);
			}
		}
		catch(SQLException e) {
			payments = null;
			DbHelperForAdmin.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForAdmin.killTheConnection();
			}
			catch(SQLException e) {
				DbHelperForAdmin.showErrorMessage(e);
			}
		}
		return payments;	
	}
	
	public ArrayList<User> getUsers(){
		
		ArrayList<User> users;
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		
		try {
			users = new ArrayList<>();
			connection = DbHelperForAdmin.getConnection();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from users;");
					
			while(resultSet.next()) {
				users.add(
						new User(
								resultSet.getString("username_"),
								resultSet.getString("password_"),
								resultSet.getString("name_"),
								resultSet.getString("surname"),
								resultSet.getString("email"),
								resultSet.getString("gender"),
								resultSet.getString("phone")
								)
						);
			}
		}
		catch(SQLException e) {
			users = null;
			DbHelperForAdmin.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForAdmin.killTheConnection();
			}
			catch(SQLException e) {
				DbHelperForAdmin.showErrorMessage(e);
			}
		}
		return users;
		
	}
}
