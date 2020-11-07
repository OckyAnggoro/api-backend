package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.Menu;
import com.app.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends BaseService<Menu> {

	@Autowired
	MenuRepository menuRepository;

	public List<Menu> findByRoleCodeList(List<String> roleCodeList) {
		return menuRepository.findByRoleCodeList(roleCodeList);
	}

	@Override
	protected Page paging(Specification specification, Pageable pageable) {
		return null;
	}

	@Override
	protected Menu save(Menu menu) {
		return null;
	}

	@Override
	protected Menu update(Menu menu) {
		return null;
	}

	@Override
	public void deleteByIds(List<Integer> ids) {
		super.deleteByIds(ids);
	}

	@Override
	public List<Menu> findByIds(List<Integer> ids) {
		return null;
	}

	@Override
	public Optional<Menu> findById(Integer id) {
		return Optional.empty();
	}

	@Override
	public List<Menu> findAllList() {
		return super.findAllList();
	}

	@Override
	public List<Menu> saveAll(Iterable<Menu> list) {
		return super.saveAll(list);
	}

	/*public List<Menu> getListNotByRoleId(Integer roleId) {
		List<Menu> menuListNotByRole = menuRepository.getListNotByRole(roleId);
		return menuListNotByRole;
	}
	
	public List<Menu>  getListByRoleId(Integer roleId) {
		List<Menu> menuListByRole = menuRepository.getListByRole(roleId);
		return menuListByRole;
	}*/

}
