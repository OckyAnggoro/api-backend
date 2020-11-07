package com.app.repository;

import com.app.model.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends GenericRepository<UserRole> {

    Page<UserRole> findAllByRoleCode(String roleCode, Pageable pageable);
}
