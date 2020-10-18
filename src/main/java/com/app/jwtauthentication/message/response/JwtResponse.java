package com.app.jwtauthentication.message.response;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.app.model.Menu;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String userName;
	private Collection<? extends GrantedAuthority> authorities;
	private List<Menu> menuList;
	 
	  public JwtResponse(String accessToken, String userName,
			  Collection<? extends GrantedAuthority> authorities, List<Menu> menuList) {
	    this.token = accessToken;
	    this.userName = userName;
	    this.authorities = authorities;
	    this.menuList = menuList;
	  }
	 
	  public String getAccessToken() {
	    return token;
	  }
	 
	  public void setAccessToken(String accessToken) {
	    this.token = accessToken;
	  }
	 
	  public String getTokenType() {
	    return type;
	  }
	 
	  public void setTokenType(String tokenType) {
	    this.type = tokenType;
	  }
	  
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return authorities;
	  }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

}
