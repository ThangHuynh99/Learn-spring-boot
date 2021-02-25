package com.laptrinhjavaweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuppressWarnings("unused")
@MappedSuperclass //dinh nghia BaseEntity la parent entity
@EntityListeners(AuditingEntityListener.class) //config 
public class BaseEntity {
	@Id //notnull va primary 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // set autoincrement
	private Long id;
	
	@Column (name = "createddate")
	@CreatedDate
	private Date createdDate;
	
	@Column (name = "modifieddate")
	@LastModifiedDate
	private Date modifiedDate;
	
	@Column (name = "createdby")
	@CreatedBy
	private String createdBy;
	
	@Column (name = "modifiedby")
	@LastModifiedBy
	private String modifiedBy;

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public Long getId() {
		return id;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
