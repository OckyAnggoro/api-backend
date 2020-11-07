package com.app.service;

import com.app.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<E> {

    protected abstract Page paging(Specification specification, Pageable pageable);

    protected abstract E save(E e);

    protected abstract E update(E e);

    public void deleteByIds(List<Integer> ids){

    }

    public abstract List<E> findByIds(List<Integer> ids);

    public abstract Optional<E> findById(Integer id);

    public List<E> findAllList(){
        return null;
    }

    public List<E> saveAll(Iterable<E> list) {
        return null;
    }
}
