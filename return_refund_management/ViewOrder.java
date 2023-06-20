package com.jayasadha.return_refund_management;

public class ViewOrder {
	
	//itemID
	//item image
	//price
	//quantity
	//return count
	
	private int ItemID;
	private String ItemImage;
	private double price;
	private int quantity;
	private int returnCount;
	private String ItemName;
	
	public ViewOrder(int itemID,String ItemName,String itemImage, double price, int quantity, int returnCount) {
		ItemID = itemID;
		ItemImage = itemImage;
		this.price = price;
		this.quantity = quantity;
		this.returnCount = returnCount;
		this.ItemName = ItemName;
	}

	public String getItemName() {
		return ItemName;
	}

	public int getItemID() {
		return ItemID;
	}

	public String getItemImage() {
		return ItemImage;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getReturnCount() {
		return returnCount;
	}
	
	
	
	
}
