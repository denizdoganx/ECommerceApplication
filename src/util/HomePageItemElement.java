package util;


public class HomePageItemElement {

	private int productId;
	
	private String filePathOfIcon;
	
	private String priceText;
	
	private String informationText;

	public HomePageItemElement(int productId, String filePathOfIcon, String priceText, String informationText) {
		this.productId = productId;
		this.filePathOfIcon = filePathOfIcon;
		this.priceText = priceText;
		this.informationText = informationText;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getFilePathOfIcon() {
		return filePathOfIcon;
	}

	public void setFilePathOfIcon(String filePathOfIcon) {
		this.filePathOfIcon = filePathOfIcon;
	}

	public String getPriceText() {
		return priceText;
	}

	public void setPriceText(String priceText) {
		this.priceText = priceText;
	}

	public String getInformationText() {
		return informationText;
	}

	public void setInformationText(String informationText) {
		this.informationText = informationText;
	}

	
}
