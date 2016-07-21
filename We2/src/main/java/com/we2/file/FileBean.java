package com.we2.file;
import java.util.Date;

public class FileBean {

	private int fcode;
	private String fname;
	private String fileurl;
	private int pjtCode; 
	private Date fdate;
	
	
	
	public int getPjtCode() {
		return pjtCode;
	}

	public void setPjtCode(int pjtCode) {
		this.pjtCode = pjtCode;
	}

	public int getFcode() {
		return fcode;
	}

	public void setFcode(int fcode) {
		this.fcode = fcode;
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

	public Date getFdate() {
		return fdate;
	}

	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}

	public FileBean() {
		super();
	}

	public FileBean(int fcode, String fname, String fileurl, Date fdate) {
		super();
		this.fcode = fcode;
		this.fname = fname;
		this.fileurl = fileurl;
		this.fdate = fdate;
	}


}
