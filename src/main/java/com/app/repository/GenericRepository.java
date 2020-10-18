package com.app.repository;

import java.util.List;

import com.app.base.TableRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.AppConstant;
import com.app.base.BaseEntity;
import org.springframework.stereotype.Service;

@NoRepositoryBean
public interface GenericRepository<E> extends JpaRepository<E, Integer> {

	@Query("SELECT t FROM #{#entityName} t WHERE t.code = :code ")
    E findByCode(@Param("code") String code);

	@Query("SELECT t FROM #{#entityName} t WHERE t.isDelete = " + AppConstant.FLAG_NOT_DELETED)
    List<E> findAll();

}
