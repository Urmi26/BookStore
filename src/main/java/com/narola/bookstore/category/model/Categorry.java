package com.narola.bookstore.category.model;
import java.util.*;

public class Categorry {
	private int categoryId;
	private String categoryName;
	private Date createdOn;
	private Date updatedOn;

	public Categorry() {
	}

	public Categorry(int categoryId) {
		this.categoryId = categoryId;
	}

	public Categorry(String categoryName) {
		this.categoryName = categoryName;
	}

	public Categorry(int categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Categorry(int categoryId, String categoryName, Date createdOn, Date updatedOn) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedon(Date updatedon) {
		this.updatedOn = updatedon;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
