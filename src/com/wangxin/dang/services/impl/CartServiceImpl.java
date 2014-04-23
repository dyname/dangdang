package com.wangxin.dang.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.wangxin.dang.pojos.CartItem;
import com.wangxin.dang.services.CartService;

public class CartServiceImpl implements CartService{

	private List<CartItem> items=new ArrayList<CartItem>();

	public boolean buy(int pid) {
		//根据pid查找商品
		return false;
	}

	public void delete(int pid) {
		// TODO Auto-generated method stub
		
	}

	public void update(int pid, int pnumber) {
		// TODO Auto-generated method stub
		
	}

	public void recovery(int pid) {
		// TODO Auto-generated method stub
		
	}

	public List<CartItem> getBuyList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CartItem> getDeleteList() {
		// TODO Auto-generated method stub
		return null;
	}

	public double count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
