package com.app.model;

import com.app.AppConstant;
import com.app.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("serial")
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name = "t3_user_role")
public class UserRole extends BaseEntity<String> {

    @ManyToOne
    @Where(clause = "deleted_at IS NULL")
    @JoinColumn(name = "role_id", referencedColumnName="id", nullable = false)
    private Role role;

    @JsonIgnore
    @ManyToOne
    @Where(clause = "deleted_at IS NULL")
    @JoinColumn(name = "user_id", referencedColumnName="id", nullable = false)
    private User user;

    @Transient
    private String outletNames;

    public UserRole() {
    }

    public UserRole(Role role, User user) {
        this.role = role;
        this.user = user;
    }

}
