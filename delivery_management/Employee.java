package com.jayasadha.delivery_management;

public class Employee {
	int EmpId;
	String Enic;
	String Edob;
	String PositionId;
	
	public Employee(int EmpId, String Enic, String Edob, String PositionId) {
		
		this.EmpId = EmpId;
		this.Enic = Enic;
		this.Edob = Edob;
		this.PositionId = PositionId;
	}

	public int getEmpId() {
		return EmpId;
	}

	public String getEnic() {
		return Enic;
	}

	public String getEdob() {
		return Edob;
	}

	public String getPositionId() {
		return PositionId;
	}

}
