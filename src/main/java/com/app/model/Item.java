package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.entity.ItemEntity;

@SuppressWarnings("serial")
@Entity
@Table(name ="t2_item")
public class Item extends ItemEntity {

}
