package com.sinda;


public class Report
{
    public String TrainingName;
    public String TrainingProvider;
    public int TotalDays;
    public int NoOfEmployees;
    public String FromDate;
    public String ToDate;
	
    @Override
	public String toString() {
		return "Reports [TrainingName=" + TrainingName
				+ ", TrainingProvider=" + TrainingProvider + ", TotalDays="
				+ TotalDays + ", NoOfEmployees=" + NoOfEmployees
				+ ", FromDate=" + FromDate + ", ToDate=" + ToDate + "]";
	}
	public String getTrainingName() {
		return TrainingName;
	}
	public void setTrainingName(String trainingName) {
		TrainingName = trainingName;
	}
	public String getTrainingProvider() {
		return TrainingProvider;
	}
	public void setTrainingProvider(String trainingProvider) {
		TrainingProvider = trainingProvider;
	}
	public int getTotalDays() {
		return TotalDays;
	}
	public void setTotalDays(int totalDays) {
		TotalDays = totalDays;
	}
	public int getNoOfEmployees() {
		return NoOfEmployees;
	}
	public void setNoOfEmployees(int noOfEmployees) {
		NoOfEmployees = noOfEmployees;
	}
	public String getFromDate() {
		return FromDate;
	}
	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}
	public String getToDate() {
		return ToDate;
	}
	public void setToDate(String toDate) {
		ToDate = toDate;
	}
    
    
    
}

