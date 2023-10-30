package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DbHelperForCustomer;
import model.Address;
import model.Card;
import model.Invoice;
import model.InvoiceDetail;
import model.Order;
import model.OrderDetail;
import model.Payment;

public class DeliveryAndPaymentPageController {

	private static DeliveryAndPaymentPageController instance = null;
	
	private DeliveryAndPaymentPageController() {
			
	}
	
	public static DeliveryAndPaymentPageController getInstance() {
		if(instance == null) {
			instance = new DeliveryAndPaymentPageController();
		}
		return instance;
	}
	
	public boolean addNewAddress(Address address) {
		
		int result;
		PreparedStatement preparedStatement;
		Connection connection;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("insert into addresses("
					+ " userId,"
					+ " country,"
					+ " city,"
					+ " town,"
					+ " district,"
					+ " addressText,"
					+ " postalCode,"
					+ " addressTitle)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?);");
			
			preparedStatement.setInt(1, address.getUserId());
			preparedStatement.setString(2, address.getCountry());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getTown());
			preparedStatement.setString(5, address.getDistrict());
			preparedStatement.setString(6, address.getAddressText());
			preparedStatement.setString(7, address.getPostalCode());
			preparedStatement.setString(8, address.getAddressTitle());
			
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
	
	
	public boolean reduceStockNumber(int productId, int amount) {
		PreparedStatement preparedStatement;
		Connection connection;
		int ret = -1;
		
		try {
			int stockNumber = getStockNumberOfGivenItem(productId);
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("update items set items.stockNumber = ? where id = ?;");
			int newStockNumber = stockNumber - amount;
			preparedStatement.setInt(1, newStockNumber);
			preparedStatement.setInt(2, productId);
			ret = preparedStatement.executeUpdate();
			
		}catch(SQLException e) {
			ret = -1;
			DbHelperForCustomer.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
			}catch(SQLException e1) {
				DbHelperForCustomer.showErrorMessage(e1);
			}
		}
		
