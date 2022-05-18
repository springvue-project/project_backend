package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.ParkDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.ParkService;
import com.ssafy.happyhouse.model.service.ParkServiceImpl;

@RestController
@RequestMapping("/park")
@CrossOrigin("*")
public class ParkController {
	
	@Autowired
	private ParkService parkServiceImpl;
	
	@GetMapping("/dong")
	public ResponseEntity<List<ParkDto>> parkFromDong(@RequestParam("dong") String dong) throws Exception {
		List<ParkDto> list = parkServiceImpl.parkFromDong(dong);
		System.out.println("ewfawefwaefawefawefa");
		System.out.println("리스트!!!!" + list);
		return new ResponseEntity<List<ParkDto>>(list, HttpStatus.OK);
	}
}
