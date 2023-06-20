package com.jayasadha.delivery_management;

public class AddDeliveryPerson {
	private int LocId;
	private int DeliveryPersonID;
	private String AssignedDate;
	
	public AddDeliveryPerson(int LocId, int DeliveryPersonID, String AssignedDate) {
	
		this.LocId = LocId;
		this.DeliveryPersonID = DeliveryPersonID;
		this.AssignedDate = AssignedDate;
	}

	public int getLocId() {
		return LocId;
	}

	public int getDeliveryPersonID() {
		return DeliveryPersonID;
	}

	public String getAssignedDate() {
		return AssignedDate;
	}

	

}
