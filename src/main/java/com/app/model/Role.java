package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.entity.RoleEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "t1_role")
public class Role extends RoleEntity{

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(String name, String code) {
		super(name, code);
		// TODO Auto-generated constructor stub
	}

	public Object stream() {
		// TODO Auto-generated method stub
		return null;
	}

}
