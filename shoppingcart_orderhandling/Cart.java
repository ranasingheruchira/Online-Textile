package com.jayasadha.shoppingcart_orderhandling;

public class Cart {

	private int cusID;
	private int itemId;
	private int quantity;
	
	public Cart(int cusID, int itemId, int quantity) {
		super();
		this.cusID = cusID;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	public int getCusID() {
		return cusID;
	}
	public int getItemId() {
		return itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	
	
	
}
