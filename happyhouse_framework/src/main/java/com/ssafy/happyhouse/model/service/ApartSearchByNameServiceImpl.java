package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.ParamsForSearchAptDto;
import com.ssafy.happyhouse.model.mapper.ApartSearchByNameMapper;

@Service
public class ApartSearchByNameServiceImpl implements ApartSearchByNameService{

	@Autowired
	private ApartSearchByNameMapper apartSearchByNameMapper;

	@Override
	public List<HouseInfoDto> getApartSearchByNameList(ParamsForSearchAptDto dto) throws SQLException{
		List<HouseInfoDto> list = null;
		list = apartSearchByNameMapper.getApartSearchByName(dto);
		System.out.println(list.toString());
		return apartSearchByNameMapper.getApartSearchByName(dto);
	}
	
}
