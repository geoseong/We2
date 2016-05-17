package com.we2.login.controller;

public class LoginCommand {

	private String userId;
	private String pwd;
	private boolean rememberUserid;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isRememberUserid() {
		return rememberUserid;
	}
	public void setRememberUserid(boolean rememberUserid) {
		this.rememberUserid = rememberUserid;
	}
	
	
}
