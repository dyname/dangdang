package com.wangxin.dang.services.impl;

import java.util.List;

import com.wangxin.dang.daos.CartDAO;
import com.wangxin.dang.daos.impl.JdbcCartDAO;
import com.wangxin.dang.pojos.CartItem;
import com.wangxin.dang.services.CartServices;
import com.wangxin.dang.utils.Constant;

public class CartServiceImplement implements CartServices{

	private CartDAO cartDao=new JdbcCartDAO();
	
	public boolean order(int userId, int productId) throws Exception {
		return cartDao.order(userId, productId);
	}
	
	public List<CartItem> findCartItemList(int userId,int statusFlag) throws Exception {
		return cartDao.findCartItemList(userId,statusFlag);
	}

	public static void main(String[] args) throws Exception {
		CartServiceImplement service=new CartServiceImplement();
//		service.order(2, 1);
//		System.out.println("insert success");
		System.out.println(service.findCartItemList(1, Constant.ON_ITEM));
	}
	
	public double saveOfList(List<CartItem> cartItems) {
		double save=0;
		if(cartItems==null||cartItems.size()==0){
			return 0;
		}else{
			for(int i=0;i<cartItems.size();i++){
				save+=cartItems.get(i).getCha();
			}
			return save;
		}
	}

	public double amountOfList(List<CartItem> cartItems) {
		double amount=0;
		if(cartItems==null||cartItems.size()==0){
			return 0;
		}else{
			for(int i=0;i<cartItems.size();i++){
				amount+=cartItems.get(i).getAmount();
			}
			return amount;
		}
	}

	public boolean changeCartById(int userId, int productId, int productNumber) throws Exception {
		return cartDao.changeCartById(userId,productId,productNumber);
	}

	public boolean deleteCartById(int userId, int productId, int statusFlag)
			throws Exception {
		return cartDao.deleteCartById(userId,productId,statusFlag);
	}
	
	public boolean recoverCartById(int userId, int productId, int statusFlag)
			throws Exception {
		return cartDao.recoverCartById(userId,productId,statusFlag);
	}

	public double amountOfCartItemByUserId(int userId) throws Exception {
		List<CartItem> cartItems=findCartItemList(userId, Constant.ON_ITEM);
		return amountOfList(cartItems);
	}

	public boolean buyProudct(int userId, int statusFlag) throws Exception {
		return cartDao.buyProudct(userId,statusFlag);
	}



}
