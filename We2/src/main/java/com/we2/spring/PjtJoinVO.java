package com.we2.spring;

public class PjtJoinVO {
	
	private String pjtcode;
	private String userId;
	private String isLeader;
	private String pjtCode;
	private String pjtName;
	private String pjtClassify;
	private String startDate;
	private String endDate;
	
	public PjtJoinVO(String pjtcode, String userId, String isLeader, String pjtCode2, String pjtName,
			String pjtClassify, String startDate, String endDate) {
		super();
		this.pjtcode = pjtcode;
		this.userId = userId;
		this.isLeader = isLeader;
		pjtCode = pjtCode2;
		this.pjtName = pjtName;
		this.pjtClassify = pjtClassify;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getPjtcode() {
		return pjtcode;
	}

	public void setPjtcode(String pjtcode) {
		this.pjtcode = pjtcode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIsLeader() {
		return isLeader;
	}

	public void setIsLeader(String isLeader) {
		this.isLeader = isLeader;
	}

	public String getPjtCode() {
		return pjtCode;
	}

	public void setPjtCode(String pjtCode) {
		this.pjtCode = pjtCode;
	}

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
