package com.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.app.entity.MenuEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "t1_menu")
public class Menu extends MenuEntity{
	
	@Transient
	private List<Menu> childMenuList;

	public List<Menu> getChildMenuList() {
		return childMenuList;
	}

	public void setChildMenuList(List<Menu> childMenuList) {
		this.childMenuList = childMenuList;
	}


}
