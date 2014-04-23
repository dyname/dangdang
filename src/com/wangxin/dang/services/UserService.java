package com.wangxin.dang.services;

import java.sql.SQLException;

import com.wangxin.dang.pojos.User;

public interface UserService {
	public void regist(User user,String ip) throws Exception;
	
	public void update(User user) throws SQLException;
	
	public void updateEmailVerifyCode(int userId, String veriftyCode) throws SQLException;
	
	public boolean findEmail(String email) throws SQLException;
	
	public boolean verifyEmailCode(int userId,String emailCode) throws SQLException;
	
	public int login(String name,String password) throws SQLException;
	
	public User findUserByEmail(String email) throws SQLException;
}
