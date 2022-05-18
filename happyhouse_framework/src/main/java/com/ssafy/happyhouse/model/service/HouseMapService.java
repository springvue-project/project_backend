package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;

public interface HouseMapService {

   List<SidoGugunCodeDto> getSido() throws Exception;
   List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
   List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
   List<HouseInfoDto> getAptInDong(String dong) throws Exception;
   List<HouseInfoDto> getAptInDongSortDistance(String dong, int type) throws Exception;
   Map<String,String> getlatlng(String dong) throws Exception;
}