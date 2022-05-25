package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;

import java.util.List;


import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.InterestDto;

public interface InterestService {
	// 관심지역 등록
	int insertInterest(InterestDto interestDto) throws SQLException;
	// 관심지역 삭제
	List<HouseInfoDto> deleteInterest(InterestDto interestDto) throws SQLException;
	
	List<HouseInfoDto> searchByUserID(String userid) throws SQLException;
}
