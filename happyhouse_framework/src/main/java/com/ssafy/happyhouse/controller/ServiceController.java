package com.ssafy.happyhouse.controller;

import java.sql.SQLException;



import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.StoreDto;
import com.ssafy.happyhouse.model.StoreParamDto;
import com.ssafy.happyhouse.model.service.StoreService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
@RequestMapping("/service")
public class ServiceController {
	
	private final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	StoreService storeServ;
	
	@GetMapping(value="/searchStore")
	@ResponseBody
	public ResponseEntity<List<StoreDto>> searchStoreByCode(
			@RequestParam("lat") String lat, @RequestParam("lng") String lng,
			@RequestParam("codeType") String codeType, @RequestParam("code") String code,
			@RequestParam("distance") String distance
			) throws SQLException{
		StoreParamDto storeParam = new StoreParamDto(lat, lng, codeType, code, distance);

		logger.debug("storeParam =>{}", storeParam.toString());
		
		return new ResponseEntity<List<StoreDto>>(storeServ.searchStore(storeParam),HttpStatus.OK);
	}



}
