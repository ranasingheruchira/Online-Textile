package com.jayasadha.shoppingcart_orderhandling;

import java.sql.Date;

public class Order {
	
	private int orderID;
	private Date orderDate;
	private String Address1;
	private String Address2;
	private String Address3;
	private Date deliveryDate;
	private String status;
	private int customer_id;
	private String deliveryPerson;
	
	public Order(int orderID, Date orderDate, String address1, String address2, String address3, Date deliveryDate,
			String status, int customer_id, String deliveryPerson) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		Address1 = address1;
		Address2 = address2;
		Address3 = address3;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.customer_id = customer_id;
		this.deliveryPerson = deliveryPerson;
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

	public String getStatus() {
		return status;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public String getDeliveryPerson() {
		return deliveryPerson;
	}
	
	
	
	

}
