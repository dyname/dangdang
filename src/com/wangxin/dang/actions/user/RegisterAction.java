package com.wangxin.dang.actions.user;

import java.sql.SQLException;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.daos.UserDAO;
import com.wangxin.dang.daos.impl.JdbcUserDAO;
import com.wangxin.dang.pojos.User;
import com.wangxin.dang.services.UserService;
import com.wangxin.dang.services.impl.UserServiceImpl;
import com.wangxin.dang.utils.DegistUtil;

public class RegisterAction extends BaseAction{
	//ÊôÐÔ
	//input
	private User user;
	
	//ÒµÎñÂß¼­
	public String execute(){
		String ip=httpRequest.getLocalAddr();
		try {
			service.regist(user,ip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public int userId;
	
	public String code;
	
	private UserService service=new UserServiceImpl();
	
	public String verify(){
		boolean vaild=false;
		try {
			vaild=service.verifyEmailCode(userId,code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(vaild){
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
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}	
