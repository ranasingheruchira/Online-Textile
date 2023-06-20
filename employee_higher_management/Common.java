package com.jayasadha.employee_higher_management;

public class Common {
	
	private int Id;
	private String Fname;
	private String Lname;
	private String Contactno;
	private String Email;
	private String AdLine1;
	private String AdLine2;
	private String City;
	private String Username;
	private String Password;
	private int Eid;
	private String Nic;
	private String Dob;
	private String Positionid;
	
	public Common(int id, String fname, String lname, String contactno, String email, String adLine1, String adLine2,
			String city, String username, String password, int eid, String nic, String dob, String positionid) {
		super();
		Id = id;
		Fname = fname;
		Lname = lname;
		Contactno = contactno;
		Email = email;
		AdLine1 = adLine1;
		AdLine2 = adLine2;
		City = city;
		Username = username;
		Password = password;
		Eid = eid;
		Nic = nic;
		Dob = dob;
		Positionid = positionid;
	}

	public int getId() {
		return Id;
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

	public int getEid() {
		return Eid;
	}

	public String getNic() {
		return Nic;
	}

	public String getDob() {
		return Dob;
	}

	public String getPositionid() {
		return Positionid;
	}
	
}
