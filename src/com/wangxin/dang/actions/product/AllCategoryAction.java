package com.wangxin.dang.actions.product;

import java.util.List;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.DoubleCategory;
import com.wangxin.dang.services.ProductService;
import com.wangxin.dang.services.impl.ProductServiceImpl;

public class AllCategoryAction extends BaseAction{
	
	private List<DoubleCategory> allCategoryList;
	
	private ProductService service =new ProductServiceImpl();
	
	public String execute(){
		try {
			allCategoryList=service.findAllCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public List<DoubleCategory> getAllCategoryList() {
		return allCategoryList;
	}

	public void setAllCategoryList(List<DoubleCategory> allCategoryList) {
		this.allCategoryList = allCategoryList;
	}
	
}
