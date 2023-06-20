package com.jayasadha.shoppingcart_orderhandling;

public class ViewCart {
	
	private int cusID;
	private int itemID;
	private String ItemName;
	private double price;
	private String image;
	private int quantitty;
	
	public ViewCart(int cusID, int itemID, String itemName, double price, String image, int quantitty) {
		super();
		this.cusID = cusID;
		this.itemID = itemID;
		ItemName = itemName;
		this.price = price;
		this.image = image;
		this.quantitty = quantitty;
	}

	public int getCusID() {
		return cusID;
	}

	public int getItemID() {
		return itemID;
	}

	public String getItemName() {
		return ItemName;
	}

	public double getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public int getQuantitty() {
		return quantitty;
	}
	
	

}
