package com.wangxin.dang.pojos;

public class Address {
	private int id;
	private int userId;
	private String receiveName;
	private String fullAddress;
	private String postalCode;
	private String mobile;
	private String phone;
	public Address(){
	}
	
	public Address(int id, int userId, String receiveName, String fullAddress,
			String postalCode, String mobile, String phone) {
		this.id = id;
		this.userId = userId;
		this.receiveName = receiveName;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		this.mobile = mobile;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", receiveName="
				+ receiveName + ", fullAddress=" + fullAddress
				+ ", postalCode=" + postalCode + ", moblie=" + mobile
				+ ", phone=" + phone + "]\n";
	}
	
	
}
