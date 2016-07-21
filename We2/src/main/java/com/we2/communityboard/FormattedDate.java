package com.we2.communityboard;

public class FormattedDate {

	private int itemNum;
	private String itemTitle;
	private String userId;
	private String itemDate;
	private int itemClick;
	private String itemPath;
	private String itemContent;
	
	
	public FormattedDate() {
		super();
	}

	//The constructor FormattedDate(int, String, String, Date, int, String, String) is undefined
	public FormattedDate(int itemNum, String itemTitle, String userId, String itemDate, int itemClick,
			String itemPath, String itemContent) {
		super();
		this.itemNum = itemNum;
		this.itemTitle = itemTitle;
		this.userId = userId;
		this.itemDate = itemDate;
		this.itemClick = itemClick;
		this.itemPath = itemPath;
		this.itemContent = itemContent;
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


	public String getItemDate() {
		return itemDate;
	}


	public void setItemDate(String itemDate) {
		this.itemDate = itemDate;
	}


	public int getItemClick() {
		return itemClick;
	}


	public void setItemClick(int itemClick) {
		this.itemClick = itemClick;
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
