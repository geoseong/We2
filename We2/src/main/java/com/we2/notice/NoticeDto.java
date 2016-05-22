package com.we2.notice;

import java.sql.Timestamp;

public class NoticeDto {

	private int num;
	private String title;
	private String writer;
	private String content;
	private Timestamp writedate;
	
	public NoticeDto() {
		
	}
	
	public NoticeDto(int num, String title, String writer, String content, Timestamp writedate) {
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.writedate = writedate;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
}
