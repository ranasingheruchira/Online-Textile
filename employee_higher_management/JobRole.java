package com.jayasadha.employee_higher_management;

public class JobRole {

	private int positionId;
	private String jobDescription;
	private String basicSalary;
	
	public JobRole() {
				
	}
	
	public JobRole(int positionId, String jobDescription, String basicSalary) {
		
		this.positionId = positionId;
		this.jobDescription = jobDescription;
		this.basicSalary = basicSalary;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}	
	
}
