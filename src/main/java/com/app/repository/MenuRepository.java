package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{
	
	@Query("SELECT menu FROM Menu menu, RoleMenu roleMenu WHERE menu.id = roleMenu.menu.id AND roleMenu.role.code in (:roleCode) ")
	List<Menu> findByRoleCodeList(@Param("roleCode")List<String> roleCode);
	
	@Query("SELECT menu FROM Menu menu WHERE menu.id = :parentId")
	Menu findById(@Param("parentId") Integer parentId);
	
	@Query("SELECT menu FROM Menu menu WHERE menu.parentId = :id")
	List<Menu> findByParentId(@Param("id") Integer id);

}
