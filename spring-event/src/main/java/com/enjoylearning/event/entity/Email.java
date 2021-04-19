package com.enjoylearning.event.entity;

import java.io.Serializable;

public class Email implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;

	private String receiver;

	private String content;

	public Email(String title, String receiver, String content) {
		super();
		this.title = title;
		this.receiver = receiver;
		this.content = content;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
