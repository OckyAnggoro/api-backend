package com.app.repository;

import com.app.model.SalesOutlet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOutletRepository extends GenericRepository<SalesOutlet>{

//    Page<SalesOutlet> findAllByOutletName(String name, Pageable pageable);
}
