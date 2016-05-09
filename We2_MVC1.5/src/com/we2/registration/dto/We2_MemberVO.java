package com.we2.registration.dto;

public class We2_MemberVO {
	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String sub_email;
	private String phone;
	private int gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSub_email() {
		return sub_email;
	}

	public void setSub_email(String sub_email) {
		this.sub_email = sub_email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "We2VO [name=" + name + ", userid=" + userid + ", pwd=" + pwd + ", email=" + email + ", sub_email="
				+ sub_email + ", phone=" + phone + ", gender=" + gender + "]";
	}
}
