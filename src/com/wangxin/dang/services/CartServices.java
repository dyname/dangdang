package com.wangxin.dang.services;

import java.util.List;

import com.wangxin.dang.pojos.CartItem;

public interface CartServices {
	
	public boolean order(int userId,int productId) throws Exception;
	
	public List<CartItem> findCartItemList(int userId,int statusFlag) throws Exception;

	public double saveOfList(List<CartItem> cartItems) ;
	
	public double amountOfList(List<CartItem> cartItems) ;
	
	public double amountOfCartItemByUserId(int userId) throws Exception;
	
	public boolean changeCartById(int userId,int productId,int productNumber) throws Exception;
	
	public boolean deleteCartById(int userId,int productId,int statusFlag) throws Exception;
	
	public boolean recoverCartById(int userId,int productId,int statusFlag) throws Exception;
	
	public boolean buyProudct(int userId,int statusFlag) throws Exception;
	
	
}
