package com.jayasadha.return_refund_management;

public class Replacement {
	
	double price;
	String name;
	int ID;
	String image;
	
	public Replacement(double price, String name, int iD, String image) {
		this.price = price;
		this.name = name;
		ID = iD;
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return ID;
	}

	public String getImage() {
		return image;
	}

}
