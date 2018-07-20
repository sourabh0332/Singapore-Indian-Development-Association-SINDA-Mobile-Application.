package com.sinda;

import java.util.*;

public class EmployeeJSON {
	String status;
	ArrayList<Employee> trainingsApprovals;

	public EmployeeJSON() {
		super();
	}

	public EmployeeJSON(String status, ArrayList<Employee> trainingsApprovals) {
		super();
		this.status = status;
		this.trainingsApprovals = trainingsApprovals;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Employee> getTrainingsApprovals() {
		return trainingsApprovals;
	}

	public void setTraininsgApprovals(ArrayList<Employee> trainingApproval) {
		this.trainingsApprovals = trainingApproval;
	}

	@Override
	public String toString() {
		return "EmployeeJSON [status=" + status + ", trainingsApprovals="
				+ trainingsApprovals + "]";
	}

}
