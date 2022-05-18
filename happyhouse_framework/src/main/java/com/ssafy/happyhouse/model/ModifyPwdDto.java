package com.ssafy.happyhouse.model;

public class ModifyPwdDto {
	private String userId;
	private String currentPwd;
	private String newPwd;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCurrentPwd() {
		return currentPwd;
	}
	public void setCurrentPwd(String currentPwd) {
		this.currentPwd = currentPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	
}
