package com.ssafy.happyhouse.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.AnnounceDto;
import com.ssafy.happyhouse.model.Board;
import com.ssafy.happyhouse.model.mapper.AnnounceMapper;
import com.ssafy.happyhouse.model.mapper.BoardMapper;

@Service
public class AnnounceServiceImpl implements AnnounceService {
	
    @Autowired
	private AnnounceMapper announceMapper;

	@Override
	public List<AnnounceDto> list() {
		return announceMapper.selectAll();
	}
	
	@Override
	public List<AnnounceDto> listlast() {
		return announceMapper.selectLast();
	}

	@Override
	public AnnounceDto detail(int no) {
		if(announceMapper.updateHit(no)==1) {
			return announceMapper.selectByNo(no);
		}else {
			return null;
		}
	}

	@Override
	public boolean insert(AnnounceDto announceDto) {
		return announceMapper.insert(announceDto)==1;
	}

	@Override
	public boolean update(AnnounceDto announceDto) {
		return announceMapper.update(announceDto)==1;
	}

	@Override
	public boolean delete(int no) {
		return announceMapper.delete(no)==1;
	}

	@Override
	public boolean updateHit(int no) {
		return announceMapper.updateHit(no)==1;
	}

	


}