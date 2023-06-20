package com.jayasadha.supplier_financial_management;

import java.util.ArrayList;
import java.util.List;

public class valid {
	
	
    private   String SID;
    private String name;
    private String contact_no;
    private String email;
    private String address1;
    private String address2;
   
    
    public valid() {
    }
    
	public valid(String SID, String name, String contact_no,String email, String Address1, String Address2) {
		this.SID = SID;
		this.name = name;
		this.contact_no = contact_no;
		this.email = email;
		this.address1= Address1;
		this.address2= Address2;
		
	
	}



	public String getSID() {
		return SID;
	}

	public String getName() {
		return name;
	}


	public String getContact_no() {
		return contact_no;
	}


	public String getEmail() {
		return email;
	}


	public String getAddress1() {
		return address1;
	}


	public String getAddress2() {
		return address2;
	}
	

	

}



