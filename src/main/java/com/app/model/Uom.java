package com.app.model;

import com.app.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Where(clause = "deleted_at IS NULL")
@Table(name = "t1_uom")
public class Uom extends BaseEntity<String> {

    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 16, nullable = false)
    private String code;

    public Uom() {
    }

    public Uom(String name, String code) {
        this.name = name;
        this.code = code;
    }

}
