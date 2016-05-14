package com.we2.spring;

public class AuthInfo {

	private String userId;
	private String name;
	private String email;
	private String phone;
	private String gender;
	
	public AuthInfo(String userId, String name, String email, String phone, String gender) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}

	public String getUserId() {
		return userId;
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
