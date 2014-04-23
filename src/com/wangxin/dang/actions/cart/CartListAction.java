package com.wangxin.dang.actions.cart;

import java.util.List;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.CartItem;
import com.wangxin.dang.pojos.User;
import com.wangxin.dang.services.CartServices;
import com.wangxin.dang.services.impl.CartServiceImplement;
import com.wangxin.dang.utils.Constant;

public class CartListAction extends BaseAction{
	
	//�ڹ��ﳵ�����Ʒ���ڵȴ������
	private List<CartItem> cartItemInList;
	//�ڹ��ﳵ��ģ������Ǵ���ɾ��״̬��
	private List<CartItem> cartItemOutList;
	
	private int userId;
	
	//��Ҫ�޸ĵ���Ʒ������
	private int productNumber;
	//��Ҫ�޸ĵ���Ʒ��id
	private int productId;
	
	private boolean changeOk=false;
	
	private CartServices service=new CartServiceImplement();
	
	public String execute(){
		userId=((User)session.get("user")).getId();
		try {
			cartItemInList=service.findCartItemList(userId,Constant.ON_ITEM);
			cartItemOutList=service.findCartItemList(userId,Constant.OUT_ITEM);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public String change(){
		System.out.println("change");
		//System.out.println("productId"+productId);
		//System.out.println("productNumber"+productNumber);
		userId=((User)session.get("user")).getId();
		System.out.println("userId:"+userId);
		//�ı����ݿ��е�����
		try {
			service.changeCartById(userId,productId,productNumber);
			cartItemInList=service.findCartItemList(userId,Constant.ON_ITEM);
			cartItemOutList=service.findCartItemList(userId,Constant.OUT_ITEM);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		changeOk=true;
		System.out.println("changok"+changeOk);
		return "success";
	}
	
	public String delete(){
		System.out.println("delete");
		userId=((User)session.get("user")).getId();
		//�ı����ݿ��е�����
		try {
			service.deleteCartById(userId,productId,Constant.OUT_ITEM);
			cartItemInList=service.findCartItemList(userId,Constant.ON_ITEM);
			cartItemOutList=service.findCartItemList(userId,Constant.OUT_ITEM);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}
	
	public String recover(){
		System.out.println("recover");
		userId=((User)session.get("user")).getId();
		//�ı����ݿ��е�����
		try {
			service.recoverCartById(userId,productId,Constant.ON_ITEM);
			cartItemInList=service.findCartItemList(userId,Constant.ON_ITEM);
			cartItemOutList=service.findCartItemList(userId,Constant.OUT_ITEM);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public List<CartItem> getCartItemInList() {
		return cartItemInList;
	}

	public void setCartItemInList(List<CartItem> cartItemInList) {
		this.cartItemInList = cartItemInList;
	}

	public List<CartItem> getCartItemOutList() {
		return cartItemOutList;
	}

	public void setCartItemOutList(List<CartItem> cartItemOutList) {
		this.cartItemOutList = cartItemOutList;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean isChangeOk() {
		return changeOk;
	}

	public void setChangeOk(boolean changeOk) {
		this.changeOk = changeOk;
	}
	
	
	
}
