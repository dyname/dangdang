package com.wangxin.dang.daos.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wangxin.dang.daos.OrderDAO;
import com.wangxin.dang.pojos.Address;
import com.wangxin.dang.utils.Constant;
import com.wangxin.dang.utils.DbUtil;

public class JdbcOrderDAO implements OrderDAO{

	private static final String findAddressById=
			"select * from d_receive_address where user_id=?";
	
	private static final String findOneAddressById=
			"select * from d_receive_address where id=?";
	
	private static final String addNewAddressBuId=
			"insert into d_receive_address(" +
			"user_id,receive_name,full_address,postal_code,mobile,phone)" +
			"values(?,?,?,?,?,?)";
	
	private static final String addOrder=
			"insert into d_order(" +
			"user_id,status,order_time,order_desc,total_price,receive_name," +
			"full_address,postal_code,mobile,phone)" +
			"values(?,?,?,?,?,?,?,?,?,?)";
	
	public List<Address> findAddressById(int userId) throws Exception {
		List<Address> addressList=new ArrayList<Address>();
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findAddressById);
		stmt.setInt(1, userId);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			addressList.add(parseAddress(rs));
		}
		return addressList;
	}

	private Address parseAddress(ResultSet rs) throws Exception {
		Address address=new Address();
		address.setId(rs.getInt("id"));
		address.setUserId(rs.getInt("user_id"));
		address.setReceiveName(rs.getString("receive_name"));
		address.setFullAddress(rs.getString("full_address"));
		address.setPostalCode(rs.getString("postal_code"));
		address.setMobile(rs.getString("mobile"));
		address.setPhone(rs.getString("phone"));
		return address;
	}

	public Address finOneAddressById(int addressId) throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findOneAddressById);
		stmt.setInt(1, addressId);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			return parseAddress(rs);
		}
		return null;
	}

	public boolean addNewAddressById(int userId, Address newAddress)
			throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(addNewAddressBuId);
		stmt.setInt(1,userId);
		stmt.setString(2, newAddress.getReceiveName());
		stmt.setString(3,newAddress.getFullAddress());
		stmt.setString(4, newAddress.getPostalCode());
		stmt.setString(5, newAddress.getMobile());
		stmt.setString(6, newAddress.getPhone());
		int index=stmt.executeUpdate();
		if(index>0){
			return true;
		}
		return false;
	}

	public int addOrder(int userId, double amount, Address address)
			throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(addOrder,java.sql.Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, userId);
		stmt.setInt(2, Constant.WAIT_SEND);
		stmt.setLong(3,System.currentTimeMillis());
		stmt.setString(4, "");
		stmt.setDouble(5, amount);
		stmt.setString(6, address.getReceiveName());
		stmt.setString(7, address.getFullAddress());
		stmt.setString(8, address.getPostalCode());
		stmt.setString(9, address.getMobile());
		stmt.setString(10, address.getPhone());
		stmt.executeUpdate();
		ResultSet rs=stmt.getGeneratedKeys();
		rs.next();
		return rs.getInt(1);
	}

}
