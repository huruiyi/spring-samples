package com.enjoylearning.event.entity;

import java.util.Date;

public class TMsg {
	private Integer id;

	private String user;

	private String phone;

	private String content;

	private Date createtime;

	public TMsg(Integer id, String user, String phone, String content, Date createtime) {
		super();
		this.id = id;
		this.user = user;
		this.phone = phone;
		this.content = content;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}