package com.jayasadha.inquiry_management;


public class Contact {
	
    private int id;
    private String fname ;
    private String lname ;
    private String contactno ;
    private String type ;
    private String msg ;
    private String cus_date;
    private String rep_msg;
    private String  rep_date;
    private String status;
    
    
    
	public Contact(int id, String fname, String lname, String contactno, String type, String msg, String  cus_date,
			String rep_msg, String  rep_date, String status) {
	
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.contactno = contactno;
		this.type = type;
		this.msg = msg;
		this.cus_date = cus_date;
		this.rep_msg = rep_msg;
		this.rep_date = rep_date;
		this.status = status;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getContactno() {
		return contactno;
	}



	public void setContactno(String contactno) {
		this.contactno = contactno;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String  getCus_date() {
		return cus_date;
	}



	public void setCus_date(String  cus_date) {
		this.cus_date = cus_date;
	}



	public String  getRep_msg() {
		return rep_msg;
	}



	public void setRep_msg(String rep_msg) {
		this.rep_msg = rep_msg;
	}



	public String  getRep_date() {
		return rep_date;
	}



	public void setRep_date(String rep_date) {
		this.rep_date = rep_date;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
    
    
    
	
}

