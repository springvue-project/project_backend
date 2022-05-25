package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.InterestDto;
import com.ssafy.happyhouse.model.mapper.InterestMapper;

@Service
public class InterestServiceImpl implements InterestService {

	@Autowired
	public InterestMapper interestMapper;

	@Override
	public int insertInterest(InterestDto interestDto) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("interestDto");
		System.out.println(interestDto.toString());
		System.out.println("========");
		if (interestMapper.searchApt(interestDto) == 1) {
			return 0; // 이미 있음
		} else {
			return interestMapper.insertInterest(interestDto);
		}
	}

	@Override
	public List<HouseInfoDto> deleteInterest(InterestDto interestDto) throws SQLException {
		interestMapper.deleteInterest(interestDto);
		return interestMapper.searchById(interestDto.getUserid());

	}

	@Override
	public List<HouseInfoDto> searchByUserID(String userid) throws SQLException {
		return interestMapper.searchById(userid);
	}

}
