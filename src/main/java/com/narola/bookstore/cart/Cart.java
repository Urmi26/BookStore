package com.narola.bookstore.cart;

import java.util.Date;

import com.narola.bookstore.book.model.Book;
import com.narola.bookstore.user.User;

public class Cart {
	private int cartId;
	private User user;
	private Book book;
	private int quantity;
	private double amount;
	@SuppressWarnings("unused")
	private double totalprice;
	private Date createdOn;	
	
	public Cart() {}
	
	public Cart(Book book,int quantity, double amount) {
		this.book=book;
		this.quantity=quantity;
		this.amount = amount;
	}
	
	public Cart(int cartId, User user, Book book, int quantity, double amount, Date createdOn)
	{
		this.cartId=cartId;
		this.user=user;
		this.book=book;
		this.quantity=quantity;
		this.amount = amount;
		this.createdOn=createdOn;
	}
	
	public Cart(int cartId, User user, int quantity,double amount, Date createdOn, Book book)
	{
		this.cartId=cartId;
		this.user=user;
		this.quantity=quantity;
		this.amount = amount;
		this.createdOn=createdOn;
		this.book=book;		
	}

	public Cart(int cartId, User user, Book book, int quantity, double amount, double totalprice, Date createdOn)
	{
		this.cartId=cartId;
		this.user=user;
		this.book=book;
		this.quantity=quantity;
		this.amount = amount;
		this.totalprice=quantity*amount;
		this.createdOn=createdOn;
	}

	public int getCartId() {
		return cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalprice() {
		return this.amount*this.quantity;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
