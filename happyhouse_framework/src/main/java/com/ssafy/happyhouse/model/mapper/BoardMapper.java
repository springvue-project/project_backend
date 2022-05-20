package com.ssafy.happyhouse.model.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.Board;
import com.ssafy.happyhouse.model.CommentDto;
@Mapper
public interface BoardMapper {
	public List<Board> selectBoard();
	public Board selectBoardByNo(int articleno);
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public int deleteBoard(int articleno);
	public int updateHit(int articelno);
	public List<CommentDto> selectComment(int articleno);
}