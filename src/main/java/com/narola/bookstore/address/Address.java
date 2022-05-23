package com.narola.bookstore.address;

import java.util.Date;

public class Address {
	private int addressId;
	private String addressLine1;
	private String addressLine2;
	private String landmark;
	private String state;
	private int pincode;
	private String city;
	private String addressType;
	private Long mobile;
	private Date createdOn;
	private Date updatedOn;

	public Address() {
	}

	public Address(int addressId) {
		this.addressId = addressId;
	}

	public Address(String addressLine1, String addressLine2, String landmark, String state, int pincode, String city,
			String addressType) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.landmark = landmark;
		this.state = state;
		this.pincode = pincode;
		this.city = city;
		this.addressType = addressType;
	}

	public Address(int addressId, String addressLine1, String addressLine2, String landmark, String state, int pincode,
			String city, String addressType, Long mobile, Date createdOn, Date updatedOn) {
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.landmark = landmark;
		this.state = state;
		this.pincode = pincode;
		this.city = city;
		this.addressType = addressType;
		this.mobile=mobile;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
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
