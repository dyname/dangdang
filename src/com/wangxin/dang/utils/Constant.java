package com.wangxin.dang.utils;

public class Constant {
	
	//用户进行登入时的三种不同的结果
	//邮箱或密码错误
	public static final int LOGIN_FAIL=0;
	//邮箱密码正确,没有邮箱验证码验证
	public static final int LOGIN_VERIFY=1;
	//登入成功
	public static final int Login_SUCCESS=2;
	
	//定义用户等级常量
	//普通用户
	public static final int NORMAL = 0;
	//高级用户
	public static final int HIGHT=1;
	//会员用户
	public static final int VIP = 2;
	
	//Session Key
	//购物车
	public static final String CART="cart";
	//用户信息
	public static final String USER="user";
	//订单状态
	//等待付款
	public static final int WAIT_PAY=0;
	//等待发货
	public static final int WAIT_SEND=1;
	//等待收货
	public static final int WAIT_RECEIVE=2;
	//交易完成
	public static final int OREDER_OK=3;
	
	//显示类型为图书的所有的分类
	public static final int CATEGORY_BOOK=1;
	
	//在购物车中的初始状态
	public static final int ON_ITEM=1;
	//在购物车中出于删除状态
	public static final int OUT_ITEM=0;
	//在购物车中出于已经购买状态
	public static final int ALREADY_BUY=2;
}
