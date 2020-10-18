package com.app.jwtauthentication.security.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.User;
import com.app.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with -> "
						+ "username or email : " + userName));
		return UserPrinciple.build(user);
	}

}
