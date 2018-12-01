package com.mhs.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MemberVO extends DefaultVO {

	private static final long serialVersionUID = 1384101919737663389L;

	private int num;
	private String userId;
	private String userName;
	private String userPassword;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}