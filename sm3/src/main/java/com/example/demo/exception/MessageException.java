package com.example.demo.exception;

@SuppressWarnings("serial")
public class MessageException extends Exception {

	private String msg;

	public MessageException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
