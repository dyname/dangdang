package com.wangxin.dang.services;

import java.util.List;

import com.wangxin.dang.pojos.CartItem;

public interface CartService {
	public boolean buy(int pid);
	public void delete(int pid);
	public void update(int pid,int pnumber);
	public void recovery(int pid);
	public List<CartItem> getBuyList();
	public List<CartItem> getDeleteList();
	public double count();
}
