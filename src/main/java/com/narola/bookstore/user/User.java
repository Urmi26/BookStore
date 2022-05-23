package com.narola.bookstore.user;

import java.util.Date;

import com.narola.bookstore.address.Address;

public class User {
	private int userId;
	private int userType;
	private String firstName;
	private String lastName;
	private int addressId;
	private long contact;
	private String emailId;
	private String password;
	private int otp;

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	private Date createdOn;
	private Date updatedOn;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User() {
	}

	public User(int userId) {
		this.userId = userId;
	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(int userType, String firstName, String lastName, int addressId, long contact, String emailId,
			String password) {
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressId = addressId;
		this.contact = contact;
		this.emailId = emailId;
		this.password = password;
	}

	public User(int userId, int userType, String firstName, String lastName, int addressId, long contact,
			String emailId, String password, int otp, Date createdOn, Date updatedOn) {
		this.userId = userId;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressId = addressId;
		this.contact = contact;
		this.emailId = emailId;
		this.password = password;
		this.otp = otp;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
