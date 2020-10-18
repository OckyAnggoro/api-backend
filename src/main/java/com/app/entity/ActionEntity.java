package com.app.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.app.base.BaseEntity;

@SuppressWarnings("serial")
@MappedSuperclass
public class ActionEntity extends BaseEntity{

	@Column(length = 32, nullable = false)
	private String name;
	
	@Column(length = 8, nullable = false)
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
