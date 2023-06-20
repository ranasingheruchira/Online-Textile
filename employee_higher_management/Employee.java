package com.jayasadha.employee_higher_management;

public class Employee {
	
	private int eid;
	private String nic;
	private String dob;
	private String positionid;
	
	public Employee(int eid, String nic, String dob, String positionid) {
		this.eid = eid;
		this.nic = nic;
		this.dob = dob;
		this.positionid = positionid;
	}
	
	public Employee(int eid, String positionid) {
		this.eid = eid;		
		this.positionid = positionid;
	}

	public int getId() {
		return eid;
	}

	public String getNic() {
		return nic;
	}

	public String getDob() {
		return dob;
	}

	public String getPositionid() {
		return positionid;
	}
	
}
