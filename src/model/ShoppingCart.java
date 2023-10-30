package model;

import java.util.ArrayList;

public class ShoppingCart {

	private static ShoppingCart cart;
	
	private int userID;
	
	private ArrayList<CartItem> items;

	private ShoppingCart() {
		
		items = new ArrayList<>();
		
	}
	
	public static ShoppingCart getCart() {
		if(cart == null) {
			cart = new ShoppingCart();
		}
		return cart;
	}

	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public boolean addItem(CartItem item) {
		boolean isAdded = true;
		if(getPieceNumber() < 5) {
			boolean isThereGivenItem = false;
			int index = 0;
			for(CartItem cartItem : items) {
				if(cartItem.getId() == item.getId()) {
					isThereGivenItem = true;
				}
				if(!isThereGivenItem) {
					index++;
				}
			}
			if(isThereGivenItem) {
				items.get(index).setAmount(item.getAmount() + items.get(index).getAmount());
			}
			else {
				items.add(item);
			}
		}
		else {
			isAdded = false;
		}
		return isAdded;
	}
	
	public boolean updateCart(int id, int newAmount) {
		boolean isUpdated = false;
		
		if(getPieceNumber() > 0) {
			for(CartItem cartItem : items) {
				if(cartItem.getId() == id) {
					isUpdated = true;
					cartItem.setAmount(newAmount);
				}
			}
		}
		
		return isUpdated;
	}
	
	public void emptyTheCart() {
		this.items.clear();
	}
	
	public boolean deleteItemWithItemID(int id) {
		boolean isDeleted = false;
		
		if(getPieceNumber() > 0) {
			int index = - 1;
			for(CartItem cartItem : items) {
				if(cartItem.getId() == id) {
					isDeleted = true;
					index = items.indexOf(cartItem);
				}
			}
			if(isDeleted) {
				items.remove(index);
			}
		}
		
		return isDeleted;
	}
	
	public boolean deleteItemWithIndex(int index) {
		boolean isDeleted = false;
		
		if(getPieceNumber() > 0) {
			items.remove(index);
			isDeleted = true;
		}
		return isDeleted;
	}
	
	public int getUserId() {
		return userID;
	}

	public ArrayList<CartItem> getItems() {
		return items;
	}

	public CartItem getItem(int index) {
		return items.get(index);
	}
	public float getTotalPrice() {
		float sum = 0.0f;
		for(CartItem cartItem : this.items) {
			sum += (cartItem.getPrice() * cartItem.getAmount());
		}
		return sum;
	}
	
	public int getPieceNumber() {
		return items.size();
	}
	
}
