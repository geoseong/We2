package com.we2.sharepjtboard;

import java.util.Date;

public class PjtBoardBean {

	private int itemNum;
	private String itemTitle;
	private String userId;
	private Date itemDate;
	private int itemClick;
	private String itemPath;
	private String itemContent;
	

	public int getItemClick() {
		return itemClick;
	}
	public void setItemClick(int itemClick) {
		this.itemClick = itemClick;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getItemDate() {
		return itemDate;
	}
	public void setItemDate(Date itemDate) {
		this.itemDate = itemDate;
	}

	public String getItemPath() {
		return itemPath;
	}
	public void setItemPath(String itemPath) {
		this.itemPath = itemPath;
	}
	public String getItemContent() {
		return itemContent;
	}
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	
}