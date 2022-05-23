package com.narola.bookstore.order;

import java.util.Date;

import com.narola.bookstore.address.Address;
import com.narola.bookstore.user.User;

public class Order {
	private int orderId;
	private User user;
	private Address address;
	private Date orderDate;
	private double totalAmount;
	private String OrderStatus;
	private Date createdOn;
	private Date updatedOn;
	
	public Order(){}
	
	public Order(int orderId) {
		this.orderId=orderId;
	}
	
	public Order(User user, Address address, Date orderDate, double totalAmount, String orderStatus,
			Date createdOn, Date updatedOn) {
		this.user = user;
		this.address = address;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		OrderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
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
