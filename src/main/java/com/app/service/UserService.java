package com.app.service;

import com.app.model.SalesOutlet;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.app.base.TableRequest;
import com.app.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends BaseService<User>{

	@Autowired
	UserRepository userRepository;

	@Override
	public Page paging(Specification specification, Pageable pageable) {
		return null;
	}

	@Override
	public User save(User user) {
		return null;
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public List<User> findByIds(List<Integer> ids) {
		return null;
	}

	@Override
	public Optional<User> findById(Integer id) {
		return Optional.empty();
	}

	@Override
	public List<User> saveAll(Iterable<User> list) {
		return userRepository.saveAll(list);
	}

	public Page<User> findUser(TableRequest tableRequest) {
		return null;
	}
}
