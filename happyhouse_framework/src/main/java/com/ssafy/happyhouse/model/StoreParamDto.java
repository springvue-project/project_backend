package com.ssafy.happyhouse.model;


public class StoreParamDto {
	
	//private String regionCode;
	private String lat;
	private String lng;
	private String codeType;
	private String code; 
	private String distance;
	
	
	
	@Override
	public String toString() {
		return "StoreParamDto [lat=" + lat + ", lng=" + lng + ", codeType=" + codeType + ", code=" + code
				+ ", distance=" + distance + "]";
	}

	public StoreParamDto(String lat, String lng, String codeType, String code, String distance) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.codeType = codeType;
		this.code = code;
		this.distance = distance;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
//	public String getRegionCode() {
//		return regionCode;
//	}
//	public void setRegionCode(String regionCode) {
//		this.regionCode = regionCode;
//	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
