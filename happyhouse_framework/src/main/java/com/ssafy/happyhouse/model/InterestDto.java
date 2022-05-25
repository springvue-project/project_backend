package com.ssafy.happyhouse.model;

public class InterestDto {
	private String userid;
	private String aptCode;
	
	
	
	public InterestDto(String userid, String aptCode) {
		super();
		this.userid = userid;
		this.aptCode = aptCode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAptCode() {
		return aptCode;
	}
	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}  
	
	
	
}
