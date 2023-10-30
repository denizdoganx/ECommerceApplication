package model;

public class InvoiceDetail {

	private int id;
	private int invoiceId;
	private int orderDetailId;
	private int itemId;
	private float unitPrice;
	private int amount;
	private float lineTotal;
	public InvoiceDetail(int invoiceId, int orderDetailId, int itemId, float unitPrice, int amount,
			float lineTotal) {
		this.invoiceId = invoiceId;
		this.orderDetailId = orderDetailId;
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
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
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
