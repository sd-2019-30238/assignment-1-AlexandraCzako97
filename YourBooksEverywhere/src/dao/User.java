package dao;

public class User {
	private int userId;
	private String username;
	private String password;
	private String payment_plan;
	
	public User() {
		
	}
	
	public User(int userId, String username, String password, String payment_plan) {
		this.userId=userId;
		this.username=username;
		this.password=password;
		this.payment_plan=payment_plan;
	}
	
	public User(String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getPayment_plan() {
		return payment_plan;
	}
	public void setPayment_plan(String payment_plan) {
		this.payment_plan = payment_plan;
	}

}
