package com.sinda;

public class ApprovalDetails{

	public String ApprovalDetailId;
	public String Remarks;
	public ApprovalStatus ApprovalStatus;
    public EmployeeRegistration EmployeeRegistration; 
    

	
	public ApprovalStatus getApprovalStatus() {
		return ApprovalStatus;
	}
	public void setApprovalStatus(ApprovalStatus approvalStatus) {
		ApprovalStatus = approvalStatus;
	}
	public String getApprovalDetailId() {
		return ApprovalDetailId;
	}
	public void setApprovalDetailId(String approvalDetailId) {
		ApprovalDetailId = approvalDetailId;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public EmployeeRegistration getEmployeeRegistration() {
		return EmployeeRegistration;
	}
	public void setEmployeeRegistration(EmployeeRegistration employeeRegistration) {
		EmployeeRegistration = employeeRegistration;
	}
	@Override
	public String toString() {
		return "ApprovalDetails [ApprovalDetailId=" + ApprovalDetailId
				+ ", Remarks=" + Remarks + ", ApprovalStatus=" + ApprovalStatus
				+ ", EmployeeRegistration=" + EmployeeRegistration + "]";
	}
	
	
}
