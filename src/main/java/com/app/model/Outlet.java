package com.app.model;

import com.app.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Where(clause = "deleted_at IS NULL")
@Table(name = "t2_outlet")
public class Outlet extends BaseEntity<String> {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String latitude;
    @Column(nullable = false)
    private String longitude;
    private String description;
    private String iconUrl;

}
