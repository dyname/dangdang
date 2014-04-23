package com.wangxin.dang.pojos;

public class Category {
	private int parentId;
	private int id;
	private String name;
	private String enName;
	private String description;
	private int total;
	public Category(){
		
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Category [parentId=" + parentId + ", id=" + id + ", name="
				+ name + ", enName=" + enName + ", description=" + description
				+ ", total=" + total + "]\n";
	}
	

	
	
}
