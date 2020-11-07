package com.app.service;


import com.app.model.Item;
import com.app.model.Uom;
import com.app.repository.GenericRepository;
import com.app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class ItemService extends BaseService<Item>{
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public Page paging(Specification specification, Pageable pageable) {
		return itemRepository.findAll(specification, pageable);
	}

	@Override
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public Item update(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> findByIds(List<Integer> ids) {
		return null;
	}

	@Override
	public Optional<Item> findById(Integer id) {
		return itemRepository.findById(id);
	}

	public Optional<Item> findByCode(String code) {
		return itemRepository.findByCode(code);
	}

	@Override
	public List<Item> findAllList() {
		return itemRepository.findAll();
	}

	@Override
	public void deleteByIds(List<Integer> ids) {
		itemRepository.softDeleteByIds(ids);
	}
}
