package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

public class Main implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String mainname;
	private Set<Sub> subs = new HashSet<Sub>(0);

	public Main() {
	}

	public Main(String mainname, Set<Sub> subs) {
		this.mainname = mainname;
		this.subs = subs;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMainname() {
		return this.mainname;
	}

	public void setMainname(String mainname) {
		this.mainname = mainname;
	}

	public Set<Sub> getSubs() {
		return this.subs;
	}

	public void setSubs(Set<Sub> subs) {
		this.subs = subs;
	}

}