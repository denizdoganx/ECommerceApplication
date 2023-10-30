package model;

import java.util.Date;

public class Invoice {

	private int id;
	private int orderId;
	private int addressId;
	private Date date;
	private int cargoFicheNum;
	private float totalPrice;
	public Invoice(int orderId, int addressId, Date date, int cargoFicheNum, float totalPrice) {
		this.orderId = orderId;
		this.addressId = addressId;
		this.date = date;
		this.cargoFicheNum = cargoFicheNum;
		this.totalPrice = totalPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public int getCargoFicheNum() {
		return cargoFicheNum;
	}
	public void setCargoFicheNum(int cargoFicheNum) {
		this.cargoFicheNum = cargoFicheNum;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
