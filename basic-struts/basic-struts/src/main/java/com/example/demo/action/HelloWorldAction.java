package com.example.demo.action;

import com.example.demo.model.MessageStore;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 4259718520890377622L;

	private MessageStore messageStore;

	private static int helloCount = 0;

	private String userName;

	@Override
	public String execute() throws Exception {
		messageStore = new MessageStore();
		if (userName != null) {
			messageStore.setMessage(messageStore.getMessage() + " " + userName);
		}
		helloCount++;

		return SUCCESS;
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}

	public int getHelloCount() {
		return helloCount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
