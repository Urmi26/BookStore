package com.narola.bookstore.msbookformat.model;

import java.util.Date;

public class MasterBookFormat {
	private int msBookId;
	private String msBookName;
	private Date createdOn;
	private Date updatedOn;
	
	private String[] msBookIdList;
	
	

	public String[] getMsBookIdList() {
		return msBookIdList;
	}

	public void setMsBookIdList(String[] msBookIdList) {
		this.msBookIdList = msBookIdList;
	}

	public MasterBookFormat() {
	}

	public MasterBookFormat(int msBookId) {
		this.msBookId = msBookId;
	}

	public MasterBookFormat(String msBookName) {
		this.msBookName = msBookName;
	}

	public MasterBookFormat(int msBookId, String msBookName) {
		this.msBookId = msBookId;
		this.msBookName = msBookName;
	}

	public MasterBookFormat(int msBookId, String msBookName, Date createdOn, Date updatedOn) {
		this.msBookId = msBookId;
		this.msBookName = msBookName;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public int getMsBookId() {
		return msBookId;
	}

	public void setMsBookId(int msBookId) {
		this.msBookId = msBookId;
	}

	public String getMsBookName() {
		return msBookName;
	}

	public void setMsBookName(String msBookName) {
		this.msBookName = msBookName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
