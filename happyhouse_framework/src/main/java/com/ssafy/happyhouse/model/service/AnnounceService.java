package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.AnnounceDto;

public interface AnnounceService {
	public List<AnnounceDto> list();
	public AnnounceDto detail(int no);
	public boolean insert(AnnounceDto announceDto);
	public boolean update(AnnounceDto announceDto);
	public boolean delete(int no);
	public boolean updateHit(int no);
}
