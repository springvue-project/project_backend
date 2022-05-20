package com.ssafy.happyhouse.model.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.AnnounceDto;

@Mapper
public interface AnnounceMapper {
	public List<AnnounceDto> selectAll();
	public AnnounceDto selectByNo(int no);
	public int insert(AnnounceDto announceDto);
	public int update(AnnounceDto announceDto);
	public int delete(int no);
	public int updateHit(int no);
}