package util;

import model.User;

public class Response {

	private String responseMessage;
	
	private boolean isOk;
	
	private int authority;
	
	private User user;

	public Response(String responseMessage, boolean isOk, int authority) {
		this.responseMessage = responseMessage;
		this.isOk = isOk;
		this.authority = authority;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
