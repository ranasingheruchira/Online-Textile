package com.jayasadha.delivery_management;

public class Location {

	private int locId;
	private String locName;
	private String locCharge;
	
	public Location(int locId, String locName, String locCharge) {
		
		this.locId = locId;
		this.locName = locName;
		this.locCharge = locCharge;
	}

	public int getLocationId() {
		return locId;
	}

	
	public String getLocationName() {
		return locName;
	}

	public String getLocationCharge() {
		return locCharge;
	}
	
}