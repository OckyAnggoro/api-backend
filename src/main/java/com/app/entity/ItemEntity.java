package com.app.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Where;

import com.app.AppConstant;
import com.app.base.BaseEntity;
import com.app.model.Uom;

@SuppressWarnings("serial")
@MappedSuperclass
public class ItemEntity extends BaseEntity{

	@Column(length = 64, nullable = false)
	private String name;
	
	@Column(length = 16, nullable = false)
	private String code;
	
	@Column(length = 128)
	private String spesification;
	
	@OneToOne
	@Where(clause = "is_deleted" + AppConstant.FLAG_NOT_DELETED)
	@JoinColumn(name = "uom_id", referencedColumnName="id")
	private Uom uom;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public String getSpesification() {
		return spesification;
	}

	public void setSpesification(String spesification) {
		this.spesification = spesification;
	}

}
