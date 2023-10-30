package model;

public class Admin {

	private String username;
	private String password;
	private int authority;
	public Admin(String username, String password, int authority) {
		super();
		this.username = username;
		this.password = password;
		this.authority = authority;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
	
}
