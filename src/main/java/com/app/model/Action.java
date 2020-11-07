package com.app.model;

import com.app.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name = "t1_action")
public class Action extends BaseEntity<String> {

    @Column(length = 32, nullable = false)
    private String name;

    @Column(length = 8, nullable = false)
    private String code;

    public Action(String name, String code) {
        this.name = name;
        this.code = code;
    }

}
