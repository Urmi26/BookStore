package com.narola.bookstore.book.model;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;

public class Book {
	private int bookId;
	private String bookName;
	private String authorName;
	private String description;
	private double amount;
	private int categoryId;
	private String publisherName;
	private InputStream img;
	private Date createdOn;
	private Date updatedOn;
	private List<String> imagesPathList;
	
	public Categorry category;
	public MasterBookFormat masterBookFormat;
	public List<MasterBookFormat> masterBookFormatt;

	public List<MasterBookFormat> getMasterBookFormatt() {
		return masterBookFormatt;
	}

	public void setMasterBookFormatt(List<MasterBookFormat> masterBookFormatt) {
		this.masterBookFormatt = masterBookFormatt;
	}

	public void setCategory(Categorry category) {
		this.category = category;
	}

	public Book() {
	}
	
	public Book(int bookId) {
		this.bookId = bookId;
	}

	public Book(String bookName) {
		this.bookName = bookName;
	}

	public Book(int bookId, String bookName) {
		this.bookId = bookId;
		this.bookName = bookName;
	}

	public Book(MasterBookFormat masterBookFormat) {
		this.masterBookFormat = masterBookFormat;
	}

	public Book(int bookId, String bookName, String authorName, String description, int categoryId,
			String publisherName) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
		this.categoryId = categoryId;
		this.publisherName = publisherName;
	}

	public Book(int bookId, String bookName, String authorName, String description, double amount, int categoryId,
			String publisherName) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
		this.amount = amount;
		this.categoryId = categoryId;
		this.publisherName = publisherName;

	}

	public Book(int bookId, String bookName, String authorName, String description, double amount, int categoryId,
			String publisherName, MasterBookFormat masterBookFormat) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
		this.amount = amount;
		this.categoryId = categoryId;
		this.publisherName = publisherName;
		this.masterBookFormat = masterBookFormat;

	}

	public Book(int bookId, String bookName, String authorName, String description, double amount, int categoryId,
			String publisherName, Date createdOn, Date updatedOn) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
		this.amount = amount;
		this.categoryId = categoryId;
		this.publisherName = publisherName;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Book(int bookId, String bookName, String authorName, String description, double amount, int categoryId,
			String publisherName, Date createdOn, Date updatedOn, Categorry category) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
		this.amount = amount;
		this.categoryId = categoryId;
		this.publisherName = publisherName;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.category = category;
	}

	public Book(int bookId, String bookName, String authorName, String description, double amount, String publisherName,
			Categorry category) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
		this.amount = amount;
		this.publisherName = publisherName;
		this.category = category;
	}

	public Book(int bookId, String bookName, String authorName, String description, double amount, int categoryId,
			String publisherName, Date createdOn, Date updatedOn, Categorry category,
			MasterBookFormat masterBookFormat) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
		this.amount = amount;
		this.categoryId = categoryId;
		this.publisherName = publisherName;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.category = category;
		this.masterBookFormat = masterBookFormat;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public InputStream getImg() {
		return img;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Categorry getCategory() {
		return category;
	}

	public void setCat(Categorry category) {
		this.category = category;
	}

	public List<String> getImagesPathList() {
		return imagesPathList;
	}

	public void setImagesPathList(List<String> imagesPathList) {
		this.imagesPathList = imagesPathList;
	}

	public MasterBookFormat getMasterBookFormat() {
		return masterBookFormat;
	}

	public void setMasterBookFormat(MasterBookFormat masterBookFormat) {
		this.masterBookFormat = masterBookFormat;
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
