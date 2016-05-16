package com.we2.willwork;


public class WillWorkVO {
	String userId;
	int pjtCode;
	String doWork;
	String doneWork;
	String stateWork;
	String name;
	
	
	public WillWorkVO(String userId, int pjtCode, String doWork, String doneWork, String stateWork, String name) {
		super();
		this.userId = userId;
		this.pjtCode = pjtCode;
		this.doWork = doWork;
		this.doneWork = doneWork;
		this.stateWork = stateWork;
		this.name = name;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPjtCode() {
		return pjtCode;
	}
	public void setPjtCode(int pjtCode) {
		this.pjtCode = pjtCode;
	}
	public String getDoWork() {
		return doWork;
	}
	public void setDoWork(String doWork) {
		this.doWork = doWork;
	}
	public String getDoneWork() {
		return doneWork;
	}
	public void setDoneWork(String doneWork) {
		this.doneWork = doneWork;
	}
	public String getStateWork() {
		return stateWork;
	}
	public void setStateWork(String stateWork) {
		this.stateWork = stateWork;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
