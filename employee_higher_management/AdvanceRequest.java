package com.jayasadha.employee_higher_management;

public class AdvanceRequest {

	private int RequestID;
	private int EmpID;
	private String RequestedDate;
	private String RequiredDate;
	private String AdvanceAmount;
	private String Reason;
	private String RqStatus;
	
	public AdvanceRequest(int requestID, int empID, String requestedDate, String requiredDate, String advanceAmount,
			String reason, String rqStatus) {
		
		RequestID = requestID;
		EmpID = empID;
		RequestedDate = requestedDate;
		RequiredDate = requiredDate;
		AdvanceAmount = advanceAmount;
		Reason = reason;
		RqStatus = rqStatus;
	}

	public int getRequestID() {
		return RequestID;
	}

	public int getEmpID() {
		return EmpID;
	}

	public String getRequestedDate() {
		return RequestedDate;
	}

	public String getRequiredDate() {
		return RequiredDate;
	}

	public String getAdvanceAmount() {
		return AdvanceAmount;
	}

	public String getReason() {
		return Reason;
	}

	public String getRqStatus() {
		return RqStatus;
	}
	
}
