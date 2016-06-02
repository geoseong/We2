package com.we2.pjtMake;

public class PjtMemDelVO {
	private String name;
	private int pjtCode;
	private String userId;
	private String isLeader;
	
	
	public PjtMemDelVO(String name, int pjtCode, String userId, String isLeader) {
		super();
		this.name = name;
		this.pjtCode = pjtCode;
		this.userId = userId;
		this.isLeader = isLeader;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPjtCode() {
		return pjtCode;
	}
	public void setPjtCode(int pjtCode) {
		this.pjtCode = pjtCode;
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
	
	
}
