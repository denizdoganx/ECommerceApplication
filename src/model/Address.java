package model;

public class Address {

	private int id;
	private int userId;
	private String country;
	private String city;
	private String town;
	private String district;
	private String addressText;
	private String postalCode;
	private String addressTitle;

	public Address(int id, int userId, String country, String city, String town, String district, String addressText,
			String postalCode, String addressTitle) {
		this.id = id;
		this.userId = userId;
		this.country = country;
		this.city = city;
		this.town = town;
		this.district = district;
		this.addressText = addressText;
		this.postalCode = postalCode;
		this.addressTitle = addressTitle;
	}

	
	
	public Address(int userId, String country, String city, String town, String district, String addressText,
			String postalCode, String addressTitle) {
		this.userId = userId;
		this.country = country;
		this.city = city;
		this.town = town;
		this.district = district;
		this.addressText = addressText;
		this.postalCode = postalCode;
		this.addressTitle = addressTitle;
	}



	public String getAddressTitle() {
		return addressTitle;
	}



	public void setAddressTitle(String addressTitle) {
		this.addressTitle = addressTitle;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddressText() {
		return addressText;
	}

	public void setAddressText(String addressText) {
		this.addressText = addressText;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
	
}
