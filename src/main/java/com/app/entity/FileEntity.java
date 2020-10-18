package com.app.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.app.base.BaseEntity;

@SuppressWarnings("serial")
@MappedSuperclass
public class FileEntity extends BaseEntity{
	
	@Column(length = 128, nullable = false)
	private String name;
	
	@Column(length = 64, nullable = false)
	private String realName;
	
	@Column(length = 11, nullable = false)
	private Integer size;
	
	@Column(length = 16, nullable = false)
	private String extension;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

}
