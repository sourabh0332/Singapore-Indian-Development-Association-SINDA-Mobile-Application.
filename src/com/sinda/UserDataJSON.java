package com.sinda;

public class UserDataJSON {
String EmployeeId;
String Group;
String IsValid;


public UserDataJSON() {
	super();
}
public UserDataJSON(String employeeId, String group, String isValid) {
	super();
	EmployeeId = employeeId;
	Group = group;
	IsValid = isValid;
}
public String getEmployeeId() {
	return EmployeeId;
}
public void setEmployeeId(String employeeId) {
	EmployeeId = employeeId;
}
public String getGroup() {
	return Group;
}
public void setGroup(String group) {
	Group = group;
}
public String getIsValid() {
	return IsValid;
}
public void setIsValid(String isValid) {
	IsValid = isValid;
}
@Override
public String toString() {
	return "UserDataJSON [EmployeeId=" + EmployeeId + ", Group=" + Group
			+ ", IsValid=" + IsValid + "]";
}



}
