package com.we2.board.community;

import org.springframework.stereotype.Repository;

@Repository
public class BoardBean {

	int cFindNum;
	String UserId;
	String cFindTitle;
	String cFindDate;
	int cFindClick;
	String cFindContent;
	
	public int getcFindNum() {
		return cFindNum;
	}
	public void setcFindNum(int cFindNum) {
		this.cFindNum = cFindNum;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getcFindTitle() {
		return cFindTitle;
	}
	public void setcFindTitle(String cFindTitle) {
		this.cFindTitle = cFindTitle;
	}
	public String getcFindDate() {
		return cFindDate;
	}
	public void setcFindDate(String cFindDate) {
		this.cFindDate = cFindDate;
	}
	public int getcFindClick() {
		return cFindClick;
	}
	public void setcFindClick(int cFindClick) {
		this.cFindClick = cFindClick;
	}
	public String getcFindContent() {
		return cFindContent;
	}
	public void setcFindContent(String cFindContent) {
		this.cFindContent = cFindContent;
	}
	
}
