package com.app.jwtauthentication.security.services;
import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.stream.Collectors;


public class UserPrinciple implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String name;
	
	private String userName;
	
	private String email;
	
	@JsonIgnore
	private String password;

	@SuppressWarnings("unused")
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserPrinciple(Integer id, String name, 
            String userName, String email, String password, 
            Collection<? extends GrantedAuthority> authorities) {
      this.id = id;
      this.name = name;
      this.userName = userName;
      this.email = email;
      this.password = password;
      this.authorities = authorities;
	}
	
	
	public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getCode())
        ).collect(Collectors.toList());
 
        return new UserPrinciple(
                user.getId(),
                user.getName(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }
	
	public Integer getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
	}
}
