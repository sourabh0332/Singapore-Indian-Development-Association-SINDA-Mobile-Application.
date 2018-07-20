package com.sinda;

public class ScheduledTraining
	{
	    public String ScheduleTrainingId;
		public String ToDate;
		public String FromDate;
		public String TrainingFees;
		public String TotalDays;
		public String TotalHours;
		public Training Training;
    
		

		@Override
		public String toString() {
			return "ScheduledTraining [ScheduleTrainingId="
					+ ScheduleTrainingId + ", ToDate=" + ToDate + ", FromDate="
					+ FromDate + ", TrainingFees=" + TrainingFees
					+ ", TotalDays=" + TotalDays + ", TotalHours=" + TotalHours
					+ ", Training=" + Training + "]";
		}


		public String getScheduleTrainingId() {
			return ScheduleTrainingId;
		}
		public void setScheduleTrainingId(String scheduleTrainingId) {
			ScheduleTrainingId = scheduleTrainingId;
		}
		public String getToDate() {
			return ToDate;
		}
		public void setToDate(String toDate) {
			ToDate = toDate;
		}
		public String getFromDate() {
			return FromDate;
		}
		public void setFromDate(String fromDate) {
			FromDate = fromDate;
		}
		public String getTrainingFees() {
			return TrainingFees;
		}
		public void setTrainingFees(String trainingFees) {
			TrainingFees = trainingFees;
		}
		public String getTotalDays() {
			return TotalDays;
		}
		public void setTotalDays(String totalDays) {
			TotalDays = totalDays;
		}
		public String getTotalHours() {
			return TotalHours;
		}
		public void setTotalHours(String totalHours) {
			TotalHours = totalHours;
		}
		public Training getTraining() {
			return Training;
		}
		public void setTraining(Training training) {
			Training = training;
		}
		        
	}


