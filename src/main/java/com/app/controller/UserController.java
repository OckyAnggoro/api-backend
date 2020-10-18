package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.base.TableRequest;
import com.app.model.User;
import com.app.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/findUser")
	public ResponseEntity<Page<User>> findUser(@RequestBody TableRequest tableRequest){
		Page<User> page = userService.findUser(tableRequest);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

}
