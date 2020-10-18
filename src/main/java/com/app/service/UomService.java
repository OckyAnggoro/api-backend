package com.app.service;

import com.app.model.Uom;
import com.app.repository.UomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UomService extends BaseServiceImpl<Uom> {

    @Autowired
    private UomRepository uomRepository;

    @Transactional
    public Page<Uom> findUom(Specification generalSpecification, Pageable pageable) {
        return uomRepository.findAll(generalSpecification, pageable);
    }

}
