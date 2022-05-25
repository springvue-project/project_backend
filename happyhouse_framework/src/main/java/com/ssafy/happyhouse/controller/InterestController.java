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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.InterestDto;
import com.ssafy.happyhouse.model.service.InterestService;

import io.swagger.annotations.ApiOperation;

@Controller
@CrossOrigin("*")
@RequestMapping("/interest")
public class InterestController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	public InterestService interService; 
	
	@ApiOperation(value = "사용자의 관심 지역 리스트 조회", response = List.class)
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<List<HouseInfoDto>> interestList(@PathVariable("id") String userid) throws SQLException {
		return new ResponseEntity<List<HouseInfoDto>>(interService.searchByUserID(userid),HttpStatus.OK);
	}
	
	@ApiOperation(value = "사용자의 관심지역 리스트 중 해당 id를 가진 리스트 삭제 후, 사용자의 관심지역 리스트 반환 ", response = List.class)
	@DeleteMapping("/{id}/{aptCode}")
	public ResponseEntity<List<HouseInfoDto>> interestDelete(@PathVariable("id") String userid ,@PathVariable("aptCode") String aptCode) throws SQLException {
		interService.deleteInterest(new InterestDto(userid, aptCode));
		return new ResponseEntity<List<HouseInfoDto>>(interService.searchByUserID(userid),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> interest(@RequestBody InterestDto interestDto) throws Exception{
		System.out.println(interestDto.getUserid());
		int result = interService.insertInterest(interestDto);
		if(result == 0 ) {
			return new ResponseEntity<String>(FAIL,HttpStatus.NO_CONTENT);
		}else if(result == 1) {
			return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(FAIL,HttpStatus.NO_CONTENT);
		}
	}

	
}
