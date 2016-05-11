package com.we2.registration;

public class AuthInfo {

	private String userid;
	private String name;
	private String email;
	private String phone;
	private String gender;
	
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

	public String getName() {
		return name;
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
	
	
}
