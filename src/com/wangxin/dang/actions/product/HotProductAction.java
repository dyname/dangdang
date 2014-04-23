package com.wangxin.dang.actions.product;

import java.util.List;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.Product;
import com.wangxin.dang.services.ProductService;
import com.wangxin.dang.services.impl.ProductServiceImpl;

public class HotProductAction extends BaseAction{
	
	//input
	private int hotSize;
	//output
	private List<Product> productList;

	private ProductService service=new ProductServiceImpl();

	public String execute(){
		try {
			productList=service.findHotProduct(hotSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public int getHotSize() {
		return hotSize;
	}

	public void setHotSize(int hotSize) {
		this.hotSize = hotSize;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
}
