package com.sinda;

import java.util.List;

public class Employee
	{
	    public String EmpId	;
        public String EmpName ;
        public String Email;
        public String BudgetAmount;
		
		public String getEmpId() {
			return EmpId;
		}
		public void setEmpId(String empId) {
			EmpId = empId;
		}
		public String getEmpName() {
			return EmpName;
		}
		public void setEmpName(String empName) {
			EmpName = empName;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getBudgetAmount() {
			return BudgetAmount;
		}
		public void setBudgetAmount(String budgetAmount) {
			BudgetAmount = budgetAmount;
		}
		@Override
		public String toString() {
			return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName
					+ ", Email=" + Email + ", BudgetAmount=" + BudgetAmount
					+ "]";
		}
		
		
}

