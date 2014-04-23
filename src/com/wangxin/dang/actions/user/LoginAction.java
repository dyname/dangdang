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
	
	//������������
	//1.������������ ,���ص��������
	//2.��Ϣ��ȷ��û��������֤,��ת��������֤����֤����
	//2.��Ϣ��ȷ������Ҳ�Ѿ���֤,������ҳ
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
			//��������
			errorMessage="";
			//System.out.println("����ɹ�");
			session.put("user", user);
			return "success";
		}else if(loginFlag==Constant.LOGIN_VERIFY){
			//����������ȷ��������Ҫ������֤����֤
			errorMessage="";
			session.put("user", user);
			//System.out.println("��Ҫ��֤������֤��");
			return "verify";
		}else{
			errorMessage="�û������������";
			//System.out.println("����ʧ��");
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
