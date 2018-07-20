package com.sinda;  


public class Training 
	{	public String TrainingName;
		public Competency Competency;
        public String Status;
	
        public String getTrainingName() {
			return TrainingName;
		}
		public void setTrainingName(String trainingName) {
			TrainingName = trainingName;
		}
		public Competency getCompetency() {
			return Competency;
		}
		public void setCompetency(Competency competency) {
			Competency = competency;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		@Override
		public String toString() {
			return "Training [TrainingName=" + TrainingName + ", Competency="
					+ Competency + ", Status=" + Status + "]";
		}
		
		
}

