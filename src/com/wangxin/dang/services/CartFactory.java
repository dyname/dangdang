package com.wangxin.dang.services;

import java.util.Map;

import com.wangxin.dang.services.impl.CartServiceImpl;
import com.wangxin.dang.utils.Constant;


public class CartFactory {
	public static CartService getCart(Map<String,Object> session){
		CartService cart = (CartService)session.get(Constant.CART);
		if(cart==null){
			cart = new CartServiceImpl();
			session.put(Constant.CART, cart);
		}
		return cart;
	}
}
