package com.wangxin.dang.actions.order;

import java.util.List;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.CartItem;
import com.wangxin.dang.pojos.User;
import com.wangxin.dang.services.CartServices;
import com.wangxin.dang.services.impl.CartServiceImplement;
import com.wangxin.dang.utils.Constant;

public class OrderAction extends BaseAction{
	
	//得到用户在购物车中的商品的列表
	private List<CartItem> orderCartItemList;
	
	private double orderAmount;
	
	private CartServices service=new CartServiceImplement();
	
	public String execute(){
		int userId=((User)(session.get("user"))).getId();
		try {
			orderCartItemList=service.findCartItemList(userId, Constant.ON_ITEM);
			orderAmount=service.amountOfList(orderCartItemList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public List<CartItem> getOrderCartItemList() {
		return orderCartItemList;
	}

	public void setOrderCartItemList(List<CartItem> orderCartItemList) {
		this.orderCartItemList = orderCartItemList;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	
}
