package com.jayasadha.shoppingcart_orderhandling;

public class OrderContain {

	private int itemID;
	private int orderID;
	private int returnCount;
	private int quantity;
	
	public OrderContain(int itemID, int orderID, int returnCount, int quantity) {
		super();
		this.itemID = itemID;
		this.orderID = orderID;
		this.returnCount = returnCount;
		this.quantity = quantity;
	}

	public int getItemID() {
		return itemID;
	}

	public int getOrderID() {
		return orderID;
	}

	public int getReturnCount() {
		return returnCount;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
	
}
