package com.app.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.AppConstant;
import com.app.model.Uom;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UomRepository extends GenericRepository<Uom>{

    Optional<Uom> findByCode(String code);
}
