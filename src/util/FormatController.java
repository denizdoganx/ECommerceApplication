package util;

import javax.swing.JOptionPane;

import model.Item;
import model.User;

public class FormatController {

	
	public static boolean checkUser(User user) {
		
		String username = user.getUsername();
		String password = user.getPassword();
		String name = user.getName();
		String surname = user.getSurname();
		String email = user.getEmail();
		String gender = user.getGender();
		String phone = user.getPhone();
		
		return checkUsername(username) && checkPassword(password) && checkName(name) && checkSurname(surname) && chechEmailFormat(email)
				&& checkGender(gender) && checkPhoneNumber(phone);
		
	}
	
	public static boolean checkItem(Item item) {
		
		String itemCode = item.getItemCode();
		String itemName = item.getItemName();
		String brand = item.getBrand();
		String category1 = item.getCategory1();
		
		return checkIsEmpty(itemCode, "Item Code") && checkIsEmpty(itemName, "Item Name") &&
				checkIsEmpty(brand, "Brand") && checkIsEmpty(category1, "Category1");
		
	}
	
	public static boolean checkNameAndSurnameOnTheCard(String text) {
		String[] pieces = text.split(" ");
		
		if(pieces.length != 2) {
			JOptionPane.showMessageDialog(null, "Fill in the Name Surname field in \"NAME SURNAME\" format.", "Error !", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			return checkNameAndSurname(pieces[0], "Name") && checkNameAndSurname(pieces[1], "Surname");
		}
	}
	
	public static boolean checkFormatOfCardNumber(String card) {
		
		if(card.length() != 19) {
			JOptionPane.showMessageDialog(null, "Enter the card number in the format XXXX XXXX XXXX XXXX.", "Error !", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			String[] piecesOfCardNum = card.split(" ");
			
			if(piecesOfCardNum.length != 4) {
				JOptionPane.showMessageDialog(null, "Enter the card number in the format XXXX XXXX XXXX XXXX.", "Error !", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else {
				for(String piece : piecesOfCardNum) {
					for(int i = 0;i < piece.length(); i++) {
						if(piece.charAt(i) < 48 || piece.charAt(i) > 57) {
							JOptionPane.showMessageDialog(null, "Just enter numbers in the card number field.", "Error !", JOptionPane.ERROR_MESSAGE);
							return false;
						}
					}
				}
				return true;
			}
		}
	}
	
	public static boolean checkFormatOfExpirationDate(String expirationDate) {
		String[] pieces = expirationDate.split("/");
		
		if(pieces.length != 2) {
			JOptionPane.showMessageDialog(null, "Fill in the Expiration Date field in 05/23 format.", "Error !", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			for(String piece : pieces) {
				for(int i = 0;i < piece.length(); i++) {
					if(piece.charAt(i) < 48 || piece.charAt(i) > 57) {
						JOptionPane.showMessageDialog(null, "Fill in the Expiration Date field in 05/23 format.", "Error !", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}
			}
			return true;
		}
	}
	
	public static boolean checkSecurityNumber(String num) {
		if(num.length() != 3) {
			JOptionPane.showMessageDialog(null, "You must enter a 3-digit number in the security number field.", "Error !", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			for(int i = 0;i < num.length(); i++) {
				if(num.charAt(i) < 48 || num.charAt(i) > 57) {
					JOptionPane.showMessageDialog(null, "You must enter a 3-digit number in the security number field.", "Error !", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			return true;
		}
	}
	
	public static boolean checkUsername(String username) {
		
		
		return checkIsEmpty(username, "Username") && checkLength(username, "username") && checkUsernameForAdmin(username);
	}
	
	
	public static boolean checkUsernameForAdmin(String username) {
		if(username.toLowerCase().contains("admin")) {
			JOptionPane.showMessageDialog(null, "This username is inappropiate.", "Error !", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static boolean checkPassword(String password) {
		return checkIsEmpty(password, "Password") && checkLength(password, "password");
	}
	
	public static boolean checkName(String name) {
		return checkIsEmpty(name, "Name") && checkNameAndSurname(name, "Name"); 
	}
	
	public static boolean checkSurname(String surname) {
		return checkIsEmpty(surname, "Surname") && checkNameAndSurname(surname, "Surname"); 
	}
	
	public static boolean checkEmail(String email) {
		return checkIsEmpty(email, "Email") && chechEmailFormat(email);
	}
	
	public static boolean checkGender(String gender) {
		return checkIsEmpty(gender, "Gender") && checkGenderFormat(gender);
	}
	
	public static boolean checkLength(String data, String fieldName) {
		if(data.length() < 4) {
			JOptionPane.showMessageDialog(null, "You must enter at least 4 characters in the " + fieldName + " field.", "Error !", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	public static boolean checkIsEmpty(String data, String fieldName) {
		if(data.isEmpty()) {
			JOptionPane.showMessageDialog(null,  fieldName + " field cannot be left blank.", "Error !", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	public static boolean chechEmailFormat(String email) {
		if(email.endsWith("@outlook.com") || email.endsWith("@gmail.com") || email.endsWith("@hotmail.com") || email.endsWith("@icloud.com")) {
			int index = email.indexOf('@');
			
			if(index < 4) {
				JOptionPane.showMessageDialog(null, "You must use at least 4 characters before the @ sign.", "Error !", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else {
				return true;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Wrong email format.", "Error !", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public static boolean checkPhoneNumber(String phone) {
		
		if(phone.length() != 10) {
			JOptionPane.showMessageDialog(null, "Phone number length must be 10 characters.", "Error !", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			if(phone.charAt(0) != '5') {
				JOptionPane.showMessageDialog(null, "Phone number must start with 5.", "Error !", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else {
				for(int i = 0;i < phone.length(); i++) {
					if(phone.charAt(i) < 48 || phone.charAt(i) > 57) {
						JOptionPane.showMessageDialog(null, "Just enter numbers in the phone number field.", "Error !", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}
				return true;
			}
		}
	}
	
	public static boolean checkNameAndSurname(String word, String fieldName) {
		
		for(int i = 0;i < word.length(); i++) {
			if((word.charAt(i) > 64 && word.charAt(i) < 91) || (word.charAt(i) < 123 && word.charAt(i) > 96)) {
				continue;
			}
			else {
				JOptionPane.showMessageDialog(null, "You can only use letters in the" + fieldName + "field", "Error !", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;	
	}
	
	
	public static boolean checkGenderFormat(String gender) {
		String lowerGender = gender.toLowerCase();
		if(lowerGender.equals("m") || lowerGender.equals("f") || lowerGender.equals("male") || lowerGender.equals("female")) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "You can use m, f, male or female characters in the Gender field.", "Error !", JOptionPane.ERROR_MESSAGE);
		return false;
	}
}
