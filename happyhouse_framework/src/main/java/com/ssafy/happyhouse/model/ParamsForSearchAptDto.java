package com.ssafy.happyhouse.model;

public class ParamsForSearchAptDto {

	String aptname;
	String dongCode;
	
	public String getAptname() {
		return aptname;
	}
	public void setAptname(String aptname) {
		this.aptname = aptname;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public ParamsForSearchAptDto(String aptname, String dongCode) {
		this.aptname = aptname;
		this.dongCode = dongCode;
	}
	@Override
	public String toString() {
		return "ParamsForSearchAptDto [aptname=" + aptname + ", dongCode=" + dongCode + "]";
	}
	
}
