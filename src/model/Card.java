package model;

public class Card {

	private int id;
	
	private int userId;
	
	private String cardNumber;
	
	private String nameAndSurnameOnTheCard;
	
	private String expirationDate;
	
	private String securityNumber;

	public Card(int userId, String cardNumber, String nameAndSurnameOnTheCard, String expirationDate,
			String securityNumber) {
		this.userId = userId;
		this.cardNumber = cardNumber;
		this.nameAndSurnameOnTheCard = nameAndSurnameOnTheCard;
		this.expirationDate = expirationDate;
		this.securityNumber = securityNumber;
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameAndSurnameOnTheCard() {
		return nameAndSurnameOnTheCard;
	}

	public void setNameAndSurnameOnTheCard(String nameAndSurnameOnTheCard) {
		this.nameAndSurnameOnTheCard = nameAndSurnameOnTheCard;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSecurityNumber() {
		return securityNumber;
	}

	public void setSecurityNumber(String securityNumber) {
		this.securityNumber = securityNumber;
	}
	
	
	
}
