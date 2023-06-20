package com.jayasadha.shoppingcart_orderhandling;

public class Item {
	
	private int ItemID;
	private String ItemName;
	private int itemQuantitty;
	private String ItemBrand;
	private String ItmCategory;
	private  String ItemDescription;
	private String ItemColour;
	private double itemPrice;
	private String itemImage;
	
	public Item(int itemID, String itemName, int itemQuantitty, String itemBrand, String itmCategory,
			String itemDescription, String itemColour, double itemPrice, String itemImage) {
		super();
		ItemID = itemID;
		ItemName = itemName;
		this.itemQuantitty = itemQuantitty;
		ItemBrand = itemBrand;
		ItmCategory = itmCategory;
		ItemDescription = itemDescription;
		ItemColour = itemColour;
		this.itemPrice = itemPrice;
		this.itemImage = itemImage;
	}

	public int getItemID() {
		return ItemID;
	}

	public String getItemName() {
		return ItemName;
	}

	public int getItemQuantitty() {
		return itemQuantitty;
	}

	public String getItemBrand() {
		return ItemBrand;
	}

	public String getItmCategory() {
		return ItmCategory;
	}

	public String getItemDescription() {
		return ItemDescription;
	}

	public String getItemColour() {
		return ItemColour;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public String getItemImage() {
		return itemImage;
	}
	
	

}
