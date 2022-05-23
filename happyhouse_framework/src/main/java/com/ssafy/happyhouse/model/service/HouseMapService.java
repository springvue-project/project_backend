package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.ApartDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.LatLngParamDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;

public interface HouseMapService {

   List<SidoGugunCodeDto> getSido() throws Exception;
   List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
   List<SidoGugunCodeDto> getDongInGugun(String gugun) throws Exception;
   List<HouseInfoDto> getAptInDong(String dong) throws Exception;
   List<HouseInfoDto> getAptInDongSortDistance(String dong, int type) throws Exception;
   Map<String,String> getlatlng(String dong) throws Exception;
   
   List<ApartDto> getAptDeal(String aptCode) throws Exception;
   List<HouseInfoDto> searchBestApt(LatLngParamDto latlng) throws SQLException;
}