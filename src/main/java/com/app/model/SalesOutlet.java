package com.app.model;

import com.app.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name = "t3_sales_outlet")
public class SalesOutlet extends BaseEntity<String> {

    @JsonIgnore
    @ManyToOne
    @Where(clause = "deleted_at IS NULL")
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @Where(clause = "deleted_at IS NULL")
    @JoinColumn(name = "outlet_id", referencedColumnName = "id", nullable = false)
    private Outlet outlet;
}
