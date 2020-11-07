package com.app.service;

import com.app.model.Outlet;
import com.app.repository.OutletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutletService extends BaseService<Outlet>{

    @Autowired
    OutletRepository outletRepository;

    @Override
    public Page paging(Specification specification, Pageable pageable) {
        return outletRepository.findAll(specification, pageable);
    }

    @Override
    public Outlet save(Outlet outlet) {
        return outletRepository.save(outlet);
    }

    @Override
    protected Outlet update(Outlet outlet) {
        return outletRepository.save(outlet);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        outletRepository.softDeleteByIds(ids);
    }

    @Override
    public List<Outlet> findByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public Optional<Outlet> findById(Integer id) {
        return outletRepository.findById(id);
    }

    @Override
    public List<Outlet> findAllList() {
        return super.findAllList();
    }
}
