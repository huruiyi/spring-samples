package com.enjoylearning.event.mapper;

import com.enjoylearning.event.entity.THotelOrder;

public interface THotelOrderMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(THotelOrder record);

	int insertSelective(THotelOrder record);

	THotelOrder selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(THotelOrder record);

	int updateByPrimaryKey(THotelOrder record);
}