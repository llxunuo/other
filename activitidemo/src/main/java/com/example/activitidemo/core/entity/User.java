package com.example.activitidemo.core.entity;

import java.io.Serializable;


/**
 * 员工实体
 * @author anxpp.com
 */
public class User implements Serializable {
	private static final long serialVersionUID = 5922975917317707955L;
	//用户ID
	private Long id;
	//员工编号
	private String code;
	//姓名
	private String name;
	//职位
	private Integer position;
	//所属部门编码
	private Long dept;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Long getDept() {
		return dept;
	}
	public void setDept(Long dept) {
		this.dept = dept;
	}
}
