package com.we2.file;

public class FileBean {

	private int fcode;
	private int pjtCode; 
	private String userId;
	private String fname;
	private String fileurl;
	private String fdate;
	
	
	public FileBean() {
		super();
	}

	public FileBean(int fcode, int pjtCode, String userId, String fname, String fileurl, String fdate) {
		super();
		this.fcode = fcode;
		this.pjtCode = pjtCode;
		this.userId = userId;
		this.fname = fname;
		this.fileurl = fileurl;
		this.fdate = fdate;
	}

	public int getFcode() {
		return fcode;
	}

	public void setFcode(int fcode) {
		this.fcode = fcode;
	}

	public int getPjtCode() {
		return pjtCode;
	}

	public void setPjtCode(int pjtCode) {
		this.pjtCode = pjtCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	
	

}
