package com.mc.gestionformation.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class AbstractEntity {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	// @Version
	protected String version;

	@Column(name = "CREATED_AT")
	// @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate createdAt;

	@Column(name = "MODIFIED_AT")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate modifiedAt;

	public AbstractEntity() {

	}

	public AbstractEntity(Long id) {
		super();
		this.id = id;

	}

	public AbstractEntity(Long id, String version, LocalDate createdAt, LocalDate modifiedAt) {
		super();
		this.id = id;
		this.version = version;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDate modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
