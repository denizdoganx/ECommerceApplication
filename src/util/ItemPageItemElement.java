package util;

import java.util.ArrayList;

import model.Item;

public class ItemPageItemElement {

	private ArrayList<String> imagePaths;
	
	private Item item;

	
	public ItemPageItemElement(ArrayList<String> imagePaths, Item item) {
		super();
		this.imagePaths = imagePaths;
		this.item = item;
	}

	public ArrayList<String> getImagePaths() {
		return imagePaths;
	}

	public void setImagePaths(ArrayList<String> imagePaths) {
		this.imagePaths = imagePaths;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
