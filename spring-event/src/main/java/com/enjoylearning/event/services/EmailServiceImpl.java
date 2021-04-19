package com.enjoylearning.event.services;

import java.io.File;
import java.io.IOException;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.SerializationUtils;

import com.enjoylearning.event.entity.Email;
import com.enjoylearning.event.entity.THotelOrder;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	// email → 对象输入流 → 缓存输出流→文件输出流
	public void sendEmail(Email email) {
		try {
			FileCopyUtils.copy(SerializationUtils.serialize(email), new File("E:/email/" + email.getTitle()));
		} catch (IOException e) {
			throw new RuntimeException("邮件发送失败，异常信息：" + e.getMessage());
		}
	}

	@EventListener
	public void handlerHotelOrder(THotelOrder order) {
		// 2.发送提醒邮件
		Email email = new Email("酒店预订成功通知邮件", order.getUcode(), "恭喜您酒店预订成功！");
		sendEmail(email);
	}

}
