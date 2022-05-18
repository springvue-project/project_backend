package com.ssafy.happyhouse.model;

// DTO : Data Transfer Object
// VO : Value Object

public class UserDto {

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userPwd=" + userPwd + ", userEmail=" + userEmail + ", userName="
				+ userName + ", registDate=" + registDate
				+ ", manager=" + manager + ", phoneNum=" + phoneNum + "]";
	}


	private String userId;
	private String userPwd;
	private String userEmail;
	private String userName;
	private String phoneNum;
	private String registDate;
	private String manager;
	

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getRegistDate() {
		return registDate;
	}


	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


}
