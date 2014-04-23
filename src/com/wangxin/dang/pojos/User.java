package com.wangxin.dang.pojos;

public class User implements java.io.Serializable{
	private int id;
	private String email;
	private String nickname;
	private String password;
	private int userIntegal;
	private boolean emailVerify;
	private String emailVerifyCode;
	private long lastLoginTime;
	private String lastLoginIp;
	public User(){
	
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserIntegal() {
		return userIntegal;
	}

	public void setUserIntegal(int userIntegal) {
		this.userIntegal = userIntegal;
	}

	public boolean isEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(boolean emailVerify) {
		this.emailVerify = emailVerify;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nickname=" + nickname
				+ ", password=" + password + ", userIntegal=" + userIntegal
				+ ", emailVerify=" + emailVerify + ", emailVerifyCode="
				+ emailVerifyCode + ", lastLoginTime=" + lastLoginTime
				+ ", lastLoginIp=" + lastLoginIp + "]";
	}

	
	
}
