package com.app.model;

import javax.persistence.*;

import com.app.AppConstant;
import com.app.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name = "t2_user")
public class User extends BaseEntity<String> {

	@Column(length = 128, nullable = false)
	private String name;

	@Column(length = 64, nullable = false)
	private String userName;

	@Column(length = 64, nullable = false)
	private String email;

	@Column(length = 64, nullable = false)
	private String password;

	@OneToMany(mappedBy = "user")
	@Where(clause = "deleted_at IS NULL")
	private List<UserRole> userRoles;

	@ManyToOne
	@Where(clause = "deleted_at IS NULL")
	@JoinColumn(name = "file_id", referencedColumnName="id")
	private File file;

	@OneToMany(mappedBy = "user")
	@Where(clause = "deleted_at IS NULL")
	private List<SalesOutlet> salesOutlets;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String nip, String name, String userName, String email, String password, List<UserRole> userRoles, File file) {
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.userRoles = userRoles;
		this.file = file;
	}

	public User(String name, String userName, String email, String password) {
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

}
