package com.we2.Login.controller;

public class LoginCommand {

	private String userid;
	private String pwd;
	private boolean rememberUserid;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
