package com.app.service;


import com.app.model.Item;
import com.app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ItemService extends BaseServiceImpl<Item>{
	
	@Autowired
	ItemRepository itemRepository;

	public Page<Item> findItem(Specification generalSpecification, Pageable pageable) {
		return itemRepository.findAll(generalSpecification, pageable);
	}

	/*@Override
	public Item findByCode(String code) {
		// TODO Auto-generated method stub
		Item item = itemRepository.findByCode(code);
		return item;
	}

	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}

	@Override
	public List<Item> findByName(String name) {
		// TODO Auto-generated method stub
		return itemRepository.findByName(name);
	}*/

}
