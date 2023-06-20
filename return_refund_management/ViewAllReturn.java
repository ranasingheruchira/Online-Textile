package com.jayasadha.return_refund_management;

import java.sql.Date;

public class ViewAllReturn {
	
	private int requestID;
	private Date requestDate;
	private String requestStatus;
	private int customerID;
	private String cusFname;
	private String cusLname;
	private String cusEmail;
	private String cusPhone;
	private String cusAddress1;
	private String cusAddress2;
	private String cusAddress3;
	private int orderID;
	private Date orderDate;
	private Date deliveryDate;
	private int itemID;
	private String itemName;
	private double itemPrice;
	private String itemImage;
	private int reolacementID;
	private String replacementName;
	private double replacementPrice;
	private String replacementImage;
	private String cusReason;
	private String empNote;
	private String evidenceImage;
	
	public ViewAllReturn(int requestID, Date requestDate, String requestStatus, int customerID, String cusFname,
			String cusLname, String cusEmail, String cusPhone, String cusAddress1, String cusAddress2,
			String cusAddress3, int orderID, Date orderDate, Date deliveryDate, int itemID, String itemName,
			double itemPrice, String itemImage, int reolacementID, String replacementName, double replacementPrice,
			String replacementImage, String cusReason, String empNote, String evidenceImage) {

		this.requestID = requestID;
		this.requestDate = requestDate;
		this.requestStatus = requestStatus;
		this.customerID = customerID;
		this.cusFname = cusFname;
		this.cusLname = cusLname;
		this.cusEmail = cusEmail;
		this.cusPhone = cusPhone;
		this.cusAddress1 = cusAddress1;
		this.cusAddress2 = cusAddress2;
		this.cusAddress3 = cusAddress3;
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemImage = itemImage;
		this.reolacementID = reolacementID;
		this.replacementName = replacementName;
		this.replacementPrice = replacementPrice;
		this.replacementImage = replacementImage;
		this.cusReason = cusReason;
		this.empNote = empNote;
		this.evidenceImage = evidenceImage;
		
	}

	public int getRequestID() {
		return requestID;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getCusFname() {
		return cusFname;
	}

	public String getCusLname() {
		return cusLname;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public String getCusPhone() {
		return cusPhone;
	}

	public String getCusAddress1() {
		return cusAddress1;
	}

	public String getCusAddress2() {
		return cusAddress2;
	}

	public String getCusAddress3() {
		return cusAddress3;
	}

	public int getOrderID() {
		return orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public int getItemID() {
		return itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public String getItemImage() {
		return itemImage;
	}

	public int getReolacementID() {
		return reolacementID;
	}

	public String getReplacementName() {
		return replacementName;
	}

	public double getReplacementPrice() {
		return replacementPrice;
	}

	public String getReplacementImage() {
		return replacementImage;
	}

	public String getCusReason() {
		return cusReason;
	}

	public String getEmpNote() {
		return empNote;
	}

	public String getEvidenceImage() {
		return evidenceImage;
	}
	
	
	

}
