package com.sinda;

public class Constants {
	static String UserName;
	static String empId;
	static String empGroup;

	public static String getUserName() {
		return UserName;
	}

	public static void setUserName(String userName) {
		UserName = userName;
	}

	public static String getEmpId() {
		return empId;
	}

	public static void setEmpId(String empId) {
		Constants.empId = empId;
	}

	public static String getEmpGroup() {
		return empGroup;
	}

	public static void setEmpGroup(String empGroup) {
		Constants.empGroup = empGroup;
	}

}
