package com.wangxin.dang.services;

import java.util.List;

import com.wangxin.dang.pojos.Address;

public interface OrderService {
	
	public List<Address> findAddressById(int userId) throws Exception;
	
	public Address finOneAddressById(int addressId) throws Exception;
	
	public int buyProudct(int userId,double amount,Address address) throws Exception;
	
	public double amountOfCartItemByUserId(int userId) throws Exception;
	
	public boolean addNewAddressById(int userId,Address newaddress) throws Exception;
}
