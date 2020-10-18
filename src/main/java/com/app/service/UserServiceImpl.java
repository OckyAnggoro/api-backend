package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.base.TableRequest;
import com.app.model.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Page<User> findUser(TableRequest tableRequest) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(tableRequest.getPage(), tableRequest.getSize(), Sort.by("name"));
		return userRepository.findAll(pageable);
	}

}
