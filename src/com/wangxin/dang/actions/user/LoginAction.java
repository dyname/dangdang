package com.wangxin.dang.actions.user;

import java.sql.SQLException;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.User;
import com.wangxin.dang.services.UserService;
import com.wangxin.dang.services.impl.UserServiceImpl;
import com.wangxin.dang.utils.Constant;

public class LoginAction extends BaseAction{
	
	private String email;
	
	private String password;
	
	private String errorMessage="";
	
	private User user=new User();
	
	private UserService service=new UserServiceImpl();
	
	//登入分三种情况
	//1.邮箱或密码错误 ,跳回到登入界面
	//2.信息正确，没有邮箱验证,跳转到邮箱验证码验证界面
	//2.信息正确，邮箱也已经验证,跳到首页
	public String execute(){
		//System.out.println("email:"+email);
		//System.out.println("passwored:"+password);
		int loginFlag=Constant.LOGIN_FAIL;
		try {
			loginFlag = service.login(email, password);
			user=service.findUserByEmail(email);
			//System.out.println(user.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(loginFlag==Constant.Login_SUCCESS){
			//正常登入
			errorMessage="";
			//System.out.println("登入成功");
			session.put("user", user);
			return "success";
		}else if(loginFlag==Constant.LOGIN_VERIFY){
			//邮箱密码正确，但是需要邮箱验证码验证
			errorMessage="";
			session.put("user", user);
			//System.out.println("需要验证邮箱验证码");
			return "verify";
		}else{
			errorMessage="用户名或密码错误";
			//System.out.println("登入失败");
			return "fail";
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
