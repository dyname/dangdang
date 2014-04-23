package com.wangxin.dang.daos.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Result;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.wangxin.dang.daos.CartDAO;
import com.wangxin.dang.pojos.CartItem;
import com.wangxin.dang.utils.Constant;
import com.wangxin.dang.utils.DbUtil;

public class JdbcCartDAO implements CartDAO {

	private static final String findUserInfoById="";
	
	//ͨ����Ʒ��id������Ʒ����Ϣ
	private static final String findProductInfoById="select product_name,dang_price,fixed_price from d_product where id=?";
	//ͨ����Ʒ��id�ڹ��ﳵ�в����Ƿ���ڣ����ھ��޸���������
	private static final String findOrderAndUpdate="update d_item set product_num=product_num+1 where product_id=? and order_id=? and status=?";
	//������������뵽���ݿ�
	private static final String insertInfoToTime=
			"insert into d_item(order_id,product_id,product_name,dang_price,fixed_price,product_num,amount,status)" +
			"values(?,?,?,?,?,?,?,?)";
	//���Ҷ�Ӧ��id�Ĺ��ﳵ
	private static final String findCartItemList="" +
			"select * from d_item where order_id=? and status=?";
	
	//�޸��û���Ӧ����Ʒ������
	private static final String changeCartById="update d_item set product_num=? where order_id=? and product_id=?";
	//����Ʒ�ӹ��ﳵ��ɾ��
	private static final String deleteCartById="update d_item set status=? where order_id=? and product_id=?";
	//����Ʒ��״̬�޸�Ϊ����
	private static final String buyProudct="update d_item set status=? where order_id=? and status=?";
	
	
	public boolean order(int userId, int productId) throws Exception {
		//�Ȳ��Ҷ������Ƿ��������Ʒ���еĻ�������������һ���ɣ�û�еĻ������ӵ����ݿ�
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findOrderAndUpdate);
		stmt.setInt(1, productId);
		stmt.setInt(2, userId);
		stmt.setInt(3, Constant.ON_ITEM);
		int updateFlag=stmt.executeUpdate();
		System.out.println(updateFlag);
		if(updateFlag>0){
			//�Ѿ��и���Ʒ��ֻҪ�޸�һ����������
			return true;
		}
		
		//���ݿ���û�и���Ʒ����Ҫ���
		String product_name="";
		double dang_price=0;
		double fixed_price=0;
		stmt=DbUtil.getConnection().prepareStatement(findProductInfoById);
		stmt.setInt(1, productId);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			product_name=rs.getString("product_name");
			dang_price=rs.getDouble("dang_price");
			fixed_price=rs.getDouble("fixed_price");
		}
		stmt=DbUtil.getConnection().prepareStatement(insertInfoToTime);
		stmt.setInt(1, userId);
		stmt.setInt(2, productId);
		stmt.setString(3, product_name);
		stmt.setDouble(4, dang_price);
		stmt.setDouble(5, fixed_price);
		stmt.setInt(6, 1);
		stmt.setInt(7, 0);
		stmt.setInt(8, Constant.ON_ITEM);
		
		updateFlag=stmt.executeUpdate();
		if(rs.next()){
			int insertFlag=rs.getInt(1);
			if(insertFlag>0){
				return true;
			}
		}
		return false;
	}

	public List<CartItem> findCartItemList(int userId,int statusFlag) throws Exception {
		List<CartItem> cartItemListInCart=new ArrayList<CartItem>();
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findCartItemList);
		stmt.setInt(1, userId);
		stmt.setInt(2,statusFlag);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			cartItemListInCart.add(parseItem(rs));
		}
		return cartItemListInCart;
	}

	private CartItem parseItem(ResultSet rs) throws Exception {
		CartItem cartItem =new CartItem();
		cartItem.setId(rs.getInt("id"));
		cartItem.setOrderId(rs.getInt("order_id"));
		cartItem.setProductId(rs.getInt("product_id"));
		cartItem.setProductName(rs.getString("product_name"));
		cartItem.setDangPrice(rs.getDouble("dang_price"));
		cartItem.setFixedPrice(rs.getDouble("fixed_price"));
		cartItem.setProductNum(rs.getInt("product_num"));
		cartItem.setAmount(cartItem.getDangPrice()*cartItem.getProductNum());
		cartItem.setStatus(rs.getInt("status"));
		cartItem.setOneCha(cartItem.getFixedPrice()-cartItem.getDangPrice());
		cartItem.setCha(cartItem.getOneCha()*cartItem.getProductNum());
		return cartItem;
	}

	public boolean changeCartById(int userId, int productId, int productNumber)
			throws Exception {
		System.out.println("userId"+userId);
		System.out.println("productId"+productId);
		System.out.println("productNumber:"+productNumber);
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(changeCartById);
		stmt.setInt(1, productNumber);
		stmt.setInt(2,userId);
		stmt.setInt(3, productId);
		int index=stmt.executeUpdate();
		if(index>0){
			System.out.println(index);
			return true;
		}
		System.out.println(index);
		return false;
	}

	public boolean deleteCartById(int userId, int productId, int statusFlag)
			throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(deleteCartById);
		stmt.setInt(1, statusFlag);
		stmt.setInt(2,userId);
		stmt.setInt(3, productId);
		int index=stmt.executeUpdate();
		if(index>0){
			System.out.println(index);
			return true;
		}
		System.out.println(index);
		return false;
	}

	public boolean recoverCartById(int userId, int productId, int statusFlag)
			throws Exception {
		return deleteCartById(userId,productId,statusFlag);
	}

	public boolean buyProudct(int userId, int statuFlag) throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(buyProudct);
		stmt.setInt(1, statuFlag);
		stmt.setInt(2,userId);
		stmt.setInt(3, Constant.ON_ITEM);
		int index=stmt.executeUpdate();
		if(index>0){
			System.out.println(index);
			return true;
		}
		System.out.println(index);
		return false;
	}
	
}
