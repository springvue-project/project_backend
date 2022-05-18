package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.ApartDto;

@Mapper
public interface ApartMapper {
   List<ApartDto> getApartList(int aptCode) throws Exception;
}