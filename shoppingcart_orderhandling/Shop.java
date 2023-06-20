package com.jayasadha.shoppingcart_orderhandling;

public class Shop {
	
	private int itemID;
	private String itemName;
	private double itemPrice;
	private String itemImage;
	
	public Shop(int itemID, String itemName, double itemPrice, String itemImage) {
	
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemImage = itemImage;
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
	
	

}
