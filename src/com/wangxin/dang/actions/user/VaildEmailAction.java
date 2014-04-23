package com.wangxin.dang.actions.user;

import java.sql.SQLException;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.services.UserService;
import com.wangxin.dang.services.impl.UserServiceImpl;

public class VaildEmailAction extends BaseAction{
	private String email;
	
	private boolean emailOk=false;
	
	private UserService service =new UserServiceImpl();
	//ÒµÎñÂß¼­
	public  String execute(){
		
		//System.out.println("request email:"+email);
		try {
			emailOk=!service.findEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("response emailOK:"+emailOk);
		return "success";
	}
	public boolean isEmailOk() {
		return emailOk;
	}
	public void setEmailOk(boolean emailOk) {
		this.emailOk = emailOk;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
