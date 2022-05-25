package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.InterestDto;

public interface InterestMapper {
	
	//관심 아파트 리스트 
	List<HouseInfoDto> searchById(String userid) throws SQLException;
	//관심 지역 등록
	int insertInterest(InterestDto InterestDto) throws SQLException;
	//관심 지역 삭제
	void deleteInterest(InterestDto InterestDto) throws SQLException;
	// 관심 아파트 등록 확인
	int searchApt(InterestDto InterestDto) throws SQLException;
}
