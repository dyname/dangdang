package com.wangxin.dang.pojos;

import java.io.Serializable;

public class Product implements Serializable{
	private int id;
	private String productName;
	private String description;
	private long addTime;
	private double fixedPrice;
	private double dangPrice;
	private double cha;
	private String keyWords;
	private int hasDeleted;
	private String productPic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getAddTime() {
		return addTime;
	}
	public void setAddTime(long addTime) {
		this.addTime = addTime;
	}
	public double getFixedPrice() {
		return fixedPrice;
	}
	public void setFixedPrice(double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	public double getDangPrice() {
		return dangPrice;
	}
	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public int getHasDeleted() {
		return hasDeleted;
	}
	public void setHasDeleted(int hasDeleted) {
		this.hasDeleted = hasDeleted;
	}
	public String getProductPic() {
		return productPic;
	}
	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}
	
	public double getCha() {
		return cha;
	}
	public void setCha(double cha) {
		this.cha = cha;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName
				+ ", description=" + description + ", addTime=" + addTime
				+ ", fixedPrice=" + fixedPrice + ", dangPrice=" + dangPrice
				+ ", keyWords=" + keyWords + ", hasDeleted=" + hasDeleted
				+ ", productPic=" + productPic + "]";
	}
	
}
