package util;

import model.Address;

public class OrderReceivedPageItemElement {
	
	private String orderNumber;
	
	private Address address;
	
	private float totalPrice;
	
	private String cardNumber;

	public OrderReceivedPageItemElement(String orderNumber, Address address, float totalPrice, String cardNumber) {
		super();
		this.orderNumber = orderNumber;
		this.address = address;
		this.totalPrice = totalPrice;
		this.cardNumber = cardNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	

}
