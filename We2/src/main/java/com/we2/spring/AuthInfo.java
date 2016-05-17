package com.we2.spring;

public class AuthInfo {

	private String userid;
	private String name;
	private String email;
	private String phone;
	private String gender;
	
	
	
	
	public AuthInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthInfo(String userid, String name, String email, String phone, String gender) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
