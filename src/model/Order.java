package model;

import java.util.Date;

public class Order {

	private int id;
	private int userId;
	private int addressId;
	private Date date;
	private float totalPrice;
	private int status;
	private String orderNumber;
	public Order(int userId, int addressId, Date date, float totalPrice, int status, String orderNumber) {
		this.userId = userId;
		this.addressId = addressId;
		this.date = date;
		this.totalPrice = totalPrice;
		this.status = status;
		this.orderNumber = orderNumber;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
