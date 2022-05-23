package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;

import java.util.List;

import com.ssafy.happyhouse.model.StoreDto;
import com.ssafy.happyhouse.model.StoreParamDto;

public interface StoreService {
	public List<StoreDto> searchStore(StoreParamDto storeParam) throws SQLException;

}
