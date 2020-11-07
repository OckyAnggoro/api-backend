package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name = "t1_role")
public class Role extends BaseEntity<String> {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String code;

	public Role() {

	}

	public Role(String name, String code) {
		this.name = name;
		this.code = code;
	}
}
