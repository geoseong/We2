package com.we2.spring;

import java.util.Date;


public class Member {

	private String name;
	private String userId;
	private String pwd;
	private String pwd_confirm;
	private String phone;
	private String email;
	private String gender;
	private Date regDate;

	public Member() {
		super();
	}

	public Member(String userId, String name, String pwd, String pwd_confirm, String email, String phone, String gender,
			Date regDate) {
		super();
		this.name = name;
		this.userId = userId;
		this.pwd = pwd;
		this.pwd_confirm = pwd_confirm;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd_confirm() {
		return pwd_confirm;
	}
	public void setPwd_confirm(String pwd_confirm) {
		this.pwd_confirm = pwd_confirm;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public boolean matchPassword(String password) {
		return this.pwd.equals(password);//password하고 matchpassword하고 값이 맞는지 비교를 하고 다시 넘김!!
	}
}
