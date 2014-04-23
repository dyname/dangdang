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
	
	//����UserDAO�����õ���һ��ʵ��������
	private UserDAO userDao=new JdbcUserDAO();

	public void regist(User user,String ip) throws Exception {
		// TODO Auto-generated method stub
		//д��d_user
		//�����û����һ��ʹ��ip�ĵ�ַ
		user.setLastLoginIp(ip);
		//�û��������md5�����
		user.setPassword(DegistUtil.md5Digest(user.getPassword()));
		//�����û�������ʱ��
		user.setLastLoginTime(System.currentTimeMillis());
		//�û��ȼ�
		user.setUserIntegal(Constant.NORMAL);
		//�û�������֤���Ƿ���֤��
		user.setEmailVerify(false);
		
		//���ݿ��б����û�
		userDao.save(user);

		//�޸��û���������֤����Ϣ
		String emailVerifyCode=VerifyUtil.createUUID()+"-"+user.getId();
		emailVerifyCode=DegistUtil.md5Digest(emailVerifyCode);
		
		//�����ݿ��и���
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
			//��֤�ɹ����޸����ݿ��е���Ϣ,���ҷ��سɹ�
			userDao.emailVerify(userId);
			return true;
		}
		return false;
		
	}

	public int login(String email, String password) throws SQLException {
		//���û�������ת����MD5��
		password=DegistUtil.md5Digest(password.trim());
		//�����ݿ���ȡ���û�������
		//System.out.println("password:"+password);
		User user=userDao.findUserByEmail(email);
		if(user==null){
			//û�и�������û�
			//System.out.println("û���������");
			return  Constant.LOGIN_FAIL;
		}
		String oldPwd=user.getPassword().trim();
		//System.out.println("oldpwd:"+oldPwd);
		//System.out.println("service��"+user.toString());
		if(!oldPwd.trim().equals(password)){
			//�������
			//System.out.println("�������");
			return Constant.LOGIN_FAIL;
		}
		if(oldPwd.trim().equals(password)){
			//�������붼��ȷ,�ж��Ƿ�������֤����֤��
			if(user.isEmailVerify()){
    			//System.out.println("����û����֤");
				return Constant.LOGIN_VERIFY;
			}
			//��������
			//System.out.println("��������");
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
