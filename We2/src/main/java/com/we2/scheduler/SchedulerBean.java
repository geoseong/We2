package com.we2.scheduler;

public class SchedulerBean {
	
	
	private int calendarmemo_num;
	private String pjtcode;
	private int calendarmemo_year;
	private int calendarmemo_month;
	private int calendarmemo_day;
	private String calendarmemo_contents;
	
	
	public SchedulerBean() {
		super();
	}
	
	public SchedulerBean(int calendarmemo_num, String pjtcode, int calendarmemo_year, int calendarmemo_month,
			int calendarmemo_day, String calendarmemo_contents) {
		super();
		this.calendarmemo_num = calendarmemo_num;
		this.pjtcode = pjtcode;
		this.calendarmemo_year = calendarmemo_year;
		this.calendarmemo_month = calendarmemo_month;
		this.calendarmemo_day = calendarmemo_day;
		this.calendarmemo_contents = calendarmemo_contents;
	}
	public int getCalendarmemo_num() {
		return calendarmemo_num;
	}
	public void setCalendarmemo_num(int calendarmemo_num) {
		this.calendarmemo_num = calendarmemo_num;
	}
	public String getPjtcode() {
		return pjtcode;
	}
	public void setPjtcode(String pjtcode) {
		this.pjtcode = pjtcode;
	}
	public int getCalendarmemo_year() {
		return calendarmemo_year;
	}
	public void setCalendarmemo_year(int calendarmemo_year) {
		this.calendarmemo_year = calendarmemo_year;
	}
	public int getCalendarmemo_month() {
		return calendarmemo_month;
	}
	public void setCalendarmemo_month(int calendarmemo_month) {
		this.calendarmemo_month = calendarmemo_month;
	}
	public int getCalendarmemo_day() {
		return calendarmemo_day;
	}
	public void setCalendarmemo_day(int calendarmemo_day) {
		this.calendarmemo_day = calendarmemo_day;
	}
	public String getCalendarmemo_contents() {
		return calendarmemo_contents;
	}
	public void setCalendarmemo_contents(String calendarmemo_contents) {
		this.calendarmemo_contents = calendarmemo_contents;
	}
	
	

}