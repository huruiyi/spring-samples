package com.enjoylearning.event.services;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoylearning.event.entity.THotelOrder;
import com.enjoylearning.event.mapper.THotelOrderMapper;

@Service
public class HotelOrderServiceImpl implements HotelOrderService {

	@Resource
	private THotelOrderMapper mapper;

	@Resource
	private ApplicationContext context;

	@Override
	@Transactional
	public void addHotealOrder(THotelOrder order) {
		mapper.insert(order);
		context.publishEvent(order);
	}

}
