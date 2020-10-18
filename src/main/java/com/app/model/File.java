package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.entity.FileEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "t1_file")
public class File extends FileEntity{

}
