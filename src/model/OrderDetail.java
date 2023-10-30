package model;

public class OrderDetail {

	
	private int id;
	private int orderId;
	private int itemId;
	private float unitPrice;
	private int amount;
	private float lineTotal;
	public OrderDetail(int orderId, int itemId, float unitPrice, int amount, float lineTotal) {
		this.orderId = orderId;
		this.itemId = itemId;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.lineTotal = lineTotal;
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
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(float lineTotal) {
		this.lineTotal = lineTotal;
	}
	
	
}
