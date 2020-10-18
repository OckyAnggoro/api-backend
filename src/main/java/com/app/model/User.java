package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.entity.UserEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "t2_user")
public class User extends UserEntity{
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String nip, String name, String userName, String email,
			String password) {
		// TODO Auto-generated constructor stub
		super(nip, name, userName, email, password);
	}

}
