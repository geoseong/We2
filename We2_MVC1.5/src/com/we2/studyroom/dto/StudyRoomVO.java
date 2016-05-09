package com.we2.studyroom.dto;

public class StudyRoomVO {
	private Integer rcode;
	private String rname;
	private String rlocation;
	private String rlocationdetail;
	private Integer rmember;
	private String rcontent;
	private String rpictureurl;

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
	public Integer getRmember() {
		return rmember;
	}
	public void setRmember(Integer rmember) {
		this.rmember = rmember;
	}
	public Integer getRcode() {
		return rcode;
	}
	public void setRcode(Integer rcode) {
		this.rcode = rcode;
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
	
	@Override
	public String toString() {
		return "StudyRoomVO [rname=" + rname + ", rlocation=" + rlocation + ", rlocationdetail=" + rlocationdetail
				+ ", rmember=" + rmember + ", rcode=" + rcode + ", rcontent=" + rcontent + ", rpictureurl=" + rpictureurl + "]";
	}
}
