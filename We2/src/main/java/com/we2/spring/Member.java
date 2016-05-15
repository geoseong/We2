package com.we2.spring;

import java.util.Date;

public class Member {

	private String userId;
	private String name;
	private String pwd;
	private String email;
	private String phone;
	private String gender;
	private Date regDate;


	public Member(String name, String pwd, String email, String phone, String gender, Date regDate) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.regDate = regDate;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public Date getRegDate() {
		return regDate;
	}

	public boolean matchPassword(String pwd) {
		return this.pwd.equals(pwd);
	}

	public void memberupdate(String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		
	}

	public void changePassword(String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		
	}
}
