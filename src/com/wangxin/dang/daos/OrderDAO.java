package com.wangxin.dang.daos;

import java.util.List;

import com.wangxin.dang.pojos.Address;

public interface OrderDAO {
	
	public List<Address> findAddressById(int userId) throws Exception;
	
	public Address finOneAddressById(int addressId) throws Exception;
	
	public boolean addNewAddressById(int userId,Address newAddress) throws Exception;
	
	public int addOrder(int userId,double amount,Address address) throws Exception;
}
