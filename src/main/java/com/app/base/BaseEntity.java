package com.app.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.app.jwtauthentication.security.services.UserCurrent;
import com.app.model.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Setter(AccessLevel.PROTECTED)
@Getter(AccessLevel.PUBLIC)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity<E> implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@Column(name = "deleted_at")
	private Date deletedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;

	@LastModifiedBy
	@Column(name = "updated_by")
	private E updatedBy;

	@CreatedBy
	@Column(name = "created_by", nullable = false, updatable = false)
	private E createdBy;

}
