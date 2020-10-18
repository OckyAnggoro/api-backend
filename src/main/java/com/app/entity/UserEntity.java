package com.app.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Where;

import com.app.AppConstant;
import com.app.base.BaseEntity;
import com.app.model.File;
import com.app.model.Role;

@SuppressWarnings("serial")
@MappedSuperclass
public class UserEntity extends BaseEntity{
	
	@Column(nullable = false)
	private String nip;
	
	@Column(length = 128, nullable = false)
	private String name;
	
	@Column(length = 64, nullable = false)
	private String userName;
	
	@Column(length = 64, nullable = false)
	private String email;
	
	@Column(length = 64, nullable = false)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	//@Where(clause = "is_deleted" + AppConstant.FLAG_NOT_DELETED)
	@JoinTable(name = "t3_user_role", joinColumns=@JoinColumn(name="user_id"), 
	inverseJoinColumns= @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToOne
	@Where(clause = "is_deleted" + AppConstant.FLAG_NOT_DELETED)
	@JoinColumn(name = "file_id", referencedColumnName="id")
	private File file;
	
	public UserEntity() {}
	  
	public UserEntity(String nip, String name, String userName, String email, String password) {
		this.nip = nip;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
