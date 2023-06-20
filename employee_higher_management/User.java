package com.jayasadha.employee_higher_management;

public class User {
	
	private int id;
	private String Fname;
	private String Lname;
	private String Contactno;
	private String Email;
	private String AdLine1;
	private String AdLine2;
	private String City;
	private String Username;
	private String Password;
	private String Type;
	private String RegisterDate;
	
	public User(int id, String fname, String lname, String contactno, String email, String adLine1, String adLine2,
			String city, String username, String password, String type, String registerDate) {
		super();
		this.id = id;
		Fname = fname;
		Lname = lname;
		Email = email;
		Contactno = contactno;
		AdLine1 = adLine1;
		AdLine2 = adLine2;
		City = city;
		Username = username;
		Password = password;
		Type = type;
		RegisterDate = registerDate;
	}
	
	public User(int id, String fname, String lname, String contactno, String email, String adLine1, String adLine2,
			String city, String username, String password) {
		super();
		this.id = id;
		Fname = fname;
		Lname = lname;
		Email = email;
		Contactno = contactno;
		AdLine1 = adLine1;
		AdLine2 = adLine2;
		City = city;
		Username = username;
		Password = password;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return Fname;
	}

	public String getLname() {
		return Lname;
	}

	public String getEmail() {
		return Email;
	}

	public String getContactno() {
		return Contactno;
	}

	public String getAdLine1() {
		return AdLine1;
	}

	public String getAdLine2() {
		return AdLine2;
	}

	public String getCity() {
		return City;
	}

	public String getUsername() {
		return Username;
	}

	public String getPassword() {
		return Password;
	}

	public String getType() {
		return Type;
	}

	public String getRegisterDate() {
		return RegisterDate;
	}
	
}
