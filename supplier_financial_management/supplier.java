package com.jayasadha.supplier_financial_management;

public class supplier {
	
	private   int sid;
	private String name;
    private String contact_no;
    private String email;
    private String address1;
    private String address2;
	
	    public supplier() {}
	 
	 public supplier(String name, String contact_no, String email, String address1, String address2) {
		super();
		this.name = name;
		this.contact_no = contact_no;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
	}
	public supplier(int sid, String name, String contact_no, String email, String address1, String address2) {
		super();
		this.sid= sid;
		this.name = name;
		this.contact_no = contact_no;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}


}
