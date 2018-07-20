package com.sinda;

import java.util.List;

public class EmployeeRegistration
	{
		public ScheduledTraining ScheduledTraining;
        public Employee Employee;
        
		public ScheduledTraining getScheduledTraining() {
			return ScheduledTraining;
		}
		public void setScheduledTraining(ScheduledTraining scheduledTraining) {
			ScheduledTraining = scheduledTraining;
		}
		public Employee getEmployee() {
			return Employee;
		}
		public void setEmployee(Employee employee) {
			Employee = employee;
		}
		@Override
		public String toString() {
			return "EmployeeRegistration [ScheduledTraining="
					+ ScheduledTraining + ", Employee=" + Employee + "]";
		}
		
		
}

