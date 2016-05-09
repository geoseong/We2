package com.we2.project.dto;

import java.util.Date;

public class ProjectVO {
	private int pjtno;
	private String pjtname;
	private int classify;
	private String userid;
	private Date start;
	private Date end;
	
	
	public int getPjtno() {
		return pjtno;
	}
	public void setPjtno(int pjtno) {
		this.pjtno = pjtno;
	}
	public String getPjtname() {
		return pjtname;
	}
	public void setPjtname(String pjtname) {
		this.pjtname = pjtname;
	}
	public int getClassify() {
		return classify;
	}
	public void setClassify(int classify) {
		this.classify = classify;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
		
}
