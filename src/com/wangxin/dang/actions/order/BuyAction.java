package com.wangxin.dang.actions.order;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.Address;
import com.wangxin.dang.pojos.User;
import com.wangxin.dang.services.OrderService;
import com.wangxin.dang.services.impl.OrderServiceImpl;

public class BuyAction extends BaseAction{
	
	private double amount;
	
	private int orderId;
	
	private String newAddress;
	
	private Address address;
	
	private OrderService service=new OrderServiceImpl();
	
	public String execute(){
		System.out.println("newAddress:"+newAddress);
		System.out.println("address:"+address);
		int userId=((User)(session.get("user"))).getId();
		//�����userId��Ӧ���û����ڹ��ﳵ��״̬��Ϊɾ��״̬��ɾ��������Ϣ��ӵ���������
		try {
			//�õ��ܼ۸�
			amount=service.amountOfCartItemByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//���ж�һ�µõ����ύ��ַ��Ϣ�ǲ����µ�,�µľ������ݿ����
			if(newAddress.trim().equals("true")){
				service.addNewAddressById(userId,address);
			}
			orderId=service.buyProudct(userId,amount,address);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getNewAddress() {
		return newAddress;
	}
	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}
	public OrderService getService() {
		return service;
	}
	public void setService(OrderService service) {
		this.service = service;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
