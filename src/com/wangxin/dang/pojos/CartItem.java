package com.wangxin.dang.pojos;

public class CartItem {
	private int id;
	private int orderId;
	private int productId;
	private String productName;
	private double dangPrice;
	private double fixedPrice;
	private int productNum;
	private double amount;
	private double cha;
	private double oneCha;
	private int status;
	public CartItem(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getDangPrice() {
		return dangPrice;
	}
	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}
	public double getFixedPrice() {
		return fixedPrice;
	}
	public void setFixedPrice(double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getCha() {
		return cha;
	}
	public void setCha(double cha) {
		this.cha = cha;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public double getOneCha() {
		return oneCha;
	}
	public void setOneCha(double oneCha) {
		this.oneCha = oneCha;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", orderId=" + orderId + ", productId="
				+ productId + ", productName=" + productName + ", dangPrice="
				+ dangPrice + ", fixedPrice=" + fixedPrice + ", productNum="
				+ productNum + ", amount=" + amount + ", cha=" + cha
				+ ", status=" + status + "]";
	}

}
