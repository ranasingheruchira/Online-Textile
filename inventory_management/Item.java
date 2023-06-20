package com.jayasadha.inventory_management;

public class Item {

	
	private int  itemID;
	private String itemName;
	private String itemQuantity;
	private String itemBrand;
	private String itemCategory;
	private String itemDescription;
	private String itemColor;
	private String itemPrice;
	private String itemImage;
	
	
	public Item(int itemID, String itemName, String itemQuantity, String itemBrand, String itemCategory,
			String itemDescription, String itemColor, String itemPrice, String itemImage) {
	
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemBrand = itemBrand;
		this.itemCategory = itemCategory;
		this.itemDescription = itemDescription;
		this.itemColor = itemColor;
		this.itemPrice = itemPrice;
		this.itemImage = itemImage;
		
	}


	public int getItemID() {
		return itemID;
	}


	public String getItemName() {
		return itemName;
	}


	public String getItemQuantity() {
		return itemQuantity;
	}


	public String getItemBrand() {
		return itemBrand;
	}


	public String getItemCategory() {
		return itemCategory;
	}



	public String getItemDescription() {
		return itemDescription;
	}


	public String getItemColor() {
		return itemColor;
	}


	public String getItemPrice() {
		return itemPrice;
	}


	public String getItemImage() {
		return itemImage;
	}
	
}
