package com.app.service;

import com.app.model.Uom;
import com.app.repository.UomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UomService extends BaseService<Uom> {

    @Autowired
    private UomRepository uomRepository;

    @Override
    public Page paging(Specification specification, Pageable pageable) {
        return uomRepository.findAll(specification, pageable);
    }

    @Override
    public Uom save(Uom uom) {
        return uomRepository.save(uom);
    }

    @Override
    public Uom update(Uom uom) {
        return uomRepository.save(uom);
    }

    @Override
    public Optional<Uom> findById(Integer id) {
        return uomRepository.findById(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        uomRepository.softDeleteByIds(ids);
    }

    @Override
    public List<Uom> findByIds(List<Integer> ids) {
        return uomRepository.findAllById(ids);
    }

    public Optional<Uom> findByCode(String code) {
        return uomRepository.findByCode(code);
    }

    @Override
    public List<Uom> findAllList() {
        return uomRepository.findAll();
    }
}
