package model;

public class User {
	private String username;
	private String password;
	private String payment_plan;
	private String status;
	private String validated_payment;
	

	public User() {
		
	}
	
	public User( String username, String password, String payment_plan) {
		this.username=username;
		this.password=password;
		this.payment_plan=payment_plan;
	}
	
	public User(String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	
	public String getValidated_payment() {
		return validated_payment;
	}

	public void setValidated_payment(String validated_payment) {
		this.validated_payment = validated_payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
