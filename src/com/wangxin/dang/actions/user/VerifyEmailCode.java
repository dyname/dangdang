package com.wangxin.dang.actions.user;

import java.sql.SQLException;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.User;
import com.wangxin.dang.services.UserService;
import com.wangxin.dang.services.impl.UserServiceImpl;

public class VerifyEmailCode extends BaseAction{

	private int userId;
	
	private  String code;
	
	private UserService service=new UserServiceImpl();
	
	private String userEmail;
	
	private String userName;
	
	private boolean vaildEmail=false;
	
	public String execute(){
		
		try {
			vaildEmail=service.verifyEmailCode(userId,code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(vaildEmail){
			return "success";
		}
		return "fail";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isVaildEmail() {
		return vaildEmail;
	}

	public void setVaildEmail(boolean vaildEmail) {
		this.vaildEmail = vaildEmail;
	}
	
}
