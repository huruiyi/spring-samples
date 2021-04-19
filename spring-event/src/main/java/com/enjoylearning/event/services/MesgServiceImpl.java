package com.enjoylearning.event.services;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.enjoylearning.event.entity.THotelOrder;
import com.enjoylearning.event.entity.TMsg;
import com.enjoylearning.event.mapper.TMsgMapper;

@Service
public class MesgServiceImpl implements MesgService {

	@Resource
	private TMsgMapper mapper;

	@Override
	public void sendMesg(TMsg mseg) {
		mapper.insert(mseg);
	}

	@EventListener
	public void handlerHotelOrder(THotelOrder order) {
//		//1.发送提醒短信
		TMsg mesg = new TMsg(1, order.getUcode(), "18699775544", "恭喜您酒店预订成功！", new Date());
		sendMesg(mesg);
	}

}
