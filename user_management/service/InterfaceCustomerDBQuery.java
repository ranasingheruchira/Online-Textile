package com.jayasadha.user_management.service;

import java.util.List;

import com.jayasadha.user_management.model.Customer;

public interface InterfaceCustomerDBQuery {

	/**
	 * method for insert customer details
	 */
	public boolean insertCusDetails(String fName, String lName, String phone, String email, String adrLine1, String adrLine2, String adrLine3, String username, String password);

	/**
	 * method for check whether the user name & password exist or not
	 */
	public boolean validateCredentials(String username, String password);
	
	/**
	 * method1(for login) for get the customer details 
	 */
	public List<Customer> getCusDetails(String username1, String password1);
	
	/**
	 * method2(for profile) for get the customer details 
	 */
	public List<Customer> getProfile(String id);
	
	/**
	 * method for update the customer details 
	 */
	public boolean updateCusDetails(String userId, String fName, String lName, String phone, String email, String adrLine1, String adrLine2, String adrLine3, String username, String password);
	
	/**
	 * method for deactivate customer(update)
	 */
	public boolean deactivateCustomer(String userId);
	
	/**
	 * method for check whether the email exist or not(forget password)
	 */
	public boolean validateEmail(String email);
	
	/**
	 * method for get contact number(forget password)
	 */
	public String getContact(String email);
	
	/**
	 * method for check whether the contact number exists or not(Reset password1)
	 */
	public boolean validatePhoneNum(String phone);
	
	/**
	 * method for update new password
	 */
	public boolean updateNewPassword(String password, String phone);
	
	/**
	 * method for get total number of customers
	 */
	public int getToatalCus();
	
	/**
	 * method for get inactive customer IDs
	 */
	public List<Customer> getInactiveCusIds();
	
	/**
	 * method for delete customers who are inactive more than 1 year
	 */
	public boolean deleteInactiveCustomers(String id);
	
	/**
	 * method for insert deleted customer details
	 */
	public boolean insertDeletedCusDetails(String id, String fName, String lName, String phone, String email, String adrLine1, String adrLine2, String adrLine3, String username, String password, String type9, String registerDate);
		
}
