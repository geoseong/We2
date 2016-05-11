package com.we2.registration;

import java.util.Date;

public class Member {

	private String userid;
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

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
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

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}
	

	public Date getRegDate() {
		return regDate;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!pwd.equals(oldPassword))
			throw new IdPasswordNotMatchingException();
		this.pwd = newPassword;
	}

	public boolean matchPassword(String pwd) {
		return this.pwd.equals(pwd);
	}

}
