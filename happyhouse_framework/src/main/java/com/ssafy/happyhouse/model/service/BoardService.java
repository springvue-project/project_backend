package com.ssafy.happyhouse.model.service;

import java.util.List;


import com.ssafy.happyhouse.model.Board;
import com.ssafy.happyhouse.model.CommentDto;

public interface BoardService {
	public List<Board> retrieveBoard();
	public Board detailBoard(int articleno);
	public boolean writeBoard(Board board);
	public boolean updateBoard(Board board);
	public boolean deleteBoard(int articleno);
	public boolean updataHit(int articleno);
	public List<CommentDto> retrieveComment(int articleno);
}
