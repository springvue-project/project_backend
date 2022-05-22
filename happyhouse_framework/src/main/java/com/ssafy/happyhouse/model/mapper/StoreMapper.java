package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.ssafy.happyhouse.model.StoreDto;
import com.ssafy.happyhouse.model.StoreParamDto;

@Mapper
public interface StoreMapper {
	//public List<StoreDto> searchByCodes(StoreParamDto storeParam) throws SQLException;
	public List<StoreDto> searchStore(StoreParamDto storeParam) throws SQLException;

}
