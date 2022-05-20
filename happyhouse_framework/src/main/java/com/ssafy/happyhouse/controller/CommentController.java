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


import com.ssafy.happyhouse.model.CommentDto;
import com.ssafy.happyhouse.model.service.CommentService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/comment")
public class CommentController {

	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private CommentService comService;

    @ApiOperation(value = "해당 게시글의 댓글 반환한다.", response = List.class)
	@GetMapping("{articleno}")
	public ResponseEntity<List<CommentDto>> retrieveComment(@PathVariable int articleno) throws Exception {
		logger.debug("retrieveComment - 호출");
		return new ResponseEntity<List<CommentDto>>(comService.retrieveComment(articleno), HttpStatus.OK);
	}

    @ApiOperation(value = "댓글 입력", response = String.class)
	@PostMapping("{articleno}")
	public ResponseEntity<String> writeComment(@RequestBody CommentDto comment) {
		logger.debug("writeBoard - 호출");
		if (comService.writeComment(comment)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

//  @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
//	@PutMapping("{commentno}")
//	public ResponseEntity<String> updateComment(@RequestBody CommentDto comment) {
//		logger.debug("updateComment - 호출");
//		logger.debug("" + comment);
//		
//		if (comService.updateComment(comment)) {
//			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//		}
//		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//	}

    @ApiOperation(value = "댓글을 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{commentno}")
	public ResponseEntity<String> deleteComment(@PathVariable int commentno) {
		logger.debug("deleteComment - 호출");
		if (comService.deleteBoard(commentno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
}