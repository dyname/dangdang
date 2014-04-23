package com.wangxin.dang.actions.order;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.Address;
import com.wangxin.dang.services.OrderService;
import com.wangxin.dang.services.impl.OrderServiceImpl;

public class OneAddressAction extends BaseAction{
	
	private Address oneAddress;
	
	private OrderService service=new OrderServiceImpl();
	
	private int addressId;
	
	public String execute(){
		//System.out.println("hello");
		//System.out.println("addressId"+addressId);
		try {
			oneAddress=service.finOneAddressById(addressId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public Address getOneAddress() {
		return oneAddress;
	}

	public void setOneAddress(Address oneAddress) {
		this.oneAddress = oneAddress;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
}
