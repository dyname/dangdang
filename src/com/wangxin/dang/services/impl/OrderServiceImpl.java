package com.wangxin.dang.services.impl;

import java.util.List;

import com.wangxin.dang.daos.OrderDAO;
import com.wangxin.dang.daos.impl.JdbcOrderDAO;
import com.wangxin.dang.pojos.Address;
import com.wangxin.dang.services.CartServices;
import com.wangxin.dang.services.OrderService;
import com.wangxin.dang.utils.Constant;

public class OrderServiceImpl implements OrderService{

	private OrderDAO orderDao=new JdbcOrderDAO();
	
	private CartServices cartServices=new CartServiceImplement();
	
	public List<Address> findAddressById(int addressId) throws Exception {
		return orderDao.findAddressById(addressId);
	}
	
	public static void main(String[] args) throws Exception {
		OrderServiceImpl service=new OrderServiceImpl();
		//System.out.println(service.findAddressById(1));
		//System.out.println(service.finOneAddressById(1));
		//service.addNewAddressById(2, new Address(1, 2, "sl", "hz", "316000", "1234567", "11111"));
		int index=service.buyProudct(1, 1000, new Address(1, 2, "sl", "hz", "316000", "1234567", "11111"));
		System.out.println("index:"+index);
	}

	public Address finOneAddressById(int addressId) throws Exception {
		return orderDao.finOneAddressById(addressId);
	}

	public int buyProudct(int userId,double amount,Address address) throws Exception {
		//先要将购物车中编号为userId的用户的购物车中的物品状态为购买的商品修改状态为购买
		cartServices.buyProudct(userId,Constant.ALREADY_BUY);
		//在将收集到的用户信息插入数据库,并返回插入数据的对应的id号
		return orderDao.addOrder(userId,amount,address);
	}

	public double amountOfCartItemByUserId(int userId) throws Exception {
		return cartServices.amountOfCartItemByUserId(userId);
	}

	public boolean addNewAddressById(int userId, Address newaddress)
			throws Exception {
		return orderDao.addNewAddressById(userId,newaddress);
	}
	
	
	
}
