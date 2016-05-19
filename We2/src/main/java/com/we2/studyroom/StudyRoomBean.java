package com.we2.studyroom;

public class StudyRoomBean {

	private int rcode;
	private String rname;
	private String rlocation;
	private String rlocationdetail;
	private int rmember;
	private String rcontent;
	private String rpictureurl;



	public int getRcode() {
		return rcode;
	}
	public void setRcode(int rcode) {
		this.rcode = rcode;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRlocation() {
		return rlocation;
	}
	public void setRlocation(String rlocation) {
		this.rlocation = rlocation;
	}
	public String getRlocationdetail() {
		return rlocationdetail;
	}
	public void setRlocationdetail(String rlocationdetail) {
		this.rlocationdetail = rlocationdetail;
	}
	public int getRmember() {
		return rmember;
	}
	public void setRmember(int rmember) {
		this.rmember = rmember;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRpictureurl() {
		return rpictureurl;
	}
	public void setRpictureurl(String rpictureurl) {
		this.rpictureurl = rpictureurl;
	}
	public StudyRoomBean() {
		super();
	}

	public StudyRoomBean(int rcode, String rname, String rlocation, String rlocationdetail, int rmember,
			String rcontent, String rpictureurl) {
		super();
		this.rcode = rcode;
		this.rname = rname;
		this.rlocation = rlocation;
		this.rlocationdetail = rlocationdetail;
		this.rmember = rmember;
		this.rcontent = rcontent;
		this.rpictureurl = rpictureurl;
		
	}
}