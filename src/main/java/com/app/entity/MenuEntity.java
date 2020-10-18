package com.app.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.app.base.BaseEntity;

@SuppressWarnings("serial")
@MappedSuperclass
public class MenuEntity extends BaseEntity{

	@Column(length = 32, nullable = false)
	private String name;
	
	@Column(length = 8, nullable = false)
	private String code;
	
	@Column(length = 512)
	private String description;
	
	@Column(length = 32, nullable = false)
	private String path;
	
	@Column(length = 11)
	private Integer parentId;
	
	@Column(length = 11)
	private Integer sequence;
	
	@Column(length = 32)
	private String icon;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


}
