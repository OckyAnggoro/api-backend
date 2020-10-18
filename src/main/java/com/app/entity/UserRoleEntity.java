package com.app.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Where;

import com.app.AppConstant;
import com.app.base.BaseEntity;
import com.app.model.Role;
import com.app.model.User;

@SuppressWarnings("serial")
@MappedSuperclass
public class UserRoleEntity extends BaseEntity{

	@ManyToOne
	@Where(clause = "is_deleted" + AppConstant.FLAG_NOT_DELETED)
	@JoinColumn(name = "role_id", referencedColumnName="id", nullable = true)
	private Role role; 
	
	@ManyToOne
	@Where(clause = "is_deleted" + AppConstant.FLAG_NOT_DELETED)
	@JoinColumn(name = "user_id", referencedColumnName="id", nullable = true)
	private User user;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} 
}
