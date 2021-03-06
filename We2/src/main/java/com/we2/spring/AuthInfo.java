package com.we2.spring;

import java.util.Date;

public class AuthInfo {

	private String userId;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private Date regDate;
	
	public AuthInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthInfo(String userId, String name, String email, String phone, String gender, Date regDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.regDate = regDate;
	}


	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
