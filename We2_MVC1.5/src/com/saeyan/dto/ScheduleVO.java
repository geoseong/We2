package com.saeyan.dto;

public class ScheduleVO {
	
	private Integer calendarmemo_num;
	private Integer calendarmemo_year;
	private Integer calendarmemo_month;
	private Integer calendarmemo_day;
	private String calendarmemo_contents;
	private String calendarmemo_id;
	private String calendarmemo_passwd;
	private String pjtCode;
	

	public Integer getCalendarmemo_num() {
		return calendarmemo_num;
	}


	public void setCalendarmemo_num(Integer calendarmemo_num) {
		this.calendarmemo_num = calendarmemo_num;
	}


	public Integer getCalendarmemo_year() {
		return calendarmemo_year;
	}


	public void setCalendarmemo_year(Integer calendarmemo_year) {
		this.calendarmemo_year = calendarmemo_year;
	}


	public Integer getCalendarmemo_month() {
		return calendarmemo_month;
	}


	public void setCalendarmemo_month(Integer calendarmemo_month) {
		this.calendarmemo_month = calendarmemo_month;
	}


	public Integer getCalendarmemo_day() {
		return calendarmemo_day;
	}


	public void setCalendarmemo_day(Integer calendarmemo_day) {
		this.calendarmemo_day = calendarmemo_day;
	}


	public String getCalendarmemo_contents() {
		return calendarmemo_contents;
	}


	public void setCalendarmemo_contents(String calendarmemo_contents) {
		this.calendarmemo_contents = calendarmemo_contents;
	}


	public String getCalendarmemo_id() {
		return calendarmemo_id;
	}


	public void setCalendarmemo_id(String calendarmemo_id) {
		this.calendarmemo_id = calendarmemo_id;
	}


	public String getCalendarmemo_passwd() {
		return calendarmemo_passwd;
	}


	public void setCalendarmemo_passwd(String calendarmemo_passwd) {
		this.calendarmemo_passwd = calendarmemo_passwd;
	}


	public String getPjtCode() {
		return pjtCode;
	}


	public void setPjtCode(String pjtCode) {
		this.pjtCode = pjtCode;
	}


	@Override
	public String toString() {
		return "ScheduleVO [calendarmemo_num=" + calendarmemo_num + ", calendarmemo_year=" + calendarmemo_year
				+ ", calendarmemo_month=" + calendarmemo_month + ", calendarmemo_day=" + calendarmemo_day
				+ ", calendarmemo_contents=" + calendarmemo_contents + ", calendarmemo_id=" + calendarmemo_id
				+ ", calendarmemo_passwd=" + calendarmemo_passwd + "]";
	}
		
}