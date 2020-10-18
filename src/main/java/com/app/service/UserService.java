package com.app.service;

import org.springframework.data.domain.Page;

import com.app.base.TableRequest;
import com.app.model.User;

public interface UserService {

	Page<User> findUser(TableRequest tableRequest);
}
