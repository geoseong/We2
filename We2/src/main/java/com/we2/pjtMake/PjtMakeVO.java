package com.we2.pjtMake;

import java.util.Calendar;
import java.util.Date;

public class PjtMakeVO {
	
	private int pjtCode;
	private String pjtName;
	private String pjtClassify;
	private String startDate;
	private String endDate;
	
	public PjtMakeVO(){
	}
	//»ý¼ºÀÚ
	public PjtMakeVO(String pjtName, String pjtClassify, String startDate, String endDate) {
		this.pjtName = pjtName;
		this.pjtClassify = pjtClassify;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public int getPjtCode() {
		return pjtCode;
	}
	public void setPjtCode(int pjtCode) {
		this.pjtCode = pjtCode;
	}
	public String getPjtName() {
		return pjtName;
	}
	public void setPjtName(String pjtName) {
		this.pjtName = pjtName;
	}
	public String getPjtClassify() {
		return pjtClassify;
	}
	public void setPjtClassify(String pjtClassify) {
		this.pjtClassify = pjtClassify;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
