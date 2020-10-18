package com.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.AppConstant;
import com.app.model.Uom;

import java.util.List;

@Repository
public interface UomRepository extends GenericRepository<Uom>, JpaSpecificationExecutor<Uom> {

}
