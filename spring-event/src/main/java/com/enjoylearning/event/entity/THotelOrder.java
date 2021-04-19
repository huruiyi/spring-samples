package com.enjoylearning.event.entity;

import java.util.Date;

public class THotelOrder {
	private Integer id;

	private String ucode;

	private String hcode;

	private Date createtime;

	public THotelOrder(Integer id, String ucode, String hcode, Date createtime) {
		super();
		this.id = id;
		this.ucode = ucode;
		this.hcode = hcode;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUcode() {
		return ucode;
	}

	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

	public String getHcode() {
		return hcode;
	}

	public void setHcode(String hcode) {
		this.hcode = hcode;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}