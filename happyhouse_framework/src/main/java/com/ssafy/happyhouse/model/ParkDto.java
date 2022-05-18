package com.ssafy.happyhouse.model;

public class ParkDto {
	private String parkName;	// 주차장 이름
	private String parkAddress;	// 주차장 주소
	private String type;		// 주차장 타입
	private String pay;			// 주차장 요금 유무
	private int count;			// 주차 구획 수
	private String lat;			// 위도
	private String lng;			// 경도
	private String phone;		// 연락처
	
	public ParkDto(String parkName, String parkAddress, String type, String pay, int count, String lat, String lng,
			String phone) {
		super();
		this.parkName = parkName;
		this.parkAddress = parkAddress;
		this.type = type;
		this.pay = pay;
		this.count = count;
		this.lat = lat;
		this.lng = lng;
		this.phone = phone;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getParkAddress() {
		return parkAddress;
	}
	public void setParkAddress(String parkAddress) {
		this.parkAddress = parkAddress;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "ParkDto [ParkName=" + parkName + ", ParkAddress=" + parkAddress + ", Type=" + type + ", pay=" + pay
				+ ", count=" + count + ", lat=" + lat + ", lng=" + lng + ", phone=" + phone + "]";
	}
	
}
