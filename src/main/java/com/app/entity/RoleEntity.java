package com.app.entity;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


import com.app.base.BaseEntity;

@SuppressWarnings("serial")
@MappedSuperclass
public class RoleEntity extends BaseEntity{
	
	@Column(length = 32, nullable = false)
	private String name;
	
	@Column(length = 8, nullable = false)
	private String code;

	public RoleEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public RoleEntity(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
