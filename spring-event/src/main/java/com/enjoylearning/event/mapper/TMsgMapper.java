package com.enjoylearning.event.mapper;

import com.enjoylearning.event.entity.TMsg;

public interface TMsgMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(TMsg record);

	int insertSelective(TMsg record);

	TMsg selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TMsg record);

	int updateByPrimaryKey(TMsg record);
}