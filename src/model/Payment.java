package model;

import java.util.Date;

public class Payment {

	private int id;
	private int orderId;
	private Date date;
	private int paymentType;
	private boolean isOk;
	private String approveCode;
	private float paymentTotal;
	public Payment(int orderId, Date date, int paymentType, boolean isOk, String approveCode,
			float paymentTotal) {
		this.orderId = orderId;
		this.date = date;
		this.paymentType = paymentType;
		this.isOk = isOk;
		this.approveCode = approveCode;
		this.paymentTotal = paymentTotal;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}
	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	public String getApproveCode() {
		return approveCode;
	}
	public void setApproveCode(String approveCode) {
		this.approveCode = approveCode;
	}
	public float getPaymentTotal() {
		return paymentTotal;
	}
	public void setPaymentTotal(float paymentTotal) {
		this.paymentTotal = paymentTotal;
	}
	
	
}