		return ret == 1;
	}
	
	
	public int getStockNumberOfGivenItem(int productId) {
		
		PreparedStatement preparedStatement;
		Connection connection;
		ResultSet resultSet;
		int ret = -1;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("select stockNumber from items where id = ?;");
			preparedStatement.setInt(1, productId);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				ret = resultSet.getInt("stockNumber");
			}
			
		}
		catch(SQLException e) {
			ret = -1;
			DbHelperForCustomer.showErrorMessage(e);
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
			} catch (SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		return ret;
	}
	
	
	public boolean addNewCard(Card card) {
		int result;
		PreparedStatement preparedStatement;
		Connection connection;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("insert into cards( "
					+ "userId,"
					+ " cardNumber,"
					+ " nameAndSurnameOnTheCard,"
					+ " expirationDate, securityNumber)"
					+ " values(?, ?, ?, ?, ?);");
			
			preparedStatement.setInt(1, card.getUserId());
			preparedStatement.setString(2, card.getCardNumber());
			preparedStatement.setString(3, card.getNameAndSurnameOnTheCard());
			preparedStatement.setString(4, card.getExpirationDate());
			preparedStatement.setString(5, card.getSecurityNumber());
			
			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			result = - 1;
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
		return result == 1;
	}
	
	public boolean addPayment(Payment payment) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		int result = - 1;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("insert payments (orderId, date_, paymentType, isOk, approveCode, paymentTotal) "
					+ "values(?, ?, ?, ?, ?, ?);");
			
			java.util.Date utilDate = payment.getDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			preparedStatement.setInt(1, payment.getOrderId());
			preparedStatement.setDate(2, sqlDate);
			preparedStatement.setInt(3, payment.getPaymentType());
			preparedStatement.setBoolean(4, payment.isOk());
			preparedStatement.setString(5, payment.getApproveCode());
			preparedStatement.setFloat(6, payment.getPaymentTotal());
			
			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			result = -1;
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
		return result == 1;
	}
	
	public int addOrder(Order order) {
		int lastInsertedId = -1;
		PreparedStatement preparedStatement;
		Connection connection;
		ResultSet resultSet;
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("insert into orders(userId, date_, totalPrice, status_, addressId, orderNumber) "
					+ "values (?, ?, ?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS);
			
			
			java.util.Date utilDate = order.getDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			preparedStatement.setInt(1, order.getUserId());
			preparedStatement.setDate(2, sqlDate);
			preparedStatement.setFloat(3, order.getTotalPrice());
			preparedStatement.setInt(4, order.getStatus());
			preparedStatement.setInt(5, order.getAddressId());
			preparedStatement.setString(6, order.getOrderNumber());
			
			preparedStatement.executeUpdate();
			
			resultSet = preparedStatement.getGeneratedKeys();
			
			if(resultSet.next()) {
				lastInsertedId = resultSet.getInt(1);
			}
		}
		catch(SQLException e) {
			lastInsertedId = -1;
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
		return lastInsertedId;
	}
	
	public int addInvoice(Invoice invoice) {
		
		Connection connection;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		int lastInsertedIdOfInvoice = - 1;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("insert into invoices(orderId, addressId, date_, cargoFicheNum, totalPrice)"
					+ " values (?, ?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS);
			
			java.util.Date utilDate = invoice.getDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			preparedStatement.setInt(1, invoice.getOrderId());
			preparedStatement.setInt(2, invoice.getAddressId());
			preparedStatement.setDate(3, sqlDate);
			preparedStatement.setInt(4, invoice.getCargoFicheNum());
			preparedStatement.setFloat(5, invoice.getTotalPrice());
			
			preparedStatement.executeUpdate();
			
			resultSet = preparedStatement.getGeneratedKeys();
			
			if(resultSet.next()) {
				lastInsertedIdOfInvoice = resultSet.getInt(1);
			}
		}
		catch(SQLException e) {
			lastInsertedIdOfInvoice = - 1;
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
		return lastInsertedIdOfInvoice;
	}
	
	public int addOrderDetail(OrderDetail orderDetail) {
		int lastInsertedId = -1;
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("insert orderDetails(orderId, itemId, unitPrice, amount, lineTotal) "
					+ "values (?, ?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, orderDetail.getOrderId());
			preparedStatement.setInt(2, orderDetail.getItemId());
			preparedStatement.setFloat(3, orderDetail.getUnitPrice());
			preparedStatement.setInt(4, orderDetail.getAmount());
			preparedStatement.setFloat(5, orderDetail.getLineTotal());
			
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			
			if(resultSet.next()) {
				lastInsertedId = resultSet.getInt(1);
			}
		}
		catch(SQLException e) {
			lastInsertedId = -1;
			DbHelperForCustomer.showErrorMessage(e);
			System.out.println("Controller'un catch bloğu");
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
			}
			catch(SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		
		return lastInsertedId;
	}
	
	public boolean addInvoiceDetail(InvoiceDetail invoiceDetail) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		int result = -1;
		
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("insert into invoicedetails(invoiceId, orderDetailId, itemId, unitPrice, amount, lineTotal)"
					+ " values (?, ?, ?, ?, ?, ?);");
			preparedStatement.setInt(1, invoiceDetail.getInvoiceId());
			preparedStatement.setInt(2, invoiceDetail.getOrderDetailId());
			preparedStatement.setInt(3, invoiceDetail.getItemId());
			preparedStatement.setFloat(4, invoiceDetail.getUnitPrice());
			preparedStatement.setInt(5, invoiceDetail.getAmount());
			preparedStatement.setFloat(6, invoiceDetail.getLineTotal());
			
			result = preparedStatement.executeUpdate();
		}
		
		catch(SQLException e) {
			result = -1;
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
		
		return result == 1;
	}
}
