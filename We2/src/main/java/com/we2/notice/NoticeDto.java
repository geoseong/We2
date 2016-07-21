package com.we2.notice;

import java.sql.Timestamp;

public class NoticeDto {

	private int num;
	private String title;
	private String writer;
	private String content;
	private String writedate;
	private int pjtCode ;
	
	public NoticeDto() {
	}

	public NoticeDto(int num, String title, String writer, String content, String writedate, int pjtCode) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.writedate = writedate;
		this.pjtCode = pjtCode;
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

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public int getPjtcode() {
		return pjtCode;
	}

	public void setPjtcode(int pjtCode) {
		this.pjtCode = pjtCode;
	}
	
	
	
}
