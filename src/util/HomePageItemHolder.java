package util;

import java.util.ArrayList;

public class HomePageItemHolder {

	public static HomePageItemHolder instance = null;
	
	private ArrayList<HomePageItemElement> items;
	
	private HomePageItemHolder() {
		items = new ArrayList<>();
	}
	
	
	public static HomePageItemHolder getInstance() {
		if(instance == null) {
			instance = new HomePageItemHolder();
		}
		return instance;
	}
	
	public void setItems(ArrayList<HomePageItemElement> items) {
		this.items = items;
	}
	
	public ArrayList<HomePageItemElement> getItems(){
		return this.items;
	}
}
