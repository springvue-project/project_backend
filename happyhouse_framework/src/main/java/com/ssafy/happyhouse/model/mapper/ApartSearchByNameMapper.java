package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.ParamsForSearchAptDto;


@Mapper
public interface ApartSearchByNameMapper {

	List<HouseInfoDto> getApartSearchByName(ParamsForSearchAptDto dto) throws SQLException;
}
