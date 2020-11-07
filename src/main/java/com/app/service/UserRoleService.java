package com.app.service;

import com.app.model.UserRole;
import com.app.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService extends BaseService<UserRole>{

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    protected Page paging(Specification specification, Pageable pageable) {
        return null;
    }

    @Override
    protected UserRole save(UserRole userRole) {
        return null;
    }

    @Override
    protected UserRole update(UserRole userRole) {
        return null;
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        super.deleteByIds(ids);
    }

    @Override
    public List<UserRole> findByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public Optional<UserRole> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<UserRole> findAllList() {
        return super.findAllList();
    }

    public Page<UserRole> findAllByRoleCode(String roleCode, Pageable pageable) {
        return userRoleRepository.findAllByRoleCode(roleCode, pageable);
    }
}
