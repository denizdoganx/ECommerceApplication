package util;

import java.io.File;

public class ImageObject {


	private File imageFile;
	
	private int itemID;
	
	private int id;
	
	public ImageObject() {
		
	}

	public ImageObject(File imageFile) {
		this.imageFile = imageFile;
	}

	public File getImageFile() {
		return imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
