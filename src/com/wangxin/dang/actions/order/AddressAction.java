package com.wangxin.dang.actions.order;

import java.util.List;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.Address;
import com.wangxin.dang.pojos.User;
import com.wangxin.dang.services.OrderService;
import com.wangxin.dang.services.impl.OrderServiceImpl;

public class AddressAction extends BaseAction{
	
	private List<Address> addressList;
	
	private OrderService service=new OrderServiceImpl();
	
	public String execute(){
		int userId=((User)(session.get("user"))).getId();
		//System.out.println("userId"+userId);
		try {
			addressList=service.findAddressById(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
}
