package com.app.model;

import javax.persistence.Column;
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
@Table(name = "t1_file")
public class File extends BaseEntity<String> {

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 64, nullable = false)
    private String realName;

    @Column(length = 11, nullable = false)
    private Integer size;

    @Column(length = 16, nullable = false)
    private String extension;

}
