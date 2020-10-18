package com.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Menu;
import com.app.repository.MenuRepository;

@Service
@Transactional
public class MenuServiceImpl implements MenuService{

	@Autowired
	MenuRepository menuRepository;

	@Override
	public List<Menu> findByRoleCode(String code) {


		List<Menu> menuList = menuRepository.findByRoleCode(code);
		List<Menu> parentMenuList = new ArrayList<Menu>();
		for (Menu menu : menuList) {
			while (menu.getParentId() != null) {
				menu = menuRepository.findById(menu.getParentId());
			}
			if (!parentMenuList.contains(menu)) {
				parentMenuList.add(menu);
			}
		}

		if (parentMenuList.size() > 0) {
			Collections.sort(parentMenuList, new Comparator<Menu>() {
				@Override
				public int compare(final Menu object1, final Menu object2) {
					return object1.getSequence().compareTo(object2.getSequence());
				}
			});
		}

		List<Menu> treeMenuList = new ArrayList<Menu>();
		for (Menu menu : parentMenuList) {
			treeMenuList.add(buildMenu(menu, code));
		}

		List<Menu> cleanMenuList = new ArrayList<Menu>();

		for (Menu menu : treeMenuList) {
			cleanMenuList.add(clearEmptyParentMenu(menu));
		}

		return cleanMenuList;
	
	}

	private Menu buildMenu(Menu menu, String code) {
		List<Menu> childList = menuRepository.findByParentId(menu.getId());
		List<Menu> menuListByRole = menuRepository.findByRoleCode(code);

		if (childList.size() > 0) {
			List<Menu> newChildList = new ArrayList<Menu>();
			for (Menu child : childList) {
				List<Menu> numChild = menuRepository.findByParentId(child.getId());

				// if menu is folder
				if (numChild.size() > 0) {
					buildMenu(child, code);
					newChildList.add(child);

				} else
				// if menu is Leaf
				{
					if (menuListByRole.contains(child)) {
						newChildList.add(child);
					}
				}
			}
			menu.setChildMenuList(newChildList);
		}
		return menu;
	}
	

	private Menu clearEmptyParentMenu(Menu menu) {
		List<Menu> childList = menu.getChildMenuList();
		if (childList != null) {
			List<Menu> newChildList = new ArrayList<Menu>();
			for (Menu child : childList) {
				if (child.getChildMenuList() != null && child.getChildMenuList().size() > 0) {
					clearEmptyParentMenu(child);
					newChildList.add(child);
				} else {
					if (child.getPath() != null) {
						newChildList.add(child);
					}
				}
			}
			menu.setChildMenuList(newChildList);
		}
		return menu;
	}


	public Integer getLastSequence() {
		return null;//menuRepository.getLastSequence();
	}

}
