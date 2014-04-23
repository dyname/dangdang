package com.wangxin.dang.pojos;

import java.util.List;

public class DoubleCategory {
	private Category categoryOwn;
	private List<Category> categoryList;
	
	public DoubleCategory(){
		
	}

	public Category getCategoryOwn() {
		return categoryOwn;
	}

	public void setCategoryOwn(Category categoryOwn) {
		this.categoryOwn = categoryOwn;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	@Override
	public String toString() {
		return "DoubleCategory [categoryOwn=" + categoryOwn + ", categoryList="
				+ categoryList + "]";
	}
	
}
