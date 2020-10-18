package com.app.service;

import java.util.List;

import com.app.base.TableRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.base.BaseEntity;
import com.app.repository.GenericRepository;

@Service
public class BaseServiceImpl<E extends BaseEntity> {

	GenericRepository<E> genricRepository;

	public Page<E> findPage(TableRequest tableRequest) {
		// return genricRepository.findPage(tableRequest);
		return null;
	}

	@Transactional
	public E findByCode(String code) {
		// TODO Auto-generated method stub
		return genricRepository.findByCode(code);
	}

	@Transactional
	public boolean checkAlreadyCode(String code) {
		// TODO Auto-generated method stub
		E entity = genricRepository.findByCode(code);
        return entity == null;
    }

	@Transactional
	public E save(E entity) {
		return (E) genricRepository.save(entity);
	}

	public List<E> findList() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean testChat(String message) {
		if(message.equalsIgnoreCase("2020")){
			return true;
		}else{
			return false;
		}

	}


}
