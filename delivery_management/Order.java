package com.jayasadha.delivery_management;

public class Order {
	private int OrderId;
	private String OrderDate;
	private String AddLine1;
	private String AddLine2;
	private String AddLine3;
	private String DeliDate;
	private String DeliStatus;
	private int CustomerId;
	private String DeliPerson;
	private int CountDeli;
	
	public Order(int OrderId, String OrderDate, String AddLine1, String AddLine2, String AddLine3, 
			String DeliDate, String DeliStatus,int CustomerId,String DeliPerson) {
		
		this.OrderId = OrderId;
		this.OrderDate = OrderDate;
		this.AddLine1 = AddLine1;
		this.AddLine2 = AddLine2;
		this.AddLine3 = AddLine3;
		this.DeliDate = DeliDate;
		this.DeliStatus = DeliStatus;
		this.CustomerId = CustomerId;
		this.DeliPerson = DeliPerson;
		
	}
	
	public Order(String AddLine3, String DeliDate, String DeliStatus,String DeliPerson, int CountDeli) {
		
		this.AddLine3 = AddLine3;
		this.DeliDate = DeliDate;
		this.DeliStatus = DeliStatus;
		this.DeliPerson = DeliPerson;
		this.CountDeli = CountDeli;
	}
	
	public Order(int OrderId, String OrderDate, String AddLine1, String AddLine2, String AddLine3, int CustomerId,
			String DeliDate, String DeliStatus) {
		
		this.OrderId = OrderId;
		this.OrderDate = OrderDate;
		this.AddLine1 = AddLine1;
		this.AddLine2 = AddLine2;
		this.AddLine3 = AddLine3;
		this.CustomerId = CustomerId;
		this.DeliDate = DeliDate;
		this.DeliStatus = DeliStatus;
		
		
	}
	
	

	public int getOrderId() {
		return OrderId;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public String getAddLine1() {
		return AddLine1;
	}

	public String getAddLine2() {
		return AddLine2;
	}

	public String getAddLine3() {
		return AddLine3;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public String getDeliDate() {
		return DeliDate;
	}

	public String getDeliStatus() {
		return DeliStatus;
	}

	public String getDeliPerson() {
		return DeliPerson;
	}

	public int getCountDeli() {
		return CountDeli;
	}


	
		
}
