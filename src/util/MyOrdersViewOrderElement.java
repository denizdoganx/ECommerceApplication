package util;

import java.util.Date;

public class MyOrdersViewOrderElement {

	private int orderID;
	
	private int userID;
	
	private Date date;
	
	private float totalPrice;
	
	private int orderStatus;
	
	private int addressID;
	
	private String orderNumber;
	
	private String addressString;

	public MyOrdersViewOrderElement(int orderID, int userID, Date date, float totalPrice, int orderStatus, int addressID,
			String orderNumber, String addressString) {
		super();
		this.addressID = addressID;
		this.orderID = orderID;
		this.userID = userID;
		this.date = date;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
		this.orderNumber = orderNumber;
		this.addressString = addressString;
	}

	
	
	public int getAddressID() {
		return addressID;
	}



	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}



	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getAddressString() {
		return addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	
	
	
}
