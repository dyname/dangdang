package com.wangxin.dang.actions.cart;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.User;
import com.wangxin.dang.services.CartServices;
import com.wangxin.dang.services.impl.CartServiceImplement;

public class OrderAction extends BaseAction{
	
	
	private int productId;
	
	private boolean orderOk=false;
	
	private CartServices service=new CartServiceImplement();
	
	public String execute(){
		System.out.println("OrderAction---------");
		System.out.println("productId:"+productId);
		System.out.println("OrderAction---------");
		
		if(session.get("user")==null){
			orderOk=false;
			return "success";
		}else{
			//得到当前用户的id，在数据库中将他的信息进行修改
			User user=(User)session.get("user");
			//将该商品添加到用户的数据库中
			try {
				service.order(user.getId(), productId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(user.getId());
		}
		
		orderOk=true;
		return "success";
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean isOrderOk() {
		return orderOk;
	}

	public void setOrderOk(boolean orderOk) {
		this.orderOk = orderOk;
	}
	
	
}
