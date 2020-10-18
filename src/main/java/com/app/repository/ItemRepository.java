package com.app.repository;

import java.util.List;

import com.app.model.Uom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.AppConstant;
import com.app.model.Item;

@Repository
public interface ItemRepository extends GenericRepository<Item>, JpaSpecificationExecutor<Item>{

	// Item findByCode(String code);
	
//	@Query("SELECT DISTINCT (item) FROM Item item where item.name like %:name% AND item.isDelete = 0 ")
//	List<Item> findByName(@Param("name") String name);
	
//	@Query("SELECT item FROM Item item where (item.name like %:search% OR item.code like %:search% OR item.uom.name like %:search%) "
//			+ "AND item.isDelete = " + AppConstant.FLAG_NOT_DELETED)
//	Page<Item> findAll(@Param("search")String search, Pageable pageable);

}
