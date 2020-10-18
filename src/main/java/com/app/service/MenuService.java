package com.app.service;

import java.util.List;

import com.app.model.Menu;

public interface MenuService {
	
	List<Menu> findByRoleCode(String code);

	/*public List<Menu> getListNotByRoleId(Integer roleId) {
		List<Menu> menuListNotByRole = menuRepository.getListNotByRole(roleId);
		return menuListNotByRole;
	}
	
	public List<Menu>  getListByRoleId(Integer roleId) {
		List<Menu> menuListByRole = menuRepository.getListByRole(roleId);
		return menuListByRole;
	}*/

}
