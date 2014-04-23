package com.wangxin.dang.services.impl;

import java.sql.SQLException;

import com.wangxin.dang.daos.UserDAO;
import com.wangxin.dang.daos.impl.JdbcUserDAO;
import com.wangxin.dang.pojos.User;
import com.wangxin.dang.services.UserService;
import com.wangxin.dang.utils.Constant;
import com.wangxin.dang.utils.DegistUtil;
import com.wangxin.dang.utils.VerifyUtil;

public class UserServiceImpl implements UserService {
	
	//调用UserDAO方法用到的一个实例化对象
	private UserDAO userDao=new JdbcUserDAO();

	public void regist(User user,String ip) throws Exception {
		// TODO Auto-generated method stub
		//写入d_user
		//设置用户最后一次使用ip的地址
		user.setLastLoginIp(ip);
		//用户密码进行md5码加密
		user.setPassword(DegistUtil.md5Digest(user.getPassword()));
		//设置用户最后登入时间
		user.setLastLoginTime(System.currentTimeMillis());
		//用户等级
		user.setUserIntegal(Constant.NORMAL);
		//用户邮箱验证码是否验证过
		user.setEmailVerify(false);
		
		//数据库中保存用户
		userDao.save(user);

		//修改用户的邮箱验证码信息
		String emailVerifyCode=VerifyUtil.createUUID()+"-"+user.getId();
		emailVerifyCode=DegistUtil.md5Digest(emailVerifyCode);
		
		//在数据库中更新
		updateEmailVerifyCode(user.getId(), emailVerifyCode);
		
	}

	public void update(User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void updateEmailVerifyCode(int userId, String veriftyCode)
			throws SQLException {
		userDao.updateEmailVerifyCode(userId,veriftyCode);
		
	}

	public boolean findEmail(String email) throws SQLException {
		return userDao.findEmail(email);
	}

	public boolean verifyEmailCode(int userId, String emailCode)
			throws SQLException {
		String oldEmailCode=userDao.getEmailCodeById(userId).trim();
		System.out.println("input :"+emailCode);
		System.out.println("find  :"+oldEmailCode);
		if(emailCode.trim().equals(oldEmailCode)){
			//验证成功，修改数据库中的信息,并且返回成功
			userDao.emailVerify(userId);
			return true;
		}
		return false;
		
	}

	public int login(String email, String password) throws SQLException {
		//将用户的密码转化成MD5码
		password=DegistUtil.md5Digest(password.trim());
		//从数据库中取出用户的密码
		//System.out.println("password:"+password);
		User user=userDao.findUserByEmail(email);
		if(user==null){
			//没有该邮箱的用户
			//System.out.println("没有这个邮箱");
			return  Constant.LOGIN_FAIL;
		}
		String oldPwd=user.getPassword().trim();
		//System.out.println("oldpwd:"+oldPwd);
		//System.out.println("service："+user.toString());
		if(!oldPwd.trim().equals(password)){
			//密码错误
			//System.out.println("密码错误");
			return Constant.LOGIN_FAIL;
		}
		if(oldPwd.trim().equals(password)){
			//邮箱密码都正确,判断是否邮箱验证码验证过
			if(user.isEmailVerify()){
    			//System.out.println("邮箱没有验证");
				return Constant.LOGIN_VERIFY;
			}
			//正常登入
			//System.out.println("正常登入");
			return Constant.Login_SUCCESS;
		}
		return Constant.LOGIN_FAIL;
	}

	
	
	public static void main(String[] args) throws Exception {
		UserServiceImpl service=new UserServiceImpl();
		//System.out.println(service.login("111@qq.com", "1111111",new User()));
	}

	public User findUserByEmail(String email) throws SQLException {
		return userDao.findUserByEmail(email);
	}

}
