package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.happyhouse.model.CommentDto;

@Mapper
public interface CommentMapper {
	public List<CommentDto> selectComment(int articleno);
	public int insertComment(CommentDto comment);
	//public int updateBoard(CommentDto comment);
	public int deleteComment(int commentno);
}