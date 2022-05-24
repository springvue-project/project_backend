package com.ssafy.happyhouse.model.service;



import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.ParamsForSearchAptDto;

public interface ApartSearchByNameService {

   List<HouseInfoDto> getApartSearchByNameList(ParamsForSearchAptDto dto) throws SQLException;
}