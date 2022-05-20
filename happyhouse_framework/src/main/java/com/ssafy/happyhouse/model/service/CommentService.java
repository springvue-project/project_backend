package com.ssafy.happyhouse.model.service;

import java.util.List;


import com.ssafy.happyhouse.model.Board;
import com.ssafy.happyhouse.model.CommentDto;

public interface CommentService {
	public List<CommentDto> retrieveComment(int articleno);
	public boolean writeComment(CommentDto comment);
	//public boolean updateComment(CommentDto comment);
	public boolean deleteBoard(int commentno);
	
}
