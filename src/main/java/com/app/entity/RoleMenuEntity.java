package com.app.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Where;

import com.app.AppConstant;
import com.app.base.BaseEntity;
import com.app.model.Menu;
import com.app.model.Role;

@SuppressWarnings("serial")
@MappedSuperclass
public class RoleMenuEntity extends BaseEntity{

	@ManyToOne
	@Where(clause = "is_deleted" + AppConstant.FLAG_NOT_DELETED)
	@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
	private Role role;
	
	@ManyToOne
	@Where(clause = "is_deleted" + AppConstant.FLAG_NOT_DELETED)
	@JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false)
	private Menu menu;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	
}
