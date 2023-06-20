package com.jayasadha.return_refund_management;

import java.sql.Date;

public class Orders {
	
	private int orderID;
	private Date orderDate;
	private String Address1;
	private String Address2;
	private String Address3;
	private Date deliveryDate;
	private String deliveryStatus;
	private int cusID;
	private String orderType;
	
	public Orders(int orderID, Date orderDate, String address1, String address2, String address3, Date deliveryDate,String deliveryStatus, int cusID, String orderType) {
		
		this.orderID = orderID;
		this.orderDate = orderDate;
		Address1 = address1;
		Address2 = address2;
		Address3 = address3;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
		this.cusID = cusID;
		this.orderType = orderType;
	}

	//getters
	
	public String getOrderType() {
		return orderType;
	}

	public int getOrderID() {
		return orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public String getAddress1() {
		return Address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public String getAddress3() {
		return Address3;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public int getCusID() {
		return cusID;
	}


}
