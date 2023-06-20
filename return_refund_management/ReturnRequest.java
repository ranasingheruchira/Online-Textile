package com.jayasadha.return_refund_management;

import java.sql.Date;

public class ReturnRequest {
	
	int RequestID;
	int CustomerID;
	String CustomerReason;
	String Emp_note;
	Date requestDate;
	String status;
	int orderID;
	int ItemID;
	int replacement;
	String relacementImage;
	
	String itemImage;
	String itemname;
	double itemPrice;
	
	String ret_itemImage;
	String ret_itemname;
	double ret_itemPrice;
	
	
	public ReturnRequest(int requestID, int customerID, String customerReason, String emp_note, Date requestDate,
			String status, int orderID, int itemID, int replacement, String relacementImage, String itemImage,String itemname,double ItemPrice,	
			String ret_itemImage, String ret_itemname,double ret_itemPrice) {
		
		super();
		RequestID = requestID;
		CustomerID = customerID;
		CustomerReason = customerReason;
		Emp_note = emp_note;
		this.requestDate = requestDate;
		this.status = status;
		this.orderID = orderID;
		ItemID = itemID;
		this.replacement = replacement;
		this.relacementImage = relacementImage;
		
		this.itemImage =itemImage;
		this.itemname = itemname;
		itemPrice = ItemPrice;
		
		this.ret_itemImage=ret_itemImage;
		this.ret_itemname=ret_itemname;
		this.ret_itemPrice=ret_itemPrice;
	}

	public String getRet_itemImage() {
		return ret_itemImage;
	}

	public String getRet_itemname() {
		return ret_itemname;
	}

	public double getRet_itemPrice() {
		return ret_itemPrice;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public String getItemImage() {
		return itemImage;
	}

	public String getItemname() {
		return itemname;
	}

	public int getRequestID() {
		return RequestID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public String getCustomerReason() {
		return CustomerReason;
	}

	public String getEmp_note() {
		return Emp_note;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public String getStatus() {
		return status;
	}

	public int getOrderID() {
		return orderID;
	}

	public int getItemID() {
		return ItemID;
	}

	public int getReplacement() {
		return replacement;
	}

	public String getRelacementImage() {
		return relacementImage;
	}

}
