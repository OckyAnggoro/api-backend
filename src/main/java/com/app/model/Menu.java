package com.app.model;

import com.app.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity
@Table(name = "t1_menu")
public class Menu extends BaseEntity<String> {
	
	@Transient
	private List<Menu> childMenuList;

	@Column(length = 32, nullable = false)
	private String name;

	@Column(length = 8, nullable = false)
	private String code;

	@Column(length = 512)
	private String description;

	@Column(length = 32, nullable = false)
	private String path;

	@Column(length = 11)
	private Integer parentId;

	@Column(length = 11)
	private Integer sequence;

	@Column(length = 32)
	private String icon;

	public Menu(List<Menu> childMenuList, String name, String code, String description, String path, Integer parentId, Integer sequence, String icon) {
		this.childMenuList = childMenuList;
		this.name = name;
		this.code = code;
		this.description = description;
		this.path = path;
		this.parentId = parentId;
		this.sequence = sequence;
		this.icon = icon;
	}

}
