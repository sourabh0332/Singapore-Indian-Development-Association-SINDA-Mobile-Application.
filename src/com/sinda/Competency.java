package com.sinda;

public class Competency {

	public String CompetencyId;
	public String CompetencyName;
	public String Status;

	public String getCompetencyId() {
		return CompetencyId;
	}
	public void setCompetencyId(String competencyId) {
		CompetencyId = competencyId;
	}
	public String getCompetencyName() {
		return CompetencyName;
	}
	public void setCompetencyName(String competencyName) {
		CompetencyName = competencyName;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Competency [CompetencyId=" + CompetencyId + ", CompetencyName="
				+ CompetencyName + ", Status=" + Status + "]";
	}

	
}
