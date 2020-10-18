package com.app.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Where;

import com.app.AppConstant;
import com.app.base.BaseEntity;
import com.app.model.Action;
import com.app.model.RoleMenu;

@SuppressWarnings("serial")
@MappedSuperclass
public class ActionRoleMenuEntity extends BaseEntity{
	
	@ManyToOne
	@Where(clause = "is_deleted" + AppConstant.FLAG_NOT_DELETED)
	@JoinColumn(name = "action_id", referencedColumnName="id", nullable = true)
	private Action action;
	
	@ManyToOne
	@Where(clause = "is_deleted" + AppConstant.FLAG_NOT_DELETED)
	@JoinColumn(name = "role_menu_id", referencedColumnName="id", nullable = true)
	private RoleMenu roleMenu;

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public RoleMenu getRoleMenu() {
		return roleMenu;
	}

	public void setRoleMenu(RoleMenu roleMenu) {
		this.roleMenu = roleMenu;
	}
}
