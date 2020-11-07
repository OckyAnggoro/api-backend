package com.app.model;

import javax.persistence.*;

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
@Where(clause = "deleted_at IS NULL")
@Table(name ="t2_item")
public class Item extends BaseEntity<String> {

    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 16, nullable = false)
    private String code;

    @Column(length = 128)
    private String spesification;

    @OneToOne
    @Where(clause = "deleted_at IS NULL")
    @JoinColumn(name = "uom_id", referencedColumnName="id")
    private Uom uom;

    public Item(String name, String code, String spesification, Uom uom) {
        this.name = name;
        this.code = code;
        this.spesification = spesification;
        this.uom = uom;
    }

    public Item() {

    }

}
