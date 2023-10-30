package model;

public class CartItem {

	private int itemID;
	private String imagePath;
	private String information;
	private float price;
	private int amount;
	public CartItem(int id, String imagePath, String information, float price, int amount) {
		this.itemID = id;
		this.imagePath = imagePath;
		this.information = information;
		this.price = price;
		this.amount = amount;
	}
	public int getId() {
		return itemID;
	}
	public void setId(int id) {
		this.itemID = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
