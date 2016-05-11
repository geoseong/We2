package com.we2.pjtMake;

public class PjtMakeVO {
	
	String userId = null;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	int pjtCode = 0;
	public int getPjtCode() {
		return pjtCode;
	}
	public void setPjtCode(int pjtCode) {
		this.pjtCode = pjtCode;
	}
	String pjtName = null;
	String pjtClassify = null;
	String startDate = null;
	String endDate = null;

	public String getPjtName() {
		return pjtName;
	}
	public void setPjtName(String pjtName) {
		this.pjtName = pjtName;
	}
	public String getPjtClassify() {
		return pjtClassify;
	}
	public void setPjtClassify(String pjtClassify) {
		this.pjtClassify = pjtClassify;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
