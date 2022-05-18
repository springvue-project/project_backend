package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.ApartDto;

public interface ApartService {

   List<ApartDto> getApartList(int aptCode) throws Exception;
}