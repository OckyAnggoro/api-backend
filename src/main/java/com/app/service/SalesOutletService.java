package com.app.service;

import com.app.model.SalesOutlet;
import com.app.repository.SalesOutletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesOutletService extends BaseService<SalesOutlet>{

    @Autowired
    SalesOutletRepository salesOutletRepository;

    @Override
    public Page paging(Specification specification, Pageable pageable) {
        return null;
    }

    /*public Page findAllByOutletName(String name, Pageable pageable){
        return salesOutletRepository.findAllByOutletName(name, pageable);
    }*/

    @Override
    protected SalesOutlet save(SalesOutlet salesOutlet) {
        return null;
    }

    @Override
    protected SalesOutlet update(SalesOutlet salesOutlet) {
        return null;
    }

    @Override
    public List<SalesOutlet> findByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public Optional<SalesOutlet> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<SalesOutlet> saveAll(Iterable<SalesOutlet> list) {
        return salesOutletRepository.saveAll(list);
    }

    @Override
    public List<SalesOutlet> findAllList() {
        return salesOutletRepository.findAll();
    }
}
