package com.example.activitidemo.simple.core.entity;

import java.io.Serializable;

/**
 * 申请单实体
 * @author anxpp.com
 * 2016年12月24日 下午12:18:34
 */

public class ApplySimple implements Serializable{
	private static final long serialVersionUID = 7116347844167214559L;
	private Long id;
	private String comtent;
	private Integer state;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComtent() {
		return comtent;
	}
	public void setComtent(String comtent) {
		this.comtent = comtent;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
