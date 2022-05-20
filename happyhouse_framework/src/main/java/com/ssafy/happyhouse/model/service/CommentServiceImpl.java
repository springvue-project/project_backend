package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.CommentDto;
import com.ssafy.happyhouse.model.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public List<CommentDto> retrieveComment(int articleno) {
		return commentMapper.selectComment(articleno);
	}

	@Override
	public boolean writeComment(CommentDto comment) {
		return commentMapper.insertComment(comment)==1;
	}

	@Override
	public boolean deleteBoard(int commentno) {
		return commentMapper.deleteComment(commentno)==1;
	}

}
