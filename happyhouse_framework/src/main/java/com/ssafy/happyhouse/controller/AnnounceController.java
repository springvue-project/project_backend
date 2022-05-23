package com.ssafy.happyhouse.controller;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.AnnounceDto;
import com.ssafy.happyhouse.model.service.AnnounceService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/announce")
public class AnnounceController {

	private static final Logger logger = LoggerFactory.getLogger(AnnounceController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private AnnounceService announceService;

    @ApiOperation(value = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<AnnounceDto>> retrieveAnnounce() throws Exception {
		logger.debug("retrieveAnnounce - 호출");
		return new ResponseEntity<List<AnnounceDto>>(announceService.list(), HttpStatus.OK);
	}
    
    @ApiOperation(value = "최근 공지사항 3개의 정보를 반환한다.", response = List.class)
	@GetMapping("/last")
	public ResponseEntity<List<AnnounceDto>> lastAnnounce() throws Exception {
		logger.debug("retrieveAnnounce - 호출");
		return new ResponseEntity<List<AnnounceDto>>(announceService.listlast(), HttpStatus.OK);
	}

    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 반환한다.", response = AnnounceDto.class)    
	@GetMapping("{no}")
	public ResponseEntity<AnnounceDto> detailAnnounce(@PathVariable int no) {
		logger.debug("detailAnnounce - 호출");
		return new ResponseEntity<AnnounceDto>(announceService.detail(no), HttpStatus.OK);
	}

    @ApiOperation(value = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeAnnounce(@RequestBody AnnounceDto announce) {
		logger.debug("writeAnnounce - 호출");
		if (announceService.insert(announce)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{no}")
	public ResponseEntity<String> updateAnnounce(@RequestBody AnnounceDto announce) {
		logger.debug("updateAnnounce  - 호출");
		logger.debug("" + announce);
		
		if (announceService.update(announce)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{no}")
	public ResponseEntity<String> deleteAnnounce(@PathVariable int no) {
		logger.debug("deleteAnnounce - 호출");
		if (announceService.delete(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}