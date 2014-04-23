package com.wangxin.dang.actions.cart;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.services.CartFactory;
import com.wangxin.dang.services.CartService;

public class BuyAction extends BaseAction {
	
	private int id;
	
	private boolean buyOk=false;
	
	public String execute(){
		CartService cart=CartFactory.getCart(session);
		cart.buy(id);
		return "success";
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isBuyOk() {
		return buyOk;
	}

	public void setBuyOk(boolean buyOk) {
		this.buyOk = buyOk;
	}
	
	
}
