package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.StoreDto;
import com.ssafy.happyhouse.model.StoreParamDto;
import com.ssafy.happyhouse.model.mapper.StoreMapper;


@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	StoreMapper storeMapper;

	@Override
	public List<StoreDto> searchStore(StoreParamDto storeParam) throws SQLException {
		return storeMapper.searchStore(storeParam);
	}


	
}
