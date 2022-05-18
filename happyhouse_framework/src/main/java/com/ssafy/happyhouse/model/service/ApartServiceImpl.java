package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.ApartDto;
import com.ssafy.happyhouse.model.mapper.ApartMapper;

@Service
public class ApartServiceImpl implements ApartService{

   
   @Autowired
   private ApartMapper apartMapper;
   
   @Override
   public List<ApartDto> getApartList(int aptCode) throws Exception {
      return apartMapper.getApartList(aptCode);
   }

}