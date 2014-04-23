package com.wangxin.dang.daos;

import java.sql.SQLException;

import com.wangxin.dang.pojos.User;

public interface UserDAO {
	public void save(User user) throws SQLException;
	
	public void update(User user) throws SQLException;
	
	public void updateEmailVerifyCode(int userId, String veriftyCode) throws SQLException;
	
	public boolean findEmail(String email) throws SQLException;
	
	public String getEmailCodeById(int userId) throws SQLException;
	
	public boolean emailVerify(int userId) throws SQLException;
	
	public User findUserByEmail(String email) throws SQLException;
}
