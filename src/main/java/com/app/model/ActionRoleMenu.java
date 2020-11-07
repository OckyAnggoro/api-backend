package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name = "t3_action_role_menu")
public class ActionRoleMenu extends BaseEntity<String>{

}
