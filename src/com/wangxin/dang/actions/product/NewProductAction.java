package com.wangxin.dang.actions.product;

import java.util.List;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.daos.ProductDAO;
import com.wangxin.dang.daos.impl.JdbcProductDAO;
import com.wangxin.dang.pojos.Product;
import com.wangxin.dang.services.ProductService;
import com.wangxin.dang.services.impl.ProductServiceImpl;

public class NewProductAction extends BaseAction{
	//input
	//output
	private List<Product> productList;
	//action配置注入一个值
	private int topSize;
	
	private ProductService service=new ProductServiceImpl();
	
	public String execute(){
		try {
			productList=service.findNewProduct(topSize);
			//System.out.println(productList.toString());
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public int getTopSize() {
		return topSize;
	}

	public void setTopSize(int topSize) {
		this.topSize = topSize;
	}
		
}
