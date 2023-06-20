package com.jayasadha.user_management.model;

public class Customer {

	private int userId;
	private String fName;
	private String lName;
	private String phone;
	private String email;
	private String addrLine1;
	private String addrLine2;
	private String addrLine3;
	private String username;
	private String password;
	private String type;
	private String registerDate;
	
	public Customer() {}
	
	public Customer(int userId, String fName, String lName, String phone, String email, String addrLine1,
			String addrLine2, String addrLine3, String username, String password, String type, String registerDate) {
		
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.email = email;
		this.addrLine1 = addrLine1;
		this.addrLine2 = addrLine2;
		this.addrLine3 = addrLine3;
		this.username = username;
		this.password = password;
		this.type = type;
		this.registerDate = registerDate;
	}

	
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getUserId() {
		return userId;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public String getAddrLine3() {
		return addrLine3;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getType() {
		return type;
	}
	
	public String getRegisterDate() {
		return registerDate;
	}
	
}
