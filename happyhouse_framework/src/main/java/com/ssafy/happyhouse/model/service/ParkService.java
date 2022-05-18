package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.ParkDto;


public interface ParkService {
	List<ParkDto> parkFromDong(String dong) throws Exception;
}
