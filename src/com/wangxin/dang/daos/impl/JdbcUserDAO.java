package com.wangxin.dang.daos.impl;

import java.awt.image.DataBufferUShort;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangxin.dang.daos.UserDAO;
import com.wangxin.dang.pojos.User;
import com.wangxin.dang.utils.DbUtil;
import com.wangxin.dang.utils.DegistUtil;
import com.wangxin.dang.utils.VerifyUtil;

public class JdbcUserDAO implements UserDAO {
	//添加一个新的用户
	private static final String save="" +
			"insert into d_user(" +
			"email,nickname,password,user_integral,is_email_verify," +
			"email_verify_code,last_login_time,last_login_ip) " +
			"value(?,?,?,?,?,?,?,?)";
	
	//更新用户的信息
	private static final String update="update d_user set " +
			"email=?,nickname=?,password=?,user_integral=?,is_email_verify=?," +
			"email_verify_code=?,last_login_time=?,last_login_ip=? where id=?";
	
	//更新邮箱的验证码信息
	private static final String updateEmailVerityCode=
			"update d_user set email_verify_code=? where id=?";
	
	//查找对应邮箱的邮箱验证码
	private static final String verifyEmailCode="select email_verify_code from d_user where id=?";
	
	//验证邮箱是否被使用
	private static final String findEmail="select count(*) from d_user where email=?";
	
	//用户登入验证
	private static final String findUserByEmail="select * from d_user where email=?";
	
	//将用户是否邮箱验证改为验证状态
	private static final String emailVerify="update d_user set is_email_verify='t' where id=?";
	
	public void save(User user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt= DbUtil.getConnection().prepareStatement(save,java.sql.Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, user.getEmail());
		stmt.setString(2, user.getNickname());
		stmt.setString(3, user.getPassword());
		stmt.setInt(4, user.getUserIntegal());
		String isVerity=user.isEmailVerify()?"y":"n";
		stmt.setString(5, isVerity);
		stmt.setString(6, user.getEmailVerifyCode());
		stmt.setLong(7, user.getLastLoginTime());
		stmt.setString(8, user.getLastLoginIp());
		stmt.executeUpdate();
		ResultSet rs=stmt.getGeneratedKeys();
		
		rs.next();
		int id = rs.getInt(1);
		user.setId(id);
		
		return ;
	}
	
	public void update(User user) throws SQLException {
		// TODO Auto-generated method stub
		//产生随机的uuid,再用MD5码加密
		
	}
	
	public void updateEmailVerifyCode(int userId,String emailVerifyCode) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt= DbUtil.getConnection().prepareStatement(updateEmailVerityCode);
		stmt.setString(1, emailVerifyCode);
		stmt.setInt(2, userId);
		stmt.executeUpdate();
		stmt.close();
	}

	public static void main(String[] args) throws Exception {
		JdbcUserDAO dao=new JdbcUserDAO();
		//System.out.println(dao.verifyEmailCode(2,"GyJuHJSqJqPMmxVSNw7Lbg=="));
	}

	public boolean findEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findEmail);
		stmt.setString(1, email);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			if(rs.getInt(1)>0){
				return true;
			}
			return false;
		}
		return false;
	}

	public String getEmailCodeById(int userId) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(verifyEmailCode);
		stmt.setInt(1, userId);
		ResultSet rs=stmt.executeQuery();
		rs.next();
		String oldEmailCode=rs.getString("email_verify_code");
		stmt.close();
		return oldEmailCode;
			
	}

	public User findUserByEmail(String email) throws SQLException {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findUserByEmail);
		stmt.setString(1, email);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			User user=new User();
			//System.out.println("有结果");
			user.setEmail(rs.getString("email"));
			String emailVerify=rs.getString("is_email_verify").trim();
			user.setEmailVerify(emailVerify.equals("n")?true:false);
			user.setEmailVerifyCode(rs.getString("email_verify_code"));
			user.setId(rs.getInt("id"));
			user.setLastLoginIp("last_login_ip");
			user.setLastLoginTime(rs.getLong("last_login_time"));
			user.setNickname(rs.getString("nickname"));
			user.setPassword(rs.getString("password"));
			user.setUserIntegal(rs.getInt("user_integral"));
			return user;
		}
		return null;
	}

	public boolean emailVerify(int userId) throws SQLException {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(emailVerify);
		stmt.setInt(1, userId);
		int index=stmt.executeUpdate();
		if(index>0){
			return true;
		}
		return false;
	}



}
