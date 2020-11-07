package com.app.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.AppConstant;
import com.app.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@SuppressWarnings("serial")
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name = "t1_role_menu")
public class RoleMenu extends BaseEntity<String> {

    @ManyToOne
    @Where(clause = "is_deleted" + AppConstant.FLAG_NOT_DELETED)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;

    @ManyToOne
    @Where(clause = "is_deleted" + AppConstant.FLAG_NOT_DELETED)
    @JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false)
    private Menu menu;

    public RoleMenu(Role role, Menu menu) {
        this.role = role;
        this.menu = menu;
    }

}
